package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	USERACCOUNTPROFILE_RES_NAME = "useraccountprofile"
)

// UserAccountProfileClient is a client for avi UserAccountProfile resource
type UserAccountProfileClient struct {
	avi_session *session.AviSession
}

// NewUserAccountProfileClient creates a new client for UserAccountProfile resource
func NewUserAccountProfileClient(avi_session *session.AviSession) *UserAccountProfileClient {
	return &UserAccountProfileClient{avi_session: avi_session}
}

func (client *UserAccountProfileClient) GetApiPath(uuid string) string {
	path := "api/" + USERACCOUNTPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of UserAccountProfile objects
func (client *UserAccountProfileClient) GetAll() ([]*models.UserAccountProfile, error) {
	var plist []*models.UserAccountProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing UserAccountProfile by uuid
func (client *UserAccountProfileClient) Get(uuid string) (*models.UserAccountProfile, error) {
	var obj *models.UserAccountProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing UserAccountProfile by name
func (client *UserAccountProfileClient) GetByName(name string) (*models.UserAccountProfile, error) {
	var obj *models.UserAccountProfile
	err := client.avi_session.GetObjectByName(USERACCOUNTPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new UserAccountProfile object
func (client *UserAccountProfileClient) Create(obj *models.UserAccountProfile) (*models.UserAccountProfile, error) {
	var robj *models.UserAccountProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing UserAccountProfile object
func (client *UserAccountProfileClient) Update(obj *models.UserAccountProfile) (*models.UserAccountProfile, error) {
	var robj *models.UserAccountProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing UserAccountProfile object with a given UUID
func (client *UserAccountProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing UserAccountProfile object with a given name
func (client *UserAccountProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
