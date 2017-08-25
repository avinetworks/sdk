package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// IPAMDNSGCPProfile ipam Dns g c p profile
// swagger:model IpamDnsGCPProfile
type IPAMDNSGCPProfile struct {

	// Match SE group subnets for VIP placement. Default is to not match SE group subnets. Field introduced in 17.1.1.
	MatchSeGroupSubnet bool `json:"match_se_group_subnet,omitempty"`

	// Usable networks for Virtual IP. If VirtualService does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for IP allocation. It is a reference to an object of type Network.
	UsableNetworkRefs []string `json:"usable_network_refs,omitempty"`
}
