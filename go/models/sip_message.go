package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SipMessage sip message
// swagger:model SipMessage
type SipMessage struct {

	// Contents of unparsed SIP message, upto first 128 bytes. Field introduced in 17.2.12.
	Content string `json:"content,omitempty"`

	// Indicates if SIP message is received from a client. Field introduced in 17.2.12.
	FromClient bool `json:"from_client,omitempty"`

	// SIP request method string. Field introduced in 17.2.12.
	Method string `json:"method,omitempty"`

	// SIP message receive time stamp. Field introduced in 17.2.12.
	RcvTimestamp int64 `json:"rcv_timestamp,omitempty"`

	// SIP message size before modifications. Field introduced in 17.2.12.
	RxBytes int32 `json:"rx_bytes,omitempty"`

	// SIP response status string. Field introduced in 17.2.12.
	Status string `json:"status,omitempty"`

	// SIP response status code, 2xx response means success. Field introduced in 17.2.12.
	StatusCode int32 `json:"status_code,omitempty"`

	// SIP message size post modifications. Field introduced in 17.2.12.
	TxBytes int32 `json:"tx_bytes,omitempty"`
}
