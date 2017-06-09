package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	POOLGROUP_RES_NAME = "poolgroup"
)

// PoolGroupClient is a client for avi PoolGroup resource
type PoolGroupClient struct {
	avi_session *session.AviSession
}

// NewPoolGroupClient creates a new client for PoolGroup resource
func NewPoolGroupClient(avi_session *session.AviSession) *PoolGroupClient {
	return &PoolGroupClient{avi_session: avi_session}
}

func (client *PoolGroupClient) GetApiPath(uuid string) string {
	path := "api/" + POOLGROUP_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of PoolGroup objects
func (client *PoolGroupClient) GetAll() ([]*models.PoolGroup, error) {
	var plist []*models.PoolGroup
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing PoolGroup by uuid
func (client *PoolGroupClient) Get(uuid string) (*models.PoolGroup, error) {
	var obj *models.PoolGroup
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing PoolGroup by name
func (client *PoolGroupClient) GetByName(name string) (*models.PoolGroup, error) {
	var obj *models.PoolGroup
	err := client.avi_session.GetObjectByName(POOLGROUP_RES_NAME, name, &obj)
	return obj, err
}

// Create a new PoolGroup object
func (client *PoolGroupClient) Create(obj *models.PoolGroup) (*models.PoolGroup, error) {
	var robj *models.PoolGroup
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing PoolGroup object
func (client *PoolGroupClient) Update(obj *models.PoolGroup) (*models.PoolGroup, error) {
	var robj *models.PoolGroup
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing PoolGroup object with a given UUID
func (client *PoolGroupClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing PoolGroup object with a given name
func (client *PoolGroupClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
