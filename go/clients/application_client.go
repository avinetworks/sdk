package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	APPLICATION_RES_NAME = "application"
)

// ApplicationClient is a client for avi Application resource
type ApplicationClient struct {
	avi_session *session.AviSession
}

// NewApplicationClient creates a new client for Application resource
func NewApplicationClient(avi_session *session.AviSession) *ApplicationClient {
	return &ApplicationClient{avi_session: avi_session}
}

func (client *ApplicationClient) GetApiPath(uuid string) string {
	path := "api/" + APPLICATION_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Application objects
func (client *ApplicationClient) GetAll() ([]*models.Application, error) {
	var plist []*models.Application
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing Application by uuid
func (client *ApplicationClient) Get(uuid string) (*models.Application, error) {
	var obj *models.Application
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing Application by name
func (client *ApplicationClient) GetByName(name string) (*models.Application, error) {
	var obj *models.Application
	err := client.avi_session.GetObjectByName(APPLICATION_RES_NAME, name, &obj)
	return obj, err
}

// Create a new Application object
func (client *ApplicationClient) Create(obj *models.Application) (*models.Application, error) {
	var robj *models.Application
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing Application object
func (client *ApplicationClient) Update(obj *models.Application) (*models.Application, error) {
	var robj *models.Application
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Application object with a given UUID
func (client *ApplicationClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing Application object with a given name
func (client *ApplicationClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
