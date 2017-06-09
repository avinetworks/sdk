package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SCPOOLSERVERSTATEINFO_RES_NAME = "scpoolserverstateinfo"
)

// SCPoolServerStateInfoClient is a client for avi SCPoolServerStateInfo resource
type SCPoolServerStateInfoClient struct {
	avi_session *session.AviSession
}

// NewSCPoolServerStateInfoClient creates a new client for SCPoolServerStateInfo resource
func NewSCPoolServerStateInfoClient(avi_session *session.AviSession) *SCPoolServerStateInfoClient {
	return &SCPoolServerStateInfoClient{avi_session: avi_session}
}

func (client *SCPoolServerStateInfoClient) GetApiPath(uuid string) string {
	path := "api/" + SCPOOLSERVERSTATEINFO_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SCPoolServerStateInfo objects
func (client *SCPoolServerStateInfoClient) GetAll() ([]*models.SCPoolServerStateInfo, error) {
	var plist []*models.SCPoolServerStateInfo
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing SCPoolServerStateInfo by uuid
func (client *SCPoolServerStateInfoClient) Get(uuid string) (*models.SCPoolServerStateInfo, error) {
	var obj *models.SCPoolServerStateInfo
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing SCPoolServerStateInfo by name
func (client *SCPoolServerStateInfoClient) GetByName(name string) (*models.SCPoolServerStateInfo, error) {
	var obj *models.SCPoolServerStateInfo
	err := client.avi_session.GetObjectByName(SCPOOLSERVERSTATEINFO_RES_NAME, name, &obj)
	return obj, err
}

// Create a new SCPoolServerStateInfo object
func (client *SCPoolServerStateInfoClient) Create(obj *models.SCPoolServerStateInfo) (*models.SCPoolServerStateInfo, error) {
	var robj *models.SCPoolServerStateInfo
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing SCPoolServerStateInfo object
func (client *SCPoolServerStateInfoClient) Update(obj *models.SCPoolServerStateInfo) (*models.SCPoolServerStateInfo, error) {
	var robj *models.SCPoolServerStateInfo
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SCPoolServerStateInfo object with a given UUID
func (client *SCPoolServerStateInfoClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing SCPoolServerStateInfo object with a given name
func (client *SCPoolServerStateInfoClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
