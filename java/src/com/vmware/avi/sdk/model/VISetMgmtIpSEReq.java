package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VISetMgmtIpSEReq is a POJO class extends AviRestResource that used for creating
 * VISetMgmtIpSEReq.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VISetMgmtIpSEReq  {
    @JsonProperty("admin")
    private VIAdminCredentials admin = null;

    @JsonProperty("all_vnic_connected")
    private Boolean allVnicConnected = false;

    @JsonProperty("cloud_uuid")
    private String cloudUuid = null;

    @JsonProperty("dc_uuid")
    private String dcUuid = null;

    @JsonProperty("ip_params")
    private VISeVmIpConfParams ipParams = null;

    @JsonProperty("power_on")
    private Boolean powerOn = true;

    @JsonProperty("rm_cookie")
    private String rmCookie = null;

    @JsonProperty("sevm_uuid")
    private String sevmUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property admin of obj type visetmgmtipsereq field type str  type ref.
   * @return admin
   */
  public VIAdminCredentials getAdmin() {
    return admin;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property admin of obj type visetmgmtipsereq field type str  type ref.
   * @param admin set the admin.
   */
  public void setAdmin(VIAdminCredentials admin) {
    this.admin = admin;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property all_vnic_connected of obj type visetmgmtipsereq field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allVnicConnected
   */
  public Boolean getAllVnicConnected() {
    return allVnicConnected;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property all_vnic_connected of obj type visetmgmtipsereq field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allVnicConnected set the allVnicConnected.
   */
  public void setAllVnicConnected(Boolean  allVnicConnected) {
    this.allVnicConnected = allVnicConnected;
  }

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
   * Unique object identifier of dc.
   * @return dcUuid
   */
  public String getDcUuid() {
    return dcUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of dc.
   * @param dcUuid set the dcUuid.
   */
  public void setDcUuid(String  dcUuid) {
    this.dcUuid = dcUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip_params of obj type visetmgmtipsereq field type str  type ref.
   * @return ipParams
   */
  public VISeVmIpConfParams getIpParams() {
    return ipParams;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip_params of obj type visetmgmtipsereq field type str  type ref.
   * @param ipParams set the ipParams.
   */
  public void setIpParams(VISeVmIpConfParams ipParams) {
    this.ipParams = ipParams;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property power_on of obj type visetmgmtipsereq field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return powerOn
   */
  public Boolean getPowerOn() {
    return powerOn;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property power_on of obj type visetmgmtipsereq field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param powerOn set the powerOn.
   */
  public void setPowerOn(Boolean  powerOn) {
    this.powerOn = powerOn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rm_cookie of obj type visetmgmtipsereq field type str  type string.
   * @return rmCookie
   */
  public String getRmCookie() {
    return rmCookie;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rm_cookie of obj type visetmgmtipsereq field type str  type string.
   * @param rmCookie set the rmCookie.
   */
  public void setRmCookie(String  rmCookie) {
    this.rmCookie = rmCookie;
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


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VISetMgmtIpSEReq objVISetMgmtIpSEReq = (VISetMgmtIpSEReq) o;
  return   Objects.equals(this.ipParams, objVISetMgmtIpSEReq.ipParams)&&
  Objects.equals(this.powerOn, objVISetMgmtIpSEReq.powerOn)&&
  Objects.equals(this.admin, objVISetMgmtIpSEReq.admin)&&
  Objects.equals(this.allVnicConnected, objVISetMgmtIpSEReq.allVnicConnected)&&
  Objects.equals(this.sevmUuid, objVISetMgmtIpSEReq.sevmUuid)&&
  Objects.equals(this.rmCookie, objVISetMgmtIpSEReq.rmCookie)&&
  Objects.equals(this.dcUuid, objVISetMgmtIpSEReq.dcUuid)&&
  Objects.equals(this.cloudUuid, objVISetMgmtIpSEReq.cloudUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VISetMgmtIpSEReq {\n");
      sb.append("    admin: ").append(toIndentedString(admin)).append("\n");
        sb.append("    allVnicConnected: ").append(toIndentedString(allVnicConnected)).append("\n");
        sb.append("    cloudUuid: ").append(toIndentedString(cloudUuid)).append("\n");
        sb.append("    dcUuid: ").append(toIndentedString(dcUuid)).append("\n");
        sb.append("    ipParams: ").append(toIndentedString(ipParams)).append("\n");
        sb.append("    powerOn: ").append(toIndentedString(powerOn)).append("\n");
        sb.append("    rmCookie: ").append(toIndentedString(rmCookie)).append("\n");
        sb.append("    sevmUuid: ").append(toIndentedString(sevmUuid)).append("\n");
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

