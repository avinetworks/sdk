package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// AutoScaleAWSSettings auto scale a w s settings
// swagger:model AutoScaleAWSSettings
type AutoScaleAWSSettings struct {

	// Name of the AWS autoscaling group. The AWS autoscaling group should not be set up with scaling policies as it would result in unpredictable behavior when used together with Avi autoscaling policies. Field introduced in 17.1.1.
	AutoscalingGroupName string `json:"autoscaling_group_name,omitempty"`
}
