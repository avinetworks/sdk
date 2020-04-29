package test

import (
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/session"
	"os"
	"testing"
)

func TestApiFilters(t *testing.T) {
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

	params := map[string]string{
		"page_size": "3",
		"page":      "1",
		"tenant":    "admin",
	}

	hmData, err := aviClient.HealthMonitor.GetAll(session.SetParams(params))
	if err != nil {
		fmt.Println("\n [ERROR] : ", err)
		t.Fail()
	} else {
		fmt.Println("\n Health monitors : ", hmData)
		if len(hmData) != 3 {
			t.Fail()
		}
	}

	params1 := map[string]string{
		"page":   "1",
		"tenant": "admin",
	}
	data, err := aviClient.HealthMonitor.GetObject(session.SetParams(params1), session.SetName("Test-Healthmonitor"))
	if err != nil {
		fmt.Println("\n [ERROR] : ", err)
		t.Fail()
	} else {
		fmt.Println("\n Health monitor object  : ", *data)
	}
}

func TestApiCollections(t *testing.T) {
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

	params := map[string]string{
		"page":      "1",
		"page_size": "1",
		"tenant":    "admin",
	}

	url := "api/healthmonitor"
	hmCollectionData, err := aviClient.AviSession.GetCollectionRaw(url, session.SetParams(params))
	if err != nil {
		fmt.Println("\n [ERROR] : ", err)
		t.Fail()
	}
	if hmCollectionData.Next != "" {
		fmt.Println("\n Health Monitor page_size=1 Next url string : ", hmCollectionData.Next)
	} else {
		fmt.Println("\n Health Monitor Next url string not found")
		t.Fail()
	}
}
