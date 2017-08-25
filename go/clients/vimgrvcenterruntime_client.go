package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// VIMgrVcenterRuntimeClient is a client for avi VIMgrVcenterRuntime resource
type VIMgrVcenterRuntimeClient struct {
	aviSession *session.AviSession
}

// NewVIMgrVcenterRuntimeClient creates a new client for VIMgrVcenterRuntime resource
func NewVIMgrVcenterRuntimeClient(aviSession *session.AviSession) *VIMgrVcenterRuntimeClient {
	return &VIMgrVcenterRuntimeClient{aviSession: aviSession}
}

func (client *VIMgrVcenterRuntimeClient) getAPIPath(uuid string) string {
	path := "api/vimgrvcenterruntime"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIMgrVcenterRuntime objects
func (client *VIMgrVcenterRuntimeClient) GetAll() ([]*models.VIMgrVcenterRuntime, error) {
	var plist []*models.VIMgrVcenterRuntime
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing VIMgrVcenterRuntime by uuid
func (client *VIMgrVcenterRuntimeClient) Get(uuid string) (*models.VIMgrVcenterRuntime, error) {
	var obj *models.VIMgrVcenterRuntime
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing VIMgrVcenterRuntime by name
func (client *VIMgrVcenterRuntimeClient) GetByName(name string) (*models.VIMgrVcenterRuntime, error) {
	var obj *models.VIMgrVcenterRuntime
	err := client.aviSession.GetObjectByName("vimgrvcenterruntime", name, &obj)
	return obj, err
}

// Create a new VIMgrVcenterRuntime object
func (client *VIMgrVcenterRuntimeClient) Create(obj *models.VIMgrVcenterRuntime) (*models.VIMgrVcenterRuntime, error) {
	var robj *models.VIMgrVcenterRuntime
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIMgrVcenterRuntime object
func (client *VIMgrVcenterRuntimeClient) Update(obj *models.VIMgrVcenterRuntime) (*models.VIMgrVcenterRuntime, error) {
	var robj *models.VIMgrVcenterRuntime
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIMgrVcenterRuntime object with a given UUID
func (client *VIMgrVcenterRuntimeClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing VIMgrVcenterRuntime object with a given name
func (client *VIMgrVcenterRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
