package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	DEBUGCONTROLLER_RES_NAME = "debugcontroller"
)

// DebugControllerClient is a client for avi DebugController resource
type DebugControllerClient struct {
	avi_session *session.AviSession
}

// NewDebugControllerClient creates a new client for DebugController resource
func NewDebugControllerClient(avi_session *session.AviSession) *DebugControllerClient {
	return &DebugControllerClient{avi_session: avi_session}
}

func (client *DebugControllerClient) GetApiPath(uuid string) string {
	path := "api/" + DEBUGCONTROLLER_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of DebugController objects
func (client *DebugControllerClient) GetAll() ([]*models.DebugController, error) {
	var plist []*models.DebugController
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing DebugController by uuid
func (client *DebugControllerClient) Get(uuid string) (*models.DebugController, error) {
	var obj *models.DebugController
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing DebugController by name
func (client *DebugControllerClient) GetByName(name string) (*models.DebugController, error) {
	var obj *models.DebugController
	err := client.avi_session.GetObjectByName(DEBUGCONTROLLER_RES_NAME, name, &obj)
	return obj, err
}

// Create a new DebugController object
func (client *DebugControllerClient) Create(obj *models.DebugController) (*models.DebugController, error) {
	var robj *models.DebugController
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing DebugController object
func (client *DebugControllerClient) Update(obj *models.DebugController) (*models.DebugController, error) {
	var robj *models.DebugController
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing DebugController object with a given UUID
func (client *DebugControllerClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing DebugController object with a given name
func (client *DebugControllerClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
