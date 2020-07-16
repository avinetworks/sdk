package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIDeleteSEReq is a POJO class extends AviRestResource that used for creating
 * VIDeleteSEReq.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIDeleteSEReq  {
    @JsonProperty("cloud_uuid")
    private String cloudUuid = null;

    @JsonProperty("segroup_uuid")
    private String segroupUuid = null;

    @JsonProperty("sevm_uuid")
    private String sevmUuid = null;

    @JsonProperty("vcenter_admin")
    private VIAdminCredentials vcenterAdmin = null;



  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of cloud.
   * @return cloudUuid
   */
  public String getCloudUuid() {
    return cloudUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of cloud.
   * @param cloudUuid set the cloudUuid.
   */
  public void setCloudUuid(String  cloudUuid) {
    this.cloudUuid = cloudUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of segroup.
   * @return segroupUuid
   */
  public String getSegroupUuid() {
    return segroupUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of segroup.
   * @param segroupUuid set the segroupUuid.
   */
  public void setSegroupUuid(String  segroupUuid) {
    this.segroupUuid = segroupUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of sevm.
   * @return sevmUuid
   */
  public String getSevmUuid() {
    return sevmUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of sevm.
   * @param sevmUuid set the sevmUuid.
   */
  public void setSevmUuid(String  sevmUuid) {
    this.sevmUuid = sevmUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_admin of obj type videletesereq field type str  type ref.
   * @return vcenterAdmin
   */
  public VIAdminCredentials getVcenterAdmin() {
    return vcenterAdmin;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_admin of obj type videletesereq field type str  type ref.
   * @param vcenterAdmin set the vcenterAdmin.
   */
  public void setVcenterAdmin(VIAdminCredentials vcenterAdmin) {
    this.vcenterAdmin = vcenterAdmin;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VIDeleteSEReq objVIDeleteSEReq = (VIDeleteSEReq) o;
  return   Objects.equals(this.vcenterAdmin, objVIDeleteSEReq.vcenterAdmin)&&
  Objects.equals(this.segroupUuid, objVIDeleteSEReq.segroupUuid)&&
  Objects.equals(this.sevmUuid, objVIDeleteSEReq.sevmUuid)&&
  Objects.equals(this.cloudUuid, objVIDeleteSEReq.cloudUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIDeleteSEReq {\n");
      sb.append("    cloudUuid: ").append(toIndentedString(cloudUuid)).append("\n");
        sb.append("    segroupUuid: ").append(toIndentedString(segroupUuid)).append("\n");
        sb.append("    sevmUuid: ").append(toIndentedString(sevmUuid)).append("\n");
        sb.append("    vcenterAdmin: ").append(toIndentedString(vcenterAdmin)).append("\n");
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

