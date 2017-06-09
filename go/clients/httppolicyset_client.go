package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	HTTPPOLICYSET_RES_NAME = "httppolicyset"
)

// HTTPPolicySetClient is a client for avi HTTPPolicySet resource
type HTTPPolicySetClient struct {
	avi_session *session.AviSession
}

// NewHTTPPolicySetClient creates a new client for HTTPPolicySet resource
func NewHTTPPolicySetClient(avi_session *session.AviSession) *HTTPPolicySetClient {
	return &HTTPPolicySetClient{avi_session: avi_session}
}

func (client *HTTPPolicySetClient) GetApiPath(uuid string) string {
	path := "api/" + HTTPPOLICYSET_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of HTTPPolicySet objects
func (client *HTTPPolicySetClient) GetAll() ([]*models.HTTPPolicySet, error) {
	var plist []*models.HTTPPolicySet
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing HTTPPolicySet by uuid
func (client *HTTPPolicySetClient) Get(uuid string) (*models.HTTPPolicySet, error) {
	var obj *models.HTTPPolicySet
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing HTTPPolicySet by name
func (client *HTTPPolicySetClient) GetByName(name string) (*models.HTTPPolicySet, error) {
	var obj *models.HTTPPolicySet
	err := client.avi_session.GetObjectByName(HTTPPOLICYSET_RES_NAME, name, &obj)
	return obj, err
}

// Create a new HTTPPolicySet object
func (client *HTTPPolicySetClient) Create(obj *models.HTTPPolicySet) (*models.HTTPPolicySet, error) {
	var robj *models.HTTPPolicySet
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing HTTPPolicySet object
func (client *HTTPPolicySetClient) Update(obj *models.HTTPPolicySet) (*models.HTTPPolicySet, error) {
	var robj *models.HTTPPolicySet
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing HTTPPolicySet object with a given UUID
func (client *HTTPPolicySetClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing HTTPPolicySet object with a given name
func (client *HTTPPolicySetClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
