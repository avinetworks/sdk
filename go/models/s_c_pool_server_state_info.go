package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SCPoolServerStateInfo s c pool server state info
// swagger:model SCPoolServerStateInfo
type SCPoolServerStateInfo struct {

	//  Field introduced in 17.1.1.
	IsServer bool `json:"is_server,omitempty"`

	//  Field introduced in 17.1.1.
	OperStatus *OperationalStatus `json:"oper_status,omitempty"`

	//  It is a reference to an object of type Pool. Field introduced in 17.1.1.
	PoolRef string `json:"pool_ref,omitempty"`

	//  Field introduced in 17.1.1.
	ServerStates []*SCServerStateInfo `json:"server_states,omitempty"`

	//  It is a reference to an object of type Tenant. Field introduced in 17.1.1.
	TenantRef string `json:"tenant_ref,omitempty"`

	// url
	// Read Only: true
	URL string `json:"url,omitempty"`

	//  Field introduced in 17.1.1.
	UUID string `json:"uuid,omitempty"`
}
