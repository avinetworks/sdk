package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SensitiveFieldRule sensitive field rule
// swagger:model SensitiveFieldRule
type SensitiveFieldRule struct {

	// Action for the match. Enum options - LOG_FIELD_REMOVE, LOG_FIELD_MASKOFF. Field introduced in 17.2.10.
	Action string `json:"action,omitempty"`

	// Enable rule to match the sensitive fields. Field introduced in 17.2.10.
	Enabled bool `json:"enabled,omitempty"`

	// Index of the rule. Field introduced in 17.2.10.
	Index int32 `json:"index,omitempty"`

	// Criterion to use for matching in the Log. Field introduced in 17.2.10.
	Match *StringMatch `json:"match,omitempty"`

	// Name of the rule. Field introduced in 17.2.10.
	Name string `json:"name,omitempty"`
}
