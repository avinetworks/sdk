package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// DNSServiceApplicationProfile Dns service application profile
// swagger:model DnsServiceApplicationProfile
type DNSServiceApplicationProfile struct {

	// Respond to AAAA queries with empty response when there are only IPV4 records.
	AaaaEmptyResponse bool `json:"aaaa_empty_response,omitempty"`

	// Enable DNS query/response over TCP. This enables analytics for pass-through queries as well. Field introduced in 17.1.1.
	DNSOverTCPEnabled bool `json:"dns_over_tcp_enabled,omitempty"`

	// Subdomain names serviced by this Virtual Service. These are configured as Ends-With semantics.
	DomainNames []string `json:"domain_names,omitempty"`

	// Enable DNS service to be aware of EDNS (Extension mechanism for DNS). EDNS extensions are parsed and shown in logs. For GSLB services, the EDNS subnet option can be used to influence Load Balancing. Field introduced in 17.1.1.
	Edns bool `json:"edns,omitempty"`

	// Drop or respond to client when the DNS service encounters an error processing a client query. By default, such a request is dropped without any response, or passed through to a passthrough pool, if configured. When set to respond, an appropriate response is sent to client, e.g. NXDOMAIN response for non-existent records, empty NOERROR response for unsupported queries, etc. Enum options - DNS_ERROR_RESPONSE_ERROR, DNS_ERROR_RESPONSE_NONE.
	ErrorResponse string `json:"error_response,omitempty"`

	// Specifies the number of IP addresses returned by the DNS Service. Enter 0 to return all IP addresses. Allowed values are 1-20. Special values are 0- 'Return all IP addresses'.
	NumDNSIP int32 `json:"num_dns_ip,omitempty"`

	// Specifies the TTL value (in seconds) for records served by DNS Service. Allowed values are 1-86400.
	TTL int32 `json:"ttl,omitempty"`
}
