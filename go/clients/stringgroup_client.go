package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	STRINGGROUP_RES_NAME = "stringgroup"
)

// StringGroupClient is a client for avi StringGroup resource
type StringGroupClient struct {
	avi_session *session.AviSession
}

// NewStringGroupClient creates a new client for StringGroup resource
func NewStringGroupClient(avi_session *session.AviSession) *StringGroupClient {
	return &StringGroupClient{avi_session: avi_session}
}

func (client *StringGroupClient) GetApiPath(uuid string) string {
	path := "api/" + STRINGGROUP_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of StringGroup objects
func (client *StringGroupClient) GetAll() ([]*models.StringGroup, error) {
	var plist []*models.StringGroup
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing StringGroup by uuid
func (client *StringGroupClient) Get(uuid string) (*models.StringGroup, error) {
	var obj *models.StringGroup
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing StringGroup by name
func (client *StringGroupClient) GetByName(name string) (*models.StringGroup, error) {
	var obj *models.StringGroup
	err := client.avi_session.GetObjectByName(STRINGGROUP_RES_NAME, name, &obj)
	return obj, err
}

// Create a new StringGroup object
func (client *StringGroupClient) Create(obj *models.StringGroup) (*models.StringGroup, error) {
	var robj *models.StringGroup
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing StringGroup object
func (client *StringGroupClient) Update(obj *models.StringGroup) (*models.StringGroup, error) {
	var robj *models.StringGroup
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing StringGroup object with a given UUID
func (client *StringGroupClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing StringGroup object with a given name
func (client *StringGroupClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
