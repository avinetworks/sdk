package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// JobEntry job entry
// swagger:model JobEntry
type JobEntry struct {

	// cookie of JobEntry.
	Cookie string `json:"cookie,omitempty"`

	// expires_at of JobEntry.
	// Required: true
	ExpiresAt string `json:"expires_at"`

	// obj_key of JobEntry.
	// Required: true
	ObjKey string `json:"obj_key"`

	//  Enum options - JOB_OWNER_VIRTUALSERVICE, JOB_OWNER_SSL, JOB_OWNER_DEBUG_VIRTUALSERVICE, JOB_OWNER_CONSISTENCY_CHECKER, JOB_OWNER_TECHSUPPORT_UPLOADER, JOB_OWNER_PKI_PROFILE, JOB_OWNER_NETWORKSECURITYPOLICY, JOB_OWNER_SEGROUP, JOB_OWNER_POSTGRES_STATUS.
	// Required: true
	Owner string `json:"owner"`

	//  It is a reference to an object of type Tenant.
	TenantRef string `json:"tenant_ref,omitempty"`

	//  Enum options - JOB_TYPE_VS_FULL_LOGS, JOB_TYPE_VS_UDF, JOB_TYPE_VS_METRICS_RT, JOB_TYPE_SSL_CERT, JOB_TYPE_DEBUGVS_PKT_CAPTURE, JOB_TYPE_CONSISTENCY_CHECK, JOB_TYPE_TECHSUPPORT, JOB_TYPE_PKI_PROFILE, JOB_TYPE_NSP_RULE, JOB_TYPE_SEGROUP_METRICS_RT, JOB_TYPE_POSTGRES_STATUS.
	// Required: true
	Type string `json:"type"`

	// url
	// Read Only: true
	URL string `json:"url,omitempty"`

	// Unique object identifier of the object.
	UUID string `json:"uuid,omitempty"`
}
