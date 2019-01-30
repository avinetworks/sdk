package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// DebugSeFault debug se fault
// swagger:model DebugSeFault
type DebugSeFault struct {

	// Toggle assert on mbuf cluster sanity check fail. Field introduced in 17.2.13.
	SeMbufClSanity bool `json:"se_mbuf_cl_sanity,omitempty"`
}
