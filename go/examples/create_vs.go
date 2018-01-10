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
	aviClient, err := clients.NewAviClient("10.10.25.201", "admin",
		session.SetPassword("avi123"),
		session.SetTenant("admin"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		return
	}
	fmt.Printf("Avi Controller Version: %s\n", aviClient.AviSession.GetControllerVersion())

	// Use a pool client to create a pool with one server with IP 10.90.20.12, port 80
	pobj := models.Pool{}
	pobj.Name = "my-test-pool"
	serverobj := models.Server{}
	serverobj.Enabled = true
	serverobj.IP = &models.IPAddr{Type: "V4", Addr: "10.90.20.12"}
	pobj.Servers = append(pobj.Servers, &serverobj)

	npobj, err := aviClient.Pool.Create(&pobj)
	if err != nil {
		fmt.Println("Pool creation failed: ", err)
		return
	}

	// Create a virtual service and use the pool created above
	vsobj := models.VirtualService{}
	vsobj.Name = "my-test-vs"
	vipip := models.IPAddr{Type: "V4", Addr: "10.90.20.51"}
	vsobj.Vip = append(vsobj.Vip, &models.Vip{VipID: "myvip", IPAddress: &vipip})
	vsobj.PoolRef = npobj.UUID
	vsobj.Services = append(vsobj.Services, &models.Service{Port: 80})

	nvsobj, err := aviClient.VirtualService.Create(&vsobj)
	if err != nil {
		fmt.Println("VS creation failed: ", err)
		return
	}
	fmt.Printf("VS obj: %+v", *nvsobj)

	// Delete vs
	// aviClient.VirtualService.Delete(nvsobj.UUID)
	// Delete pool
	// aviClient.Pool.Delete(npobj.UUID)
}
