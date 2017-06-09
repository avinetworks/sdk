package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	GSLBGEODBPROFILE_RES_NAME = "gslbgeodbprofile"
)

// GslbGeoDbProfileClient is a client for avi GslbGeoDbProfile resource
type GslbGeoDbProfileClient struct {
	avi_session *session.AviSession
}

// NewGslbGeoDbProfileClient creates a new client for GslbGeoDbProfile resource
func NewGslbGeoDbProfileClient(avi_session *session.AviSession) *GslbGeoDbProfileClient {
	return &GslbGeoDbProfileClient{avi_session: avi_session}
}

func (client *GslbGeoDbProfileClient) GetApiPath(uuid string) string {
	path := "api/" + GSLBGEODBPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of GslbGeoDbProfile objects
func (client *GslbGeoDbProfileClient) GetAll() ([]*models.GslbGeoDbProfile, error) {
	var plist []*models.GslbGeoDbProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing GslbGeoDbProfile by uuid
func (client *GslbGeoDbProfileClient) Get(uuid string) (*models.GslbGeoDbProfile, error) {
	var obj *models.GslbGeoDbProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing GslbGeoDbProfile by name
func (client *GslbGeoDbProfileClient) GetByName(name string) (*models.GslbGeoDbProfile, error) {
	var obj *models.GslbGeoDbProfile
	err := client.avi_session.GetObjectByName(GSLBGEODBPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new GslbGeoDbProfile object
func (client *GslbGeoDbProfileClient) Create(obj *models.GslbGeoDbProfile) (*models.GslbGeoDbProfile, error) {
	var robj *models.GslbGeoDbProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing GslbGeoDbProfile object
func (client *GslbGeoDbProfileClient) Update(obj *models.GslbGeoDbProfile) (*models.GslbGeoDbProfile, error) {
	var robj *models.GslbGeoDbProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing GslbGeoDbProfile object with a given UUID
func (client *GslbGeoDbProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing GslbGeoDbProfile object with a given name
func (client *GslbGeoDbProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
