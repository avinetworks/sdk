package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// DiscoveredNetwork discovered network
// swagger:model DiscoveredNetwork
type DiscoveredNetwork struct {

	// Discovered network for this IP. It is a reference to an object of type Network.
	// Required: true
	NetworkRef string `json:"network_ref"`

	// Discovered subnet for this IP.
	Subnet []*IPAddrPrefix `json:"subnet,omitempty"`
}
