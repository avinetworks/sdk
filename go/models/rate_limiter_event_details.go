package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// RateLimiterEventDetails rate limiter event details
// swagger:model RateLimiterEventDetails
type RateLimiterEventDetails struct {

	// Rate limiter error message. Field introduced in 18.2.9.
	ErrorMessage *string `json:"error_message,omitempty"`

	// Name of the rate limiter. Field introduced in 18.2.9.
	RlResourceName *string `json:"rl_resource_name,omitempty"`

	// Rate limiter type. Field introduced in 18.2.9.
	RlResourceType *string `json:"rl_resource_type,omitempty"`

	// Status. Field introduced in 18.2.9.
	Status *string `json:"status,omitempty"`
}
