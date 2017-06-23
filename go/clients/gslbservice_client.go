package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// GslbServiceClient is a client for avi GslbService resource
type GslbServiceClient struct {
	aviSession *session.AviSession
}

// NewGslbServiceClient creates a new client for GslbService resource
func NewGslbServiceClient(aviSession *session.AviSession) *GslbServiceClient {
	return &GslbServiceClient{aviSession: aviSession}
}

func (client *GslbServiceClient) getAPIPath(uuid string) string {
	path := "api/gslbservice"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of GslbService objects
func (client *GslbServiceClient) GetAll() ([]*models.GslbService, error) {
	var plist []*models.GslbService
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing GslbService by uuid
func (client *GslbServiceClient) Get(uuid string) (*models.GslbService, error) {
	var obj *models.GslbService
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing GslbService by name
func (client *GslbServiceClient) GetByName(name string) (*models.GslbService, error) {
	var obj *models.GslbService
	err := client.aviSession.GetObjectByName("gslbservice", name, &obj)
	return obj, err
}

// Create a new GslbService object
func (client *GslbServiceClient) Create(obj *models.GslbService) (*models.GslbService, error) {
	var robj *models.GslbService
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing GslbService object
func (client *GslbServiceClient) Update(obj *models.GslbService) (*models.GslbService, error) {
	var robj *models.GslbService
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing GslbService object with a given UUID
func (client *GslbServiceClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing GslbService object with a given name
func (client *GslbServiceClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
