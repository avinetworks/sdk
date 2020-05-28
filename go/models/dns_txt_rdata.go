package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// DNSTxtRdata Dns txt rdata
// swagger:model DnsTxtRdata
type DNSTxtRdata struct {

	// Text data associated with the FQDN. Field introduced in 18.2.9.
	// Required: true
	TextStr *string `json:"text_str"`
}
