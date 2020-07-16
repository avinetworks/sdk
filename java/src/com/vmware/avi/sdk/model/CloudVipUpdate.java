package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudVipUpdate is a POJO class extends AviRestResource that used for creating
 * CloudVipUpdate.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudVipUpdate  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("error_string")
    private String errorString = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;

    @JsonProperty("vtype")
    private String vtype = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type cloudvipupdate field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type cloudvipupdate field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error_string of obj type cloudvipupdate field type str  type string.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error_string of obj type cloudvipupdate field type str  type string.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of vs.
   * @return vsUuid
   */
  public String getVsUuid() {
    return vsUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of vs.
   * @param vsUuid set the vsUuid.
   */
  public void setVsUuid(String  vsUuid) {
    this.vsUuid = vsUuid;
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
  CloudVipUpdate objCloudVipUpdate = (CloudVipUpdate) o;
  return   Objects.equals(this.vsUuid, objCloudVipUpdate.vsUuid)&&
  Objects.equals(this.vtype, objCloudVipUpdate.vtype)&&
  Objects.equals(this.errorString, objCloudVipUpdate.errorString)&&
  Objects.equals(this.ccId, objCloudVipUpdate.ccId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudVipUpdate {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
        sb.append("    vsUuid: ").append(toIndentedString(vsUuid)).append("\n");
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

