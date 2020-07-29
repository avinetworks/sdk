package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ApicVSPlacementReq is a POJO class extends AviRestResource that used for creating
 * ApicVSPlacementReq.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApicVSPlacementReq  {
    @JsonProperty("graph")
    private String graph = null;

    @JsonProperty("lifs")
    private List<Lif> lifs = null;

    @JsonProperty("network_rel")
    private List<APICNetworkRel> networkRel = null;

    @JsonProperty("tenant_name")
    private String tenantName = null;

    @JsonProperty("vdev")
    private String vdev = null;

    @JsonProperty("vgrp")
    private String vgrp = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property graph of obj type apicvsplacementreq field type str  type string.
   * @return graph
   */
  public String getGraph() {
    return graph;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property graph of obj type apicvsplacementreq field type str  type string.
   * @param graph set the graph.
   */
  public void setGraph(String  graph) {
    this.graph = graph;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property lifs of obj type apicvsplacementreq field type str  type array.
   * @return lifs
   */
  public List<Lif> getLifs() {
    return lifs;
  }

  /**
   * This is the setter method. this will set the lifs
   * Placeholder for description of property lifs of obj type apicvsplacementreq field type str  type array.
   * @return lifs
   */
  public void setLifs(List<Lif>  lifs) {
    this.lifs = lifs;
  }

  /**
   * This is the setter method this will set the lifs
   * Placeholder for description of property lifs of obj type apicvsplacementreq field type str  type array.
   * @return lifs
   */
  public ApicVSPlacementReq addLifsItem(Lif lifsItem) {
    if (this.lifs == null) {
      this.lifs = new ArrayList<Lif>();
    }
    this.lifs.add(lifsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property network_rel of obj type apicvsplacementreq field type str  type array.
   * @return networkRel
   */
  public List<APICNetworkRel> getNetworkRel() {
    return networkRel;
  }

  /**
   * This is the setter method. this will set the networkRel
   * Placeholder for description of property network_rel of obj type apicvsplacementreq field type str  type array.
   * @return networkRel
   */
  public void setNetworkRel(List<APICNetworkRel>  networkRel) {
    this.networkRel = networkRel;
  }

  /**
   * This is the setter method this will set the networkRel
   * Placeholder for description of property network_rel of obj type apicvsplacementreq field type str  type array.
   * @return networkRel
   */
  public ApicVSPlacementReq addNetworkRelItem(APICNetworkRel networkRelItem) {
    if (this.networkRel == null) {
      this.networkRel = new ArrayList<APICNetworkRel>();
    }
    this.networkRel.add(networkRelItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tenant_name of obj type apicvsplacementreq field type str  type string.
   * @return tenantName
   */
  public String getTenantName() {
    return tenantName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property tenant_name of obj type apicvsplacementreq field type str  type string.
   * @param tenantName set the tenantName.
   */
  public void setTenantName(String  tenantName) {
    this.tenantName = tenantName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vdev of obj type apicvsplacementreq field type str  type string.
   * @return vdev
   */
  public String getVdev() {
    return vdev;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vdev of obj type apicvsplacementreq field type str  type string.
   * @param vdev set the vdev.
   */
  public void setVdev(String  vdev) {
    this.vdev = vdev;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vgrp of obj type apicvsplacementreq field type str  type string.
   * @return vgrp
   */
  public String getVgrp() {
    return vgrp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vgrp of obj type apicvsplacementreq field type str  type string.
   * @param vgrp set the vgrp.
   */
  public void setVgrp(String  vgrp) {
    this.vgrp = vgrp;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ApicVSPlacementReq objApicVSPlacementReq = (ApicVSPlacementReq) o;
  return   Objects.equals(this.vdev, objApicVSPlacementReq.vdev)&&
  Objects.equals(this.graph, objApicVSPlacementReq.graph)&&
  Objects.equals(this.tenantName, objApicVSPlacementReq.tenantName)&&
  Objects.equals(this.lifs, objApicVSPlacementReq.lifs)&&
  Objects.equals(this.vgrp, objApicVSPlacementReq.vgrp)&&
  Objects.equals(this.networkRel, objApicVSPlacementReq.networkRel);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ApicVSPlacementReq {\n");
      sb.append("    graph: ").append(toIndentedString(graph)).append("\n");
        sb.append("    lifs: ").append(toIndentedString(lifs)).append("\n");
        sb.append("    networkRel: ").append(toIndentedString(networkRel)).append("\n");
        sb.append("    tenantName: ").append(toIndentedString(tenantName)).append("\n");
        sb.append("    vdev: ").append(toIndentedString(vdev)).append("\n");
        sb.append("    vgrp: ").append(toIndentedString(vgrp)).append("\n");
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

