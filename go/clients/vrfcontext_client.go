package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// VrfContextClient is a client for avi VrfContext resource
type VrfContextClient struct {
	aviSession *session.AviSession
}

// NewVrfContextClient creates a new client for VrfContext resource
func NewVrfContextClient(aviSession *session.AviSession) *VrfContextClient {
	return &VrfContextClient{aviSession: aviSession}
}

func (client *VrfContextClient) getAPIPath(uuid string) string {
	path := "api/vrfcontext"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VrfContext objects
func (client *VrfContextClient) GetAll() ([]*models.VrfContext, error) {
	var plist []*models.VrfContext
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing VrfContext by uuid
func (client *VrfContextClient) Get(uuid string) (*models.VrfContext, error) {
	var obj *models.VrfContext
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing VrfContext by name
func (client *VrfContextClient) GetByName(name string) (*models.VrfContext, error) {
	var obj *models.VrfContext
	err := client.aviSession.GetObjectByName("vrfcontext", name, &obj)
	return obj, err
}

// Create a new VrfContext object
func (client *VrfContextClient) Create(obj *models.VrfContext) (*models.VrfContext, error) {
	var robj *models.VrfContext
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing VrfContext object
func (client *VrfContextClient) Update(obj *models.VrfContext) (*models.VrfContext, error) {
	var robj *models.VrfContext
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VrfContext object with a given UUID
func (client *VrfContextClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing VrfContext object with a given name
func (client *VrfContextClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
