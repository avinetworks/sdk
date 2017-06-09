package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	HEALTHMONITOR_RES_NAME = "healthmonitor"
)

// HealthMonitorClient is a client for avi HealthMonitor resource
type HealthMonitorClient struct {
	avi_session *session.AviSession
}

// NewHealthMonitorClient creates a new client for HealthMonitor resource
func NewHealthMonitorClient(avi_session *session.AviSession) *HealthMonitorClient {
	return &HealthMonitorClient{avi_session: avi_session}
}

func (client *HealthMonitorClient) GetApiPath(uuid string) string {
	path := "api/" + HEALTHMONITOR_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of HealthMonitor objects
func (client *HealthMonitorClient) GetAll() ([]*models.HealthMonitor, error) {
	var plist []*models.HealthMonitor
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing HealthMonitor by uuid
func (client *HealthMonitorClient) Get(uuid string) (*models.HealthMonitor, error) {
	var obj *models.HealthMonitor
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing HealthMonitor by name
func (client *HealthMonitorClient) GetByName(name string) (*models.HealthMonitor, error) {
	var obj *models.HealthMonitor
	err := client.avi_session.GetObjectByName(HEALTHMONITOR_RES_NAME, name, &obj)
	return obj, err
}

// Create a new HealthMonitor object
func (client *HealthMonitorClient) Create(obj *models.HealthMonitor) (*models.HealthMonitor, error) {
	var robj *models.HealthMonitor
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing HealthMonitor object
func (client *HealthMonitorClient) Update(obj *models.HealthMonitor) (*models.HealthMonitor, error) {
	var robj *models.HealthMonitor
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing HealthMonitor object with a given UUID
func (client *HealthMonitorClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing HealthMonitor object with a given name
func (client *HealthMonitorClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
