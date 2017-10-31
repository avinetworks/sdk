package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// WafRuleLog waf rule log
// swagger:model WafRuleLog
type WafRuleLog struct {

	//  Field introduced in 17.2.1.
	Matches []*WafRuleMatchData `json:"matches,omitempty"`

	//  Field introduced in 17.2.1.
	Msg string `json:"msg,omitempty"`

	//  Field introduced in 17.2.1.
	Phase string `json:"phase,omitempty"`

	//  Field introduced in 17.2.1.
	RuleGroup string `json:"rule_group,omitempty"`

	//  Field introduced in 17.2.1.
	RuleID string `json:"rule_id,omitempty"`

	//  Field introduced in 17.2.1.
	Tags []string `json:"tags,omitempty"`
}
