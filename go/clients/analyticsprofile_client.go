package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	ANALYTICSPROFILE_RES_NAME = "analyticsprofile"
)

// AnalyticsProfileClient is a client for avi AnalyticsProfile resource
type AnalyticsProfileClient struct {
	avi_session *session.AviSession
}

// NewAnalyticsProfileClient creates a new client for AnalyticsProfile resource
func NewAnalyticsProfileClient(avi_session *session.AviSession) *AnalyticsProfileClient {
	return &AnalyticsProfileClient{avi_session: avi_session}
}

func (client *AnalyticsProfileClient) GetApiPath(uuid string) string {
	path := "api/" + ANALYTICSPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of AnalyticsProfile objects
func (client *AnalyticsProfileClient) GetAll() ([]*models.AnalyticsProfile, error) {
	var plist []*models.AnalyticsProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing AnalyticsProfile by uuid
func (client *AnalyticsProfileClient) Get(uuid string) (*models.AnalyticsProfile, error) {
	var obj *models.AnalyticsProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing AnalyticsProfile by name
func (client *AnalyticsProfileClient) GetByName(name string) (*models.AnalyticsProfile, error) {
	var obj *models.AnalyticsProfile
	err := client.avi_session.GetObjectByName(ANALYTICSPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new AnalyticsProfile object
func (client *AnalyticsProfileClient) Create(obj *models.AnalyticsProfile) (*models.AnalyticsProfile, error) {
	var robj *models.AnalyticsProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing AnalyticsProfile object
func (client *AnalyticsProfileClient) Update(obj *models.AnalyticsProfile) (*models.AnalyticsProfile, error) {
	var robj *models.AnalyticsProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing AnalyticsProfile object with a given UUID
func (client *AnalyticsProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing AnalyticsProfile object with a given name
func (client *AnalyticsProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
