package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	IPADDRGROUP_RES_NAME = "ipaddrgroup"
)

// IPAddrGroupClient is a client for avi IPAddrGroup resource
type IPAddrGroupClient struct {
	avi_session *session.AviSession
}

// NewIPAddrGroupClient creates a new client for IPAddrGroup resource
func NewIPAddrGroupClient(avi_session *session.AviSession) *IPAddrGroupClient {
	return &IPAddrGroupClient{avi_session: avi_session}
}

func (client *IPAddrGroupClient) GetApiPath(uuid string) string {
	path := "api/" + IPADDRGROUP_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of IPAddrGroup objects
func (client *IPAddrGroupClient) GetAll() ([]*models.IPAddrGroup, error) {
	var plist []*models.IPAddrGroup
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing IPAddrGroup by uuid
func (client *IPAddrGroupClient) Get(uuid string) (*models.IPAddrGroup, error) {
	var obj *models.IPAddrGroup
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing IPAddrGroup by name
func (client *IPAddrGroupClient) GetByName(name string) (*models.IPAddrGroup, error) {
	var obj *models.IPAddrGroup
	err := client.avi_session.GetObjectByName(IPADDRGROUP_RES_NAME, name, &obj)
	return obj, err
}

// Create a new IPAddrGroup object
func (client *IPAddrGroupClient) Create(obj *models.IPAddrGroup) (*models.IPAddrGroup, error) {
	var robj *models.IPAddrGroup
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing IPAddrGroup object
func (client *IPAddrGroupClient) Update(obj *models.IPAddrGroup) (*models.IPAddrGroup, error) {
	var robj *models.IPAddrGroup
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing IPAddrGroup object with a given UUID
func (client *IPAddrGroupClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing IPAddrGroup object with a given name
func (client *IPAddrGroupClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
