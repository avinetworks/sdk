
/***************************************************************************
 * 
 * AVI CONFIDENTIAL
 * __________________
 * 
 * [2013] - [2017] Avi Networks Incorporated
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

// VIPGNameInfoClient is a client for avi VIPGNameInfo resource
type VIPGNameInfoClient struct {
	aviSession *session.AviSession
}

// NewVIPGNameInfoClient creates a new client for VIPGNameInfo resource
func NewVIPGNameInfoClient(aviSession *session.AviSession) *VIPGNameInfoClient {
	return &VIPGNameInfoClient{aviSession: aviSession}
}

func (client *VIPGNameInfoClient) getAPIPath(uuid string) string {
	path := "api/vipgnameinfo"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIPGNameInfo objects
func (client *VIPGNameInfoClient) GetAll() ([]*models.VIPGNameInfo, error) {
	var plist []*models.VIPGNameInfo
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing VIPGNameInfo by uuid
func (client *VIPGNameInfoClient) Get(uuid string) (*models.VIPGNameInfo, error) {
	var obj *models.VIPGNameInfo
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing VIPGNameInfo by name
func (client *VIPGNameInfoClient) GetByName(name string) (*models.VIPGNameInfo, error) {
	var obj *models.VIPGNameInfo
	err := client.aviSession.GetObjectByName("vipgnameinfo", name, &obj)
	return obj, err
}

// Create a new VIPGNameInfo object
func (client *VIPGNameInfoClient) Create(obj *models.VIPGNameInfo) (*models.VIPGNameInfo, error) {
	var robj *models.VIPGNameInfo
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIPGNameInfo object
func (client *VIPGNameInfoClient) Update(obj *models.VIPGNameInfo) (*models.VIPGNameInfo, error) {
	var robj *models.VIPGNameInfo
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIPGNameInfo object with a given UUID
func (client *VIPGNameInfoClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing VIPGNameInfo object with a given name
func (client *VIPGNameInfoClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
