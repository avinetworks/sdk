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

// CloudPropertiesClient is a client for avi CloudProperties resource
type CloudPropertiesClient struct {
	aviSession *session.AviSession
}

// NewCloudPropertiesClient creates a new client for CloudProperties resource
func NewCloudPropertiesClient(aviSession *session.AviSession) *CloudPropertiesClient {
	return &CloudPropertiesClient{aviSession: aviSession}
}

func (client *CloudPropertiesClient) getAPIPath(uuid string, options ...session.ApiOptionsParams) (string, error) {
	path := "api/cloudproperties"
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

// GetAll is a collection API to get a list of CloudProperties objects
func (client *CloudPropertiesClient) GetAll(options ...session.ApiOptionsParams) ([]*models.CloudProperties, error) {
	var plist []*models.CloudProperties
	path, err := client.getAPIPath("", options...)
	if err == nil {
		err = client.aviSession.GetCollection(path, &plist, options...)
	}
	return plist, err
}

// Get an existing CloudProperties by uuid
func (client *CloudPropertiesClient) Get(uuid string, options ...session.ApiOptionsParams) (*models.CloudProperties, error) {
	var obj *models.CloudProperties
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Get(path, &obj, options...)
	return obj, err
}

// GetByName - Get an existing CloudProperties by name
func (client *CloudPropertiesClient) GetByName(name string, options ...session.ApiOptionsParams) (*models.CloudProperties, error) {
	var obj *models.CloudProperties
	err := client.aviSession.GetObjectByName("cloudproperties", name, &obj, options...)
	return obj, err
}

// GetObject - Get an existing CloudProperties by filters like name, cloud, tenant
// Api creates CloudProperties object with every call.
func (client *CloudPropertiesClient) GetObject(options ...session.ApiOptionsParams) (*models.CloudProperties, error) {
	var obj *models.CloudProperties
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("cloudproperties", newOptions...)
	return obj, err
}

// Create a new CloudProperties object
func (client *CloudPropertiesClient) Create(obj *models.CloudProperties, options ...session.ApiOptionsParams) (*models.CloudProperties, error) {
	var robj *models.CloudProperties
	path, _ := client.getAPIPath("")
	err := client.aviSession.Post(path, obj, &robj, options...)
	return robj, err
}

// Update an existing CloudProperties object
func (client *CloudPropertiesClient) Update(obj *models.CloudProperties, options ...session.ApiOptionsParams) (*models.CloudProperties, error) {
	var robj *models.CloudProperties
	path, _ := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj, options...)
	return robj, err
}

// Patch an existing CloudProperties object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.CloudProperties
// or it should be json compatible of form map[string]interface{}
func (client *CloudPropertiesClient) Patch(uuid string, patch interface{}, patchOp string, options ...session.ApiOptionsParams) (*models.CloudProperties, error) {
	var robj *models.CloudProperties
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj, options...)
	return robj, err
}

// Delete an existing CloudProperties object with a given UUID
func (client *CloudPropertiesClient) Delete(uuid string, options ...session.ApiOptionsParams) error {
	path, _ := client.getAPIPath(uuid)
	if len(options) == 0 {
		return client.aviSession.Delete(path)
	} else {
		return client.aviSession.DeleteObject(path, options...)
	}
}

// DeleteByName - Delete an existing CloudProperties object with a given name
func (client *CloudPropertiesClient) DeleteByName(name string, options ...session.ApiOptionsParams) error {
	res, err := client.GetByName(name, options...)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID, options...)
}

// GetAviSession
func (client *CloudPropertiesClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
