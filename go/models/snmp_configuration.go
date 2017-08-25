package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SnmpConfiguration snmp configuration
// swagger:model SnmpConfiguration
type SnmpConfiguration struct {

	// Community string for SNMP v2c.
	Community string `json:"community,omitempty"`

	// Sets the sysContact in system MIB.
	SysContact string `json:"sys_contact,omitempty"`

	// Sets the sysLocation in system MIB.
	SysLocation string `json:"sys_location,omitempty"`
}
