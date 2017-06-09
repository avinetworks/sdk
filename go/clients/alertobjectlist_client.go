package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	ALERTOBJECTLIST_RES_NAME = "alertobjectlist"
)

// AlertObjectListClient is a client for avi AlertObjectList resource
type AlertObjectListClient struct {
	avi_session *session.AviSession
}

// NewAlertObjectListClient creates a new client for AlertObjectList resource
func NewAlertObjectListClient(avi_session *session.AviSession) *AlertObjectListClient {
	return &AlertObjectListClient{avi_session: avi_session}
}

func (client *AlertObjectListClient) GetApiPath(uuid string) string {
	path := "api/" + ALERTOBJECTLIST_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of AlertObjectList objects
func (client *AlertObjectListClient) GetAll() ([]*models.AlertObjectList, error) {
	var plist []*models.AlertObjectList
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing AlertObjectList by uuid
func (client *AlertObjectListClient) Get(uuid string) (*models.AlertObjectList, error) {
	var obj *models.AlertObjectList
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing AlertObjectList by name
func (client *AlertObjectListClient) GetByName(name string) (*models.AlertObjectList, error) {
	var obj *models.AlertObjectList
	err := client.avi_session.GetObjectByName(ALERTOBJECTLIST_RES_NAME, name, &obj)
	return obj, err
}

// Create a new AlertObjectList object
func (client *AlertObjectListClient) Create(obj *models.AlertObjectList) (*models.AlertObjectList, error) {
	var robj *models.AlertObjectList
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing AlertObjectList object
func (client *AlertObjectListClient) Update(obj *models.AlertObjectList) (*models.AlertObjectList, error) {
	var robj *models.AlertObjectList
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing AlertObjectList object with a given UUID
func (client *AlertObjectListClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing AlertObjectList object with a given name
func (client *AlertObjectListClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
