package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	JOBENTRY_RES_NAME = "jobentry"
)

// JobEntryClient is a client for avi JobEntry resource
type JobEntryClient struct {
	avi_session *session.AviSession
}

// NewJobEntryClient creates a new client for JobEntry resource
func NewJobEntryClient(avi_session *session.AviSession) *JobEntryClient {
	return &JobEntryClient{avi_session: avi_session}
}

func (client *JobEntryClient) GetApiPath(uuid string) string {
	path := "api/" + JOBENTRY_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of JobEntry objects
func (client *JobEntryClient) GetAll() ([]*models.JobEntry, error) {
	var plist []*models.JobEntry
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing JobEntry by uuid
func (client *JobEntryClient) Get(uuid string) (*models.JobEntry, error) {
	var obj *models.JobEntry
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing JobEntry by name
func (client *JobEntryClient) GetByName(name string) (*models.JobEntry, error) {
	var obj *models.JobEntry
	err := client.avi_session.GetObjectByName(JOBENTRY_RES_NAME, name, &obj)
	return obj, err
}

// Create a new JobEntry object
func (client *JobEntryClient) Create(obj *models.JobEntry) (*models.JobEntry, error) {
	var robj *models.JobEntry
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing JobEntry object
func (client *JobEntryClient) Update(obj *models.JobEntry) (*models.JobEntry, error) {
	var robj *models.JobEntry
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing JobEntry object with a given UUID
func (client *JobEntryClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing JobEntry object with a given name
func (client *JobEntryClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
