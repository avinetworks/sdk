package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	POOLGROUPDEPLOYMENTPOLICY_RES_NAME = "poolgroupdeploymentpolicy"
)

// PoolGroupDeploymentPolicyClient is a client for avi PoolGroupDeploymentPolicy resource
type PoolGroupDeploymentPolicyClient struct {
	avi_session *session.AviSession
}

// NewPoolGroupDeploymentPolicyClient creates a new client for PoolGroupDeploymentPolicy resource
func NewPoolGroupDeploymentPolicyClient(avi_session *session.AviSession) *PoolGroupDeploymentPolicyClient {
	return &PoolGroupDeploymentPolicyClient{avi_session: avi_session}
}

func (client *PoolGroupDeploymentPolicyClient) GetApiPath(uuid string) string {
	path := "api/" + POOLGROUPDEPLOYMENTPOLICY_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of PoolGroupDeploymentPolicy objects
func (client *PoolGroupDeploymentPolicyClient) GetAll() ([]*models.PoolGroupDeploymentPolicy, error) {
	var plist []*models.PoolGroupDeploymentPolicy
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing PoolGroupDeploymentPolicy by uuid
func (client *PoolGroupDeploymentPolicyClient) Get(uuid string) (*models.PoolGroupDeploymentPolicy, error) {
	var obj *models.PoolGroupDeploymentPolicy
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing PoolGroupDeploymentPolicy by name
func (client *PoolGroupDeploymentPolicyClient) GetByName(name string) (*models.PoolGroupDeploymentPolicy, error) {
	var obj *models.PoolGroupDeploymentPolicy
	err := client.avi_session.GetObjectByName(POOLGROUPDEPLOYMENTPOLICY_RES_NAME, name, &obj)
	return obj, err
}

// Create a new PoolGroupDeploymentPolicy object
func (client *PoolGroupDeploymentPolicyClient) Create(obj *models.PoolGroupDeploymentPolicy) (*models.PoolGroupDeploymentPolicy, error) {
	var robj *models.PoolGroupDeploymentPolicy
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing PoolGroupDeploymentPolicy object
func (client *PoolGroupDeploymentPolicyClient) Update(obj *models.PoolGroupDeploymentPolicy) (*models.PoolGroupDeploymentPolicy, error) {
	var robj *models.PoolGroupDeploymentPolicy
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing PoolGroupDeploymentPolicy object with a given UUID
func (client *PoolGroupDeploymentPolicyClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing PoolGroupDeploymentPolicy object with a given name
func (client *PoolGroupDeploymentPolicyClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
