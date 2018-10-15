package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// VirtualServiceResource virtual service resource
// swagger:model VirtualServiceResource
type VirtualServiceResource struct {

	// Placeholder for description of property is_exclusive of obj type VirtualServiceResource field type str  type boolean
	IsExclusive *bool `json:"is_exclusive,omitempty"`

	// Number of memory.
	Memory *int32 `json:"memory,omitempty"`

	// Number of num_se.
	NumSe *int32 `json:"num_se,omitempty"`

	// Number of num_standby_se.
	NumStandbySe *int32 `json:"num_standby_se,omitempty"`

	// Number of num_vcpus.
	NumVcpus *int32 `json:"num_vcpus,omitempty"`

	// Placeholder for description of property scalein_primary of obj type VirtualServiceResource field type str  type boolean
	ScaleinPrimary *bool `json:"scalein_primary,omitempty"`

	// Unique object identifier of scalein_se.
	ScaleinSeUUID *string `json:"scalein_se_uuid,omitempty"`
}
