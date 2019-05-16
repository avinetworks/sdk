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
	aviClient, err := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword(os.Getenv("password")),
		session.SetTenant("admin"),
		session.SetVersion(os.Getenv("version")),
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
