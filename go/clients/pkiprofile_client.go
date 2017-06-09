package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	PKIPROFILE_RES_NAME = "pkiprofile"
)

// PKIprofileClient is a client for avi PKIprofile resource
type PKIprofileClient struct {
	avi_session *session.AviSession
}

// NewPKIprofileClient creates a new client for PKIprofile resource
func NewPKIprofileClient(avi_session *session.AviSession) *PKIprofileClient {
	return &PKIprofileClient{avi_session: avi_session}
}

func (client *PKIprofileClient) GetApiPath(uuid string) string {
	path := "api/" + PKIPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of PKIprofile objects
func (client *PKIprofileClient) GetAll() ([]*models.PKIprofile, error) {
	var plist []*models.PKIprofile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing PKIprofile by uuid
func (client *PKIprofileClient) Get(uuid string) (*models.PKIprofile, error) {
	var obj *models.PKIprofile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing PKIprofile by name
func (client *PKIprofileClient) GetByName(name string) (*models.PKIprofile, error) {
	var obj *models.PKIprofile
	err := client.avi_session.GetObjectByName(PKIPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new PKIprofile object
func (client *PKIprofileClient) Create(obj *models.PKIprofile) (*models.PKIprofile, error) {
	var robj *models.PKIprofile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing PKIprofile object
func (client *PKIprofileClient) Update(obj *models.PKIprofile) (*models.PKIprofile, error) {
	var robj *models.PKIprofile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing PKIprofile object with a given UUID
func (client *PKIprofileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing PKIprofile object with a given name
func (client *PKIprofileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
