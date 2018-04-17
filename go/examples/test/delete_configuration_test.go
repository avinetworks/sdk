package test

import (
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/session"
	"testing"
)

func TestDeleteConfigurations(t *testing.T) {
	aviClient, err := clients.NewAviClient("localhost:8080//", "admin",
		session.SetPassword("avi123"),
		session.SetTenant("avinetworks"),
		session.SetVersion("17.2.8"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		t.Fail()
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)

	// Delete Virtualservice
	vsres := aviClient.VirtualService.DeleteByName("Test-vs")
	fmt.Printf("\n Virtualservice deleted successfully : %+v", vsres)

	// Delete healthmonitor
	res := aviClient.HealthMonitor.DeleteByName("Test-Healthmonitor")
	fmt.Printf("\n Healthmonitor deleted successfully: %+v", res)

	// Create session for webapp tenant
	aviClient1, err := clients.NewAviClient("localhost:8080//", "admin",
		session.SetPassword("avi123"),
		session.SetTenant("webapp"),
		session.SetVersion("17.2.8"),
		session.SetInsecure)

	// Delete persistence profile
	appProfRes := aviClient1.ApplicationPersistenceProfile.DeleteByName("Test-Persistece-Profile")
	fmt.Printf("\n Application persistence profile deleted successfully: %+v", appProfRes)

	// Delete healthmonitor
	sslProfRes := aviClient1.SSLProfile.DeleteByName("Test-Ssl-Profile")
	fmt.Printf("\n Ssl profile deleted successfully: %+v", sslProfRes)

}