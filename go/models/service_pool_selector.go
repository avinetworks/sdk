package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// ServicePoolSelector service pool selector
// swagger:model ServicePoolSelector
type ServicePoolSelector struct {

	//  It is a reference to an object of type PoolGroup.
	ServicePoolGroupRef string `json:"service_pool_group_ref,omitempty"`

	//  It is a reference to an object of type Pool.
	ServicePoolRef string `json:"service_pool_ref,omitempty"`

	// Pool based destination port. Allowed values are 1-65535.
	// Required: true
	ServicePort int32 `json:"service_port"`

	// Destination protocol to match for the pool selection. If not specified, it will match any protocol. Enum options - PROTOCOL_TYPE_TCP_PROXY, PROTOCOL_TYPE_TCP_FAST_PATH, PROTOCOL_TYPE_UDP_FAST_PATH.
	ServiceProtocol string `json:"service_protocol,omitempty"`
}
