package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The StaticRoute is a POJO class extends AviRestResource that used for creating
 * StaticRoute.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StaticRoute  {
    @JsonProperty("disable_gateway_monitor")
    private Boolean disableGatewayMonitor = null;

    @JsonProperty("if_name")
    private String ifName = null;

    @JsonProperty("next_hop")
    private IpAddr nextHop = null;

    @JsonProperty("prefix")
    private IpAddrPrefix prefix = null;

    @JsonProperty("route_id")
    private String routeId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Disable the gateway monitor for default gateway.
   * They are monitored by default.
   * Field introduced in 17.1.1.
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
   * @param disableGatewayMonitor set the disableGatewayMonitor.
   */
  public void setDisableGatewayMonitor(Boolean  disableGatewayMonitor) {
    this.disableGatewayMonitor = disableGatewayMonitor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property if_name of obj type staticroute field type str  type string.
   * @return ifName
   */
  public String getIfName() {
    return ifName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property if_name of obj type staticroute field type str  type string.
   * @param ifName set the ifName.
   */
  public void setIfName(String  ifName) {
    this.ifName = ifName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property next_hop of obj type staticroute field type str  type ref.
   * @return nextHop
   */
  public IpAddr getNextHop() {
    return nextHop;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property next_hop of obj type staticroute field type str  type ref.
   * @param nextHop set the nextHop.
   */
  public void setNextHop(IpAddr nextHop) {
    this.nextHop = nextHop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property prefix of obj type staticroute field type str  type ref.
   * @return prefix
   */
  public IpAddrPrefix getPrefix() {
    return prefix;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property prefix of obj type staticroute field type str  type ref.
   * @param prefix set the prefix.
   */
  public void setPrefix(IpAddrPrefix prefix) {
    this.prefix = prefix;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property route_id of obj type staticroute field type str  type string.
   * @return routeId
   */
  public String getRouteId() {
    return routeId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property route_id of obj type staticroute field type str  type string.
   * @param routeId set the routeId.
   */
  public void setRouteId(String  routeId) {
    this.routeId = routeId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  StaticRoute objStaticRoute = (StaticRoute) o;
  return   Objects.equals(this.routeId, objStaticRoute.routeId)&&
  Objects.equals(this.prefix, objStaticRoute.prefix)&&
  Objects.equals(this.nextHop, objStaticRoute.nextHop)&&
  Objects.equals(this.ifName, objStaticRoute.ifName)&&
  Objects.equals(this.disableGatewayMonitor, objStaticRoute.disableGatewayMonitor);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class StaticRoute {\n");
      sb.append("    disableGatewayMonitor: ").append(toIndentedString(disableGatewayMonitor)).append("\n");
        sb.append("    ifName: ").append(toIndentedString(ifName)).append("\n");
        sb.append("    nextHop: ").append(toIndentedString(nextHop)).append("\n");
        sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
        sb.append("    routeId: ").append(toIndentedString(routeId)).append("\n");
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

