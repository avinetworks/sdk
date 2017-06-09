package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SECURECHANNELTOKEN_RES_NAME = "securechanneltoken"
)

// SecureChannelTokenClient is a client for avi SecureChannelToken resource
type SecureChannelTokenClient struct {
	avi_session *session.AviSession
}

// NewSecureChannelTokenClient creates a new client for SecureChannelToken resource
func NewSecureChannelTokenClient(avi_session *session.AviSession) *SecureChannelTokenClient {
	return &SecureChannelTokenClient{avi_session: avi_session}
}

func (client *SecureChannelTokenClient) GetApiPath(uuid string) string {
	path := "api/" + SECURECHANNELTOKEN_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SecureChannelToken objects
func (client *SecureChannelTokenClient) GetAll() ([]*models.SecureChannelToken, error) {
	var plist []*models.SecureChannelToken
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing SecureChannelToken by uuid
func (client *SecureChannelTokenClient) Get(uuid string) (*models.SecureChannelToken, error) {
	var obj *models.SecureChannelToken
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing SecureChannelToken by name
func (client *SecureChannelTokenClient) GetByName(name string) (*models.SecureChannelToken, error) {
	var obj *models.SecureChannelToken
	err := client.avi_session.GetObjectByName(SECURECHANNELTOKEN_RES_NAME, name, &obj)
	return obj, err
}

// Create a new SecureChannelToken object
func (client *SecureChannelTokenClient) Create(obj *models.SecureChannelToken) (*models.SecureChannelToken, error) {
	var robj *models.SecureChannelToken
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing SecureChannelToken object
func (client *SecureChannelTokenClient) Update(obj *models.SecureChannelToken) (*models.SecureChannelToken, error) {
	var robj *models.SecureChannelToken
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SecureChannelToken object with a given UUID
func (client *SecureChannelTokenClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing SecureChannelToken object with a given name
func (client *SecureChannelTokenClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
