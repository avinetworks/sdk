package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// GslbSiteRuntime gslb site runtime
// swagger:model GslbSiteRuntime
type GslbSiteRuntime struct {

	// Placeholder for description of property rxed_site_hs of obj type GslbSiteRuntime field type str  type object
	RxedSiteHs *GslbSiteHealthStatus `json:"rxed_site_hs,omitempty"`

	// Placeholder for description of property site_cfg of obj type GslbSiteRuntime field type str  type object
	SiteCfg *GslbSiteRuntimeCfg `json:"site_cfg,omitempty"`

	// Placeholder for description of property site_info of obj type GslbSiteRuntime field type str  type object
	SiteInfo *GslbSiteRuntimeInfo `json:"site_info,omitempty"`

	// Placeholder for description of property site_stats of obj type GslbSiteRuntime field type str  type object
	SiteStats *GslbSiteRuntimeStats `json:"site_stats,omitempty"`
}
