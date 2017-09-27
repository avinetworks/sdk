package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// VinfraVcenterBadCredentials vinfra vcenter bad credentials
// swagger:model VinfraVcenterBadCredentials
type VinfraVcenterBadCredentials struct {

	// Name of the object.
	Name string `json:"name,omitempty"`

	// vcenter of VinfraVcenterBadCredentials.
	// Required: true
	Vcenter string `json:"vcenter"`

	// vcenter_name of VinfraVcenterBadCredentials.
	VcenterName string `json:"vcenter_name,omitempty"`
}
