package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// ReplicationOperation replication operation
// swagger:model ReplicationOperation
type ReplicationOperation struct {

	// Specifies the kind of replication. Enum options - REPLICATION_OPS_FASTFORWARD, REPLICATION_OPS_FORCESYNC. Field introduced in 20.1.1.
	Ops *string `json:"ops,omitempty"`

	// Active follower site UUID which need to sync to leaders checkpoint. Field introduced in 20.1.1.
	SiteID *string `json:"site_id,omitempty"`
}
