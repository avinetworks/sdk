package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// VNIC v n i c
// swagger:model vNIC
type VNIC struct {

	// adapter of vNIC.
	// Read Only: true
	Adapter string `json:"adapter,omitempty"`

	// Placeholder for description of property can_se_dp_takeover of obj type vNIC field type str  type boolean
	// Read Only: true
	CanSeDpTakeover bool `json:"can_se_dp_takeover,omitempty"`

	// Placeholder for description of property connected of obj type vNIC field type str  type boolean
	// Read Only: true
	Connected bool `json:"connected,omitempty"`

	// Placeholder for description of property del_pending of obj type vNIC field type str  type boolean
	// Read Only: true
	DelPending bool `json:"del_pending,omitempty"`

	// Placeholder for description of property dhcp_enabled of obj type vNIC field type str  type boolean
	DhcpEnabled bool `json:"dhcp_enabled,omitempty"`

	// Placeholder for description of property enabled of obj type vNIC field type str  type boolean
	Enabled bool `json:"enabled,omitempty"`

	// if_name of vNIC.
	// Read Only: true
	IfName string `json:"if_name,omitempty"`

	// Placeholder for description of property is_asm of obj type vNIC field type str  type boolean
	// Read Only: true
	IsAsm bool `json:"is_asm,omitempty"`

	// Placeholder for description of property is_avi_internal_network of obj type vNIC field type str  type boolean
	// Read Only: true
	IsAviInternalNetwork bool `json:"is_avi_internal_network,omitempty"`

	// Placeholder for description of property is_hsm of obj type vNIC field type str  type boolean
	// Read Only: true
	IsHsm bool `json:"is_hsm,omitempty"`

	// Placeholder for description of property is_mgmt of obj type vNIC field type str  type boolean
	// Read Only: true
	IsMgmt bool `json:"is_mgmt,omitempty"`

	// Placeholder for description of property is_portchannel of obj type vNIC field type str  type boolean
	// Read Only: true
	IsPortchannel bool `json:"is_portchannel,omitempty"`

	// linux_name of vNIC.
	// Read Only: true
	LinuxName string `json:"linux_name,omitempty"`

	// mac_address of vNIC.
	// Required: true
	// Read Only: true
	MacAddress string `json:"mac_address"`

	// Placeholder for description of property members of obj type vNIC field type str  type object
	// Read Only: true
	Members []*MemberInterface `json:"members,omitempty"`

	// Number of mtu.
	// Read Only: true
	Mtu int32 `json:"mtu,omitempty"`

	// network_name of vNIC.
	// Read Only: true
	NetworkName string `json:"network_name,omitempty"`

	//  It is a reference to an object of type Network.
	// Read Only: true
	NetworkRef string `json:"network_ref,omitempty"`

	// pci_id of vNIC.
	// Read Only: true
	PciID string `json:"pci_id,omitempty"`

	// Unique object identifier of port.
	// Read Only: true
	PortUUID string `json:"port_uuid,omitempty"`

	// Number of vlan_id.
	// Read Only: true
	VlanID int32 `json:"vlan_id,omitempty"`

	// Placeholder for description of property vlan_interfaces of obj type vNIC field type str  type object
	VlanInterfaces []*VlanInterface `json:"vlan_interfaces,omitempty"`

	// Placeholder for description of property vnic_networks of obj type vNIC field type str  type object
	VnicNetworks []*VNICNetwork `json:"vnic_networks,omitempty"`

	// Number of vrf_id.
	// Read Only: true
	VrfID int32 `json:"vrf_id,omitempty"`

	//  It is a reference to an object of type VrfContext.
	VrfRef string `json:"vrf_ref,omitempty"`
}
