package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SERVERAUTOSCALEPOLICY_RES_NAME = "serverautoscalepolicy"
)

// ServerAutoScalePolicyClient is a client for avi ServerAutoScalePolicy resource
type ServerAutoScalePolicyClient struct {
	avi_session *session.AviSession
}

// NewServerAutoScalePolicyClient creates a new client for ServerAutoScalePolicy resource
func NewServerAutoScalePolicyClient(avi_session *session.AviSession) *ServerAutoScalePolicyClient {
	return &ServerAutoScalePolicyClient{avi_session: avi_session}
}

func (client *ServerAutoScalePolicyClient) GetApiPath(uuid string) string {
	path := "api/" + SERVERAUTOSCALEPOLICY_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of ServerAutoScalePolicy objects
func (client *ServerAutoScalePolicyClient) GetAll() ([]*models.ServerAutoScalePolicy, error) {
	var plist []*models.ServerAutoScalePolicy
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing ServerAutoScalePolicy by uuid
func (client *ServerAutoScalePolicyClient) Get(uuid string) (*models.ServerAutoScalePolicy, error) {
	var obj *models.ServerAutoScalePolicy
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing ServerAutoScalePolicy by name
func (client *ServerAutoScalePolicyClient) GetByName(name string) (*models.ServerAutoScalePolicy, error) {
	var obj *models.ServerAutoScalePolicy
	err := client.avi_session.GetObjectByName(SERVERAUTOSCALEPOLICY_RES_NAME, name, &obj)
	return obj, err
}

// Create a new ServerAutoScalePolicy object
func (client *ServerAutoScalePolicyClient) Create(obj *models.ServerAutoScalePolicy) (*models.ServerAutoScalePolicy, error) {
	var robj *models.ServerAutoScalePolicy
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing ServerAutoScalePolicy object
func (client *ServerAutoScalePolicyClient) Update(obj *models.ServerAutoScalePolicy) (*models.ServerAutoScalePolicy, error) {
	var robj *models.ServerAutoScalePolicy
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing ServerAutoScalePolicy object with a given UUID
func (client *ServerAutoScalePolicyClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing ServerAutoScalePolicy object with a given name
func (client *ServerAutoScalePolicyClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
