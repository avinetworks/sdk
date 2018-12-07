package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SeList se list
// swagger:model SeList
type SeList struct {

	// Placeholder for description of property admin_down_requested of obj type SeList field type str  type boolean
	AdminDownRequested *bool `json:"admin_down_requested,omitempty"`

	// Placeholder for description of property at_curr_ver of obj type SeList field type str  type boolean
	AtCurrVer *bool `json:"at_curr_ver,omitempty"`

	//  Field introduced in 17.2.3.
	AttachIPStatus *string `json:"attach_ip_status,omitempty"`

	//  Field introduced in 17.2.3.
	AttachIPSuccess *bool `json:"attach_ip_success,omitempty"`

	// Placeholder for description of property delete_in_progress of obj type SeList field type str  type boolean
	DeleteInProgress *bool `json:"delete_in_progress,omitempty"`

	// Placeholder for description of property download_selist_only of obj type SeList field type str  type boolean
	DownloadSelistOnly *bool `json:"download_selist_only,omitempty"`

	// Placeholder for description of property floating_intf_ip of obj type SeList field type str  type object
	FloatingIntfIP []*IPAddr `json:"floating_intf_ip,omitempty"`

	// This flag indicates whether the geo-files have been pushed to the DNS-VS's SE. Field introduced in 17.1.1.
	GeoDownload *bool `json:"geo_download,omitempty"`

	// This flag indicates whether the geodb object has been pushed to the DNS-VS's SE. Field introduced in 17.1.2.
	GeodbDownload *bool `json:"geodb_download,omitempty"`

	// This flag indicates whether the gslb, ghm, gs objects have been pushed to the DNS-VS's SE. Field introduced in 17.1.1.
	GslbDownload *bool `json:"gslb_download,omitempty"`

	// Placeholder for description of property is_connected of obj type SeList field type str  type boolean
	IsConnected *bool `json:"is_connected,omitempty"`

	// Placeholder for description of property is_portchannel of obj type SeList field type str  type boolean
	IsPortchannel *bool `json:"is_portchannel,omitempty"`

	// Placeholder for description of property is_primary of obj type SeList field type str  type boolean
	IsPrimary *bool `json:"is_primary,omitempty"`

	// Placeholder for description of property is_standby of obj type SeList field type str  type boolean
	IsStandby *bool `json:"is_standby,omitempty"`

	// Number of memory.
	Memory *int32 `json:"memory,omitempty"`

	// Placeholder for description of property pending_download of obj type SeList field type str  type boolean
	PendingDownload *bool `json:"pending_download,omitempty"`

	// Placeholder for description of property scalein_in_progress of obj type SeList field type str  type boolean
	ScaleinInProgress *bool `json:"scalein_in_progress,omitempty"`

	//  It is a reference to an object of type ServiceEngine.
	// Required: true
	SeRef *string `json:"se_ref"`

	// Number of sec_idx.
	SecIdx *int32 `json:"sec_idx,omitempty"`

	// Placeholder for description of property snat_ip of obj type SeList field type str  type object
	SnatIP *IPAddr `json:"snat_ip,omitempty"`

	// Number of vcpus.
	Vcpus *int32 `json:"vcpus,omitempty"`

	// version of SeList.
	Version *string `json:"version,omitempty"`

	//  Field introduced in 18.1.1.
	Vip6SubnetMask *int32 `json:"vip6_subnet_mask,omitempty"`

	// Placeholder for description of property vip_intf_ip of obj type SeList field type str  type object
	VipIntfIP *IPAddr `json:"vip_intf_ip,omitempty"`

	// Placeholder for description of property vip_intf_list of obj type SeList field type str  type object
	VipIntfList []*SeVipInterfaceList `json:"vip_intf_list,omitempty"`

	// vip_intf_mac of SeList.
	VipIntfMac *string `json:"vip_intf_mac,omitempty"`

	// Number of vip_subnet_mask.
	VipSubnetMask *int32 `json:"vip_subnet_mask,omitempty"`

	// Number of vlan_id.
	VlanID *int32 `json:"vlan_id,omitempty"`

	// Placeholder for description of property vnic of obj type SeList field type str  type object
	Vnic []*VsSeVnic `json:"vnic,omitempty"`
}
