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

// VIMgrClusterRuntimeClient is a client for avi VIMgrClusterRuntime resource
type VIMgrClusterRuntimeClient struct {
	aviSession *session.AviSession
}

// NewVIMgrClusterRuntimeClient creates a new client for VIMgrClusterRuntime resource
func NewVIMgrClusterRuntimeClient(aviSession *session.AviSession) *VIMgrClusterRuntimeClient {
	return &VIMgrClusterRuntimeClient{aviSession: aviSession}
}

func (client *VIMgrClusterRuntimeClient) getAPIPath(uuid string, options ...session.ApiOptionsParams) (string, error) {
	path := "api/vimgrclusterruntime"
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

// GetAll is a collection API to get a list of VIMgrClusterRuntime objects
func (client *VIMgrClusterRuntimeClient) GetAll(options ...session.ApiOptionsParams) ([]*models.VIMgrClusterRuntime, error) {
	var plist []*models.VIMgrClusterRuntime
	path, err := client.getAPIPath("", options...)
	if err == nil {
		err = client.aviSession.GetCollection(path, &plist, options...)
	}
	return plist, err
}

// Get an existing VIMgrClusterRuntime by uuid
func (client *VIMgrClusterRuntimeClient) Get(uuid string, options ...session.ApiOptionsParams) (*models.VIMgrClusterRuntime, error) {
	var obj *models.VIMgrClusterRuntime
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Get(path, &obj, options...)
	return obj, err
}

// GetByName - Get an existing VIMgrClusterRuntime by name
func (client *VIMgrClusterRuntimeClient) GetByName(name string, options ...session.ApiOptionsParams) (*models.VIMgrClusterRuntime, error) {
	var obj *models.VIMgrClusterRuntime
	err := client.aviSession.GetObjectByName("vimgrclusterruntime", name, &obj, options...)
	return obj, err
}

// GetObject - Get an existing VIMgrClusterRuntime by filters like name, cloud, tenant
// Api creates VIMgrClusterRuntime object with every call.
func (client *VIMgrClusterRuntimeClient) GetObject(options ...session.ApiOptionsParams) (*models.VIMgrClusterRuntime, error) {
	var obj *models.VIMgrClusterRuntime
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("vimgrclusterruntime", newOptions...)
	return obj, err
}

// Create a new VIMgrClusterRuntime object
func (client *VIMgrClusterRuntimeClient) Create(obj *models.VIMgrClusterRuntime, options ...session.ApiOptionsParams) (*models.VIMgrClusterRuntime, error) {
	var robj *models.VIMgrClusterRuntime
	path, _ := client.getAPIPath("")
	err := client.aviSession.Post(path, obj, &robj, options...)
	return robj, err
}

// Update an existing VIMgrClusterRuntime object
func (client *VIMgrClusterRuntimeClient) Update(obj *models.VIMgrClusterRuntime, options ...session.ApiOptionsParams) (*models.VIMgrClusterRuntime, error) {
	var robj *models.VIMgrClusterRuntime
	path, _ := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj, options...)
	return robj, err
}

// Patch an existing VIMgrClusterRuntime object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.VIMgrClusterRuntime
// or it should be json compatible of form map[string]interface{}
func (client *VIMgrClusterRuntimeClient) Patch(uuid string, patch interface{}, patchOp string, options ...session.ApiOptionsParams) (*models.VIMgrClusterRuntime, error) {
	var robj *models.VIMgrClusterRuntime
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj, options...)
	return robj, err
}

// Delete an existing VIMgrClusterRuntime object with a given UUID
func (client *VIMgrClusterRuntimeClient) Delete(uuid string, options ...session.ApiOptionsParams) error {
	path, _ := client.getAPIPath(uuid)
	if len(options) == 0 {
		return client.aviSession.Delete(path)
	} else {
		return client.aviSession.DeleteObject(path, options...)
	}
}

// DeleteByName - Delete an existing VIMgrClusterRuntime object with a given name
func (client *VIMgrClusterRuntimeClient) DeleteByName(name string, options ...session.ApiOptionsParams) error {
	res, err := client.GetByName(name, options...)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID, options...)
}

// GetAviSession
func (client *VIMgrClusterRuntimeClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
