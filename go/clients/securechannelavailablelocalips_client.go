package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SECURECHANNELAVAILABLELOCALIPS_RES_NAME = "securechannelavailablelocalips"
)

// SecureChannelAvailableLocalIpsClient is a client for avi SecureChannelAvailableLocalIps resource
type SecureChannelAvailableLocalIpsClient struct {
	avi_session *session.AviSession
}

// NewSecureChannelAvailableLocalIpsClient creates a new client for SecureChannelAvailableLocalIps resource
func NewSecureChannelAvailableLocalIpsClient(avi_session *session.AviSession) *SecureChannelAvailableLocalIpsClient {
	return &SecureChannelAvailableLocalIpsClient{avi_session: avi_session}
}

func (client *SecureChannelAvailableLocalIpsClient) GetApiPath(uuid string) string {
	path := "api/" + SECURECHANNELAVAILABLELOCALIPS_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SecureChannelAvailableLocalIps objects
func (client *SecureChannelAvailableLocalIpsClient) GetAll() ([]*models.SecureChannelAvailableLocalIps, error) {
	var plist []*models.SecureChannelAvailableLocalIps
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing SecureChannelAvailableLocalIps by uuid
func (client *SecureChannelAvailableLocalIpsClient) Get(uuid string) (*models.SecureChannelAvailableLocalIps, error) {
	var obj *models.SecureChannelAvailableLocalIps
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing SecureChannelAvailableLocalIps by name
func (client *SecureChannelAvailableLocalIpsClient) GetByName(name string) (*models.SecureChannelAvailableLocalIps, error) {
	var obj *models.SecureChannelAvailableLocalIps
	err := client.avi_session.GetObjectByName(SECURECHANNELAVAILABLELOCALIPS_RES_NAME, name, &obj)
	return obj, err
}

// Create a new SecureChannelAvailableLocalIps object
func (client *SecureChannelAvailableLocalIpsClient) Create(obj *models.SecureChannelAvailableLocalIps) (*models.SecureChannelAvailableLocalIps, error) {
	var robj *models.SecureChannelAvailableLocalIps
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing SecureChannelAvailableLocalIps object
func (client *SecureChannelAvailableLocalIpsClient) Update(obj *models.SecureChannelAvailableLocalIps) (*models.SecureChannelAvailableLocalIps, error) {
	var robj *models.SecureChannelAvailableLocalIps
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SecureChannelAvailableLocalIps object with a given UUID
func (client *SecureChannelAvailableLocalIpsClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing SecureChannelAvailableLocalIps object with a given name
func (client *SecureChannelAvailableLocalIpsClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
