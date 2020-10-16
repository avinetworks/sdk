package test

import (
	"crypto/tls"
	"crypto/x509"
	"io/ioutil"
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
	var caCert []byte
	caCert, _ = ioutil.ReadFile("example.crt")
	caCertPool := x509.NewCertPool()
	caCertPool.AppendCertsFromPEM(caCert)

	transport = &http.Transport{
		TLSClientConfig: &tls.Config{
			//Using self signed certificate
			InsecureSkipVerify: true,
			RootCAs:            caCertPool,
		},
	}

	aviClient, err := clients.NewAviClient(os.Getenv("AVI_CONTROLLER"), os.Getenv("AVI_USERNAME"),
		session.SetPassword(os.Getenv("AVI_PASSWORD")),
		session.SetTenant(os.Getenv("AVI_TENANT")),
		session.SetVersion(os.Getenv("AVI_VERSION")),
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
