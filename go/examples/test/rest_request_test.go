package test

import (
	"encoding/json"
	"os"
	"testing"

	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/session"
)

func TestRestRequest(t *testing.T) {
	var err error
	aviClient, err := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword(os.Getenv("password")),
		session.SetTenant("admin"),
		session.SetVersion(os.Getenv("version")))
	if err != nil {
		t.Log("Couldn't create session: ", err)
		t.Fail()
	}

	var payload interface{}
	payloadJSON := `{"name": "Test-vcenter-cloud2"}`
	if err = json.Unmarshal([]byte(payloadJSON), &payload); err != nil {
		t.Logf("Unable to decode payload: %v", err)
	}

	// check 404 for wrong url
	url := "api/cloudhablas"
	resp, err := aviClient.AviSession.RestRequest("POST", url, payload, "admin", nil)
	aviError, _ := err.(session.AviError)
	if resp.StatusCode != 404 && resp.StatusCode == aviError.HttpStatusCode {
		t.Logf("Expecting HTTP 404 but got status: %d", resp.StatusCode)
		t.Fail()
	}

	// check POST for correct URL
	url = "api/cloud"
	resp, err = aviClient.AviSession.RestRequest("POST", url, payload, "admin", nil)
	if resp.StatusCode != 200 {
		t.Logf("Expecting HTTP 200 but got status: %d", resp.StatusCode)
		t.Fail()
	}

	// check GET
	resp, err = aviClient.AviSession.RestRequest("GET", url, nil, "admin", nil)
	if resp.StatusCode != 200 {
		t.Logf("Expecting HTTP 200 but got status: %d", resp.StatusCode)
		t.Fail()
	}
	return
}
