package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	ACTIONGROUPCONFIG_RES_NAME = "actiongroupconfig"
)

// ActionGroupConfigClient is a client for avi ActionGroupConfig resource
type ActionGroupConfigClient struct {
	avi_session *session.AviSession
}

// NewActionGroupConfigClient creates a new client for ActionGroupConfig resource
func NewActionGroupConfigClient(avi_session *session.AviSession) *ActionGroupConfigClient {
	return &ActionGroupConfigClient{avi_session: avi_session}
}

func (client *ActionGroupConfigClient) GetApiPath(uuid string) string {
	path := "api/" + ACTIONGROUPCONFIG_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of ActionGroupConfig objects
func (client *ActionGroupConfigClient) GetAll() ([]*models.ActionGroupConfig, error) {
	var plist []*models.ActionGroupConfig
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing ActionGroupConfig by uuid
func (client *ActionGroupConfigClient) Get(uuid string) (*models.ActionGroupConfig, error) {
	var obj *models.ActionGroupConfig
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing ActionGroupConfig by name
func (client *ActionGroupConfigClient) GetByName(name string) (*models.ActionGroupConfig, error) {
	var obj *models.ActionGroupConfig
	err := client.avi_session.GetObjectByName(ACTIONGROUPCONFIG_RES_NAME, name, &obj)
	return obj, err
}

// Create a new ActionGroupConfig object
func (client *ActionGroupConfigClient) Create(obj *models.ActionGroupConfig) (*models.ActionGroupConfig, error) {
	var robj *models.ActionGroupConfig
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing ActionGroupConfig object
func (client *ActionGroupConfigClient) Update(obj *models.ActionGroupConfig) (*models.ActionGroupConfig, error) {
	var robj *models.ActionGroupConfig
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing ActionGroupConfig object with a given UUID
func (client *ActionGroupConfigClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing ActionGroupConfig object with a given name
func (client *ActionGroupConfigClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
