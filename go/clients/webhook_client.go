package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	WEBHOOK_RES_NAME = "webhook"
)

// WebhookClient is a client for avi Webhook resource
type WebhookClient struct {
	avi_session *session.AviSession
}

// NewWebhookClient creates a new client for Webhook resource
func NewWebhookClient(avi_session *session.AviSession) *WebhookClient {
	return &WebhookClient{avi_session: avi_session}
}

func (client *WebhookClient) GetApiPath(uuid string) string {
	path := "api/" + WEBHOOK_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Webhook objects
func (client *WebhookClient) GetAll() ([]*models.Webhook, error) {
	var plist []*models.Webhook
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing Webhook by uuid
func (client *WebhookClient) Get(uuid string) (*models.Webhook, error) {
	var obj *models.Webhook
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing Webhook by name
func (client *WebhookClient) GetByName(name string) (*models.Webhook, error) {
	var obj *models.Webhook
	err := client.avi_session.GetObjectByName(WEBHOOK_RES_NAME, name, &obj)
	return obj, err
}

// Create a new Webhook object
func (client *WebhookClient) Create(obj *models.Webhook) (*models.Webhook, error) {
	var robj *models.Webhook
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing Webhook object
func (client *WebhookClient) Update(obj *models.Webhook) (*models.Webhook, error) {
	var robj *models.Webhook
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Webhook object with a given UUID
func (client *WebhookClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing Webhook object with a given name
func (client *WebhookClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
