package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	MICROSERVICE_RES_NAME = "microservice"
)

// MicroServiceClient is a client for avi MicroService resource
type MicroServiceClient struct {
	avi_session *session.AviSession
}

// NewMicroServiceClient creates a new client for MicroService resource
func NewMicroServiceClient(avi_session *session.AviSession) *MicroServiceClient {
	return &MicroServiceClient{avi_session: avi_session}
}

func (client *MicroServiceClient) GetApiPath(uuid string) string {
	path := "api/" + MICROSERVICE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of MicroService objects
func (client *MicroServiceClient) GetAll() ([]*models.MicroService, error) {
	var plist []*models.MicroService
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing MicroService by uuid
func (client *MicroServiceClient) Get(uuid string) (*models.MicroService, error) {
	var obj *models.MicroService
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing MicroService by name
func (client *MicroServiceClient) GetByName(name string) (*models.MicroService, error) {
	var obj *models.MicroService
	err := client.avi_session.GetObjectByName(MICROSERVICE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new MicroService object
func (client *MicroServiceClient) Create(obj *models.MicroService) (*models.MicroService, error) {
	var robj *models.MicroService
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing MicroService object
func (client *MicroServiceClient) Update(obj *models.MicroService) (*models.MicroService, error) {
	var robj *models.MicroService
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing MicroService object with a given UUID
func (client *MicroServiceClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing MicroService object with a given name
func (client *MicroServiceClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
