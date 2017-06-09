package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	CLOUDCONNECTORUSER_RES_NAME = "cloudconnectoruser"
)

// CloudConnectorUserClient is a client for avi CloudConnectorUser resource
type CloudConnectorUserClient struct {
	avi_session *session.AviSession
}

// NewCloudConnectorUserClient creates a new client for CloudConnectorUser resource
func NewCloudConnectorUserClient(avi_session *session.AviSession) *CloudConnectorUserClient {
	return &CloudConnectorUserClient{avi_session: avi_session}
}

func (client *CloudConnectorUserClient) GetApiPath(uuid string) string {
	path := "api/" + CLOUDCONNECTORUSER_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of CloudConnectorUser objects
func (client *CloudConnectorUserClient) GetAll() ([]*models.CloudConnectorUser, error) {
	var plist []*models.CloudConnectorUser
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing CloudConnectorUser by uuid
func (client *CloudConnectorUserClient) Get(uuid string) (*models.CloudConnectorUser, error) {
	var obj *models.CloudConnectorUser
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing CloudConnectorUser by name
func (client *CloudConnectorUserClient) GetByName(name string) (*models.CloudConnectorUser, error) {
	var obj *models.CloudConnectorUser
	err := client.avi_session.GetObjectByName(CLOUDCONNECTORUSER_RES_NAME, name, &obj)
	return obj, err
}

// Create a new CloudConnectorUser object
func (client *CloudConnectorUserClient) Create(obj *models.CloudConnectorUser) (*models.CloudConnectorUser, error) {
	var robj *models.CloudConnectorUser
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing CloudConnectorUser object
func (client *CloudConnectorUserClient) Update(obj *models.CloudConnectorUser) (*models.CloudConnectorUser, error) {
	var robj *models.CloudConnectorUser
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing CloudConnectorUser object with a given UUID
func (client *CloudConnectorUserClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing CloudConnectorUser object with a given name
func (client *CloudConnectorUserClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
