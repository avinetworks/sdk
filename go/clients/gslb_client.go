package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	GSLB_RES_NAME = "gslb"
)

// GslbClient is a client for avi Gslb resource
type GslbClient struct {
	avi_session *session.AviSession
}

// NewGslbClient creates a new client for Gslb resource
func NewGslbClient(avi_session *session.AviSession) *GslbClient {
	return &GslbClient{avi_session: avi_session}
}

func (client *GslbClient) GetApiPath(uuid string) string {
	path := "api/" + GSLB_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Gslb objects
func (client *GslbClient) GetAll() ([]*models.Gslb, error) {
	var plist []*models.Gslb
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing Gslb by uuid
func (client *GslbClient) Get(uuid string) (*models.Gslb, error) {
	var obj *models.Gslb
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing Gslb by name
func (client *GslbClient) GetByName(name string) (*models.Gslb, error) {
	var obj *models.Gslb
	err := client.avi_session.GetObjectByName(GSLB_RES_NAME, name, &obj)
	return obj, err
}

// Create a new Gslb object
func (client *GslbClient) Create(obj *models.Gslb) (*models.Gslb, error) {
	var robj *models.Gslb
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing Gslb object
func (client *GslbClient) Update(obj *models.Gslb) (*models.Gslb, error) {
	var robj *models.Gslb
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Gslb object with a given UUID
func (client *GslbClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing Gslb object with a given name
func (client *GslbClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
