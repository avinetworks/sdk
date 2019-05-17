package test

import (
	"crypto/tls"
	"net/http"
	"os"
	"testing"
	"time"

	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/session"
)

func TestCustomTransport(t *testing.T) {
	var transport *http.Transport

	// example to attach CACert
	/*
		var caCert []byte
		caCert, _ = ioutil.ReadFile("/path_to_cert.crt")
		caCertPool := x509.NewCertPool()
		caCertPool.AppendCertsFromPEM(caCert)
	*/

	transport = &http.Transport{
		TLSClientConfig: &tls.Config{
			InsecureSkipVerify: true,
			// RootCAs:            caCertPool,
		},
	}

	aviClient, err := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword(os.Getenv("password")),
		session.SetTenant("admin"),
		session.SetVersion(os.Getenv("version")),
		session.SetTransport(transport),
		session.SetTimeout(time.Duration(30*time.Second)))

	if err != nil {
		t.Log("Couldn't create session: ", err)
		t.Fail()
	}

	cv, err := aviClient.AviSession.GetControllerVersion()
	t.Logf("Avi Controller Version: %v:%v\n", cv, err)
	t.Log("Session creation with custom transport object successful")
}
