package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// AssetContactInfo asset contact info
// swagger:model AssetContactInfo
type AssetContactInfo struct {

	// Organizational department of the point of contact for this asset. Field introduced in 20.1.1.
	Department *string `json:"department,omitempty"`

	// Email ID of the point of contact for this asset. Field introduced in 20.1.1.
	// Required: true
	EmailID *string `json:"email_id"`

	// Name of the point of contact for this asset. Field introduced in 20.1.1.
	Name *string `json:"name,omitempty"`

	// Phone number of the point of contact for this asset. Field introduced in 20.1.1.
	PhoneNumber *string `json:"phone_number,omitempty"`
}
