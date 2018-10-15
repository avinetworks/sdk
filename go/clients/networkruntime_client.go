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

// NetworkRuntimeClient is a client for avi NetworkRuntime resource
type NetworkRuntimeClient struct {
	aviSession *session.AviSession
}

// NewNetworkRuntimeClient creates a new client for NetworkRuntime resource
func NewNetworkRuntimeClient(aviSession *session.AviSession) *NetworkRuntimeClient {
	return &NetworkRuntimeClient{aviSession: aviSession}
}

func (client *NetworkRuntimeClient) getAPIPath(uuid string) string {
	path := "api/networkruntime"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of NetworkRuntime objects
func (client *NetworkRuntimeClient) GetAll() ([]*models.NetworkRuntime, error) {
	var plist []*models.NetworkRuntime
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing NetworkRuntime by uuid
func (client *NetworkRuntimeClient) Get(uuid string) (*models.NetworkRuntime, error) {
	var obj *models.NetworkRuntime
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing NetworkRuntime by name
func (client *NetworkRuntimeClient) GetByName(name string) (*models.NetworkRuntime, error) {
	var obj *models.NetworkRuntime
	err := client.aviSession.GetObjectByName("networkruntime", name, &obj)
	return obj, err
}

// GetObject - Get an existing NetworkRuntime by filters like name, cloud, tenant
// Api creates NetworkRuntime object with every call.
func (client *NetworkRuntimeClient) GetObject(options ...session.ApiOptionsParams) (*models.NetworkRuntime, error) {
	var obj *models.NetworkRuntime
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("networkruntime", newOptions...)
	return obj, err
}

// Create a new NetworkRuntime object
func (client *NetworkRuntimeClient) Create(obj *models.NetworkRuntime) (*models.NetworkRuntime, error) {
	var robj *models.NetworkRuntime
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing NetworkRuntime object
func (client *NetworkRuntimeClient) Update(obj *models.NetworkRuntime) (*models.NetworkRuntime, error) {
	var robj *models.NetworkRuntime
	path := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing NetworkRuntime object with a given UUID
func (client *NetworkRuntimeClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing NetworkRuntime object with a given name
func (client *NetworkRuntimeClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID)
}

// GetAviSession
func (client *NetworkRuntimeClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
