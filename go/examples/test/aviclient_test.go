package test

import (
"fmt"
"github.com/avinetworks/sdk/go/clients"
"github.com/avinetworks/sdk/go/session"
"os"
"testing"
)
func TestAviClientWithInvalidController(t *testing.T) {
	aviClient, err := clients.NewAviClient("1.1.1.1", "admin",
		session.SetPassword(os.Getenv("password")),
		session.SetTenant("admin"),
		session.SetVersion(os.Getenv("version")),
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
	password := os.Getenv("password")
	new_password := password + "1"
	path := "api/useraccount"
	hm_path := "api/healthmonitor"
	var robj interface{}
	aviClientNewPassword, _ := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword(new_password),
		session.SetTenant("admin"),
		session.SetVersion(os.Getenv("version")),
		session.SetInsecure, session.SetLazyAuthentication(true))
	err := aviClientNewPassword.AviSession.Get(hm_path, &robj)
	if err == nil {
		fmt.Println("Didn't get expected error for wrong password")
		t.Fail()
	}

	aviClientOldPassword, _ := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword(password),
		session.SetTenant("admin"),
		session.SetVersion(os.Getenv("version")),
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
