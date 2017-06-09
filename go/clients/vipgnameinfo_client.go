package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VIPGNAMEINFO_RES_NAME = "vipgnameinfo"
)

// VIPGNameInfoClient is a client for avi VIPGNameInfo resource
type VIPGNameInfoClient struct {
	avi_session *session.AviSession
}

// NewVIPGNameInfoClient creates a new client for VIPGNameInfo resource
func NewVIPGNameInfoClient(avi_session *session.AviSession) *VIPGNameInfoClient {
	return &VIPGNameInfoClient{avi_session: avi_session}
}

func (client *VIPGNameInfoClient) GetApiPath(uuid string) string {
	path := "api/" + VIPGNAMEINFO_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIPGNameInfo objects
func (client *VIPGNameInfoClient) GetAll() ([]*models.VIPGNameInfo, error) {
	var plist []*models.VIPGNameInfo
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VIPGNameInfo by uuid
func (client *VIPGNameInfoClient) Get(uuid string) (*models.VIPGNameInfo, error) {
	var obj *models.VIPGNameInfo
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VIPGNameInfo by name
func (client *VIPGNameInfoClient) GetByName(name string) (*models.VIPGNameInfo, error) {
	var obj *models.VIPGNameInfo
	err := client.avi_session.GetObjectByName(VIPGNAMEINFO_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VIPGNameInfo object
func (client *VIPGNameInfoClient) Create(obj *models.VIPGNameInfo) (*models.VIPGNameInfo, error) {
	var robj *models.VIPGNameInfo
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIPGNameInfo object
func (client *VIPGNameInfoClient) Update(obj *models.VIPGNameInfo) (*models.VIPGNameInfo, error) {
	var robj *models.VIPGNameInfo
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIPGNameInfo object with a given UUID
func (client *VIPGNameInfoClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VIPGNameInfo object with a given name
func (client *VIPGNameInfoClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
