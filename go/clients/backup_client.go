package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	BACKUP_RES_NAME = "backup"
)

// BackupClient is a client for avi Backup resource
type BackupClient struct {
	avi_session *session.AviSession
}

// NewBackupClient creates a new client for Backup resource
func NewBackupClient(avi_session *session.AviSession) *BackupClient {
	return &BackupClient{avi_session: avi_session}
}

func (client *BackupClient) GetApiPath(uuid string) string {
	path := "api/" + BACKUP_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Backup objects
func (client *BackupClient) GetAll() ([]*models.Backup, error) {
	var plist []*models.Backup
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing Backup by uuid
func (client *BackupClient) Get(uuid string) (*models.Backup, error) {
	var obj *models.Backup
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing Backup by name
func (client *BackupClient) GetByName(name string) (*models.Backup, error) {
	var obj *models.Backup
	err := client.avi_session.GetObjectByName(BACKUP_RES_NAME, name, &obj)
	return obj, err
}

// Create a new Backup object
func (client *BackupClient) Create(obj *models.Backup) (*models.Backup, error) {
	var robj *models.Backup
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing Backup object
func (client *BackupClient) Update(obj *models.Backup) (*models.Backup, error) {
	var robj *models.Backup
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Backup object with a given UUID
func (client *BackupClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing Backup object with a given name
func (client *BackupClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
