package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SingleLicense single license
// swagger:model SingleLicense
type SingleLicense struct {

	// Total number of Service Engine burst cores for core based licenses. Field introduced in 17.2.5.
	BurstCores *int32 `json:"burst_cores,omitempty"`

	// Number of Service Engine cores in non-container clouds.
	Cores *float64 `json:"cores,omitempty"`

	// Total number of cpu cores. Field introduced in 20.1.1.
	CPUCores *float64 `json:"cpu_cores,omitempty"`

	// created_on of SingleLicense.
	CreatedOn *string `json:"created_on,omitempty"`

	// customer_name of SingleLicense.
	// Required: true
	CustomerName *string `json:"customer_name"`

	// enforced_params of SingleLicense.
	EnforcedParams []string `json:"enforced_params,omitempty"`

	// Flag to track license expiry. Field introduced in 20.1.1.
	Expired *bool `json:"expired,omitempty"`

	// last_update of SingleLicense.
	LastUpdate *string `json:"last_update,omitempty"`

	// license_id of SingleLicense.
	LicenseID *string `json:"license_id,omitempty"`

	// license_name of SingleLicense.
	// Required: true
	LicenseName *string `json:"license_name"`

	// license_string of SingleLicense.
	LicenseString *string `json:"license_string,omitempty"`

	// license_tier of SingleLicense.
	LicenseTier []string `json:"license_tier,omitempty"`

	// license_type of SingleLicense.
	LicenseType *string `json:"license_type,omitempty"`

	// Number of Service Engines hosts in container clouds.
	MaxSes *int32 `json:"max_ses,omitempty"`

	// Service Engine bandwidth limits for bandwidth based licenses. Field introduced in 17.2.5.
	SeBandwidthLimits []*SEBandwidthLimit `json:"se_bandwidth_limits,omitempty"`

	// Serial key (Hyphen separated 25 char wide alphanumeric key Ex  AA123-23BAS-383AS-383UD-FHSFG). Field introduced in 20.1.1.
	SerialKey *string `json:"serial_key,omitempty"`

	// Total number of service cores equivalent to all the resoures available in the single license. Field introduced in 20.1.1.
	ServiceCores *float64 `json:"service_cores,omitempty"`

	// Number of physical cpu sockets across Service Engines in no access and linux server clouds.
	Sockets *int32 `json:"sockets,omitempty"`

	// start_on of SingleLicense.
	StartOn *string `json:"start_on,omitempty"`

	// Specifies the licensed tier. Enum options - ENTERPRISE_16, ENTERPRISE, ENTERPRISE_18, BASIC, ESSENTIALS. Field introduced in 17.2.5.
	TierType *string `json:"tier_type,omitempty"`

	// valid_until of SingleLicense.
	// Required: true
	ValidUntil *string `json:"valid_until"`

	// version of SingleLicense.
	Version *string `json:"version,omitempty"`
}
