package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GCPVIPAllocation is a POJO class extends AviRestResource that used for creating
 * GCPVIPAllocation.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GCPVIPAllocation  {
    @JsonProperty("ilb")
    private GCPVIPILB ilb = null;

    @JsonProperty("mode")
    private String mode = "ROUTES";

    @JsonProperty("routes")
    private GCPVIPRoutes routes = null;



  /**
   * This is the getter method this will return the attribute value.
   * Configure google cloud internal loadbalancer for vip.
   * The vip will be auto allocated from a google cloud vpc subnet.
   * Field introduced in 20.1.1.
   * @return ilb
   */
  public GCPVIPILB getIlb() {
    return ilb;
  }

  /**
   * This is the setter method to the attribute.
   * Configure google cloud internal loadbalancer for vip.
   * The vip will be auto allocated from a google cloud vpc subnet.
   * Field introduced in 20.1.1.
   * @param ilb set the ilb.
   */
  public void setIlb(GCPVIPILB ilb) {
    this.ilb = ilb;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vip allocation mode.
   * Enum options - ROUTES, ILB.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as ROUTES.
   * @return mode
   */
  public String getMode() {
    return mode;
  }

  /**
   * This is the setter method to the attribute.
   * Vip allocation mode.
   * Enum options - ROUTES, ILB.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as ROUTES.
   * @param mode set the mode.
   */
  public void setMode(String  mode) {
    this.mode = mode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure google cloud vpc routes for vip.
   * The vip can either be a static ip or auto allocted from avi internal network.
   * The vip should not overlap with any of the subnet ranges in google cloud vpc.
   * Field introduced in 20.1.1.
   * @return routes
   */
  public GCPVIPRoutes getRoutes() {
    return routes;
  }

  /**
   * This is the setter method to the attribute.
   * Configure google cloud vpc routes for vip.
   * The vip can either be a static ip or auto allocted from avi internal network.
   * The vip should not overlap with any of the subnet ranges in google cloud vpc.
   * Field introduced in 20.1.1.
   * @param routes set the routes.
   */
  public void setRoutes(GCPVIPRoutes routes) {
    this.routes = routes;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GCPVIPAllocation objGCPVIPAllocation = (GCPVIPAllocation) o;
  return   Objects.equals(this.mode, objGCPVIPAllocation.mode)&&
  Objects.equals(this.routes, objGCPVIPAllocation.routes)&&
  Objects.equals(this.ilb, objGCPVIPAllocation.ilb);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GCPVIPAllocation {\n");
      sb.append("    ilb: ").append(toIndentedString(ilb)).append("\n");
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("    routes: ").append(toIndentedString(routes)).append("\n");
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

