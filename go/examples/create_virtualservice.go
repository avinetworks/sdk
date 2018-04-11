package main

import (
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/session"
	"github.com/avinetworks/sdk/go/models"
)

func main() {
	aviClient, err := clients.NewAviClient("10.10.28.91", "admin",
		session.SetPassword("avi123"),
		session.SetTenant("avinetworks"),
		session.SetVersion("17.2.8"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		return
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)


	aviClient1, err := clients.NewAviClient("10.10.28.91", "admin",
		session.SetPassword("avi123"),
		session.SetTenant("webapp"),
		session.SetVersion("17.2.8"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		return
	}
	cv1, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv1, err)

	// get healthmonitor uuid
	var obj interface{}
	var uuid interface{}
	err = aviClient1.AviSession.GetObjectByName("healthmonitor", "Test-Healthmonitor", &obj)
	if err == nil {
		uuid = obj.(map[string]interface{})["uuid"]
		fmt.Printf("\n Healthmonitor uuid: %v\n %s", uuid)
	} else {
		fmt.Printf("\n [ERROR] : ", err)
	}

	var profobj interface{}
	var profuuid interface{}
	err = aviClient1.AviSession.GetObjectByName("applicationpersistenceprofile", "Test-Persistece-Profile", &profobj)
	if err == nil {
		profuuid = profobj.(map[string]interface{})["uuid"]
		fmt.Printf("\n Application persistence profile uuid: %v\n %s", profuuid)
	} else {
		fmt.Printf("\n [ERROR] : ", err)
	}
	fmt.Printf("\n APPLICATION PERSISTENCE PROFILE : ", profuuid)

	// get cloud uuid
	var cloudobj interface{}
	var cuuid interface{}
	err = aviClient1.AviSession.GetObjectByName("cloud", "Test-vcenter-cloud", &cloudobj)
	if err == nil {
		cuuid = cloudobj.(map[string]interface{})["uuid"]
		fmt.Printf("\n Cloud uuid: %v\n %s", cuuid)
	} else {
		fmt.Printf("\n [ERROR] : ", err)
	}

	// Use a pool client to create a pool with one server with IP 10.90.20.12, port 80
	pobj := models.Pool{}
	pobj.Name = "my-test-pool"
	serverobj := models.Server{}
	serverobj.Enabled = true
	serverobj.IP = &models.IPAddr{Type: "V4", Addr: "10.90.20.12"}
	pobj.Servers = append(pobj.Servers, &serverobj)
    	pobj.TenantRef = "/api/tenant?name=avinetworks"
	pobj.CloudRef = cuuid.(string)
	pobj.ApplicationPersistenceProfileRef = profuuid.(string)
	pobj.HealthMonitorRefs = append(pobj.HealthMonitorRefs, uuid.(string))
	npobj, err := aviClient.Pool.Create(&pobj)
	if err == nil {
		fmt.Println("POOL Created sussfully : ", npobj)
	} else {
		fmt.Printf("\n [ERROR] : ", err)
	}

	// Create a virtual service and use the pool created above
	vsobj := models.VirtualService{}
	vsobj.Name = "my-test-vs"
	vipip := models.IPAddr{Type: "V4", Addr: "10.90.20.52"}
	vsobj.Vip = append(vsobj.Vip, &models.Vip{VipID: "myvip", IPAddress: &vipip})
	vsobj.TenantRef = "/api/tenant?name=avinetworks"
	vsobj.PoolRef = npobj.UUID
	vsobj.CloudRef = cuuid.(string)
	vsobj.Services = append(vsobj.Services, &models.Service{Port: 80})

	nvsobj, err := aviClient.VirtualService.Create(&vsobj)
	if err != nil {
		fmt.Println("VS creation failed: ", err)
		return
	}
	fmt.Printf("VS obj: ", nvsobj.TenantRef)

}