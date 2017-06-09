package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	CLOUD_RES_NAME = "cloud"
)

// CloudClient is a client for avi Cloud resource
type CloudClient struct {
	avi_session *session.AviSession
}

// NewCloudClient creates a new client for Cloud resource
func NewCloudClient(avi_session *session.AviSession) *CloudClient {
	return &CloudClient{avi_session: avi_session}
}

func (client *CloudClient) GetApiPath(uuid string) string {
	path := "api/" + CLOUD_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Cloud objects
func (client *CloudClient) GetAll() ([]*models.Cloud, error) {
	var plist []*models.Cloud
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing Cloud by uuid
func (client *CloudClient) Get(uuid string) (*models.Cloud, error) {
	var obj *models.Cloud
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing Cloud by name
func (client *CloudClient) GetByName(name string) (*models.Cloud, error) {
	var obj *models.Cloud
	err := client.avi_session.GetObjectByName(CLOUD_RES_NAME, name, &obj)
	return obj, err
}

// Create a new Cloud object
func (client *CloudClient) Create(obj *models.Cloud) (*models.Cloud, error) {
	var robj *models.Cloud
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing Cloud object
func (client *CloudClient) Update(obj *models.Cloud) (*models.Cloud, error) {
	var robj *models.Cloud
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Cloud object with a given UUID
func (client *CloudClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing Cloud object with a given name
func (client *CloudClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
