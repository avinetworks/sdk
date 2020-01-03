package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// GslbPool gslb pool
// swagger:model GslbPool
type GslbPool struct {

	// The load balancing algorithm will pick a local member within the GSLB service list of available Members. Enum options - GSLB_ALGORITHM_ROUND_ROBIN, GSLB_ALGORITHM_CONSISTENT_HASH, GSLB_ALGORITHM_GEO, GSLB_ALGORITHM_TOPOLOGY.
	// Required: true
	Algorithm *string `json:"algorithm"`

	// Mask to be applied on client IP for consistent hash algorithm. Allowed values are 1-31.
	ConsistentHashMask *int32 `json:"consistent_hash_mask,omitempty"`

	// User provided information that records member details such as application owner name, contact, etc. Field introduced in 17.1.3.
	Description *string `json:"description,omitempty"`

	// Enable or disable a GSLB service pool. Field introduced in 17.2.14, 18.1.5, 18.2.1.
	Enabled *bool `json:"enabled,omitempty"`

	// The fallback load balancing algorithm used to pick a member when the pool algorithm fails to find a valid member. For instance when algorithm is Geo and client/server do not have valid geo location. Enum options - GSLB_ALGORITHM_ROUND_ROBIN, GSLB_ALGORITHM_CONSISTENT_HASH, GSLB_ALGORITHM_GEO, GSLB_ALGORITHM_TOPOLOGY. Field introduced in 18.2.3.
	FallbackAlgorithm *string `json:"fallback_algorithm,omitempty"`

	// Select list of VIPs belonging to this GSLB service.
	Members []*GslbPoolMember `json:"members,omitempty"`

	// Name of the GSLB service pool.
	// Required: true
	Name *string `json:"name"`

	// Priority of this pool of Members. The higher the number, the higher is the priority of the pool. The DNS Service chooses the pool with the highest priority that is operationally up. Allowed values are 0-100. Special values are 0 - 'Do not choose members from this pool.A priority of 0 is equivalent to disabling the pool.'.
	Priority *int32 `json:"priority,omitempty"`
}
