package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// LinuxServerHost linux server host
// swagger:model LinuxServerHost
type LinuxServerHost struct {

	// Placeholder for description of property host_attr of obj type LinuxServerHost field type str  type object
	HostAttr []*HostAttributes `json:"host_attr,omitempty"`

	// Placeholder for description of property host_ip of obj type LinuxServerHost field type str  type object
	// Required: true
	HostIP *IPAddr `json:"host_ip"`

	// Node's availability zone. ServiceEngines belonging to the availability zone will be rebooted during a manual DR failover.
	NodeAvailabilityZone string `json:"node_availability_zone,omitempty"`
}
