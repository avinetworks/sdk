package main

import (
	"os"
	"strconv"
	"time"

	"github.com/avinetworks/sdk/go/session"
	"github.com/golang/glog"
)

var AVI_CONTROLLER = os.Getenv("AVI_CONTROLLER")
var AVI_USERNAME = os.Getenv("AVI_USERNAME")
var AVI_TENANT = os.Getenv("AVI_TENANT")
var AVI_PASSWORD = os.Getenv("AVI_PASSWORD")
var AVI_POOL_NAME = os.Getenv("AVI_POOL_NAME")
var AVI_VIRTUALSERVICE_NAME = os.Getenv("AVI_VIRTUALSERVICE_NAME")
var AVI_AUTH_TOKEN = os.Getenv("AVI_AUTH_TOKEN")
var AVI_API_ITERATIONS int
var RESET_SESSION_AT_ITERATION int
var SLEEP_TIME int

/*
	global variable specifications
	AVI_API_ITERATIONS:	number of iterations to run REST API tests
	RESET_SESSION_AT_ITERATION: reset session after every n APIs
	SLEEP_TIME: Use SLEEP_TIME to pause an iteration for n seconds
*/

func checkTime(start time.Time, testcase string, iteration int) {
	now := time.Now()
	delta := now.Sub(start)
	if delta.Seconds() > 2 {
		glog.Errorf("iteration: %d - Testcase %s took %v seconds", iteration, testcase, delta)
	}
}

func initialize_session(controller string, username string, tenant string, password string, auth_token string, version string) (*session.AviSession, error) {
	if password != "" {
		return session.NewAviSession(controller,
			username, session.SetTenant(tenant), session.SetPassword(password),
			session.SetInsecure, session.SetVersion(version))
	} else {
		return session.NewAviSession(controller,
			username, session.SetTenant(tenant),
			session.SetAuthToken(AVI_AUTH_TOKEN), session.SetInsecure, session.SetVersion(version))
	}
}

/*
	resource: https://flaviocopes.com/golang-profiling/
	Setup profiling:
		1. brew install graphviz (macOS) OR sudo apt-get install graphviz (linux)
		2. go get github.com/pkg/profile
			add "github.com/pkg/profile in the import object"
		3. uncomment `defer profile.Start().Stop()`
		4. go build api_reads.go

	Running the program initiates CPU Profiling and generates a *.pprof file in a tmp directory
	graphviz is a utility which convert .pprof file in a readable format
		4. go tool pprof --pdf api_reads <path to .pprof file>  > pprof.pdf
*/
func main() {
	// defer profile.Start().Stop()
	// defer profile.Start(profile.MemProfile).Stop()

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

	if reset, err := strconv.Atoi(os.Getenv("RESET_SESSION_AT_ITERATION")); err == nil {
		RESET_SESSION_AT_ITERATION = reset
	} else {
		RESET_SESSION_AT_ITERATION = 0
	}

	if sleep_time, err := strconv.Atoi(os.Getenv("SLEEP_TIME")); err == nil {
		SLEEP_TIME = sleep_time
	} else {
		SLEEP_TIME = 0
	}
	aviVersion, ok := os.LookupEnv("AVI_VERSION")
	if !ok {
		aviVersion = "17.2.14"
	}
	var err error
	var avisess *session.AviSession

	glog.Infof("using settings CNTLR: %s USER: %s TENANT: %s VERSION: %s AUTH: %s ITR %d",
		AVI_CONTROLLER, AVI_USERNAME, AVI_TENANT, aviVersion, AVI_AUTH_TOKEN, AVI_API_ITERATIONS)

	avisess, err = initialize_session(AVI_CONTROLLER, AVI_USERNAME, AVI_TENANT, AVI_PASSWORD,
		AVI_AUTH_TOKEN, aviVersion)

	if err != nil {
		glog.Errorf("Login Failed settings CNTLR: %s USER: %s TENANT: %s VERSION: %s AUTH: %s ITR %d err %v",
			AVI_CONTROLLER, AVI_USERNAME, AVI_TENANT, aviVersion, AVI_AUTH_TOKEN, AVI_API_ITERATIONS, err)
		return
	}

	for i := 0; i < AVI_API_ITERATIONS; i++ {
		start := time.Now()
		var res interface{}
		var err error

		if RESET_SESSION_AT_ITERATION != 0 && (i%RESET_SESSION_AT_ITERATION) == 0 && i != 0 {
			glog.Infof("Resetting session\n")
			avisess, err = initialize_session(AVI_CONTROLLER, AVI_USERNAME, AVI_TENANT, AVI_PASSWORD,
				AVI_AUTH_TOKEN, aviVersion)
		}

		if AVI_POOL_NAME != "" {
			start = time.Now()
			if err = avisess.GetObjectByName("pool", AVI_POOL_NAME, &res); err != nil {
				glog.Errorf("api/pool %s err: %s", AVI_POOL_NAME, err)
			}
			checkTime(start, "GetPoolByName", i)
		}

		start = time.Now()
		if err = avisess.Get("api/pool", &res); err == nil {
			resp := res.(map[string]interface{})
			glog.Infof("count: %d", resp["count"])
		} else {
			glog.Errorf("err: %s", err)

		}
		checkTime(start, "GetPoolList", i)

		start = time.Now()
		if err = avisess.Get("api/pool-inventory", &res); err == nil {
			resp := res.(map[string]interface{})
			glog.Infof("count: %d", resp["count"])
		} else {
			glog.Errorf("pi/pool-inventory err: %s", err)
		}
		checkTime(start, "GetPoolInventory", i)

		if AVI_VIRTUALSERVICE_NAME != "" {
			start = time.Now()
			if err = avisess.GetObjectByName("virtualservice", AVI_VIRTUALSERVICE_NAME, &res); err != nil {
				glog.Infof("vs %s: err %s", AVI_VIRTUALSERVICE_NAME, err)

			}
			checkTime(start, "GetVirtualServiceByName", i)
		}

		start = time.Now()
		if err = avisess.Get("api/virtualservice", &res); err == nil {
			resp := res.(map[string]interface{})
			glog.Infof("count: %d", resp["count"])
		} else {
			glog.Errorf("api/virtualservice err: %s", err)
		}
		checkTime(start, "GetVirtualServiceList", i)

		start = time.Now()
		if err = avisess.Get("api/virtualservice-inventory", &res); err == nil {
			resp := res.(map[string]interface{})
			glog.Infof("count: %d", resp["count"])
		} else {
			glog.Errorf("err: %s", err)
		}
		checkTime(start, "GetVirtualServiceInventory", i)

		if SLEEP_TIME != 0 {
			time.Sleep(time.Duration(2 * time.Second))
		}
	}
	glog.Error("Test Complete")

}
