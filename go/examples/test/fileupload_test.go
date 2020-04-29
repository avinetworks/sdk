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
	aviClient, err := clients.NewAviClient(os.Getenv("AVI_CONTROLLER"), os.Getenv("AVI_USERNAME"),
		session.SetPassword(os.Getenv("AVI_PASSWORD")),
		session.SetTenant(os.Getenv("AVI_TENANT")),
		session.SetVersion(os.Getenv("AVI_VERSION")),
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
