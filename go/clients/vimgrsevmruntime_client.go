package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VIMGRSEVMRUNTIME_RES_NAME = "vimgrsevmruntime"
)

// VIMgrSEVMRuntimeClient is a client for avi VIMgrSEVMRuntime resource
type VIMgrSEVMRuntimeClient struct {
	avi_session *session.AviSession
}

// NewVIMgrSEVMRuntimeClient creates a new client for VIMgrSEVMRuntime resource
func NewVIMgrSEVMRuntimeClient(avi_session *session.AviSession) *VIMgrSEVMRuntimeClient {
	return &VIMgrSEVMRuntimeClient{avi_session: avi_session}
}

func (client *VIMgrSEVMRuntimeClient) GetApiPath(uuid string) string {
	path := "api/" + VIMGRSEVMRUNTIME_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIMgrSEVMRuntime objects
func (client *VIMgrSEVMRuntimeClient) GetAll() ([]*models.VIMgrSEVMRuntime, error) {
	var plist []*models.VIMgrSEVMRuntime
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VIMgrSEVMRuntime by uuid
func (client *VIMgrSEVMRuntimeClient) Get(uuid string) (*models.VIMgrSEVMRuntime, error) {
	var obj *models.VIMgrSEVMRuntime
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VIMgrSEVMRuntime by name
func (client *VIMgrSEVMRuntimeClient) GetByName(name string) (*models.VIMgrSEVMRuntime, error) {
	var obj *models.VIMgrSEVMRuntime
	err := client.avi_session.GetObjectByName(VIMGRSEVMRUNTIME_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VIMgrSEVMRuntime object
func (client *VIMgrSEVMRuntimeClient) Create(obj *models.VIMgrSEVMRuntime) (*models.VIMgrSEVMRuntime, error) {
	var robj *models.VIMgrSEVMRuntime
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIMgrSEVMRuntime object
func (client *VIMgrSEVMRuntimeClient) Update(obj *models.VIMgrSEVMRuntime) (*models.VIMgrSEVMRuntime, error) {
	var robj *models.VIMgrSEVMRuntime
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIMgrSEVMRuntime object with a given UUID
func (client *VIMgrSEVMRuntimeClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VIMgrSEVMRuntime object with a given name
func (client *VIMgrSEVMRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
