package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// VlanInterface vlan interface
// swagger:model VlanInterface
type VlanInterface struct {

	// Placeholder for description of property dhcp_enabled of obj type VlanInterface field type str  type boolean
	DhcpEnabled bool `json:"dhcp_enabled,omitempty"`

	// if_name of VlanInterface.
	// Required: true
	IfName string `json:"if_name"`

	// Placeholder for description of property is_mgmt of obj type VlanInterface field type str  type boolean
	// Read Only: true
	IsMgmt bool `json:"is_mgmt,omitempty"`

	// Number of vlan_id.
	VlanID int32 `json:"vlan_id,omitempty"`

	// Placeholder for description of property vnic_networks of obj type VlanInterface field type str  type object
	VnicNetworks []*VNICNetwork `json:"vnic_networks,omitempty"`

	//  It is a reference to an object of type VrfContext.
	VrfRef string `json:"vrf_ref,omitempty"`
}
