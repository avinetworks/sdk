package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// AutoScaleLaunchConfig auto scale launch config
// swagger:model AutoScaleLaunchConfig
type AutoScaleLaunchConfig struct {

	// Placeholder for description of property aws of obj type AutoScaleLaunchConfig field type str  type object
	Aws *AutoScaleAWSSettings `json:"aws,omitempty"`

	// User defined description for the object.
	Description string `json:"description,omitempty"`

	// Unique ID of the Amazon Machine Image (AMI)  or OpenStack VM ID.
	ImageID string `json:"image_id,omitempty"`

	// Placeholder for description of property mesos of obj type AutoScaleLaunchConfig field type str  type object
	Mesos *AutoScaleMesosSettings `json:"mesos,omitempty"`

	// Name of the object.
	// Required: true
	Name string `json:"name"`

	// Placeholder for description of property openstack of obj type AutoScaleLaunchConfig field type str  type object
	Openstack *AutoScaleOpenStackSettings `json:"openstack,omitempty"`

	//  It is a reference to an object of type Tenant.
	TenantRef string `json:"tenant_ref,omitempty"`

	// url
	// Read Only: true
	URL string `json:"url,omitempty"`

	// Unique object identifier of the object.
	UUID string `json:"uuid,omitempty"`
}
