package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The UpgradeStatusInfo is a POJO class extends AviRestResource that used for creating
 * UpgradeStatusInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpgradeStatusInfo extends AviRestResource  {
    @JsonProperty("after_reboot_rollback_fnc")
    private String afterRebootRollbackFnc = null;

    @JsonProperty("after_reboot_task_name")
    private String afterRebootTaskName = null;

    @JsonProperty("clean")
    private Boolean clean = null;

    @JsonProperty("duration")
    private Integer duration = null;

    @JsonProperty("enable_patch_rollback")
    private Boolean enablePatchRollback = false;

    @JsonProperty("enable_rollback")
    private Boolean enableRollback = false;

    @JsonProperty("end_time")
    private String endTime = null;

    @JsonProperty("enqueue_time")
    private String enqueueTime = null;

    @JsonProperty("history")
    private List<OpsHistory> history = null;

    @JsonProperty("image_path")
    private String imagePath = null;

    @JsonProperty("image_ref")
    private String imageRef = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("node_type")
    private String nodeType = null;

    @JsonProperty("obj_cloud_ref")
    private String objCloudRef = null;

    @JsonProperty("params")
    private UpgradeOpsParam params = null;

    @JsonProperty("patch_image_path")
    private String patchImagePath = null;

    @JsonProperty("patch_image_ref")
    private String patchImageRef = null;

    @JsonProperty("patch_list")
    private List<PatchData> patchList = null;

    @JsonProperty("patch_reboot")
    private Boolean patchReboot = null;

    @JsonProperty("patch_version")
    private String patchVersion = null;

    @JsonProperty("prev_image_path")
    private String prevImagePath = null;

    @JsonProperty("prev_patch_image_path")
    private String prevPatchImagePath = null;

    @JsonProperty("previous_image_ref")
    private String previousImageRef = null;

    @JsonProperty("previous_patch_image_ref")
    private String previousPatchImageRef = null;

    @JsonProperty("previous_patch_list")
    private List<PatchData> previousPatchList = null;

    @JsonProperty("previous_patch_version")
    private String previousPatchVersion = null;

    @JsonProperty("previous_version")
    private String previousVersion = null;

    @JsonProperty("progress")
    private Integer progress = 0;

    @JsonProperty("se_patch_image_path")
    private String sePatchImagePath = null;

    @JsonProperty("se_patch_image_ref")
    private String sePatchImageRef = null;

    @JsonProperty("se_upgrade_events")
    private List<SeUpgradeEvents> seUpgradeEvents = null;

    @JsonProperty("seg_params")
    private UpgradeOpsParam segParams = null;

    @JsonProperty("seg_status")
    private SeGroupStatus segStatus = null;

    @JsonProperty("start_time")
    private String startTime = null;

    @JsonProperty("state")
    private UpgradeOpsState state = null;

    @JsonProperty("system")
    private Boolean system = null;

    @JsonProperty("tasks_completed")
    private Integer tasksCompleted = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("total_tasks")
    private Integer totalTasks = null;

    @JsonProperty("upgrade_events")
    private List<EventMap> upgradeEvents = null;

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
     * Backward compatible abort function name.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return afterRebootRollbackFnc
     */
    public String getAfterRebootRollbackFnc() {
        return afterRebootRollbackFnc;
    }

    /**
     * This is the setter method to the attribute.
     * Backward compatible abort function name.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param afterRebootRollbackFnc set the afterRebootRollbackFnc.
     */
    public void setAfterRebootRollbackFnc(String  afterRebootRollbackFnc) {
        this.afterRebootRollbackFnc = afterRebootRollbackFnc;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Backward compatible task dict name.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return afterRebootTaskName
     */
    public String getAfterRebootTaskName() {
        return afterRebootTaskName;
    }

    /**
     * This is the setter method to the attribute.
     * Backward compatible task dict name.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param afterRebootTaskName set the afterRebootTaskName.
     */
    public void setAfterRebootTaskName(String  afterRebootTaskName) {
        this.afterRebootTaskName = afterRebootTaskName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Flag for clean installation.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return clean
     */
    public Boolean getClean() {
        return clean;
    }

    /**
     * This is the setter method to the attribute.
     * Flag for clean installation.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param clean set the clean.
     */
    public void setClean(Boolean  clean) {
        this.clean = clean;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Duration of upgrade operation in seconds.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * This is the setter method to the attribute.
     * Duration of upgrade operation in seconds.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param duration set the duration.
     */
    public void setDuration(Integer  duration) {
        this.duration = duration;
    }

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
     * End time of upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * This is the setter method to the attribute.
     * End time of upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param endTime set the endTime.
     */
    public void setEndTime(String  endTime) {
        this.endTime = endTime;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enqueue time of upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return enqueueTime
     */
    public String getEnqueueTime() {
        return enqueueTime;
    }

    /**
     * This is the setter method to the attribute.
     * Enqueue time of upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param enqueueTime set the enqueueTime.
     */
    public void setEnqueueTime(String  enqueueTime) {
        this.enqueueTime = enqueueTime;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Record of past operations on this node.
     * Field introduced in 20.1.4.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return history
     */
    public List<OpsHistory> getHistory() {
        return history;
    }

    /**
     * This is the setter method. this will set the history
     * Record of past operations on this node.
     * Field introduced in 20.1.4.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return history
     */
    public void setHistory(List<OpsHistory>  history) {
        this.history = history;
    }

    /**
     * This is the setter method this will set the history
     * Record of past operations on this node.
     * Field introduced in 20.1.4.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return history
     */
    public UpgradeStatusInfo addHistoryItem(OpsHistory historyItem) {
      if (this.history == null) {
        this.history = new ArrayList<OpsHistory>();
      }
      this.history.add(historyItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Image path of current base image.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * This is the setter method to the attribute.
     * Image path of current base image.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param imagePath set the imagePath.
     */
    public void setImagePath(String  imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Image uuid for identifying the current base image.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param imageRef set the imageRef.
     */
    public void setImageRef(String  imageRef) {
        this.imageRef = imageRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the system such as cluster name, se group name and se name.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the system such as cluster name, se group name and se name.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param objCloudRef set the objCloudRef.
     */
    public void setObjCloudRef(String  objCloudRef) {
        this.objCloudRef = objCloudRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Parameters associated with the upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return params
     */
    public UpgradeOpsParam getParams() {
        return params;
    }

    /**
     * This is the setter method to the attribute.
     * Parameters associated with the upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param params set the params.
     */
    public void setParams(UpgradeOpsParam params) {
        this.params = params;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Image path of current patch image.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return patchImagePath
     */
    public String getPatchImagePath() {
        return patchImagePath;
    }

    /**
     * This is the setter method to the attribute.
     * Image path of current patch image.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param patchImagePath set the patchImagePath.
     */
    public void setPatchImagePath(String  patchImagePath) {
        this.patchImagePath = patchImagePath;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Image uuid for identifying the current patch.example  base-image is 18.2.6 and a patch 6p1 is applied, then this field will indicate the 6p1
     * value.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return patchImageRef
     */
    public String getPatchImageRef() {
        return patchImageRef;
    }

    /**
     * This is the setter method to the attribute.
     * Image uuid for identifying the current patch.example  base-image is 18.2.6 and a patch 6p1 is applied, then this field will indicate the 6p1
     * value.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param patchImageRef set the patchImageRef.
     */
    public void setPatchImageRef(String  patchImageRef) {
        this.patchImageRef = patchImageRef;
    }
    /**
     * This is the getter method this will return the attribute value.
     * List of patches applied to this node.
     * Example  base-image is 18.2.6 and a patch 6p1 is applied, then a patch 6p5 applied, this field will indicate the [{'6p1', '6p1_image_uuid'},
     * {'6p5', '6p5_image_uuid'}] value.
     * Field introduced in 18.2.8, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return patchList
     */
    public List<PatchData> getPatchList() {
        return patchList;
    }

    /**
     * This is the setter method. this will set the patchList
     * List of patches applied to this node.
     * Example  base-image is 18.2.6 and a patch 6p1 is applied, then a patch 6p5 applied, this field will indicate the [{'6p1', '6p1_image_uuid'},
     * {'6p5', '6p5_image_uuid'}] value.
     * Field introduced in 18.2.8, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return patchList
     */
    public void setPatchList(List<PatchData>  patchList) {
        this.patchList = patchList;
    }

    /**
     * This is the setter method this will set the patchList
     * List of patches applied to this node.
     * Example  base-image is 18.2.6 and a patch 6p1 is applied, then a patch 6p5 applied, this field will indicate the [{'6p1', '6p1_image_uuid'},
     * {'6p5', '6p5_image_uuid'}] value.
     * Field introduced in 18.2.8, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return patchList
     */
    public UpgradeStatusInfo addPatchListItem(PatchData patchListItem) {
      if (this.patchList == null) {
        this.patchList = new ArrayList<PatchData>();
      }
      this.patchList.add(patchListItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Flag for patch op with reboot.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return patchReboot
     */
    public Boolean getPatchReboot() {
        return patchReboot;
    }

    /**
     * This is the setter method to the attribute.
     * Flag for patch op with reboot.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param patchReboot set the patchReboot.
     */
    public void setPatchReboot(Boolean  patchReboot) {
        this.patchReboot = patchReboot;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Current patch version applied to this node.
     * Example  base-image is 18.2.6 and a patch 6p1 is applied, then this field will indicate the 6p1 value.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return patchVersion
     */
    public String getPatchVersion() {
        return patchVersion;
    }

    /**
     * This is the setter method to the attribute.
     * Current patch version applied to this node.
     * Example  base-image is 18.2.6 and a patch 6p1 is applied, then this field will indicate the 6p1 value.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param patchVersion set the patchVersion.
     */
    public void setPatchVersion(String  patchVersion) {
        this.patchVersion = patchVersion;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Image path of previous base image.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return prevImagePath
     */
    public String getPrevImagePath() {
        return prevImagePath;
    }

    /**
     * This is the setter method to the attribute.
     * Image path of previous base image.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param prevImagePath set the prevImagePath.
     */
    public void setPrevImagePath(String  prevImagePath) {
        this.prevImagePath = prevImagePath;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Image path of previous patch image.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return prevPatchImagePath
     */
    public String getPrevPatchImagePath() {
        return prevPatchImagePath;
    }

    /**
     * This is the setter method to the attribute.
     * Image path of previous patch image.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param prevPatchImagePath set the prevPatchImagePath.
     */
    public void setPrevPatchImagePath(String  prevPatchImagePath) {
        this.prevPatchImagePath = prevPatchImagePath;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Image uuid for identifying previous base image.example  base-image was 18.2.5 and an upgrade was done to 18.2.6, then this field will indicate
     * the 18.2.5 value.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return previousImageRef
     */
    public String getPreviousImageRef() {
        return previousImageRef;
    }

    /**
     * This is the setter method to the attribute.
     * Image uuid for identifying previous base image.example  base-image was 18.2.5 and an upgrade was done to 18.2.6, then this field will indicate
     * the 18.2.5 value.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param previousImageRef set the previousImageRef.
     */
    public void setPreviousImageRef(String  previousImageRef) {
        this.previousImageRef = previousImageRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Image uuid for identifying previous patch.example  base-image was 18.2.6 with a patch 6p1.
     * Upgrade was initiated to 18.2.8 with patch 8p1.
     * The previous_image field will contain 18.2.6 and this field will indicate the 6p1 value.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return previousPatchImageRef
     */
    public String getPreviousPatchImageRef() {
        return previousPatchImageRef;
    }

    /**
     * This is the setter method to the attribute.
     * Image uuid for identifying previous patch.example  base-image was 18.2.6 with a patch 6p1.
     * Upgrade was initiated to 18.2.8 with patch 8p1.
     * The previous_image field will contain 18.2.6 and this field will indicate the 6p1 value.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param previousPatchImageRef set the previousPatchImageRef.
     */
    public void setPreviousPatchImageRef(String  previousPatchImageRef) {
        this.previousPatchImageRef = previousPatchImageRef;
    }
    /**
     * This is the getter method this will return the attribute value.
     * List of patches applied to this node on previous major version.
     * Field introduced in 18.2.8, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return previousPatchList
     */
    public List<PatchData> getPreviousPatchList() {
        return previousPatchList;
    }

    /**
     * This is the setter method. this will set the previousPatchList
     * List of patches applied to this node on previous major version.
     * Field introduced in 18.2.8, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return previousPatchList
     */
    public void setPreviousPatchList(List<PatchData>  previousPatchList) {
        this.previousPatchList = previousPatchList;
    }

    /**
     * This is the setter method this will set the previousPatchList
     * List of patches applied to this node on previous major version.
     * Field introduced in 18.2.8, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return previousPatchList
     */
    public UpgradeStatusInfo addPreviousPatchListItem(PatchData previousPatchListItem) {
      if (this.previousPatchList == null) {
        this.previousPatchList = new ArrayList<PatchData>();
      }
      this.previousPatchList.add(previousPatchListItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Previous patch version applied to this node.example  base-image was 18.2.6 with a patch 6p1.
     * Upgrade was initiated to 18.2.8 with patch 8p1.
     * The previous_image field will contain 18.2.6 and this field will indicate the 6p1 value.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return previousPatchVersion
     */
    public String getPreviousPatchVersion() {
        return previousPatchVersion;
    }

    /**
     * This is the setter method to the attribute.
     * Previous patch version applied to this node.example  base-image was 18.2.6 with a patch 6p1.
     * Upgrade was initiated to 18.2.8 with patch 8p1.
     * The previous_image field will contain 18.2.6 and this field will indicate the 6p1 value.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param previousPatchVersion set the previousPatchVersion.
     */
    public void setPreviousPatchVersion(String  previousPatchVersion) {
        this.previousPatchVersion = previousPatchVersion;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Previous version prior to upgrade.example  base-image was 18.2.5 and an upgrade was done to 18.2.6, then this field will indicate the 18.2.5
     * value.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return previousVersion
     */
    public String getPreviousVersion() {
        return previousVersion;
    }

    /**
     * This is the setter method to the attribute.
     * Previous version prior to upgrade.example  base-image was 18.2.5 and an upgrade was done to 18.2.6, then this field will indicate the 18.2.5
     * value.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param previousVersion set the previousVersion.
     */
    public void setPreviousVersion(String  previousVersion) {
        this.previousVersion = previousVersion;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Upgrade operations progress which holds value between 0-100.
     * Allowed values are 0-100.
     * Field introduced in 18.2.8, 20.1.1.
     * Unit is percent.
     * Default value when not specified in API or module is interpreted by Avi Controller as 0.
     * @return progress
     */
    public Integer getProgress() {
        return progress;
    }

    /**
     * This is the setter method to the attribute.
     * Upgrade operations progress which holds value between 0-100.
     * Allowed values are 0-100.
     * Field introduced in 18.2.8, 20.1.1.
     * Unit is percent.
     * Default value when not specified in API or module is interpreted by Avi Controller as 0.
     * @param progress set the progress.
     */
    public void setProgress(Integer  progress) {
        this.progress = progress;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Image path of se patch image.(required in case of reimage and upgrade + patch).
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return sePatchImagePath
     */
    public String getSePatchImagePath() {
        return sePatchImagePath;
    }

    /**
     * This is the setter method to the attribute.
     * Image path of se patch image.(required in case of reimage and upgrade + patch).
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param sePatchImagePath set the sePatchImagePath.
     */
    public void setSePatchImagePath(String  sePatchImagePath) {
        this.sePatchImagePath = sePatchImagePath;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Image uuid for identifying the current se patch required in case of system upgrade(re-image) with se patch.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return sePatchImageRef
     */
    public String getSePatchImageRef() {
        return sePatchImageRef;
    }

    /**
     * This is the setter method to the attribute.
     * Image uuid for identifying the current se patch required in case of system upgrade(re-image) with se patch.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param sePatchImageRef set the sePatchImageRef.
     */
    public void setSePatchImageRef(String  sePatchImageRef) {
        this.sePatchImageRef = sePatchImageRef;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Serviceenginegroup upgrade errors.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seUpgradeEvents
     */
    public List<SeUpgradeEvents> getSeUpgradeEvents() {
        return seUpgradeEvents;
    }

    /**
     * This is the setter method. this will set the seUpgradeEvents
     * Serviceenginegroup upgrade errors.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seUpgradeEvents
     */
    public void setSeUpgradeEvents(List<SeUpgradeEvents>  seUpgradeEvents) {
        this.seUpgradeEvents = seUpgradeEvents;
    }

    /**
     * This is the setter method this will set the seUpgradeEvents
     * Serviceenginegroup upgrade errors.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seUpgradeEvents
     */
    public UpgradeStatusInfo addSeUpgradeEventsItem(SeUpgradeEvents seUpgradeEventsItem) {
      if (this.seUpgradeEvents == null) {
        this.seUpgradeEvents = new ArrayList<SeUpgradeEvents>();
      }
      this.seUpgradeEvents.add(seUpgradeEventsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Se_patch may be different from the controller_patch.
     * It has to be saved in the journal for subsequent consumption.
     * The segroup params will be saved in the controller entry as seg_params.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return segParams
     */
    public UpgradeOpsParam getSegParams() {
        return segParams;
    }

    /**
     * This is the setter method to the attribute.
     * Se_patch may be different from the controller_patch.
     * It has to be saved in the journal for subsequent consumption.
     * The segroup params will be saved in the controller entry as seg_params.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param segParams set the segParams.
     */
    public void setSegParams(UpgradeOpsParam segParams) {
        this.segParams = segParams;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Detailed segroup status.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return segStatus
     */
    public SeGroupStatus getSegStatus() {
        return segStatus;
    }

    /**
     * This is the setter method to the attribute.
     * Detailed segroup status.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param segStatus set the segStatus.
     */
    public void setSegStatus(SeGroupStatus segStatus) {
        this.segStatus = segStatus;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Start time of upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * This is the setter method to the attribute.
     * Start time of upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param startTime set the startTime.
     */
    public void setStartTime(String  startTime) {
        this.startTime = startTime;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Current status of the upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return state
     */
    public UpgradeOpsState getState() {
        return state;
    }

    /**
     * This is the setter method to the attribute.
     * Current status of the upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param state set the state.
     */
    public void setState(UpgradeOpsState state) {
        this.state = state;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Flag is set only in the cluster if the upgrade is initiated as a system-upgrade.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return system
     */
    public Boolean getSystem() {
        return system;
    }

    /**
     * This is the setter method to the attribute.
     * Flag is set only in the cluster if the upgrade is initiated as a system-upgrade.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param system set the system.
     */
    public void setSystem(Boolean  system) {
        this.system = system;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Completed set of tasks in the upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tasksCompleted
     */
    public Integer getTasksCompleted() {
        return tasksCompleted;
    }

    /**
     * This is the setter method to the attribute.
     * Completed set of tasks in the upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param tenantRef set the tenantRef.
     */
    public void setTenantRef(String  tenantRef) {
        this.tenantRef = tenantRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Total number of tasks in the upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return totalTasks
     */
    public Integer getTotalTasks() {
        return totalTasks;
    }

    /**
     * This is the setter method to the attribute.
     * Total number of tasks in the upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param totalTasks set the totalTasks.
     */
    public void setTotalTasks(Integer  totalTasks) {
        this.totalTasks = totalTasks;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Events performed for upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return upgradeEvents
     */
    public List<EventMap> getUpgradeEvents() {
        return upgradeEvents;
    }

    /**
     * This is the setter method. this will set the upgradeEvents
     * Events performed for upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return upgradeEvents
     */
    public void setUpgradeEvents(List<EventMap>  upgradeEvents) {
        this.upgradeEvents = upgradeEvents;
    }

    /**
     * This is the setter method this will set the upgradeEvents
     * Events performed for upgrade operation.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return upgradeEvents
     */
    public UpgradeStatusInfo addUpgradeEventsItem(EventMap upgradeEventsItem) {
      if (this.upgradeEvents == null) {
        this.upgradeEvents = new ArrayList<EventMap>();
      }
      this.upgradeEvents.add(upgradeEventsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Upgrade operations requested.
     * Enum options - UPGRADE, PATCH, ROLLBACK, ROLLBACKPATCH, SEGROUP_RESUME.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid identifier for the system such as cluster, se group and se.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param uuid set the uuid.
     */
    public void setUuid(String  uuid) {
        this.uuid = uuid;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Current base image applied to this node.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /**
     * This is the setter method to the attribute.
     * Current base image applied to this node.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
      UpgradeStatusInfo objUpgradeStatusInfo = (UpgradeStatusInfo) o;
      return   Objects.equals(this.uuid, objUpgradeStatusInfo.uuid)&&
  Objects.equals(this.name, objUpgradeStatusInfo.name)&&
  Objects.equals(this.nodeType, objUpgradeStatusInfo.nodeType)&&
  Objects.equals(this.upgradeOps, objUpgradeStatusInfo.upgradeOps)&&
  Objects.equals(this.version, objUpgradeStatusInfo.version)&&
  Objects.equals(this.imageRef, objUpgradeStatusInfo.imageRef)&&
  Objects.equals(this.patchVersion, objUpgradeStatusInfo.patchVersion)&&
  Objects.equals(this.patchImageRef, objUpgradeStatusInfo.patchImageRef)&&
  Objects.equals(this.previousVersion, objUpgradeStatusInfo.previousVersion)&&
  Objects.equals(this.previousImageRef, objUpgradeStatusInfo.previousImageRef)&&
  Objects.equals(this.previousPatchVersion, objUpgradeStatusInfo.previousPatchVersion)&&
  Objects.equals(this.previousPatchImageRef, objUpgradeStatusInfo.previousPatchImageRef)&&
  Objects.equals(this.state, objUpgradeStatusInfo.state)&&
  Objects.equals(this.params, objUpgradeStatusInfo.params)&&
  Objects.equals(this.upgradeEvents, objUpgradeStatusInfo.upgradeEvents)&&
  Objects.equals(this.segStatus, objUpgradeStatusInfo.segStatus)&&
  Objects.equals(this.startTime, objUpgradeStatusInfo.startTime)&&
  Objects.equals(this.endTime, objUpgradeStatusInfo.endTime)&&
  Objects.equals(this.duration, objUpgradeStatusInfo.duration)&&
  Objects.equals(this.enqueueTime, objUpgradeStatusInfo.enqueueTime)&&
  Objects.equals(this.enableRollback, objUpgradeStatusInfo.enableRollback)&&
  Objects.equals(this.enablePatchRollback, objUpgradeStatusInfo.enablePatchRollback)&&
  Objects.equals(this.totalTasks, objUpgradeStatusInfo.totalTasks)&&
  Objects.equals(this.tasksCompleted, objUpgradeStatusInfo.tasksCompleted)&&
  Objects.equals(this.system, objUpgradeStatusInfo.system)&&
  Objects.equals(this.progress, objUpgradeStatusInfo.progress)&&
  Objects.equals(this.patchList, objUpgradeStatusInfo.patchList)&&
  Objects.equals(this.previousPatchList, objUpgradeStatusInfo.previousPatchList)&&
  Objects.equals(this.clean, objUpgradeStatusInfo.clean)&&
  Objects.equals(this.sePatchImageRef, objUpgradeStatusInfo.sePatchImageRef)&&
  Objects.equals(this.imagePath, objUpgradeStatusInfo.imagePath)&&
  Objects.equals(this.patchImagePath, objUpgradeStatusInfo.patchImagePath)&&
  Objects.equals(this.sePatchImagePath, objUpgradeStatusInfo.sePatchImagePath)&&
  Objects.equals(this.prevImagePath, objUpgradeStatusInfo.prevImagePath)&&
  Objects.equals(this.prevPatchImagePath, objUpgradeStatusInfo.prevPatchImagePath)&&
  Objects.equals(this.segParams, objUpgradeStatusInfo.segParams)&&
  Objects.equals(this.patchReboot, objUpgradeStatusInfo.patchReboot)&&
  Objects.equals(this.afterRebootTaskName, objUpgradeStatusInfo.afterRebootTaskName)&&
  Objects.equals(this.afterRebootRollbackFnc, objUpgradeStatusInfo.afterRebootRollbackFnc)&&
  Objects.equals(this.tenantRef, objUpgradeStatusInfo.tenantRef)&&
  Objects.equals(this.objCloudRef, objUpgradeStatusInfo.objCloudRef)&&
  Objects.equals(this.seUpgradeEvents, objUpgradeStatusInfo.seUpgradeEvents)&&
  Objects.equals(this.history, objUpgradeStatusInfo.history);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class UpgradeStatusInfo {\n");
                  sb.append("    afterRebootRollbackFnc: ").append(toIndentedString(afterRebootRollbackFnc)).append("\n");
                        sb.append("    afterRebootTaskName: ").append(toIndentedString(afterRebootTaskName)).append("\n");
                        sb.append("    clean: ").append(toIndentedString(clean)).append("\n");
                        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
                        sb.append("    enablePatchRollback: ").append(toIndentedString(enablePatchRollback)).append("\n");
                        sb.append("    enableRollback: ").append(toIndentedString(enableRollback)).append("\n");
                        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
                        sb.append("    enqueueTime: ").append(toIndentedString(enqueueTime)).append("\n");
                        sb.append("    history: ").append(toIndentedString(history)).append("\n");
                        sb.append("    imagePath: ").append(toIndentedString(imagePath)).append("\n");
                        sb.append("    imageRef: ").append(toIndentedString(imageRef)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
                        sb.append("    objCloudRef: ").append(toIndentedString(objCloudRef)).append("\n");
                        sb.append("    params: ").append(toIndentedString(params)).append("\n");
                        sb.append("    patchImagePath: ").append(toIndentedString(patchImagePath)).append("\n");
                        sb.append("    patchImageRef: ").append(toIndentedString(patchImageRef)).append("\n");
                        sb.append("    patchList: ").append(toIndentedString(patchList)).append("\n");
                        sb.append("    patchReboot: ").append(toIndentedString(patchReboot)).append("\n");
                        sb.append("    patchVersion: ").append(toIndentedString(patchVersion)).append("\n");
                        sb.append("    prevImagePath: ").append(toIndentedString(prevImagePath)).append("\n");
                        sb.append("    prevPatchImagePath: ").append(toIndentedString(prevPatchImagePath)).append("\n");
                        sb.append("    previousImageRef: ").append(toIndentedString(previousImageRef)).append("\n");
                        sb.append("    previousPatchImageRef: ").append(toIndentedString(previousPatchImageRef)).append("\n");
                        sb.append("    previousPatchList: ").append(toIndentedString(previousPatchList)).append("\n");
                        sb.append("    previousPatchVersion: ").append(toIndentedString(previousPatchVersion)).append("\n");
                        sb.append("    previousVersion: ").append(toIndentedString(previousVersion)).append("\n");
                        sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
                        sb.append("    sePatchImagePath: ").append(toIndentedString(sePatchImagePath)).append("\n");
                        sb.append("    sePatchImageRef: ").append(toIndentedString(sePatchImageRef)).append("\n");
                        sb.append("    seUpgradeEvents: ").append(toIndentedString(seUpgradeEvents)).append("\n");
                        sb.append("    segParams: ").append(toIndentedString(segParams)).append("\n");
                        sb.append("    segStatus: ").append(toIndentedString(segStatus)).append("\n");
                        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
                        sb.append("    state: ").append(toIndentedString(state)).append("\n");
                        sb.append("    system: ").append(toIndentedString(system)).append("\n");
                        sb.append("    tasksCompleted: ").append(toIndentedString(tasksCompleted)).append("\n");
                        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
                        sb.append("    totalTasks: ").append(toIndentedString(totalTasks)).append("\n");
                        sb.append("    upgradeEvents: ").append(toIndentedString(upgradeEvents)).append("\n");
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
