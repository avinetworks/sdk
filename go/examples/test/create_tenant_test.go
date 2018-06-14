package test

import (
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
	"testing"
	"os"
)

func TestCreateTenant(t *testing.T) {
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

	// Create tenant avinetworks
	tenantobj := models.Tenant{}
	tenantobj.Name = "avinetworks"
	tobj, err := aviClient.Tenant.Create(&tenantobj)
	if err != nil {
	    fmt.Println("\n Tenant creation failed: ", err)
		t.Fail()
	}
	fmt.Println("\n Tenant created successfully.  ",tobj)

}