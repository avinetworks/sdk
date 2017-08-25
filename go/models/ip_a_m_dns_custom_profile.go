package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// IPAMDNSCustomProfile ipam Dns custom profile
// swagger:model IpamDnsCustomProfile
type IPAMDNSCustomProfile struct {

	// Custom parameters that will passed for the IPAM/DNS provider including but not limited to provider credentials and API version. Field introduced in 17.1.1.
	CustomIPAMDNSParams []*CustomParams `json:"custom_ipam_dns_params,omitempty"`

	//  It is a reference to an object of type CustomIpamDnsProfile. Field introduced in 17.1.1.
	CustomIPAMDNSProfileRef string `json:"custom_ipam_dns_profile_ref,omitempty"`
}
