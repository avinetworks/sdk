package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The InternalGatewayMonitor is a POJO class extends AviRestResource that used for creating
 * InternalGatewayMonitor.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternalGatewayMonitor  {
    @JsonProperty("disable_gateway_monitor")
    private Boolean disableGatewayMonitor = false;

    @JsonProperty("gateway_monitor_failure_threshold")
    private Integer gatewayMonitorFailureThreshold = 10;

    @JsonProperty("gateway_monitor_interval")
    private Integer gatewayMonitorInterval = 1000;

    @JsonProperty("gateway_monitor_success_threshold")
    private Integer gatewayMonitorSuccessThreshold = 15;



  /**
   * This is the getter method this will return the attribute value.
   * Disable the gateway monitor for default gateway.
   * They are monitored by default.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableGatewayMonitor
   */
  public Boolean getDisableGatewayMonitor() {
    return disableGatewayMonitor;
  }

  /**
   * This is the setter method to the attribute.
   * Disable the gateway monitor for default gateway.
   * They are monitored by default.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableGatewayMonitor set the disableGatewayMonitor.
   */
  public void setDisableGatewayMonitor(Boolean  disableGatewayMonitor) {
    this.disableGatewayMonitor = disableGatewayMonitor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The number of consecutive failed gateway health checks before a gateway is marked down.
   * Allowed values are 3-50.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return gatewayMonitorFailureThreshold
   */
  public Integer getGatewayMonitorFailureThreshold() {
    return gatewayMonitorFailureThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * The number of consecutive failed gateway health checks before a gateway is marked down.
   * Allowed values are 3-50.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param gatewayMonitorFailureThreshold set the gatewayMonitorFailureThreshold.
   */
  public void setGatewayMonitorFailureThreshold(Integer  gatewayMonitorFailureThreshold) {
    this.gatewayMonitorFailureThreshold = gatewayMonitorFailureThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The interval between two ping requests sent by the gateway monitor in milliseconds.
   * If a value is not specified, requests are sent every second.
   * Allowed values are 100-60000.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @return gatewayMonitorInterval
   */
  public Integer getGatewayMonitorInterval() {
    return gatewayMonitorInterval;
  }

  /**
   * This is the setter method to the attribute.
   * The interval between two ping requests sent by the gateway monitor in milliseconds.
   * If a value is not specified, requests are sent every second.
   * Allowed values are 100-60000.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @param gatewayMonitorInterval set the gatewayMonitorInterval.
   */
  public void setGatewayMonitorInterval(Integer  gatewayMonitorInterval) {
    this.gatewayMonitorInterval = gatewayMonitorInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The number of consecutive successful gateway health checks before a gateway that was marked down by the gateway monitor is marked up.
   * Allowed values are 3-50.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 15.
   * @return gatewayMonitorSuccessThreshold
   */
  public Integer getGatewayMonitorSuccessThreshold() {
    return gatewayMonitorSuccessThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * The number of consecutive successful gateway health checks before a gateway that was marked down by the gateway monitor is marked up.
   * Allowed values are 3-50.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 15.
   * @param gatewayMonitorSuccessThreshold set the gatewayMonitorSuccessThreshold.
   */
  public void setGatewayMonitorSuccessThreshold(Integer  gatewayMonitorSuccessThreshold) {
    this.gatewayMonitorSuccessThreshold = gatewayMonitorSuccessThreshold;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  InternalGatewayMonitor objInternalGatewayMonitor = (InternalGatewayMonitor) o;
  return   Objects.equals(this.gatewayMonitorSuccessThreshold, objInternalGatewayMonitor.gatewayMonitorSuccessThreshold)&&
  Objects.equals(this.gatewayMonitorFailureThreshold, objInternalGatewayMonitor.gatewayMonitorFailureThreshold)&&
  Objects.equals(this.disableGatewayMonitor, objInternalGatewayMonitor.disableGatewayMonitor)&&
  Objects.equals(this.gatewayMonitorInterval, objInternalGatewayMonitor.gatewayMonitorInterval);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class InternalGatewayMonitor {\n");
      sb.append("    disableGatewayMonitor: ").append(toIndentedString(disableGatewayMonitor)).append("\n");
        sb.append("    gatewayMonitorFailureThreshold: ").append(toIndentedString(gatewayMonitorFailureThreshold)).append("\n");
        sb.append("    gatewayMonitorInterval: ").append(toIndentedString(gatewayMonitorInterval)).append("\n");
        sb.append("    gatewayMonitorSuccessThreshold: ").append(toIndentedString(gatewayMonitorSuccessThreshold)).append("\n");
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

