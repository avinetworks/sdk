package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	DNSPOLICY_RES_NAME = "dnspolicy"
)

// DNSPolicyClient is a client for avi DNSPolicy resource
type DNSPolicyClient struct {
	avi_session *session.AviSession
}

// NewDNSPolicyClient creates a new client for DNSPolicy resource
func NewDNSPolicyClient(avi_session *session.AviSession) *DNSPolicyClient {
	return &DNSPolicyClient{avi_session: avi_session}
}

func (client *DNSPolicyClient) GetApiPath(uuid string) string {
	path := "api/" + DNSPOLICY_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of DNSPolicy objects
func (client *DNSPolicyClient) GetAll() ([]*models.DNSPolicy, error) {
	var plist []*models.DNSPolicy
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing DNSPolicy by uuid
func (client *DNSPolicyClient) Get(uuid string) (*models.DNSPolicy, error) {
	var obj *models.DNSPolicy
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing DNSPolicy by name
func (client *DNSPolicyClient) GetByName(name string) (*models.DNSPolicy, error) {
	var obj *models.DNSPolicy
	err := client.avi_session.GetObjectByName(DNSPOLICY_RES_NAME, name, &obj)
	return obj, err
}

// Create a new DNSPolicy object
func (client *DNSPolicyClient) Create(obj *models.DNSPolicy) (*models.DNSPolicy, error) {
	var robj *models.DNSPolicy
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing DNSPolicy object
func (client *DNSPolicyClient) Update(obj *models.DNSPolicy) (*models.DNSPolicy, error) {
	var robj *models.DNSPolicy
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing DNSPolicy object with a given UUID
func (client *DNSPolicyClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing DNSPolicy object with a given name
func (client *DNSPolicyClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
