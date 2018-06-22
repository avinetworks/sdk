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

// AlertClient is a client for avi Alert resource
type AlertClient struct {
	aviSession *session.AviSession
}

// NewAlertClient creates a new client for Alert resource
func NewAlertClient(aviSession *session.AviSession) *AlertClient {
	return &AlertClient{aviSession: aviSession}
}

func (client *AlertClient) getAPIPath(uuid string) string {
	path := "api/alert"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Alert objects
func (client *AlertClient) GetAll() ([]*models.Alert, error) {
	var plist []*models.Alert
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing Alert by uuid
func (client *AlertClient) Get(uuid string) (*models.Alert, error) {
	var obj *models.Alert
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing Alert by name
func (client *AlertClient) GetByName(name string) (*models.Alert, error) {
	var obj *models.Alert
	err := client.aviSession.GetObjectByName("alert", name, &obj)
	return obj, err
}

// Create a new Alert object
func (client *AlertClient) Create(obj *models.Alert) (*models.Alert, error) {
	var robj *models.Alert
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing Alert object
func (client *AlertClient) Update(obj *models.Alert) (*models.Alert, error) {
	var robj *models.Alert
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Alert object with a given UUID
func (client *AlertClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing Alert object with a given name
func (client *AlertClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
