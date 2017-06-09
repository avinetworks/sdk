package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	APICLIFSRUNTIME_RES_NAME = "apiclifsruntime"
)

// APICLifsRuntimeClient is a client for avi APICLifsRuntime resource
type APICLifsRuntimeClient struct {
	avi_session *session.AviSession
}

// NewAPICLifsRuntimeClient creates a new client for APICLifsRuntime resource
func NewAPICLifsRuntimeClient(avi_session *session.AviSession) *APICLifsRuntimeClient {
	return &APICLifsRuntimeClient{avi_session: avi_session}
}

func (client *APICLifsRuntimeClient) GetApiPath(uuid string) string {
	path := "api/" + APICLIFSRUNTIME_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of APICLifsRuntime objects
func (client *APICLifsRuntimeClient) GetAll() ([]*models.APICLifsRuntime, error) {
	var plist []*models.APICLifsRuntime
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing APICLifsRuntime by uuid
func (client *APICLifsRuntimeClient) Get(uuid string) (*models.APICLifsRuntime, error) {
	var obj *models.APICLifsRuntime
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing APICLifsRuntime by name
func (client *APICLifsRuntimeClient) GetByName(name string) (*models.APICLifsRuntime, error) {
	var obj *models.APICLifsRuntime
	err := client.avi_session.GetObjectByName(APICLIFSRUNTIME_RES_NAME, name, &obj)
	return obj, err
}

// Create a new APICLifsRuntime object
func (client *APICLifsRuntimeClient) Create(obj *models.APICLifsRuntime) (*models.APICLifsRuntime, error) {
	var robj *models.APICLifsRuntime
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing APICLifsRuntime object
func (client *APICLifsRuntimeClient) Update(obj *models.APICLifsRuntime) (*models.APICLifsRuntime, error) {
	var robj *models.APICLifsRuntime
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing APICLifsRuntime object with a given UUID
func (client *APICLifsRuntimeClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing APICLifsRuntime object with a given name
func (client *APICLifsRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
