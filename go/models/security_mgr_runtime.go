package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SecurityMgrRuntime security mgr runtime
// swagger:model SecurityMgrRuntime
type SecurityMgrRuntime struct {

	//  Field introduced in 18.2.4.
	Thresholds []*SecMgrThreshold `json:"thresholds,omitempty"`
}
