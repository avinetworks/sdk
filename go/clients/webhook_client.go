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

// WebhookClient is a client for avi Webhook resource
type WebhookClient struct {
	aviSession *session.AviSession
}

// NewWebhookClient creates a new client for Webhook resource
func NewWebhookClient(aviSession *session.AviSession) *WebhookClient {
	return &WebhookClient{aviSession: aviSession}
}

func (client *WebhookClient) getAPIPath(uuid string) string {
	path := "api/webhook"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Webhook objects
func (client *WebhookClient) GetAll() ([]*models.Webhook, error) {
	var plist []*models.Webhook
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing Webhook by uuid
func (client *WebhookClient) Get(uuid string) (*models.Webhook, error) {
	var obj *models.Webhook
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing Webhook by name
func (client *WebhookClient) GetByName(name string) (*models.Webhook, error) {
	var obj *models.Webhook
	err := client.aviSession.GetObjectByName("webhook", name, &obj)
	return obj, err
}

// Create a new Webhook object
func (client *WebhookClient) Create(obj *models.Webhook) (*models.Webhook, error) {
	var robj *models.Webhook
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing Webhook object
func (client *WebhookClient) Update(obj *models.Webhook) (*models.Webhook, error) {
	var robj *models.Webhook
	path := client.getAPIPath(obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Webhook object with a given UUID
func (client *WebhookClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing Webhook object with a given name
func (client *WebhookClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
