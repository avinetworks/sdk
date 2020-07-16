package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ScaleStatus is a POJO class extends AviRestResource that used for creating
 * ScaleStatus.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScaleStatus  {
    @JsonProperty("action")
    private String action = null;

    @JsonProperty("action_success")
    private Boolean actionSuccess = null;

    @JsonProperty("end_time_str")
    private String endTimeStr = null;

    @JsonProperty("num_se_assigned")
    private Integer numSeAssigned = null;

    @JsonProperty("num_se_requested")
    private Integer numSeRequested = null;

    @JsonProperty("placement_read_fail_cnt")
    private Integer placementReadFailCnt = null;

    @JsonProperty("reason")
    private List<String> reason = null;

    @JsonProperty("reason_code")
    private Integer reasonCode = null;

    @JsonProperty("reason_code_string")
    private String reasonCodeString = null;

    @JsonProperty("scale_se")
    private String scaleSe = null;

    @JsonProperty("start_time_str")
    private String startTimeStr = null;

    @JsonProperty("state")
    private String state = null;

    @JsonProperty("vip_placement_resolution_info")
    private VipPlacementResolutionInfo vipPlacementResolutionInfo = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - OTHER, CREATE, READ, UPDATE, DELETE, SCALE_OUT, SCALE_IN, SE_REMOVED, SE_DISCONNECT, SE_RECONNECT, WARM_RESTART, COLD_RESTART,
   * UPDATE_LOGMGR_MAP, MIGRATE_SCALEOUT, MIGRATE_SCALEIN, INITIAL_PLACEMENT, ROTATE_KEYS, GLB_MGR_UPDATE, UPDATE_DNS_RECORDS, SCALEOUT_ADMINUP...
   * Field introduced in 17.1.1.
   * @return action
   */
  public String getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - OTHER, CREATE, READ, UPDATE, DELETE, SCALE_OUT, SCALE_IN, SE_REMOVED, SE_DISCONNECT, SE_RECONNECT, WARM_RESTART, COLD_RESTART,
   * UPDATE_LOGMGR_MAP, MIGRATE_SCALEOUT, MIGRATE_SCALEIN, INITIAL_PLACEMENT, ROTATE_KEYS, GLB_MGR_UPDATE, UPDATE_DNS_RECORDS, SCALEOUT_ADMINUP...
   * Field introduced in 17.1.1.
   * @param action set the action.
   */
  public void setAction(String  action) {
    this.action = action;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.1.1.
   * @return actionSuccess
   */
  public Boolean getActionSuccess() {
    return actionSuccess;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.1.1.
   * @param actionSuccess set the actionSuccess.
   */
  public void setActionSuccess(Boolean  actionSuccess) {
    this.actionSuccess = actionSuccess;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property end_time_str of obj type scalestatus field type str  type string.
   * @return endTimeStr
   */
  public String getEndTimeStr() {
    return endTimeStr;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property end_time_str of obj type scalestatus field type str  type string.
   * @param endTimeStr set the endTimeStr.
   */
  public void setEndTimeStr(String  endTimeStr) {
    this.endTimeStr = endTimeStr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_se_assigned of obj type scalestatus field type str  type integer.
   * @return numSeAssigned
   */
  public Integer getNumSeAssigned() {
    return numSeAssigned;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_se_assigned of obj type scalestatus field type str  type integer.
   * @param numSeAssigned set the numSeAssigned.
   */
  public void setNumSeAssigned(Integer  numSeAssigned) {
    this.numSeAssigned = numSeAssigned;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_se_requested of obj type scalestatus field type str  type integer.
   * @return numSeRequested
   */
  public Integer getNumSeRequested() {
    return numSeRequested;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_se_requested of obj type scalestatus field type str  type integer.
   * @param numSeRequested set the numSeRequested.
   */
  public void setNumSeRequested(Integer  numSeRequested) {
    this.numSeRequested = numSeRequested;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return placementReadFailCnt
   */
  public Integer getPlacementReadFailCnt() {
    return placementReadFailCnt;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param placementReadFailCnt set the placementReadFailCnt.
   */
  public void setPlacementReadFailCnt(Integer  placementReadFailCnt) {
    this.placementReadFailCnt = placementReadFailCnt;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type scalestatus field type str  type array.
   * @return reason
   */
  public List<String> getReason() {
    return reason;
  }

  /**
   * This is the setter method. this will set the reason
   * Placeholder for description of property reason of obj type scalestatus field type str  type array.
   * @return reason
   */
  public void setReason(List<String>  reason) {
    this.reason = reason;
  }

  /**
   * This is the setter method this will set the reason
   * Placeholder for description of property reason of obj type scalestatus field type str  type array.
   * @return reason
   */
  public ScaleStatus addReasonItem(String reasonItem) {
    if (this.reason == null) {
      this.reason = new ArrayList<String>();
    }
    this.reason.add(reasonItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason_code of obj type scalestatus field type str  type integer.
   * @return reasonCode
   */
  public Integer getReasonCode() {
    return reasonCode;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason_code of obj type scalestatus field type str  type integer.
   * @param reasonCode set the reasonCode.
   */
  public void setReasonCode(Integer  reasonCode) {
    this.reasonCode = reasonCode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason_code_string of obj type scalestatus field type str  type string.
   * @return reasonCodeString
   */
  public String getReasonCodeString() {
    return reasonCodeString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason_code_string of obj type scalestatus field type str  type string.
   * @param reasonCodeString set the reasonCodeString.
   */
  public void setReasonCodeString(String  reasonCodeString) {
    this.reasonCodeString = reasonCodeString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property scale_se of obj type scalestatus field type str  type string.
   * @return scaleSe
   */
  public String getScaleSe() {
    return scaleSe;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property scale_se of obj type scalestatus field type str  type string.
   * @param scaleSe set the scaleSe.
   */
  public void setScaleSe(String  scaleSe) {
    this.scaleSe = scaleSe;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property start_time_str of obj type scalestatus field type str  type string.
   * @return startTimeStr
   */
  public String getStartTimeStr() {
    return startTimeStr;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property start_time_str of obj type scalestatus field type str  type string.
   * @param startTimeStr set the startTimeStr.
   */
  public void setStartTimeStr(String  startTimeStr) {
    this.startTimeStr = startTimeStr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - SCALEOUT_PROCESSING, SCALEOUT_AWAITING_SE_ASSIGNMENT, SCALEOUT_CREATING_SE, SCALEOUT_RESOURCES, SCALEOUT_AWAITING_SE_PROGRAMMING,
   * SCALEOUT_WAIT_FOR_SE_READY, SCALEOUT_SUCCESS, SCALEOUT_ERROR, SCALEOUT_ROLLBACK, SCALEOUT_ERROR_DISABLED, SCALEIN_AWAITING_SE_PRE_RELEASE,
   * SCALEIN_AWAITING_SE_PROGRAMMING, SCALEIN_WAIT_FOR_SE_READY, SCALEIN_AWAITING_SE_RELEASE, SCALEIN_SUCCESS, SCALEIN_ERROR,
   * MIGRATE_SCALEOUT_AWAITING_SE_ASSIGNMENT, MIGRATE_SCALEOUT_CREATING_SE, MIGRATE_SCALEOUT_RESOURCES, MIGRATE_SCALEOUT_AWAITING_SE_PROGRAMMING...
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - SCALEOUT_PROCESSING, SCALEOUT_AWAITING_SE_ASSIGNMENT, SCALEOUT_CREATING_SE, SCALEOUT_RESOURCES, SCALEOUT_AWAITING_SE_PROGRAMMING,
   * SCALEOUT_WAIT_FOR_SE_READY, SCALEOUT_SUCCESS, SCALEOUT_ERROR, SCALEOUT_ROLLBACK, SCALEOUT_ERROR_DISABLED, SCALEIN_AWAITING_SE_PRE_RELEASE,
   * SCALEIN_AWAITING_SE_PROGRAMMING, SCALEIN_WAIT_FOR_SE_READY, SCALEIN_AWAITING_SE_RELEASE, SCALEIN_SUCCESS, SCALEIN_ERROR,
   * MIGRATE_SCALEOUT_AWAITING_SE_ASSIGNMENT, MIGRATE_SCALEOUT_CREATING_SE, MIGRATE_SCALEOUT_RESOURCES, MIGRATE_SCALEOUT_AWAITING_SE_PROGRAMMING...
   * @param state set the state.
   */
  public void setState(String  state) {
    this.state = state;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_placement_resolution_info of obj type scalestatus field type str  type ref.
   * @return vipPlacementResolutionInfo
   */
  public VipPlacementResolutionInfo getVipPlacementResolutionInfo() {
    return vipPlacementResolutionInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vip_placement_resolution_info of obj type scalestatus field type str  type ref.
   * @param vipPlacementResolutionInfo set the vipPlacementResolutionInfo.
   */
  public void setVipPlacementResolutionInfo(VipPlacementResolutionInfo vipPlacementResolutionInfo) {
    this.vipPlacementResolutionInfo = vipPlacementResolutionInfo;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ScaleStatus objScaleStatus = (ScaleStatus) o;
  return   Objects.equals(this.endTimeStr, objScaleStatus.endTimeStr)&&
  Objects.equals(this.reasonCodeString, objScaleStatus.reasonCodeString)&&
  Objects.equals(this.actionSuccess, objScaleStatus.actionSuccess)&&
  Objects.equals(this.startTimeStr, objScaleStatus.startTimeStr)&&
  Objects.equals(this.reasonCode, objScaleStatus.reasonCode)&&
  Objects.equals(this.reason, objScaleStatus.reason)&&
  Objects.equals(this.vipPlacementResolutionInfo, objScaleStatus.vipPlacementResolutionInfo)&&
  Objects.equals(this.scaleSe, objScaleStatus.scaleSe)&&
  Objects.equals(this.state, objScaleStatus.state)&&
  Objects.equals(this.numSeAssigned, objScaleStatus.numSeAssigned)&&
  Objects.equals(this.action, objScaleStatus.action)&&
  Objects.equals(this.placementReadFailCnt, objScaleStatus.placementReadFailCnt)&&
  Objects.equals(this.numSeRequested, objScaleStatus.numSeRequested);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ScaleStatus {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    actionSuccess: ").append(toIndentedString(actionSuccess)).append("\n");
        sb.append("    endTimeStr: ").append(toIndentedString(endTimeStr)).append("\n");
        sb.append("    numSeAssigned: ").append(toIndentedString(numSeAssigned)).append("\n");
        sb.append("    numSeRequested: ").append(toIndentedString(numSeRequested)).append("\n");
        sb.append("    placementReadFailCnt: ").append(toIndentedString(placementReadFailCnt)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    reasonCode: ").append(toIndentedString(reasonCode)).append("\n");
        sb.append("    reasonCodeString: ").append(toIndentedString(reasonCodeString)).append("\n");
        sb.append("    scaleSe: ").append(toIndentedString(scaleSe)).append("\n");
        sb.append("    startTimeStr: ").append(toIndentedString(startTimeStr)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    vipPlacementResolutionInfo: ").append(toIndentedString(vipPlacementResolutionInfo)).append("\n");
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

