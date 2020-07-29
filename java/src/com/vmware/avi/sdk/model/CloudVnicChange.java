package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudVnicChange is a POJO class extends AviRestResource that used for creating
 * CloudVnicChange.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudVnicChange  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("error_string")
    private String errorString = null;

    @JsonProperty("mac_addrs")
    private List<String> macAddrs = null;

    @JsonProperty("se_vm_uuid")
    private String seVmUuid = null;

    @JsonProperty("vnics")
    private List<CC_VnicInfo> vnics = null;

    @JsonProperty("vtype")
    private String vtype = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type cloudvnicchange field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type cloudvnicchange field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error_string of obj type cloudvnicchange field type str  type string.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error_string of obj type cloudvnicchange field type str  type string.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mac_addrs of obj type cloudvnicchange field type str  type array.
   * @return macAddrs
   */
  public List<String> getMacAddrs() {
    return macAddrs;
  }

  /**
   * This is the setter method. this will set the macAddrs
   * Placeholder for description of property mac_addrs of obj type cloudvnicchange field type str  type array.
   * @return macAddrs
   */
  public void setMacAddrs(List<String>  macAddrs) {
    this.macAddrs = macAddrs;
  }

  /**
   * This is the setter method this will set the macAddrs
   * Placeholder for description of property mac_addrs of obj type cloudvnicchange field type str  type array.
   * @return macAddrs
   */
  public CloudVnicChange addMacAddrsItem(String macAddrsItem) {
    if (this.macAddrs == null) {
      this.macAddrs = new ArrayList<String>();
    }
    this.macAddrs.add(macAddrsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of se_vm.
   * @return seVmUuid
   */
  public String getSeVmUuid() {
    return seVmUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of se_vm.
   * @param seVmUuid set the seVmUuid.
   */
  public void setSeVmUuid(String  seVmUuid) {
    this.seVmUuid = seVmUuid;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vnics of obj type cloudvnicchange field type str  type array.
   * @return vnics
   */
  public List<CC_VnicInfo> getVnics() {
    return vnics;
  }

  /**
   * This is the setter method. this will set the vnics
   * Placeholder for description of property vnics of obj type cloudvnicchange field type str  type array.
   * @return vnics
   */
  public void setVnics(List<CC_VnicInfo>  vnics) {
    this.vnics = vnics;
  }

  /**
   * This is the setter method this will set the vnics
   * Placeholder for description of property vnics of obj type cloudvnicchange field type str  type array.
   * @return vnics
   */
  public CloudVnicChange addVnicsItem(CC_VnicInfo vnicsItem) {
    if (this.vnics == null) {
      this.vnics = new ArrayList<CC_VnicInfo>();
    }
    this.vnics.add(vnicsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * @return vtype
   */
  public String getVtype() {
    return vtype;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * @param vtype set the vtype.
   */
  public void setVtype(String  vtype) {
    this.vtype = vtype;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CloudVnicChange objCloudVnicChange = (CloudVnicChange) o;
  return   Objects.equals(this.ccId, objCloudVnicChange.ccId)&&
  Objects.equals(this.vtype, objCloudVnicChange.vtype)&&
  Objects.equals(this.seVmUuid, objCloudVnicChange.seVmUuid)&&
  Objects.equals(this.vnics, objCloudVnicChange.vnics)&&
  Objects.equals(this.macAddrs, objCloudVnicChange.macAddrs)&&
  Objects.equals(this.errorString, objCloudVnicChange.errorString);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudVnicChange {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
        sb.append("    macAddrs: ").append(toIndentedString(macAddrs)).append("\n");
        sb.append("    seVmUuid: ").append(toIndentedString(seVmUuid)).append("\n");
        sb.append("    vnics: ").append(toIndentedString(vnics)).append("\n");
        sb.append("    vtype: ").append(toIndentedString(vtype)).append("\n");
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

