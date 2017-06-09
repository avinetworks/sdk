package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	GSLBAPPLICATIONPERSISTENCEPROFILE_RES_NAME = "gslbapplicationpersistenceprofile"
)

// GslbApplicationPersistenceProfileClient is a client for avi GslbApplicationPersistenceProfile resource
type GslbApplicationPersistenceProfileClient struct {
	avi_session *session.AviSession
}

// NewGslbApplicationPersistenceProfileClient creates a new client for GslbApplicationPersistenceProfile resource
func NewGslbApplicationPersistenceProfileClient(avi_session *session.AviSession) *GslbApplicationPersistenceProfileClient {
	return &GslbApplicationPersistenceProfileClient{avi_session: avi_session}
}

func (client *GslbApplicationPersistenceProfileClient) GetApiPath(uuid string) string {
	path := "api/" + GSLBAPPLICATIONPERSISTENCEPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of GslbApplicationPersistenceProfile objects
func (client *GslbApplicationPersistenceProfileClient) GetAll() ([]*models.GslbApplicationPersistenceProfile, error) {
	var plist []*models.GslbApplicationPersistenceProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing GslbApplicationPersistenceProfile by uuid
func (client *GslbApplicationPersistenceProfileClient) Get(uuid string) (*models.GslbApplicationPersistenceProfile, error) {
	var obj *models.GslbApplicationPersistenceProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing GslbApplicationPersistenceProfile by name
func (client *GslbApplicationPersistenceProfileClient) GetByName(name string) (*models.GslbApplicationPersistenceProfile, error) {
	var obj *models.GslbApplicationPersistenceProfile
	err := client.avi_session.GetObjectByName(GSLBAPPLICATIONPERSISTENCEPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new GslbApplicationPersistenceProfile object
func (client *GslbApplicationPersistenceProfileClient) Create(obj *models.GslbApplicationPersistenceProfile) (*models.GslbApplicationPersistenceProfile, error) {
	var robj *models.GslbApplicationPersistenceProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing GslbApplicationPersistenceProfile object
func (client *GslbApplicationPersistenceProfileClient) Update(obj *models.GslbApplicationPersistenceProfile) (*models.GslbApplicationPersistenceProfile, error) {
	var robj *models.GslbApplicationPersistenceProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing GslbApplicationPersistenceProfile object with a given UUID
func (client *GslbApplicationPersistenceProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing GslbApplicationPersistenceProfile object with a given name
func (client *GslbApplicationPersistenceProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
