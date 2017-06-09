package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VIMGRVCENTERRUNTIME_RES_NAME = "vimgrvcenterruntime"
)

// VIMgrVcenterRuntimeClient is a client for avi VIMgrVcenterRuntime resource
type VIMgrVcenterRuntimeClient struct {
	avi_session *session.AviSession
}

// NewVIMgrVcenterRuntimeClient creates a new client for VIMgrVcenterRuntime resource
func NewVIMgrVcenterRuntimeClient(avi_session *session.AviSession) *VIMgrVcenterRuntimeClient {
	return &VIMgrVcenterRuntimeClient{avi_session: avi_session}
}

func (client *VIMgrVcenterRuntimeClient) GetApiPath(uuid string) string {
	path := "api/" + VIMGRVCENTERRUNTIME_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIMgrVcenterRuntime objects
func (client *VIMgrVcenterRuntimeClient) GetAll() ([]*models.VIMgrVcenterRuntime, error) {
	var plist []*models.VIMgrVcenterRuntime
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VIMgrVcenterRuntime by uuid
func (client *VIMgrVcenterRuntimeClient) Get(uuid string) (*models.VIMgrVcenterRuntime, error) {
	var obj *models.VIMgrVcenterRuntime
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VIMgrVcenterRuntime by name
func (client *VIMgrVcenterRuntimeClient) GetByName(name string) (*models.VIMgrVcenterRuntime, error) {
	var obj *models.VIMgrVcenterRuntime
	err := client.avi_session.GetObjectByName(VIMGRVCENTERRUNTIME_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VIMgrVcenterRuntime object
func (client *VIMgrVcenterRuntimeClient) Create(obj *models.VIMgrVcenterRuntime) (*models.VIMgrVcenterRuntime, error) {
	var robj *models.VIMgrVcenterRuntime
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIMgrVcenterRuntime object
func (client *VIMgrVcenterRuntimeClient) Update(obj *models.VIMgrVcenterRuntime) (*models.VIMgrVcenterRuntime, error) {
	var robj *models.VIMgrVcenterRuntime
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIMgrVcenterRuntime object with a given UUID
func (client *VIMgrVcenterRuntimeClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VIMgrVcenterRuntime object with a given name
func (client *VIMgrVcenterRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
