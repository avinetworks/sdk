package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Service is a POJO class extends AviRestResource that used for creating
 * Service.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Service  {
    @JsonProperty("enable_http2")
    private Boolean enableHttp2 = false;

    @JsonProperty("enable_ssl")
    private Boolean enableSsl = false;

    @JsonProperty("override_application_profile_ref")
    private String overrideApplicationProfileRef = null;

    @JsonProperty("override_network_profile_ref")
    private String overrideNetworkProfileRef = null;

    @JsonProperty("port")
    private Integer port = null;

    @JsonProperty("port_range_end")
    private Integer portRangeEnd = 0;



  /**
   * This is the getter method this will return the attribute value.
   * Enable http2 on this port.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableHttp2
   */
  public Boolean getEnableHttp2() {
    return enableHttp2;
  }

  /**
   * This is the setter method to the attribute.
   * Enable http2 on this port.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableHttp2 set the enableHttp2.
   */
  public void setEnableHttp2(Boolean  enableHttp2) {
    this.enableHttp2 = enableHttp2;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable ssl termination and offload for traffic from clients.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableSsl
   */
  public Boolean getEnableSsl() {
    return enableSsl;
  }

  /**
   * This is the setter method to the attribute.
   * Enable ssl termination and offload for traffic from clients.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableSsl set the enableSsl.
   */
  public void setEnableSsl(Boolean  enableSsl) {
    this.enableSsl = enableSsl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable application layer specific features for the this specific service.
   * It is a reference to an object of type applicationprofile.
   * Field introduced in 17.2.4.
   * @return overrideApplicationProfileRef
   */
  public String getOverrideApplicationProfileRef() {
    return overrideApplicationProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Enable application layer specific features for the this specific service.
   * It is a reference to an object of type applicationprofile.
   * Field introduced in 17.2.4.
   * @param overrideApplicationProfileRef set the overrideApplicationProfileRef.
   */
  public void setOverrideApplicationProfileRef(String  overrideApplicationProfileRef) {
    this.overrideApplicationProfileRef = overrideApplicationProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Override the network profile for this specific service port.
   * It is a reference to an object of type networkprofile.
   * @return overrideNetworkProfileRef
   */
  public String getOverrideNetworkProfileRef() {
    return overrideNetworkProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Override the network profile for this specific service port.
   * It is a reference to an object of type networkprofile.
   * @param overrideNetworkProfileRef set the overrideNetworkProfileRef.
   */
  public void setOverrideNetworkProfileRef(String  overrideNetworkProfileRef) {
    this.overrideNetworkProfileRef = overrideNetworkProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The virtual service's port number.
   * Allowed values are 0-65535.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * The virtual service's port number.
   * Allowed values are 0-65535.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The end of the virtual service's port number range.
   * Allowed values are 1-65535.
   * Special values are 0- 'single port'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return portRangeEnd
   */
  public Integer getPortRangeEnd() {
    return portRangeEnd;
  }

  /**
   * This is the setter method to the attribute.
   * The end of the virtual service's port number range.
   * Allowed values are 1-65535.
   * Special values are 0- 'single port'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param portRangeEnd set the portRangeEnd.
   */
  public void setPortRangeEnd(Integer  portRangeEnd) {
    this.portRangeEnd = portRangeEnd;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Service objService = (Service) o;
  return   Objects.equals(this.port, objService.port)&&
  Objects.equals(this.enableSsl, objService.enableSsl)&&
  Objects.equals(this.overrideNetworkProfileRef, objService.overrideNetworkProfileRef)&&
  Objects.equals(this.portRangeEnd, objService.portRangeEnd)&&
  Objects.equals(this.overrideApplicationProfileRef, objService.overrideApplicationProfileRef)&&
  Objects.equals(this.enableHttp2, objService.enableHttp2);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Service {\n");
      sb.append("    enableHttp2: ").append(toIndentedString(enableHttp2)).append("\n");
        sb.append("    enableSsl: ").append(toIndentedString(enableSsl)).append("\n");
        sb.append("    overrideApplicationProfileRef: ").append(toIndentedString(overrideApplicationProfileRef)).append("\n");
        sb.append("    overrideNetworkProfileRef: ").append(toIndentedString(overrideNetworkProfileRef)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    portRangeEnd: ").append(toIndentedString(portRangeEnd)).append("\n");
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

