package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// UpgradeStatusInfo upgrade status info
// swagger:model UpgradeStatusInfo
type UpgradeStatusInfo struct {

	// UNIX time since epoch in microseconds. Units(MICROSECONDS).
	// Read Only: true
	LastModified *string `json:"_last_modified,omitempty"`

	// Duration of upgrade operations in seconds. Field introduced in 18.2.6.
	Duration *int32 `json:"duration,omitempty"`

	// Check if the patch rollback is possible on this node. Field introduced in 18.2.6.
	EnablePatchRollback *bool `json:"enable_patch_rollback,omitempty"`

	// Check if the rollback is possible on this node. Field introduced in 18.2.6.
	EnableRollback *bool `json:"enable_rollback,omitempty"`

	// End time of upgrade operations. Field introduced in 18.2.6.
	EndTime *string `json:"end_time,omitempty"`

	// Enqueue time of upgrade operations. Field introduced in 18.2.6.
	EnqueueTime *string `json:"enqueue_time,omitempty"`

	// Image uuid for identifying the current base image. It is a reference to an object of type Image. Field introduced in 18.2.6.
	ImageRef *string `json:"image_ref,omitempty"`

	// Name of the system such as cluster name, se group name and se name. Field introduced in 18.2.6.
	Name *string `json:"name,omitempty"`

	// Type of the system such as controller_cluster, se_group or se. Enum options - NODE_CONTROLLER_CLUSTER, NODE_SE_GROUP, NODE_SE_TYPE. Field introduced in 18.2.6.
	NodeType *string `json:"node_type,omitempty"`

	// Cloud that this object belongs to. It is a reference to an object of type Cloud. Field introduced in 18.2.6.
	ObjCloudRef *string `json:"obj_cloud_ref,omitempty"`

	// Parameters associated with the current upgrade ops. Field introduced in 18.2.6.
	Params *UpgradeOpsParam `json:"params,omitempty"`

	// Image uuid for identifying the current patch. It is a reference to an object of type Image. Field introduced in 18.2.6.
	PatchImageRef *string `json:"patch_image_ref,omitempty"`

	// Current patch version applied to this node. Field introduced in 18.2.6.
	PatchVersion *string `json:"patch_version,omitempty"`

	// Image uuid for identifying previous base image. It is a reference to an object of type Image. Field introduced in 18.2.6.
	PreviousImageRef *string `json:"previous_image_ref,omitempty"`

	// Image uuid for identifying previous patch. It is a reference to an object of type Image. Field introduced in 18.2.6.
	PreviousPatchImageRef *string `json:"previous_patch_image_ref,omitempty"`

	// Previous patch version applied to this node. Field introduced in 18.2.6.
	PreviousPatchVersion *string `json:"previous_patch_version,omitempty"`

	// Previous version prior to upgrade. Field introduced in 18.2.6.
	PreviousVersion *string `json:"previous_version,omitempty"`

	// ServiceEngineGroup upgrade errors. Field introduced in 18.2.6.
	SeUpgradeEvents []*SeUpgradeEvents `json:"se_upgrade_events,omitempty"`

	// Detailed SeGroup status. Field introduced in 18.2.6.
	SegStatus *SeGroupStatus `json:"seg_status,omitempty"`

	// Start time of upgrade operations. Field introduced in 18.2.6.
	StartTime *string `json:"start_time,omitempty"`

	// Current status of the upgrade operations. Field introduced in 18.2.6.
	State *UpgradeOpsState `json:"state,omitempty"`

	// Flag is set only in the cluster node entry if the upgrade is initiated as a system-upgrade. Field introduced in 18.2.6.
	System *bool `json:"system,omitempty"`

	// Upgrade tasks completed. Field introduced in 18.2.6.
	TasksCompleted *int32 `json:"tasks_completed,omitempty"`

	// Tenant that this object belongs to. It is a reference to an object of type Tenant. Field introduced in 18.2.6.
	TenantRef *string `json:"tenant_ref,omitempty"`

	// Total upgrade tasks. Field introduced in 18.2.6.
	TotalTasks *int32 `json:"total_tasks,omitempty"`

	// Events performed for upgrade operations. Field introduced in 18.2.6.
	UpgradeEvents []*EventMap `json:"upgrade_events,omitempty"`

	// Upgrade operations requested. Enum options - UPGRADE, PATCH, ROLLBACK, ROLLBACKPATCH, SEGROUP_RESUME. Field introduced in 18.2.6.
	UpgradeOps *string `json:"upgrade_ops,omitempty"`

	// url
	// Read Only: true
	URL *string `json:"url,omitempty"`

	// UUID Identifier for the system such as cluster, se group and se. Field introduced in 18.2.6.
	UUID *string `json:"uuid,omitempty"`

	// Current base image applied to this node. Field introduced in 18.2.6.
	Version *string `json:"version,omitempty"`
}
