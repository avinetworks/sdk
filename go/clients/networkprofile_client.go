package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	NETWORKPROFILE_RES_NAME = "networkprofile"
)

// NetworkProfileClient is a client for avi NetworkProfile resource
type NetworkProfileClient struct {
	avi_session *session.AviSession
}

// NewNetworkProfileClient creates a new client for NetworkProfile resource
func NewNetworkProfileClient(avi_session *session.AviSession) *NetworkProfileClient {
	return &NetworkProfileClient{avi_session: avi_session}
}

func (client *NetworkProfileClient) GetApiPath(uuid string) string {
	path := "api/" + NETWORKPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of NetworkProfile objects
func (client *NetworkProfileClient) GetAll() ([]*models.NetworkProfile, error) {
	var plist []*models.NetworkProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing NetworkProfile by uuid
func (client *NetworkProfileClient) Get(uuid string) (*models.NetworkProfile, error) {
	var obj *models.NetworkProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing NetworkProfile by name
func (client *NetworkProfileClient) GetByName(name string) (*models.NetworkProfile, error) {
	var obj *models.NetworkProfile
	err := client.avi_session.GetObjectByName(NETWORKPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new NetworkProfile object
func (client *NetworkProfileClient) Create(obj *models.NetworkProfile) (*models.NetworkProfile, error) {
	var robj *models.NetworkProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing NetworkProfile object
func (client *NetworkProfileClient) Update(obj *models.NetworkProfile) (*models.NetworkProfile, error) {
	var robj *models.NetworkProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing NetworkProfile object with a given UUID
func (client *NetworkProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing NetworkProfile object with a given name
func (client *NetworkProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
