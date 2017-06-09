package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SERVICEENGINE_RES_NAME = "serviceengine"
)

// ServiceEngineClient is a client for avi ServiceEngine resource
type ServiceEngineClient struct {
	avi_session *session.AviSession
}

// NewServiceEngineClient creates a new client for ServiceEngine resource
func NewServiceEngineClient(avi_session *session.AviSession) *ServiceEngineClient {
	return &ServiceEngineClient{avi_session: avi_session}
}

func (client *ServiceEngineClient) GetApiPath(uuid string) string {
	path := "api/" + SERVICEENGINE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of ServiceEngine objects
func (client *ServiceEngineClient) GetAll() ([]*models.ServiceEngine, error) {
	var plist []*models.ServiceEngine
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing ServiceEngine by uuid
func (client *ServiceEngineClient) Get(uuid string) (*models.ServiceEngine, error) {
	var obj *models.ServiceEngine
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing ServiceEngine by name
func (client *ServiceEngineClient) GetByName(name string) (*models.ServiceEngine, error) {
	var obj *models.ServiceEngine
	err := client.avi_session.GetObjectByName(SERVICEENGINE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new ServiceEngine object
func (client *ServiceEngineClient) Create(obj *models.ServiceEngine) (*models.ServiceEngine, error) {
	var robj *models.ServiceEngine
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing ServiceEngine object
func (client *ServiceEngineClient) Update(obj *models.ServiceEngine) (*models.ServiceEngine, error) {
	var robj *models.ServiceEngine
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing ServiceEngine object with a given UUID
func (client *ServiceEngineClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing ServiceEngine object with a given name
func (client *ServiceEngineClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
