package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// VirtualServiceClient is a client for avi VirtualService resource
type VirtualServiceClient struct {
	aviSession *session.AviSession
}

// NewVirtualServiceClient creates a new client for VirtualService resource
func NewVirtualServiceClient(aviSession *session.AviSession) *VirtualServiceClient {
	return &VirtualServiceClient{aviSession: aviSession}
}

func (client *VirtualServiceClient) getAPIPath(uuid string) string {
	path := "api/virtualservice"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VirtualService objects
func (client *VirtualServiceClient) GetAll() ([]*models.VirtualService, error) {
	var plist []*models.VirtualService
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing VirtualService by uuid
func (client *VirtualServiceClient) Get(uuid string) (*models.VirtualService, error) {
	var obj *models.VirtualService
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing VirtualService by name
func (client *VirtualServiceClient) GetByName(name string) (*models.VirtualService, error) {
	var obj *models.VirtualService
	err := client.aviSession.GetObjectByName("virtualservice", name, &obj)
	return obj, err
}

// Create a new VirtualService object
func (client *VirtualServiceClient) Create(obj *models.VirtualService) (*models.VirtualService, error) {
	var robj *models.VirtualService
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing VirtualService object
func (client *VirtualServiceClient) Update(obj *models.VirtualService) (*models.VirtualService, error) {
	var robj *models.VirtualService
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VirtualService object with a given UUID
func (client *VirtualServiceClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing VirtualService object with a given name
func (client *VirtualServiceClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
