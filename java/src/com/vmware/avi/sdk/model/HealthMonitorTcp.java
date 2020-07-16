package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HealthMonitorTcp is a POJO class extends AviRestResource that used for creating
 * HealthMonitorTcp.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthMonitorTcp  {
    @JsonProperty("maintenance_response")
    private String maintenanceResponse = null;

    @JsonProperty("tcp_half_open")
    private Boolean tcpHalfOpen = false;

    @JsonProperty("tcp_request")
    private String tcpRequest = null;

    @JsonProperty("tcp_response")
    private String tcpResponse = null;



  /**
   * This is the getter method this will return the attribute value.
   * Match or look for this keyword in the first 2kb of server's response indicating server maintenance.
   * A successful match results in the server being marked down.
   * @return maintenanceResponse
   */
  public String getMaintenanceResponse() {
    return maintenanceResponse;
  }

  /**
   * This is the setter method to the attribute.
   * Match or look for this keyword in the first 2kb of server's response indicating server maintenance.
   * A successful match results in the server being marked down.
   * @param maintenanceResponse set the maintenanceResponse.
   */
  public void setMaintenanceResponse(String  maintenanceResponse) {
    this.maintenanceResponse = maintenanceResponse;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure tcp health monitor to use half-open tcp connections to monitor the health of backend servers thereby avoiding consumption of a full
   * fledged server side connection and the overhead and logs associated with it.
   * This method is light-weight as it makes use of listener in server's kernel layer to measure the health and a child socket or user thread is not
   * created on the server side.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return tcpHalfOpen
   */
  public Boolean getTcpHalfOpen() {
    return tcpHalfOpen;
  }

  /**
   * This is the setter method to the attribute.
   * Configure tcp health monitor to use half-open tcp connections to monitor the health of backend servers thereby avoiding consumption of a full
   * fledged server side connection and the overhead and logs associated with it.
   * This method is light-weight as it makes use of listener in server's kernel layer to measure the health and a child socket or user thread is not
   * created on the server side.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param tcpHalfOpen set the tcpHalfOpen.
   */
  public void setTcpHalfOpen(Boolean  tcpHalfOpen) {
    this.tcpHalfOpen = tcpHalfOpen;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Request data to send after completing the tcp handshake.
   * @return tcpRequest
   */
  public String getTcpRequest() {
    return tcpRequest;
  }

  /**
   * This is the setter method to the attribute.
   * Request data to send after completing the tcp handshake.
   * @param tcpRequest set the tcpRequest.
   */
  public void setTcpRequest(String  tcpRequest) {
    this.tcpRequest = tcpRequest;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Match for the desired keyword in the first 2kb of the server's tcp response.
   * If this field is left blank, no server response is required.
   * @return tcpResponse
   */
  public String getTcpResponse() {
    return tcpResponse;
  }

  /**
   * This is the setter method to the attribute.
   * Match for the desired keyword in the first 2kb of the server's tcp response.
   * If this field is left blank, no server response is required.
   * @param tcpResponse set the tcpResponse.
   */
  public void setTcpResponse(String  tcpResponse) {
    this.tcpResponse = tcpResponse;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HealthMonitorTcp objHealthMonitorTcp = (HealthMonitorTcp) o;
  return   Objects.equals(this.tcpRequest, objHealthMonitorTcp.tcpRequest)&&
  Objects.equals(this.tcpResponse, objHealthMonitorTcp.tcpResponse)&&
  Objects.equals(this.tcpHalfOpen, objHealthMonitorTcp.tcpHalfOpen)&&
  Objects.equals(this.maintenanceResponse, objHealthMonitorTcp.maintenanceResponse);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HealthMonitorTcp {\n");
      sb.append("    maintenanceResponse: ").append(toIndentedString(maintenanceResponse)).append("\n");
        sb.append("    tcpHalfOpen: ").append(toIndentedString(tcpHalfOpen)).append("\n");
        sb.append("    tcpRequest: ").append(toIndentedString(tcpRequest)).append("\n");
        sb.append("    tcpResponse: ").append(toIndentedString(tcpResponse)).append("\n");
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

