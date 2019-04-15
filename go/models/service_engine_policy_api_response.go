package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// ServiceEnginePolicyAPIResponse service engine policy Api response
// swagger:model ServiceEnginePolicyApiResponse
type ServiceEnginePolicyAPIResponse struct {

	// count
	// Required: true
	Count *int32 `json:"count"`

	// results
	// Required: true
	Results []*ServiceEnginePolicy `json:"results,omitempty"`
}
