package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SwitchoverFailEventDetails switchover fail event details
// swagger:model SwitchoverFailEventDetails
type SwitchoverFailEventDetails struct {

	// from_se_name of SwitchoverFailEventDetails.
	FromSeName string `json:"from_se_name,omitempty"`

	// ip of SwitchoverFailEventDetails.
	IP string `json:"ip,omitempty"`

	// reason of SwitchoverFailEventDetails.
	Reason string `json:"reason,omitempty"`

	// vs_name of SwitchoverFailEventDetails.
	VsName string `json:"vs_name,omitempty"`

	// Unique object identifier of vs.
	VsUUID string `json:"vs_uuid,omitempty"`
}
