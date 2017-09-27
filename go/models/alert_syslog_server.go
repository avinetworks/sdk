package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// AlertSyslogServer alert syslog server
// swagger:model AlertSyslogServer
type AlertSyslogServer struct {

	// The destination Syslog server IP address or hostname.
	// Required: true
	SyslogServer string `json:"syslog_server"`

	// The destination Syslog server's service port.
	SyslogServerPort int32 `json:"syslog_server_port,omitempty"`

	// Network protocol to establish syslog session.
	// Required: true
	UDP bool `json:"udp"`
}
