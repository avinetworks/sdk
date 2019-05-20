package test

import (
	"fmt"
	"os"
	"testing"

	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/session"
)

func TestDeleteConfigurations(t *testing.T) {
	aviClient, err := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword(os.Getenv("password")),
		session.SetTenant("avinetworks"),
		session.SetVersion(os.Getenv("version")),
		session.SetInsecure)

	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		t.Fail()
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)

	// Delete Virtualservice
	vsRes := aviClient.VirtualService.DeleteByName("Test-vs")
	fmt.Printf("\n Virtualservice deleted successfully : %+v", vsRes)

	// Delete Pool
	poolRes := aviClient.Pool.DeleteByName("Test-pool")
	fmt.Printf("Pool Deleted Successfully, : %+v", poolRes)
	// Create session for webapp tenant
	aviClient1, err := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword(os.Getenv("password")),
		session.SetTenant("admin"),
		session.SetVersion(os.Getenv("version")),
		session.SetInsecure)

	// Delete persistence profile
	appProfRes := aviClient1.ApplicationPersistenceProfile.DeleteByName("Test-Persistece-Profile")
	fmt.Printf("\n Application persistence profile deleted successfully: %+v", appProfRes)

	// Delete healthmonitor
	sslProfRes := aviClient1.SSLProfile.DeleteByName("Test-Ssl-Profile")
	fmt.Printf("\n Ssl profile deleted successfully: %+v", sslProfRes)

	// Delete healthmonitor
	res := aviClient1.HealthMonitor.DeleteByName("Test-Healthmonitor")
	fmt.Printf("\n Healthmonitor deleted successfully: %+v", res)

	// Delete tenant
	tenantRes := aviClient1.Tenant.DeleteByName("avinetworks")
	fmt.Printf("Tenant avinetworks deleted successfully %+v", tenantRes)

	// Delete cloud
	cloudRes := aviClient1.Cloud.DeleteByName("Test-vcenter-cloud")
	fmt.Printf("\n Cloud deleted successfully : %-v", cloudRes)
}
