package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SSLPROFILE_RES_NAME = "sslprofile"
)

// SSLProfileClient is a client for avi SSLProfile resource
type SSLProfileClient struct {
	avi_session *session.AviSession
}

// NewSSLProfileClient creates a new client for SSLProfile resource
func NewSSLProfileClient(avi_session *session.AviSession) *SSLProfileClient {
	return &SSLProfileClient{avi_session: avi_session}
}

func (client *SSLProfileClient) GetApiPath(uuid string) string {
	path := "api/" + SSLPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SSLProfile objects
func (client *SSLProfileClient) GetAll() ([]*models.SSLProfile, error) {
	var plist []*models.SSLProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing SSLProfile by uuid
func (client *SSLProfileClient) Get(uuid string) (*models.SSLProfile, error) {
	var obj *models.SSLProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing SSLProfile by name
func (client *SSLProfileClient) GetByName(name string) (*models.SSLProfile, error) {
	var obj *models.SSLProfile
	err := client.avi_session.GetObjectByName(SSLPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new SSLProfile object
func (client *SSLProfileClient) Create(obj *models.SSLProfile) (*models.SSLProfile, error) {
	var robj *models.SSLProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing SSLProfile object
func (client *SSLProfileClient) Update(obj *models.SSLProfile) (*models.SSLProfile, error) {
	var robj *models.SSLProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SSLProfile object with a given UUID
func (client *SSLProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing SSLProfile object with a given name
func (client *SSLProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
