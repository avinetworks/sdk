package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SCVSSTATEINFO_RES_NAME = "scvsstateinfo"
)

// SCVsStateInfoClient is a client for avi SCVsStateInfo resource
type SCVsStateInfoClient struct {
	avi_session *session.AviSession
}

// NewSCVsStateInfoClient creates a new client for SCVsStateInfo resource
func NewSCVsStateInfoClient(avi_session *session.AviSession) *SCVsStateInfoClient {
	return &SCVsStateInfoClient{avi_session: avi_session}
}

func (client *SCVsStateInfoClient) GetApiPath(uuid string) string {
	path := "api/" + SCVSSTATEINFO_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SCVsStateInfo objects
func (client *SCVsStateInfoClient) GetAll() ([]*models.SCVsStateInfo, error) {
	var plist []*models.SCVsStateInfo
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing SCVsStateInfo by uuid
func (client *SCVsStateInfoClient) Get(uuid string) (*models.SCVsStateInfo, error) {
	var obj *models.SCVsStateInfo
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing SCVsStateInfo by name
func (client *SCVsStateInfoClient) GetByName(name string) (*models.SCVsStateInfo, error) {
	var obj *models.SCVsStateInfo
	err := client.avi_session.GetObjectByName(SCVSSTATEINFO_RES_NAME, name, &obj)
	return obj, err
}

// Create a new SCVsStateInfo object
func (client *SCVsStateInfoClient) Create(obj *models.SCVsStateInfo) (*models.SCVsStateInfo, error) {
	var robj *models.SCVsStateInfo
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing SCVsStateInfo object
func (client *SCVsStateInfoClient) Update(obj *models.SCVsStateInfo) (*models.SCVsStateInfo, error) {
	var robj *models.SCVsStateInfo
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SCVsStateInfo object with a given UUID
func (client *SCVsStateInfoClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing SCVsStateInfo object with a given name
func (client *SCVsStateInfoClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
