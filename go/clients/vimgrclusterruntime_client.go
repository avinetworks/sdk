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

// VIMgrClusterRuntimeClient is a client for avi VIMgrClusterRuntime resource
type VIMgrClusterRuntimeClient struct {
	aviSession *session.AviSession
}

// NewVIMgrClusterRuntimeClient creates a new client for VIMgrClusterRuntime resource
func NewVIMgrClusterRuntimeClient(aviSession *session.AviSession) *VIMgrClusterRuntimeClient {
	return &VIMgrClusterRuntimeClient{aviSession: aviSession}
}

func (client *VIMgrClusterRuntimeClient) getAPIPath(uuid string) string {
	path := "api/vimgrclusterruntime"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VIMgrClusterRuntime objects
func (client *VIMgrClusterRuntimeClient) GetAll() ([]*models.VIMgrClusterRuntime, error) {
	var plist []*models.VIMgrClusterRuntime
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing VIMgrClusterRuntime by uuid
func (client *VIMgrClusterRuntimeClient) Get(uuid string) (*models.VIMgrClusterRuntime, error) {
	var obj *models.VIMgrClusterRuntime
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing VIMgrClusterRuntime by name
func (client *VIMgrClusterRuntimeClient) GetByName(name string) (*models.VIMgrClusterRuntime, error) {
	var obj *models.VIMgrClusterRuntime
	err := client.aviSession.GetObjectByName("vimgrclusterruntime", name, &obj)
	return obj, err
}

// Create a new VIMgrClusterRuntime object
func (client *VIMgrClusterRuntimeClient) Create(obj *models.VIMgrClusterRuntime) (*models.VIMgrClusterRuntime, error) {
	var robj *models.VIMgrClusterRuntime
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing VIMgrClusterRuntime object
func (client *VIMgrClusterRuntimeClient) Update(obj *models.VIMgrClusterRuntime) (*models.VIMgrClusterRuntime, error) {
	var robj *models.VIMgrClusterRuntime
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VIMgrClusterRuntime object with a given UUID
func (client *VIMgrClusterRuntimeClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing VIMgrClusterRuntime object with a given name
func (client *VIMgrClusterRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
