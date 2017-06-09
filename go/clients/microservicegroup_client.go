package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	MICROSERVICEGROUP_RES_NAME = "microservicegroup"
)

// MicroServiceGroupClient is a client for avi MicroServiceGroup resource
type MicroServiceGroupClient struct {
	avi_session *session.AviSession
}

// NewMicroServiceGroupClient creates a new client for MicroServiceGroup resource
func NewMicroServiceGroupClient(avi_session *session.AviSession) *MicroServiceGroupClient {
	return &MicroServiceGroupClient{avi_session: avi_session}
}

func (client *MicroServiceGroupClient) GetApiPath(uuid string) string {
	path := "api/" + MICROSERVICEGROUP_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of MicroServiceGroup objects
func (client *MicroServiceGroupClient) GetAll() ([]*models.MicroServiceGroup, error) {
	var plist []*models.MicroServiceGroup
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing MicroServiceGroup by uuid
func (client *MicroServiceGroupClient) Get(uuid string) (*models.MicroServiceGroup, error) {
	var obj *models.MicroServiceGroup
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing MicroServiceGroup by name
func (client *MicroServiceGroupClient) GetByName(name string) (*models.MicroServiceGroup, error) {
	var obj *models.MicroServiceGroup
	err := client.avi_session.GetObjectByName(MICROSERVICEGROUP_RES_NAME, name, &obj)
	return obj, err
}

// Create a new MicroServiceGroup object
func (client *MicroServiceGroupClient) Create(obj *models.MicroServiceGroup) (*models.MicroServiceGroup, error) {
	var robj *models.MicroServiceGroup
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing MicroServiceGroup object
func (client *MicroServiceGroupClient) Update(obj *models.MicroServiceGroup) (*models.MicroServiceGroup, error) {
	var robj *models.MicroServiceGroup
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing MicroServiceGroup object with a given UUID
func (client *MicroServiceGroupClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing MicroServiceGroup object with a given name
func (client *MicroServiceGroupClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
