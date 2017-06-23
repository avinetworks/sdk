package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// UserActivityClient is a client for avi UserActivity resource
type UserActivityClient struct {
	aviSession *session.AviSession
}

// NewUserActivityClient creates a new client for UserActivity resource
func NewUserActivityClient(aviSession *session.AviSession) *UserActivityClient {
	return &UserActivityClient{aviSession: aviSession}
}

func (client *UserActivityClient) getAPIPath(uuid string) string {
	path := "api/useractivity"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of UserActivity objects
func (client *UserActivityClient) GetAll() ([]*models.UserActivity, error) {
	var plist []*models.UserActivity
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing UserActivity by uuid
func (client *UserActivityClient) Get(uuid string) (*models.UserActivity, error) {
	var obj *models.UserActivity
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing UserActivity by name
func (client *UserActivityClient) GetByName(name string) (*models.UserActivity, error) {
	var obj *models.UserActivity
	err := client.aviSession.GetObjectByName("useractivity", name, &obj)
	return obj, err
}

// Create a new UserActivity object
func (client *UserActivityClient) Create(obj *models.UserActivity) (*models.UserActivity, error) {
	var robj *models.UserActivity
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing UserActivity object
func (client *UserActivityClient) Update(obj *models.UserActivity) (*models.UserActivity, error) {
	var robj *models.UserActivity
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing UserActivity object with a given UUID
func (client *UserActivityClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing UserActivity object with a given name
func (client *UserActivityClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
