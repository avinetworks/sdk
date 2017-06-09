package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VIMGRCLUSTERRUNTIME_RES_NAME = "vimgrclusterruntime"
)

// VIMgrClusterRuntimeClient is a client for avi VIMgrClusterRuntime resource
type VIMgrClusterRuntimeClient struct {
	avi_session *session.AviSession
}

// NewVIMgrClusterRuntimeClient creates a new client for VIMgrClusterRuntime resource
func NewVIMgrClusterRuntimeClient(avi_session *session.AviSession) *VIMgrClusterRuntimeClient {
	return &VIMgrClusterRuntimeClient{avi_session: avi_session}
}

func (client *VIMgrClusterRuntimeClient) GetApiPath(uuid string) string {
	path := "api/" + VIMGRCLUSTERRUNTIME_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIMgrClusterRuntime objects
func (client *VIMgrClusterRuntimeClient) GetAll() ([]*models.VIMgrClusterRuntime, error) {
	var plist []*models.VIMgrClusterRuntime
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VIMgrClusterRuntime by uuid
func (client *VIMgrClusterRuntimeClient) Get(uuid string) (*models.VIMgrClusterRuntime, error) {
	var obj *models.VIMgrClusterRuntime
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VIMgrClusterRuntime by name
func (client *VIMgrClusterRuntimeClient) GetByName(name string) (*models.VIMgrClusterRuntime, error) {
	var obj *models.VIMgrClusterRuntime
	err := client.avi_session.GetObjectByName(VIMGRCLUSTERRUNTIME_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VIMgrClusterRuntime object
func (client *VIMgrClusterRuntimeClient) Create(obj *models.VIMgrClusterRuntime) (*models.VIMgrClusterRuntime, error) {
	var robj *models.VIMgrClusterRuntime
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIMgrClusterRuntime object
func (client *VIMgrClusterRuntimeClient) Update(obj *models.VIMgrClusterRuntime) (*models.VIMgrClusterRuntime, error) {
	var robj *models.VIMgrClusterRuntime
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIMgrClusterRuntime object with a given UUID
func (client *VIMgrClusterRuntimeClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VIMgrClusterRuntime object with a given name
func (client *VIMgrClusterRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
