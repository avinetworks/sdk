package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// GslbPool gslb pool
// swagger:model GslbPool
type GslbPool struct {

	// The load balancing algorithm will pick a local member within the GSLB service list of available Members. Enum options - GSLB_ALGORITHM_ROUND_ROBIN, GSLB_ALGORITHM_CONSISTENT_HASH, GSLB_ALGORITHM_GEO.
	// Required: true
	Algorithm string `json:"algorithm"`

	// Mask to be applied on client IP for consistent hash algorithm. Allowed values are 1-31.
	ConsistentHashMask int32 `json:"consistent_hash_mask,omitempty"`

	// Select list of VIPs belonging to this GSLB service.
	Members []*GslbPoolMember `json:"members,omitempty"`

	// Name of the GSLB service pool.
	// Required: true
	Name string `json:"name"`

	// Priority of this pool of Members. If the priority of this is the highest in the group, DNS service picks up only this member for DNS responses. Allowed values are 1-100.
	Priority int32 `json:"priority,omitempty"`
}
