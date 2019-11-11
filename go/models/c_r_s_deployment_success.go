package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// CRSDeploymentSuccess c r s deployment success
// swagger:model CRSDeploymentSuccess
type CRSDeploymentSuccess struct {

	// Name of the CRS release. Field introduced in 20.1.1.
	Name *string `json:"name,omitempty"`

	// CRS data release date. Field introduced in 20.1.1.
	ReleaseDate *string `json:"release_date,omitempty"`

	// Version of the CRS release. Field introduced in 20.1.1.
	Version *string `json:"version,omitempty"`
}
