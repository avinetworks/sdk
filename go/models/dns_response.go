package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// DNSResponse Dns response
// swagger:model DnsResponse
type DNSResponse struct {

	// Number of additional records.
	AdditionalRecordsCount int32 `json:"additional_records_count,omitempty"`

	// Number of answer records.
	AnswerRecordsCount int32 `json:"answer_records_count,omitempty"`

	// Flag to indicate the responding DNS is an authority for the requested FQDN.
	AuthoritativeAnswer bool `json:"authoritative_answer,omitempty"`

	// Number of nameserver records.
	NameserverRecordsCount int32 `json:"nameserver_records_count,omitempty"`

	// Opt resource records in the response. Field introduced in 17.1.1.
	OptRecord *DNSOptRecord `json:"opt_record,omitempty"`

	// Resource records in the response.
	Records []*DNSResourceRecord `json:"records,omitempty"`

	// Flag indicating the DNS query is fully answered.
	RecursionAvailable bool `json:"recursion_available,omitempty"`

	// Response code in the response. Enum options - DNS_RCODE_NOERROR, DNS_RCODE_FORMERR, DNS_RCODE_SERVFAIL, DNS_RCODE_NXDOMAIN, DNS_RCODE_NOTIMP, DNS_RCODE_REFUSED, DNS_RCODE_YXDOMAIN, DNS_RCODE_YXRRSET, DNS_RCODE_NXRRSET, DNS_RCODE_NOTAUTH, DNS_RCODE_NOTZONE.
	ResponseCode string `json:"response_code,omitempty"`

	// Flag to indicate if the answer received from DNS is truncated (original answer exceeds 512 bytes UDP limit).
	Truncation bool `json:"truncation,omitempty"`
}
