package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VIMGRCONTROLLERRUNTIME_RES_NAME = "vimgrcontrollerruntime"
)

// VIMgrControllerRuntimeClient is a client for avi VIMgrControllerRuntime resource
type VIMgrControllerRuntimeClient struct {
	avi_session *session.AviSession
}

// NewVIMgrControllerRuntimeClient creates a new client for VIMgrControllerRuntime resource
func NewVIMgrControllerRuntimeClient(avi_session *session.AviSession) *VIMgrControllerRuntimeClient {
	return &VIMgrControllerRuntimeClient{avi_session: avi_session}
}

func (client *VIMgrControllerRuntimeClient) GetApiPath(uuid string) string {
	path := "api/" + VIMGRCONTROLLERRUNTIME_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIMgrControllerRuntime objects
func (client *VIMgrControllerRuntimeClient) GetAll() ([]*models.VIMgrControllerRuntime, error) {
	var plist []*models.VIMgrControllerRuntime
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VIMgrControllerRuntime by uuid
func (client *VIMgrControllerRuntimeClient) Get(uuid string) (*models.VIMgrControllerRuntime, error) {
	var obj *models.VIMgrControllerRuntime
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VIMgrControllerRuntime by name
func (client *VIMgrControllerRuntimeClient) GetByName(name string) (*models.VIMgrControllerRuntime, error) {
	var obj *models.VIMgrControllerRuntime
	err := client.avi_session.GetObjectByName(VIMGRCONTROLLERRUNTIME_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VIMgrControllerRuntime object
func (client *VIMgrControllerRuntimeClient) Create(obj *models.VIMgrControllerRuntime) (*models.VIMgrControllerRuntime, error) {
	var robj *models.VIMgrControllerRuntime
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIMgrControllerRuntime object
func (client *VIMgrControllerRuntimeClient) Update(obj *models.VIMgrControllerRuntime) (*models.VIMgrControllerRuntime, error) {
	var robj *models.VIMgrControllerRuntime
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIMgrControllerRuntime object with a given UUID
func (client *VIMgrControllerRuntimeClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VIMgrControllerRuntime object with a given name
func (client *VIMgrControllerRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
