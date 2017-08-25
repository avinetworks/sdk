package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// ServerAutoScalePolicyClient is a client for avi ServerAutoScalePolicy resource
type ServerAutoScalePolicyClient struct {
	aviSession *session.AviSession
}

// NewServerAutoScalePolicyClient creates a new client for ServerAutoScalePolicy resource
func NewServerAutoScalePolicyClient(aviSession *session.AviSession) *ServerAutoScalePolicyClient {
	return &ServerAutoScalePolicyClient{aviSession: aviSession}
}

func (client *ServerAutoScalePolicyClient) getAPIPath(uuid string) string {
	path := "api/serverautoscalepolicy"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of ServerAutoScalePolicy objects
func (client *ServerAutoScalePolicyClient) GetAll() ([]*models.ServerAutoScalePolicy, error) {
	var plist []*models.ServerAutoScalePolicy
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing ServerAutoScalePolicy by uuid
func (client *ServerAutoScalePolicyClient) Get(uuid string) (*models.ServerAutoScalePolicy, error) {
	var obj *models.ServerAutoScalePolicy
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing ServerAutoScalePolicy by name
func (client *ServerAutoScalePolicyClient) GetByName(name string) (*models.ServerAutoScalePolicy, error) {
	var obj *models.ServerAutoScalePolicy
	err := client.aviSession.GetObjectByName("serverautoscalepolicy", name, &obj)
	return obj, err
}

// Create a new ServerAutoScalePolicy object
func (client *ServerAutoScalePolicyClient) Create(obj *models.ServerAutoScalePolicy) (*models.ServerAutoScalePolicy, error) {
	var robj *models.ServerAutoScalePolicy
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing ServerAutoScalePolicy object
func (client *ServerAutoScalePolicyClient) Update(obj *models.ServerAutoScalePolicy) (*models.ServerAutoScalePolicy, error) {
	var robj *models.ServerAutoScalePolicy
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing ServerAutoScalePolicy object with a given UUID
func (client *ServerAutoScalePolicyClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing ServerAutoScalePolicy object with a given name
func (client *ServerAutoScalePolicyClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
