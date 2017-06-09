package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	DEBUGVIRTUALSERVICE_RES_NAME = "debugvirtualservice"
)

// DebugVirtualServiceClient is a client for avi DebugVirtualService resource
type DebugVirtualServiceClient struct {
	avi_session *session.AviSession
}

// NewDebugVirtualServiceClient creates a new client for DebugVirtualService resource
func NewDebugVirtualServiceClient(avi_session *session.AviSession) *DebugVirtualServiceClient {
	return &DebugVirtualServiceClient{avi_session: avi_session}
}

func (client *DebugVirtualServiceClient) GetApiPath(uuid string) string {
	path := "api/" + DEBUGVIRTUALSERVICE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of DebugVirtualService objects
func (client *DebugVirtualServiceClient) GetAll() ([]*models.DebugVirtualService, error) {
	var plist []*models.DebugVirtualService
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing DebugVirtualService by uuid
func (client *DebugVirtualServiceClient) Get(uuid string) (*models.DebugVirtualService, error) {
	var obj *models.DebugVirtualService
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing DebugVirtualService by name
func (client *DebugVirtualServiceClient) GetByName(name string) (*models.DebugVirtualService, error) {
	var obj *models.DebugVirtualService
	err := client.avi_session.GetObjectByName(DEBUGVIRTUALSERVICE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new DebugVirtualService object
func (client *DebugVirtualServiceClient) Create(obj *models.DebugVirtualService) (*models.DebugVirtualService, error) {
	var robj *models.DebugVirtualService
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing DebugVirtualService object
func (client *DebugVirtualServiceClient) Update(obj *models.DebugVirtualService) (*models.DebugVirtualService, error) {
	var robj *models.DebugVirtualService
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing DebugVirtualService object with a given UUID
func (client *DebugVirtualServiceClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing DebugVirtualService object with a given name
func (client *DebugVirtualServiceClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
