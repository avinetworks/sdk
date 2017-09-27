package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SnmpTrapServer snmp trap server
// swagger:model SnmpTrapServer
type SnmpTrapServer struct {

	// The community string to communicate with the trap server.
	// Required: true
	Community string `json:"community"`

	// IP Address of the SNMP trap destination.
	// Required: true
	IPAddr *IPAddr `json:"ip_addr"`
}
