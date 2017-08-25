package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// AnalyticsPolicy analytics policy
// swagger:model AnalyticsPolicy
type AnalyticsPolicy struct {

	// Gain insights from sampled client to server HTTP requests and responses. Enum options - NO_INSIGHTS, PASSIVE, ACTIVE.
	ClientInsights string `json:"client_insights,omitempty"`

	// Placeholder for description of property client_insights_sampling of obj type AnalyticsPolicy field type str  type object
	ClientInsightsSampling *ClientInsightsSampling `json:"client_insights_sampling,omitempty"`

	// Placeholder for description of property client_log_filters of obj type AnalyticsPolicy field type str  type object
	ClientLogFilters []*ClientLogFilter `json:"client_log_filters,omitempty"`

	// Placeholder for description of property full_client_logs of obj type AnalyticsPolicy field type str  type object
	FullClientLogs *FullClientLogs `json:"full_client_logs,omitempty"`

	// Settings to turn on realtime metrics and set duration for realtime updates.
	MetricsRealtimeUpdate *MetricsRealTimeUpdate `json:"metrics_realtime_update,omitempty"`
}
