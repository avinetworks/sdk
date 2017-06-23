package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// TrafficCloneProfileClient is a client for avi TrafficCloneProfile resource
type TrafficCloneProfileClient struct {
	aviSession *session.AviSession
}

// NewTrafficCloneProfileClient creates a new client for TrafficCloneProfile resource
func NewTrafficCloneProfileClient(aviSession *session.AviSession) *TrafficCloneProfileClient {
	return &TrafficCloneProfileClient{aviSession: aviSession}
}

func (client *TrafficCloneProfileClient) getAPIPath(uuid string) string {
	path := "api/trafficcloneprofile"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of TrafficCloneProfile objects
func (client *TrafficCloneProfileClient) GetAll() ([]*models.TrafficCloneProfile, error) {
	var plist []*models.TrafficCloneProfile
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing TrafficCloneProfile by uuid
func (client *TrafficCloneProfileClient) Get(uuid string) (*models.TrafficCloneProfile, error) {
	var obj *models.TrafficCloneProfile
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing TrafficCloneProfile by name
func (client *TrafficCloneProfileClient) GetByName(name string) (*models.TrafficCloneProfile, error) {
	var obj *models.TrafficCloneProfile
	err := client.aviSession.GetObjectByName("trafficcloneprofile", name, &obj)
	return obj, err
}

// Create a new TrafficCloneProfile object
func (client *TrafficCloneProfileClient) Create(obj *models.TrafficCloneProfile) (*models.TrafficCloneProfile, error) {
	var robj *models.TrafficCloneProfile
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing TrafficCloneProfile object
func (client *TrafficCloneProfileClient) Update(obj *models.TrafficCloneProfile) (*models.TrafficCloneProfile, error) {
	var robj *models.TrafficCloneProfile
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing TrafficCloneProfile object with a given UUID
func (client *TrafficCloneProfileClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing TrafficCloneProfile object with a given name
func (client *TrafficCloneProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
