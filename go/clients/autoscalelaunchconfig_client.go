package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	AUTOSCALELAUNCHCONFIG_RES_NAME = "autoscalelaunchconfig"
)

// AutoScaleLaunchConfigClient is a client for avi AutoScaleLaunchConfig resource
type AutoScaleLaunchConfigClient struct {
	avi_session *session.AviSession
}

// NewAutoScaleLaunchConfigClient creates a new client for AutoScaleLaunchConfig resource
func NewAutoScaleLaunchConfigClient(avi_session *session.AviSession) *AutoScaleLaunchConfigClient {
	return &AutoScaleLaunchConfigClient{avi_session: avi_session}
}

func (client *AutoScaleLaunchConfigClient) GetApiPath(uuid string) string {
	path := "api/" + AUTOSCALELAUNCHCONFIG_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of AutoScaleLaunchConfig objects
func (client *AutoScaleLaunchConfigClient) GetAll() ([]*models.AutoScaleLaunchConfig, error) {
	var plist []*models.AutoScaleLaunchConfig
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing AutoScaleLaunchConfig by uuid
func (client *AutoScaleLaunchConfigClient) Get(uuid string) (*models.AutoScaleLaunchConfig, error) {
	var obj *models.AutoScaleLaunchConfig
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing AutoScaleLaunchConfig by name
func (client *AutoScaleLaunchConfigClient) GetByName(name string) (*models.AutoScaleLaunchConfig, error) {
	var obj *models.AutoScaleLaunchConfig
	err := client.avi_session.GetObjectByName(AUTOSCALELAUNCHCONFIG_RES_NAME, name, &obj)
	return obj, err
}

// Create a new AutoScaleLaunchConfig object
func (client *AutoScaleLaunchConfigClient) Create(obj *models.AutoScaleLaunchConfig) (*models.AutoScaleLaunchConfig, error) {
	var robj *models.AutoScaleLaunchConfig
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing AutoScaleLaunchConfig object
func (client *AutoScaleLaunchConfigClient) Update(obj *models.AutoScaleLaunchConfig) (*models.AutoScaleLaunchConfig, error) {
	var robj *models.AutoScaleLaunchConfig
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing AutoScaleLaunchConfig object with a given UUID
func (client *AutoScaleLaunchConfigClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing AutoScaleLaunchConfig object with a given name
func (client *AutoScaleLaunchConfigClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
