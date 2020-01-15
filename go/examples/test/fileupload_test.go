package test

import (
	"fmt"
	"github.com/avinetworks/sdk/go/clients"
	"github.com/avinetworks/sdk/go/session"
	"log"
	"os"
	"testing"
)

//Open given file as a file pointer
func mustOpen(f string) *os.File {
	r, err := os.Open(f)
	if err != nil {
		log.Printf("[ERROR] mustOpen Error while opening file %v", f)
		panic(err)
	}
	return r
}

func TestFileUpload(t *testing.T) {
	aviClient, err := clients.NewAviClient(os.Getenv("controller"), "admin",
		session.SetPassword(os.Getenv("password")),
		session.SetTenant("admin"),
		session.SetVersion(os.Getenv("version")),
		session.SetInsecure)

	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		t.Fail()
	}

	uri := "hsmpackages?hsmtype=safenet"
	local_file := "/mnt/files/hsm/safenet_pkg/6.1/safenet.tar"
	local_file_ptr := mustOpen(local_file)
	err = aviClient.AviSession.PostMultipartRequest("POST", uri, local_file_ptr)
	if err != nil {
		log.Printf("[ERROR] MultipartUploadOrDownload Error uploading file %v %v", local_file, err)
		t.Fail()
	}
}
