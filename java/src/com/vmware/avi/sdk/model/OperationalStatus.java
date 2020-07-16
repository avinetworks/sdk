package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OperationalStatus is a POJO class extends AviRestResource that used for creating
 * OperationalStatus.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationalStatus  {
    @JsonProperty("last_changed_time")
    private TimeStamp lastChangedTime = null;

    @JsonProperty("reason")
    private List<String> reason = null;

    @JsonProperty("reason_code")
    private Integer reasonCode = null;

    @JsonProperty("reason_code_string")
    private String reasonCodeString = null;

    @JsonProperty("state")
    private String state = "OPER_UNAVAIL";



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property last_changed_time of obj type operationalstatus field type str  type ref.
   * @return lastChangedTime
   */
  public TimeStamp getLastChangedTime() {
    return lastChangedTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property last_changed_time of obj type operationalstatus field type str  type ref.
   * @param lastChangedTime set the lastChangedTime.
   */
  public void setLastChangedTime(TimeStamp lastChangedTime) {
    this.lastChangedTime = lastChangedTime;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type operationalstatus field type str  type array.
   * @return reason
   */
  public List<String> getReason() {
    return reason;
  }

  /**
   * This is the setter method. this will set the reason
   * Placeholder for description of property reason of obj type operationalstatus field type str  type array.
   * @return reason
   */
  public void setReason(List<String>  reason) {
    this.reason = reason;
  }

  /**
   * This is the setter method this will set the reason
   * Placeholder for description of property reason of obj type operationalstatus field type str  type array.
   * @return reason
   */
  public OperationalStatus addReasonItem(String reasonItem) {
    if (this.reason == null) {
      this.reason = new ArrayList<String>();
    }
    this.reason.add(reasonItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason_code of obj type operationalstatus field type str  type integer.
   * @return reasonCode
   */
  public Integer getReasonCode() {
    return reasonCode;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason_code of obj type operationalstatus field type str  type integer.
   * @param reasonCode set the reasonCode.
   */
  public void setReasonCode(Integer  reasonCode) {
    this.reasonCode = reasonCode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason_code_string of obj type operationalstatus field type str  type string.
   * @return reasonCodeString
   */
  public String getReasonCodeString() {
    return reasonCodeString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason_code_string of obj type operationalstatus field type str  type string.
   * @param reasonCodeString set the reasonCodeString.
   */
  public void setReasonCodeString(String  reasonCodeString) {
    this.reasonCodeString = reasonCodeString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - OPER_UP, OPER_DOWN, OPER_CREATING, OPER_RESOURCES, OPER_INACTIVE, OPER_DISABLED, OPER_UNUSED, OPER_UNKNOWN, OPER_PROCESSING,
   * OPER_INITIALIZING, OPER_ERROR_DISABLED, OPER_AWAIT_MANUAL_PLACEMENT, OPER_UPGRADING, OPER_SE_PROCESSING, OPER_PARTITIONED, OPER_DISABLING,
   * OPER_FAILED, OPER_UNAVAIL.
   * Default value when not specified in API or module is interpreted by Avi Controller as OPER_UNAVAIL.
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - OPER_UP, OPER_DOWN, OPER_CREATING, OPER_RESOURCES, OPER_INACTIVE, OPER_DISABLED, OPER_UNUSED, OPER_UNKNOWN, OPER_PROCESSING,
   * OPER_INITIALIZING, OPER_ERROR_DISABLED, OPER_AWAIT_MANUAL_PLACEMENT, OPER_UPGRADING, OPER_SE_PROCESSING, OPER_PARTITIONED, OPER_DISABLING,
   * OPER_FAILED, OPER_UNAVAIL.
   * Default value when not specified in API or module is interpreted by Avi Controller as OPER_UNAVAIL.
   * @param state set the state.
   */
  public void setState(String  state) {
    this.state = state;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OperationalStatus objOperationalStatus = (OperationalStatus) o;
  return   Objects.equals(this.reasonCodeString, objOperationalStatus.reasonCodeString)&&
  Objects.equals(this.state, objOperationalStatus.state)&&
  Objects.equals(this.reasonCode, objOperationalStatus.reasonCode)&&
  Objects.equals(this.reason, objOperationalStatus.reason)&&
  Objects.equals(this.lastChangedTime, objOperationalStatus.lastChangedTime);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OperationalStatus {\n");
      sb.append("    lastChangedTime: ").append(toIndentedString(lastChangedTime)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    reasonCode: ").append(toIndentedString(reasonCode)).append("\n");
        sb.append("    reasonCodeString: ").append(toIndentedString(reasonCodeString)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

