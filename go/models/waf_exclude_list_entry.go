package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// WafExcludeListEntry waf exclude list entry
// swagger:model WafExcludeListEntry
type WafExcludeListEntry struct {

	// Client IP Subnet to exclude for WAF rules. Field introduced in 17.2.1.
	ClientSubnet *IPAddrPrefix `json:"client_subnet,omitempty"`

	// match_element can be 'ARGS xxx' or 'REQUEST_HEADERS xxx' or 'REQUEST_COOKIES xxx' or 'RESPONSE_HEADERS xxx'. These match_elements in the HTTP Transcation (if present) will be excluded when executing WAF Rules. Field introduced in 17.2.1.
	MatchElement string `json:"match_element,omitempty"`

	// URI Path to exclude for WAF rules. Field introduced in 17.2.1.
	URIPath string `json:"uri_path,omitempty"`
}
