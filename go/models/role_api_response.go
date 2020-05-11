package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// RoleAPIResponse role Api response
// swagger:model RoleApiResponse
type RoleAPIResponse struct {

	// count
	// Required: true
	Count *int32 `json:"count"`

	// results
	// Required: true
	Results []*Role `json:"results,omitempty"`
}
