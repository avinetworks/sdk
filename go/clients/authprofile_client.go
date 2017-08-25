package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// AuthProfileClient is a client for avi AuthProfile resource
type AuthProfileClient struct {
	aviSession *session.AviSession
}

// NewAuthProfileClient creates a new client for AuthProfile resource
func NewAuthProfileClient(aviSession *session.AviSession) *AuthProfileClient {
	return &AuthProfileClient{aviSession: aviSession}
}

func (client *AuthProfileClient) getAPIPath(uuid string) string {
	path := "api/authprofile"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of AuthProfile objects
func (client *AuthProfileClient) GetAll() ([]*models.AuthProfile, error) {
	var plist []*models.AuthProfile
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing AuthProfile by uuid
func (client *AuthProfileClient) Get(uuid string) (*models.AuthProfile, error) {
	var obj *models.AuthProfile
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing AuthProfile by name
func (client *AuthProfileClient) GetByName(name string) (*models.AuthProfile, error) {
	var obj *models.AuthProfile
	err := client.aviSession.GetObjectByName("authprofile", name, &obj)
	return obj, err
}

// Create a new AuthProfile object
func (client *AuthProfileClient) Create(obj *models.AuthProfile) (*models.AuthProfile, error) {
	var robj *models.AuthProfile
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing AuthProfile object
func (client *AuthProfileClient) Update(obj *models.AuthProfile) (*models.AuthProfile, error) {
	var robj *models.AuthProfile
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing AuthProfile object with a given UUID
func (client *AuthProfileClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing AuthProfile object with a given name
func (client *AuthProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
