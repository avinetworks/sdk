package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IcapLog is a POJO class extends AviRestResource that used for creating
 * IcapLog.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IcapLog  {
    @JsonProperty("action")
    private String action = null;

    @JsonProperty("request_logs")
    private List<IcapRequestLog> requestLogs = null;



  /**
   * This is the getter method this will return the attribute value.
   * Denotes whether the content was processed by icap server and an action was taken.
   * Enum options - ICAP_DISABLED, ICAP_PASSED, ICAP_MODIFIED, ICAP_BLOCKED, ICAP_FAILED.
   * Field introduced in 20.1.1.
   * @return action
   */
  public String getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Denotes whether the content was processed by icap server and an action was taken.
   * Enum options - ICAP_DISABLED, ICAP_PASSED, ICAP_MODIFIED, ICAP_BLOCKED, ICAP_FAILED.
   * Field introduced in 20.1.1.
   * @param action set the action.
   */
  public void setAction(String  action) {
    this.action = action;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Logs for the http request's content sent to the icap server.
   * Field introduced in 20.1.1.
   * @return requestLogs
   */
  public List<IcapRequestLog> getRequestLogs() {
    return requestLogs;
  }

  /**
   * This is the setter method. this will set the requestLogs
   * Logs for the http request's content sent to the icap server.
   * Field introduced in 20.1.1.
   * @return requestLogs
   */
  public void setRequestLogs(List<IcapRequestLog>  requestLogs) {
    this.requestLogs = requestLogs;
  }

  /**
   * This is the setter method this will set the requestLogs
   * Logs for the http request's content sent to the icap server.
   * Field introduced in 20.1.1.
   * @return requestLogs
   */
  public IcapLog addRequestLogsItem(IcapRequestLog requestLogsItem) {
    if (this.requestLogs == null) {
      this.requestLogs = new ArrayList<IcapRequestLog>();
    }
    this.requestLogs.add(requestLogsItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IcapLog objIcapLog = (IcapLog) o;
  return   Objects.equals(this.action, objIcapLog.action)&&
  Objects.equals(this.requestLogs, objIcapLog.requestLogs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IcapLog {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    requestLogs: ").append(toIndentedString(requestLogs)).append("\n");
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

