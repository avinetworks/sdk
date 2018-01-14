package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// VersionInfo version info
// swagger:model VersionInfo
type VersionInfo struct {

	// Name of the object.
	Name string `json:"name,omitempty"`

	//  Enum options - GSLB_NONE, GSLB_CREATE, GSLB_UPDATE, GSLB_DELETE, GSLB_PURGE, GSLB_DECL.
	Ops string `json:"ops,omitempty"`

	// Unique object identifier of the object.
	UUID string `json:"uuid,omitempty"`
}
