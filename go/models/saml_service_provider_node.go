package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SamlServiceProviderNode saml service provider node
// swagger:model SamlServiceProviderNode
type SamlServiceProviderNode struct {

	// Globally unique entityID for this node. Entity ID on the IDP should match this. Field introduced in 17.2.3.
	EntityID *string `json:"entity_id,omitempty"`

	// Refers to the Cluster name identifier (Virtual IP or FQDN). Field introduced in 17.2.3.
	// Required: true
	Name *string `json:"name"`

	// Service Provider signing certificate for metadata. Field introduced in 17.2.3.
	SigningCert *string `json:"signing_cert,omitempty"`

	// Service Provider signing key for metadata. Field introduced in 17.2.3.
	SigningKey *string `json:"signing_key,omitempty"`

	// Single Signon URL to be programmed on the IDP. Field introduced in 17.2.3.
	SingleSignonURL *string `json:"single_signon_url,omitempty"`
}
