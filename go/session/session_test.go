package session

import (
	"github.com/avinetworks/sdk/go/models"
	"log"
	"reflect"
	"testing"
	"encoding/json"
)

func TestAviSession(t *testing.T) {
	avisess := NewAviSession("10.10.25.201", "admin", "avi123", true)
	avisess.InitiateSession()

	res, err := avisess.Get("api/tenant")
	log.Println("res: ", res, " err:", err)
	resp := res.(map[string]interface{})
	log.Println("count: ", resp["count"])

	// create a tenant
	tenant := make(map[string]string)
	tenant["name"] = "testtenant"
	res, err = avisess.Post("api/tenant", tenant)
	log.Println("res: ", res, " err:", err)
	if err != nil {
		t.Error("Tenant Creation failed: ", err)
		return
	}

	// check tenant is created well
	res, err = avisess.Get("api/tenant?name=testtenant")
	log.Println("res: ", res, " err:", err)
	if reflect.TypeOf(res).Kind() == reflect.String {
		t.Errorf("Got string instead of json!")
		return
	}
	resp = res.(map[string]interface{})
	log.Println("count: ", resp["count"])
	curr_count := resp["count"].(float64)
	if curr_count != 1.0 {
		t.Errorf("could not find a tenant with name testtenant")
		return
	}
	tenant["uuid"] = resp["results"].([]interface{})[0].(map[string]interface{})["uuid"].(string)

	// delete the tenant
	res, err = avisess.Delete("api/tenant/" + tenant["uuid"])
	log.Println("res: ", res, " err:", err)
	if err != nil {
		t.Error("Deletion failed")
		return
	}

	// check to make sure that the tenant is not there any more
	// check tenant is created well
	res, err = avisess.Get("api/tenant?name=testtenant")
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
	avisess := NewAviSession("10.10.25.201", "admin", "avi123", true)
	avisess.InitiateSession()

	tpool := models.Pool{}
        pname := "testpool"
	tpool.Name = &pname
	res, err := avisess.Post("api/pool", tpool)
	log.Println("res: ", res, " err:", err)
	if err != nil {
		t.Error("Pool Creation failed: ", err)
	}
        
        var npool2 models.Pool
        err = avisess.GetObjectByName("pool", "testpool", &npool2)

 
	log.Printf("npool: %+v err: %+v", npool2, err)
        log.Println("name: ", *npool2.Name)
	t.Error("Just to force output")
}
