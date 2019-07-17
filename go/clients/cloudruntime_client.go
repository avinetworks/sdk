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

// CloudRuntimeClient is a client for avi CloudRuntime resource
type CloudRuntimeClient struct {
	aviSession *session.AviSession
}

// NewCloudRuntimeClient creates a new client for CloudRuntime resource
func NewCloudRuntimeClient(aviSession *session.AviSession) *CloudRuntimeClient {
	return &CloudRuntimeClient{aviSession: aviSession}
}

func (client *CloudRuntimeClient) getAPIPath(uuid string, options ...session.ApiOptionsParams) (string, error) {
	path := "api/cloudruntime"
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

// GetAll is a collection API to get a list of CloudRuntime objects
func (client *CloudRuntimeClient) GetAll(options ...session.ApiOptionsParams) ([]*models.CloudRuntime, error) {
	var plist []*models.CloudRuntime
	path, err := client.getAPIPath("", options...)
	if err == nil {
		err = client.aviSession.GetCollection(path, &plist, options...)
	}
	return plist, err
}

// Get an existing CloudRuntime by uuid
func (client *CloudRuntimeClient) Get(uuid string, options ...session.ApiOptionsParams) (*models.CloudRuntime, error) {
	var obj *models.CloudRuntime
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Get(path, &obj, options...)
	return obj, err
}

// GetByName - Get an existing CloudRuntime by name
func (client *CloudRuntimeClient) GetByName(name string, options ...session.ApiOptionsParams) (*models.CloudRuntime, error) {
	var obj *models.CloudRuntime
	err := client.aviSession.GetObjectByName("cloudruntime", name, &obj, options...)
	return obj, err
}

// GetObject - Get an existing CloudRuntime by filters like name, cloud, tenant
// Api creates CloudRuntime object with every call.
func (client *CloudRuntimeClient) GetObject(options ...session.ApiOptionsParams) (*models.CloudRuntime, error) {
	var obj *models.CloudRuntime
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("cloudruntime", newOptions...)
	return obj, err
}

// Create a new CloudRuntime object
func (client *CloudRuntimeClient) Create(obj *models.CloudRuntime, options ...session.ApiOptionsParams) (*models.CloudRuntime, error) {
	var robj *models.CloudRuntime
	path, _ := client.getAPIPath("")
	err := client.aviSession.Post(path, obj, &robj, options...)
	return robj, err
}

// Update an existing CloudRuntime object
func (client *CloudRuntimeClient) Update(obj *models.CloudRuntime, options ...session.ApiOptionsParams) (*models.CloudRuntime, error) {
	var robj *models.CloudRuntime
	path, _ := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj, options...)
	return robj, err
}

// Patch an existing CloudRuntime object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.CloudRuntime
// or it should be json compatible of form map[string]interface{}
func (client *CloudRuntimeClient) Patch(uuid string, patch interface{}, patchOp string, options ...session.ApiOptionsParams) (*models.CloudRuntime, error) {
	var robj *models.CloudRuntime
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj, options...)
	return robj, err
}

// Delete an existing CloudRuntime object with a given UUID
func (client *CloudRuntimeClient) Delete(uuid string, options ...session.ApiOptionsParams) error {
	path, _ := client.getAPIPath(uuid)
	if len(options) == 0 {
		return client.aviSession.Delete(path)
	} else {
		return client.aviSession.DeleteObject(path, options...)
	}
}

// DeleteByName - Delete an existing CloudRuntime object with a given name
func (client *CloudRuntimeClient) DeleteByName(name string, options ...session.ApiOptionsParams) error {
	res, err := client.GetByName(name, options...)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID, options...)
}

// GetAviSession
func (client *CloudRuntimeClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
