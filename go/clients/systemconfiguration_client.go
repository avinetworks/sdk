package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SYSTEMCONFIGURATION_RES_NAME = "systemconfiguration"
)

// SystemConfigurationClient is a client for avi SystemConfiguration resource
type SystemConfigurationClient struct {
	avi_session *session.AviSession
}

// NewSystemConfigurationClient creates a new client for SystemConfiguration resource
func NewSystemConfigurationClient(avi_session *session.AviSession) *SystemConfigurationClient {
	return &SystemConfigurationClient{avi_session: avi_session}
}

func (client *SystemConfigurationClient) GetApiPath(uuid string) string {
	path := "api/" + SYSTEMCONFIGURATION_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SystemConfiguration objects
func (client *SystemConfigurationClient) GetAll() ([]*models.SystemConfiguration, error) {
	var plist []*models.SystemConfiguration
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing SystemConfiguration by uuid
func (client *SystemConfigurationClient) Get(uuid string) (*models.SystemConfiguration, error) {
	var obj *models.SystemConfiguration
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing SystemConfiguration by name
func (client *SystemConfigurationClient) GetByName(name string) (*models.SystemConfiguration, error) {
	var obj *models.SystemConfiguration
	err := client.avi_session.GetObjectByName(SYSTEMCONFIGURATION_RES_NAME, name, &obj)
	return obj, err
}

// Create a new SystemConfiguration object
func (client *SystemConfigurationClient) Create(obj *models.SystemConfiguration) (*models.SystemConfiguration, error) {
	var robj *models.SystemConfiguration
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing SystemConfiguration object
func (client *SystemConfigurationClient) Update(obj *models.SystemConfiguration) (*models.SystemConfiguration, error) {
	var robj *models.SystemConfiguration
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SystemConfiguration object with a given UUID
func (client *SystemConfigurationClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing SystemConfiguration object with a given name
func (client *SystemConfigurationClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
