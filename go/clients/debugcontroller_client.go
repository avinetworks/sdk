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

// DebugControllerClient is a client for avi DebugController resource
type DebugControllerClient struct {
	aviSession *session.AviSession
}

// NewDebugControllerClient creates a new client for DebugController resource
func NewDebugControllerClient(aviSession *session.AviSession) *DebugControllerClient {
	return &DebugControllerClient{aviSession: aviSession}
}

func (client *DebugControllerClient) getAPIPath(uuid string, options ...session.ApiOptionsParams) (string, error) {
	path := "api/debugcontroller"
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

// GetAll is a collection API to get a list of DebugController objects
func (client *DebugControllerClient) GetAll(options ...session.ApiOptionsParams) ([]*models.DebugController, error) {
	var plist []*models.DebugController
	path, err := client.getAPIPath("", options...)
	if err == nil {
		err = client.aviSession.GetCollection(path, &plist, options...)
	}
	return plist, err
}

// Get an existing DebugController by uuid
func (client *DebugControllerClient) Get(uuid string, options ...session.ApiOptionsParams) (*models.DebugController, error) {
	var obj *models.DebugController
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Get(path, &obj, options...)
	return obj, err
}

// GetByName - Get an existing DebugController by name
func (client *DebugControllerClient) GetByName(name string, options ...session.ApiOptionsParams) (*models.DebugController, error) {
	var obj *models.DebugController
	err := client.aviSession.GetObjectByName("debugcontroller", name, &obj, options...)
	return obj, err
}

// GetObject - Get an existing DebugController by filters like name, cloud, tenant
// Api creates DebugController object with every call.
func (client *DebugControllerClient) GetObject(options ...session.ApiOptionsParams) (*models.DebugController, error) {
	var obj *models.DebugController
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("debugcontroller", newOptions...)
	return obj, err
}

// Create a new DebugController object
func (client *DebugControllerClient) Create(obj *models.DebugController, options ...session.ApiOptionsParams) (*models.DebugController, error) {
	var robj *models.DebugController
	path, _ := client.getAPIPath("")
	err := client.aviSession.Post(path, obj, &robj, options...)
	return robj, err
}

// Update an existing DebugController object
func (client *DebugControllerClient) Update(obj *models.DebugController, options ...session.ApiOptionsParams) (*models.DebugController, error) {
	var robj *models.DebugController
	path, _ := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj, options...)
	return robj, err
}

// Patch an existing DebugController object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.DebugController
// or it should be json compatible of form map[string]interface{}
func (client *DebugControllerClient) Patch(uuid string, patch interface{}, patchOp string, options ...session.ApiOptionsParams) (*models.DebugController, error) {
	var robj *models.DebugController
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj, options...)
	return robj, err
}

// Delete an existing DebugController object with a given UUID
func (client *DebugControllerClient) Delete(uuid string, options ...session.ApiOptionsParams) error {
	path, _ := client.getAPIPath(uuid)
	if len(options) == 0 {
		return client.aviSession.Delete(path)
	} else {
		return client.aviSession.DeleteObject(path, options...)
	}
}

// DeleteByName - Delete an existing DebugController object with a given name
func (client *DebugControllerClient) DeleteByName(name string, options ...session.ApiOptionsParams) error {
	res, err := client.GetByName(name, options...)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID, options...)
}

// GetAviSession
func (client *DebugControllerClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
