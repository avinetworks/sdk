package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VICreateSEReq is a POJO class extends AviRestResource that used for creating
 * VICreateSEReq.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VICreateSEReq  {
    @JsonProperty("cloud_uuid")
    private String cloudUuid = null;

    @JsonProperty("cookie")
    private String cookie = null;

    @JsonProperty("se_grp_uuid")
    private String seGrpUuid = null;

    @JsonProperty("se_params")
    private VISeVmOvaParams seParams = null;

    @JsonProperty("tenant_uuid")
    private String tenantUuid = null;

    @JsonProperty("vcenter_admin")
    private VIAdminCredentials vcenterAdmin = null;

    @JsonProperty("vcenter_vnic_portgroups")
    private List<String> vcenterVnicPortgroups = null;



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
   * Placeholder for description of property cookie of obj type vicreatesereq field type str  type string.
   * @return cookie
   */
  public String getCookie() {
    return cookie;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cookie of obj type vicreatesereq field type str  type string.
   * @param cookie set the cookie.
   */
  public void setCookie(String  cookie) {
    this.cookie = cookie;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of se_grp.
   * @return seGrpUuid
   */
  public String getSeGrpUuid() {
    return seGrpUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of se_grp.
   * @param seGrpUuid set the seGrpUuid.
   */
  public void setSeGrpUuid(String  seGrpUuid) {
    this.seGrpUuid = seGrpUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_params of obj type vicreatesereq field type str  type ref.
   * @return seParams
   */
  public VISeVmOvaParams getSeParams() {
    return seParams;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_params of obj type vicreatesereq field type str  type ref.
   * @param seParams set the seParams.
   */
  public void setSeParams(VISeVmOvaParams seParams) {
    this.seParams = seParams;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of tenant.
   * @return tenantUuid
   */
  public String getTenantUuid() {
    return tenantUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of tenant.
   * @param tenantUuid set the tenantUuid.
   */
  public void setTenantUuid(String  tenantUuid) {
    this.tenantUuid = tenantUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_admin of obj type vicreatesereq field type str  type ref.
   * @return vcenterAdmin
   */
  public VIAdminCredentials getVcenterAdmin() {
    return vcenterAdmin;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_admin of obj type vicreatesereq field type str  type ref.
   * @param vcenterAdmin set the vcenterAdmin.
   */
  public void setVcenterAdmin(VIAdminCredentials vcenterAdmin) {
    this.vcenterAdmin = vcenterAdmin;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_vnic_portgroups of obj type vicreatesereq field type str  type array.
   * @return vcenterVnicPortgroups
   */
  public List<String> getVcenterVnicPortgroups() {
    return vcenterVnicPortgroups;
  }

  /**
   * This is the setter method. this will set the vcenterVnicPortgroups
   * Placeholder for description of property vcenter_vnic_portgroups of obj type vicreatesereq field type str  type array.
   * @return vcenterVnicPortgroups
   */
  public void setVcenterVnicPortgroups(List<String>  vcenterVnicPortgroups) {
    this.vcenterVnicPortgroups = vcenterVnicPortgroups;
  }

  /**
   * This is the setter method this will set the vcenterVnicPortgroups
   * Placeholder for description of property vcenter_vnic_portgroups of obj type vicreatesereq field type str  type array.
   * @return vcenterVnicPortgroups
   */
  public VICreateSEReq addVcenterVnicPortgroupsItem(String vcenterVnicPortgroupsItem) {
    if (this.vcenterVnicPortgroups == null) {
      this.vcenterVnicPortgroups = new ArrayList<String>();
    }
    this.vcenterVnicPortgroups.add(vcenterVnicPortgroupsItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VICreateSEReq objVICreateSEReq = (VICreateSEReq) o;
  return   Objects.equals(this.seParams, objVICreateSEReq.seParams)&&
  Objects.equals(this.cookie, objVICreateSEReq.cookie)&&
  Objects.equals(this.vcenterAdmin, objVICreateSEReq.vcenterAdmin)&&
  Objects.equals(this.vcenterVnicPortgroups, objVICreateSEReq.vcenterVnicPortgroups)&&
  Objects.equals(this.seGrpUuid, objVICreateSEReq.seGrpUuid)&&
  Objects.equals(this.tenantUuid, objVICreateSEReq.tenantUuid)&&
  Objects.equals(this.cloudUuid, objVICreateSEReq.cloudUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VICreateSEReq {\n");
      sb.append("    cloudUuid: ").append(toIndentedString(cloudUuid)).append("\n");
        sb.append("    cookie: ").append(toIndentedString(cookie)).append("\n");
        sb.append("    seGrpUuid: ").append(toIndentedString(seGrpUuid)).append("\n");
        sb.append("    seParams: ").append(toIndentedString(seParams)).append("\n");
        sb.append("    tenantUuid: ").append(toIndentedString(tenantUuid)).append("\n");
        sb.append("    vcenterAdmin: ").append(toIndentedString(vcenterAdmin)).append("\n");
        sb.append("    vcenterVnicPortgroups: ").append(toIndentedString(vcenterVnicPortgroups)).append("\n");
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

