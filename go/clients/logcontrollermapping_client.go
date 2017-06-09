package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	LOGCONTROLLERMAPPING_RES_NAME = "logcontrollermapping"
)

// LogControllerMappingClient is a client for avi LogControllerMapping resource
type LogControllerMappingClient struct {
	avi_session *session.AviSession
}

// NewLogControllerMappingClient creates a new client for LogControllerMapping resource
func NewLogControllerMappingClient(avi_session *session.AviSession) *LogControllerMappingClient {
	return &LogControllerMappingClient{avi_session: avi_session}
}

func (client *LogControllerMappingClient) GetApiPath(uuid string) string {
	path := "api/" + LOGCONTROLLERMAPPING_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of LogControllerMapping objects
func (client *LogControllerMappingClient) GetAll() ([]*models.LogControllerMapping, error) {
	var plist []*models.LogControllerMapping
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing LogControllerMapping by uuid
func (client *LogControllerMappingClient) Get(uuid string) (*models.LogControllerMapping, error) {
	var obj *models.LogControllerMapping
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing LogControllerMapping by name
func (client *LogControllerMappingClient) GetByName(name string) (*models.LogControllerMapping, error) {
	var obj *models.LogControllerMapping
	err := client.avi_session.GetObjectByName(LOGCONTROLLERMAPPING_RES_NAME, name, &obj)
	return obj, err
}

// Create a new LogControllerMapping object
func (client *LogControllerMappingClient) Create(obj *models.LogControllerMapping) (*models.LogControllerMapping, error) {
	var robj *models.LogControllerMapping
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing LogControllerMapping object
func (client *LogControllerMappingClient) Update(obj *models.LogControllerMapping) (*models.LogControllerMapping, error) {
	var robj *models.LogControllerMapping
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing LogControllerMapping object with a given UUID
func (client *LogControllerMappingClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing LogControllerMapping object with a given name
func (client *LogControllerMappingClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
