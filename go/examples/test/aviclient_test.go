package test

import (
"fmt"
"github.com/avinetworks/sdk/go/clients"
"github.com/avinetworks/sdk/go/session"
"os"
"testing"
)
func TestAviClientWithInvalidController(t *testing.T) {
	aviClient, err := clients.NewAviClient("1.1.1.1", os.Getenv("AVI_USERNAME"),
		session.SetPassword(os.Getenv("AVI_PASSWORD")),
		session.SetTenant(os.Getenv("AVI_TENANT")),
		session.SetVersion(os.Getenv("AVI_VERSION")),
		session.SetInsecure, session.SetLazyAuthentication(true))
	if err != nil {
		fmt.Println("Issue with lazyauthentication")
		t.Fail()
	}
	hmData, err := aviClient.HealthMonitor.GetAll()
	if hmData == nil || err != nil {
		fmt.Println("Got expected error for invalid controller IP. [ERROR]:", err.Error())
	} else {
		fmt.Println("Didn't get the error for invalid controller IP.")
		t.Fail()
	}
}

func TestUpdatePassword(t *testing.T) {
	password := os.Getenv("AVI_PASSWORD")
	new_password := password + "1"
	path := "api/useraccount"
	hm_path := "api/healthmonitor"
	var robj interface{}
	aviClientNewPassword, _ := clients.NewAviClient(os.Getenv("AVI_CONTROLLER"), os.Getenv("AVI_USERNAME"),
		session.SetPassword(new_password),
		session.SetTenant(os.Getenv("AVI_TENANT")),
		session.SetVersion(os.Getenv("AVI_VERSION")),
		session.SetInsecure, session.SetLazyAuthentication(true))
	err := aviClientNewPassword.AviSession.Get(hm_path, &robj)
	if err == nil {
		fmt.Println("Didn't get expected error for wrong password")
		t.Fail()
	}

	aviClientOldPassword, _ := clients.NewAviClient(os.Getenv("AVI_CONTROLLER"), os.Getenv("AVI_USERNAME"),
		session.SetPassword(password),
		session.SetTenant(os.Getenv("AVI_TENANT")),
		session.SetVersion(os.Getenv("AVI_VERSION")),
		session.SetInsecure, session.SetLazyAuthentication(true))
	data := make(map[string]string)
	data["username"] = "admin"
	data["name"] = "admin"
	data["old_password"] = password
	data["password"] = new_password
	err = aviClientOldPassword.AviSession.Put(path, data, &robj)
	if err != nil {
		fmt.Println("Error while updating the password. [ERROR]: ", err)
		t.Fail()
	}

	err = aviClientNewPassword.AviSession.Get(hm_path, &robj)
	if err != nil {
		fmt.Println("Got the error after updating the password. [ERROR]: ", err)
		t.Fail()
	}

	//Teardown
	data["password"] = password
	data["old_password"] = new_password
	err = aviClientNewPassword.AviSession.Put(path, data, &robj)
	if err != nil {
		fmt.Println("Error while updating the password. [ERROR]: ", err)
		t.Fail()
	}
}
