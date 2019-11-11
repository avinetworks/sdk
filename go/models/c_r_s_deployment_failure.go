package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// CRSDeploymentFailure c r s deployment failure
// swagger:model CRSDeploymentFailure
type CRSDeploymentFailure struct {

	// Error message to be conveyed to controller UI. Field introduced in 20.1.1.
	Message *string `json:"message,omitempty"`

	// Name of the CRS release. Field introduced in 20.1.1.
	Name *string `json:"name,omitempty"`

	// CRS data release date. Field introduced in 20.1.1.
	ReleaseDate *string `json:"release_date,omitempty"`

	// Version of the CRS release. Field introduced in 20.1.1.
	Version *string `json:"version,omitempty"`
}
