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

//AviSession maintains a session to the specified Avi Controller
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

	// internal: csrfToken for this session
	csrfToken string

	// internal: referer field string to use in requests
	prefix string
}

//NewAviSession initiates a session to AviController and returns it
func NewAviSession(host string, username string, options ...func(*AviSession) error) (*AviSession, error) {
	if flag.Parsed() == false {
		flag.Parse()
	}
	avisess := &AviSession{
		host:     host,
		username: username,
	}
	avisess.sessionid = ""
	avisess.csrfToken = ""
	avisess.prefix = "https://" + avisess.host + "/"
	avisess.tenant = ""
	avisess.insecure = false

	for _, option := range options {
		err := option(avisess)
		if err != nil {
			return avisess, err
		}
	}
	err := avisess.initiateSession()
	return avisess, err
}

func (avisess *AviSession) initiateSession() error {
	if avisess.insecure == true {
		glog.Warning("Strict certificate verification is *DISABLED*")
	}

	// initiate http session here
	// first set the csrf token
	var res interface{}
	rerror := avisess.Get("", res)

	// now login to get session_id, csrfToken
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

// SetPassword - Use this for NewAviSession option argument for setting password
func SetPassword(password string) func(*AviSession) error {
	return func(sess *AviSession) error {
		return sess.setPassword(password)
	}
}

func (avisess *AviSession) setPassword(password string) error {
	avisess.password = password
	return nil
}

// SetTenant - Use this for NewAviSession option argument for setting tenant
func SetTenant(tenant string) func(*AviSession) error {
	return func(sess *AviSession) error {
		return sess.setTenant(tenant)
	}
}

func (avisess *AviSession) setTenant(tenant string) error {
	avisess.tenant = tenant
	return nil
}

// SetInsecure - Use this for NewAviSession option argument for allowing insecure connection to AviController
func SetInsecure(avi *AviSession) error {
	avi.insecure = true
	return nil
}

//
// Helper routines for REST calls.
//

// restRequest makes a REST request to the Avi Controller's REST API.
// Returns a byte[] if successful
func (avisess *AviSession) restRequest(verb string, uri string, payload interface{}) ([]byte, error) {
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
	if avisess.csrfToken != "" {
		req.Header["X-CSRFToken"] = []string{avisess.csrfToken}
		req.AddCookie(&http.Cookie{Name: "csrftoken", Value: avisess.csrfToken})
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
			avisess.csrfToken = cookie.Value
			glog.Infof("Set the csrf token to %v", avisess.csrfToken)
		}
		if cookie.Name == "sessionid" {
			avisess.sessionid = cookie.Value
		}
	}
	glog.Infof("Response code: %v", resp.StatusCode)

	if resp.StatusCode == 419 {
		// session got reset; try again
		return avisess.restRequest(verb, uri, payload)
	}

	if resp.StatusCode == 401 && len(avisess.sessionid) != 0 && uri != "login" {
		// session expired; initiate session and then retry the request
		avisess.initiateSession()
		return avisess.restRequest(verb, uri, payload)
	}

	if resp.StatusCode < 200 || resp.StatusCode > 299 {
		glog.Errorf("Error: %v", resp)
		bres, berr := ioutil.ReadAll(resp.Body)
		if berr == nil {
			mres, _ := convertAviResponseToMapInterface(bres)
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

	if resp.StatusCode == 404 {
		glog.Errorf("Error: %v", resp)
		mres, merr := ioutil.ReadAll(resp.Body)
		if merr == nil {
			mresult, _ := convertAviResponseToMapInterface(mres)
			glog.Infof("Error resp: %v", mresult)
			emsg := fmt.Sprintf("%v", mresult)
			errorResult.Message = &emsg
		}
		return result, errorResult
	}

	result, err = ioutil.ReadAll(resp.Body)

	if err != nil {
		result = nil
		errorResult := AviError{verb: verb, url: url}
		errmsg := fmt.Sprintf("Response body read failed: %v", err)
		errorResult.Message = &errmsg
	}

	return result, err
}

func convertAviResponseToMapInterface(resbytes []byte) (interface{}, error) {
	var result interface{}
	err := json.Unmarshal(resbytes, &result)
	return result, err
}

// AviCollectionResult for representing the collection type results from Avi
type AviCollectionResult struct {
	Count   int
	Results json.RawMessage
}

func debug(data []byte, err error) {
	if err == nil {
		glog.Infof("%s\n\n", data)
	} else {
		glog.Fatalf("%s\n\n", err)
	}
}

func (avisess *AviSession) restRequestInterfaceResponse(verb string, url string,
	payload interface{}, response interface{}) error {
	res, rerror := avisess.restRequest(verb, url, payload)
	if rerror != nil || res == nil {
		return rerror
	}
	return json.Unmarshal(res, &response)
}

// Get issues a GET request against the avisess REST API.
func (avisess *AviSession) Get(uri string, response interface{}) error {
	return avisess.restRequestInterfaceResponse("GET", uri, nil, response)
}

// Post issues a POST request against the avisess REST API.
func (avisess *AviSession) Post(uri string, payload interface{}, response interface{}) error {
	return avisess.restRequestInterfaceResponse("POST", uri, payload, response)
}

// Put issues a PUT request against the avisess REST API.
func (avisess *AviSession) Put(uri string, payload interface{}, response interface{}) error {
	return avisess.restRequestInterfaceResponse("PUT", uri, payload, response)
}

// Delete issues a DELETE request against the avisess REST API.
func (avisess *AviSession) Delete(uri string) error {
	return avisess.restRequestInterfaceResponse("DELETE", uri, nil, nil)
}

// GetCollectionRaw issues a GET request and returns a AviCollectionResult with unmarshaled (raw) results section.
func (avisess *AviSession) GetCollectionRaw(uri string) (AviCollectionResult, error) {
	var result AviCollectionResult
	res, rerror := avisess.restRequest("GET", uri, nil)
	if rerror != nil || res == nil {
		return result, rerror
	}
	err := json.Unmarshal(res, &result)
	return result, err
}

// GetCollection performs a collection API call and unmarshals the results into objList, which should be an array type
func (avisess *AviSession) GetCollection(uri string, objList interface{}) error {
	result, err := avisess.GetCollectionRaw(uri)
	if err != nil {
		return err
	}
	if result.Count == 0 {
		return nil
	}
	return json.Unmarshal(result.Results, &objList)
}

// GetRaw performs a GET API call and returns raw data
func (avisess *AviSession) GetRaw(uri string) ([]byte, error) {
	return avisess.restRequest("GET", uri, nil)
}

// PostRaw performs a POST API call and returns raw data
func (avisess *AviSession) PostRaw(uri string, payload interface{}) ([]byte, error) {
	return avisess.restRequest("POST", uri, payload)
}

// GetObjectByName performs GET with name filter
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

// Utility functions

// GetControllerVersion gets the version number from the Avi Controller
func (avisess *AviSession) GetControllerVersion() (string, error) {
	var resp interface{}

	err := avisess.Get("/api/initial-data", &resp)
	if err != nil {
		return "", err
	}
	version := resp.(map[string]interface{})["version"].(map[string]interface{})["Version"].(string)
	return version, nil
}
