package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VSDATASCRIPTSET_RES_NAME = "vsdatascriptset"
)

// VSDataScriptSetClient is a client for avi VSDataScriptSet resource
type VSDataScriptSetClient struct {
	avi_session *session.AviSession
}

// NewVSDataScriptSetClient creates a new client for VSDataScriptSet resource
func NewVSDataScriptSetClient(avi_session *session.AviSession) *VSDataScriptSetClient {
	return &VSDataScriptSetClient{avi_session: avi_session}
}

func (client *VSDataScriptSetClient) GetApiPath(uuid string) string {
	path := "api/" + VSDATASCRIPTSET_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VSDataScriptSet objects
func (client *VSDataScriptSetClient) GetAll() ([]*models.VSDataScriptSet, error) {
	var plist []*models.VSDataScriptSet
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VSDataScriptSet by uuid
func (client *VSDataScriptSetClient) Get(uuid string) (*models.VSDataScriptSet, error) {
	var obj *models.VSDataScriptSet
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VSDataScriptSet by name
func (client *VSDataScriptSetClient) GetByName(name string) (*models.VSDataScriptSet, error) {
	var obj *models.VSDataScriptSet
	err := client.avi_session.GetObjectByName(VSDATASCRIPTSET_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VSDataScriptSet object
func (client *VSDataScriptSetClient) Create(obj *models.VSDataScriptSet) (*models.VSDataScriptSet, error) {
	var robj *models.VSDataScriptSet
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VSDataScriptSet object
func (client *VSDataScriptSetClient) Update(obj *models.VSDataScriptSet) (*models.VSDataScriptSet, error) {
	var robj *models.VSDataScriptSet
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VSDataScriptSet object with a given UUID
func (client *VSDataScriptSetClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VSDataScriptSet object with a given name
func (client *VSDataScriptSetClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
