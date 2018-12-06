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

// ServiceEngineClient is a client for avi ServiceEngine resource
type ServiceEngineClient struct {
	aviSession *session.AviSession
}

// NewServiceEngineClient creates a new client for ServiceEngine resource
func NewServiceEngineClient(aviSession *session.AviSession) *ServiceEngineClient {
	return &ServiceEngineClient{aviSession: aviSession}
}

func (client *ServiceEngineClient) getAPIPath(uuid string) string {
	path := "api/serviceengine"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of ServiceEngine objects
func (client *ServiceEngineClient) GetAll() ([]*models.ServiceEngine, error) {
	var plist []*models.ServiceEngine
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing ServiceEngine by uuid
func (client *ServiceEngineClient) Get(uuid string) (*models.ServiceEngine, error) {
	var obj *models.ServiceEngine
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing ServiceEngine by name
func (client *ServiceEngineClient) GetByName(name string) (*models.ServiceEngine, error) {
	var obj *models.ServiceEngine
	err := client.aviSession.GetObjectByName("serviceengine", name, &obj)
	return obj, err
}

// GetObject - Get an existing ServiceEngine by filters like name, cloud, tenant
// Api creates ServiceEngine object with every call.
func (client *ServiceEngineClient) GetObject(options ...session.ApiOptionsParams) (*models.ServiceEngine, error) {
	var obj *models.ServiceEngine
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("serviceengine", newOptions...)
	return obj, err
}

// Create a new ServiceEngine object
func (client *ServiceEngineClient) Create(obj *models.ServiceEngine) (*models.ServiceEngine, error) {
	var robj *models.ServiceEngine
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing ServiceEngine object
func (client *ServiceEngineClient) Update(obj *models.ServiceEngine) (*models.ServiceEngine, error) {
	var robj *models.ServiceEngine
	path := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing ServiceEngine object with a given UUID
func (client *ServiceEngineClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing ServiceEngine object with a given name
func (client *ServiceEngineClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID)
}

// GetAviSession
func (client *ServiceEngineClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
