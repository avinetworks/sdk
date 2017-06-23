package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// AwsConfiguration aws configuration
// swagger:model AwsConfiguration
type AwsConfiguration struct {

	// AWS access key ID.
	AccessKeyID string `json:"access_key_id,omitempty"`

	// Free unused elastic IP addresses.
	FreeElasticips bool `json:"free_elasticips,omitempty"`

	// IAM assume role for cross-account access.
	IamAssumeRole string `json:"iam_assume_role,omitempty"`

	// AWS region.
	Region string `json:"region,omitempty"`

	// If enabled, create/update DNS entries in Amazon Route 53 zones.
	Route53Integration bool `json:"route53_integration,omitempty"`

	// AWS secret access key.
	SecretAccessKey string `json:"secret_access_key,omitempty"`

	// Use IAM roles instead of access and secret key.
	UseIamRoles bool `json:"use_iam_roles,omitempty"`

	// VPC name.
	Vpc string `json:"vpc,omitempty"`

	// VPC ID.
	// Required: true
	VpcID string `json:"vpc_id"`

	// Placeholder for description of property zones of obj type AwsConfiguration field type str  type object
	Zones []*AwsZoneConfig `json:"zones,omitempty"`
}
