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

// ControllerPropertiesClient is a client for avi ControllerProperties resource
type ControllerPropertiesClient struct {
	aviSession *session.AviSession
}

// NewControllerPropertiesClient creates a new client for ControllerProperties resource
func NewControllerPropertiesClient(aviSession *session.AviSession) *ControllerPropertiesClient {
	return &ControllerPropertiesClient{aviSession: aviSession}
}

func (client *ControllerPropertiesClient) getAPIPath(uuid string, options ...session.ApiOptionsParams) (string, error) {
	path := "api/controllerproperties"
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

// GetAll is a collection API to get a list of ControllerProperties objects
func (client *ControllerPropertiesClient) GetAll(options ...session.ApiOptionsParams) ([]*models.ControllerProperties, error) {
	var plist []*models.ControllerProperties
	path, err := client.getAPIPath("", options...)
	if err == nil {
		err = client.aviSession.GetCollection(path, &plist, options...)
	}
	return plist, err
}

// Get an existing ControllerProperties by uuid
func (client *ControllerPropertiesClient) Get(uuid string, options ...session.ApiOptionsParams) (*models.ControllerProperties, error) {
	var obj *models.ControllerProperties
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Get(path, &obj, options...)
	return obj, err
}

// GetByName - Get an existing ControllerProperties by name
func (client *ControllerPropertiesClient) GetByName(name string, options ...session.ApiOptionsParams) (*models.ControllerProperties, error) {
	var obj *models.ControllerProperties
	err := client.aviSession.GetObjectByName("controllerproperties", name, &obj, options...)
	return obj, err
}

// GetObject - Get an existing ControllerProperties by filters like name, cloud, tenant
// Api creates ControllerProperties object with every call.
func (client *ControllerPropertiesClient) GetObject(options ...session.ApiOptionsParams) (*models.ControllerProperties, error) {
	var obj *models.ControllerProperties
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("controllerproperties", newOptions...)
	return obj, err
}

// Create a new ControllerProperties object
func (client *ControllerPropertiesClient) Create(obj *models.ControllerProperties, options ...session.ApiOptionsParams) (*models.ControllerProperties, error) {
	var robj *models.ControllerProperties
	path, _ := client.getAPIPath("")
	err := client.aviSession.Post(path, obj, &robj, options...)
	return robj, err
}

// Update an existing ControllerProperties object
func (client *ControllerPropertiesClient) Update(obj *models.ControllerProperties, options ...session.ApiOptionsParams) (*models.ControllerProperties, error) {
	var robj *models.ControllerProperties
	path, _ := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj, options...)
	return robj, err
}

// Patch an existing ControllerProperties object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.ControllerProperties
// or it should be json compatible of form map[string]interface{}
func (client *ControllerPropertiesClient) Patch(uuid string, patch interface{}, patchOp string, options ...session.ApiOptionsParams) (*models.ControllerProperties, error) {
	var robj *models.ControllerProperties
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj, options...)
	return robj, err
}

// Delete an existing ControllerProperties object with a given UUID
func (client *ControllerPropertiesClient) Delete(uuid string, options ...session.ApiOptionsParams) error {
	path, _ := client.getAPIPath(uuid)
	if len(options) == 0 {
		return client.aviSession.Delete(path)
	} else {
		return client.aviSession.DeleteObject(path, options...)
	}
}

// DeleteByName - Delete an existing ControllerProperties object with a given name
func (client *ControllerPropertiesClient) DeleteByName(name string, options ...session.ApiOptionsParams) error {
	res, err := client.GetByName(name, options...)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID, options...)
}

// GetAviSession
func (client *ControllerPropertiesClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
