package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VipRuntime is a POJO class extends AviRestResource that used for creating
 * VipRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VipRuntime  {
    @JsonProperty("ev")
    private List<String> ev = null;

    @JsonProperty("ev_status")
    private VsEvStatus evStatus = null;

    @JsonProperty("first_se_assigned_time")
    private TimeStamp firstSeAssignedTime = null;

    @JsonProperty("first_time_placement")
    private Boolean firstTimePlacement = false;

    @JsonProperty("fsm_state_id")
    private String fsmStateId = "0";

    @JsonProperty("fsm_state_name")
    private String fsmStateName = "VipFsmMap::Inactive";

    @JsonProperty("last_changed_time")
    private TimeStamp lastChangedTime = null;

    @JsonProperty("last_scale_status")
    private ScaleStatus lastScaleStatus = null;

    @JsonProperty("marked_for_delete")
    private Boolean markedForDelete = false;

    @JsonProperty("metrics_mgr_port")
    private String metricsMgrPort = null;

    @JsonProperty("migrate_in_progress")
    private Boolean migrateInProgress = false;

    @JsonProperty("migrate_request")
    private VsMigrateParams migrateRequest = null;

    @JsonProperty("migrate_scalein_pending")
    private Boolean migrateScaleinPending = false;

    @JsonProperty("migrate_scaleout_pending")
    private Boolean migrateScaleoutPending = false;

    @JsonProperty("num_additional_se")
    private Integer numAdditionalSe = 0;

    @JsonProperty("prev_metrics_mgr_port")
    private String prevMetricsMgrPort = null;

    @JsonProperty("progress_percent")
    private Integer progressPercent = 0;

    @JsonProperty("requested_resource")
    private VirtualServiceResource requestedResource = null;

    @JsonProperty("scale_status")
    private ScaleStatus scaleStatus = null;

    @JsonProperty("scalein_in_progress")
    private Boolean scaleinInProgress = false;

    @JsonProperty("scalein_request")
    private VsScaleinParams scaleinRequest = null;

    @JsonProperty("scaleout_in_progress")
    private Boolean scaleoutInProgress = false;

    @JsonProperty("se_list")
    private List<SeList> seList = null;

    @JsonProperty("servers_configured")
    private Boolean serversConfigured = true;

    @JsonProperty("supp_runtime_status")
    private OperationalStatus suppRuntimeStatus = null;

    @JsonProperty("user_scaleout_pending")
    private Boolean userScaleoutPending = false;

    @JsonProperty("vip_id")
    private String vipId = null;

    @JsonProperty("warmstart_resync_done")
    private Boolean warmstartResyncDone = false;

    @JsonProperty("warmstart_resync_sent")
    private Boolean warmstartResyncSent = false;


  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ev of obj type vipruntime field type str  type array.
   * @return ev
   */
  public List<String> getEv() {
    return ev;
  }

  /**
   * This is the setter method. this will set the ev
   * Placeholder for description of property ev of obj type vipruntime field type str  type array.
   * @return ev
   */
  public void setEv(List<String>  ev) {
    this.ev = ev;
  }

  /**
   * This is the setter method this will set the ev
   * Placeholder for description of property ev of obj type vipruntime field type str  type array.
   * @return ev
   */
  public VipRuntime addEvItem(String evItem) {
    if (this.ev == null) {
      this.ev = new ArrayList<String>();
    }
    this.ev.add(evItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ev_status of obj type vipruntime field type str  type ref.
   * @return evStatus
   */
  public VsEvStatus getEvStatus() {
    return evStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ev_status of obj type vipruntime field type str  type ref.
   * @param evStatus set the evStatus.
   */
  public void setEvStatus(VsEvStatus evStatus) {
    this.evStatus = evStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property first_se_assigned_time of obj type vipruntime field type str  type ref.
   * @return firstSeAssignedTime
   */
  public TimeStamp getFirstSeAssignedTime() {
    return firstSeAssignedTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property first_se_assigned_time of obj type vipruntime field type str  type ref.
   * @param firstSeAssignedTime set the firstSeAssignedTime.
   */
  public void setFirstSeAssignedTime(TimeStamp firstSeAssignedTime) {
    this.firstSeAssignedTime = firstSeAssignedTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property first_time_placement of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return firstTimePlacement
   */
  public Boolean getFirstTimePlacement() {
    return firstTimePlacement;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property first_time_placement of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param firstTimePlacement set the firstTimePlacement.
   */
  public void setFirstTimePlacement(Boolean  firstTimePlacement) {
    this.firstTimePlacement = firstTimePlacement;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property fsm_state_id of obj type vipruntime field type str  type string.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return fsmStateId
   */
  public String getFsmStateId() {
    return fsmStateId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property fsm_state_id of obj type vipruntime field type str  type string.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param fsmStateId set the fsmStateId.
   */
  public void setFsmStateId(String  fsmStateId) {
    this.fsmStateId = fsmStateId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property fsm_state_name of obj type vipruntime field type str  type string.
   * Default value when not specified in API or module is interpreted by Avi Controller as VipFsmMap::Inactive.
   * @return fsmStateName
   */
  public String getFsmStateName() {
    return fsmStateName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property fsm_state_name of obj type vipruntime field type str  type string.
   * Default value when not specified in API or module is interpreted by Avi Controller as VipFsmMap::Inactive.
   * @param fsmStateName set the fsmStateName.
   */
  public void setFsmStateName(String  fsmStateName) {
    this.fsmStateName = fsmStateName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property last_changed_time of obj type vipruntime field type str  type ref.
   * @return lastChangedTime
   */
  public TimeStamp getLastChangedTime() {
    return lastChangedTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property last_changed_time of obj type vipruntime field type str  type ref.
   * @param lastChangedTime set the lastChangedTime.
   */
  public void setLastChangedTime(TimeStamp lastChangedTime) {
    this.lastChangedTime = lastChangedTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property last_scale_status of obj type vipruntime field type str  type ref.
   * @return lastScaleStatus
   */
  public ScaleStatus getLastScaleStatus() {
    return lastScaleStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property last_scale_status of obj type vipruntime field type str  type ref.
   * @param lastScaleStatus set the lastScaleStatus.
   */
  public void setLastScaleStatus(ScaleStatus lastScaleStatus) {
    this.lastScaleStatus = lastScaleStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property marked_for_delete of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return markedForDelete
   */
  public Boolean getMarkedForDelete() {
    return markedForDelete;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property marked_for_delete of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param markedForDelete set the markedForDelete.
   */
  public void setMarkedForDelete(Boolean  markedForDelete) {
    this.markedForDelete = markedForDelete;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - METRICS_MGR_PORT_0, METRICS_MGR_PORT_1, METRICS_MGR_PORT_2, METRICS_MGR_PORT_3.
   * @return metricsMgrPort
   */
  public String getMetricsMgrPort() {
    return metricsMgrPort;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - METRICS_MGR_PORT_0, METRICS_MGR_PORT_1, METRICS_MGR_PORT_2, METRICS_MGR_PORT_3.
   * @param metricsMgrPort set the metricsMgrPort.
   */
  public void setMetricsMgrPort(String  metricsMgrPort) {
    this.metricsMgrPort = metricsMgrPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property migrate_in_progress of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return migrateInProgress
   */
  public Boolean getMigrateInProgress() {
    return migrateInProgress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property migrate_in_progress of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param migrateInProgress set the migrateInProgress.
   */
  public void setMigrateInProgress(Boolean  migrateInProgress) {
    this.migrateInProgress = migrateInProgress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property migrate_request of obj type vipruntime field type str  type ref.
   * @return migrateRequest
   */
  public VsMigrateParams getMigrateRequest() {
    return migrateRequest;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property migrate_request of obj type vipruntime field type str  type ref.
   * @param migrateRequest set the migrateRequest.
   */
  public void setMigrateRequest(VsMigrateParams migrateRequest) {
    this.migrateRequest = migrateRequest;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property migrate_scalein_pending of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return migrateScaleinPending
   */
  public Boolean getMigrateScaleinPending() {
    return migrateScaleinPending;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property migrate_scalein_pending of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param migrateScaleinPending set the migrateScaleinPending.
   */
  public void setMigrateScaleinPending(Boolean  migrateScaleinPending) {
    this.migrateScaleinPending = migrateScaleinPending;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property migrate_scaleout_pending of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return migrateScaleoutPending
   */
  public Boolean getMigrateScaleoutPending() {
    return migrateScaleoutPending;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property migrate_scaleout_pending of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param migrateScaleoutPending set the migrateScaleoutPending.
   */
  public void setMigrateScaleoutPending(Boolean  migrateScaleoutPending) {
    this.migrateScaleoutPending = migrateScaleoutPending;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_additional_se of obj type vipruntime field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return numAdditionalSe
   */
  public Integer getNumAdditionalSe() {
    return numAdditionalSe;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_additional_se of obj type vipruntime field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param numAdditionalSe set the numAdditionalSe.
   */
  public void setNumAdditionalSe(Integer  numAdditionalSe) {
    this.numAdditionalSe = numAdditionalSe;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - METRICS_MGR_PORT_0, METRICS_MGR_PORT_1, METRICS_MGR_PORT_2, METRICS_MGR_PORT_3.
   * @return prevMetricsMgrPort
   */
  public String getPrevMetricsMgrPort() {
    return prevMetricsMgrPort;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - METRICS_MGR_PORT_0, METRICS_MGR_PORT_1, METRICS_MGR_PORT_2, METRICS_MGR_PORT_3.
   * @param prevMetricsMgrPort set the prevMetricsMgrPort.
   */
  public void setPrevMetricsMgrPort(String  prevMetricsMgrPort) {
    this.prevMetricsMgrPort = prevMetricsMgrPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property progress_percent of obj type vipruntime field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return progressPercent
   */
  public Integer getProgressPercent() {
    return progressPercent;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property progress_percent of obj type vipruntime field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param progressPercent set the progressPercent.
   */
  public void setProgressPercent(Integer  progressPercent) {
    this.progressPercent = progressPercent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property requested_resource of obj type vipruntime field type str  type ref.
   * @return requestedResource
   */
  public VirtualServiceResource getRequestedResource() {
    return requestedResource;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property requested_resource of obj type vipruntime field type str  type ref.
   * @param requestedResource set the requestedResource.
   */
  public void setRequestedResource(VirtualServiceResource requestedResource) {
    this.requestedResource = requestedResource;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property scale_status of obj type vipruntime field type str  type ref.
   * @return scaleStatus
   */
  public ScaleStatus getScaleStatus() {
    return scaleStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property scale_status of obj type vipruntime field type str  type ref.
   * @param scaleStatus set the scaleStatus.
   */
  public void setScaleStatus(ScaleStatus scaleStatus) {
    this.scaleStatus = scaleStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property scalein_in_progress of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return scaleinInProgress
   */
  public Boolean getScaleinInProgress() {
    return scaleinInProgress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property scalein_in_progress of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param scaleinInProgress set the scaleinInProgress.
   */
  public void setScaleinInProgress(Boolean  scaleinInProgress) {
    this.scaleinInProgress = scaleinInProgress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property scalein_request of obj type vipruntime field type str  type ref.
   * @return scaleinRequest
   */
  public VsScaleinParams getScaleinRequest() {
    return scaleinRequest;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property scalein_request of obj type vipruntime field type str  type ref.
   * @param scaleinRequest set the scaleinRequest.
   */
  public void setScaleinRequest(VsScaleinParams scaleinRequest) {
    this.scaleinRequest = scaleinRequest;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property scaleout_in_progress of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return scaleoutInProgress
   */
  public Boolean getScaleoutInProgress() {
    return scaleoutInProgress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property scaleout_in_progress of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param scaleoutInProgress set the scaleoutInProgress.
   */
  public void setScaleoutInProgress(Boolean  scaleoutInProgress) {
    this.scaleoutInProgress = scaleoutInProgress;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_list of obj type vipruntime field type str  type array.
   * @return seList
   */
  public List<SeList> getSeList() {
    return seList;
  }

  /**
   * This is the setter method. this will set the seList
   * Placeholder for description of property se_list of obj type vipruntime field type str  type array.
   * @return seList
   */
  public void setSeList(List<SeList>  seList) {
    this.seList = seList;
  }

  /**
   * This is the setter method this will set the seList
   * Placeholder for description of property se_list of obj type vipruntime field type str  type array.
   * @return seList
   */
  public VipRuntime addSeListItem(SeList seListItem) {
    if (this.seList == null) {
      this.seList = new ArrayList<SeList>();
    }
    this.seList.add(seListItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return serversConfigured
   */
  public Boolean getServersConfigured() {
    return serversConfigured;
  }

  /**
   * This is the setter method to the attribute.
   * Field deprecated in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param serversConfigured set the serversConfigured.
   */
  public void setServersConfigured(Boolean  serversConfigured) {
    this.serversConfigured = serversConfigured;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property supp_runtime_status of obj type vipruntime field type str  type ref.
   * @return suppRuntimeStatus
   */
  public OperationalStatus getSuppRuntimeStatus() {
    return suppRuntimeStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property supp_runtime_status of obj type vipruntime field type str  type ref.
   * @param suppRuntimeStatus set the suppRuntimeStatus.
   */
  public void setSuppRuntimeStatus(OperationalStatus suppRuntimeStatus) {
    this.suppRuntimeStatus = suppRuntimeStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property user_scaleout_pending of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return userScaleoutPending
   */
  public Boolean getUserScaleoutPending() {
    return userScaleoutPending;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property user_scaleout_pending of obj type vipruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param userScaleoutPending set the userScaleoutPending.
   */
  public void setUserScaleoutPending(Boolean  userScaleoutPending) {
    this.userScaleoutPending = userScaleoutPending;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_id of obj type vipruntime field type str  type string.
   * @return vipId
   */
  public String getVipId() {
    return vipId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vip_id of obj type vipruntime field type str  type string.
   * @param vipId set the vipId.
   */
  public void setVipId(String  vipId) {
    this.vipId = vipId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vip finished resyncing with resource manager.
   * Field introduced in 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return warmstartResyncDone
   */
  public Boolean getWarmstartResyncDone() {
    return warmstartResyncDone;
  }

  /**
   * This is the setter method to the attribute.
   * Vip finished resyncing with resource manager.
   * Field introduced in 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param warmstartResyncDone set the warmstartResyncDone.
   */
  public void setWarmstartResyncDone(Boolean  warmstartResyncDone) {
    this.warmstartResyncDone = warmstartResyncDone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rpc sent to resource manager for warmstart resync.
   * Field introduced in 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return warmstartResyncSent
   */
  public Boolean getWarmstartResyncSent() {
    return warmstartResyncSent;
  }

  /**
   * This is the setter method to the attribute.
   * Rpc sent to resource manager for warmstart resync.
   * Field introduced in 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param warmstartResyncSent set the warmstartResyncSent.
   */
  public void setWarmstartResyncSent(Boolean  warmstartResyncSent) {
    this.warmstartResyncSent = warmstartResyncSent;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VipRuntime objVipRuntime = (VipRuntime) o;
  return   Objects.equals(this.vipId, objVipRuntime.vipId)&&
  Objects.equals(this.fsmStateName, objVipRuntime.fsmStateName)&&
  Objects.equals(this.fsmStateId, objVipRuntime.fsmStateId)&&
  Objects.equals(this.serversConfigured, objVipRuntime.serversConfigured)&&
  Objects.equals(this.lastChangedTime, objVipRuntime.lastChangedTime)&&
  Objects.equals(this.markedForDelete, objVipRuntime.markedForDelete)&&
  Objects.equals(this.progressPercent, objVipRuntime.progressPercent)&&
  Objects.equals(this.scaleStatus, objVipRuntime.scaleStatus)&&
  Objects.equals(this.metricsMgrPort, objVipRuntime.metricsMgrPort)&&
  Objects.equals(this.prevMetricsMgrPort, objVipRuntime.prevMetricsMgrPort)&&
  Objects.equals(this.scaleoutInProgress, objVipRuntime.scaleoutInProgress)&&
  Objects.equals(this.userScaleoutPending, objVipRuntime.userScaleoutPending)&&
  Objects.equals(this.scaleinInProgress, objVipRuntime.scaleinInProgress)&&
  Objects.equals(this.scaleinRequest, objVipRuntime.scaleinRequest)&&
  Objects.equals(this.migrateInProgress, objVipRuntime.migrateInProgress)&&
  Objects.equals(this.migrateRequest, objVipRuntime.migrateRequest)&&
  Objects.equals(this.migrateScaleoutPending, objVipRuntime.migrateScaleoutPending)&&
  Objects.equals(this.migrateScaleinPending, objVipRuntime.migrateScaleinPending)&&
  Objects.equals(this.firstTimePlacement, objVipRuntime.firstTimePlacement)&&
  Objects.equals(this.seList, objVipRuntime.seList)&&
  Objects.equals(this.requestedResource, objVipRuntime.requestedResource)&&
  Objects.equals(this.suppRuntimeStatus, objVipRuntime.suppRuntimeStatus)&&
  Objects.equals(this.firstSeAssignedTime, objVipRuntime.firstSeAssignedTime)&&
  Objects.equals(this.numAdditionalSe, objVipRuntime.numAdditionalSe)&&
  Objects.equals(this.evStatus, objVipRuntime.evStatus)&&
  Objects.equals(this.ev, objVipRuntime.ev)&&
  Objects.equals(this.lastScaleStatus, objVipRuntime.lastScaleStatus)&&
  Objects.equals(this.warmstartResyncSent, objVipRuntime.warmstartResyncSent)&&
  Objects.equals(this.warmstartResyncDone, objVipRuntime.warmstartResyncDone);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VipRuntime {\n");
      sb.append("    ev: ").append(toIndentedString(ev)).append("\n");
        sb.append("    evStatus: ").append(toIndentedString(evStatus)).append("\n");
        sb.append("    firstSeAssignedTime: ").append(toIndentedString(firstSeAssignedTime)).append("\n");
        sb.append("    firstTimePlacement: ").append(toIndentedString(firstTimePlacement)).append("\n");
        sb.append("    fsmStateId: ").append(toIndentedString(fsmStateId)).append("\n");
        sb.append("    fsmStateName: ").append(toIndentedString(fsmStateName)).append("\n");
        sb.append("    lastChangedTime: ").append(toIndentedString(lastChangedTime)).append("\n");
        sb.append("    lastScaleStatus: ").append(toIndentedString(lastScaleStatus)).append("\n");
        sb.append("    markedForDelete: ").append(toIndentedString(markedForDelete)).append("\n");
        sb.append("    metricsMgrPort: ").append(toIndentedString(metricsMgrPort)).append("\n");
        sb.append("    migrateInProgress: ").append(toIndentedString(migrateInProgress)).append("\n");
        sb.append("    migrateRequest: ").append(toIndentedString(migrateRequest)).append("\n");
        sb.append("    migrateScaleinPending: ").append(toIndentedString(migrateScaleinPending)).append("\n");
        sb.append("    migrateScaleoutPending: ").append(toIndentedString(migrateScaleoutPending)).append("\n");
        sb.append("    numAdditionalSe: ").append(toIndentedString(numAdditionalSe)).append("\n");
        sb.append("    prevMetricsMgrPort: ").append(toIndentedString(prevMetricsMgrPort)).append("\n");
        sb.append("    progressPercent: ").append(toIndentedString(progressPercent)).append("\n");
        sb.append("    requestedResource: ").append(toIndentedString(requestedResource)).append("\n");
        sb.append("    scaleStatus: ").append(toIndentedString(scaleStatus)).append("\n");
        sb.append("    scaleinInProgress: ").append(toIndentedString(scaleinInProgress)).append("\n");
        sb.append("    scaleinRequest: ").append(toIndentedString(scaleinRequest)).append("\n");
        sb.append("    scaleoutInProgress: ").append(toIndentedString(scaleoutInProgress)).append("\n");
        sb.append("    seList: ").append(toIndentedString(seList)).append("\n");
        sb.append("    serversConfigured: ").append(toIndentedString(serversConfigured)).append("\n");
        sb.append("    suppRuntimeStatus: ").append(toIndentedString(suppRuntimeStatus)).append("\n");
        sb.append("    userScaleoutPending: ").append(toIndentedString(userScaleoutPending)).append("\n");
        sb.append("    vipId: ").append(toIndentedString(vipId)).append("\n");
        sb.append("    warmstartResyncDone: ").append(toIndentedString(warmstartResyncDone)).append("\n");
        sb.append("    warmstartResyncSent: ").append(toIndentedString(warmstartResyncSent)).append("\n");
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

