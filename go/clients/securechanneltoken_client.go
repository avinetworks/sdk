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

// SecureChannelTokenClient is a client for avi SecureChannelToken resource
type SecureChannelTokenClient struct {
	aviSession *session.AviSession
}

// NewSecureChannelTokenClient creates a new client for SecureChannelToken resource
func NewSecureChannelTokenClient(aviSession *session.AviSession) *SecureChannelTokenClient {
	return &SecureChannelTokenClient{aviSession: aviSession}
}

func (client *SecureChannelTokenClient) getAPIPath(uuid string) string {
	path := "api/securechanneltoken"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SecureChannelToken objects
func (client *SecureChannelTokenClient) GetAll() ([]*models.SecureChannelToken, error) {
	var plist []*models.SecureChannelToken
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing SecureChannelToken by uuid
func (client *SecureChannelTokenClient) Get(uuid string) (*models.SecureChannelToken, error) {
	var obj *models.SecureChannelToken
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing SecureChannelToken by name
func (client *SecureChannelTokenClient) GetByName(name string) (*models.SecureChannelToken, error) {
	var obj *models.SecureChannelToken
	err := client.aviSession.GetObjectByName("securechanneltoken", name, &obj)
	return obj, err
}

// Create a new SecureChannelToken object
func (client *SecureChannelTokenClient) Create(obj *models.SecureChannelToken) (*models.SecureChannelToken, error) {
	var robj *models.SecureChannelToken
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing SecureChannelToken object
func (client *SecureChannelTokenClient) Update(obj *models.SecureChannelToken) (*models.SecureChannelToken, error) {
	var robj *models.SecureChannelToken
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SecureChannelToken object with a given UUID
func (client *SecureChannelTokenClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing SecureChannelToken object with a given name
func (client *SecureChannelTokenClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
