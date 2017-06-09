package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	CONTROLLERLICENSE_RES_NAME = "controllerlicense"
)

// ControllerLicenseClient is a client for avi ControllerLicense resource
type ControllerLicenseClient struct {
	avi_session *session.AviSession
}

// NewControllerLicenseClient creates a new client for ControllerLicense resource
func NewControllerLicenseClient(avi_session *session.AviSession) *ControllerLicenseClient {
	return &ControllerLicenseClient{avi_session: avi_session}
}

func (client *ControllerLicenseClient) GetApiPath(uuid string) string {
	path := "api/" + CONTROLLERLICENSE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of ControllerLicense objects
func (client *ControllerLicenseClient) GetAll() ([]*models.ControllerLicense, error) {
	var plist []*models.ControllerLicense
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing ControllerLicense by uuid
func (client *ControllerLicenseClient) Get(uuid string) (*models.ControllerLicense, error) {
	var obj *models.ControllerLicense
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing ControllerLicense by name
func (client *ControllerLicenseClient) GetByName(name string) (*models.ControllerLicense, error) {
	var obj *models.ControllerLicense
	err := client.avi_session.GetObjectByName(CONTROLLERLICENSE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new ControllerLicense object
func (client *ControllerLicenseClient) Create(obj *models.ControllerLicense) (*models.ControllerLicense, error) {
	var robj *models.ControllerLicense
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing ControllerLicense object
func (client *ControllerLicenseClient) Update(obj *models.ControllerLicense) (*models.ControllerLicense, error) {
	var robj *models.ControllerLicense
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing ControllerLicense object with a given UUID
func (client *ControllerLicenseClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing ControllerLicense object with a given name
func (client *ControllerLicenseClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
