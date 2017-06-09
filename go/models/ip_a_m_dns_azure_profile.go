package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// IPAMDNSAzureProfile ipam Dns azure profile
// swagger:model IpamDnsAzureProfile
type IPAMDNSAzureProfile struct {

	// Azure resource group dedicated for Avi Controller. Avi Controller will create all its resources in this resource group. Field introduced in 17.2.1.
	ResourceGroup string `json:"resource_group,omitempty"`

	// Placeholder for description of property serviceprincipal of obj type IpamDnsAzureProfile field type str  type object
	Serviceprincipal *AzureServicePrincipalCredentials `json:"serviceprincipal,omitempty"`

	// Subscription Id for the Azure subscription. Field introduced in 17.2.1.
	SubscriptionID string `json:"subscription_id,omitempty"`

	// Usable networks for Virtual IP. If VirtualService does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for IP allocation. Field introduced in 17.2.1.
	UsableNetworkUuids []string `json:"usable_network_uuids,omitempty"`

	// Placeholder for description of property userpass of obj type IpamDnsAzureProfile field type str  type object
	Userpass *AzureUserPassCredentials `json:"userpass,omitempty"`

	// Virtual networks where Virtual IPs will belong. Field introduced in 17.2.1.
	VirtualNetworkIds []string `json:"virtual_network_ids,omitempty"`
}
