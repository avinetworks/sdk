package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// AttackMetaData attack meta data
// swagger:model AttackMetaData
type AttackMetaData struct {

	// DNS amplification attack record. Field introduced in 21.1.1.
	Amplification *AttackDNSAmplification `json:"amplification,omitempty"`

	// ip of AttackMetaData.
	IP *string `json:"ip,omitempty"`

	// Number of max_resp_time.
	MaxRespTime *int32 `json:"max_resp_time,omitempty"`

	// url of AttackMetaData.
	URL *string `json:"url,omitempty"`
}
