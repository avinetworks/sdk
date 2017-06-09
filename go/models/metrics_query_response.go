package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// MetricsQueryResponse metrics query response
// swagger:model MetricsQueryResponse
type MetricsQueryResponse struct {

	// Unique object identifier of entity.
	// Required: true
	EntityUUID string `json:"entity_uuid"`

	// returns the ID specified in the query.
	ID string `json:"id,omitempty"`

	// Number of limit.
	// Required: true
	Limit int32 `json:"limit"`

	//  Enum options - VSERVER_METRICS_ENTITY, VM_METRICS_ENTITY, SE_METRICS_ENTITY, CONTROLLER_METRICS_ENTITY, APPLICATION_METRICS_ENTITY, TENANT_METRICS_ENTITY.
	// Required: true
	MetricEntity string `json:"metric_entity"`

	// metric_id of MetricsQueryResponse.
	// Required: true
	MetricID string `json:"metric_id"`

	// Placeholder for description of property series of obj type MetricsQueryResponse field type str  type object
	Series []*MetricsDataSeries `json:"series,omitempty"`

	// start of MetricsQueryResponse.
	// Required: true
	Start string `json:"start"`

	// Number of step.
	// Required: true
	Step int32 `json:"step"`

	// stop of MetricsQueryResponse.
	// Required: true
	Stop string `json:"stop"`
}
