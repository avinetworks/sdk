package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The vNICNetwork is a POJO class extends AviRestResource that used for creating
 * vNICNetwork.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class vNICNetwork  {
    @JsonProperty("ctlr_alloc")
    private Boolean ctlrAlloc = false;

    @JsonProperty("ip")
    private IpAddrPrefix ip = null;

    @JsonProperty("mode")
    private String mode = "DHCP";



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ctlr_alloc of obj type vnicnetwork field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return ctlrAlloc
   */
  public Boolean getCtlrAlloc() {
    return ctlrAlloc;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ctlr_alloc of obj type vnicnetwork field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param ctlrAlloc set the ctlrAlloc.
   */
  public void setCtlrAlloc(Boolean  ctlrAlloc) {
    this.ctlrAlloc = ctlrAlloc;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip of obj type vnicnetwork field type str  type ref.
   * @return ip
   */
  public IpAddrPrefix getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip of obj type vnicnetwork field type str  type ref.
   * @param ip set the ip.
   */
  public void setIp(IpAddrPrefix ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - DHCP, STATIC, VIP, DOCKER_HOST.
   * Default value when not specified in API or module is interpreted by Avi Controller as DHCP.
   * @return mode
   */
  public String getMode() {
    return mode;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - DHCP, STATIC, VIP, DOCKER_HOST.
   * Default value when not specified in API or module is interpreted by Avi Controller as DHCP.
   * @param mode set the mode.
   */
  public void setMode(String  mode) {
    this.mode = mode;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  vNICNetwork objvNICNetwork = (vNICNetwork) o;
  return   Objects.equals(this.ip, objvNICNetwork.ip)&&
  Objects.equals(this.ctlrAlloc, objvNICNetwork.ctlrAlloc)&&
  Objects.equals(this.mode, objvNICNetwork.mode);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class vNICNetwork {\n");
      sb.append("    ctlrAlloc: ").append(toIndentedString(ctlrAlloc)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
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

