package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	ALERTSCRIPTCONFIG_RES_NAME = "alertscriptconfig"
)

// AlertScriptConfigClient is a client for avi AlertScriptConfig resource
type AlertScriptConfigClient struct {
	avi_session *session.AviSession
}

// NewAlertScriptConfigClient creates a new client for AlertScriptConfig resource
func NewAlertScriptConfigClient(avi_session *session.AviSession) *AlertScriptConfigClient {
	return &AlertScriptConfigClient{avi_session: avi_session}
}

func (client *AlertScriptConfigClient) GetApiPath(uuid string) string {
	path := "api/" + ALERTSCRIPTCONFIG_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of AlertScriptConfig objects
func (client *AlertScriptConfigClient) GetAll() ([]*models.AlertScriptConfig, error) {
	var plist []*models.AlertScriptConfig
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing AlertScriptConfig by uuid
func (client *AlertScriptConfigClient) Get(uuid string) (*models.AlertScriptConfig, error) {
	var obj *models.AlertScriptConfig
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing AlertScriptConfig by name
func (client *AlertScriptConfigClient) GetByName(name string) (*models.AlertScriptConfig, error) {
	var obj *models.AlertScriptConfig
	err := client.avi_session.GetObjectByName(ALERTSCRIPTCONFIG_RES_NAME, name, &obj)
	return obj, err
}

// Create a new AlertScriptConfig object
func (client *AlertScriptConfigClient) Create(obj *models.AlertScriptConfig) (*models.AlertScriptConfig, error) {
	var robj *models.AlertScriptConfig
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing AlertScriptConfig object
func (client *AlertScriptConfigClient) Update(obj *models.AlertScriptConfig) (*models.AlertScriptConfig, error) {
	var robj *models.AlertScriptConfig
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing AlertScriptConfig object with a given UUID
func (client *AlertScriptConfigClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing AlertScriptConfig object with a given name
func (client *AlertScriptConfigClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
