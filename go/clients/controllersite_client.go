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

// ControllerSiteClient is a client for avi ControllerSite resource
type ControllerSiteClient struct {
	aviSession *session.AviSession
}

// NewControllerSiteClient creates a new client for ControllerSite resource
func NewControllerSiteClient(aviSession *session.AviSession) *ControllerSiteClient {
	return &ControllerSiteClient{aviSession: aviSession}
}

func (client *ControllerSiteClient) getAPIPath(uuid string, options ...session.ApiOptionsParams) (string, error) {
	path := "api/controllersite"
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

// GetAll is a collection API to get a list of ControllerSite objects
func (client *ControllerSiteClient) GetAll(options ...session.ApiOptionsParams) ([]*models.ControllerSite, error) {
	var plist []*models.ControllerSite
	path, err := client.getAPIPath("", options...)
	if err == nil {
		err = client.aviSession.GetCollection(path, &plist, options...)
	}
	return plist, err
}

// Get an existing ControllerSite by uuid
func (client *ControllerSiteClient) Get(uuid string, options ...session.ApiOptionsParams) (*models.ControllerSite, error) {
	var obj *models.ControllerSite
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Get(path, &obj, options...)
	return obj, err
}

// GetByName - Get an existing ControllerSite by name
func (client *ControllerSiteClient) GetByName(name string, options ...session.ApiOptionsParams) (*models.ControllerSite, error) {
	var obj *models.ControllerSite
	err := client.aviSession.GetObjectByName("controllersite", name, &obj, options...)
	return obj, err
}

// GetObject - Get an existing ControllerSite by filters like name, cloud, tenant
// Api creates ControllerSite object with every call.
func (client *ControllerSiteClient) GetObject(options ...session.ApiOptionsParams) (*models.ControllerSite, error) {
	var obj *models.ControllerSite
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("controllersite", newOptions...)
	return obj, err
}

// Create a new ControllerSite object
func (client *ControllerSiteClient) Create(obj *models.ControllerSite, options ...session.ApiOptionsParams) (*models.ControllerSite, error) {
	var robj *models.ControllerSite
	path, _ := client.getAPIPath("")
	err := client.aviSession.Post(path, obj, &robj, options...)
	return robj, err
}

// Update an existing ControllerSite object
func (client *ControllerSiteClient) Update(obj *models.ControllerSite, options ...session.ApiOptionsParams) (*models.ControllerSite, error) {
	var robj *models.ControllerSite
	path, _ := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj, options...)
	return robj, err
}

// Patch an existing ControllerSite object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.ControllerSite
// or it should be json compatible of form map[string]interface{}
func (client *ControllerSiteClient) Patch(uuid string, patch interface{}, patchOp string, options ...session.ApiOptionsParams) (*models.ControllerSite, error) {
	var robj *models.ControllerSite
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj, options...)
	return robj, err
}

// Delete an existing ControllerSite object with a given UUID
func (client *ControllerSiteClient) Delete(uuid string, options ...session.ApiOptionsParams) error {
	path, _ := client.getAPIPath(uuid)
	if len(options) == 0 {
		return client.aviSession.Delete(path)
	} else {
		return client.aviSession.DeleteObject(path, options...)
	}
}

// DeleteByName - Delete an existing ControllerSite object with a given name
func (client *ControllerSiteClient) DeleteByName(name string, options ...session.ApiOptionsParams) error {
	res, err := client.GetByName(name, options...)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID, options...)
}

// GetAviSession
func (client *ControllerSiteClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
