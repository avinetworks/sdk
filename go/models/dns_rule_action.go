package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// DNSRuleAction Dns rule action
// swagger:model DnsRuleAction
type DNSRuleAction struct {

	// Allow or drop the DNS query. Field introduced in 17.1.1.
	Allow *DNSRuleActionAllowDrop `json:"allow,omitempty"`

	// Select a specific GSLB site for the DNS query. This action should be used only when GSLB services have been configured for the DNS virtual service. Field introduced in 17.1.5.
	GslbSiteSelection *DNSRuleActionGslbSiteSelection `json:"gslb_site_selection,omitempty"`

	// Generate a response for the DNS query. Field introduced in 17.1.1.
	Response *DNSRuleActionResponse `json:"response,omitempty"`
}
