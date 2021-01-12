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

func TestFileObjectUpload(t *testing.T) {
	aviClient, err := clients.NewAviClient(os.Getenv("AVI_CONTROLLER"), os.Getenv("AVI_USERNAME"),
		session.SetPassword(os.Getenv("AVI_PASSWORD")),
		session.SetTenant(os.Getenv("AVI_TENANT")),
		session.SetVersion(os.Getenv("AVI_VERSION")),
		session.SetInsecure)

	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		t.Fail()
	}

	local_file := "/mnt/files/hsm/safenet_pkg/6.1/safenet.tar"
	local_file_ptr := mustOpen(local_file)
	fileParams := make(map[string]string)
	fileParams["name"] = "TestHsmPackage"
	fileParams["read_only"] = "false"
	//Allowed options are OTHER_FILE_TYPES, IP_REPUTATION, GEO_DB, TECH_SUPPORT, HSMPACKAGES, IPAMDNSSCRIPTS,
	//CONTROLLER_IMAGE.
	fileParams["type"] = "IP_REPUTATION"
	fileParams["version"] = "2.1.1"
	fileParams["restrict_download"] = "false"

	err = aviClient.AviSession.PostMultipartFileObjectRequest(local_file_ptr, "admin", fileParams)
	if err != nil {
		log.Printf("[ERROR] MultipartFileObjectUpload Error uploading file %v %v", local_file, err)
		t.Fail()
	}
	fmt.Println("\nSuccessfully uploaded file using fileobject API")
	fileObjectRes := aviClient.FileObject.DeleteByName("TestHsmPackage")
	fmt.Println("FileObject Deleted Successfully, : ", fileObjectRes)
}

func TestWafAppSignatureUpload(t *testing.T) {
	aviClient, err := clients.NewAviClient(os.Getenv("AVI_CONTROLLER"), os.Getenv("AVI_USERNAME"),
		session.SetPassword(os.Getenv("AVI_PASSWORD")),
		session.SetTenant(os.Getenv("AVI_TENANT")),
		session.SetVersion(os.Getenv("AVI_VERSION")),
		session.SetInsecure)

	if err != nil {
		fmt.Println("Couldn't create session: ", err)
		t.Fail()
	}

	local_file := "/mnt/files/rulesets/vmware-waf-rulesets-1610418004000.zip"
	appSignData, err := aviClient.WafApplicationSignatureProvider.GetAll()
	if err != nil {
		log.Printf("[ERROR] MultipartWafApplicationUUpload Error uploading file %v %v", local_file, err)
		t.Fail()
	}
	log.Printf(" Using the UUID: %#v", *appSignData[0].UUID)
	uri := *appSignData[0].UUID + "/update"
	local_file_ptr := mustOpen(local_file)
	fileParams := make(map[string]string)

	err = aviClient.AviSession.PostMultipartWafAppSignatureObjectRequest(local_file_ptr, uri, "admin", fileParams)
	if err != nil {
		log.Printf("[ERROR] MultipartWafApplicationUUpload Error uploading file %v %v", local_file, err)
		t.Fail()
	}
	fmt.Println("\nSuccessfully set Waf applications signatures")
}
