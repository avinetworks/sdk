package test

import (
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/session"
	"testing"
	"github.com/avinetworks/sdk/go/models"
	"os"
)

var cuuid string
var uuid string
var profuuid string

func TestCreateVirtualservice(t *testing.T) {
	aviClient, err := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword("fr3sca$%^"),
		session.SetTenant("avinetworks"),
		session.SetVersion("17.2.8"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		t.Fail()
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)


	aviClient1, err := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword("fr3sca$%^"),
		session.SetTenant("admin"),
		session.SetVersion("17.2.8"),
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
		fmt.Printf("\n [ERROR] : ", err)
		t.Fail()
	}

	// Get application persistence profile object.
	var profobj interface{}
	err = aviClient1.AviSession.GetObjectByName("applicationpersistenceprofile", "Test-Persistece-Profile", &profobj)
	if err != nil {
		fmt.Printf("\n [ERROR] : ", err)
		t.Fail()
	}

	// get cloud uuid
	var cloudobj interface{}
	err = aviClient1.AviSession.GetObjectByName("cloud", "Test-vcenter-cloud", &cloudobj)
	if err != nil {
		fmt.Printf("\n [ERROR] : ", err)
		t.Fail()
	}

	cuuid = fmt.Sprint("/api/cloud?name=",cloudobj.(map[string]interface{})["name"])
	profuuid = fmt.Sprint("/api/applicationpersistenceprofile?name=",profobj.(map[string]interface{})["name"])
	uuid = fmt.Sprint("/api/healthmonitor?name=",obj.(map[string]interface{})["name"])

	// Use a pool client to create a pool with one server with IP 10.90.20.12, port 80
	pobj := models.Pool{}
	pobj.Name = "Test-pool"
	serverobj := models.Server{}
	serverobj.Enabled = true
	serverobj.IP = &models.IPAddr{Type: "V4", Addr: "10.90.20.12"}
	pobj.Servers = append(pobj.Servers, &serverobj)
	pobj.TenantRef = "/api/tenant?name=avinetworks"
	pobj.CloudRef = cuuid
	pobj.ApplicationPersistenceProfileRef = profuuid
	pobj.HealthMonitorRefs = append(pobj.HealthMonitorRefs, uuid)

	npobj, err := aviClient.Pool.Create(&pobj)
	if err == nil {
		fmt.Println("\n POOL Created sussfully : ", npobj)
	} else {
		fmt.Printf("\n [ERROR] : ", err)
		t.Fail()
	}

	// Create a virtual service and use the pool created above
	vsobj := models.VirtualService{}
	vsobj.Name = "my-test-vs"
	vipip := models.IPAddr{Type: "V4", Addr: "10.10.18.67"}
	vsobj.Vip = append(vsobj.Vip, &models.Vip{VipID: "myvip", IPAddress: &vipip})
	vsobj.TenantRef = "/api/tenant?name=avinetworks"
	vsobj.PoolRef = npobj.UUID
	vsobj.CloudRef = cuuid
	vsobj.Services = append(vsobj.Services, &models.Service{Port: 80})

	nvsobj, err := aviClient.VirtualService.Create(&vsobj)
	if err != nil {
		fmt.Println("\n VS creation failed: ", err)
		t.Fail()
	}
	fmt.Printf("\n VS obj: ", nvsobj.TenantRef)

	// Update VirtualService
	vservice:= models.VirtualService{}
	err = aviClient.AviSession.GetObjectByName("virtualservice", "my-test-vs", &vservice)
	if err == nil {
		vservice.Name = "Test-vs"
		vservice.Services = append(vsobj.Services, &models.Service{Port: 443})
		upObj , err := aviClient.VirtualService.Update(&vservice)
		vsobj.PoolRef = npobj.UUID
		if err != nil {
			fmt.Println("\n Virtualservice Updation failed: ", err)
			t.Fail()
		}
		fmt.Printf("\n Virtualservice obj: %+v", *upObj)
	}
}