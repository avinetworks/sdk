package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SEPROPERTIES_RES_NAME = "seproperties"
)

// SePropertiesClient is a client for avi SeProperties resource
type SePropertiesClient struct {
	avi_session *session.AviSession
}

// NewSePropertiesClient creates a new client for SeProperties resource
func NewSePropertiesClient(avi_session *session.AviSession) *SePropertiesClient {
	return &SePropertiesClient{avi_session: avi_session}
}

func (client *SePropertiesClient) GetApiPath(uuid string) string {
	path := "api/" + SEPROPERTIES_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SeProperties objects
func (client *SePropertiesClient) GetAll() ([]*models.SeProperties, error) {
	var plist []*models.SeProperties
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing SeProperties by uuid
func (client *SePropertiesClient) Get(uuid string) (*models.SeProperties, error) {
	var obj *models.SeProperties
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing SeProperties by name
func (client *SePropertiesClient) GetByName(name string) (*models.SeProperties, error) {
	var obj *models.SeProperties
	err := client.avi_session.GetObjectByName(SEPROPERTIES_RES_NAME, name, &obj)
	return obj, err
}

// Create a new SeProperties object
func (client *SePropertiesClient) Create(obj *models.SeProperties) (*models.SeProperties, error) {
	var robj *models.SeProperties
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing SeProperties object
func (client *SePropertiesClient) Update(obj *models.SeProperties) (*models.SeProperties, error) {
	var robj *models.SeProperties
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SeProperties object with a given UUID
func (client *SePropertiesClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing SeProperties object with a given name
func (client *SePropertiesClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
