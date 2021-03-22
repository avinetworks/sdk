package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// CompressionProfile compression profile
// swagger:model CompressionProfile
type CompressionProfile struct {

	// Number of buffers to use for compression output. Field introduced in 21.1.1.
	BufNum *int32 `json:"buf_num,omitempty"`

	// Size of each buffer used for compression output, this should ideally be a multiple of pagesize. Field introduced in 21.1.1.
	BufSize *int32 `json:"buf_size,omitempty"`

	// Compress only content types listed in this *string group. Content types not present in this list are not compressed. It is a reference to an object of type StringGroup.
	CompressibleContentRef *string `json:"compressible_content_ref,omitempty"`

	// Compress HTTP response content if it wasn't already compressed.
	// Required: true
	Compression *bool `json:"compression"`

	// Custom filters used when auto compression is not selected.
	Filter []*CompressionFilter `json:"filter,omitempty"`

	// hash size used by compression, rounded to the last power of 2. Field introduced in 21.1.1.
	HashSize *int32 `json:"hash_size,omitempty"`

	// Level of compression to apply on content selected for aggressive compression. Field introduced in 21.1.1.
	LevelAggressive *int32 `json:"level_aggressive,omitempty"`

	// Level of compression to apply on content selected for normal compression. Field introduced in 21.1.1.
	LevelNormal *int32 `json:"level_normal,omitempty"`

	// If client RTT is higher than this threshold, enable normal compression on the response. Field introduced in 21.1.1. Unit is MILLISECONDS.
	MaxLowRtt *int32 `json:"max_low_rtt,omitempty"`

	// If client RTT is higher than this threshold, enable aggressive compression on the response.  . Field introduced in 21.1.1. Unit is MILLISECONDS.
	MinHighRtt *int32 `json:"min_high_rtt,omitempty"`

	// Minimum response content length to enable compression. Field introduced in 21.1.1.
	MinLength *int32 `json:"min_length,omitempty"`

	// Values that identify mobile browsers in order to enable aggressive compression. It is a reference to an object of type StringGroup. Field introduced in 21.1.1.
	MobileStrRef *string `json:"mobile_str_ref,omitempty"`

	// Offload compression from the servers to AVI. Saves compute cycles on the servers.
	// Required: true
	RemoveAcceptEncodingHeader *bool `json:"remove_accept_encoding_header"`

	// Compress content automatically or add custom filters to define compressible content and compression levels. Enum options - AUTO_COMPRESSION, CUSTOM_COMPRESSION.
	// Required: true
	Type *string `json:"type"`

	// window size used by compression, rounded to the last power of 2. Field introduced in 21.1.1.
	WindowSize *int32 `json:"window_size,omitempty"`
}
