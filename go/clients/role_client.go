package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	ROLE_RES_NAME = "role"
)

// RoleClient is a client for avi Role resource
type RoleClient struct {
	avi_session *session.AviSession
}

// NewRoleClient creates a new client for Role resource
func NewRoleClient(avi_session *session.AviSession) *RoleClient {
	return &RoleClient{avi_session: avi_session}
}

func (client *RoleClient) GetApiPath(uuid string) string {
	path := "api/" + ROLE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Role objects
func (client *RoleClient) GetAll() ([]*models.Role, error) {
	var plist []*models.Role
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing Role by uuid
func (client *RoleClient) Get(uuid string) (*models.Role, error) {
	var obj *models.Role
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing Role by name
func (client *RoleClient) GetByName(name string) (*models.Role, error) {
	var obj *models.Role
	err := client.avi_session.GetObjectByName(ROLE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new Role object
func (client *RoleClient) Create(obj *models.Role) (*models.Role, error) {
	var robj *models.Role
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing Role object
func (client *RoleClient) Update(obj *models.Role) (*models.Role, error) {
	var robj *models.Role
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Role object with a given UUID
func (client *RoleClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing Role object with a given name
func (client *RoleClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
