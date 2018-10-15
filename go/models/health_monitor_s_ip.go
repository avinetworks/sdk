package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// HealthMonitorSIP health monitor s IP
// swagger:model HealthMonitorSIP
type HealthMonitorSIP struct {

	// Specify the SIP request to be sent to the server. Enum options - SIP_OPTIONS. Field introduced in 17.2.8, 18.1.3.
	// Required: true
	SipRequestCode *string `json:"sip_request_code"`

	// String to match in server response, max length is 512 characters. By default it checks for SIP/2.0 in payload. Field introduced in 17.2.8, 18.1.3.
	SipResponse *string `json:"sip_response,omitempty"`
}
