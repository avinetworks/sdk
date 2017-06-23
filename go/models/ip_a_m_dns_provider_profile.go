package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// IPAMDNSProviderProfile ipam Dns provider profile
// swagger:model IpamDnsProviderProfile
type IPAMDNSProviderProfile struct {

	// Provider details if type is AWS.
	AwsProfile *IPAMDNSAwsProfile `json:"aws_profile,omitempty"`

	// Provider details if type is Custom. Field introduced in 17.1.1.
	CustomProfile *IPAMDNSCustomProfile `json:"custom_profile,omitempty"`

	// Provider details if type is Google Cloud.
	GcpProfile *IPAMDNSGCPProfile `json:"gcp_profile,omitempty"`

	// Provider details if type is Infoblox.
	InfobloxProfile *IPAMDNSInfobloxProfile `json:"infoblox_profile,omitempty"`

	// Provider details if type is Avi.
	InternalProfile *IPAMDNSInternalProfile `json:"internal_profile,omitempty"`

	// Name for the IPAM/DNS Provider profile.
	// Required: true
	Name string `json:"name"`

	// Provider details if type is OpenStack.
	OpenstackProfile *IPAMDNSOpenstackProfile `json:"openstack_profile,omitempty"`

	//  Field introduced in 17.1.1.
	ProxyConfiguration *ProxyConfiguration `json:"proxy_configuration,omitempty"`

	//  It is a reference to an object of type Tenant.
	TenantRef string `json:"tenant_ref,omitempty"`

	// Provider Type for the IPAM/DNS Provider profile. Enum options - IPAMDNS_TYPE_INFOBLOX, IPAMDNS_TYPE_AWS, IPAMDNS_TYPE_OPENSTACK, IPAMDNS_TYPE_GCP, IPAMDNS_TYPE_INFOBLOX_DNS, IPAMDNS_TYPE_CUSTOM, IPAMDNS_TYPE_CUSTOM_DNS, IPAMDNS_TYPE_INTERNAL, IPAMDNS_TYPE_INTERNAL_DNS.
	// Required: true
	Type string `json:"type"`

	// url
	// Read Only: true
	URL string `json:"url,omitempty"`

	// UUID of the IPAM/DNS Provider profile.
	UUID string `json:"uuid,omitempty"`
}
