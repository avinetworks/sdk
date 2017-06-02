package session

import (
	"bytes"
	"crypto/tls"
	"encoding/json"
	"fmt"
	"io"
	"io/ioutil"
	"log"
	"net/http"
	"net/http/httputil"
	"reflect"
	"errors"

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
	Tenant string

	// internal: session id for this session
	sessionid string

	// internal: csrf_token for this session
	csrf_token string

	// internal: referer field string to use in requests
	prefix string
}

func NewAviSession(host string, username string, password string, insecure bool) *AviSession {
	avisess := &AviSession{
		host:     host,
		username: username,
		password: password,
		insecure: insecure,
	}
	avisess.sessionid = ""
	avisess.csrf_token = ""
	avisess.prefix = "https://" + avisess.host + "/"
	avisess.Tenant = ""
	return avisess
}

func (avisession *AviSession) InitiateSession() error {
	if avisession.insecure == true {
		glog.Warning("Strict certificate verification is *DISABLED*")
	}

	// initiate http session here
	// first set the csrf token
	res, rerror := avisession.Get("")

	// now login to get session_id
	cred := make(map[string]string)
	cred["username"] = avisession.username
	cred["password"] = avisession.password
	res, rerror = avisession.Post("login", cred)
	// now session id is set too

	log.Println("response: ", res)
	if res != nil && reflect.TypeOf(res).Kind() != reflect.String {
		println("results: ", res.(map[string]interface{}), " error: ", rerror)
	}

	return nil
}

//
// Helper routines for REST calls.
//

// rest_request makes a REST request to the Avi Controller's REST API.
// Returns a byte[] if successful
func (avi *AviSession) rest_request(verb string, uri string, payload interface{}) ([]byte, error) {
	var result []byte
	url := avi.prefix + uri

	tr := &http.Transport{
		TLSClientConfig: &tls.Config{InsecureSkipVerify: avi.insecure},
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
	if avi.csrf_token != "" {
		req.Header["X-CSRFToken"] = []string{avi.csrf_token}
		req.AddCookie(&http.Cookie{Name: "csrftoken", Value: avi.csrf_token})
	}
	if avi.prefix != "" {
		req.Header.Set("Referer", avi.prefix)
	}
	if avi.Tenant != "" {
		req.Header.Set("X-Avi-Tenant", avi.Tenant)
	}
	if avi.sessionid != "" {
		req.AddCookie(&http.Cookie{Name: "sessionid", Value: avi.sessionid})
	}

	dump, err := httputil.DumpRequestOut(req, true)
	log.Println("Request headers: ", req.Header)
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
		log.Println("cookie: ", cookie)
		if cookie.Name == "csrftoken" {
			avi.csrf_token = cookie.Value
			log.Println("Set the csrf token to ", avi.csrf_token)
		}
		if cookie.Name == "sessionid" {
			avi.sessionid = cookie.Value
		}
	}
	log.Println("Response code: ", resp.StatusCode)

	if resp.StatusCode == 419 {
		// session got reset; try again
		return avi.rest_request(verb, uri, payload)
	}

	if resp.StatusCode == 401 && len(avi.sessionid) != 0 && uri != "login" {
		// session expired; initiate session and then retry the request
		avi.InitiateSession()
		return avi.rest_request(verb, uri, payload)
	}

	if resp.StatusCode < 200 || resp.StatusCode > 299 {
		log.Println("Error: ", resp)
		bres, berr := ioutil.ReadAll(resp.Body)
		if berr == nil {
		    mres, _ := ConvertAviResponseToMapInterface(bres)
		    log.Println("Error resp: ", mres)
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
	Results []json.RawMessage
}

func ConvertBytesToSpecificInterface(resbytes []byte, result interface{}) error {
	err := json.Unmarshal(resbytes, result)
	return err
}

func debug(data []byte, err error) {
	if err == nil {
		fmt.Printf("%s\n\n", data)
	} else {
		log.Fatalf("%s\n\n", err)
	}
}

func (avi *AviSession) rest_request_interface_response(verb string, url string,
	payload interface{}) (interface{}, error) {
	res, rerror := avi.rest_request(verb, url, payload)
	if rerror != nil || res == nil {
		return res, rerror
	}
	return ConvertAviResponseToMapInterface(res)
}

// get issues a GET request against the avi REST API.
func (avi *AviSession) Get(uri string) (interface{}, error) {
	return avi.rest_request_interface_response("GET", uri, nil)
}

// post issues a POST request against the avi REST API.
func (avi *AviSession) Post(uri string, payload interface{}) (interface{}, error) {
	return avi.rest_request_interface_response("POST", uri, payload)
}

// put issues a PUT request against the avi REST API.
func (avi *AviSession) Put(uri string, payload interface{}) (interface{}, error) {
	return avi.rest_request_interface_response("PUT", uri, payload)
}

// delete issues a DELETE request against the avi REST API.
func (avi *AviSession) Delete(uri string) (interface{}, error) {
	return avi.rest_request_interface_response("DELETE", uri, nil)
}

// get issues a GET request against the avi REST API.
func (avi *AviSession) GetCollection(uri string) (AviCollectionResult, error) {
	var result AviCollectionResult
	res, rerror := avi.rest_request("GET", uri, nil)
	if rerror != nil || res == nil {
		return result, rerror
	}
	err := json.Unmarshal(res, &result)
	return result, err
}

func (avi *AviSession) GetRaw(uri string) ([]byte, error) {
	return avi.rest_request("GET", uri, nil)
}

func (avi *AviSession) PostRaw(uri string, payload interface{}) ([]byte, error) {
	return avi.rest_request("POST", uri, payload)
}

func (avi *AviSession) GetObjectByName(obj string, name string, result interface{}) error {
	uri := "api/" + obj + "?name=" + name
	res_col, err := avi.GetCollection(uri)
	if err != nil {
		return err
	}
	if res_col.Count == 0 {
		return errors.New("No object of type " + obj + " with name " + name + "is found")
	} else if res_col.Count > 1 {
		return errors.New("More than one object of type " + obj + " with name " + name + "is found")
	}

	return json.Unmarshal(res_col.Results[0], result)
}
