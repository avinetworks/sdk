package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// PlacementScopeConfig placement scope config
// swagger:model PlacementScopeConfig
type PlacementScopeConfig struct {

	// Folder to place all the Service Engine virtual machines in vCenter. Field introduced in 20.1.1.
	VcenterFolder *string `json:"vcenter_folder,omitempty"`

	// VCenter server configuration. It is a reference to an object of type VCenterServer. Field introduced in 20.1.1.
	// Required: true
	VcenterRef *string `json:"vcenter_ref"`
}
