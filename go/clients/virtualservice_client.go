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

// VirtualServiceClient is a client for avi VirtualService resource
type VirtualServiceClient struct {
	aviSession *session.AviSession
}

// NewVirtualServiceClient creates a new client for VirtualService resource
func NewVirtualServiceClient(aviSession *session.AviSession) *VirtualServiceClient {
	return &VirtualServiceClient{aviSession: aviSession}
}

func (client *VirtualServiceClient) getAPIPath(uuid string) string {
	path := "api/virtualservice"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of VirtualService objects
func (client *VirtualServiceClient) GetAll() ([]*models.VirtualService, error) {
	var plist []*models.VirtualService
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing VirtualService by uuid
func (client *VirtualServiceClient) Get(uuid string) (*models.VirtualService, error) {
	var obj *models.VirtualService
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing VirtualService by name
func (client *VirtualServiceClient) GetByName(name string) (*models.VirtualService, error) {
	var obj *models.VirtualService
	err := client.aviSession.GetObjectByName("virtualservice", name, &obj)
	return obj, err
}

// GetObject - Get an existing VirtualService by filters like name, cloud, tenant
// Api creates VirtualService object with every call.
func (client *VirtualServiceClient) GetObject(options ...session.ApiOptionsParams) (*models.VirtualService, error) {
	var obj *models.VirtualService
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("virtualservice", newOptions...)
	return obj, err
}

// Create a new VirtualService object
func (client *VirtualServiceClient) Create(obj *models.VirtualService) (*models.VirtualService, error) {
	var robj *models.VirtualService
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing VirtualService object
func (client *VirtualServiceClient) Update(obj *models.VirtualService) (*models.VirtualService, error) {
	var robj *models.VirtualService
	path := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing VirtualService object with a given UUID
func (client *VirtualServiceClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing VirtualService object with a given name
func (client *VirtualServiceClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID)
}

// GetAviSession
func (client *VirtualServiceClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
