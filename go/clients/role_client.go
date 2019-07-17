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

// RoleClient is a client for avi Role resource
type RoleClient struct {
	aviSession *session.AviSession
}

// NewRoleClient creates a new client for Role resource
func NewRoleClient(aviSession *session.AviSession) *RoleClient {
	return &RoleClient{aviSession: aviSession}
}

func (client *RoleClient) getAPIPath(uuid string, options ...session.ApiOptionsParams) (string, error) {
	path := "api/role"
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

// GetAll is a collection API to get a list of Role objects
func (client *RoleClient) GetAll(options ...session.ApiOptionsParams) ([]*models.Role, error) {
	var plist []*models.Role
	path, err := client.getAPIPath("", options...)
	if err == nil {
		err = client.aviSession.GetCollection(path, &plist, options...)
	}
	return plist, err
}

// Get an existing Role by uuid
func (client *RoleClient) Get(uuid string, options ...session.ApiOptionsParams) (*models.Role, error) {
	var obj *models.Role
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Get(path, &obj, options...)
	return obj, err
}

// GetByName - Get an existing Role by name
func (client *RoleClient) GetByName(name string, options ...session.ApiOptionsParams) (*models.Role, error) {
	var obj *models.Role
	err := client.aviSession.GetObjectByName("role", name, &obj, options...)
	return obj, err
}

// GetObject - Get an existing Role by filters like name, cloud, tenant
// Api creates Role object with every call.
func (client *RoleClient) GetObject(options ...session.ApiOptionsParams) (*models.Role, error) {
	var obj *models.Role
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("role", newOptions...)
	return obj, err
}

// Create a new Role object
func (client *RoleClient) Create(obj *models.Role, options ...session.ApiOptionsParams) (*models.Role, error) {
	var robj *models.Role
	path, _ := client.getAPIPath("")
	err := client.aviSession.Post(path, obj, &robj, options...)
	return robj, err
}

// Update an existing Role object
func (client *RoleClient) Update(obj *models.Role, options ...session.ApiOptionsParams) (*models.Role, error) {
	var robj *models.Role
	path, _ := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj, options...)
	return robj, err
}

// Patch an existing Role object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.Role
// or it should be json compatible of form map[string]interface{}
func (client *RoleClient) Patch(uuid string, patch interface{}, patchOp string, options ...session.ApiOptionsParams) (*models.Role, error) {
	var robj *models.Role
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj, options...)
	return robj, err
}

// Delete an existing Role object with a given UUID
func (client *RoleClient) Delete(uuid string, options ...session.ApiOptionsParams) error {
	path, _ := client.getAPIPath(uuid)
	if len(options) == 0 {
		return client.aviSession.Delete(path)
	} else {
		return client.aviSession.DeleteObject(path, options...)
	}
}

// DeleteByName - Delete an existing Role object with a given name
func (client *RoleClient) DeleteByName(name string, options ...session.ApiOptionsParams) error {
	res, err := client.GetByName(name, options...)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID, options...)
}

// GetAviSession
func (client *RoleClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
