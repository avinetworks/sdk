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
