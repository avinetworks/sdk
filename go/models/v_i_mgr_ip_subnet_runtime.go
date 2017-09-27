package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// VIMgrIPSubnetRuntime v i mgr IP subnet runtime
// swagger:model VIMgrIPSubnetRuntime
type VIMgrIPSubnetRuntime struct {

	// Indicates floating/elastic IP association possibility.
	FipAvailable bool `json:"fip_available,omitempty"`

	// If fip_available is True, this is list of supported FIP subnets, possibly empty if Cloud does not support such a network list.
	FipSubnetUuids []string `json:"fip_subnet_uuids,omitempty"`

	// ip_subnet of VIMgrIPSubnetRuntime.
	IPSubnet string `json:"ip_subnet,omitempty"`

	// Name of the object.
	Name string `json:"name,omitempty"`

	// Placeholder for description of property prefix of obj type VIMgrIPSubnetRuntime field type str  type object
	// Required: true
	Prefix *IPAddrPrefix `json:"prefix"`

	// True if prefix is primary IP on interface, else false.
	Primary bool `json:"primary,omitempty"`

	// Number of ref_count.
	RefCount int32 `json:"ref_count,omitempty"`

	// Number of se_ref_count.
	SeRefCount int32 `json:"se_ref_count,omitempty"`

	// Unique object identifier of the object.
	UUID string `json:"uuid,omitempty"`
}
