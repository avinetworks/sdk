package main

import (
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
	"os"
)


func main() {
	aviClient, err := clients.NewAviClient("10.10.28.91", "admin",
		session.SetPassword("avi123"),
		session.SetTenant("admin"),
	    	session.SetVersion("17.2.8"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		os.Exit(1)
	}

	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)

	// Create tenant avinetworks
	tenantobj := models.Tenant{}
	tenantobj.Name = "avinetworks"
	tobj, err := aviClient.Tenant.Create(&tenantobj)
	if err != nil {
	    fmt.Println("Tenant creation failed: ", err)
		os.Exit(1)
	}
	fmt.Println("Tenant created successfully.  ",tobj)

	// Create tenant webapp
	tenantobj.Name = "webapp"
	tenobj, err := aviClient.Tenant.Create(&tenantobj)
	if err != nil {
	    fmt.Println("Tenant creation failed: ", err)
		os.Exit(1)
	}
	fmt.Println("Tenant created successfully. ",tenobj)
}