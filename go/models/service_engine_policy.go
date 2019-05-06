package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// ServiceEnginePolicy service engine policy
// swagger:model ServiceEnginePolicy
type ServiceEnginePolicy struct {

	// UNIX time since epoch in microseconds. Units(MICROSECONDS).
	// Read Only: true
	LastModified *string `json:"_last_modified,omitempty"`

	// Name of the Service Engine Policy. Field introduced in 18.2.3.
	// Required: true
	Name *string `json:"name"`

	// Nat policy. It is a reference to an object of type NatPolicy. Field introduced in 18.2.3.
	NatPolicyRef *string `json:"nat_policy_ref,omitempty"`

	// Service Engine Group to which the policy is applied. It is a reference to an object of type ServiceEngineGroup. Field introduced in 18.2.3.
	// Required: true
	SeGroupRef *string `json:"se_group_ref"`

	//  It is a reference to an object of type Tenant. Field introduced in 18.2.3.
	TenantRef *string `json:"tenant_ref,omitempty"`

	// url
	// Read Only: true
	URL *string `json:"url,omitempty"`

	// UUID of the Service Engine Policy. Field introduced in 18.2.3.
	UUID *string `json:"uuid,omitempty"`

	// VRF context to which the policy is scoped. It is a reference to an object of type VrfContext. Field introduced in 18.2.3.
	// Required: true
	VrfRef *string `json:"vrf_ref"`
}
