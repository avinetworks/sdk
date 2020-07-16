package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VinfraDiscSummaryDetails is a POJO class extends AviRestResource that used for creating
 * VinfraDiscSummaryDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VinfraDiscSummaryDetails  {
    @JsonProperty("num_clusters")
    private Integer numClusters = null;

    @JsonProperty("num_dcs")
    private Integer numDcs = null;

    @JsonProperty("num_hosts")
    private Integer numHosts = null;

    @JsonProperty("num_nws")
    private Integer numNws = null;

    @JsonProperty("num_vms")
    private Integer numVms = null;

    @JsonProperty("vcenter")
    private String vcenter = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_clusters of obj type vinfradiscsummarydetails field type str  type integer.
   * @return numClusters
   */
  public Integer getNumClusters() {
    return numClusters;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_clusters of obj type vinfradiscsummarydetails field type str  type integer.
   * @param numClusters set the numClusters.
   */
  public void setNumClusters(Integer  numClusters) {
    this.numClusters = numClusters;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_dcs of obj type vinfradiscsummarydetails field type str  type integer.
   * @return numDcs
   */
  public Integer getNumDcs() {
    return numDcs;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_dcs of obj type vinfradiscsummarydetails field type str  type integer.
   * @param numDcs set the numDcs.
   */
  public void setNumDcs(Integer  numDcs) {
    this.numDcs = numDcs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_hosts of obj type vinfradiscsummarydetails field type str  type integer.
   * @return numHosts
   */
  public Integer getNumHosts() {
    return numHosts;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_hosts of obj type vinfradiscsummarydetails field type str  type integer.
   * @param numHosts set the numHosts.
   */
  public void setNumHosts(Integer  numHosts) {
    this.numHosts = numHosts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_nws of obj type vinfradiscsummarydetails field type str  type integer.
   * @return numNws
   */
  public Integer getNumNws() {
    return numNws;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_nws of obj type vinfradiscsummarydetails field type str  type integer.
   * @param numNws set the numNws.
   */
  public void setNumNws(Integer  numNws) {
    this.numNws = numNws;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_vms of obj type vinfradiscsummarydetails field type str  type integer.
   * @return numVms
   */
  public Integer getNumVms() {
    return numVms;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_vms of obj type vinfradiscsummarydetails field type str  type integer.
   * @param numVms set the numVms.
   */
  public void setNumVms(Integer  numVms) {
    this.numVms = numVms;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter of obj type vinfradiscsummarydetails field type str  type string.
   * @return vcenter
   */
  public String getVcenter() {
    return vcenter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter of obj type vinfradiscsummarydetails field type str  type string.
   * @param vcenter set the vcenter.
   */
  public void setVcenter(String  vcenter) {
    this.vcenter = vcenter;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VinfraDiscSummaryDetails objVinfraDiscSummaryDetails = (VinfraDiscSummaryDetails) o;
  return   Objects.equals(this.numVms, objVinfraDiscSummaryDetails.numVms)&&
  Objects.equals(this.numNws, objVinfraDiscSummaryDetails.numNws)&&
  Objects.equals(this.numClusters, objVinfraDiscSummaryDetails.numClusters)&&
  Objects.equals(this.vcenter, objVinfraDiscSummaryDetails.vcenter)&&
  Objects.equals(this.numDcs, objVinfraDiscSummaryDetails.numDcs)&&
  Objects.equals(this.numHosts, objVinfraDiscSummaryDetails.numHosts);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VinfraDiscSummaryDetails {\n");
      sb.append("    numClusters: ").append(toIndentedString(numClusters)).append("\n");
        sb.append("    numDcs: ").append(toIndentedString(numDcs)).append("\n");
        sb.append("    numHosts: ").append(toIndentedString(numHosts)).append("\n");
        sb.append("    numNws: ").append(toIndentedString(numNws)).append("\n");
        sb.append("    numVms: ").append(toIndentedString(numVms)).append("\n");
        sb.append("    vcenter: ").append(toIndentedString(vcenter)).append("\n");
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

