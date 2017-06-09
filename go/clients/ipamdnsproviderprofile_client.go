package clients

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

import (
	"github.com/avinetworks/sdk/go/models"
	"github.com/avinetworks/sdk/go/session"
)

const (
	IPAMDNSPROVIDERPROFILE_RES_NAME = "ipamdnsproviderprofile"
)

// IPAMDNSProviderProfileClient is a client for avi IPAMDNSProviderProfile resource
type IPAMDNSProviderProfileClient struct {
	avi_session *session.AviSession
}

// NewIPAMDNSProviderProfileClient creates a new client for IPAMDNSProviderProfile resource
func NewIPAMDNSProviderProfileClient(avi_session *session.AviSession) *IPAMDNSProviderProfileClient {
	return &IPAMDNSProviderProfileClient{avi_session: avi_session}
}

func (client *IPAMDNSProviderProfileClient) GetApiPath(uuid string) string {
	path := "api/" + IPAMDNSPROVIDERPROFILE_RES_NAME
	if uuid != "" {
		path += "/" + uuid
	}
	return path
}

// GetAll is a collection API to get a list of IPAMDNSProviderProfile objects
func (client *IPAMDNSProviderProfileClient) GetAll() ([]*models.IPAMDNSProviderProfile, error) {
	var plist []*models.IPAMDNSProviderProfile
	err := client.avi_session.GetCollection(client.GetApiPath(""), &plist)
	return plist, err
}

// Get an existing IPAMDNSProviderProfile by uuid
func (client *IPAMDNSProviderProfileClient) Get(uuid string) (*models.IPAMDNSProviderProfile, error) {
	var obj *models.IPAMDNSProviderProfile
	err := client.avi_session.Get(client.GetApiPath(uuid), &obj)
	return obj, err
}

// Get an existing IPAMDNSProviderProfile by name
func (client *IPAMDNSProviderProfileClient) GetByName(name string) (*models.IPAMDNSProviderProfile, error) {
	var obj *models.IPAMDNSProviderProfile
	err := client.avi_session.GetObjectByName(IPAMDNSPROVIDERPROFILE_RES_NAME, name, &obj)
	return obj, err
}

// Create a new IPAMDNSProviderProfile object
func (client *IPAMDNSProviderProfileClient) Create(obj *models.IPAMDNSProviderProfile) (*models.IPAMDNSProviderProfile, error) {
	var robj *models.IPAMDNSProviderProfile
	err := client.avi_session.Post(client.GetApiPath(""), obj, &robj)
	return robj, err
}

// Update an existing IPAMDNSProviderProfile object
func (client *IPAMDNSProviderProfileClient) Update(obj *models.IPAMDNSProviderProfile) (*models.IPAMDNSProviderProfile, error) {
	var robj *models.IPAMDNSProviderProfile
	path := client.GetApiPath(obj.UUID)
	err := client.avi_session.Put(path, obj, &robj)
	return robj, err
}

// Delete an existing IPAMDNSProviderProfile object with a given UUID
func (client *IPAMDNSProviderProfileClient) Delete(uuid string) error {
	return client.avi_session.Delete(client.GetApiPath(uuid))
}

// Delete an existing IPAMDNSProviderProfile object with a given name
func (client *IPAMDNSProviderProfileClient) DeleteByName(name string) error {
	res, err := client.GetByName(name)
	if err != nil {
		return err
	}
	return client.Delete(res.UUID)
}
