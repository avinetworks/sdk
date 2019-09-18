package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// RouteInfo route info
// swagger:model RouteInfo
type RouteInfo struct {

	// Host interface name. Field introduced in 18.2.6.
	IfName *string `json:"if_name,omitempty"`

	// Host nexthop ip address. Field introduced in 18.2.6.
	Nexthop *IPAddr `json:"nexthop,omitempty"`

	// Host subnet address. Field introduced in 18.2.6.
	// Required: true
	Subnet *IPAddrPrefix `json:"subnet"`
}
