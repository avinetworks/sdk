package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	POOL_RES_NAME = "pool"
)

// PoolClient is a client for avi Pool resource
type PoolClient struct {
	avi_session *session.AviSession
}

// NewPoolClient creates a new client for Pool resource
func NewPoolClient(avi_session *session.AviSession) *PoolClient {
	return &PoolClient{avi_session: avi_session}
}

func (client *PoolClient) GetApiPath(uuid string) string {
	path := "api/" + POOL_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Pool objects
func (client *PoolClient) GetAll() ([]*models.Pool, error) {
	var plist []*models.Pool
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing Pool by uuid
func (client *PoolClient) Get(uuid string) (*models.Pool, error) {
	var obj *models.Pool
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing Pool by name
func (client *PoolClient) GetByName(name string) (*models.Pool, error) {
	var obj *models.Pool
	err := client.avi_session.GetObjectByName(POOL_RES_NAME, name, &obj)
	return obj, err
}

// Create a new Pool object
func (client *PoolClient) Create(obj *models.Pool) (*models.Pool, error) {
	var robj *models.Pool
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing Pool object
func (client *PoolClient) Update(obj *models.Pool) (*models.Pool, error) {
	var robj *models.Pool
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Pool object with a given UUID
func (client *PoolClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing Pool object with a given name
func (client *PoolClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
