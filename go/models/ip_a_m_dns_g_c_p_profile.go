package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// IPAMDNSGCPProfile ipam Dns g c p profile
// swagger:model IpamDnsGCPProfile
type IPAMDNSGCPProfile struct {

	// Match SE group subnets for VIP placement. Default is to not match SE group subnets. Field introduced in 17.1.1.
	MatchSeGroupSubnet bool `json:"match_se_group_subnet,omitempty"`

	// Google Cloud Platform Network Name. VIP will be allocated from this Network. This is required if Google Cloud Platform Network is used for VIP allocation. Field introduced in 18.1.2.
	NetworkName string `json:"network_name,omitempty"`

	// Google Cloud Platform Network Project Name. This is the host project in which Google Cloud Platform Network resides. Field introduced in 18.1.2.
	NetworkProjectName string `json:"network_project_name,omitempty"`

	// Google Cloud Platform Project Name. This is required if Google Cloud Platform Network is used for VIP allocation. This field is optional. By default it will use the value of the field network_project_name. Field introduced in 18.1.2.
	ProjectName string `json:"project_name,omitempty"`

	// Google Cloud Platform Region Name. This is required if Google Cloud Platform Network is used for VIP allocation. Field introduced in 18.1.2.
	RegionName string `json:"region_name,omitempty"`

	// Usable networks for Virtual IP. If VirtualService does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for IP allocation. It is a reference to an object of type Network.
	UsableNetworkRefs []string `json:"usable_network_refs,omitempty"`

	// Use Google Cloud Platform Network for VIP allocation. By default Avi Vantage Network is used for VIP allocation. Field introduced in 18.1.2.
	UseGcpNetwork bool `json:"use_gcp_network,omitempty"`
}
