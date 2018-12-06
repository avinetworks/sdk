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

// ClusterClient is a client for avi Cluster resource
type ClusterClient struct {
	aviSession *session.AviSession
}

// NewClusterClient creates a new client for Cluster resource
func NewClusterClient(aviSession *session.AviSession) *ClusterClient {
	return &ClusterClient{aviSession: aviSession}
}

func (client *ClusterClient) getAPIPath(uuid string) string {
	path := "api/cluster"
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of Cluster objects
func (client *ClusterClient) GetAll() ([]*models.Cluster, error) {
	var plist []*models.Cluster
	err := client.aviSession.GetCollection(client.getAPIPath(""), &plist)
	return plist, err
}

// Get an existing Cluster by uuid
func (client *ClusterClient) Get(uuid string) (*models.Cluster, error) {
	var obj *models.Cluster
	err := client.aviSession.Get(client.getAPIPath(uuid), &obj)
	return obj, err
}

// GetByName - Get an existing Cluster by name
func (client *ClusterClient) GetByName(name string) (*models.Cluster, error) {
	var obj *models.Cluster
	err := client.aviSession.GetObjectByName("cluster", name, &obj)
	return obj, err
}

// GetObject - Get an existing Cluster by filters like name, cloud, tenant
// Api creates Cluster object with every call.
func (client *ClusterClient) GetObject(options ...session.ApiOptionsParams) (*models.Cluster, error) {
	var obj *models.Cluster
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("cluster", newOptions...)
	return obj, err
}

// Create a new Cluster object
func (client *ClusterClient) Create(obj *models.Cluster) (*models.Cluster, error) {
	var robj *models.Cluster
	err := client.aviSession.Post(client.getAPIPath(""), obj, &robj)
	return robj, err
}

// Update an existing Cluster object
func (client *ClusterClient) Update(obj *models.Cluster) (*models.Cluster, error) {
	var robj *models.Cluster
	path := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing Cluster object with a given UUID
func (client *ClusterClient) Delete(uuid string) error {
	return client.aviSession.Delete(client.getAPIPath(uuid))
}

// DeleteByName - Delete an existing Cluster object with a given name
func (client *ClusterClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID)
}

// GetAviSession
func (client *ClusterClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
