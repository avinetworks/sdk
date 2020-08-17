package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PlacementScopeConfig is a POJO class extends AviRestResource that used for creating
 * PlacementScopeConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlacementScopeConfig  {
    @JsonProperty("nsxt_hosts")
    private NsxtHosts nsxtHosts = null;

    @JsonProperty("vcenter_folder")
    private String vcenterFolder = null;

    @JsonProperty("vcenter_ref")
    private String vcenterRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * List of transport nodes include or exclude.
   * Field introduced in 20.1.1.
   * @return nsxtHosts
   */
  public NsxtHosts getNsxtHosts() {
    return nsxtHosts;
  }

  /**
   * This is the setter method to the attribute.
   * List of transport nodes include or exclude.
   * Field introduced in 20.1.1.
   * @param nsxtHosts set the nsxtHosts.
   */
  public void setNsxtHosts(NsxtHosts nsxtHosts) {
    this.nsxtHosts = nsxtHosts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Folder to place all the service engine virtual machines in vcenter.
   * Field introduced in 20.1.1.
   * @return vcenterFolder
   */
  public String getVcenterFolder() {
    return vcenterFolder;
  }

  /**
   * This is the setter method to the attribute.
   * Folder to place all the service engine virtual machines in vcenter.
   * Field introduced in 20.1.1.
   * @param vcenterFolder set the vcenterFolder.
   */
  public void setVcenterFolder(String  vcenterFolder) {
    this.vcenterFolder = vcenterFolder;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vcenter server configuration.
   * It is a reference to an object of type vcenterserver.
   * Field introduced in 20.1.1.
   * @return vcenterRef
   */
  public String getVcenterRef() {
    return vcenterRef;
  }

  /**
   * This is the setter method to the attribute.
   * Vcenter server configuration.
   * It is a reference to an object of type vcenterserver.
   * Field introduced in 20.1.1.
   * @param vcenterRef set the vcenterRef.
   */
  public void setVcenterRef(String  vcenterRef) {
    this.vcenterRef = vcenterRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  PlacementScopeConfig objPlacementScopeConfig = (PlacementScopeConfig) o;
  return   Objects.equals(this.vcenterRef, objPlacementScopeConfig.vcenterRef)&&
  Objects.equals(this.vcenterFolder, objPlacementScopeConfig.vcenterFolder)&&
  Objects.equals(this.nsxtHosts, objPlacementScopeConfig.nsxtHosts);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PlacementScopeConfig {\n");
      sb.append("    nsxtHosts: ").append(toIndentedString(nsxtHosts)).append("\n");
        sb.append("    vcenterFolder: ").append(toIndentedString(vcenterFolder)).append("\n");
        sb.append("    vcenterRef: ").append(toIndentedString(vcenterRef)).append("\n");
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

