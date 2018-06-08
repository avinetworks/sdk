package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// VipAutoscaleZones vip autoscale zones
// swagger:model VipAutoscaleZones
type VipAutoscaleZones struct {

	//  Field introduced in 18.1.2.
	AvailabilityZone string `json:"availability_zone,omitempty"`

	//  Field introduced in 18.1.2.
	SubnetUuids []string `json:"subnet_uuids,omitempty"`
}
