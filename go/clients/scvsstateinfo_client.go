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

// SCVsStateInfoClient is a client for avi SCVsStateInfo resource
type SCVsStateInfoClient struct {
	aviSession *session.AviSession
}

// NewSCVsStateInfoClient creates a new client for SCVsStateInfo resource
func NewSCVsStateInfoClient(aviSession *session.AviSession) *SCVsStateInfoClient {
	return &SCVsStateInfoClient{aviSession: aviSession}
}

func (client *SCVsStateInfoClient) getAPIPath(uuid string) string {
	path := "api/scvsstateinfo"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SCVsStateInfo objects
func (client *SCVsStateInfoClient) GetAll() ([]*models.SCVsStateInfo, error) {
	var plist []*models.SCVsStateInfo
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing SCVsStateInfo by uuid
func (client *SCVsStateInfoClient) Get(uuid string) (*models.SCVsStateInfo, error) {
	var obj *models.SCVsStateInfo
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing SCVsStateInfo by name
func (client *SCVsStateInfoClient) GetByName(name string) (*models.SCVsStateInfo, error) {
	var obj *models.SCVsStateInfo
	err := client.aviSession.GetObjectByName("scvsstateinfo", name, &obj)
	return obj, err
}

// GetObject - Get an existing SCVsStateInfo by filters like name, cloud, tenant
// Api creates SCVsStateInfo object with every call.
func (client *SCVsStateInfoClient) GetObject(options ...session.ApiOptionsParams) (*models.SCVsStateInfo, error) {
	var obj *models.SCVsStateInfo
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("scvsstateinfo", newOptions...)
	return obj, err
}

// Create a new SCVsStateInfo object
func (client *SCVsStateInfoClient) Create(obj *models.SCVsStateInfo) (*models.SCVsStateInfo, error) {
	var robj *models.SCVsStateInfo
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing SCVsStateInfo object
func (client *SCVsStateInfoClient) Update(obj *models.SCVsStateInfo) (*models.SCVsStateInfo, error) {
	var robj *models.SCVsStateInfo
	path := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SCVsStateInfo object with a given UUID
func (client *SCVsStateInfoClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing SCVsStateInfo object with a given name
func (client *SCVsStateInfoClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID)
}

// GetAviSession
func (client *SCVsStateInfoClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
