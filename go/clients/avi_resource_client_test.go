package clients

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
	"log"
	"testing"
)

func TestAviPoolClient(t *testing.T) {
	// Create Pool
	// Get All
	// Update Pool
	// Delete Pool
	aviSession, err := session.NewAviSession("10.10.25.201", "admin",
		session.SetPassword("avi123"), session.SetInsecure)
	pclient := NewPoolClient(aviSession)

	obj := models.Pool{}
	obj.Name = "testpool"
	objp, err := pclient.Create(&obj)
	log.Printf("res: %+v; err: %+v", *objp, err)

	aserver := models.Server{}
	aserver.IP = &models.IPAddr{Addr: "10.10.10.10", Type: "V4"}
	objp.Servers = append(objp.Servers, &aserver)

	objp, err = pclient.Update(objp)
	log.Printf("After update -- res: %+v; err: %+v", *objp, err)
	log.Printf("After update -- server: %+v", objp.Servers[0])

	lobjp, err := pclient.GetAll()
	log.Printf("res: %+v; err: %+v", *lobjp[0], err)

	objp, err = pclient.GetByName("testpool")
	log.Printf("res: %+v; err: %+v", *objp, err)

	objp, err = pclient.Get(objp.UUID)
	log.Printf("res: %+v; err: %+v", *objp, err)
	objp.Enabled = false

	objp, err = pclient.Update(objp)
	log.Printf("res: %+v; err: %+v", *objp, err)

	err = pclient.Delete(objp.UUID)
	log.Printf("err: %+v", err)
	t.Error("Just to force output")
}
