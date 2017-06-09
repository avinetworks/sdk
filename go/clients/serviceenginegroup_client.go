package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SERVICEENGINEGROUP_RES_NAME = "serviceenginegroup"
)

// ServiceEngineGroupClient is a client for avi ServiceEngineGroup resource
type ServiceEngineGroupClient struct {
	avi_session *session.AviSession
}

// NewServiceEngineGroupClient creates a new client for ServiceEngineGroup resource
func NewServiceEngineGroupClient(avi_session *session.AviSession) *ServiceEngineGroupClient {
	return &ServiceEngineGroupClient{avi_session: avi_session}
}

func (client *ServiceEngineGroupClient) GetApiPath(uuid string) string {
	path := "api/" + SERVICEENGINEGROUP_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of ServiceEngineGroup objects
func (client *ServiceEngineGroupClient) GetAll() ([]*models.ServiceEngineGroup, error) {
	var plist []*models.ServiceEngineGroup
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing ServiceEngineGroup by uuid
func (client *ServiceEngineGroupClient) Get(uuid string) (*models.ServiceEngineGroup, error) {
	var obj *models.ServiceEngineGroup
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing ServiceEngineGroup by name
func (client *ServiceEngineGroupClient) GetByName(name string) (*models.ServiceEngineGroup, error) {
	var obj *models.ServiceEngineGroup
	err := client.avi_session.GetObjectByName(SERVICEENGINEGROUP_RES_NAME, name, &obj)
	return obj, err
}

// Create a new ServiceEngineGroup object
func (client *ServiceEngineGroupClient) Create(obj *models.ServiceEngineGroup) (*models.ServiceEngineGroup, error) {
	var robj *models.ServiceEngineGroup
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing ServiceEngineGroup object
func (client *ServiceEngineGroupClient) Update(obj *models.ServiceEngineGroup) (*models.ServiceEngineGroup, error) {
	var robj *models.ServiceEngineGroup
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing ServiceEngineGroup object with a given UUID
func (client *ServiceEngineGroupClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing ServiceEngineGroup object with a given name
func (client *ServiceEngineGroupClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
