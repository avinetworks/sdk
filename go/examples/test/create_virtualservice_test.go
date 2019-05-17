package test

import (
	"fmt"
	"os"
	"testing"

	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

var cuuid string
var uuid string
var profuuid string

func TestCreateVirtualservice(t *testing.T) {
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

	aviClient1, err := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword(os.Getenv("password")),
		session.SetTenant("admin"),
		session.SetVersion(os.Getenv("version")),
		session.SetInsecure)

	if err != nil {
		fmt.Println("\n Couldn't create session: ", err)
		t.Fail()
	}
	cv1, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("\n Avi Controller Version: %v:%v\n", cv1, err)

	// get healthmonitor object.
	var obj interface{}
	err = aviClient1.AviSession.GetObjectByName("healthmonitor", "Test-Healthmonitor", &obj)
	if err != nil {
		fmt.Printf("\n [ERROR] : %s", err)
		t.Fail()
	}

	// Get application persistence profile object.
	var profobj interface{}
	err = aviClient1.AviSession.GetObjectByName("applicationpersistenceprofile", "Test-Persistece-Profile", &profobj)
	if err != nil {
		fmt.Printf("\n [ERROR] : %s", err)
		t.Fail()
	}

	// get cloud uuid
	var cloudobj interface{}
	err = aviClient1.AviSession.GetObjectByName("cloud", "Test-vcenter-cloud", &cloudobj)
	if err != nil {
		fmt.Printf("\n [ERROR] : %s", err)
		t.Fail()
	}

	cuuid = fmt.Sprint("/api/cloud?name=", cloudobj.(map[string]interface{})["name"])
	profuuid = fmt.Sprint("/api/applicationpersistenceprofile?name=", profobj.(map[string]interface{})["name"])
	uuid = fmt.Sprint("/api/healthmonitor?name=", obj.(map[string]interface{})["name"])

	// Use a pool client to create a pool with one server with IP 10.90.20.12, port 80
	pobj := models.Pool{}
	pname := "Test-pool"
	pobj.Name = &pname
	serverobj := models.Server{}
	enabled := true
	serverobj.Enabled = &enabled
	Type := "V4"
	addr := "10.90.20.12"
	serverobj.IP = &models.IPAddr{Type: &Type, Addr: &addr}
	pobj.Servers = append(pobj.Servers, &serverobj)
	tr := "/api/tenant?name=avinetworks"
	pobj.TenantRef = &tr
	pobj.CloudRef = &cuuid
	pobj.ApplicationPersistenceProfileRef = &profuuid
	pobj.HealthMonitorRefs = append(pobj.HealthMonitorRefs, uuid)

	npobj, err := aviClient.Pool.Create(&pobj)
	if err == nil {
		fmt.Println("\n POOL Created sussfully : ", npobj)
	} else {
		fmt.Printf("\n [ERROR] : %s", err)
		t.Fail()
	}

	// Create a virtual service and use the pool created above
	vsobj := models.VirtualService{}
	vsname := "my-test-vs"
	vsobj.Name = &vsname
	Type = "V4"
	addr = "10.10.18.67"
	vipip := models.IPAddr{Type: &Type, Addr: &addr}
	vid := "myvip"
	vsobj.Vip = append(vsobj.Vip, &models.Vip{VipID: &vid, IPAddress: &vipip})
	vsobj.TenantRef = &tr
	vsobj.PoolRef = npobj.UUID
	vsobj.CloudRef = &cuuid
	port := (int32)(80)
	vsobj.Services = append(vsobj.Services, &models.Service{Port: &port})

	nvsobj, err := aviClient.VirtualService.Create(&vsobj)
	if err != nil {
		fmt.Println("\n VS creation failed: ", err)
		t.Fail()
	}
	fmt.Printf("\n VS obj: %v", nvsobj.TenantRef)

	// Update VirtualService
	vservice := models.VirtualService{}
	err = aviClient.AviSession.GetObjectByName("virtualservice", "my-test-vs", &vservice)
	if err == nil {
		vsname := "Test-vs"
		vservice.Name = &vsname
		port := (int32)(443)
		vservice.Services = append(vsobj.Services, &models.Service{Port: &port})
		upObj, err := aviClient.VirtualService.Update(&vservice)
		vsobj.PoolRef = npobj.UUID
		if err != nil {
			fmt.Println("\n Virtualservice Updation failed: ", err)
			t.Fail()
		}
		fmt.Printf("\n Virtualservice obj: %+v", *upObj)
	}
}
