package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	NETWORK_RES_NAME = "network"
)

// NetworkClient is a client for avi Network resource
type NetworkClient struct {
	avi_session *session.AviSession
}

// NewNetworkClient creates a new client for Network resource
func NewNetworkClient(avi_session *session.AviSession) *NetworkClient {
	return &NetworkClient{avi_session: avi_session}
}

func (client *NetworkClient) GetApiPath(uuid string) string {
	path := "api/" + NETWORK_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Network objects
func (client *NetworkClient) GetAll() ([]*models.Network, error) {
	var plist []*models.Network
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing Network by uuid
func (client *NetworkClient) Get(uuid string) (*models.Network, error) {
	var obj *models.Network
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing Network by name
func (client *NetworkClient) GetByName(name string) (*models.Network, error) {
	var obj *models.Network
	err := client.avi_session.GetObjectByName(NETWORK_RES_NAME, name, &obj)
	return obj, err
}

// Create a new Network object
func (client *NetworkClient) Create(obj *models.Network) (*models.Network, error) {
	var robj *models.Network
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing Network object
func (client *NetworkClient) Update(obj *models.Network) (*models.Network, error) {
	var robj *models.Network
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Network object with a given UUID
func (client *NetworkClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing Network object with a given name
func (client *NetworkClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
