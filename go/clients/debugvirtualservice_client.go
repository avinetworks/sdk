package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// DebugVirtualServiceClient is a client for avi DebugVirtualService resource
type DebugVirtualServiceClient struct {
	aviSession *session.AviSession
}

// NewDebugVirtualServiceClient creates a new client for DebugVirtualService resource
func NewDebugVirtualServiceClient(aviSession *session.AviSession) *DebugVirtualServiceClient {
	return &DebugVirtualServiceClient{aviSession: aviSession}
}

func (client *DebugVirtualServiceClient) getAPIPath(uuid string) string {
	path := "api/debugvirtualservice"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of DebugVirtualService objects
func (client *DebugVirtualServiceClient) GetAll() ([]*models.DebugVirtualService, error) {
	var plist []*models.DebugVirtualService
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing DebugVirtualService by uuid
func (client *DebugVirtualServiceClient) Get(uuid string) (*models.DebugVirtualService, error) {
	var obj *models.DebugVirtualService
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing DebugVirtualService by name
func (client *DebugVirtualServiceClient) GetByName(name string) (*models.DebugVirtualService, error) {
	var obj *models.DebugVirtualService
	err := client.aviSession.GetObjectByName("debugvirtualservice", name, &obj)
	return obj, err
}

// Create a new DebugVirtualService object
func (client *DebugVirtualServiceClient) Create(obj *models.DebugVirtualService) (*models.DebugVirtualService, error) {
	var robj *models.DebugVirtualService
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing DebugVirtualService object
func (client *DebugVirtualServiceClient) Update(obj *models.DebugVirtualService) (*models.DebugVirtualService, error) {
	var robj *models.DebugVirtualService
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing DebugVirtualService object with a given UUID
func (client *DebugVirtualServiceClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing DebugVirtualService object with a given name
func (client *DebugVirtualServiceClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
