package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HealthMonitorUdp is a POJO class extends AviRestResource that used for creating
 * HealthMonitorUdp.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthMonitorUdp  {
    @JsonProperty("maintenance_response")
    private String maintenanceResponse = null;

    @JsonProperty("udp_request")
    private String udpRequest = null;

    @JsonProperty("udp_response")
    private String udpResponse = null;



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
   * Send udp request.
   * @return udpRequest
   */
  public String getUdpRequest() {
    return udpRequest;
  }

  /**
   * This is the setter method to the attribute.
   * Send udp request.
   * @param udpRequest set the udpRequest.
   */
  public void setUdpRequest(String  udpRequest) {
    this.udpRequest = udpRequest;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Match for keyword in the udp response.
   * @return udpResponse
   */
  public String getUdpResponse() {
    return udpResponse;
  }

  /**
   * This is the setter method to the attribute.
   * Match for keyword in the udp response.
   * @param udpResponse set the udpResponse.
   */
  public void setUdpResponse(String  udpResponse) {
    this.udpResponse = udpResponse;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HealthMonitorUdp objHealthMonitorUdp = (HealthMonitorUdp) o;
  return   Objects.equals(this.udpRequest, objHealthMonitorUdp.udpRequest)&&
  Objects.equals(this.udpResponse, objHealthMonitorUdp.udpResponse)&&
  Objects.equals(this.maintenanceResponse, objHealthMonitorUdp.maintenanceResponse);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HealthMonitorUdp {\n");
      sb.append("    maintenanceResponse: ").append(toIndentedString(maintenanceResponse)).append("\n");
        sb.append("    udpRequest: ").append(toIndentedString(udpRequest)).append("\n");
        sb.append("    udpResponse: ").append(toIndentedString(udpResponse)).append("\n");
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

