package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// SystemConfigurationClient is a client for avi SystemConfiguration resource
type SystemConfigurationClient struct {
	aviSession *session.AviSession
}

// NewSystemConfigurationClient creates a new client for SystemConfiguration resource
func NewSystemConfigurationClient(aviSession *session.AviSession) *SystemConfigurationClient {
	return &SystemConfigurationClient{aviSession: aviSession}
}

func (client *SystemConfigurationClient) getAPIPath(uuid string) string {
	path := "api/systemconfiguration"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SystemConfiguration objects
func (client *SystemConfigurationClient) GetAll() ([]*models.SystemConfiguration, error) {
	var plist []*models.SystemConfiguration
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing SystemConfiguration by uuid
func (client *SystemConfigurationClient) Get(uuid string) (*models.SystemConfiguration, error) {
	var obj *models.SystemConfiguration
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing SystemConfiguration by name
func (client *SystemConfigurationClient) GetByName(name string) (*models.SystemConfiguration, error) {
	var obj *models.SystemConfiguration
	err := client.aviSession.GetObjectByName("systemconfiguration", name, &obj)
	return obj, err
}

// Create a new SystemConfiguration object
func (client *SystemConfigurationClient) Create(obj *models.SystemConfiguration) (*models.SystemConfiguration, error) {
	var robj *models.SystemConfiguration
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing SystemConfiguration object
func (client *SystemConfigurationClient) Update(obj *models.SystemConfiguration) (*models.SystemConfiguration, error) {
	var robj *models.SystemConfiguration
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SystemConfiguration object with a given UUID
func (client *SystemConfigurationClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing SystemConfiguration object with a given name
func (client *SystemConfigurationClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
