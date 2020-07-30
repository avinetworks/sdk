package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VinfraVcenterConnectivityStatus is a POJO class extends AviRestResource that used for creating
 * VinfraVcenterConnectivityStatus.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VinfraVcenterConnectivityStatus  {
    @JsonProperty("cloud")
    private String cloud = null;

    @JsonProperty("datacenter")
    private String datacenter = null;

    @JsonProperty("vcenter")
    private String vcenter = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cloud of obj type vinfravcenterconnectivitystatus field type str  type string.
   * @return cloud
   */
  public String getCloud() {
    return cloud;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cloud of obj type vinfravcenterconnectivitystatus field type str  type string.
   * @param cloud set the cloud.
   */
  public void setCloud(String  cloud) {
    this.cloud = cloud;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property datacenter of obj type vinfravcenterconnectivitystatus field type str  type string.
   * @return datacenter
   */
  public String getDatacenter() {
    return datacenter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property datacenter of obj type vinfravcenterconnectivitystatus field type str  type string.
   * @param datacenter set the datacenter.
   */
  public void setDatacenter(String  datacenter) {
    this.datacenter = datacenter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter of obj type vinfravcenterconnectivitystatus field type str  type string.
   * @return vcenter
   */
  public String getVcenter() {
    return vcenter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter of obj type vinfravcenterconnectivitystatus field type str  type string.
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
  VinfraVcenterConnectivityStatus objVinfraVcenterConnectivityStatus = (VinfraVcenterConnectivityStatus) o;
  return   Objects.equals(this.vcenter, objVinfraVcenterConnectivityStatus.vcenter)&&
  Objects.equals(this.datacenter, objVinfraVcenterConnectivityStatus.datacenter)&&
  Objects.equals(this.cloud, objVinfraVcenterConnectivityStatus.cloud);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VinfraVcenterConnectivityStatus {\n");
      sb.append("    cloud: ").append(toIndentedString(cloud)).append("\n");
        sb.append("    datacenter: ").append(toIndentedString(datacenter)).append("\n");
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

