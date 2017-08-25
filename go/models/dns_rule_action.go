package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// DNSRuleAction Dns rule action
// swagger:model DnsRuleAction
type DNSRuleAction struct {

	// Allow or drop the DNS query. Field introduced in 17.1.1.
	Allow *DNSRuleActionAllowDrop `json:"allow,omitempty"`

	// Generate a response for the DNS query. Field introduced in 17.1.1.
	Response *DNSRuleActionResponse `json:"response,omitempty"`
}
