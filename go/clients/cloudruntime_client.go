package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	CLOUDRUNTIME_RES_NAME = "cloudruntime"
)

// CloudRuntimeClient is a client for avi CloudRuntime resource
type CloudRuntimeClient struct {
	avi_session *session.AviSession
}

// NewCloudRuntimeClient creates a new client for CloudRuntime resource
func NewCloudRuntimeClient(avi_session *session.AviSession) *CloudRuntimeClient {
	return &CloudRuntimeClient{avi_session: avi_session}
}

func (client *CloudRuntimeClient) GetApiPath(uuid string) string {
	path := "api/" + CLOUDRUNTIME_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of CloudRuntime objects
func (client *CloudRuntimeClient) GetAll() ([]*models.CloudRuntime, error) {
	var plist []*models.CloudRuntime
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing CloudRuntime by uuid
func (client *CloudRuntimeClient) Get(uuid string) (*models.CloudRuntime, error) {
	var obj *models.CloudRuntime
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing CloudRuntime by name
func (client *CloudRuntimeClient) GetByName(name string) (*models.CloudRuntime, error) {
	var obj *models.CloudRuntime
	err := client.avi_session.GetObjectByName(CLOUDRUNTIME_RES_NAME, name, &obj)
	return obj, err
}

// Create a new CloudRuntime object
func (client *CloudRuntimeClient) Create(obj *models.CloudRuntime) (*models.CloudRuntime, error) {
	var robj *models.CloudRuntime
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing CloudRuntime object
func (client *CloudRuntimeClient) Update(obj *models.CloudRuntime) (*models.CloudRuntime, error) {
	var robj *models.CloudRuntime
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing CloudRuntime object with a given UUID
func (client *CloudRuntimeClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing CloudRuntime object with a given name
func (client *CloudRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
