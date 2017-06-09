package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	APPLICATIONPROFILE_RES_NAME = "applicationprofile"
)

// ApplicationProfileClient is a client for avi ApplicationProfile resource
type ApplicationProfileClient struct {
	avi_session *session.AviSession
}

// NewApplicationProfileClient creates a new client for ApplicationProfile resource
func NewApplicationProfileClient(avi_session *session.AviSession) *ApplicationProfileClient {
	return &ApplicationProfileClient{avi_session: avi_session}
}

func (client *ApplicationProfileClient) GetApiPath(uuid string) string {
	path := "api/" + APPLICATIONPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of ApplicationProfile objects
func (client *ApplicationProfileClient) GetAll() ([]*models.ApplicationProfile, error) {
	var plist []*models.ApplicationProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing ApplicationProfile by uuid
func (client *ApplicationProfileClient) Get(uuid string) (*models.ApplicationProfile, error) {
	var obj *models.ApplicationProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing ApplicationProfile by name
func (client *ApplicationProfileClient) GetByName(name string) (*models.ApplicationProfile, error) {
	var obj *models.ApplicationProfile
	err := client.avi_session.GetObjectByName(APPLICATIONPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new ApplicationProfile object
func (client *ApplicationProfileClient) Create(obj *models.ApplicationProfile) (*models.ApplicationProfile, error) {
	var robj *models.ApplicationProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing ApplicationProfile object
func (client *ApplicationProfileClient) Update(obj *models.ApplicationProfile) (*models.ApplicationProfile, error) {
	var robj *models.ApplicationProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing ApplicationProfile object with a given UUID
func (client *ApplicationProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing ApplicationProfile object with a given name
func (client *ApplicationProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
