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
		session.SetVersion("17.2.8"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		return
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)

    cloudobj := models.Cloud{}
    cloudobj.Name = "Test-vcenter-cloud"
    cloudobj.Vtype = "CLOUD_NONE"
    cloudobj.EnableVipStaticRoutes = false
    cloudobj.DhcpEnabled = false
    cloudobj.StateBasedDNSRegistration = true
    cloudobj.LicenseType = "LIC_CORES"
    cloudobj.LicenseTier = "ENTERPRISE_18"
    cloudobj.ApicMode = false
    cloudobj.Mtu = 1300

    tobj, err := aviClient.Cloud.Create(&cloudobj)
	if err != nil {
	    fmt.Println("Cloud creation failed: ", err)
		return
	}
	fmt.Println("Finish ",tobj)
}