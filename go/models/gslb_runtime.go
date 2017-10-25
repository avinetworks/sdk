package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// GslbRuntime gslb runtime
// swagger:model GslbRuntime
type GslbRuntime struct {

	//  Field introduced in 17.1.3.
	Checksum string `json:"checksum,omitempty"`

	// Placeholder for description of property dns_enabled of obj type GslbRuntime field type str  type boolean
	DNSEnabled bool `json:"dns_enabled,omitempty"`

	// Placeholder for description of property event_cache of obj type GslbRuntime field type str  type object
	EventCache *EventCache `json:"event_cache,omitempty"`

	// Placeholder for description of property flr_state of obj type GslbRuntime field type str  type object
	FlrState []*CfgState `json:"flr_state,omitempty"`

	// Placeholder for description of property ldr_state of obj type GslbRuntime field type str  type object
	LdrState *CfgState `json:"ldr_state,omitempty"`

	// Name of the object.
	Name string `json:"name,omitempty"`

	// Placeholder for description of property site of obj type GslbRuntime field type str  type object
	Site []*GslbSiteRuntime `json:"site,omitempty"`

	//  Field introduced in 17.1.1.
	ThirdPartySites []*GslbThirdPartySiteRuntime `json:"third_party_sites,omitempty"`

	// Unique object identifier of the object.
	UUID string `json:"uuid,omitempty"`
}
