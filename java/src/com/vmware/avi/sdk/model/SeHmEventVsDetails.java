package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeHmEventVsDetails is a POJO class extends AviRestResource that used for creating
 * SeHmEventVsDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeHmEventVsDetails  {
    @JsonProperty("ha_reason")
    private String haReason = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("se_name")
    private String seName = null;

    @JsonProperty("src_uuid")
    private String srcUuid = null;

    @JsonProperty("vip6_address")
    private IpAddr vip6Address = null;

    @JsonProperty("vip_address")
    private IpAddr vipAddress = null;

    @JsonProperty("vip_id")
    private String vipId = null;

    @JsonProperty("virtual_service")
    private String virtualService = null;



  /**
   * This is the getter method this will return the attribute value.
   * Ha compromised reason.
   * @return haReason
   */
  public String getHaReason() {
    return haReason;
  }

  /**
   * This is the setter method to the attribute.
   * Ha compromised reason.
   * @param haReason set the haReason.
   */
  public void setHaReason(String  haReason) {
    this.haReason = haReason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Reason for virtual service down.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Reason for virtual service down.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service engine name.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Service engine name.
   * @param seName set the seName.
   */
  public void setSeName(String  seName) {
    this.seName = seName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the event generator.
   * @return srcUuid
   */
  public String getSrcUuid() {
    return srcUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the event generator.
   * @param srcUuid set the srcUuid.
   */
  public void setSrcUuid(String  srcUuid) {
    this.srcUuid = srcUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vip address.
   * @return vip6Address
   */
  public IpAddr getVip6Address() {
    return vip6Address;
  }

  /**
   * This is the setter method to the attribute.
   * Vip address.
   * @param vip6Address set the vip6Address.
   */
  public void setVip6Address(IpAddr vip6Address) {
    this.vip6Address = vip6Address;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vip address.
   * @return vipAddress
   */
  public IpAddr getVipAddress() {
    return vipAddress;
  }

  /**
   * This is the setter method to the attribute.
   * Vip address.
   * @param vipAddress set the vipAddress.
   */
  public void setVipAddress(IpAddr vipAddress) {
    this.vipAddress = vipAddress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vip id.
   * @return vipId
   */
  public String getVipId() {
    return vipId;
  }

  /**
   * This is the setter method to the attribute.
   * Vip id.
   * @param vipId set the vipId.
   */
  public void setVipId(String  vipId) {
    this.vipId = vipId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtual service name.
   * It is a reference to an object of type virtualservice.
   * @return virtualService
   */
  public String getVirtualService() {
    return virtualService;
  }

  /**
   * This is the setter method to the attribute.
   * Virtual service name.
   * It is a reference to an object of type virtualservice.
   * @param virtualService set the virtualService.
   */
  public void setVirtualService(String  virtualService) {
    this.virtualService = virtualService;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeHmEventVsDetails objSeHmEventVsDetails = (SeHmEventVsDetails) o;
  return   Objects.equals(this.virtualService, objSeHmEventVsDetails.virtualService)&&
  Objects.equals(this.reason, objSeHmEventVsDetails.reason)&&
  Objects.equals(this.seName, objSeHmEventVsDetails.seName)&&
  Objects.equals(this.haReason, objSeHmEventVsDetails.haReason)&&
  Objects.equals(this.srcUuid, objSeHmEventVsDetails.srcUuid)&&
  Objects.equals(this.vipId, objSeHmEventVsDetails.vipId)&&
  Objects.equals(this.vipAddress, objSeHmEventVsDetails.vipAddress)&&
  Objects.equals(this.vip6Address, objSeHmEventVsDetails.vip6Address);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeHmEventVsDetails {\n");
      sb.append("    haReason: ").append(toIndentedString(haReason)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
        sb.append("    srcUuid: ").append(toIndentedString(srcUuid)).append("\n");
        sb.append("    vip6Address: ").append(toIndentedString(vip6Address)).append("\n");
        sb.append("    vipAddress: ").append(toIndentedString(vipAddress)).append("\n");
        sb.append("    vipId: ").append(toIndentedString(vipId)).append("\n");
        sb.append("    virtualService: ").append(toIndentedString(virtualService)).append("\n");
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

