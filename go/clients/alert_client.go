package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	ALERT_RES_NAME = "alert"
)

// AlertClient is a client for avi Alert resource
type AlertClient struct {
	avi_session *session.AviSession
}

// NewAlertClient creates a new client for Alert resource
func NewAlertClient(avi_session *session.AviSession) *AlertClient {
	return &AlertClient{avi_session: avi_session}
}

func (client *AlertClient) GetApiPath(uuid string) string {
	path := "api/" + ALERT_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Alert objects
func (client *AlertClient) GetAll() ([]*models.Alert, error) {
	var plist []*models.Alert
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing Alert by uuid
func (client *AlertClient) Get(uuid string) (*models.Alert, error) {
	var obj *models.Alert
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing Alert by name
func (client *AlertClient) GetByName(name string) (*models.Alert, error) {
	var obj *models.Alert
	err := client.avi_session.GetObjectByName(ALERT_RES_NAME, name, &obj)
	return obj, err
}

// Create a new Alert object
func (client *AlertClient) Create(obj *models.Alert) (*models.Alert, error) {
	var robj *models.Alert
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing Alert object
func (client *AlertClient) Update(obj *models.Alert) (*models.Alert, error) {
	var robj *models.Alert
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Alert object with a given UUID
func (client *AlertClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing Alert object with a given name
func (client *AlertClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
