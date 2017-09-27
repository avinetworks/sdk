package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// ClientLogStreamingConfig client log streaming config
// swagger:model ClientLogStreamingConfig
type ClientLogStreamingConfig struct {

	// The destination server IP address or hostname. If a name is provided, this should be resolvable on Avi Service Engines. Field introduced in 17.1.1.
	// Required: true
	ExternalServer string `json:"external_server"`

	// The destination server's service port. Field introduced in 17.1.1.
	ExternalServerPort int32 `json:"external_server_port,omitempty"`

	// Type of logs to stream to the external server. Default is LOGS_ALL, i.e., send all logs. Enum options - LOGS_SIGNIFICANT_ONLY, LOGS_UDF_ONLY, LOGS_UDF_SIGNIFICANT, LOGS_ALL. Field introduced in 17.1.1.
	LogTypesToSend string `json:"log_types_to_send,omitempty"`

	// Maximum number of logs per second streamed to the remote server. By default, 100 logs per second are streamed. Set this to zero(0) to not enforce any limit. Field introduced in 17.1.1.
	MaxLogsPerSecond int32 `json:"max_logs_per_second,omitempty"`
}
