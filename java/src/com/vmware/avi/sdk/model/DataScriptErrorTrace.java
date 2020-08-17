package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DataScriptErrorTrace is a POJO class extends AviRestResource that used for creating
 * DataScriptErrorTrace.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataScriptErrorTrace  {
    @JsonProperty("error")
    private String error = null;

    @JsonProperty("event")
    private String event = null;

    @JsonProperty("stack_trace")
    private String stackTrace = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error of obj type datascripterrortrace field type str  type string.
   * @return error
   */
  public String getError() {
    return error;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error of obj type datascripterrortrace field type str  type string.
   * @param error set the error.
   */
  public void setError(String  error) {
    this.error = error;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property event of obj type datascripterrortrace field type str  type string.
   * @return event
   */
  public String getEvent() {
    return event;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property event of obj type datascripterrortrace field type str  type string.
   * @param event set the event.
   */
  public void setEvent(String  event) {
    this.event = event;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property stack_trace of obj type datascripterrortrace field type str  type string.
   * @return stackTrace
   */
  public String getStackTrace() {
    return stackTrace;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property stack_trace of obj type datascripterrortrace field type str  type string.
   * @param stackTrace set the stackTrace.
   */
  public void setStackTrace(String  stackTrace) {
    this.stackTrace = stackTrace;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DataScriptErrorTrace objDataScriptErrorTrace = (DataScriptErrorTrace) o;
  return   Objects.equals(this.error, objDataScriptErrorTrace.error)&&
  Objects.equals(this.stackTrace, objDataScriptErrorTrace.stackTrace)&&
  Objects.equals(this.event, objDataScriptErrorTrace.event);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DataScriptErrorTrace {\n");
      sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("    event: ").append(toIndentedString(event)).append("\n");
        sb.append("    stackTrace: ").append(toIndentedString(stackTrace)).append("\n");
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

