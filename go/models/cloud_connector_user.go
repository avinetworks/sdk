package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// CloudConnectorUser cloud connector user
// swagger:model CloudConnectorUser
type CloudConnectorUser struct {

	// UNIX time since epoch in microseconds. Units(MICROSECONDS).
	// Read Only: true
	LastModified int64 `json:"_last_modified,omitempty"`

	//  Field introduced in 17.2.1.
	AzureServiceprincipal *AzureServicePrincipalCredentials `json:"azure_serviceprincipal,omitempty"`

	//  Field introduced in 17.2.1.
	AzureUserpass *AzureUserPassCredentials `json:"azure_userpass,omitempty"`

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
