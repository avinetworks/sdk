package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// VirtualServiceRuntime virtual service runtime
// swagger:model VirtualServiceRuntime
type VirtualServiceRuntime struct {

	// Placeholder for description of property apic_extension of obj type VirtualServiceRuntime field type str  type object
	ApicExtension *VsApicExtension `json:"apic_extension,omitempty"`

	// controller_ip of VirtualServiceRuntime.
	ControllerIP *string `json:"controller_ip,omitempty"`

	// Placeholder for description of property datapath_debug of obj type VirtualServiceRuntime field type str  type object
	DatapathDebug *DebugVirtualService `json:"datapath_debug,omitempty"`

	// Placeholder for description of property east_west of obj type VirtualServiceRuntime field type str  type boolean
	EastWest *bool `json:"east_west,omitempty"`

	//  Field introduced in 17.1.1.
	GslbDNSGeoUpdate *GslbDNSGeoUpdate `json:"gslb_dns_geo_update,omitempty"`

	// Placeholder for description of property gslb_dns_update of obj type VirtualServiceRuntime field type str  type object
	GslbDNSUpdate *GslbDNSUpdate `json:"gslb_dns_update,omitempty"`

	// Placeholder for description of property ipam_dns_records of obj type VirtualServiceRuntime field type str  type object
	IPAMDNSRecords []*DNSRecord `json:"ipam_dns_records,omitempty"`

	// Placeholder for description of property is_dns_vs of obj type VirtualServiceRuntime field type str  type boolean
	IsDNSVs *bool `json:"is_dns_vs,omitempty"`

	// Placeholder for description of property last_changed_time of obj type VirtualServiceRuntime field type str  type object
	LastChangedTime *TimeStamp `json:"last_changed_time,omitempty"`

	// lif of VirtualServiceRuntime.
	Lif []string `json:"lif,omitempty"`

	// Placeholder for description of property manual_placement of obj type VirtualServiceRuntime field type str  type boolean
	ManualPlacement *bool `json:"manual_placement,omitempty"`

	// Placeholder for description of property marked_for_delete of obj type VirtualServiceRuntime field type str  type boolean
	MarkedForDelete *bool `json:"marked_for_delete,omitempty"`

	//  Enum options - METRICS_MGR_PORT_0, METRICS_MGR_PORT_1, METRICS_MGR_PORT_2, METRICS_MGR_PORT_3.
	MetricsMgrPort *string `json:"metrics_mgr_port,omitempty"`

	// Number of num_additional_se.
	NumAdditionalSe *int32 `json:"num_additional_se,omitempty"`

	// Placeholder for description of property one_plus_one_ha of obj type VirtualServiceRuntime field type str  type boolean
	OnePlusOneHa *bool `json:"one_plus_one_ha,omitempty"`

	// prev_controller_ip of VirtualServiceRuntime.
	PrevControllerIP *string `json:"prev_controller_ip,omitempty"`

	//  Enum options - METRICS_MGR_PORT_0, METRICS_MGR_PORT_1, METRICS_MGR_PORT_2, METRICS_MGR_PORT_3.
	PrevMetricsMgrPort *string `json:"prev_metrics_mgr_port,omitempty"`

	// Number of redis_db.
	RedisDb *int32 `json:"redis_db,omitempty"`

	// redis_ip of VirtualServiceRuntime.
	RedisIP *string `json:"redis_ip,omitempty"`

	// Number of redis_port.
	RedisPort *int32 `json:"redis_port,omitempty"`

	// Placeholder for description of property rules_configured of obj type VirtualServiceRuntime field type str  type boolean
	RulesConfigured *bool `json:"rules_configured,omitempty"`

	// Enable Service Engines to elect a primary amongst themselves in the absence of connectivity to controller. Field introduced in 18.1.2.
	SelfSeElection *bool `json:"self_se_election,omitempty"`

	// Placeholder for description of property servers_configured of obj type VirtualServiceRuntime field type str  type boolean
	ServersConfigured *bool `json:"servers_configured,omitempty"`

	// Placeholder for description of property tls_ticket_key of obj type VirtualServiceRuntime field type str  type object
	TLSTicketKey []*TLSTicket `json:"tls_ticket_key,omitempty"`

	//  Enum options - VS_TYPE_NORMAL, VS_TYPE_VH_PARENT, VS_TYPE_VH_CHILD.
	Type *string `json:"type,omitempty"`

	// Unique object identifier of the object.
	UUID *string `json:"uuid,omitempty"`

	// Version number of the SE List update.
	Version *int64 `json:"version,omitempty"`

	//  It is a reference to an object of type VirtualService.
	VhChildVsRef []string `json:"vh_child_vs_ref,omitempty"`

	// Placeholder for description of property vip_runtime of obj type VirtualServiceRuntime field type str  type object
	VipRuntime []*VipRuntime `json:"vip_runtime,omitempty"`

	// VS update request received before warmstart finished. Field introduced in 18.1.4.
	VsUpdatePending *VirtualService `json:"vs_update_pending,omitempty"`
}
