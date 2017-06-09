package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	TENANT_RES_NAME = "tenant"
)

// TenantClient is a client for avi Tenant resource
type TenantClient struct {
	avi_session *session.AviSession
}

// NewTenantClient creates a new client for Tenant resource
func NewTenantClient(avi_session *session.AviSession) *TenantClient {
	return &TenantClient{avi_session: avi_session}
}

func (client *TenantClient) GetApiPath(uuid string) string {
	path := "api/" + TENANT_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Tenant objects
func (client *TenantClient) GetAll() ([]*models.Tenant, error) {
	var plist []*models.Tenant
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing Tenant by uuid
func (client *TenantClient) Get(uuid string) (*models.Tenant, error) {
	var obj *models.Tenant
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing Tenant by name
func (client *TenantClient) GetByName(name string) (*models.Tenant, error) {
	var obj *models.Tenant
	err := client.avi_session.GetObjectByName(TENANT_RES_NAME, name, &obj)
	return obj, err
}

// Create a new Tenant object
func (client *TenantClient) Create(obj *models.Tenant) (*models.Tenant, error) {
	var robj *models.Tenant
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing Tenant object
func (client *TenantClient) Update(obj *models.Tenant) (*models.Tenant, error) {
	var robj *models.Tenant
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Tenant object with a given UUID
func (client *TenantClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing Tenant object with a given name
func (client *TenantClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
