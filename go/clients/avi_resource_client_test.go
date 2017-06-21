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
	avi_sess, err := session.NewAviSession("10.10.25.201", "admin",
		session.SetPassword("avi123"), session.SetInsecure)
	pclient := NewPoolClient(avi_sess)

	obj := models.Pool{}
	obj.Name = "testpool"
	objp, err := pclient.Create(&obj)
	log.Printf("res: %+v; err: %+v", *objp, err)

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
