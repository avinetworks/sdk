package session

import (
	"github.com/avinetworks/sdk/go/models"
	"log"
	"reflect"
	"testing"
)

func TestAviSession(t *testing.T) {
	avisess, err := NewAviSession("10.10.25.201", "admin", SetPassword("avi123"), SetInsecure)
	if err != nil {
		t.Error("Session Creation failed: ", err)
		return
	}
	var res interface{}
	err = avisess.Get("api/tenant", &res)
	log.Println("res: ", res, " err:", err)
	resp := res.(map[string]interface{})
	log.Println("count: ", resp["count"])

	// create a tenant
	tenant := make(map[string]string)
	tenant["name"] = "testtenant"
	var tres interface{}
	err = avisess.Post("api/tenant", &tenant, &tres)
	log.Println("res: ", tres, " err:", err)
	if err != nil {
		t.Error("Tenant Creation failed: ", err)
		return
	}

	// check tenant is created well
	err = avisess.Get("api/tenant?name=testtenant", &res)
	log.Println("res: ", res, " err:", err)
	if reflect.TypeOf(res).Kind() == reflect.String {
		t.Errorf("Got string instead of json!")
		return
	}
	resp = res.(map[string]interface{})
	log.Println("count: ", resp["count"])
	currCount := resp["count"].(float64)
	if currCount != 1.0 {
		t.Errorf("could not find a tenant with name testtenant")
		return
	}
	tenant["uuid"] = resp["results"].([]interface{})[0].(map[string]interface{})["uuid"].(string)

	// delete the tenant
	err = avisess.Delete("api/tenant/" + tenant["uuid"])
	log.Println("err: ", err)
	if err != nil {
		t.Error("Deletion failed")
		return
	}

	// check to make sure that the tenant is not there any more
	// check tenant is created well
	err = avisess.Get("api/tenant?name=testtenant", &res)
	log.Println("res: ", res, " err:", err)
	resp = res.(map[string]interface{})
	log.Println("count: ", resp["count"])
	curr_count = resp["count"].(float64)
	if curr_count != 0.0 {
		t.Errorf("Expecting no tenant with that name")
		return
	}

	//t.Error("Just to force output")
}

func TestAviPool(t *testing.T) {
	avisess, err := NewAviSession("10.10.25.201", "admin", SetPassword("avi123"), SetInsecure)
	if err != nil {
		t.Error("Session Creation failed: ", err)
		return
	}

	tpool := models.Pool{}
	pname := "testpool"
	tpool.Name = pname
	var res models.Pool
	err = avisess.Post("api/pool", tpool, &res)
	log.Println("res: ", res, " err:", err)
	if err != nil {
		t.Error("Pool Creation failed: ", err)
	}

	var npool2 models.Pool
	err = avisess.GetObjectByName("pool", "testpool", &npool2)

	log.Printf("npool: %+v err: %+v", npool2, err)
	log.Println("name: ", npool2.Name)

	err = avisess.Delete("api/pool/" + npool2.UUID)
	if err != nil {
		t.Error("Pool deletion failed: ", err)
	}
	//t.Error("Just to force output")
}
