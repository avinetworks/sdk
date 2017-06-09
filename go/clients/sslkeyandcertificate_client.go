package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	SSLKEYANDCERTIFICATE_RES_NAME = "sslkeyandcertificate"
)

// SSLKeyAndCertificateClient is a client for avi SSLKeyAndCertificate resource
type SSLKeyAndCertificateClient struct {
	avi_session *session.AviSession
}

// NewSSLKeyAndCertificateClient creates a new client for SSLKeyAndCertificate resource
func NewSSLKeyAndCertificateClient(avi_session *session.AviSession) *SSLKeyAndCertificateClient {
	return &SSLKeyAndCertificateClient{avi_session: avi_session}
}

func (client *SSLKeyAndCertificateClient) GetApiPath(uuid string) string {
	path := "api/" + SSLKEYANDCERTIFICATE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of SSLKeyAndCertificate objects
func (client *SSLKeyAndCertificateClient) GetAll() ([]*models.SSLKeyAndCertificate, error) {
	var plist []*models.SSLKeyAndCertificate
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing SSLKeyAndCertificate by uuid
func (client *SSLKeyAndCertificateClient) Get(uuid string) (*models.SSLKeyAndCertificate, error) {
	var obj *models.SSLKeyAndCertificate
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing SSLKeyAndCertificate by name
func (client *SSLKeyAndCertificateClient) GetByName(name string) (*models.SSLKeyAndCertificate, error) {
	var obj *models.SSLKeyAndCertificate
	err := client.avi_session.GetObjectByName(SSLKEYANDCERTIFICATE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new SSLKeyAndCertificate object
func (client *SSLKeyAndCertificateClient) Create(obj *models.SSLKeyAndCertificate) (*models.SSLKeyAndCertificate, error) {
	var robj *models.SSLKeyAndCertificate
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing SSLKeyAndCertificate object
func (client *SSLKeyAndCertificateClient) Update(obj *models.SSLKeyAndCertificate) (*models.SSLKeyAndCertificate, error) {
	var robj *models.SSLKeyAndCertificate
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing SSLKeyAndCertificate object with a given UUID
func (client *SSLKeyAndCertificateClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing SSLKeyAndCertificate object with a given name
func (client *SSLKeyAndCertificateClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
