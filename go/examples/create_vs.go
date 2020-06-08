package main

import (
	//"flag"
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

func main() {
	// flag.Lookup("logtostderr").Value.Set("false")
	// Create a session and a generic client to Avi Controller
	aviClient, err := clients.NewAviClient("10.10.28.91", "admin",
		session.SetPassword("password"),
		session.SetTenant("admin"),
		session.SetVersion("20.1.1"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		return
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)

	// Use a pool client to create a pool with one server with IP 10.90.20.12, port 80
	pobj := models.Pool{}
	pname := "my-test-pool"
	pobj.Name = &pname
	serverobj := models.Server{}
	enabled := true
	serverobj.Enabled = &enabled
	ipType := "V4"
	addr := "10.90.20.12"
	serverobj.IP = &models.IPAddr{Type: &ipType, Addr: &addr}
	pobj.Servers = append(pobj.Servers, &serverobj)

	npobj, err := aviClient.Pool.Create(&pobj)
	if err != nil {
		fmt.Println("Pool creation failed: ", err)
		return
	}

	vsVip := models.VsVip{}
	vipAddr := "10.90.20.51"
	vipip := models.IPAddr{Type: &ipType, Addr: &vipAddr}
	vipId := "1"
	vipObj := models.Vip{VipID: &vipId, IPAddress: &vipip}
	vipName := "test_vsvip"
	vsVip.Name = &vipName
	vsVip.Vip = append(vsVip.Vip, &vipObj)

	vsVipObj, err := aviClient.VsVip.Create(&vsVip)
	if err != nil {
		fmt.Println("VIP creation failed: ", err)
		return
	}

	// Create a virtual service and use the pool created above
	vsobj := models.VirtualService{}
	vname := "my-test-vs"
	vsobj.Name = &vname
	vsobj.VsvipRef = vsVipObj.UUID

	vsobj.PoolRef = npobj.UUID
	port := int32(80)
	vsobj.Services = append(vsobj.Services, &models.Service{Port: &port})

	nvsobj, err := aviClient.VirtualService.Create(&vsobj)
	if err != nil {
		fmt.Println("VS creation failed: ", err)
		return
	}
	fmt.Printf("VS obj: %+v", *nvsobj)

	// Example of fetching object by name

	var obj interface{}
	err = aviClient.AviSession.GetObjectByName("virtualservice", "my-test-vs", &obj)
	fmt.Printf("VS obj: %v\n", obj)

	err = aviClient.AviSession.GetObject(
		"virtualservice", session.SetName("my-test-vs"), session.SetResult(&obj),
		session.SetCloudUUID("cloud-f39f950a-e6ca-442d-b546-fc31520991bb"))
	fmt.Printf("VS with CLOUD_UUID obj: %v", obj)

	// Delete vs
	err = aviClient.VirtualService.Delete(*nvsobj.UUID)
	if err != nil {
		fmt.Println("VS deletion failed: ", err)
		return
	}
	// Delete pool
	err = aviClient.Pool.Delete(*npobj.UUID)
	if err != nil {
		fmt.Println("Pool deletion failed: ", err)
		return
	}

	// Delete vip
	err = aviClient.VsVip.Delete(*vsVipObj.UUID)
	if err != nil {
		fmt.Println("Vip deletion failed: ", err)
		return
	}
}
