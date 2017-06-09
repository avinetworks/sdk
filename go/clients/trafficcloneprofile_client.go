package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	TRAFFICCLONEPROFILE_RES_NAME = "trafficcloneprofile"
)

// TrafficCloneProfileClient is a client for avi TrafficCloneProfile resource
type TrafficCloneProfileClient struct {
	avi_session *session.AviSession
}

// NewTrafficCloneProfileClient creates a new client for TrafficCloneProfile resource
func NewTrafficCloneProfileClient(avi_session *session.AviSession) *TrafficCloneProfileClient {
	return &TrafficCloneProfileClient{avi_session: avi_session}
}

func (client *TrafficCloneProfileClient) GetApiPath(uuid string) string {
	path := "api/" + TRAFFICCLONEPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of TrafficCloneProfile objects
func (client *TrafficCloneProfileClient) GetAll() ([]*models.TrafficCloneProfile, error) {
	var plist []*models.TrafficCloneProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing TrafficCloneProfile by uuid
func (client *TrafficCloneProfileClient) Get(uuid string) (*models.TrafficCloneProfile, error) {
	var obj *models.TrafficCloneProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing TrafficCloneProfile by name
func (client *TrafficCloneProfileClient) GetByName(name string) (*models.TrafficCloneProfile, error) {
	var obj *models.TrafficCloneProfile
	err := client.avi_session.GetObjectByName(TRAFFICCLONEPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new TrafficCloneProfile object
func (client *TrafficCloneProfileClient) Create(obj *models.TrafficCloneProfile) (*models.TrafficCloneProfile, error) {
	var robj *models.TrafficCloneProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing TrafficCloneProfile object
func (client *TrafficCloneProfileClient) Update(obj *models.TrafficCloneProfile) (*models.TrafficCloneProfile, error) {
	var robj *models.TrafficCloneProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing TrafficCloneProfile object with a given UUID
func (client *TrafficCloneProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing TrafficCloneProfile object with a given name
func (client *TrafficCloneProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
