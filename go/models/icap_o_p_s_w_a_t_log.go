package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// IcapOPSWATLog icap o p s w a t log
// swagger:model IcapOPSWATLog
type IcapOPSWATLog struct {

	// Blocking reason for the content. It is available only if content was scanned by ICAP server and some violations were found. Field introduced in 21.1.1.
	Reason *string `json:"reason,omitempty"`

	// Short description of the threat found in the content. Available only if content was scanned by ICAP server and some violations were found. Field introduced in 21.1.1.
	ThreatID *string `json:"threat_id,omitempty"`

	// Threat found in the content. Available only if content was scanned by ICAP server and some violations were found. Field introduced in 21.1.1.
	Violations []*IcapViolation `json:"violations,omitempty"`
}
