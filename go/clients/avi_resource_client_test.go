package clients

import (
	"../models"
	"../clients"
	"log"
	"reflect"
	"testing"
	"encoding/json"
)

func TestAviPoolClient(t *testing.T) {
	// Create Pool
	// Get All
	// Update Pool
	// Delete Pool
	avi_sess := NewAviSession("10.10.25.42", "admin", "avi123", true)
	avi_sess.InitiateSession()
	pclient := NewPoolClient(avi_sess)

	obj := models.Pool{}
	name := "testpool"
	obj.Name = &name
	obj, err := pclient.Create(obj)
	log.Println("res: ", obj, " err: ", err)

	obj, err = pclient.Get(obj.UUID)
	log.Println("res: ", obj, " err: ", err)
	obj.enable = False

	obj, err = pclient.Update(obj)
	log.Println("res: ", obj, " err: ", err)

	err = pclient.Delete(obj.UUID)
	log.Println("res: ", obj, " err: ", err)
	t.Error("Just to force output")
}


