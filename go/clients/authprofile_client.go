package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	AUTHPROFILE_RES_NAME = "authprofile"
)

// AuthProfileClient is a client for avi AuthProfile resource
type AuthProfileClient struct {
	avi_session *session.AviSession
}

// NewAuthProfileClient creates a new client for AuthProfile resource
func NewAuthProfileClient(avi_session *session.AviSession) *AuthProfileClient {
	return &AuthProfileClient{avi_session: avi_session}
}

func (client *AuthProfileClient) GetApiPath(uuid string) string {
	path := "api/" + AUTHPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of AuthProfile objects
func (client *AuthProfileClient) GetAll() ([]*models.AuthProfile, error) {
	var plist []*models.AuthProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing AuthProfile by uuid
func (client *AuthProfileClient) Get(uuid string) (*models.AuthProfile, error) {
	var obj *models.AuthProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing AuthProfile by name
func (client *AuthProfileClient) GetByName(name string) (*models.AuthProfile, error) {
	var obj *models.AuthProfile
	err := client.avi_session.GetObjectByName(AUTHPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new AuthProfile object
func (client *AuthProfileClient) Create(obj *models.AuthProfile) (*models.AuthProfile, error) {
	var robj *models.AuthProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing AuthProfile object
func (client *AuthProfileClient) Update(obj *models.AuthProfile) (*models.AuthProfile, error) {
	var robj *models.AuthProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing AuthProfile object with a given UUID
func (client *AuthProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing AuthProfile object with a given name
func (client *AuthProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
