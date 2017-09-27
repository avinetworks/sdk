package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// ServerScaleInParams server scale in params
// swagger:model ServerScaleInParams
type ServerScaleInParams struct {

	// Reason for the manual scalein.
	Reason string `json:"reason,omitempty"`

	// List of server IDs that should be scaled in.
	Servers []*ServerID `json:"servers,omitempty"`
}
