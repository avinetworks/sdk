package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SNMPTRAPPROFILE_RES_NAME = "snmptrapprofile"
)

// SnmpTrapProfileClient is a client for avi SnmpTrapProfile resource
type SnmpTrapProfileClient struct {
	avi_session *session.AviSession
}

// NewSnmpTrapProfileClient creates a new client for SnmpTrapProfile resource
func NewSnmpTrapProfileClient(avi_session *session.AviSession) *SnmpTrapProfileClient {
	return &SnmpTrapProfileClient{avi_session: avi_session}
}

func (client *SnmpTrapProfileClient) GetApiPath(uuid string) string {
	path := "api/" + SNMPTRAPPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SnmpTrapProfile objects
func (client *SnmpTrapProfileClient) GetAll() ([]*models.SnmpTrapProfile, error) {
	var plist []*models.SnmpTrapProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing SnmpTrapProfile by uuid
func (client *SnmpTrapProfileClient) Get(uuid string) (*models.SnmpTrapProfile, error) {
	var obj *models.SnmpTrapProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing SnmpTrapProfile by name
func (client *SnmpTrapProfileClient) GetByName(name string) (*models.SnmpTrapProfile, error) {
	var obj *models.SnmpTrapProfile
	err := client.avi_session.GetObjectByName(SNMPTRAPPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new SnmpTrapProfile object
func (client *SnmpTrapProfileClient) Create(obj *models.SnmpTrapProfile) (*models.SnmpTrapProfile, error) {
	var robj *models.SnmpTrapProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing SnmpTrapProfile object
func (client *SnmpTrapProfileClient) Update(obj *models.SnmpTrapProfile) (*models.SnmpTrapProfile, error) {
	var robj *models.SnmpTrapProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SnmpTrapProfile object with a given UUID
func (client *SnmpTrapProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing SnmpTrapProfile object with a given name
func (client *SnmpTrapProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
