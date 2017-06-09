package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	ALERTCONFIG_RES_NAME = "alertconfig"
)

// AlertConfigClient is a client for avi AlertConfig resource
type AlertConfigClient struct {
	avi_session *session.AviSession
}

// NewAlertConfigClient creates a new client for AlertConfig resource
func NewAlertConfigClient(avi_session *session.AviSession) *AlertConfigClient {
	return &AlertConfigClient{avi_session: avi_session}
}

func (client *AlertConfigClient) GetApiPath(uuid string) string {
	path := "api/" + ALERTCONFIG_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of AlertConfig objects
func (client *AlertConfigClient) GetAll() ([]*models.AlertConfig, error) {
	var plist []*models.AlertConfig
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing AlertConfig by uuid
func (client *AlertConfigClient) Get(uuid string) (*models.AlertConfig, error) {
	var obj *models.AlertConfig
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing AlertConfig by name
func (client *AlertConfigClient) GetByName(name string) (*models.AlertConfig, error) {
	var obj *models.AlertConfig
	err := client.avi_session.GetObjectByName(ALERTCONFIG_RES_NAME, name, &obj)
	return obj, err
}

// Create a new AlertConfig object
func (client *AlertConfigClient) Create(obj *models.AlertConfig) (*models.AlertConfig, error) {
	var robj *models.AlertConfig
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing AlertConfig object
func (client *AlertConfigClient) Update(obj *models.AlertConfig) (*models.AlertConfig, error) {
	var robj *models.AlertConfig
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing AlertConfig object with a given UUID
func (client *AlertConfigClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing AlertConfig object with a given name
func (client *AlertConfigClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
