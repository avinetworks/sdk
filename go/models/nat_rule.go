package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// NatRule nat rule
// swagger:model NatRule
type NatRule struct {

	// Nat Action Type. Enum options - NAT_POLICY_ACTION_TYPE_DYNAMIC_IP_PORT. Field introduced in 18.2.3.
	// Required: true
	Action *string `json:"action"`

	// Nat rule Action Information. Field introduced in 18.2.3.
	ActionParam *NatPolicyActionParam `json:"action_param,omitempty"`

	// Creator name. Field introduced in 18.2.3.
	CreatedBy *string `json:"created_by,omitempty"`

	// Nat rule enable flag. Field introduced in 18.2.3.
	// Required: true
	Enable *bool `json:"enable"`

	// Nat rule Index. Field introduced in 18.2.3.
	// Required: true
	Index *int32 `json:"index"`

	// Nat rule Match Criteria. Field introduced in 18.2.3.
	// Required: true
	Match *NatMatchTarget `json:"match"`

	// Nat rule Name. Field introduced in 18.2.3.
	// Required: true
	Name *string `json:"name"`
}
