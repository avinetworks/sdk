package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VIMGRHOSTRUNTIME_RES_NAME = "vimgrhostruntime"
)

// VIMgrHostRuntimeClient is a client for avi VIMgrHostRuntime resource
type VIMgrHostRuntimeClient struct {
	avi_session *session.AviSession
}

// NewVIMgrHostRuntimeClient creates a new client for VIMgrHostRuntime resource
func NewVIMgrHostRuntimeClient(avi_session *session.AviSession) *VIMgrHostRuntimeClient {
	return &VIMgrHostRuntimeClient{avi_session: avi_session}
}

func (client *VIMgrHostRuntimeClient) GetApiPath(uuid string) string {
	path := "api/" + VIMGRHOSTRUNTIME_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIMgrHostRuntime objects
func (client *VIMgrHostRuntimeClient) GetAll() ([]*models.VIMgrHostRuntime, error) {
	var plist []*models.VIMgrHostRuntime
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VIMgrHostRuntime by uuid
func (client *VIMgrHostRuntimeClient) Get(uuid string) (*models.VIMgrHostRuntime, error) {
	var obj *models.VIMgrHostRuntime
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VIMgrHostRuntime by name
func (client *VIMgrHostRuntimeClient) GetByName(name string) (*models.VIMgrHostRuntime, error) {
	var obj *models.VIMgrHostRuntime
	err := client.avi_session.GetObjectByName(VIMGRHOSTRUNTIME_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VIMgrHostRuntime object
func (client *VIMgrHostRuntimeClient) Create(obj *models.VIMgrHostRuntime) (*models.VIMgrHostRuntime, error) {
	var robj *models.VIMgrHostRuntime
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIMgrHostRuntime object
func (client *VIMgrHostRuntimeClient) Update(obj *models.VIMgrHostRuntime) (*models.VIMgrHostRuntime, error) {
	var robj *models.VIMgrHostRuntime
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIMgrHostRuntime object with a given UUID
func (client *VIMgrHostRuntimeClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VIMgrHostRuntime object with a given name
func (client *VIMgrHostRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
