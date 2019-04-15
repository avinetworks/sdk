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

// ServiceEnginePolicyClient is a client for avi ServiceEnginePolicy resource
type ServiceEnginePolicyClient struct {
	aviSession *session.AviSession
}

// NewServiceEnginePolicyClient creates a new client for ServiceEnginePolicy resource
func NewServiceEnginePolicyClient(aviSession *session.AviSession) *ServiceEnginePolicyClient {
	return &ServiceEnginePolicyClient{aviSession: aviSession}
}

func (client *ServiceEnginePolicyClient) getAPIPath(uuid string) string {
	path := "api/serviceenginepolicy"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of ServiceEnginePolicy objects
func (client *ServiceEnginePolicyClient) GetAll() ([]*models.ServiceEnginePolicy, error) {
	var plist []*models.ServiceEnginePolicy
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing ServiceEnginePolicy by uuid
func (client *ServiceEnginePolicyClient) Get(uuid string) (*models.ServiceEnginePolicy, error) {
	var obj *models.ServiceEnginePolicy
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing ServiceEnginePolicy by name
func (client *ServiceEnginePolicyClient) GetByName(name string) (*models.ServiceEnginePolicy, error) {
	var obj *models.ServiceEnginePolicy
	err := client.aviSession.GetObjectByName("serviceenginepolicy", name, &obj)
	return obj, err
}

// GetObject - Get an existing ServiceEnginePolicy by filters like name, cloud, tenant
// Api creates ServiceEnginePolicy object with every call.
func (client *ServiceEnginePolicyClient) GetObject(options ...session.ApiOptionsParams) (*models.ServiceEnginePolicy, error) {
	var obj *models.ServiceEnginePolicy
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("serviceenginepolicy", newOptions...)
	return obj, err
}

// Create a new ServiceEnginePolicy object
func (client *ServiceEnginePolicyClient) Create(obj *models.ServiceEnginePolicy) (*models.ServiceEnginePolicy, error) {
	var robj *models.ServiceEnginePolicy
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing ServiceEnginePolicy object
func (client *ServiceEnginePolicyClient) Update(obj *models.ServiceEnginePolicy) (*models.ServiceEnginePolicy, error) {
	var robj *models.ServiceEnginePolicy
	path := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Patch an existing ServiceEnginePolicy object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.ServiceEnginePolicy
// or it should be json compatible of form map[string]interface{}
func (client *ServiceEnginePolicyClient) Patch(uuid string, patch interface{}, patchOp string) (*models.ServiceEnginePolicy, error) {
	var robj *models.ServiceEnginePolicy
	path := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj)
	return robj, err
}

// Delete an existing ServiceEnginePolicy object with a given UUID
func (client *ServiceEnginePolicyClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing ServiceEnginePolicy object with a given name
func (client *ServiceEnginePolicyClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID)
}

// GetAviSession
func (client *ServiceEnginePolicyClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
