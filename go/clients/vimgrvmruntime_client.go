package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VIMGRVMRUNTIME_RES_NAME = "vimgrvmruntime"
)

// VIMgrVMRuntimeClient is a client for avi VIMgrVMRuntime resource
type VIMgrVMRuntimeClient struct {
	avi_session *session.AviSession
}

// NewVIMgrVMRuntimeClient creates a new client for VIMgrVMRuntime resource
func NewVIMgrVMRuntimeClient(avi_session *session.AviSession) *VIMgrVMRuntimeClient {
	return &VIMgrVMRuntimeClient{avi_session: avi_session}
}

func (client *VIMgrVMRuntimeClient) GetApiPath(uuid string) string {
	path := "api/" + VIMGRVMRUNTIME_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIMgrVMRuntime objects
func (client *VIMgrVMRuntimeClient) GetAll() ([]*models.VIMgrVMRuntime, error) {
	var plist []*models.VIMgrVMRuntime
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VIMgrVMRuntime by uuid
func (client *VIMgrVMRuntimeClient) Get(uuid string) (*models.VIMgrVMRuntime, error) {
	var obj *models.VIMgrVMRuntime
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VIMgrVMRuntime by name
func (client *VIMgrVMRuntimeClient) GetByName(name string) (*models.VIMgrVMRuntime, error) {
	var obj *models.VIMgrVMRuntime
	err := client.avi_session.GetObjectByName(VIMGRVMRUNTIME_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VIMgrVMRuntime object
func (client *VIMgrVMRuntimeClient) Create(obj *models.VIMgrVMRuntime) (*models.VIMgrVMRuntime, error) {
	var robj *models.VIMgrVMRuntime
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIMgrVMRuntime object
func (client *VIMgrVMRuntimeClient) Update(obj *models.VIMgrVMRuntime) (*models.VIMgrVMRuntime, error) {
	var robj *models.VIMgrVMRuntime
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIMgrVMRuntime object with a given UUID
func (client *VIMgrVMRuntimeClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VIMgrVMRuntime object with a given name
func (client *VIMgrVMRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
