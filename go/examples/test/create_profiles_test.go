package test

import (
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
	"testing"
	"os"
)

func TestCreateProfiles(t *testing.T) {
	aviClient, err := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword("fr3sca$%^"),
		session.SetTenant("admin"),
		session.SetVersion("17.2.8"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		t.Fail()
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)

	// Create application persistence in avinetworks tenant
	profileobj := models.ApplicationPersistenceProfile{}
	profileobj.IsFederated = false
	profileobj.PersistenceType = "PERSISTENCE_TYPE_CLIENT_IP_ADDRESS"
	profileobj.Name = "Test-Persistece-Profile"
	profileobj.TenantRef = "/api/tenant?name=admin"
	ipobj := models.IPPersistenceProfile{IPPersistentTimeout: 5}
	profileobj.IPPersistenceProfile = &ipobj
	npobj, err := aviClient.ApplicationPersistenceProfile.Create(&profileobj)
	if err != nil {
		fmt.Println("\n Application persistence profile creation failed: ", err)
		t.Fail()
	}
	fmt.Println("\n Application persistence profile ", npobj)

	// Create ssl profile in avinetworks tenant
	sslobj := models.SSLProfile{}
	sslobj.Name= "Test-Ssl-Profile"
	sslobj.TenantRef= "/api/tenant?name=admin"
	sslobj.EnableSslSessionReuse = true
	sslobj.SslSessionTimeout = 86400
	sslobj.PreferClientCipherOrdering = false
	sslobj.SendCloseNotify = true
	sslobj.AcceptedCiphers = "ECDHE-ECDSA-AES128-GCM-SHA256:ECDHE-ECDSA-AES128-SHA:ECDHE-ECDSA-AES256-SHA:ECDHE-ECDSA-AES256-GCM-SHA384:ECDHE-ECDSA-AES128-SHA256:ECDHE-ECDSA-AES256-SHA384:AES128-GCM-SHA256:AES256-GCM-SHA384:AES128-SHA256:AES256-SHA256:AES128-SHA:AES256-SHA:DES-CBC3-SHA"
	vobj := models.SSLVersion{Type: "SSL_VERSION_TLS1"}
	sslobj.AcceptedVersions = append(sslobj.AcceptedVersions, &vobj)

	profobj, err := aviClient.SSLProfile.Create(&sslobj)
	if err != nil {
		fmt.Println("\n Ssl profile creation failed: ", err)
		t.Fail()
	} else {
		fmt.Println("Ssl profile ", profobj)
	}

}