package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	NETWORKSECURITYPOLICY_RES_NAME = "networksecuritypolicy"
)

// NetworkSecurityPolicyClient is a client for avi NetworkSecurityPolicy resource
type NetworkSecurityPolicyClient struct {
	avi_session *session.AviSession
}

// NewNetworkSecurityPolicyClient creates a new client for NetworkSecurityPolicy resource
func NewNetworkSecurityPolicyClient(avi_session *session.AviSession) *NetworkSecurityPolicyClient {
	return &NetworkSecurityPolicyClient{avi_session: avi_session}
}

func (client *NetworkSecurityPolicyClient) GetApiPath(uuid string) string {
	path := "api/" + NETWORKSECURITYPOLICY_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of NetworkSecurityPolicy objects
func (client *NetworkSecurityPolicyClient) GetAll() ([]*models.NetworkSecurityPolicy, error) {
	var plist []*models.NetworkSecurityPolicy
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing NetworkSecurityPolicy by uuid
func (client *NetworkSecurityPolicyClient) Get(uuid string) (*models.NetworkSecurityPolicy, error) {
	var obj *models.NetworkSecurityPolicy
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing NetworkSecurityPolicy by name
func (client *NetworkSecurityPolicyClient) GetByName(name string) (*models.NetworkSecurityPolicy, error) {
	var obj *models.NetworkSecurityPolicy
	err := client.avi_session.GetObjectByName(NETWORKSECURITYPOLICY_RES_NAME, name, &obj)
	return obj, err
}

// Create a new NetworkSecurityPolicy object
func (client *NetworkSecurityPolicyClient) Create(obj *models.NetworkSecurityPolicy) (*models.NetworkSecurityPolicy, error) {
	var robj *models.NetworkSecurityPolicy
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing NetworkSecurityPolicy object
func (client *NetworkSecurityPolicyClient) Update(obj *models.NetworkSecurityPolicy) (*models.NetworkSecurityPolicy, error) {
	var robj *models.NetworkSecurityPolicy
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing NetworkSecurityPolicy object with a given UUID
func (client *NetworkSecurityPolicyClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing NetworkSecurityPolicy object with a given name
func (client *NetworkSecurityPolicyClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
