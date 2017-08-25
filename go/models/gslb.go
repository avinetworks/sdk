package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// Gslb gslb
// swagger:model Gslb
type Gslb struct {

	// Max retries after which the remote site is treatedas a fresh start. In fresh start all the configsare downloaded. Allowed values are 1-1024.
	ClearOnMaxRetries int32 `json:"clear_on_max_retries,omitempty"`

	// Group to specify if the client ip addresses are public or private. Field introduced in 17.1.2.
	ClientIPAddrGroup *GslbClientIPAddrGroup `json:"client_ip_addr_group,omitempty"`

	// User defined description for the object.
	Description string `json:"description,omitempty"`

	// Sub domain configuration for the GSLB.  GSLB service's FQDN must be a match one of these subdomains. .
	DNSConfigs []*DNSConfig `json:"dns_configs,omitempty"`

	// Mark this Site as leader of GSLB configuration. This site is the one among the Avi sites.
	// Required: true
	LeaderClusterUUID string `json:"leader_cluster_uuid"`

	// Name for the GSLB object.
	// Required: true
	Name string `json:"name"`

	// Frequency with which group members communicate. Allowed values are 1-3600.
	SendInterval int32 `json:"send_interval,omitempty"`

	// Select Avi site member belonging to this Gslb.
	Sites []*GslbSite `json:"sites,omitempty"`

	//  It is a reference to an object of type Tenant.
	TenantRef string `json:"tenant_ref,omitempty"`

	// Third party site member belonging to this Gslb. Field introduced in 17.1.1.
	ThirdPartySites []*GslbThirdPartySite `json:"third_party_sites,omitempty"`

	// url
	// Read Only: true
	URL string `json:"url,omitempty"`

	// UUID of the GSLB object.
	UUID string `json:"uuid,omitempty"`

	// The view-id is used in maintenance mode to differentiate partitioned groups while they havethe same gslb namespace. Each partitioned groupwill be able to operate independently by using theview-id.
	// Read Only: true
	ViewID int64 `json:"view_id,omitempty"`
}
