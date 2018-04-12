package main

import (

	"github.com/avinetworks/sdk/go/clients"
	//"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
	"fmt"
	"os"
)


func main() {

	aviClient, err := clients.NewAviClient("localhost:5003", "admin",
		session.SetPassword("avi123"),
		session.SetTenant("admin"),
		session.SetVersion("17.2.8"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		os.Exit(1)
		return
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)

	//cloudobj := models.Cloud{}
	//cloudobj.Name = "Test-vcenter-cloud"
	//cloudobj.Vtype = "CLOUD_NONE"
	//cloudobj.EnableVipStaticRoutes = false
	//cloudobj.DhcpEnabled = false
	//cloudobj.LicenseType = "LIC_CORES"
	//cloudobj.LicenseTier = "ENTERPRISE_18"
	//cloudobj.ApicMode = false
	//cloudobj.Mtu = 1300
	//
	//tobj, err := aviClient.Cloud.Create(&cloudobj)
	//if err != nil {
	//	fmt.Printf("[ERROR]: %v\n %s", err)
	//	os.Exit(1)
	//	return
	//}
	//fmt.Println("Cloud created successfully. ",tobj)
}