package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ServerConfig is a POJO class extends AviRestResource that used for creating
 * ServerConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerConfig  {
    @JsonProperty("def_port")
    private Boolean defPort = null;

    @JsonProperty("hostname")
    private String hostname = null;

    @JsonProperty("ip_addr")
    private IpAddr ipAddr = null;

    @JsonProperty("is_enabled")
    private Boolean isEnabled = null;

    @JsonProperty("last_state")
    private String lastState = "OPER_UNAVAIL";

    @JsonProperty("location")
    private GeoLocation location = null;

    @JsonProperty("oper_status")
    private OperationalStatus operStatus = null;

    @JsonProperty("port")
    private Integer port = null;

    @JsonProperty("propogate_state")
    private Boolean propogateState = null;

    @JsonProperty("timer_exists")
    private Boolean timerExists = false;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property def_port of obj type serverconfig field type str  type boolean.
   * @return defPort
   */
  public Boolean getDefPort() {
    return defPort;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property def_port of obj type serverconfig field type str  type boolean.
   * @param defPort set the defPort.
   */
  public void setDefPort(Boolean  defPort) {
    this.defPort = defPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property hostname of obj type serverconfig field type str  type string.
   * @return hostname
   */
  public String getHostname() {
    return hostname;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property hostname of obj type serverconfig field type str  type string.
   * @param hostname set the hostname.
   */
  public void setHostname(String  hostname) {
    this.hostname = hostname;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip_addr of obj type serverconfig field type str  type ref.
   * @return ipAddr
   */
  public IpAddr getIpAddr() {
    return ipAddr;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip_addr of obj type serverconfig field type str  type ref.
   * @param ipAddr set the ipAddr.
   */
  public void setIpAddr(IpAddr ipAddr) {
    this.ipAddr = ipAddr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property is_enabled of obj type serverconfig field type str  type boolean.
   * @return isEnabled
   */
  public Boolean getIsEnabled() {
    return isEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_enabled of obj type serverconfig field type str  type boolean.
   * @param isEnabled set the isEnabled.
   */
  public void setIsEnabled(Boolean  isEnabled) {
    this.isEnabled = isEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - OPER_UP, OPER_DOWN, OPER_CREATING, OPER_RESOURCES, OPER_INACTIVE, OPER_DISABLED, OPER_UNUSED, OPER_UNKNOWN, OPER_PROCESSING,
   * OPER_INITIALIZING, OPER_ERROR_DISABLED, OPER_AWAIT_MANUAL_PLACEMENT, OPER_UPGRADING, OPER_SE_PROCESSING, OPER_PARTITIONED, OPER_DISABLING,
   * OPER_FAILED, OPER_UNAVAIL.
   * Default value when not specified in API or module is interpreted by Avi Controller as OPER_UNAVAIL.
   * @return lastState
   */
  public String getLastState() {
    return lastState;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - OPER_UP, OPER_DOWN, OPER_CREATING, OPER_RESOURCES, OPER_INACTIVE, OPER_DISABLED, OPER_UNUSED, OPER_UNKNOWN, OPER_PROCESSING,
   * OPER_INITIALIZING, OPER_ERROR_DISABLED, OPER_AWAIT_MANUAL_PLACEMENT, OPER_UPGRADING, OPER_SE_PROCESSING, OPER_PARTITIONED, OPER_DISABLING,
   * OPER_FAILED, OPER_UNAVAIL.
   * Default value when not specified in API or module is interpreted by Avi Controller as OPER_UNAVAIL.
   * @param lastState set the lastState.
   */
  public void setLastState(String  lastState) {
    this.lastState = lastState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtualservice member in case this server is a member of gs group, and geo location available.
   * @return location
   */
  public GeoLocation getLocation() {
    return location;
  }

  /**
   * This is the setter method to the attribute.
   * Virtualservice member in case this server is a member of gs group, and geo location available.
   * @param location set the location.
   */
  public void setLocation(GeoLocation location) {
    this.location = location;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property oper_status of obj type serverconfig field type str  type ref.
   * @return operStatus
   */
  public OperationalStatus getOperStatus() {
    return operStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property oper_status of obj type serverconfig field type str  type ref.
   * @param operStatus set the operStatus.
   */
  public void setOperStatus(OperationalStatus operStatus) {
    this.operStatus = operStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property port of obj type serverconfig field type str  type integer.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property port of obj type serverconfig field type str  type integer.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If this is set, propogate this server state to other ses for this vs.
   * Applicable to eastwest vs and gs hm-sharding.
   * @return propogateState
   */
  public Boolean getPropogateState() {
    return propogateState;
  }

  /**
   * This is the setter method to the attribute.
   * If this is set, propogate this server state to other ses for this vs.
   * Applicable to eastwest vs and gs hm-sharding.
   * @param propogateState set the propogateState.
   */
  public void setPropogateState(Boolean  propogateState) {
    this.propogateState = propogateState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property timer_exists of obj type serverconfig field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return timerExists
   */
  public Boolean getTimerExists() {
    return timerExists;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property timer_exists of obj type serverconfig field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param timerExists set the timerExists.
   */
  public void setTimerExists(Boolean  timerExists) {
    this.timerExists = timerExists;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ServerConfig objServerConfig = (ServerConfig) o;
  return   Objects.equals(this.isEnabled, objServerConfig.isEnabled)&&
  Objects.equals(this.lastState, objServerConfig.lastState)&&
  Objects.equals(this.ipAddr, objServerConfig.ipAddr)&&
  Objects.equals(this.hostname, objServerConfig.hostname)&&
  Objects.equals(this.propogateState, objServerConfig.propogateState)&&
  Objects.equals(this.operStatus, objServerConfig.operStatus)&&
  Objects.equals(this.location, objServerConfig.location)&&
  Objects.equals(this.defPort, objServerConfig.defPort)&&
  Objects.equals(this.timerExists, objServerConfig.timerExists)&&
  Objects.equals(this.port, objServerConfig.port);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ServerConfig {\n");
      sb.append("    defPort: ").append(toIndentedString(defPort)).append("\n");
        sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
        sb.append("    ipAddr: ").append(toIndentedString(ipAddr)).append("\n");
        sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
        sb.append("    lastState: ").append(toIndentedString(lastState)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    operStatus: ").append(toIndentedString(operStatus)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    propogateState: ").append(toIndentedString(propogateState)).append("\n");
        sb.append("    timerExists: ").append(toIndentedString(timerExists)).append("\n");
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

