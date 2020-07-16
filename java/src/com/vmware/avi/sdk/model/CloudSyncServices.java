package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudSyncServices is a POJO class extends AviRestResource that used for creating
 * CloudSyncServices.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudSyncServices  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("error_string")
    private String errorString = null;

    @JsonProperty("se_vm_uuid")
    private String seVmUuid = null;

    @JsonProperty("vips")
    private List<IpAddr> vips = null;

    @JsonProperty("vtype")
    private String vtype = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type cloudsyncservices field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type cloudsyncservices field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error_string of obj type cloudsyncservices field type str  type string.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error_string of obj type cloudsyncservices field type str  type string.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
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
   * List of vips.
   * Field introduced in 18.2.2.
   * @return vips
   */
  public List<IpAddr> getVips() {
    return vips;
  }

  /**
   * This is the setter method. this will set the vips
   * List of vips.
   * Field introduced in 18.2.2.
   * @return vips
   */
  public void setVips(List<IpAddr>  vips) {
    this.vips = vips;
  }

  /**
   * This is the setter method this will set the vips
   * List of vips.
   * Field introduced in 18.2.2.
   * @return vips
   */
  public CloudSyncServices addVipsItem(IpAddr vipsItem) {
    if (this.vips == null) {
      this.vips = new ArrayList<IpAddr>();
    }
    this.vips.add(vipsItem);
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
  CloudSyncServices objCloudSyncServices = (CloudSyncServices) o;
  return   Objects.equals(this.vips, objCloudSyncServices.vips)&&
  Objects.equals(this.vtype, objCloudSyncServices.vtype)&&
  Objects.equals(this.seVmUuid, objCloudSyncServices.seVmUuid)&&
  Objects.equals(this.errorString, objCloudSyncServices.errorString)&&
  Objects.equals(this.ccId, objCloudSyncServices.ccId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudSyncServices {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
        sb.append("    seVmUuid: ").append(toIndentedString(seVmUuid)).append("\n");
        sb.append("    vips: ").append(toIndentedString(vips)).append("\n");
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

