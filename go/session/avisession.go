package session

import (
	"bytes"
	"crypto/tls"
	"encoding/json"
	"errors"
	"flag"
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"net/http/httputil"
	"reflect"

	"github.com/golang/glog"
)

type aviResult struct {
	// Code should match the HTTP status code.
	Code int `json:"code"`

	// Message should contain a short description of the result of the requested
	// operation.
	Message *string `json:"message"`
}

// AviError represents an error resulting from a request to the Avi Controller
type AviError struct {
	// aviresult holds the standard header (code and message) that is included in
	// responses from Avi.
	aviResult

	// verb is the HTTP verb (GET, POST, PUT, PATCH, or DELETE) that was
	// used in the request that resulted in the error.
	verb string

	// url is the URL that was used in the request that resulted in the error.
	url string

	// httpStatusCode is the HTTP response status code (e.g., 200, 404, etc.).
	httpStatusCode int

	// err contains a descriptive error object for error cases other than HTTP
	// errors (i.e., non-2xx responses), such as socket errors or malformed JSON.
	err error
}

// Error implements the error interface.
func (err AviError) Error() string {
	var msg string

	if err.err != nil {
		msg = fmt.Sprintf("error: %v", err.err)
	} else if err.Message != nil {
		msg = fmt.Sprintf("HTTP code: %d; error from Avi: %s",
			err.httpStatusCode, *err.Message)
	} else {
		msg = fmt.Sprintf("HTTP code: %d.", err.httpStatusCode)
	}

	return fmt.Sprintf("Encountered an error on %s request to URL %s: %s",
		err.verb, err.url, msg)
}

func NewAviError(verb string, url string, status_code int) AviError {
	return AviError{verb: verb, url: url, httpStatusCode: status_code}
}

type AviSession struct {
	// host specifies the hostname or IP address of the Avi Controller
	host string

	// username specifies the username with which we should authenticate with the
	// Avi Controller.
	username string

	// password specifies the password with which we should authenticate with the
	// Avi Controller.
	password string

	// insecure specifies whether we should perform strict certificate validation
	// for connections to the Avi Controller.
	insecure bool

	// optional tenant string to use for API request
	tenant string

	// internal: session id for this session
	sessionid string

	// internal: csrf_token for this session
	csrf_token string

	// internal: referer field string to use in requests
	prefix string
}

func NewAviSession(host string, username string, options ...func(*AviSession) error) (*AviSession, error) {
	flag.Parse()
	avisess := &AviSession{
		host:     host,
		username: username,
	}
	avisess.sessionid = ""
	avisess.csrf_token = ""
	avisess.prefix = "https://" + avisess.host + "/"
	avisess.tenant = ""
	avisess.insecure = false

	for _, option := range options {
		err := option(avisess)
		if err != nil {
			return avisess, err
		}
	}
	err := avisess.InitiateSession()
	return avisess, err
}

func (avisess *AviSession) InitiateSession() error {
	if avisess.insecure == true {
		glog.Warning("Strict certificate verification is *DISABLED*")
	}

	// initiate http session here
	// first set the csrf token
	var res interface{}
	rerror := avisess.Get("", res)

	// now login to get session_id, csrf_token
	cred := make(map[string]string)
	cred["username"] = avisess.username
	cred["password"] = avisess.password
	rerror = avisess.Post("login", cred, res)

	if rerror != nil {
		return rerror
	}

	glog.Infof("response: %v", res)
	if res != nil && reflect.TypeOf(res).Kind() != reflect.String {
		glog.Infof("results: %v error %v", res.(map[string]interface{}), rerror)
	}

	return nil
}

func SetPassword(password string) func(*AviSession) error {
	return func(sess *AviSession) error {
		return sess.set_password(password)
	}
}

func (avisess *AviSession) set_password(password string) error {
	avisess.password = password
	return nil
}

func SetTenant(tenant string) func(*AviSession) error {
	return func(sess *AviSession) error {
		return sess.set_tenant(tenant)
	}
}

func (avisess *AviSession) set_tenant(tenant string) error {
	avisess.tenant = tenant
	return nil
}

func SetInsecure(avi *AviSession) error {
	avi.insecure = true
	return nil
}

//
// Helper routines for REST calls.
//

// rest_request makes a REST request to the Avi Controller's REST API.
// Returns a byte[] if successful
func (avisess *AviSession) rest_request(verb string, uri string, payload interface{}) ([]byte, error) {
	var result []byte
	url := avisess.prefix + uri

	tr := &http.Transport{
		TLSClientConfig: &tls.Config{InsecureSkipVerify: avisess.insecure},
	}

	errorResult := AviError{verb: verb, url: url}

	var payloadIO io.Reader
	if payload != nil {
		jsonStr, err := json.Marshal(payload)
		if err != nil {
			return result, AviError{verb: verb, url: url, err: err}
		}
		payloadIO = bytes.NewBuffer(jsonStr)
	}

	req, err := http.NewRequest(verb, url, payloadIO)
	if err != nil {
		errorResult.err = fmt.Errorf("http.NewRequest failed: %v", err)
		return result, errorResult
	}

	req.Header.Set("Content-Type", "application/json")
	req.Header.Set("Accept", "application/json")
	req.Header.Set("X-Avi-Version", "17.1.2")
	if avisess.csrf_token != "" {
		req.Header["X-CSRFToken"] = []string{avisess.csrf_token}
		req.AddCookie(&http.Cookie{Name: "csrftoken", Value: avisess.csrf_token})
	}
	if avisess.prefix != "" {
		req.Header.Set("Referer", avisess.prefix)
	}
	if avisess.tenant != "" {
		req.Header.Set("X-Avi-Tenant", avisess.tenant)
	}
	if avisess.sessionid != "" {
		req.AddCookie(&http.Cookie{Name: "sessionid", Value: avisess.sessionid})
	}

	// glog.Infof("Request headers: %v", req.Header)
	dump, err := httputil.DumpRequestOut(req, true)
	debug(dump, err)

	client := &http.Client{Transport: tr}

	resp, err := client.Do(req)
	if err != nil {
		errorResult.err = fmt.Errorf("client.Do failed: %v", err)
		return result, errorResult
	}

	defer resp.Body.Close()

	errorResult.httpStatusCode = resp.StatusCode

	// collect cookies from the resp
	for _, cookie := range resp.Cookies() {
		glog.Infof("cookie: %v", cookie)
		if cookie.Name == "csrftoken" {
			avisess.csrf_token = cookie.Value
			glog.Infof("Set the csrf token to %v", avisess.csrf_token)
		}
		if cookie.Name == "sessionid" {
			avisess.sessionid = cookie.Value
		}
	}
	glog.Infof("Response code: %v", resp.StatusCode)

	if resp.StatusCode == 419 {
		// session got reset; try again
		return avisess.rest_request(verb, uri, payload)
	}

	if resp.StatusCode == 401 && len(avisess.sessionid) != 0 && uri != "login" {
		// session expired; initiate session and then retry the request
		avisess.InitiateSession()
		return avisess.rest_request(verb, uri, payload)
	}

	if resp.StatusCode < 200 || resp.StatusCode > 299 {
		glog.Errorf("Error: %v", resp)
		bres, berr := ioutil.ReadAll(resp.Body)
		if berr == nil {
			mres, _ := ConvertAviResponseToMapInterface(bres)
			glog.Infof("Error resp: %v", mres)
			emsg := fmt.Sprintf("%v", mres)
			errorResult.Message = &emsg
		}
		return result, errorResult
	}

	if resp.StatusCode == 204 {
		// no content in the response
		return result, nil
	}

	result, err = ioutil.ReadAll(resp.Body)
	return result, err
}

func ConvertAviResponseToMapInterface(resbytes []byte) (interface{}, error) {
	var result interface{}
	err := json.Unmarshal(resbytes, &result)
	return result, err
}

type AviCollectionResult struct {
	Count   int
	Results json.RawMessage
}

func ConvertBytesToSpecificInterface(resbytes []byte, result interface{}) error {
	err := json.Unmarshal(resbytes, &result)
	return err
}

func debug(data []byte, err error) {
	if err == nil {
		glog.Infof("%s\n\n", data)
	} else {
		glog.Fatalf("%s\n\n", err)
	}
}

func (avisess *AviSession) rest_request_interface_response(verb string, url string,
	payload interface{}, response interface{}) error {
	res, rerror := avisess.rest_request(verb, url, payload)
	if rerror != nil || res == nil {
		return rerror
	}
	return json.Unmarshal(res, &response)
}

// get issues a GET request against the avisess REST API.
func (avisess *AviSession) Get(uri string, response interface{}) error {
	return avisess.rest_request_interface_response("GET", uri, nil, response)
}

// post issues a POST request against the avisess REST API.
func (avisess *AviSession) Post(uri string, payload interface{}, response interface{}) error {
	return avisess.rest_request_interface_response("POST", uri, payload, response)
}

// put issues a PUT request against the avisess REST API.
func (avisess *AviSession) Put(uri string, payload interface{}, response interface{}) error {
	return avisess.rest_request_interface_response("PUT", uri, payload, response)
}

// delete issues a DELETE request against the avisess REST API.
func (avisess *AviSession) Delete(uri string) error {
	return avisess.rest_request_interface_response("DELETE", uri, nil, nil)
}

// get issues a GET request against the avisess REST API.
func (avisess *AviSession) GetCollectionRaw(uri string) (AviCollectionResult, error) {
	var result AviCollectionResult
	res, rerror := avisess.rest_request("GET", uri, nil)
	if rerror != nil || res == nil {
		return result, rerror
	}
	err := json.Unmarshal(res, &result)
	return result, err
}

func (avisess *AviSession) GetCollection(uri string, obj_list interface{}) error {
	result, err := avisess.GetCollectionRaw(uri)
	if err != nil {
		return err
	}
	if result.Count == 0 {
		return nil
	}
	return json.Unmarshal(result.Results, &obj_list)
}

func (avisess *AviSession) GetRaw(uri string) ([]byte, error) {
	return avisess.rest_request("GET", uri, nil)
}

func (avisess *AviSession) PostRaw(uri string, payload interface{}) ([]byte, error) {
	return avisess.rest_request("POST", uri, payload)
}

func (avisess *AviSession) GetObjectByName(obj string, name string, result interface{}) error {
	uri := "api/" + obj + "?name=" + name
	res, err := avisess.GetCollectionRaw(uri)
	if err != nil {
		return err
	}
	if res.Count == 0 {
		return errors.New("No object of type " + obj + " with name " + name + "is found")
	} else if res.Count > 1 {
		return errors.New("More than one object of type " + obj + " with name " + name + "is found")
	}
	elems := make([]json.RawMessage, 1)
	err = json.Unmarshal(res.Results, &elems)
	if err != nil {
		return err
	}
	return json.Unmarshal(elems[0], &result)
}
