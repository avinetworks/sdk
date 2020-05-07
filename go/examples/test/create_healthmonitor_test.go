package test

import (
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
	"os"
	"testing"
)

func TestCreateHealthmonitor(t *testing.T) {
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

	// Create health monitor in webapp tenant
	hmobj := models.HealthMonitor{}
	name := "Test-Hm"
	hmobj.Name = &name
	Type := "HEALTH_MONITOR_HTTP"
	hmobj.Type = &Type
	rt := (int32)(2)
	hmobj.ReceiveTimeout = &rt
	si := (int32)(3)
	hmobj.SendInterval = &si
	sc := (int32)(10)
	hmobj.SuccessfulChecks = &sc
	tr := "/api/tenant?name=admin"
	hmobj.TenantRef = &tr
	httpmonitor := models.HealthMonitorHTTP{}
	ehr := false
	httpmonitor.ExactHTTPRequest = &ehr
	hr := "HEAD / HTTP/1.0"
	httpmonitor.HTTPRequest = &hr
	httpmonitor.HTTPResponseCode = append(httpmonitor.HTTPResponseCode, "HTTP_3XX")
	hmobj.HTTPMonitor = &httpmonitor
	nvsobj, err := aviClient.HealthMonitor.Create(&hmobj)
	if err != nil {
		fmt.Println("\n Healthmonitor creation failed: ", err)
		t.Fail()
	}
	fmt.Printf("\n Healthmonitor obj: %+v", *nvsobj)

	// Update healthmonitor
	profobj := models.HealthMonitor{}
	err = aviClient.AviSession.GetObjectByName("healthmonitor", "Test-Hm", &profobj)
	if err == nil {
		name := "Test-Healthmonitor"
		profobj.Name = &name
		rt := (int32)(3)
		profobj.ReceiveTimeout = &rt
		si := (int32)(4)
		profobj.SendInterval = &si
		sc := (int32)(10)
		profobj.SuccessfulChecks = &sc
		Type := "HEALTH_MONITOR_HTTP"
		profobj.Type = &Type

		upObj, err := aviClient.HealthMonitor.Update(&profobj)
		if err != nil {
			fmt.Println("\n [ERROR] : ", err)
			t.Fail()
		}
		fmt.Printf("\n\nUpdated Healthmonitor obj: %+v", *upObj)
	} else {
		fmt.Println("\n [%%%%%% ERROR] : ", err)
		t.Fail()
	}

}
