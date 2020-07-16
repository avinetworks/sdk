package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The UpgradeTask is a POJO class extends AviRestResource that used for creating
 * UpgradeTask.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpgradeTask  {
    @JsonProperty("duration")
    private String duration = null;

    @JsonProperty("end_time")
    private String endTime = null;

    @JsonProperty("start_time")
    private String startTime = null;

    @JsonProperty("task")
    private String task = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property duration of obj type upgradetask field type str  type string.
   * @return duration
   */
  public String getDuration() {
    return duration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property duration of obj type upgradetask field type str  type string.
   * @param duration set the duration.
   */
  public void setDuration(String  duration) {
    this.duration = duration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property end_time of obj type upgradetask field type str  type string.
   * @return endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property end_time of obj type upgradetask field type str  type string.
   * @param endTime set the endTime.
   */
  public void setEndTime(String  endTime) {
    this.endTime = endTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property start_time of obj type upgradetask field type str  type string.
   * @return startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property start_time of obj type upgradetask field type str  type string.
   * @param startTime set the startTime.
   */
  public void setStartTime(String  startTime) {
    this.startTime = startTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - PREPARE_FOR_SHUTDOWN, COPY_AND_VERIFY_IMAGE, INSTALL_IMAGE, POST_INSTALL_HOOKS, PREPARE_CONTROLLER_FOR_SHUTDOWN, STOP_CONTROLLER,
   * EXTRACT_PATCH_IMAGE, EXECUTE_PRE_INSTALL_COMMANDS, INSTALL_PATCH_IMAGE, PREPARE_FOR_REBOOT_CONTROLLER_NODES, REBOOT_CONTROLLER_NODES,
   * WAIT_FOR_ALL_CONTROLLER_NODES_ONLINE, PRE_UPGRADE_HOOKS, MIGRATE_CONFIG, START_PRIMARY_CONTROLLER, START_ALL_CONTROLLERS, POST_UPGRADE_HOOKS,
   * EXECUTE_POST_INSTALL_COMMANDS, SET_CONTROLLER_UPGRADE_COMPLETED, STATE_NOT_USED_IN_V2...
   * @return task
   */
  public String getTask() {
    return task;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - PREPARE_FOR_SHUTDOWN, COPY_AND_VERIFY_IMAGE, INSTALL_IMAGE, POST_INSTALL_HOOKS, PREPARE_CONTROLLER_FOR_SHUTDOWN, STOP_CONTROLLER,
   * EXTRACT_PATCH_IMAGE, EXECUTE_PRE_INSTALL_COMMANDS, INSTALL_PATCH_IMAGE, PREPARE_FOR_REBOOT_CONTROLLER_NODES, REBOOT_CONTROLLER_NODES,
   * WAIT_FOR_ALL_CONTROLLER_NODES_ONLINE, PRE_UPGRADE_HOOKS, MIGRATE_CONFIG, START_PRIMARY_CONTROLLER, START_ALL_CONTROLLERS, POST_UPGRADE_HOOKS,
   * EXECUTE_POST_INSTALL_COMMANDS, SET_CONTROLLER_UPGRADE_COMPLETED, STATE_NOT_USED_IN_V2...
   * @param task set the task.
   */
  public void setTask(String  task) {
    this.task = task;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  UpgradeTask objUpgradeTask = (UpgradeTask) o;
  return   Objects.equals(this.duration, objUpgradeTask.duration)&&
  Objects.equals(this.startTime, objUpgradeTask.startTime)&&
  Objects.equals(this.task, objUpgradeTask.task)&&
  Objects.equals(this.endTime, objUpgradeTask.endTime);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class UpgradeTask {\n");
      sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    task: ").append(toIndentedString(task)).append("\n");
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

