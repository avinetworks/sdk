package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The UpgradeStatusSummary is a POJO class extends AviRestResource that used for creating
 * UpgradeStatusSummary.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpgradeStatusSummary extends AviRestResource  {
    @JsonProperty("enable_patch_rollback")
    private Boolean enablePatchRollback = false;

    @JsonProperty("enable_rollback")
    private Boolean enableRollback = false;

    @JsonProperty("end_time")
    private String endTime = null;

    @JsonProperty("image_ref")
    private String imageRef = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("node_type")
    private String nodeType = null;

    @JsonProperty("obj_cloud_ref")
    private String objCloudRef = null;

    @JsonProperty("patch_image_ref")
    private String patchImageRef = null;

    @JsonProperty("start_time")
    private String startTime = null;

    @JsonProperty("state")
    private UpgradeOpsState state = null;

    @JsonProperty("tasks_completed")
    private Integer tasksCompleted = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("total_tasks")
    private Integer totalTasks = null;

    @JsonProperty("upgrade_ops")
    private String upgradeOps = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("version")
    private String version = null;



  /**
   * This is the getter method this will return the attribute value.
   * Check if the patch rollback is possible on this node.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enablePatchRollback
   */
  public Boolean getEnablePatchRollback() {
    return enablePatchRollback;
  }

  /**
   * This is the setter method to the attribute.
   * Check if the patch rollback is possible on this node.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enablePatchRollback set the enablePatchRollback.
   */
  public void setEnablePatchRollback(Boolean  enablePatchRollback) {
    this.enablePatchRollback = enablePatchRollback;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Check if the rollback is possible on this node.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableRollback
   */
  public Boolean getEnableRollback() {
    return enableRollback;
  }

  /**
   * This is the setter method to the attribute.
   * Check if the rollback is possible on this node.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableRollback set the enableRollback.
   */
  public void setEnableRollback(Boolean  enableRollback) {
    this.enableRollback = enableRollback;
  }

  /**
   * This is the getter method this will return the attribute value.
   * End time of upgrade operations.
   * Field introduced in 18.2.6.
   * @return endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * This is the setter method to the attribute.
   * End time of upgrade operations.
   * Field introduced in 18.2.6.
   * @param endTime set the endTime.
   */
  public void setEndTime(String  endTime) {
    this.endTime = endTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Image uuid for identifying the current base image.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @return imageRef
   */
  public String getImageRef() {
    return imageRef;
  }

  /**
   * This is the setter method to the attribute.
   * Image uuid for identifying the current base image.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @param imageRef set the imageRef.
   */
  public void setImageRef(String  imageRef) {
    this.imageRef = imageRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the system such as cluster name, se group name and se name.
   * Field introduced in 18.2.6.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the system such as cluster name, se group name and se name.
   * Field introduced in 18.2.6.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Type of the system such as controller_cluster, se_group or se.
   * Enum options - NODE_CONTROLLER_CLUSTER, NODE_SE_GROUP, NODE_SE_TYPE.
   * Field introduced in 18.2.6.
   * @return nodeType
   */
  public String getNodeType() {
    return nodeType;
  }

  /**
   * This is the setter method to the attribute.
   * Type of the system such as controller_cluster, se_group or se.
   * Enum options - NODE_CONTROLLER_CLUSTER, NODE_SE_GROUP, NODE_SE_TYPE.
   * Field introduced in 18.2.6.
   * @param nodeType set the nodeType.
   */
  public void setNodeType(String  nodeType) {
    this.nodeType = nodeType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Cloud that this object belongs to.
   * It is a reference to an object of type cloud.
   * Field introduced in 18.2.6.
   * @return objCloudRef
   */
  public String getObjCloudRef() {
    return objCloudRef;
  }

  /**
   * This is the setter method to the attribute.
   * Cloud that this object belongs to.
   * It is a reference to an object of type cloud.
   * Field introduced in 18.2.6.
   * @param objCloudRef set the objCloudRef.
   */
  public void setObjCloudRef(String  objCloudRef) {
    this.objCloudRef = objCloudRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Image uuid for identifying the current patch.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @return patchImageRef
   */
  public String getPatchImageRef() {
    return patchImageRef;
  }

  /**
   * This is the setter method to the attribute.
   * Image uuid for identifying the current patch.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @param patchImageRef set the patchImageRef.
   */
  public void setPatchImageRef(String  patchImageRef) {
    this.patchImageRef = patchImageRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Start time of upgrade operations.
   * Field introduced in 18.2.6.
   * @return startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * This is the setter method to the attribute.
   * Start time of upgrade operations.
   * Field introduced in 18.2.6.
   * @param startTime set the startTime.
   */
  public void setStartTime(String  startTime) {
    this.startTime = startTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Current status of the upgrade operations.
   * Field introduced in 18.2.6.
   * @return state
   */
  public UpgradeOpsState getState() {
    return state;
  }

  /**
   * This is the setter method to the attribute.
   * Current status of the upgrade operations.
   * Field introduced in 18.2.6.
   * @param state set the state.
   */
  public void setState(UpgradeOpsState state) {
    this.state = state;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Upgrade tasks completed.
   * Field introduced in 18.2.6.
   * @return tasksCompleted
   */
  public Integer getTasksCompleted() {
    return tasksCompleted;
  }

  /**
   * This is the setter method to the attribute.
   * Upgrade tasks completed.
   * Field introduced in 18.2.6.
   * @param tasksCompleted set the tasksCompleted.
   */
  public void setTasksCompleted(Integer  tasksCompleted) {
    this.tasksCompleted = tasksCompleted;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.6.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.6.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total upgrade tasks.
   * Field introduced in 18.2.6.
   * @return totalTasks
   */
  public Integer getTotalTasks() {
    return totalTasks;
  }

  /**
   * This is the setter method to the attribute.
   * Total upgrade tasks.
   * Field introduced in 18.2.6.
   * @param totalTasks set the totalTasks.
   */
  public void setTotalTasks(Integer  totalTasks) {
    this.totalTasks = totalTasks;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Upgrade operations requested.
   * Enum options - UPGRADE, PATCH, ROLLBACK, ROLLBACKPATCH, SEGROUP_RESUME.
   * Field introduced in 18.2.6.
   * @return upgradeOps
   */
  public String getUpgradeOps() {
    return upgradeOps;
  }

  /**
   * This is the setter method to the attribute.
   * Upgrade operations requested.
   * Enum options - UPGRADE, PATCH, ROLLBACK, ROLLBACKPATCH, SEGROUP_RESUME.
   * Field introduced in 18.2.6.
   * @param upgradeOps set the upgradeOps.
   */
  public void setUpgradeOps(String  upgradeOps) {
    this.upgradeOps = upgradeOps;
  }
/**
   * This is the getter method this will return the attribute value.
   * Avi controller URL of the object.
   * @return url
   */
  public String getUrl() {
    return url;
  }

  /**
   * This is the setter method. this will set the url
   * Avi controller URL of the object.
   * @return url
   */
  public void setUrl(String  url) {
    this.url = url;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid identifier for the system such as cluster, se group and se.
   * Field introduced in 18.2.6.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid identifier for the system such as cluster, se group and se.
   * Field introduced in 18.2.6.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Current base image applied to this node.
   * Field introduced in 18.2.6.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Current base image applied to this node.
   * Field introduced in 18.2.6.
   * @param version set the version.
   */
  public void setVersion(String  version) {
    this.version = version;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  UpgradeStatusSummary objUpgradeStatusSummary = (UpgradeStatusSummary) o;
  return   Objects.equals(this.enableRollback, objUpgradeStatusSummary.enableRollback)&&
  Objects.equals(this.uuid, objUpgradeStatusSummary.uuid)&&
  Objects.equals(this.objCloudRef, objUpgradeStatusSummary.objCloudRef)&&
  Objects.equals(this.startTime, objUpgradeStatusSummary.startTime)&&
  Objects.equals(this.state, objUpgradeStatusSummary.state)&&
  Objects.equals(this.upgradeOps, objUpgradeStatusSummary.upgradeOps)&&
  Objects.equals(this.enablePatchRollback, objUpgradeStatusSummary.enablePatchRollback)&&
  Objects.equals(this.nodeType, objUpgradeStatusSummary.nodeType)&&
  Objects.equals(this.version, objUpgradeStatusSummary.version)&&
  Objects.equals(this.endTime, objUpgradeStatusSummary.endTime)&&
  Objects.equals(this.patchImageRef, objUpgradeStatusSummary.patchImageRef)&&
  Objects.equals(this.imageRef, objUpgradeStatusSummary.imageRef)&&
  Objects.equals(this.tasksCompleted, objUpgradeStatusSummary.tasksCompleted)&&
  Objects.equals(this.tenantRef, objUpgradeStatusSummary.tenantRef)&&
  Objects.equals(this.totalTasks, objUpgradeStatusSummary.totalTasks)&&
  Objects.equals(this.name, objUpgradeStatusSummary.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class UpgradeStatusSummary {\n");
      sb.append("    enablePatchRollback: ").append(toIndentedString(enablePatchRollback)).append("\n");
        sb.append("    enableRollback: ").append(toIndentedString(enableRollback)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    imageRef: ").append(toIndentedString(imageRef)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
        sb.append("    objCloudRef: ").append(toIndentedString(objCloudRef)).append("\n");
        sb.append("    patchImageRef: ").append(toIndentedString(patchImageRef)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    tasksCompleted: ").append(toIndentedString(tasksCompleted)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    totalTasks: ").append(toIndentedString(totalTasks)).append("\n");
        sb.append("    upgradeOps: ").append(toIndentedString(upgradeOps)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
      sb.append("}");
  return sb.toString();
}

/**
* Convert the given object to string with each line indented by 4 spaces
* (except the first line).
*/
private String toIndentedString(java.lang.Object o) {
  if (o == null) {
    return "null";
  }
  return o.toString().replace("\n", "\n    ");
}
}

