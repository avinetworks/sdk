package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SiteVersion site version
// swagger:model SiteVersion
type SiteVersion struct {

	// UNIX time since epoch in microseconds. Units(MICROSECONDS).
	// Read Only: true
	LastModified *string `json:"_last_modified,omitempty"`

	// Date when the site was created. Field introduced in 20.1.1.
	Date *string `json:"date,omitempty"`

	// Name of the Site. Field introduced in 20.1.1.
	// Required: true
	Name *string `json:"name"`

	// Previous targer version for a site. Field introduced in 20.1.1.
	PrevTargetVersion *int64 `json:"prev_target_version,omitempty"`

	// Replication state for a site. Enum options - REPLICATION_STATE_FASTFORWARD, REPLICATION_STATE_FORCESYNC, REPLICATION_STATE_STREAMING, REPLICATION_STATE_SUSPENDED. Field introduced in 20.1.1.
	ReplicationState *string `json:"replication_state,omitempty"`

	// Cluster UUID of the site. Field introduced in 20.1.1.
	SiteID *string `json:"site_id,omitempty"`

	// Target version of the site. Field introduced in 20.1.1.
	TargetVersion *int64 `json:"target_version,omitempty"`

	// Tenant that this object belongs to. It is a reference to an object of type Tenant. Field introduced in 20.1.1.
	TenantRef *string `json:"tenant_ref,omitempty"`

	// url
	// Read Only: true
	URL *string `json:"url,omitempty"`

	// UUID of the SiteVersion object. Field introduced in 20.1.1.
	UUID *string `json:"uuid,omitempty"`

	// Version of the site. Field introduced in 20.1.1.
	Version *int64 `json:"version,omitempty"`

	// Type of message for which version is maintained. Enum options - CONFIG_VERSION, HEALTH_STATUS_VERSION. Field introduced in 20.1.1.
	VersionType *string `json:"version_type,omitempty"`
}
