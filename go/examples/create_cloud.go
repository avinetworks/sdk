package main

import (

	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
	"fmt"
)


func main() {

	aviClient, err := clients.NewAviClient("10.10.28.91", "admin",
		session.SetPassword("avi123"),
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
	cloudobj.LicenseType = "LIC_CORES"
	cloudobj.LicenseTier = "ENTERPRISE_18"
	cloudobj.ApicMode = false
	cloudobj.Mtu = 1300

	tobj, err := aviClient.Cloud.Create(&cloudobj)

	var obj interface{}
	err = aviClient.AviSession.GetObjectByName("tenant", "webapp", &obj)
	if err == nil {
		fmt.Printf("### VS obj: %v\n %s", obj)
		uuid := obj.(map[string]interface{})["uuid"]
		fmt.Printf("### VS uuid: %v\n %s", uuid)
	}
	fmt.Println("Cloud created successfully. ",tobj)
}