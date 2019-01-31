package clients

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
	"github.com/golang/glog"
	"os"
	"testing"
)

var AVI_CONTROLLER = os.Getenv("AVI_CONTROLLER")
var AVI_PASSWORD = os.Getenv("AVI_PASSWORD")
var AVI_USERNAME = os.Getenv("AVI_USERNAME")
var AVI_TENANT = os.Getenv("AVI_TENANT")

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
	os.Exit(m.Run())
}

func getSessions(t *testing.T) []*session.AviSession {
	/* Test username/password authentication */
	credentialsSession, err := session.NewAviSession(AVI_CONTROLLER, AVI_USERNAME,
		session.SetPassword(AVI_PASSWORD), session.SetTenant(AVI_TENANT), session.SetInsecure)
	if err != nil {
		t.Fatalf("Session Creation failed: %s", err)
	}
	return []*session.AviSession{credentialsSession}
}

// Create Pool
// Get All
// Update Pool
// Delete Pool
func testAviPoolClient(t *testing.T, aviSession *session.AviSession) {
	pclient := NewPoolClient(aviSession)
	avssn := pclient.GetAviSession()
	if avssn == nil {
		t.Fatalf("ERROR: AviSession Get Failed")
	}

	obj := models.Pool{}
	pname := "testpool"
	obj.Name = &pname
	objp, err := pclient.Create(&obj)
	if err != nil {
		t.Fatalf("ERROR: %s", err)
	}
	glog.Infof("res: %+v; err: %+v", *objp, err)

	aserver := models.Server{}
	addr := "10.10.10.10"
	ipType := "V4"
	aserver.IP = &models.IPAddr{Addr: &addr, Type: &ipType}
	objp.Servers = append(objp.Servers, &aserver)

	objp, err = pclient.Update(objp)
	glog.Infof("After update -- res: %+v; err: %+v", *objp, err)
	glog.Infof("After update -- server: %+v", objp.Servers[0])
	if err != nil {
		t.Fatalf("ERROR: %s", err)
	}

	lobjp, err := pclient.GetAll()
	glog.Infof("res: %+v; err: %+v", *lobjp[0], err)
	if err != nil {
		t.Fatalf("ERROR: %s", err)
	}

	objp, err = pclient.GetByName("testpool")
	glog.Infof("res: %+v; err: %+v", *objp, err)
	if err != nil {
		t.Fatalf("ERROR: %s", err)
	}

	objp, err = pclient.GetObject(session.SetName("testpool"))
	if err != nil {
		t.Fatalf("ERROR: %s", err)
	} else {
		glog.Infof("res: %+v; err: %+v", *objp, err)
	}

	objp, err = pclient.Get(*objp.UUID)
	glog.Infof("res: %+v; err: %+v", *objp, err)
	enabled := false
	objp.Enabled = &enabled
	if err != nil {
		t.Fatalf("ERROR: %s", err)
	}

	objp, err = pclient.Update(objp)
	glog.Infof("res: %+v; err: %+v", *objp, err)
	if err != nil {
		t.Fatalf("ERROR: %s", err)
	}

	err = pclient.Delete(*objp.UUID)
	glog.Infof("err: %+v", err)
	if err != nil {
		t.Fatalf("ERROR: %s", err)
	}
}

func TestAviPoolClient(t *testing.T) {
	for _, session := range getSessions(t) {
		testAviPoolClient(t, session)
	}
}

func TestAviPoolPatch(t *testing.T) {
	for _, aviSession := range getSessions(t) {
		pclient := NewPoolClient(aviSession)
		avssn := pclient.GetAviSession()
		if avssn == nil {
			t.Fatalf("ERROR: AviSession Get Failed")
		}

		obj := models.Pool{}
		pname := "testpool-patch"
		obj.Name = &pname
		objp, err := pclient.Create(&obj)
		if err != nil {
			t.Fatalf("ERROR: %s", err)
		}
		glog.Infof("res: %+v; err: %+v", *objp, err)

		//add server
		server := models.Server{}
		var patch = make(map[string]interface{})
		ipaddr := models.IPAddr{}
		addr := "10.90.164.222"
		ipaddr.Addr = &addr
		Type := "V4"
		ipaddr.Type = &Type
		server.IP = &ipaddr
		var servers = make([]models.Server, 1)
		servers[0] = server
		patch["servers"] = servers
		var patchedPool *models.Pool
		patchedPool, err = pclient.Patch(*objp.UUID, patch, "add")

		if len(patchedPool.Servers) == 0 {
			t.Fatalf("Patching of Pool Failed server add %v", server)
		}
		patchedPool, err = pclient.Patch(*objp.UUID, patch, "delete")
		if err != nil {
			t.Fatalf("Patching failed err %v", err)
		}
		if len(patchedPool.Servers) > 0 {
			t.Fatalf("Patching of Pool Failed server remove %v", server)
		}
		err = pclient.Delete(*patchedPool.UUID)
		glog.Infof("err: %+v", err)
		if err != nil {
			t.Fatalf("ERROR: %s", err)
		}
	}
}
