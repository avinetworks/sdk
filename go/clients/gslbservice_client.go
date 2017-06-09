package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	GSLBSERVICE_RES_NAME = "gslbservice"
)

// GslbServiceClient is a client for avi GslbService resource
type GslbServiceClient struct {
	avi_session *session.AviSession
}

// NewGslbServiceClient creates a new client for GslbService resource
func NewGslbServiceClient(avi_session *session.AviSession) *GslbServiceClient {
	return &GslbServiceClient{avi_session: avi_session}
}

func (client *GslbServiceClient) GetApiPath(uuid string) string {
	path := "api/" + GSLBSERVICE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of GslbService objects
func (client *GslbServiceClient) GetAll() ([]*models.GslbService, error) {
	var plist []*models.GslbService
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing GslbService by uuid
func (client *GslbServiceClient) Get(uuid string) (*models.GslbService, error) {
	var obj *models.GslbService
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing GslbService by name
func (client *GslbServiceClient) GetByName(name string) (*models.GslbService, error) {
	var obj *models.GslbService
	err := client.avi_session.GetObjectByName(GSLBSERVICE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new GslbService object
func (client *GslbServiceClient) Create(obj *models.GslbService) (*models.GslbService, error) {
	var robj *models.GslbService
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing GslbService object
func (client *GslbServiceClient) Update(obj *models.GslbService) (*models.GslbService, error) {
	var robj *models.GslbService
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing GslbService object with a given UUID
func (client *GslbServiceClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing GslbService object with a given name
func (client *GslbServiceClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
