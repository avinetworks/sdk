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

// WafProfileClient is a client for avi WafProfile resource
type WafProfileClient struct {
	aviSession *session.AviSession
}

// NewWafProfileClient creates a new client for WafProfile resource
func NewWafProfileClient(aviSession *session.AviSession) *WafProfileClient {
	return &WafProfileClient{aviSession: aviSession}
}

func (client *WafProfileClient) getAPIPath(uuid string, options ...session.ApiOptionsParams) (string, error) {
	path := "api/wafprofile"
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

// GetAll is a collection API to get a list of WafProfile objects
func (client *WafProfileClient) GetAll(options ...session.ApiOptionsParams) ([]*models.WafProfile, error) {
	var plist []*models.WafProfile
	path, err := client.getAPIPath("", options...)
	if err == nil {
		err = client.aviSession.GetCollection(path, &plist, options...)
	}
	return plist, err
}

// Get an existing WafProfile by uuid
func (client *WafProfileClient) Get(uuid string, options ...session.ApiOptionsParams) (*models.WafProfile, error) {
	var obj *models.WafProfile
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Get(path, &obj, options...)
	return obj, err
}

// GetByName - Get an existing WafProfile by name
func (client *WafProfileClient) GetByName(name string, options ...session.ApiOptionsParams) (*models.WafProfile, error) {
	var obj *models.WafProfile
	err := client.aviSession.GetObjectByName("wafprofile", name, &obj, options...)
	return obj, err
}

// GetObject - Get an existing WafProfile by filters like name, cloud, tenant
// Api creates WafProfile object with every call.
func (client *WafProfileClient) GetObject(options ...session.ApiOptionsParams) (*models.WafProfile, error) {
	var obj *models.WafProfile
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("wafprofile", newOptions...)
	return obj, err
}

// Create a new WafProfile object
func (client *WafProfileClient) Create(obj *models.WafProfile, options ...session.ApiOptionsParams) (*models.WafProfile, error) {
	var robj *models.WafProfile
	path, _ := client.getAPIPath("")
	err := client.aviSession.Post(path, obj, &robj, options...)
	return robj, err
}

// Update an existing WafProfile object
func (client *WafProfileClient) Update(obj *models.WafProfile, options ...session.ApiOptionsParams) (*models.WafProfile, error) {
	var robj *models.WafProfile
	path, _ := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj, options...)
	return robj, err
}

// Patch an existing WafProfile object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.WafProfile
// or it should be json compatible of form map[string]interface{}
func (client *WafProfileClient) Patch(uuid string, patch interface{}, patchOp string, options ...session.ApiOptionsParams) (*models.WafProfile, error) {
	var robj *models.WafProfile
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj, options...)
	return robj, err
}

// Delete an existing WafProfile object with a given UUID
func (client *WafProfileClient) Delete(uuid string, options ...session.ApiOptionsParams) error {
	path, _ := client.getAPIPath(uuid)
	if len(options) == 0 {
		return client.aviSession.Delete(path)
	} else {
		return client.aviSession.DeleteObject(path, options...)
	}
}

// DeleteByName - Delete an existing WafProfile object with a given name
func (client *WafProfileClient) DeleteByName(name string, options ...session.ApiOptionsParams) error {
	res, err := client.GetByName(name, options...)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID, options...)
}

// GetAviSession
func (client *WafProfileClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
