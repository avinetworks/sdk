package session

import (
	"encoding/json"
	"github.com/avinetworks/sdk/go/models"
	"github.com/golang/glog"
	"os"
	"os/exec"
	"reflect"
	"strconv"
	"testing"
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

func TestMain(m *testing.M) {
	// call flag.Parse() here if TestMain uses flags
	if AVI_CONTROLLER == "" {
		AVI_CONTROLLER = "localhost"
	}
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
	os.Exit(m.Run())
}

// Function that generates auth token from django
// In future, this will become an internal API
func getAuthToken() string {
	output, err := exec.Command("/opt/avi/python/bin/portal/manage.py", "gen_auth_token", "--user", "admin", "--hours", "12").Output()
	if err != nil {
		glog.Infof("ERROR: %s", err)
		return ""
	}
	var jsonData interface{}
	err = json.Unmarshal(output, &jsonData)
	if err != nil {
		glog.Infof("ERROR: %s", err)
		return ""
	}
	jsonDataMap := jsonData.(map[string]interface{})
	authToken := jsonDataMap["token"].(string)
	return authToken
}

func getSessions(t *testing.T) []*AviSession {
	/* Test username/password authentication */

	aviVersion, ok := os.LookupEnv("AVI_VERSION")
	if !ok {
		aviVersion = "18.1.3"
	}

	var err error
	var credentialsSession *AviSession

	if AVI_PASSWORD != "" {
		credentialsSession, err = NewAviSession(AVI_CONTROLLER, AVI_USERNAME,
			SetTenant(AVI_TENANT), SetPassword(AVI_PASSWORD), SetInsecure, SetVersion(aviVersion))
	} else {
		credentialsSession, err = NewAviSession(AVI_CONTROLLER, AVI_USERNAME,
			SetTenant(AVI_TENANT), SetAuthToken(AVI_AUTH_TOKEN), SetInsecure, SetVersion(aviVersion))
	}

	if AVI_CONTROLLER != "localhost" {
		return []*AviSession{credentialsSession}
	}

	/* Test token authentication */
	authToken := getAuthToken()
	authTokenSession, err := NewAviSession(AVI_CONTROLLER, "admin",
		SetAuthToken(authToken), SetInsecure)

	if err != nil {
		t.Fatalf("Session Creation failed: %s", err)
	}

	/* Test token authentication with provided callback function */
	authTokenSessionCallback, err := NewAviSession(AVI_CONTROLLER, "admin",
		SetRefreshAuthTokenCallback(getAuthToken),
		SetInsecure)

	if err != nil {
		t.Errorf("Session Creation failed: %s", err)
	}

	return []*AviSession{credentialsSession, authTokenSession, authTokenSessionCallback}
}

func testAviSession(t *testing.T, avisess *AviSession) {

	var res interface{}
	err := avisess.Get("api/tenant", &res)
	glog.Infof("res: %s, err: %s", res, err)
	resp := res.(map[string]interface{})
	glog.Infof("count: %s", resp["count"])

	// create a tenant
	tenant := make(map[string]string)
	tenant["name"] = "testtenant"
	var tres interface{}
	err = avisess.Post("api/tenant", &tenant, &tres)
	glog.Infof("res: %s, err: %s", tres, err)
	if err != nil {
		t.Error("Tenant Creation failed: ", err)
		return
	}

	// check tenant is created well
	err = avisess.Get("api/tenant?name=testtenant", &res)
	glog.Infof("res: %s, err: %s", res, err)
	if reflect.TypeOf(res).Kind() == reflect.String {
		t.Errorf("Got string instead of json!")
		return
	}
	resp = res.(map[string]interface{})
	glog.Infof("count: %s", resp["count"])
	currCount := resp["count"].(float64)
	if currCount != 1.0 {
		t.Errorf("could not find a tenant with name testtenant")
		return
	}
	tenant["uuid"] = resp["results"].([]interface{})[0].(map[string]interface{})["uuid"].(string)

	// delete the tenant
	err = avisess.Delete("api/tenant/" + tenant["uuid"])
	glog.Infof("err: %s", err)
	if err != nil {
		t.Error("Deletion failed")
		return
	}

	// check to make sure that the tenant is not there any more
	// check tenant is created well
	err = avisess.Get("api/tenant?name=testtenant", &res)
	glog.Infof("res: %s, err: %s", res, err)
	resp = res.(map[string]interface{})
	glog.Infof("count: ", resp["count"])
	currCount = resp["count"].(float64)
	if currCount != 0.0 {
		t.Errorf("Expecting no tenant with that name")
		return
	}

}

func testAviPool(t *testing.T, avisess *AviSession) {
	tpool := models.Pool{}
	pname := "testpool"
	tpool.Name = &pname
	var res models.Pool
	err := avisess.Post("api/pool", tpool, &res)
	glog.Infof("res: %s, err: %s", res, err)
	if err != nil {
		t.Errorf("Pool Creation failed: %s", err)
	}

	var npool2 models.Pool
	err = avisess.GetObjectByName("pool", "testpool", &npool2)

	glog.Infof("npool: %+v err: %+v", npool2, err)
	glog.Infof("name %s: ", npool2.Name)

	var npool3 models.Pool
	// Test patch before deleting the pool
	var patch = make(map[string]interface{})
	server := models.Server{}
	ipaddr := models.IPAddr{}
	addr := "10.90.164.222"
	ipaddr.Addr = &addr
	Type := "V4"
	ipaddr.Type = &Type
	server.IP = &ipaddr
	var servers = make([]models.Server, 1)
	servers[0] = server
	patch["servers"] = servers
	err = avisess.Patch("api/pool/"+*npool2.UUID, patch, "add", &npool3)
	if err != nil {
		t.Errorf("Pool Patch failed %s", err)
	}

	//if len(npool3.Servers) != 1 {
	//	t.Error("Pool Patch failed %v", npool3)
	//}

	err = avisess.Delete("api/pool/" + *npool2.UUID)
	if err != nil {
		t.Errorf("Pool deletion failed: %s", err)
	}
}

func TestAviSession(t *testing.T) {
	for _, session := range getSessions(t) {
		testAviSession(t, session)
	}
}

func TestAviPool(t *testing.T) {
	for _, session := range getSessions(t) {
		testAviPool(t, session)
	}
}

func testAviDefaultFields(t *testing.T, avisess *AviSession) {
	tpool := models.Pool{}
	pname := "gosdk-test-pool"
	tpool.Name = &pname
	//bt := true
	//tpool.InlineHealthMonitor = &bt
	var res models.Pool
	err := avisess.Post("api/pool", tpool, &res)
	glog.Infof("res: %s, err: %s", res, err)
	if err != nil {
		t.Errorf("Pool Creation failed: %s", err)
	}

	if *res.InlineHealthMonitor == false {
		t.Errorf("Pool inline health monitor setting changed")
	}

	var npool2 models.Pool
	err = avisess.GetObjectByName("pool", pname, &npool2)

	if err != nil {
		t.Errorf("Pool %s lookup failed", pname)
	}

	if *npool2.InlineHealthMonitor == false {
		t.Errorf("Pool inline health monitor setting changed")
	}

	server := models.Server{}
	ipaddr := models.IPAddr{}
	addr := "10.90.164.222"
	ipaddr.Addr = &addr
	Type := "V4"
	ipaddr.Type = &Type
	server.IP = &ipaddr
	npool2.Servers = append(npool2.Servers, &server)
	nt := false
	npool2.InlineHealthMonitor = &nt

	var npool3 models.Pool
	err = avisess.Put("api/pool/"+*npool2.UUID, npool2, &npool3)

	if err != nil {
		t.Errorf("Pool Patch failed %s", err)
	}

	// AV-44749: This logic should be flipped after fixing AV-44749.
	if *npool3.InlineHealthMonitor != nt {
		t.Errorf("Pool inline health monitor setting changed to true")
	}

	err = avisess.Delete("api/pool/" + *npool2.UUID)
	if err != nil {
		t.Errorf("Pool deletion failed: %s", err)
	}
}

func TestAviDefaultFields(t *testing.T) {
	for _, session := range getSessions(t) {
		testAviDefaultFields(t, session)
	}
}

func bogusAuthTokenFunction() string {
	return "incorrect-auth-token"
}

func TestTokenAuthRobustness(t *testing.T) {
	if AVI_CONTROLLER != "localhost" {
		t.Skip("SKIPPING as test not running in controller.")
		return
	}
	/* Test token authentication with provided callback function */
	authTokenSessionCallback, err := NewAviSession(AVI_CONTROLLER, "admin",
		SetRefreshAuthTokenCallback(bogusAuthTokenFunction),
		SetInsecure)
	var res interface{}
	err = authTokenSessionCallback.Get("api/tenant", &res)
	if err == nil {
		t.Errorf("ERROR: Expected an error from incorrect token auth")
	}

	authTokenSession, err := NewAviSession(AVI_CONTROLLER, "admin",
		SetAuthToken("wrong-auth-token"),
		SetInsecure)
	err = authTokenSession.Get("api/tenant", &res)
	if err == nil {
		t.Errorf("ERROR: Expected an error from incorrect token auth")
	}
}

func checkTime(t *testing.T, start time.Time, testcase string) {
	now := time.Now()
	delta := now.Sub(start)
	if delta.Seconds() > 1 {
		t.Errorf("Testcase %s took %v seconds", testcase, delta)
	}
}

func TestAviReads(t *testing.T) {
	for _, avisess := range getSessions(t) {
		for i := 0; i < AVI_API_ITERATIONS; i++ {
			start := time.Now()
			var res interface{}
			err := avisess.Get("api/tenant", &res)
			glog.Infof("res: %s, err: %s", res, err)
			resp := res.(map[string]interface{})
			glog.Infof("count: %s", resp["count"])
			checkTime(t, start, "GetTenant")

			if AVI_POOL_NAME != "" {
				start = time.Now()
				err := avisess.GetObjectByName("pool", AVI_POOL_NAME, &res)
				glog.Infof("res: %s, err: %s", res, err)
				checkTime(t, start, "GetPoolByName")
			}

			start = time.Now()
			err = avisess.Get("api/pool", &res)
			glog.Infof("res: %s, err: %s", res, err)
			resp = res.(map[string]interface{})
			glog.Infof("count: %s", resp["count"])
			checkTime(t, start, "GetPool")

			if AVI_VIRTUALSERVICE_NAME != "" {
				start = time.Now()
				err := avisess.GetObjectByName("virtualservice", AVI_POOL_NAME, &res)
				glog.Infof("res: %s, err: %s", res, err)
				checkTime(t, start, "GetVirtualServiceByName")
			}

			start = time.Now()
			err = avisess.Get("api/virtualservice", &res)
			glog.Infof("res: %s, err: %s", res, err)
			resp = res.(map[string]interface{})
			checkTime(t, start, "GetVirtualServiceList")

			start = time.Now()
			err = avisess.Get("api/virtualservice", &res)
			glog.Infof("res: %s, err: %s", res, err)
			resp = res.(map[string]interface{})
			checkTime(t, start, "GetVirtualServiceInventory")

		}
	}
}
