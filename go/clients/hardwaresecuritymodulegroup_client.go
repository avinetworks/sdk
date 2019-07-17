/***************************************************************************
 *
 * AVI CONFIDENTIAL
 * __________________
 *
 * [2013] - [2018] Avi Networks Incorporated
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of Avi Networks Incorporated and its suppliers, if any. The intellectual
 * and technical concepts contained herein are proprietary to Avi Networks
 * Incorporated, and its suppliers and are covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or
 * copyright law, and other laws. Dissemination of this information or
 * reproduction of this material is strictly forbidden unless prior written
 * permission is obtained from Avi Networks Incorporated.
 */

package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

// HardwareSecurityModuleGroupClient is a client for avi HardwareSecurityModuleGroup resource
type HardwareSecurityModuleGroupClient struct {
	aviSession *session.AviSession
}

// NewHardwareSecurityModuleGroupClient creates a new client for HardwareSecurityModuleGroup resource
func NewHardwareSecurityModuleGroupClient(aviSession *session.AviSession) *HardwareSecurityModuleGroupClient {
	return &HardwareSecurityModuleGroupClient{aviSession: aviSession}
}

func (client *HardwareSecurityModuleGroupClient) getAPIPath(uuid string, options ...session.ApiOptionsParams) (string, error) {
	path := "api/hardwaresecuritymodulegroup"
	var err error
	if uuid != "" {
		path += "/" + uuid
	} else {
		path, err = session.SetApiFilter(path, options...)
		if err != nil {
			return "", err
		}
	}
	return path, nil
}

// GetAll is a collection API to get a list of HardwareSecurityModuleGroup objects
func (client *HardwareSecurityModuleGroupClient) GetAll(options ...session.ApiOptionsParams) ([]*models.HardwareSecurityModuleGroup, error) {
	var plist []*models.HardwareSecurityModuleGroup
	path, err := client.getAPIPath("", options...)
	if err == nil {
		err = client.aviSession.GetCollection(path, &plist, options...)
	}
	return plist, err
}

// Get an existing HardwareSecurityModuleGroup by uuid
func (client *HardwareSecurityModuleGroupClient) Get(uuid string, options ...session.ApiOptionsParams) (*models.HardwareSecurityModuleGroup, error) {
	var obj *models.HardwareSecurityModuleGroup
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Get(path, &obj, options...)
	return obj, err
}

// GetByName - Get an existing HardwareSecurityModuleGroup by name
func (client *HardwareSecurityModuleGroupClient) GetByName(name string, options ...session.ApiOptionsParams) (*models.HardwareSecurityModuleGroup, error) {
	var obj *models.HardwareSecurityModuleGroup
	err := client.aviSession.GetObjectByName("hardwaresecuritymodulegroup", name, &obj, options...)
	return obj, err
}

// GetObject - Get an existing HardwareSecurityModuleGroup by filters like name, cloud, tenant
// Api creates HardwareSecurityModuleGroup object with every call.
func (client *HardwareSecurityModuleGroupClient) GetObject(options ...session.ApiOptionsParams) (*models.HardwareSecurityModuleGroup, error) {
	var obj *models.HardwareSecurityModuleGroup
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("hardwaresecuritymodulegroup", newOptions...)
	return obj, err
}

// Create a new HardwareSecurityModuleGroup object
func (client *HardwareSecurityModuleGroupClient) Create(obj *models.HardwareSecurityModuleGroup, options ...session.ApiOptionsParams) (*models.HardwareSecurityModuleGroup, error) {
	var robj *models.HardwareSecurityModuleGroup
	path, _ := client.getAPIPath("")
	err := client.aviSession.Post(path, obj, &robj, options...)
	return robj, err
}

// Update an existing HardwareSecurityModuleGroup object
func (client *HardwareSecurityModuleGroupClient) Update(obj *models.HardwareSecurityModuleGroup, options ...session.ApiOptionsParams) (*models.HardwareSecurityModuleGroup, error) {
	var robj *models.HardwareSecurityModuleGroup
	path, _ := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj, options...)
	return robj, err
}

// Patch an existing HardwareSecurityModuleGroup object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.HardwareSecurityModuleGroup
// or it should be json compatible of form map[string]interface{}
func (client *HardwareSecurityModuleGroupClient) Patch(uuid string, patch interface{}, patchOp string, options ...session.ApiOptionsParams) (*models.HardwareSecurityModuleGroup, error) {
	var robj *models.HardwareSecurityModuleGroup
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj, options...)
	return robj, err
}

// Delete an existing HardwareSecurityModuleGroup object with a given UUID
func (client *HardwareSecurityModuleGroupClient) Delete(uuid string, options ...session.ApiOptionsParams) error {
	path, _ := client.getAPIPath(uuid)
	if len(options) == 0 {
		return client.aviSession.Delete(path)
	} else {
		return client.aviSession.DeleteObject(path, options...)
	}
}

// DeleteByName - Delete an existing HardwareSecurityModuleGroup object with a given name
func (client *HardwareSecurityModuleGroupClient) DeleteByName(name string, options ...session.ApiOptionsParams) error {
	res, err := client.GetByName(name, options...)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID, options...)
}

// GetAviSession
func (client *HardwareSecurityModuleGroupClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
