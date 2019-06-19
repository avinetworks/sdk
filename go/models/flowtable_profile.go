package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// FlowtableProfile flowtable profile
// swagger:model FlowtableProfile
type FlowtableProfile struct {

	// Idle timeout in seconds for TCP flows in closed state. Allowed values are 1-36000. Field introduced in 18.2.5.
	TCPClosedTimeout *int32 `json:"tcp_closed_timeout,omitempty"`

	// Idle timeout in seconds for nat TCP flows in connection setup state. Allowed values are 1-36000. Field introduced in 18.2.5.
	TCPConnectionSetupTimeout *int32 `json:"tcp_connection_setup_timeout,omitempty"`

	// Idle timeout in seconds for TCP flows in half closed state. Allowed values are 1-36000. Field introduced in 18.2.5.
	TCPHalfClosedTimeout *int32 `json:"tcp_half_closed_timeout,omitempty"`

	// Idle timeout in seconds for TCP flows. Allowed values are 1-36000. Field introduced in 18.2.5.
	TCPIDLETimeout *int32 `json:"tcp_idle_timeout,omitempty"`

	// Idle timeout in seconds for UDP flows. Allowed values are 1-36000. Field introduced in 18.2.5.
	UDPIDLETimeout *int32 `json:"udp_idle_timeout,omitempty"`
}
