package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// AlertEmailConfig alert email config
// swagger:model AlertEmailConfig
type AlertEmailConfig struct {

	// Alerts are copied to the comma separated list of  email recipients.
	CcEmails string `json:"cc_emails,omitempty"`

	// User defined description for the object.
	Description string `json:"description,omitempty"`

	// A user-friendly name of the email notification service.
	// Required: true
	Name string `json:"name"`

	//  It is a reference to an object of type Tenant.
	TenantRef string `json:"tenant_ref,omitempty"`

	// Alerts are sent to the comma separated list of  email recipients.
	// Required: true
	ToEmails string `json:"to_emails"`

	// url
	// Read Only: true
	URL string `json:"url,omitempty"`

	// Unique object identifier of the object.
	UUID string `json:"uuid,omitempty"`
}
