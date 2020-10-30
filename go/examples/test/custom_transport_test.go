package test

import (
	"crypto/tls"
	"crypto/x509"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
	"io/ioutil"
	"net/http"
	"os"
	"testing"
	"time"
)

func TestCustomTransport(t *testing.T) {
	/*
	Test Controller TLS connection with self signed certificates
	Scenario:
	Create controller session using(using default transport setting)
	Create controller ssl key and certificate
	Configure certificate on controller for https connection using systemconfiguration object
	Get the key and certificate
	Configure same key and certificate in transport object for caCertPool and X509KeyPair
	Try to create the new session with TLS(without InsecureSkipVerify=true)
	Teardown(reset controller and delete ssl certs)
	 */
	name := "test-go-sdk-tls-connection"
	var daysUntilExpire int32 = 3650
	selfSigned := true
	commonName := "*"
	organizationUnit := "SDK Automation"
	organization := "Avinetworks"
	locality := "NY"
	state := "CA"
	country := "US"
	subjectAltNames := []string{os.Getenv("AVI_CONTROLLER")}
	sslType := "SSL_CERTIFICATE_TYPE_SYSTEM"
	subject := models.SSLCertificateDescription{
		CommonName:        &commonName,
		Country:           &country,
		Locality:          &locality,
		Organization:      &organization,
		OrganizationUnit:  &organizationUnit,
		State:             &state,
	}
	certificate := models.SSLCertificate{
		Subject: &subject,
		SubjectAltNames: subjectAltNames,
		SelfSigned: &selfSigned,
		DaysUntilExpire: &daysUntilExpire,
	}
	sslWithSan := models.SSLKeyAndCertificate{
		Name: &name,
		Type: &sslType,
		Certificate: &certificate,
	}

	//Create controller session using(using default transport setting)
	aviClient, err := clients.NewAviClient(os.Getenv("AVI_CONTROLLER"), os.Getenv("AVI_USERNAME"),
		session.SetPassword(os.Getenv("AVI_PASSWORD")),
		session.SetTenant(os.Getenv("AVI_TENANT")),
		session.SetVersion(os.Getenv("AVI_VERSION")),
		session.SetTimeout(time.Duration(30*time.Second)))
	if err != nil {
		t.Log("Error while creating session for controller: ", os.Getenv("AVI_CONTROLLER"), "Error: ", err)
		t.Fail()
	}

	//Create controller ssl key and certificate on controller
	sslCertObj, err := aviClient.SSLKeyAndCertificate.Create(&sslWithSan)
	if err != nil {
		t.Log("Failed to create sslkeyandcertificate. Error", err)
		t.Fail()
	}
	sslCertUuid := sslCertObj.UUID

	//Configure certificate created above on controller for https connection using systemconfiguration object
	systemConfigObj, err := aviClient.SystemConfiguration.Get("")
	if err != nil {
		t.Log("Error while getting systemconfiguration. Error: ", err)
		t.Fail()
	}
	systemConfigObj.PortalConfiguration.SslkeyandcertificateRefs = []string{*sslCertUuid}
	sysConfigUuid := ""
	systemConfigObj.UUID = &sysConfigUuid
	systemConfigUpdate, err := aviClient.SystemConfiguration.Update(systemConfigObj)
	if err != nil {
		t.Log("Error while updating systemconfiguration. Error: ", err)
	}

	//Configure same key and certificate in transport object for caCertPool and X509KeyPair
	uri := "api/sslkeyandcertificate/" + *sslCertUuid + "?export_key=true"
	sslObj1 := models.SSLKeyAndCertificate{}
	err = aviClient.AviSession.Get(uri, &sslObj1)
	if err != nil {
		t.Log("Failed to get the ssl certificate. Error: ", err)
		t.Fail()
	}
	sslPrivateKey := []byte(*sslObj1.Key)
	err = ioutil.WriteFile("testTLS.key", sslPrivateKey, 0644)
	if err != nil {
		t.Log("Error while creating the file for key. Error: ", err)
	}
	sslCert := []byte(*sslObj1.Certificate.Certificate)
	err = ioutil.WriteFile("testTLS.crt", sslCert, 0644)
	if err != nil {
		t.Log("Error while creating the file for cert. Error: ", err)
	}

	var transport *http.Transport
	cert, err := tls.LoadX509KeyPair("testTLS.crt", "testTLS.key")
	if err != nil {
		t.Log(err)
		t.Fail()
	}

	// Create a CA certificate pool and add cert.pem to it
	caCert, err := ioutil.ReadFile("testTLS.crt")
	if err != nil {
		t.Log(err)
		t.Fail()
	}
	caCertPool := x509.NewCertPool()
	caCertPool.AppendCertsFromPEM(caCert)

	// Create a HTTPS client and supply the created CA pool and certificate
	transport = &http.Transport{
			TLSClientConfig: &tls.Config{
				RootCAs: caCertPool,
				Certificates: []tls.Certificate{cert},
			},
		}

	//Try to create the new session with TLS(without InsecureSkipVerify=true)
	time.Sleep(30 * time.Second)
	aviClientTLS, err := clients.NewAviClient(os.Getenv("AVI_CONTROLLER"), os.Getenv("AVI_USERNAME"),
		session.SetPassword(os.Getenv("AVI_PASSWORD")),
		session.SetTenant(os.Getenv("AVI_TENANT")),
		session.SetVersion(os.Getenv("AVI_VERSION")),
		session.SetTransport(transport),
		session.SetTimeout(time.Duration(30*time.Second)))
	if err != nil {
		t.Log("Couldn't create session(TLS enabled). Error: ", err)
		t.Fail()
	}

	cv, err := aviClientTLS.AviSession.GetControllerVersion()
	if err != nil {
		t.Log("Failed to get the controller version using TLS enabled session. Error", err)
		t.Fail()
	}
	t.Logf("Avi Controller Version: %v\n", cv)
	t.Log("Session creation with custom transport object successful")

	//Teardown(reset controller and delete ssl certs)
	systemConfigUpdate.PortalConfiguration.SslkeyandcertificateRefs = []string{}
	systemConfigUpdate.UUID = &sysConfigUuid
	_ , err = aviClient.SystemConfiguration.Update(systemConfigUpdate)
	if err != nil {
		t.Log("failed to clean the sslcertificates from systemconfiguration. Error: ", err)
		t.Fail()
	}
	aviClient.SSLKeyAndCertificate.Delete(*sslCertUuid)
	os.Remove("testTLS.crt")
	os.Remove("testTLS.key")
}