package test

import (
	"crypto/tls"
	"fmt"
	"net/http"
	"os"
	"testing"

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
		session.SetPassword("fr3sca$%^"),
		session.SetTenant("admin"),
		session.SetVersion("17.2.8"),
		session.SetTransport(transport))

	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		t.Fail()
	}

	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)
	fmt.Println("Session creation with custom transport object successful")
}
