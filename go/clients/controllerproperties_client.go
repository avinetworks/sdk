package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	CONTROLLERPROPERTIES_RES_NAME = "controllerproperties"
)

// ControllerPropertiesClient is a client for avi ControllerProperties resource
type ControllerPropertiesClient struct {
	avi_session *session.AviSession
}

// NewControllerPropertiesClient creates a new client for ControllerProperties resource
func NewControllerPropertiesClient(avi_session *session.AviSession) *ControllerPropertiesClient {
	return &ControllerPropertiesClient{avi_session: avi_session}
}

func (client *ControllerPropertiesClient) GetApiPath(uuid string) string {
	path := "api/" + CONTROLLERPROPERTIES_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of ControllerProperties objects
func (client *ControllerPropertiesClient) GetAll() ([]*models.ControllerProperties, error) {
	var plist []*models.ControllerProperties
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing ControllerProperties by uuid
func (client *ControllerPropertiesClient) Get(uuid string) (*models.ControllerProperties, error) {
	var obj *models.ControllerProperties
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing ControllerProperties by name
func (client *ControllerPropertiesClient) GetByName(name string) (*models.ControllerProperties, error) {
	var obj *models.ControllerProperties
	err := client.avi_session.GetObjectByName(CONTROLLERPROPERTIES_RES_NAME, name, &obj)
	return obj, err
}

// Create a new ControllerProperties object
func (client *ControllerPropertiesClient) Create(obj *models.ControllerProperties) (*models.ControllerProperties, error) {
	var robj *models.ControllerProperties
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing ControllerProperties object
func (client *ControllerPropertiesClient) Update(obj *models.ControllerProperties) (*models.ControllerProperties, error) {
	var robj *models.ControllerProperties
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing ControllerProperties object with a given UUID
func (client *ControllerPropertiesClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing ControllerProperties object with a given name
func (client *ControllerPropertiesClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
