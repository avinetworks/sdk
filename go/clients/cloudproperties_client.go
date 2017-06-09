package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	CLOUDPROPERTIES_RES_NAME = "cloudproperties"
)

// CloudPropertiesClient is a client for avi CloudProperties resource
type CloudPropertiesClient struct {
	avi_session *session.AviSession
}

// NewCloudPropertiesClient creates a new client for CloudProperties resource
func NewCloudPropertiesClient(avi_session *session.AviSession) *CloudPropertiesClient {
	return &CloudPropertiesClient{avi_session: avi_session}
}

func (client *CloudPropertiesClient) GetApiPath(uuid string) string {
	path := "api/" + CLOUDPROPERTIES_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of CloudProperties objects
func (client *CloudPropertiesClient) GetAll() ([]*models.CloudProperties, error) {
	var plist []*models.CloudProperties
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing CloudProperties by uuid
func (client *CloudPropertiesClient) Get(uuid string) (*models.CloudProperties, error) {
	var obj *models.CloudProperties
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing CloudProperties by name
func (client *CloudPropertiesClient) GetByName(name string) (*models.CloudProperties, error) {
	var obj *models.CloudProperties
	err := client.avi_session.GetObjectByName(CLOUDPROPERTIES_RES_NAME, name, &obj)
	return obj, err
}

// Create a new CloudProperties object
func (client *CloudPropertiesClient) Create(obj *models.CloudProperties) (*models.CloudProperties, error) {
	var robj *models.CloudProperties
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing CloudProperties object
func (client *CloudPropertiesClient) Update(obj *models.CloudProperties) (*models.CloudProperties, error) {
	var robj *models.CloudProperties
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing CloudProperties object with a given UUID
func (client *CloudPropertiesClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing CloudProperties object with a given name
func (client *CloudPropertiesClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
