package main

import (
	"github.com/avinetworks/sdk/go/session"
	"github.com/golang/glog"
	"os"
	"strconv"
	"time"
)

var AVI_CONTROLLER = os.Getenv("AVI_CONTROLLER")
var AVI_USERNAME = os.Getenv("AVI_USERNAME")
var AVI_TENANT = os.Getenv("AVI_TENANT")
var AVI_PASSWORD = os.Getenv("AVI_PASSWORD")
var AVI_POOL_NAME = os.Getenv("")
var AVI_VIRTUALSERVICE_NAME = os.Getenv("")
var AVI_AUTH_TOKEN = os.Getenv("AVI_AUTH_TOKEN")
var AVI_API_ITERATIONS int

func checkTime(start time.Time, testcase string) {
	now := time.Now()
	delta := now.Sub(start)
	if delta.Seconds() > 2 {
		glog.Errorf("Testcase %s took %v seconds", testcase, delta)
	}
}

func main() {
	// flag.Lookup("logtostderr").Value.Set("false")
	// Create a session and a generic client to Avi Controller

	if AVI_USERNAME == "" {
		AVI_USERNAME = "admin"
	}
	if AVI_TENANT == "" {
		AVI_TENANT = "admin"
	}
	if iterations, err := strconv.Atoi(os.Getenv("AVI_API_ITERATIONS")); err == nil {
		AVI_API_ITERATIONS = iterations
	} else {
		AVI_API_ITERATIONS = 1
	}

	aviVersion, ok := os.LookupEnv("AVI_VERSION")
	if !ok {
		aviVersion = "18.1.3"
	}
	var err error
	var avisess *session.AviSession

	glog.Infof("using settings CNTLR: %s USER: %s TENANT: %s VERSION: %s AUTH: %s ITR %d",
		AVI_CONTROLLER, AVI_USERNAME, AVI_TENANT, aviVersion, AVI_AUTH_TOKEN, AVI_API_ITERATIONS)
	if AVI_PASSWORD != "" {
		avisess, err = session.NewAviSession(AVI_CONTROLLER,
			AVI_USERNAME, session.SetTenant(AVI_TENANT), session.SetPassword(AVI_PASSWORD),
			session.SetInsecure, session.SetVersion(aviVersion))
	} else {
		avisess, err = session.NewAviSession(AVI_CONTROLLER,
			AVI_USERNAME, session.SetTenant(AVI_TENANT),
			session.SetAuthToken(AVI_AUTH_TOKEN), session.SetInsecure, session.SetVersion(aviVersion))
	}

	if err != nil {
		glog.Errorf("Login Failed settings CNTLR: %s USER: %s TENANT: %s VERSION: %s AUTH: %s ITR %d err %v",
			AVI_CONTROLLER, AVI_USERNAME, AVI_TENANT, aviVersion, AVI_AUTH_TOKEN, AVI_API_ITERATIONS, err)
		return
	}

	for i := 0; i < AVI_API_ITERATIONS; i++ {
		start := time.Now()
		var res interface{}
		var err error
		if AVI_POOL_NAME != "" {
			start = time.Now()
			if err = avisess.GetObjectByName("pool", AVI_POOL_NAME, &res); err != nil {
				glog.Errorf("api/pool %s err: %s", AVI_POOL_NAME, err)
			}
			checkTime(start, "GetPoolByName")
		}

		start = time.Now()
		if err = avisess.Get("api/pool", &res); err == nil {
			resp := res.(map[string]interface{})
			glog.Infof("count: %d", resp["count"])
		} else {
			glog.Errorf("err: %s", err)

		}
		checkTime(start, "GetPoolList")

		start = time.Now()
		if err = avisess.Get("api/pool-inventory", &res); err == nil {
			resp := res.(map[string]interface{})
			glog.Infof("count: %d", resp["count"])
		} else {
			glog.Errorf("pi/pool-inventory err: %s", err)
		}
		checkTime(start, "GetPoolInventory")

		if AVI_VIRTUALSERVICE_NAME != "" {
			start = time.Now()
			if err = avisess.GetObjectByName("virtualservice", AVI_VIRTUALSERVICE_NAME, &res); err != nil {
				glog.Infof("vs %s: err %s", AVI_VIRTUALSERVICE_NAME, err)

			}
			checkTime(start, "GetVirtualServiceByName")
		}

		start = time.Now()
		if err = avisess.Get("api/virtualservice", &res); err == nil {
			resp := res.(map[string]interface{})
			glog.Infof("count: %d", resp["count"])
		} else {
			glog.Errorf("api/virtualservice err: %s", err)
		}
		checkTime(start, "GetVirtualServiceList")

		start = time.Now()
		if err = avisess.Get("api/virtualservice-inventory", &res); err == nil{
			resp := res.(map[string]interface{})
			glog.Infof("count: %d", resp["count"])
		} else {
			glog.Errorf("err: %s", err)
		}
		checkTime(start, "GetVirtualServiceInventory")
	}
	glog.Error("Test Complete")

}
