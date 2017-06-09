package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// GeoLocation geo location
// swagger:model GeoLocation
type GeoLocation struct {

	// Latitude of the location. Field introduced in 17.1.1.
	Latitude float32 `json:"latitude,omitempty"`

	// Longitude of the location. Field introduced in 17.1.1.
	Longitude float32 `json:"longitude,omitempty"`

	// Location name in the format Country/State/City. Field introduced in 17.1.1.
	Name string `json:"name,omitempty"`

	// Location tag string - example  USEast. Field introduced in 17.1.1.
	Tag string `json:"tag,omitempty"`
}
