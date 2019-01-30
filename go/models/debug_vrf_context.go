package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// DebugVrfContext debug vrf context
// swagger:model DebugVrfContext
type DebugVrfContext struct {

	// Vrf config command buffer process interval. Allowed values are 1-10. Field introduced in 17.2.13.
	CommandBufferInterval int32 `json:"command_buffer_interval,omitempty"`

	// Vrf config command buffer size. Allowed values are 0-65535. Field introduced in 17.2.13.
	CommandBufferSize int32 `json:"command_buffer_size,omitempty"`

	//  Field introduced in 17.1.1.
	Flags []*DebugVrf `json:"flags,omitempty"`
}
