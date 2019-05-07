package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// NatPolicyActionParam nat policy action param
// swagger:model NatPolicyActionParam
type NatPolicyActionParam struct {

	// Pool of IP Addresses used for Nat. Field introduced in 18.2.3.
	NatInfo []*NatAddrInfo `json:"nat_info,omitempty"`
}
