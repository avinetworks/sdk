package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SecureChannelToken secure channel token
// swagger:model SecureChannelToken
type SecureChannelToken struct {

	// Expiry time for secure channel.
	ExpiryTime float64 `json:"expiry_time,omitempty"`

	// Placeholder for description of property metadata of obj type SecureChannelToken field type str  type object
	Metadata []*SecureChannelMetadata `json:"metadata,omitempty"`

	// Name of the object.
	// Required: true
	Name string `json:"name"`

	// Unique object identifier of node.
	NodeUUID string `json:"node_uuid,omitempty"`

	// url
	// Read Only: true
	URL string `json:"url,omitempty"`

	// Unique object identifier of the object.
	UUID string `json:"uuid,omitempty"`
}
