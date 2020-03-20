package test

import (
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/session"
	"os"
	"testing"
)
func TestResetPassword(t *testing.T) {
	password := os.Getenv("password")
	invalid_password := password + "1"
	var robj interface{}
	path := "api/healthmonitor"
	aviClient, _ := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword(invalid_password),
		session.SetTenant("admin"),
		session.SetVersion(os.Getenv("version")),
		session.SetInsecure, session.SetLazyAuthentication(true))

	err := aviClient.AviSession.Get(path, &robj)
	if err == nil {
		fmt.Printf("Didn't get expected error for invalid password %v\n", err)
		t.Fail()
	}
	aviClient.AviSession.ResetPassword(password)
	err = aviClient.AviSession.Get(path, &robj)
	if err != nil {
			fmt.Printf("[ERROR] in get after password update %v\n", err)
			t.Fail()
	}
}
