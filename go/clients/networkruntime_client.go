package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	NETWORKRUNTIME_RES_NAME = "networkruntime"
)

// NetworkRuntimeClient is a client for avi NetworkRuntime resource
type NetworkRuntimeClient struct {
	avi_session *session.AviSession
}

// NewNetworkRuntimeClient creates a new client for NetworkRuntime resource
func NewNetworkRuntimeClient(avi_session *session.AviSession) *NetworkRuntimeClient {
	return &NetworkRuntimeClient{avi_session: avi_session}
}

func (client *NetworkRuntimeClient) GetApiPath(uuid string) string {
	path := "api/" + NETWORKRUNTIME_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of NetworkRuntime objects
func (client *NetworkRuntimeClient) GetAll() ([]*models.NetworkRuntime, error) {
	var plist []*models.NetworkRuntime
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing NetworkRuntime by uuid
func (client *NetworkRuntimeClient) Get(uuid string) (*models.NetworkRuntime, error) {
	var obj *models.NetworkRuntime
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing NetworkRuntime by name
func (client *NetworkRuntimeClient) GetByName(name string) (*models.NetworkRuntime, error) {
	var obj *models.NetworkRuntime
	err := client.avi_session.GetObjectByName(NETWORKRUNTIME_RES_NAME, name, &obj)
	return obj, err
}

// Create a new NetworkRuntime object
func (client *NetworkRuntimeClient) Create(obj *models.NetworkRuntime) (*models.NetworkRuntime, error) {
	var robj *models.NetworkRuntime
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing NetworkRuntime object
func (client *NetworkRuntimeClient) Update(obj *models.NetworkRuntime) (*models.NetworkRuntime, error) {
	var robj *models.NetworkRuntime
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing NetworkRuntime object with a given UUID
func (client *NetworkRuntimeClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing NetworkRuntime object with a given name
func (client *NetworkRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
