package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// VIMgrHostRuntimeClient is a client for avi VIMgrHostRuntime resource
type VIMgrHostRuntimeClient struct {
	aviSession *session.AviSession
}

// NewVIMgrHostRuntimeClient creates a new client for VIMgrHostRuntime resource
func NewVIMgrHostRuntimeClient(aviSession *session.AviSession) *VIMgrHostRuntimeClient {
	return &VIMgrHostRuntimeClient{aviSession: aviSession}
}

func (client *VIMgrHostRuntimeClient) getAPIPath(uuid string) string {
	path := "api/vimgrhostruntime"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIMgrHostRuntime objects
func (client *VIMgrHostRuntimeClient) GetAll() ([]*models.VIMgrHostRuntime, error) {
	var plist []*models.VIMgrHostRuntime
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing VIMgrHostRuntime by uuid
func (client *VIMgrHostRuntimeClient) Get(uuid string) (*models.VIMgrHostRuntime, error) {
	var obj *models.VIMgrHostRuntime
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing VIMgrHostRuntime by name
func (client *VIMgrHostRuntimeClient) GetByName(name string) (*models.VIMgrHostRuntime, error) {
	var obj *models.VIMgrHostRuntime
	err := client.aviSession.GetObjectByName("vimgrhostruntime", name, &obj)
	return obj, err
}

// Create a new VIMgrHostRuntime object
func (client *VIMgrHostRuntimeClient) Create(obj *models.VIMgrHostRuntime) (*models.VIMgrHostRuntime, error) {
	var robj *models.VIMgrHostRuntime
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIMgrHostRuntime object
func (client *VIMgrHostRuntimeClient) Update(obj *models.VIMgrHostRuntime) (*models.VIMgrHostRuntime, error) {
	var robj *models.VIMgrHostRuntime
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIMgrHostRuntime object with a given UUID
func (client *VIMgrHostRuntimeClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing VIMgrHostRuntime object with a given name
func (client *VIMgrHostRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
