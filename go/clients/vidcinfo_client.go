package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VIDCINFO_RES_NAME = "vidcinfo"
)

// VIDCInfoClient is a client for avi VIDCInfo resource
type VIDCInfoClient struct {
	avi_session *session.AviSession
}

// NewVIDCInfoClient creates a new client for VIDCInfo resource
func NewVIDCInfoClient(avi_session *session.AviSession) *VIDCInfoClient {
	return &VIDCInfoClient{avi_session: avi_session}
}

func (client *VIDCInfoClient) GetApiPath(uuid string) string {
	path := "api/" + VIDCINFO_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIDCInfo objects
func (client *VIDCInfoClient) GetAll() ([]*models.VIDCInfo, error) {
	var plist []*models.VIDCInfo
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VIDCInfo by uuid
func (client *VIDCInfoClient) Get(uuid string) (*models.VIDCInfo, error) {
	var obj *models.VIDCInfo
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VIDCInfo by name
func (client *VIDCInfoClient) GetByName(name string) (*models.VIDCInfo, error) {
	var obj *models.VIDCInfo
	err := client.avi_session.GetObjectByName(VIDCINFO_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VIDCInfo object
func (client *VIDCInfoClient) Create(obj *models.VIDCInfo) (*models.VIDCInfo, error) {
	var robj *models.VIDCInfo
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIDCInfo object
func (client *VIDCInfoClient) Update(obj *models.VIDCInfo) (*models.VIDCInfo, error) {
	var robj *models.VIDCInfo
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIDCInfo object with a given UUID
func (client *VIDCInfoClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VIDCInfo object with a given name
func (client *VIDCInfoClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
