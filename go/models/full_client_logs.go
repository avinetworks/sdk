package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// FullClientLogs full client logs
// swagger:model FullClientLogs
type FullClientLogs struct {

	// Log all headers.
	AllHeaders bool `json:"all_headers,omitempty"`

	// How long should the system capture all logs, measured in minutes. Set to 0 for infinite. Special values are 0 - 'infinite'.
	Duration int32 `json:"duration,omitempty"`

	// Capture all client logs including connections and requests.  When disabled, only errors will be logged.
	// Required: true
	Enabled bool `json:"enabled"`
}
