package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VRFCONTEXT_RES_NAME = "vrfcontext"
)

// VrfContextClient is a client for avi VrfContext resource
type VrfContextClient struct {
	avi_session *session.AviSession
}

// NewVrfContextClient creates a new client for VrfContext resource
func NewVrfContextClient(avi_session *session.AviSession) *VrfContextClient {
	return &VrfContextClient{avi_session: avi_session}
}

func (client *VrfContextClient) GetApiPath(uuid string) string {
	path := "api/" + VRFCONTEXT_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VrfContext objects
func (client *VrfContextClient) GetAll() ([]*models.VrfContext, error) {
	var plist []*models.VrfContext
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VrfContext by uuid
func (client *VrfContextClient) Get(uuid string) (*models.VrfContext, error) {
	var obj *models.VrfContext
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VrfContext by name
func (client *VrfContextClient) GetByName(name string) (*models.VrfContext, error) {
	var obj *models.VrfContext
	err := client.avi_session.GetObjectByName(VRFCONTEXT_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VrfContext object
func (client *VrfContextClient) Create(obj *models.VrfContext) (*models.VrfContext, error) {
	var robj *models.VrfContext
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VrfContext object
func (client *VrfContextClient) Update(obj *models.VrfContext) (*models.VrfContext, error) {
	var robj *models.VrfContext
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VrfContext object with a given UUID
func (client *VrfContextClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VrfContext object with a given name
func (client *VrfContextClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
