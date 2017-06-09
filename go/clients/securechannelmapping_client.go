package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SECURECHANNELMAPPING_RES_NAME = "securechannelmapping"
)

// SecureChannelMappingClient is a client for avi SecureChannelMapping resource
type SecureChannelMappingClient struct {
	avi_session *session.AviSession
}

// NewSecureChannelMappingClient creates a new client for SecureChannelMapping resource
func NewSecureChannelMappingClient(avi_session *session.AviSession) *SecureChannelMappingClient {
	return &SecureChannelMappingClient{avi_session: avi_session}
}

func (client *SecureChannelMappingClient) GetApiPath(uuid string) string {
	path := "api/" + SECURECHANNELMAPPING_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SecureChannelMapping objects
func (client *SecureChannelMappingClient) GetAll() ([]*models.SecureChannelMapping, error) {
	var plist []*models.SecureChannelMapping
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing SecureChannelMapping by uuid
func (client *SecureChannelMappingClient) Get(uuid string) (*models.SecureChannelMapping, error) {
	var obj *models.SecureChannelMapping
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing SecureChannelMapping by name
func (client *SecureChannelMappingClient) GetByName(name string) (*models.SecureChannelMapping, error) {
	var obj *models.SecureChannelMapping
	err := client.avi_session.GetObjectByName(SECURECHANNELMAPPING_RES_NAME, name, &obj)
	return obj, err
}

// Create a new SecureChannelMapping object
func (client *SecureChannelMappingClient) Create(obj *models.SecureChannelMapping) (*models.SecureChannelMapping, error) {
	var robj *models.SecureChannelMapping
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing SecureChannelMapping object
func (client *SecureChannelMappingClient) Update(obj *models.SecureChannelMapping) (*models.SecureChannelMapping, error) {
	var robj *models.SecureChannelMapping
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SecureChannelMapping object with a given UUID
func (client *SecureChannelMappingClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing SecureChannelMapping object with a given name
func (client *SecureChannelMappingClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
