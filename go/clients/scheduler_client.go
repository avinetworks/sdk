package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SCHEDULER_RES_NAME = "scheduler"
)

// SchedulerClient is a client for avi Scheduler resource
type SchedulerClient struct {
	avi_session *session.AviSession
}

// NewSchedulerClient creates a new client for Scheduler resource
func NewSchedulerClient(avi_session *session.AviSession) *SchedulerClient {
	return &SchedulerClient{avi_session: avi_session}
}

func (client *SchedulerClient) GetApiPath(uuid string) string {
	path := "api/" + SCHEDULER_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Scheduler objects
func (client *SchedulerClient) GetAll() ([]*models.Scheduler, error) {
	var plist []*models.Scheduler
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing Scheduler by uuid
func (client *SchedulerClient) Get(uuid string) (*models.Scheduler, error) {
	var obj *models.Scheduler
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing Scheduler by name
func (client *SchedulerClient) GetByName(name string) (*models.Scheduler, error) {
	var obj *models.Scheduler
	err := client.avi_session.GetObjectByName(SCHEDULER_RES_NAME, name, &obj)
	return obj, err
}

// Create a new Scheduler object
func (client *SchedulerClient) Create(obj *models.Scheduler) (*models.Scheduler, error) {
	var robj *models.Scheduler
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing Scheduler object
func (client *SchedulerClient) Update(obj *models.Scheduler) (*models.Scheduler, error) {
	var robj *models.Scheduler
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Scheduler object with a given UUID
func (client *SchedulerClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing Scheduler object with a given name
func (client *SchedulerClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
