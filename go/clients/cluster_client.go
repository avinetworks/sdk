package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	CLUSTER_RES_NAME = "cluster"
)

// ClusterClient is a client for avi Cluster resource
type ClusterClient struct {
	avi_session *session.AviSession
}

// NewClusterClient creates a new client for Cluster resource
func NewClusterClient(avi_session *session.AviSession) *ClusterClient {
	return &ClusterClient{avi_session: avi_session}
}

func (client *ClusterClient) GetApiPath(uuid string) string {
	path := "api/" + CLUSTER_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Cluster objects
func (client *ClusterClient) GetAll() ([]*models.Cluster, error) {
	var plist []*models.Cluster
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing Cluster by uuid
func (client *ClusterClient) Get(uuid string) (*models.Cluster, error) {
	var obj *models.Cluster
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing Cluster by name
func (client *ClusterClient) GetByName(name string) (*models.Cluster, error) {
	var obj *models.Cluster
	err := client.avi_session.GetObjectByName(CLUSTER_RES_NAME, name, &obj)
	return obj, err
}

// Create a new Cluster object
func (client *ClusterClient) Create(obj *models.Cluster) (*models.Cluster, error) {
	var robj *models.Cluster
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing Cluster object
func (client *ClusterClient) Update(obj *models.Cluster) (*models.Cluster, error) {
	var robj *models.Cluster
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Cluster object with a given UUID
func (client *ClusterClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing Cluster object with a given name
func (client *ClusterClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
