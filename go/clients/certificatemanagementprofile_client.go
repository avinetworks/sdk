package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	CERTIFICATEMANAGEMENTPROFILE_RES_NAME = "certificatemanagementprofile"
)

// CertificateManagementProfileClient is a client for avi CertificateManagementProfile resource
type CertificateManagementProfileClient struct {
	avi_session *session.AviSession
}

// NewCertificateManagementProfileClient creates a new client for CertificateManagementProfile resource
func NewCertificateManagementProfileClient(avi_session *session.AviSession) *CertificateManagementProfileClient {
	return &CertificateManagementProfileClient{avi_session: avi_session}
}

func (client *CertificateManagementProfileClient) GetApiPath(uuid string) string {
	path := "api/" + CERTIFICATEMANAGEMENTPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of CertificateManagementProfile objects
func (client *CertificateManagementProfileClient) GetAll() ([]*models.CertificateManagementProfile, error) {
	var plist []*models.CertificateManagementProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing CertificateManagementProfile by uuid
func (client *CertificateManagementProfileClient) Get(uuid string) (*models.CertificateManagementProfile, error) {
	var obj *models.CertificateManagementProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing CertificateManagementProfile by name
func (client *CertificateManagementProfileClient) GetByName(name string) (*models.CertificateManagementProfile, error) {
	var obj *models.CertificateManagementProfile
	err := client.avi_session.GetObjectByName(CERTIFICATEMANAGEMENTPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new CertificateManagementProfile object
func (client *CertificateManagementProfileClient) Create(obj *models.CertificateManagementProfile) (*models.CertificateManagementProfile, error) {
	var robj *models.CertificateManagementProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing CertificateManagementProfile object
func (client *CertificateManagementProfileClient) Update(obj *models.CertificateManagementProfile) (*models.CertificateManagementProfile, error) {
	var robj *models.CertificateManagementProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing CertificateManagementProfile object with a given UUID
func (client *CertificateManagementProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing CertificateManagementProfile object with a given name
func (client *CertificateManagementProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
