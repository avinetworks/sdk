package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VIMGRDCRUNTIME_RES_NAME = "vimgrdcruntime"
)

// VIMgrDCRuntimeClient is a client for avi VIMgrDCRuntime resource
type VIMgrDCRuntimeClient struct {
	avi_session *session.AviSession
}

// NewVIMgrDCRuntimeClient creates a new client for VIMgrDCRuntime resource
func NewVIMgrDCRuntimeClient(avi_session *session.AviSession) *VIMgrDCRuntimeClient {
	return &VIMgrDCRuntimeClient{avi_session: avi_session}
}

func (client *VIMgrDCRuntimeClient) GetApiPath(uuid string) string {
	path := "api/" + VIMGRDCRUNTIME_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIMgrDCRuntime objects
func (client *VIMgrDCRuntimeClient) GetAll() ([]*models.VIMgrDCRuntime, error) {
	var plist []*models.VIMgrDCRuntime
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VIMgrDCRuntime by uuid
func (client *VIMgrDCRuntimeClient) Get(uuid string) (*models.VIMgrDCRuntime, error) {
	var obj *models.VIMgrDCRuntime
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VIMgrDCRuntime by name
func (client *VIMgrDCRuntimeClient) GetByName(name string) (*models.VIMgrDCRuntime, error) {
	var obj *models.VIMgrDCRuntime
	err := client.avi_session.GetObjectByName(VIMGRDCRUNTIME_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VIMgrDCRuntime object
func (client *VIMgrDCRuntimeClient) Create(obj *models.VIMgrDCRuntime) (*models.VIMgrDCRuntime, error) {
	var robj *models.VIMgrDCRuntime
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIMgrDCRuntime object
func (client *VIMgrDCRuntimeClient) Update(obj *models.VIMgrDCRuntime) (*models.VIMgrDCRuntime, error) {
	var robj *models.VIMgrDCRuntime
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIMgrDCRuntime object with a given UUID
func (client *VIMgrDCRuntimeClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VIMgrDCRuntime object with a given name
func (client *VIMgrDCRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
