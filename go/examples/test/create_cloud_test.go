package test

import (
	"fmt"
	"os"
	"testing"

	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

func TestCreateCloud(t *testing.T) {
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

	cloudobj := models.Cloud{}
	name := "Test-vcenter-cloud"
	cloudobj.Name = &name
	vtype := "CLOUD_NONE"
	cloudobj.Vtype = &vtype
	evsr := false
	cloudobj.EnableVipStaticRoutes = &evsr
	de := false
	cloudobj.DhcpEnabled = &de
	lt := "LIC_CORES"
	cloudobj.LicenseType = &lt
	ltier := "ENTERPRISE_18"
	cloudobj.LicenseTier = &ltier
	am := false
	cloudobj.ApicMode = &am
	mtu := (int32)(1300)
	cloudobj.Mtu = &mtu

	tobj, err := aviClient.Cloud.Create(&cloudobj)
	if err != nil {
		fmt.Printf("[ERROR]: \n %s", err)
		t.Fail()
	}
	fmt.Println("\n Cloud created successfully. ", tobj)
}
