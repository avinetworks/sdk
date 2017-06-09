package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	PRIORITYLABELS_RES_NAME = "prioritylabels"
)

// PriorityLabelsClient is a client for avi PriorityLabels resource
type PriorityLabelsClient struct {
	avi_session *session.AviSession
}

// NewPriorityLabelsClient creates a new client for PriorityLabels resource
func NewPriorityLabelsClient(avi_session *session.AviSession) *PriorityLabelsClient {
	return &PriorityLabelsClient{avi_session: avi_session}
}

func (client *PriorityLabelsClient) GetApiPath(uuid string) string {
	path := "api/" + PRIORITYLABELS_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of PriorityLabels objects
func (client *PriorityLabelsClient) GetAll() ([]*models.PriorityLabels, error) {
	var plist []*models.PriorityLabels
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing PriorityLabels by uuid
func (client *PriorityLabelsClient) Get(uuid string) (*models.PriorityLabels, error) {
	var obj *models.PriorityLabels
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing PriorityLabels by name
func (client *PriorityLabelsClient) GetByName(name string) (*models.PriorityLabels, error) {
	var obj *models.PriorityLabels
	err := client.avi_session.GetObjectByName(PRIORITYLABELS_RES_NAME, name, &obj)
	return obj, err
}

// Create a new PriorityLabels object
func (client *PriorityLabelsClient) Create(obj *models.PriorityLabels) (*models.PriorityLabels, error) {
	var robj *models.PriorityLabels
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing PriorityLabels object
func (client *PriorityLabelsClient) Update(obj *models.PriorityLabels) (*models.PriorityLabels, error) {
	var robj *models.PriorityLabels
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing PriorityLabels object with a given UUID
func (client *PriorityLabelsClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing PriorityLabels object with a given name
func (client *PriorityLabelsClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
