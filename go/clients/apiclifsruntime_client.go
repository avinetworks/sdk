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

// APICLifsRuntimeClient is a client for avi APICLifsRuntime resource
type APICLifsRuntimeClient struct {
	aviSession *session.AviSession
}

// NewAPICLifsRuntimeClient creates a new client for APICLifsRuntime resource
func NewAPICLifsRuntimeClient(aviSession *session.AviSession) *APICLifsRuntimeClient {
	return &APICLifsRuntimeClient{aviSession: aviSession}
}

func (client *APICLifsRuntimeClient) getAPIPath(uuid string, options ...session.ApiOptionsParams) (string, error) {
	path := "api/apiclifsruntime"
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

// GetAll is a collection API to get a list of APICLifsRuntime objects
func (client *APICLifsRuntimeClient) GetAll(options ...session.ApiOptionsParams) ([]*models.APICLifsRuntime, error) {
	var plist []*models.APICLifsRuntime
	path, err := client.getAPIPath("", options...)
	if err == nil {
		err = client.aviSession.GetCollection(path, &plist, options...)
	}
	return plist, err
}

// Get an existing APICLifsRuntime by uuid
func (client *APICLifsRuntimeClient) Get(uuid string, options ...session.ApiOptionsParams) (*models.APICLifsRuntime, error) {
	var obj *models.APICLifsRuntime
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Get(path, &obj, options...)
	return obj, err
}

// GetByName - Get an existing APICLifsRuntime by name
func (client *APICLifsRuntimeClient) GetByName(name string, options ...session.ApiOptionsParams) (*models.APICLifsRuntime, error) {
	var obj *models.APICLifsRuntime
	err := client.aviSession.GetObjectByName("apiclifsruntime", name, &obj, options...)
	return obj, err
}

// GetObject - Get an existing APICLifsRuntime by filters like name, cloud, tenant
// Api creates APICLifsRuntime object with every call.
func (client *APICLifsRuntimeClient) GetObject(options ...session.ApiOptionsParams) (*models.APICLifsRuntime, error) {
	var obj *models.APICLifsRuntime
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("apiclifsruntime", newOptions...)
	return obj, err
}

// Create a new APICLifsRuntime object
func (client *APICLifsRuntimeClient) Create(obj *models.APICLifsRuntime, options ...session.ApiOptionsParams) (*models.APICLifsRuntime, error) {
	var robj *models.APICLifsRuntime
	path, _ := client.getAPIPath("")
	err := client.aviSession.Post(path, obj, &robj, options...)
	return robj, err
}

// Update an existing APICLifsRuntime object
func (client *APICLifsRuntimeClient) Update(obj *models.APICLifsRuntime, options ...session.ApiOptionsParams) (*models.APICLifsRuntime, error) {
	var robj *models.APICLifsRuntime
	path, _ := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj, options...)
	return robj, err
}

// Patch an existing APICLifsRuntime object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.APICLifsRuntime
// or it should be json compatible of form map[string]interface{}
func (client *APICLifsRuntimeClient) Patch(uuid string, patch interface{}, patchOp string, options ...session.ApiOptionsParams) (*models.APICLifsRuntime, error) {
	var robj *models.APICLifsRuntime
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj, options...)
	return robj, err
}

// Delete an existing APICLifsRuntime object with a given UUID
func (client *APICLifsRuntimeClient) Delete(uuid string, options ...session.ApiOptionsParams) error {
	path, _ := client.getAPIPath(uuid)
	if len(options) == 0 {
		return client.aviSession.Delete(path)
	} else {
		return client.aviSession.DeleteObject(path, options...)
	}
}

// DeleteByName - Delete an existing APICLifsRuntime object with a given name
func (client *APICLifsRuntimeClient) DeleteByName(name string, options ...session.ApiOptionsParams) error {
	res, err := client.GetByName(name, options...)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID, options...)
}

// GetAviSession
func (client *APICLifsRuntimeClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
