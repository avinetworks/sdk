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

// LogControllerMappingClient is a client for avi LogControllerMapping resource
type LogControllerMappingClient struct {
	aviSession *session.AviSession
}

// NewLogControllerMappingClient creates a new client for LogControllerMapping resource
func NewLogControllerMappingClient(aviSession *session.AviSession) *LogControllerMappingClient {
	return &LogControllerMappingClient{aviSession: aviSession}
}

func (client *LogControllerMappingClient) getAPIPath(uuid string) string {
	path := "api/logcontrollermapping"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of LogControllerMapping objects
func (client *LogControllerMappingClient) GetAll() ([]*models.LogControllerMapping, error) {
	var plist []*models.LogControllerMapping
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing LogControllerMapping by uuid
func (client *LogControllerMappingClient) Get(uuid string) (*models.LogControllerMapping, error) {
	var obj *models.LogControllerMapping
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing LogControllerMapping by name
func (client *LogControllerMappingClient) GetByName(name string) (*models.LogControllerMapping, error) {
	var obj *models.LogControllerMapping
	err := client.aviSession.GetObjectByName("logcontrollermapping", name, &obj)
	return obj, err
}

// GetObject - Get an existing LogControllerMapping by filters like name, cloud, tenant
// Api creates LogControllerMapping object with every call.
func (client *LogControllerMappingClient) GetObject(options ...session.ApiOptionsParams) (*models.LogControllerMapping, error) {
	var obj *models.LogControllerMapping
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("logcontrollermapping", newOptions...)
	return obj, err
}

// Create a new LogControllerMapping object
func (client *LogControllerMappingClient) Create(obj *models.LogControllerMapping) (*models.LogControllerMapping, error) {
	var robj *models.LogControllerMapping
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing LogControllerMapping object
func (client *LogControllerMappingClient) Update(obj *models.LogControllerMapping) (*models.LogControllerMapping, error) {
	var robj *models.LogControllerMapping
	path := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing LogControllerMapping object with a given UUID
func (client *LogControllerMappingClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing LogControllerMapping object with a given name
func (client *LogControllerMappingClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID)
}

// GetAviSession
func (client *LogControllerMappingClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
