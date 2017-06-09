package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	HARDWARESECURITYMODULEGROUP_RES_NAME = "hardwaresecuritymodulegroup"
)

// HardwareSecurityModuleGroupClient is a client for avi HardwareSecurityModuleGroup resource
type HardwareSecurityModuleGroupClient struct {
	avi_session *session.AviSession
}

// NewHardwareSecurityModuleGroupClient creates a new client for HardwareSecurityModuleGroup resource
func NewHardwareSecurityModuleGroupClient(avi_session *session.AviSession) *HardwareSecurityModuleGroupClient {
	return &HardwareSecurityModuleGroupClient{avi_session: avi_session}
}

func (client *HardwareSecurityModuleGroupClient) GetApiPath(uuid string) string {
	path := "api/" + HARDWARESECURITYMODULEGROUP_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of HardwareSecurityModuleGroup objects
func (client *HardwareSecurityModuleGroupClient) GetAll() ([]*models.HardwareSecurityModuleGroup, error) {
	var plist []*models.HardwareSecurityModuleGroup
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing HardwareSecurityModuleGroup by uuid
func (client *HardwareSecurityModuleGroupClient) Get(uuid string) (*models.HardwareSecurityModuleGroup, error) {
	var obj *models.HardwareSecurityModuleGroup
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing HardwareSecurityModuleGroup by name
func (client *HardwareSecurityModuleGroupClient) GetByName(name string) (*models.HardwareSecurityModuleGroup, error) {
	var obj *models.HardwareSecurityModuleGroup
	err := client.avi_session.GetObjectByName(HARDWARESECURITYMODULEGROUP_RES_NAME, name, &obj)
	return obj, err
}

// Create a new HardwareSecurityModuleGroup object
func (client *HardwareSecurityModuleGroupClient) Create(obj *models.HardwareSecurityModuleGroup) (*models.HardwareSecurityModuleGroup, error) {
	var robj *models.HardwareSecurityModuleGroup
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing HardwareSecurityModuleGroup object
func (client *HardwareSecurityModuleGroupClient) Update(obj *models.HardwareSecurityModuleGroup) (*models.HardwareSecurityModuleGroup, error) {
	var robj *models.HardwareSecurityModuleGroup
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing HardwareSecurityModuleGroup object with a given UUID
func (client *HardwareSecurityModuleGroupClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing HardwareSecurityModuleGroup object with a given name
func (client *HardwareSecurityModuleGroupClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
