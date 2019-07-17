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

// CloudClient is a client for avi Cloud resource
type CloudClient struct {
	aviSession *session.AviSession
}

// NewCloudClient creates a new client for Cloud resource
func NewCloudClient(aviSession *session.AviSession) *CloudClient {
	return &CloudClient{aviSession: aviSession}
}

func (client *CloudClient) getAPIPath(uuid string, options ...session.ApiOptionsParams) (string, error) {
	path := "api/cloud"
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

// GetAll is a collection API to get a list of Cloud objects
func (client *CloudClient) GetAll(options ...session.ApiOptionsParams) ([]*models.Cloud, error) {
	var plist []*models.Cloud
	path, err := client.getAPIPath("", options...)
	if err == nil {
		err = client.aviSession.GetCollection(path, &plist, options...)
	}
	return plist, err
}

// Get an existing Cloud by uuid
func (client *CloudClient) Get(uuid string, options ...session.ApiOptionsParams) (*models.Cloud, error) {
	var obj *models.Cloud
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Get(path, &obj, options...)
	return obj, err
}

// GetByName - Get an existing Cloud by name
func (client *CloudClient) GetByName(name string, options ...session.ApiOptionsParams) (*models.Cloud, error) {
	var obj *models.Cloud
	err := client.aviSession.GetObjectByName("cloud", name, &obj, options...)
	return obj, err
}

// GetObject - Get an existing Cloud by filters like name, cloud, tenant
// Api creates Cloud object with every call.
func (client *CloudClient) GetObject(options ...session.ApiOptionsParams) (*models.Cloud, error) {
	var obj *models.Cloud
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("cloud", newOptions...)
	return obj, err
}

// Create a new Cloud object
func (client *CloudClient) Create(obj *models.Cloud, options ...session.ApiOptionsParams) (*models.Cloud, error) {
	var robj *models.Cloud
	path, _ := client.getAPIPath("")
	err := client.aviSession.Post(path, obj, &robj, options...)
	return robj, err
}

// Update an existing Cloud object
func (client *CloudClient) Update(obj *models.Cloud, options ...session.ApiOptionsParams) (*models.Cloud, error) {
	var robj *models.Cloud
	path, _ := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj, options...)
	return robj, err
}

// Patch an existing Cloud object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.Cloud
// or it should be json compatible of form map[string]interface{}
func (client *CloudClient) Patch(uuid string, patch interface{}, patchOp string, options ...session.ApiOptionsParams) (*models.Cloud, error) {
	var robj *models.Cloud
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj, options...)
	return robj, err
}

// Delete an existing Cloud object with a given UUID
func (client *CloudClient) Delete(uuid string, options ...session.ApiOptionsParams) error {
	path, _ := client.getAPIPath(uuid)
	if len(options) == 0 {
		return client.aviSession.Delete(path)
	} else {
		return client.aviSession.DeleteObject(path, options...)
	}
}

// DeleteByName - Delete an existing Cloud object with a given name
func (client *CloudClient) DeleteByName(name string, options ...session.ApiOptionsParams) error {
	res, err := client.GetByName(name, options...)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID, options...)
}

// GetAviSession
func (client *CloudClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
