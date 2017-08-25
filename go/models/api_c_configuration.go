package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// APICConfiguration API c configuration
// swagger:model APICConfiguration
type APICConfiguration struct {

	// Name of the Avi specific tenant created within APIC.
	ApicAdminTenant string `json:"apic_admin_tenant,omitempty"`

	// vCenter's virtual machine manager domain within APIC.
	ApicDomain string `json:"apic_domain,omitempty"`

	// The hostname or IP address of the APIC controller.
	ApicName []string `json:"apic_name,omitempty"`

	// The password Avi Vantage will use when authenticating with APIC.
	ApicPassword string `json:"apic_password,omitempty"`

	// apic_product of APICConfiguration.
	ApicProduct string `json:"apic_product,omitempty"`

	// The username Avi Vantage will use when authenticating with APIC.
	ApicUsername string `json:"apic_username,omitempty"`

	// apic_vendor of APICConfiguration.
	ApicVendor string `json:"apic_vendor,omitempty"`

	// The password APIC will use when authenticating with Avi Vantage.
	AviControllerPassword string `json:"avi_controller_password,omitempty"`

	// The username APIC will use when authenticating with Avi Vantage.
	AviControllerUsername string `json:"avi_controller_username,omitempty"`

	// Context aware for supporting Service Graphs across VRFs. Enum options - SINGLE_CONTEXT, MULTI_CONTEXT.
	ContextAware string `json:"context_aware,omitempty"`

	// deployment of APICConfiguration.
	Deployment string `json:"deployment,omitempty"`

	// Use Managed Mode for APIC Service Insertion. Field introduced in 17.1.1.
	ManagedMode bool `json:"managed_mode,omitempty"`

	// AVI Device Package Minor Version.
	Minor string `json:"minor,omitempty"`

	// AVI Device Package Version.
	Version string `json:"version,omitempty"`
}
