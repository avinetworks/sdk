package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VIMGRNWRUNTIME_RES_NAME = "vimgrnwruntime"
)

// VIMgrNWRuntimeClient is a client for avi VIMgrNWRuntime resource
type VIMgrNWRuntimeClient struct {
	avi_session *session.AviSession
}

// NewVIMgrNWRuntimeClient creates a new client for VIMgrNWRuntime resource
func NewVIMgrNWRuntimeClient(avi_session *session.AviSession) *VIMgrNWRuntimeClient {
	return &VIMgrNWRuntimeClient{avi_session: avi_session}
}

func (client *VIMgrNWRuntimeClient) GetApiPath(uuid string) string {
	path := "api/" + VIMGRNWRUNTIME_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIMgrNWRuntime objects
func (client *VIMgrNWRuntimeClient) GetAll() ([]*models.VIMgrNWRuntime, error) {
	var plist []*models.VIMgrNWRuntime
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VIMgrNWRuntime by uuid
func (client *VIMgrNWRuntimeClient) Get(uuid string) (*models.VIMgrNWRuntime, error) {
	var obj *models.VIMgrNWRuntime
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VIMgrNWRuntime by name
func (client *VIMgrNWRuntimeClient) GetByName(name string) (*models.VIMgrNWRuntime, error) {
	var obj *models.VIMgrNWRuntime
	err := client.avi_session.GetObjectByName(VIMGRNWRUNTIME_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VIMgrNWRuntime object
func (client *VIMgrNWRuntimeClient) Create(obj *models.VIMgrNWRuntime) (*models.VIMgrNWRuntime, error) {
	var robj *models.VIMgrNWRuntime
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIMgrNWRuntime object
func (client *VIMgrNWRuntimeClient) Update(obj *models.VIMgrNWRuntime) (*models.VIMgrNWRuntime, error) {
	var robj *models.VIMgrNWRuntime
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIMgrNWRuntime object with a given UUID
func (client *VIMgrNWRuntimeClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VIMgrNWRuntime object with a given name
func (client *VIMgrNWRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
