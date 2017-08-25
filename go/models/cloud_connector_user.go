package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// CloudConnectorUser cloud connector user
// swagger:model CloudConnectorUser
type CloudConnectorUser struct {

	// Name of the object.
	// Required: true
	Name string `json:"name"`

	// password of CloudConnectorUser.
	Password string `json:"password,omitempty"`

	// private_key of CloudConnectorUser.
	PrivateKey string `json:"private_key,omitempty"`

	// public_key of CloudConnectorUser.
	PublicKey string `json:"public_key,omitempty"`

	//  It is a reference to an object of type Tenant.
	TenantRef string `json:"tenant_ref,omitempty"`

	// url
	// Read Only: true
	URL string `json:"url,omitempty"`

	// Unique object identifier of the object.
	UUID string `json:"uuid,omitempty"`
}
