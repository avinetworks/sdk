package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeHmEventShmDetails is a POJO class extends AviRestResource that used for creating
 * SeHmEventShmDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeHmEventShmDetails  {
    @JsonProperty("average_response_time")
    private Integer averageResponseTime = null;

    @JsonProperty("health_monitor")
    private String healthMonitor = null;

    @JsonProperty("resp_string")
    private String respString = null;

    @JsonProperty("response_code")
    private Integer responseCode = null;



  /**
   * This is the getter method this will return the attribute value.
   * Average health monitor response time from server in milli-seconds.
   * @return averageResponseTime
   */
  public Integer getAverageResponseTime() {
    return averageResponseTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average health monitor response time from server in milli-seconds.
   * @param averageResponseTime set the averageResponseTime.
   */
  public void setAverageResponseTime(Integer  averageResponseTime) {
    this.averageResponseTime = averageResponseTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Health monitor name.
   * It is a reference to an object of type healthmonitor.
   * @return healthMonitor
   */
  public String getHealthMonitor() {
    return healthMonitor;
  }

  /**
   * This is the setter method to the attribute.
   * Health monitor name.
   * It is a reference to an object of type healthmonitor.
   * @param healthMonitor set the healthMonitor.
   */
  public void setHealthMonitor(String  healthMonitor) {
    this.healthMonitor = healthMonitor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property resp_string of obj type sehmeventshmdetails field type str  type string.
   * @return respString
   */
  public String getRespString() {
    return respString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property resp_string of obj type sehmeventshmdetails field type str  type string.
   * @param respString set the respString.
   */
  public void setRespString(String  respString) {
    this.respString = respString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Response code from server.
   * Field introduced in 17.2.4.
   * @return responseCode
   */
  public Integer getResponseCode() {
    return responseCode;
  }

  /**
   * This is the setter method to the attribute.
   * Response code from server.
   * Field introduced in 17.2.4.
   * @param responseCode set the responseCode.
   */
  public void setResponseCode(Integer  responseCode) {
    this.responseCode = responseCode;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeHmEventShmDetails objSeHmEventShmDetails = (SeHmEventShmDetails) o;
  return   Objects.equals(this.responseCode, objSeHmEventShmDetails.responseCode)&&
  Objects.equals(this.respString, objSeHmEventShmDetails.respString)&&
  Objects.equals(this.averageResponseTime, objSeHmEventShmDetails.averageResponseTime)&&
  Objects.equals(this.healthMonitor, objSeHmEventShmDetails.healthMonitor);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeHmEventShmDetails {\n");
      sb.append("    averageResponseTime: ").append(toIndentedString(averageResponseTime)).append("\n");
        sb.append("    healthMonitor: ").append(toIndentedString(healthMonitor)).append("\n");
        sb.append("    respString: ").append(toIndentedString(respString)).append("\n");
        sb.append("    responseCode: ").append(toIndentedString(responseCode)).append("\n");
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

