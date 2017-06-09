package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	GSLBHEALTHMONITOR_RES_NAME = "gslbhealthmonitor"
)

// GslbHealthMonitorClient is a client for avi GslbHealthMonitor resource
type GslbHealthMonitorClient struct {
	avi_session *session.AviSession
}

// NewGslbHealthMonitorClient creates a new client for GslbHealthMonitor resource
func NewGslbHealthMonitorClient(avi_session *session.AviSession) *GslbHealthMonitorClient {
	return &GslbHealthMonitorClient{avi_session: avi_session}
}

func (client *GslbHealthMonitorClient) GetApiPath(uuid string) string {
	path := "api/" + GSLBHEALTHMONITOR_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of GslbHealthMonitor objects
func (client *GslbHealthMonitorClient) GetAll() ([]*models.GslbHealthMonitor, error) {
	var plist []*models.GslbHealthMonitor
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing GslbHealthMonitor by uuid
func (client *GslbHealthMonitorClient) Get(uuid string) (*models.GslbHealthMonitor, error) {
	var obj *models.GslbHealthMonitor
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing GslbHealthMonitor by name
func (client *GslbHealthMonitorClient) GetByName(name string) (*models.GslbHealthMonitor, error) {
	var obj *models.GslbHealthMonitor
	err := client.avi_session.GetObjectByName(GSLBHEALTHMONITOR_RES_NAME, name, &obj)
	return obj, err
}

// Create a new GslbHealthMonitor object
func (client *GslbHealthMonitorClient) Create(obj *models.GslbHealthMonitor) (*models.GslbHealthMonitor, error) {
	var robj *models.GslbHealthMonitor
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing GslbHealthMonitor object
func (client *GslbHealthMonitorClient) Update(obj *models.GslbHealthMonitor) (*models.GslbHealthMonitor, error) {
	var robj *models.GslbHealthMonitor
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing GslbHealthMonitor object with a given UUID
func (client *GslbHealthMonitorClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing GslbHealthMonitor object with a given name
func (client *GslbHealthMonitorClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
