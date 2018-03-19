package main

import (
	//"flag"
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)


func main() {
    aviClient, err := clients.NewAviClient("10.10.28.98", "admin",
		session.SetPassword("avi123$%"),
		session.SetTenant("admin"),
	    	session.SetVersion("17.2.7"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		return
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)
	tenantobj := models.Tenant{}
	tenantobj.Name = "avinetworks"
	tobj, err := aviClient.Tenant.Create(&tenantobj)
	if err != nil {
	    fmt.Println("Tenant creation failed: ", err)
		return
	}
	fmt.Println("Finish ",tobj)

	tenantobj.Name = "testtenant"
	tenobj, err := aviClient.Tenant.Create(&tenantobj)
	if err != nil {
	    fmt.Println("Tenant creation failed: ", err)
		return
	}
	fmt.Println("Finish ",tenobj)
}