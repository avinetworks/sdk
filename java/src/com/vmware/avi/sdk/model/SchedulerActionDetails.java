package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SchedulerActionDetails is a POJO class extends AviRestResource that used for creating
 * SchedulerActionDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchedulerActionDetails  {
    @JsonProperty("backup_uri")
    private List<String> backupUri = null;

    @JsonProperty("control_script_output")
    private String controlScriptOutput = null;

    @JsonProperty("execution_datestamp")
    private String executionDatestamp = null;

    @JsonProperty("scheduler_uuid")
    private String schedulerUuid = null;

    @JsonProperty("status")
    private String status = null;


  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property backup_uri of obj type scheduleractiondetails field type str  type array.
   * @return backupUri
   */
  public List<String> getBackupUri() {
    return backupUri;
  }

  /**
   * This is the setter method. this will set the backupUri
   * Placeholder for description of property backup_uri of obj type scheduleractiondetails field type str  type array.
   * @return backupUri
   */
  public void setBackupUri(List<String>  backupUri) {
    this.backupUri = backupUri;
  }

  /**
   * This is the setter method this will set the backupUri
   * Placeholder for description of property backup_uri of obj type scheduleractiondetails field type str  type array.
   * @return backupUri
   */
  public SchedulerActionDetails addBackupUriItem(String backupUriItem) {
    if (this.backupUri == null) {
      this.backupUri = new ArrayList<String>();
    }
    this.backupUri.add(backupUriItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property control_script_output of obj type scheduleractiondetails field type str  type string.
   * @return controlScriptOutput
   */
  public String getControlScriptOutput() {
    return controlScriptOutput;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property control_script_output of obj type scheduleractiondetails field type str  type string.
   * @param controlScriptOutput set the controlScriptOutput.
   */
  public void setControlScriptOutput(String  controlScriptOutput) {
    this.controlScriptOutput = controlScriptOutput;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property execution_datestamp of obj type scheduleractiondetails field type str  type string.
   * @return executionDatestamp
   */
  public String getExecutionDatestamp() {
    return executionDatestamp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property execution_datestamp of obj type scheduleractiondetails field type str  type string.
   * @param executionDatestamp set the executionDatestamp.
   */
  public void setExecutionDatestamp(String  executionDatestamp) {
    this.executionDatestamp = executionDatestamp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of scheduler.
   * @return schedulerUuid
   */
  public String getSchedulerUuid() {
    return schedulerUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of scheduler.
   * @param schedulerUuid set the schedulerUuid.
   */
  public void setSchedulerUuid(String  schedulerUuid) {
    this.schedulerUuid = schedulerUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property status of obj type scheduleractiondetails field type str  type string.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property status of obj type scheduleractiondetails field type str  type string.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SchedulerActionDetails objSchedulerActionDetails = (SchedulerActionDetails) o;
  return   Objects.equals(this.schedulerUuid, objSchedulerActionDetails.schedulerUuid)&&
  Objects.equals(this.executionDatestamp, objSchedulerActionDetails.executionDatestamp)&&
  Objects.equals(this.backupUri, objSchedulerActionDetails.backupUri)&&
  Objects.equals(this.controlScriptOutput, objSchedulerActionDetails.controlScriptOutput)&&
  Objects.equals(this.status, objSchedulerActionDetails.status);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SchedulerActionDetails {\n");
      sb.append("    backupUri: ").append(toIndentedString(backupUri)).append("\n");
        sb.append("    controlScriptOutput: ").append(toIndentedString(controlScriptOutput)).append("\n");
        sb.append("    executionDatestamp: ").append(toIndentedString(executionDatestamp)).append("\n");
        sb.append("    schedulerUuid: ").append(toIndentedString(schedulerUuid)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

