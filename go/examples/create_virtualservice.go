package main

import (
	//"flag"
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

func main() {

    aviClient, err := clients.NewAviClient("10.10.28.99", "admin",
		session.SetPassword("avi123$%"),
		session.SetTenant("avinetworks"),
		session.SetVersion("17.2.8"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		return
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)


	aviClient1, err := clients.NewAviClient("10.10.28.99", "admin",
		session.SetPassword("avi123$%"),
		session.SetTenant("webapp"),
		session.SetVersion("17.2.8"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		return
	}
	cv1, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv1, err)

	// get virtual service
    	var obj interface{}
	err = aviClient1.AviSession.GetObjectByName("healthmonitor", "Test-Hm", &obj)
	if err == nil {
		fmt.Printf("### VS obj: %v\n %s", obj)
		uuid := obj.(map[string]interface{})["uuid"]
		fmt.Printf("### VS uuid: %v\n %s", uuid)
	}
	uuid := obj.(map[string]interface{})["uuid"]

	var profobj interface{}
	err = aviClient1.AviSession.GetObjectByName("applicationpersistenceprofile", "Test-Persistece-Profile", &obj)
	if err == nil {
		fmt.Printf("### VS obj: %v\n %s", profobj)
		profobj := obj.(map[string]interface{})["uuid"]
		fmt.Printf("### VS uuid: %v\n %s", profobj)
	}
	profobj = obj.(map[string]interface{})["uuid"]
    	fmt.Printf("HEALTH %v\n", profobj)
	// Use a pool client to create a pool with one server with IP 10.90.20.12, port 80
	pobj := models.Pool{}
	pobj.Name = "my-test-pool"
	serverobj := models.Server{}
	serverobj.Enabled = true
	serverobj.IP = &models.IPAddr{Type: "V4", Addr: "10.90.20.12"}
	pobj.Servers = append(pobj.Servers, &serverobj)
    	pobj.TenantRef = "tenant-50db83ba-2f67-42a5-aa59-2a6869388092"
	pobj.CloudRef = "cloud-50d3b62f-914d-4f39-912b-73b507d7be73"
	pobj.ApplicationPersistenceProfileRef = profobj.(string)
	//pobj.HealthMonitorRefs = uuid.(string)
	pobj.HealthMonitorRefs = append(pobj.HealthMonitorRefs, uuid.(string))
	npobj, err := aviClient.Pool.Create(&pobj)
	if err != nil {
		fmt.Println("Pool creation failed: ", err)
		return
	}

    // Create a virtual service and use the pool created above
	vsobj := models.VirtualService{}
	vsobj.Name = "my-test-vs"
	vipip := models.IPAddr{Type: "V4", Addr: "10.90.20.52"}
	vsobj.Vip = append(vsobj.Vip, &models.Vip{VipID: "myvip", IPAddress: &vipip})
	vsobj.TenantRef = "tenant-50db83ba-2f67-42a5-aa59-2a6869388092"
	vsobj.PoolRef = npobj.UUID
	vsobj.CloudRef = "cloud-50d3b62f-914d-4f39-912b-73b507d7be73"
	vsobj.Services = append(vsobj.Services, &models.Service{Port: 80})

	nvsobj, err := aviClient.VirtualService.Create(&vsobj)
	if err != nil {
		fmt.Println("VS creation failed: ", err)
		return
	}
	fmt.Printf("VS obj: ", nvsobj.TenantRef)




}