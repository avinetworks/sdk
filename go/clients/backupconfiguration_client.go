package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	BACKUPCONFIGURATION_RES_NAME = "backupconfiguration"
)

// BackupConfigurationClient is a client for avi BackupConfiguration resource
type BackupConfigurationClient struct {
	avi_session *session.AviSession
}

// NewBackupConfigurationClient creates a new client for BackupConfiguration resource
func NewBackupConfigurationClient(avi_session *session.AviSession) *BackupConfigurationClient {
	return &BackupConfigurationClient{avi_session: avi_session}
}

func (client *BackupConfigurationClient) GetApiPath(uuid string) string {
	path := "api/" + BACKUPCONFIGURATION_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of BackupConfiguration objects
func (client *BackupConfigurationClient) GetAll() ([]*models.BackupConfiguration, error) {
	var plist []*models.BackupConfiguration
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing BackupConfiguration by uuid
func (client *BackupConfigurationClient) Get(uuid string) (*models.BackupConfiguration, error) {
	var obj *models.BackupConfiguration
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing BackupConfiguration by name
func (client *BackupConfigurationClient) GetByName(name string) (*models.BackupConfiguration, error) {
	var obj *models.BackupConfiguration
	err := client.avi_session.GetObjectByName(BACKUPCONFIGURATION_RES_NAME, name, &obj)
	return obj, err
}

// Create a new BackupConfiguration object
func (client *BackupConfigurationClient) Create(obj *models.BackupConfiguration) (*models.BackupConfiguration, error) {
	var robj *models.BackupConfiguration
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing BackupConfiguration object
func (client *BackupConfigurationClient) Update(obj *models.BackupConfiguration) (*models.BackupConfiguration, error) {
	var robj *models.BackupConfiguration
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing BackupConfiguration object with a given UUID
func (client *BackupConfigurationClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing BackupConfiguration object with a given name
func (client *BackupConfigurationClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
