package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VIRTUALSERVICE_RES_NAME = "virtualservice"
)

// VirtualServiceClient is a client for avi VirtualService resource
type VirtualServiceClient struct {
	avi_session *session.AviSession
}

// NewVirtualServiceClient creates a new client for VirtualService resource
func NewVirtualServiceClient(avi_session *session.AviSession) *VirtualServiceClient {
	return &VirtualServiceClient{avi_session: avi_session}
}

func (client *VirtualServiceClient) GetApiPath(uuid string) string {
	path := "api/" + VIRTUALSERVICE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VirtualService objects
func (client *VirtualServiceClient) GetAll() ([]*models.VirtualService, error) {
	var plist []*models.VirtualService
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VirtualService by uuid
func (client *VirtualServiceClient) Get(uuid string) (*models.VirtualService, error) {
	var obj *models.VirtualService
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VirtualService by name
func (client *VirtualServiceClient) GetByName(name string) (*models.VirtualService, error) {
	var obj *models.VirtualService
	err := client.avi_session.GetObjectByName(VIRTUALSERVICE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VirtualService object
func (client *VirtualServiceClient) Create(obj *models.VirtualService) (*models.VirtualService, error) {
	var robj *models.VirtualService
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VirtualService object
func (client *VirtualServiceClient) Update(obj *models.VirtualService) (*models.VirtualService, error) {
	var robj *models.VirtualService
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VirtualService object with a given UUID
func (client *VirtualServiceClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VirtualService object with a given name
func (client *VirtualServiceClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
