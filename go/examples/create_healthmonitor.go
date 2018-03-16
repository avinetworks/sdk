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
		session.SetTenant("webapp"),
		session.SetVersion("17.2.8"),
		session.SetInsecure)
	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		return
	}
	cv, err := aviClient.AviSession.GetControllerVersion()
	fmt.Printf("Avi Controller Version: %v:%v\n", cv, err)

	// Create health monitor in avinetworks tenant

	hmobj := models.HealthMonitor{}
	hmobj.Name = "Test-Hm"
	hmobj.Type = "HEALTH_MONITOR_HTTP"
	hmobj.ReceiveTimeout = 2
	hmobj.SendInterval = 3
	hmobj.SuccessfulChecks = 10
	hmobj.TenantRef = "tenant-9832e41d-56f0-49b6-bb62-58767821031b"
	httpmonitor := models.HealthMonitorHTTP{}
	httpmonitor.ExactHTTPRequest = false
	httpmonitor.HTTPRequest = "HEAD / HTTP/1.0"
	//httpmonitor.HTTPResponseCode = append(models.HTTPResponseCode, "HTTP_2XX")
	//hmobj.HTTPMonitor = &models.httpmonitor
	nvsobj, err := aviClient.HealthMonitor.Create(&hmobj)
	if err != nil {
		fmt.Println("Healthmonitor creation failed: ", err)
		return
	}
	fmt.Printf("Healthmonitor obj: %+v", *nvsobj)
}