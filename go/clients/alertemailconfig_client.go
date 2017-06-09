package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	ALERTEMAILCONFIG_RES_NAME = "alertemailconfig"
)

// AlertEmailConfigClient is a client for avi AlertEmailConfig resource
type AlertEmailConfigClient struct {
	avi_session *session.AviSession
}

// NewAlertEmailConfigClient creates a new client for AlertEmailConfig resource
func NewAlertEmailConfigClient(avi_session *session.AviSession) *AlertEmailConfigClient {
	return &AlertEmailConfigClient{avi_session: avi_session}
}

func (client *AlertEmailConfigClient) GetApiPath(uuid string) string {
	path := "api/" + ALERTEMAILCONFIG_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of AlertEmailConfig objects
func (client *AlertEmailConfigClient) GetAll() ([]*models.AlertEmailConfig, error) {
	var plist []*models.AlertEmailConfig
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing AlertEmailConfig by uuid
func (client *AlertEmailConfigClient) Get(uuid string) (*models.AlertEmailConfig, error) {
	var obj *models.AlertEmailConfig
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing AlertEmailConfig by name
func (client *AlertEmailConfigClient) GetByName(name string) (*models.AlertEmailConfig, error) {
	var obj *models.AlertEmailConfig
	err := client.avi_session.GetObjectByName(ALERTEMAILCONFIG_RES_NAME, name, &obj)
	return obj, err
}

// Create a new AlertEmailConfig object
func (client *AlertEmailConfigClient) Create(obj *models.AlertEmailConfig) (*models.AlertEmailConfig, error) {
	var robj *models.AlertEmailConfig
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing AlertEmailConfig object
func (client *AlertEmailConfigClient) Update(obj *models.AlertEmailConfig) (*models.AlertEmailConfig, error) {
	var robj *models.AlertEmailConfig
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing AlertEmailConfig object with a given UUID
func (client *AlertEmailConfigClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing AlertEmailConfig object with a given name
func (client *AlertEmailConfigClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
