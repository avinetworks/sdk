package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// AzureInfo azure info
// swagger:model AzureInfo
type AzureInfo struct {

	// Name of the availability set of which the VM is a part of.
	AvailabilitySet string `json:"availability_set,omitempty"`

	// Fault domain within the availability set the VM is a part of.
	FaultDomain string `json:"fault_domain,omitempty"`

	// Name of the Azure VM.
	Name string `json:"name,omitempty"`

	// Resource group name for the VM.
	ResourceGroup string `json:"resource_group,omitempty"`

	// Subnet ID of the primary nic of the VM.
	SubnetID string `json:"subnet_id,omitempty"`

	// Update domain within the availability set the VM is a part of.
	UpdateDomain string `json:"update_domain,omitempty"`

	// Azure VM uuid for the se vm.
	VMUUID string `json:"vm_uuid,omitempty"`

	// VNIC id of the primary nic of the VM.
	VnicID string `json:"vnic_id,omitempty"`
}
