package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SingleLicense single license
// swagger:model SingleLicense
type SingleLicense struct {

	// Number of backend_servers.
	BackendServers int32 `json:"backend_servers,omitempty"`

	// Number of service engine cores in non-container clouds.
	Cores int32 `json:"cores,omitempty"`

	// created_on of SingleLicense.
	CreatedOn string `json:"created_on,omitempty"`

	// customer_name of SingleLicense.
	// Required: true
	CustomerName string `json:"customer_name"`

	// enforced_params of SingleLicense.
	EnforcedParams []string `json:"enforced_params,omitempty"`

	// last_update of SingleLicense.
	LastUpdate string `json:"last_update,omitempty"`

	// license_id of SingleLicense.
	LicenseID string `json:"license_id,omitempty"`

	// license_name of SingleLicense.
	// Required: true
	LicenseName string `json:"license_name"`

	// license_string of SingleLicense.
	LicenseString string `json:"license_string,omitempty"`

	// license_tier of SingleLicense.
	LicenseTier []string `json:"license_tier,omitempty"`

	// license_type of SingleLicense.
	LicenseType string `json:"license_type,omitempty"`

	// Number of max_apps.
	MaxApps int32 `json:"max_apps,omitempty"`

	// Number of service engines hosts in container clouds.
	MaxSes int32 `json:"max_ses,omitempty"`

	// Number of physical cpu sockets across service engines in no access and linux server clouds.
	Sockets int32 `json:"sockets,omitempty"`

	// start_on of SingleLicense.
	StartOn string `json:"start_on,omitempty"`

	// Number of throughput.
	Throughput int32 `json:"throughput,omitempty"`

	// valid_until of SingleLicense.
	// Required: true
	ValidUntil string `json:"valid_until"`

	// version of SingleLicense.
	Version string `json:"version,omitempty"`
}
