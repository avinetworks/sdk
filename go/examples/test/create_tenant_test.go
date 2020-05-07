package test

import (
	"fmt"
	"os"
	"testing"

	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

func TestCreateTenant(t *testing.T) {
	aviClient, err := clients.NewAviClient(os.Getenv("AVI_CONTROLLER"), os.Getenv("AVI_USERNAME"),
		session.SetPassword(os.Getenv("AVI_PASSWORD")),
		session.SetTenant(os.Getenv("AVI_TENANT")),
		session.SetVersion(os.Getenv("AVI_VERSION")),
		session.SetInsecure)

	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		t.Fail()
	}

	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)

	// Create tenant avinetworks
	tenantobj := models.Tenant{}
	name := "avinetworks"
	tenantobj.Name = &name
	tobj, err := aviClient.Tenant.Create(&tenantobj)
	if err != nil {
		fmt.Println("\n Tenant creation failed: ", err)
		t.Fail()
	}
	fmt.Println("\n Tenant created successfully.  ", tobj)

}
