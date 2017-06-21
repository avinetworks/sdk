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
	avi_sess := session.NewAviSession("10.10.25.201", "admin", "avi123",
		true, "")
	avi_sess.InitiateSession()
	pclient := NewPoolClient(avi_sess)

	obj := models.Pool{}
	obj.Name = "testpool"
	objp, err := pclient.Create(&obj)
	log.Println("res: ", *objp, " err: ", err)

	lobjp, err := pclient.GetAll()
	log.Println("res: ", lobjp[0], " err: ", err)

	objp, err = pclient.GetByName("testpool")
	log.Println("res: ", *objp, " err: ", err)

	objp, err = pclient.Get(objp.UUID)
	log.Println("res: ", *objp, " err: ", err)
	objp.Enabled = false

	objp, err = pclient.Update(objp)
	log.Println("res: ", objp, " err: ", err)

	err = pclient.Delete(objp.UUID)
	log.Println("res: ", objp, " err: ", err)
	t.Error("Just to force output")
}
