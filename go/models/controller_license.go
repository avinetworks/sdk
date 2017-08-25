package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// ControllerLicense controller license
// swagger:model ControllerLicense
type ControllerLicense struct {

	// Number of backend_servers.
	BackendServers int32 `json:"backend_servers,omitempty"`

	// Number of service engine cores in non-container clouds.
	Cores int32 `json:"cores,omitempty"`

	// customer_name of ControllerLicense.
	// Required: true
	CustomerName string `json:"customer_name"`

	// license_tier of ControllerLicense.
	LicenseTier []string `json:"license_tier,omitempty"`

	// Placeholder for description of property licenses of obj type ControllerLicense field type str  type object
	Licenses []*SingleLicense `json:"licenses,omitempty"`

	// Number of max_apps.
	MaxApps int32 `json:"max_apps,omitempty"`

	// Number of service engines hosts in container clouds.
	MaxSes int32 `json:"max_ses,omitempty"`

	// Deprecated.
	MaxVses int32 `json:"max_vses,omitempty"`

	// Name of the object.
	Name string `json:"name,omitempty"`

	// Number of physical cpu sockets across service engines in no access and linux server clouds.
	Sockets int32 `json:"sockets,omitempty"`

	// start_on of ControllerLicense.
	StartOn string `json:"start_on,omitempty"`

	// Number of throughput.
	Throughput int32 `json:"throughput,omitempty"`

	// url
	// Read Only: true
	URL string `json:"url,omitempty"`

	// Unique object identifier of the object.
	UUID string `json:"uuid,omitempty"`

	// valid_until of ControllerLicense.
	// Required: true
	ValidUntil string `json:"valid_until"`
}
