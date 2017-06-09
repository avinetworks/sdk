package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	APPLICATIONPERSISTENCEPROFILE_RES_NAME = "applicationpersistenceprofile"
)

// ApplicationPersistenceProfileClient is a client for avi ApplicationPersistenceProfile resource
type ApplicationPersistenceProfileClient struct {
	avi_session *session.AviSession
}

// NewApplicationPersistenceProfileClient creates a new client for ApplicationPersistenceProfile resource
func NewApplicationPersistenceProfileClient(avi_session *session.AviSession) *ApplicationPersistenceProfileClient {
	return &ApplicationPersistenceProfileClient{avi_session: avi_session}
}

func (client *ApplicationPersistenceProfileClient) GetApiPath(uuid string) string {
	path := "api/" + APPLICATIONPERSISTENCEPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of ApplicationPersistenceProfile objects
func (client *ApplicationPersistenceProfileClient) GetAll() ([]*models.ApplicationPersistenceProfile, error) {
	var plist []*models.ApplicationPersistenceProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing ApplicationPersistenceProfile by uuid
func (client *ApplicationPersistenceProfileClient) Get(uuid string) (*models.ApplicationPersistenceProfile, error) {
	var obj *models.ApplicationPersistenceProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing ApplicationPersistenceProfile by name
func (client *ApplicationPersistenceProfileClient) GetByName(name string) (*models.ApplicationPersistenceProfile, error) {
	var obj *models.ApplicationPersistenceProfile
	err := client.avi_session.GetObjectByName(APPLICATIONPERSISTENCEPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new ApplicationPersistenceProfile object
func (client *ApplicationPersistenceProfileClient) Create(obj *models.ApplicationPersistenceProfile) (*models.ApplicationPersistenceProfile, error) {
	var robj *models.ApplicationPersistenceProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing ApplicationPersistenceProfile object
func (client *ApplicationPersistenceProfileClient) Update(obj *models.ApplicationPersistenceProfile) (*models.ApplicationPersistenceProfile, error) {
	var robj *models.ApplicationPersistenceProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing ApplicationPersistenceProfile object with a given UUID
func (client *ApplicationPersistenceProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing ApplicationPersistenceProfile object with a given name
func (client *ApplicationPersistenceProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
