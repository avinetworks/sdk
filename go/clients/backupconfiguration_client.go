package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// BackupConfigurationClient is a client for avi BackupConfiguration resource
type BackupConfigurationClient struct {
	aviSession *session.AviSession
}

// NewBackupConfigurationClient creates a new client for BackupConfiguration resource
func NewBackupConfigurationClient(aviSession *session.AviSession) *BackupConfigurationClient {
	return &BackupConfigurationClient{aviSession: aviSession}
}

func (client *BackupConfigurationClient) getAPIPath(uuid string) string {
	path := "api/backupconfiguration"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of BackupConfiguration objects
func (client *BackupConfigurationClient) GetAll() ([]*models.BackupConfiguration, error) {
	var plist []*models.BackupConfiguration
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing BackupConfiguration by uuid
func (client *BackupConfigurationClient) Get(uuid string) (*models.BackupConfiguration, error) {
	var obj *models.BackupConfiguration
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing BackupConfiguration by name
func (client *BackupConfigurationClient) GetByName(name string) (*models.BackupConfiguration, error) {
	var obj *models.BackupConfiguration
	err := client.aviSession.GetObjectByName("backupconfiguration", name, &obj)
	return obj, err
}

// Create a new BackupConfiguration object
func (client *BackupConfigurationClient) Create(obj *models.BackupConfiguration) (*models.BackupConfiguration, error) {
	var robj *models.BackupConfiguration
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing BackupConfiguration object
func (client *BackupConfigurationClient) Update(obj *models.BackupConfiguration) (*models.BackupConfiguration, error) {
	var robj *models.BackupConfiguration
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing BackupConfiguration object with a given UUID
func (client *BackupConfigurationClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing BackupConfiguration object with a given name
func (client *BackupConfigurationClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
