package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	ALERTSYSLOGCONFIG_RES_NAME = "alertsyslogconfig"
)

// AlertSyslogConfigClient is a client for avi AlertSyslogConfig resource
type AlertSyslogConfigClient struct {
	avi_session *session.AviSession
}

// NewAlertSyslogConfigClient creates a new client for AlertSyslogConfig resource
func NewAlertSyslogConfigClient(avi_session *session.AviSession) *AlertSyslogConfigClient {
	return &AlertSyslogConfigClient{avi_session: avi_session}
}

func (client *AlertSyslogConfigClient) GetApiPath(uuid string) string {
	path := "api/" + ALERTSYSLOGCONFIG_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of AlertSyslogConfig objects
func (client *AlertSyslogConfigClient) GetAll() ([]*models.AlertSyslogConfig, error) {
	var plist []*models.AlertSyslogConfig
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing AlertSyslogConfig by uuid
func (client *AlertSyslogConfigClient) Get(uuid string) (*models.AlertSyslogConfig, error) {
	var obj *models.AlertSyslogConfig
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing AlertSyslogConfig by name
func (client *AlertSyslogConfigClient) GetByName(name string) (*models.AlertSyslogConfig, error) {
	var obj *models.AlertSyslogConfig
	err := client.avi_session.GetObjectByName(ALERTSYSLOGCONFIG_RES_NAME, name, &obj)
	return obj, err
}

// Create a new AlertSyslogConfig object
func (client *AlertSyslogConfigClient) Create(obj *models.AlertSyslogConfig) (*models.AlertSyslogConfig, error) {
	var robj *models.AlertSyslogConfig
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing AlertSyslogConfig object
func (client *AlertSyslogConfigClient) Update(obj *models.AlertSyslogConfig) (*models.AlertSyslogConfig, error) {
	var robj *models.AlertSyslogConfig
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing AlertSyslogConfig object with a given UUID
func (client *AlertSyslogConfigClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing AlertSyslogConfig object with a given name
func (client *AlertSyslogConfigClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
