package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// VsSwitchoverParams vs switchover params
// swagger:model VsSwitchoverParams
type VsSwitchoverParams struct {

	// Unique object identifier of se.
	SeUUID string `json:"se_uuid,omitempty"`

	//  Field introduced in 17.1.1.
	// Required: true
	VipID string `json:"vip_id"`
}
