package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// VipAutoscalePolicy vip autoscale policy
// swagger:model VipAutoscalePolicy
type VipAutoscalePolicy struct {

	// The maximum size of the group. Field introduced in 18.1.2.
	MaxSize int32 `json:"max_size,omitempty"`

	// The minimum size of the group. Field introduced in 18.1.2.
	MinSize int32 `json:"min_size,omitempty"`

	// When set, scaling is suspended. Field introduced in 18.1.2.
	Suspend bool `json:"suspend,omitempty"`
}
