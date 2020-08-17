package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SystemUpgradeState is a POJO class extends AviRestResource that used for creating
 * SystemUpgradeState.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SystemUpgradeState  {
    @JsonProperty("controller_state")
    private ControllerUpgradeState controllerState = null;

    @JsonProperty("duration")
    private Integer duration = null;

    @JsonProperty("end_time")
    private String endTime = null;

    @JsonProperty("from_version")
    private String fromVersion = null;

    @JsonProperty("in_progress")
    private Boolean inProgress = null;

    @JsonProperty("is_patch")
    private Boolean isPatch = null;

    @JsonProperty("patch_type")
    private String patchType = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("result")
    private String result = null;

    @JsonProperty("rollback")
    private Boolean rollback = null;

    @JsonProperty("se_state")
    private SeUpgradeStatusSummary seState = null;

    @JsonProperty("start_time")
    private String startTime = null;

    @JsonProperty("to_version")
    private String toVersion = null;



  /**
   * This is the getter method this will return the attribute value.
   * Upgrade state from controller.
   * @return controllerState
   */
  public ControllerUpgradeState getControllerState() {
    return controllerState;
  }

  /**
   * This is the setter method to the attribute.
   * Upgrade state from controller.
   * @param controllerState set the controllerState.
   */
  public void setControllerState(ControllerUpgradeState controllerState) {
    this.controllerState = controllerState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Upgrade duration.
   * Field introduced in 17.1.1.
   * @return duration
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * This is the setter method to the attribute.
   * Upgrade duration.
   * Field introduced in 17.1.1.
   * @param duration set the duration.
   */
  public void setDuration(Integer  duration) {
    this.duration = duration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Upgrade end time.
   * Field introduced in 17.1.1.
   * @return endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * This is the setter method to the attribute.
   * Upgrade end time.
   * Field introduced in 17.1.1.
   * @param endTime set the endTime.
   */
  public void setEndTime(String  endTime) {
    this.endTime = endTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Current version.
   * Field introduced in 17.1.1.
   * @return fromVersion
   */
  public String getFromVersion() {
    return fromVersion;
  }

  /**
   * This is the setter method to the attribute.
   * Current version.
   * Field introduced in 17.1.1.
   * @param fromVersion set the fromVersion.
   */
  public void setFromVersion(String  fromVersion) {
    this.fromVersion = fromVersion;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Set if upgrade is in progress.
   * @return inProgress
   */
  public Boolean getInProgress() {
    return inProgress;
  }

  /**
   * This is the setter method to the attribute.
   * Set if upgrade is in progress.
   * @param inProgress set the inProgress.
   */
  public void setInProgress(Boolean  inProgress) {
    this.inProgress = inProgress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Is set true, if patch upgrade requested by the user.
   * Field introduced in 17.2.8.
   * @return isPatch
   */
  public Boolean getIsPatch() {
    return isPatch;
  }

  /**
   * This is the setter method to the attribute.
   * Is set true, if patch upgrade requested by the user.
   * Field introduced in 17.2.8.
   * @param isPatch set the isPatch.
   */
  public void setIsPatch(Boolean  isPatch) {
    this.isPatch = isPatch;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Type of patch upgrade.
   * Field introduced in 17.2.8.
   * @return patchType
   */
  public String getPatchType() {
    return patchType;
  }

  /**
   * This is the setter method to the attribute.
   * Type of patch upgrade.
   * Field introduced in 17.2.8.
   * @param patchType set the patchType.
   */
  public void setPatchType(String  patchType) {
    this.patchType = patchType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Reason for upgrade failure.
   * Field introduced in 17.1.1.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Reason for upgrade failure.
   * Field introduced in 17.1.1.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Upgrade result.
   * Field introduced in 17.1.1.
   * @return result
   */
  public String getResult() {
    return result;
  }

  /**
   * This is the setter method to the attribute.
   * Upgrade result.
   * Field introduced in 17.1.1.
   * @param result set the result.
   */
  public void setResult(String  result) {
    this.result = result;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Set if rollback is requested by the user.
   * @return rollback
   */
  public Boolean getRollback() {
    return rollback;
  }

  /**
   * This is the setter method to the attribute.
   * Set if rollback is requested by the user.
   * @param rollback set the rollback.
   */
  public void setRollback(Boolean  rollback) {
    this.rollback = rollback;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Upgrade state of service engines.
   * @return seState
   */
  public SeUpgradeStatusSummary getSeState() {
    return seState;
  }

  /**
   * This is the setter method to the attribute.
   * Upgrade state of service engines.
   * @param seState set the seState.
   */
  public void setSeState(SeUpgradeStatusSummary seState) {
    this.seState = seState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Upgrade start time.
   * Field introduced in 17.1.1.
   * @return startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * This is the setter method to the attribute.
   * Upgrade start time.
   * Field introduced in 17.1.1.
   * @param startTime set the startTime.
   */
  public void setStartTime(String  startTime) {
    this.startTime = startTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Version to upgrade to.
   * Field introduced in 17.1.1.
   * @return toVersion
   */
  public String getToVersion() {
    return toVersion;
  }

  /**
   * This is the setter method to the attribute.
   * Version to upgrade to.
   * Field introduced in 17.1.1.
   * @param toVersion set the toVersion.
   */
  public void setToVersion(String  toVersion) {
    this.toVersion = toVersion;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SystemUpgradeState objSystemUpgradeState = (SystemUpgradeState) o;
  return   Objects.equals(this.inProgress, objSystemUpgradeState.inProgress)&&
  Objects.equals(this.rollback, objSystemUpgradeState.rollback)&&
  Objects.equals(this.controllerState, objSystemUpgradeState.controllerState)&&
  Objects.equals(this.seState, objSystemUpgradeState.seState)&&
  Objects.equals(this.startTime, objSystemUpgradeState.startTime)&&
  Objects.equals(this.endTime, objSystemUpgradeState.endTime)&&
  Objects.equals(this.duration, objSystemUpgradeState.duration)&&
  Objects.equals(this.fromVersion, objSystemUpgradeState.fromVersion)&&
  Objects.equals(this.toVersion, objSystemUpgradeState.toVersion)&&
  Objects.equals(this.result, objSystemUpgradeState.result)&&
  Objects.equals(this.reason, objSystemUpgradeState.reason)&&
  Objects.equals(this.isPatch, objSystemUpgradeState.isPatch)&&
  Objects.equals(this.patchType, objSystemUpgradeState.patchType);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SystemUpgradeState {\n");
      sb.append("    controllerState: ").append(toIndentedString(controllerState)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    fromVersion: ").append(toIndentedString(fromVersion)).append("\n");
        sb.append("    inProgress: ").append(toIndentedString(inProgress)).append("\n");
        sb.append("    isPatch: ").append(toIndentedString(isPatch)).append("\n");
        sb.append("    patchType: ").append(toIndentedString(patchType)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    result: ").append(toIndentedString(result)).append("\n");
        sb.append("    rollback: ").append(toIndentedString(rollback)).append("\n");
        sb.append("    seState: ").append(toIndentedString(seState)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    toVersion: ").append(toIndentedString(toVersion)).append("\n");
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

