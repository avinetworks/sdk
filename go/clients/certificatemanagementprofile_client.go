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

// CertificateManagementProfileClient is a client for avi CertificateManagementProfile resource
type CertificateManagementProfileClient struct {
	aviSession *session.AviSession
}

// NewCertificateManagementProfileClient creates a new client for CertificateManagementProfile resource
func NewCertificateManagementProfileClient(aviSession *session.AviSession) *CertificateManagementProfileClient {
	return &CertificateManagementProfileClient{aviSession: aviSession}
}

func (client *CertificateManagementProfileClient) getAPIPath(uuid string, options ...session.ApiOptionsParams) (string, error) {
	path := "api/certificatemanagementprofile"
	var err error
	if uuid != "" {
		path += "/" + uuid
	} else {
		path, err = session.SetApiFilter(path, options...)
		if err != nil {
			return "", err
		}
	}
	return path, nil
}

// GetAll is a collection API to get a list of CertificateManagementProfile objects
func (client *CertificateManagementProfileClient) GetAll(options ...session.ApiOptionsParams) ([]*models.CertificateManagementProfile, error) {
	var plist []*models.CertificateManagementProfile
	path, err := client.getAPIPath("", options...)
	if err == nil {
		err = client.aviSession.GetCollection(path, &plist, options...)
	}
	return plist, err
}

// Get an existing CertificateManagementProfile by uuid
func (client *CertificateManagementProfileClient) Get(uuid string, options ...session.ApiOptionsParams) (*models.CertificateManagementProfile, error) {
	var obj *models.CertificateManagementProfile
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Get(path, &obj, options...)
	return obj, err
}

// GetByName - Get an existing CertificateManagementProfile by name
func (client *CertificateManagementProfileClient) GetByName(name string, options ...session.ApiOptionsParams) (*models.CertificateManagementProfile, error) {
	var obj *models.CertificateManagementProfile
	err := client.aviSession.GetObjectByName("certificatemanagementprofile", name, &obj, options...)
	return obj, err
}

// GetObject - Get an existing CertificateManagementProfile by filters like name, cloud, tenant
// Api creates CertificateManagementProfile object with every call.
func (client *CertificateManagementProfileClient) GetObject(options ...session.ApiOptionsParams) (*models.CertificateManagementProfile, error) {
	var obj *models.CertificateManagementProfile
	newOptions := make([]session.ApiOptionsParams, len(options)+1)
	for i, p := range options {
		newOptions[i] = p
	}
	newOptions[len(options)] = session.SetResult(&obj)
	err := client.aviSession.GetObject("certificatemanagementprofile", newOptions...)
	return obj, err
}

// Create a new CertificateManagementProfile object
func (client *CertificateManagementProfileClient) Create(obj *models.CertificateManagementProfile, options ...session.ApiOptionsParams) (*models.CertificateManagementProfile, error) {
	var robj *models.CertificateManagementProfile
	path, _ := client.getAPIPath("")
	err := client.aviSession.Post(path, obj, &robj, options...)
	return robj, err
}

// Update an existing CertificateManagementProfile object
func (client *CertificateManagementProfileClient) Update(obj *models.CertificateManagementProfile, options ...session.ApiOptionsParams) (*models.CertificateManagementProfile, error) {
	var robj *models.CertificateManagementProfile
	path, _ := client.getAPIPath(*obj.UUID)
	err := client.aviSession.Put(path, obj, &robj, options...)
	return robj, err
}

// Patch an existing CertificateManagementProfile object specified using uuid
// patchOp: Patch operation - add, replace, or delete
// patch: Patch payload should be compatible with the models.CertificateManagementProfile
// or it should be json compatible of form map[string]interface{}
func (client *CertificateManagementProfileClient) Patch(uuid string, patch interface{}, patchOp string, options ...session.ApiOptionsParams) (*models.CertificateManagementProfile, error) {
	var robj *models.CertificateManagementProfile
	path, _ := client.getAPIPath(uuid)
	err := client.aviSession.Patch(path, patch, patchOp, &robj, options...)
	return robj, err
}

// Delete an existing CertificateManagementProfile object with a given UUID
func (client *CertificateManagementProfileClient) Delete(uuid string, options ...session.ApiOptionsParams) error {
	path, _ := client.getAPIPath(uuid)
	if len(options) == 0 {
		return client.aviSession.Delete(path)
	} else {
		return client.aviSession.DeleteObject(path, options...)
	}
}

// DeleteByName - Delete an existing CertificateManagementProfile object with a given name
func (client *CertificateManagementProfileClient) DeleteByName(name string, options ...session.ApiOptionsParams) error {
	res, err := client.GetByName(name, options...)
	if err != nil {
		return err
	}
	return client.Delete(*res.UUID, options...)
}

// GetAviSession
func (client *CertificateManagementProfileClient) GetAviSession() *session.AviSession {
	return client.aviSession
}
