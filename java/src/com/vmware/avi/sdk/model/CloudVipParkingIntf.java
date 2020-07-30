package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudVipParkingIntf is a POJO class extends AviRestResource that used for creating
 * CloudVipParkingIntf.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudVipParkingIntf  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("error_string")
    private String errorString = null;

    @JsonProperty("intf_id")
    private String intfId = null;

    @JsonProperty("subnet_id")
    private String subnetId = null;

    @JsonProperty("vtype")
    private String vtype = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type cloudvipparkingintf field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type cloudvipparkingintf field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error_string of obj type cloudvipparkingintf field type str  type string.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error_string of obj type cloudvipparkingintf field type str  type string.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property intf_id of obj type cloudvipparkingintf field type str  type string.
   * @return intfId
   */
  public String getIntfId() {
    return intfId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property intf_id of obj type cloudvipparkingintf field type str  type string.
   * @param intfId set the intfId.
   */
  public void setIntfId(String  intfId) {
    this.intfId = intfId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property subnet_id of obj type cloudvipparkingintf field type str  type string.
   * @return subnetId
   */
  public String getSubnetId() {
    return subnetId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property subnet_id of obj type cloudvipparkingintf field type str  type string.
   * @param subnetId set the subnetId.
   */
  public void setSubnetId(String  subnetId) {
    this.subnetId = subnetId;
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
  CloudVipParkingIntf objCloudVipParkingIntf = (CloudVipParkingIntf) o;
  return   Objects.equals(this.ccId, objCloudVipParkingIntf.ccId)&&
  Objects.equals(this.vtype, objCloudVipParkingIntf.vtype)&&
  Objects.equals(this.subnetId, objCloudVipParkingIntf.subnetId)&&
  Objects.equals(this.intfId, objCloudVipParkingIntf.intfId)&&
  Objects.equals(this.errorString, objCloudVipParkingIntf.errorString);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudVipParkingIntf {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
        sb.append("    intfId: ").append(toIndentedString(intfId)).append("\n");
        sb.append("    subnetId: ").append(toIndentedString(subnetId)).append("\n");
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

