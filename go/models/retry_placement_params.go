package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// RetryPlacementParams retry placement params
// swagger:model RetryPlacementParams
type RetryPlacementParams struct {

	// Indicates the vip_id that needs placement retrial. Field introduced in 17.1.2.
	// Required: true
	VipID string `json:"vip_id"`
}
