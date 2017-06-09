package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	VSVIP_RES_NAME = "vsvip"
)

// VsVipClient is a client for avi VsVip resource
type VsVipClient struct {
	avi_session *session.AviSession
}

// NewVsVipClient creates a new client for VsVip resource
func NewVsVipClient(avi_session *session.AviSession) *VsVipClient {
	return &VsVipClient{avi_session: avi_session}
}

func (client *VsVipClient) GetApiPath(uuid string) string {
	path := "api/" + VSVIP_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VsVip objects
func (client *VsVipClient) GetAll() ([]*models.VsVip, error) {
	var plist []*models.VsVip
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing VsVip by uuid
func (client *VsVipClient) Get(uuid string) (*models.VsVip, error) {
	var obj *models.VsVip
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing VsVip by name
func (client *VsVipClient) GetByName(name string) (*models.VsVip, error) {
	var obj *models.VsVip
	err := client.avi_session.GetObjectByName(VSVIP_RES_NAME, name, &obj)
	return obj, err
}

// Create a new VsVip object
func (client *VsVipClient) Create(obj *models.VsVip) (*models.VsVip, error) {
	var robj *models.VsVip
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing VsVip object
func (client *VsVipClient) Update(obj *models.VsVip) (*models.VsVip, error) {
	var robj *models.VsVip
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VsVip object with a given UUID
func (client *VsVipClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing VsVip object with a given name
func (client *VsVipClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
