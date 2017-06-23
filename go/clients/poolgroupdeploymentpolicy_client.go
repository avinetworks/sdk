package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// PoolGroupDeploymentPolicyClient is a client for avi PoolGroupDeploymentPolicy resource
type PoolGroupDeploymentPolicyClient struct {
	aviSession *session.AviSession
}

// NewPoolGroupDeploymentPolicyClient creates a new client for PoolGroupDeploymentPolicy resource
func NewPoolGroupDeploymentPolicyClient(aviSession *session.AviSession) *PoolGroupDeploymentPolicyClient {
	return &PoolGroupDeploymentPolicyClient{aviSession: aviSession}
}

func (client *PoolGroupDeploymentPolicyClient) getAPIPath(uuid string) string {
	path := "api/poolgroupdeploymentpolicy"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of PoolGroupDeploymentPolicy objects
func (client *PoolGroupDeploymentPolicyClient) GetAll() ([]*models.PoolGroupDeploymentPolicy, error) {
	var plist []*models.PoolGroupDeploymentPolicy
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing PoolGroupDeploymentPolicy by uuid
func (client *PoolGroupDeploymentPolicyClient) Get(uuid string) (*models.PoolGroupDeploymentPolicy, error) {
	var obj *models.PoolGroupDeploymentPolicy
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing PoolGroupDeploymentPolicy by name
func (client *PoolGroupDeploymentPolicyClient) GetByName(name string) (*models.PoolGroupDeploymentPolicy, error) {
	var obj *models.PoolGroupDeploymentPolicy
	err := client.aviSession.GetObjectByName("poolgroupdeploymentpolicy", name, &obj)
	return obj, err
}

// Create a new PoolGroupDeploymentPolicy object
func (client *PoolGroupDeploymentPolicyClient) Create(obj *models.PoolGroupDeploymentPolicy) (*models.PoolGroupDeploymentPolicy, error) {
	var robj *models.PoolGroupDeploymentPolicy
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing PoolGroupDeploymentPolicy object
func (client *PoolGroupDeploymentPolicyClient) Update(obj *models.PoolGroupDeploymentPolicy) (*models.PoolGroupDeploymentPolicy, error) {
	var robj *models.PoolGroupDeploymentPolicy
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing PoolGroupDeploymentPolicy object with a given UUID
func (client *PoolGroupDeploymentPolicyClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing PoolGroupDeploymentPolicy object with a given name
func (client *PoolGroupDeploymentPolicyClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
