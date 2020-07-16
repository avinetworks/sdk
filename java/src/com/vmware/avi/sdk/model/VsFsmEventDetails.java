package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VsFsmEventDetails is a POJO class extends AviRestResource that used for creating
 * VsFsmEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VsFsmEventDetails  {
    @JsonProperty("vip_id")
    private String vipId = null;

    @JsonProperty("vs_rt")
    private VirtualServiceRuntime vsRt = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_id of obj type vsfsmeventdetails field type str  type string.
   * @return vipId
   */
  public String getVipId() {
    return vipId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vip_id of obj type vsfsmeventdetails field type str  type string.
   * @param vipId set the vipId.
   */
  public void setVipId(String  vipId) {
    this.vipId = vipId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_rt of obj type vsfsmeventdetails field type str  type ref.
   * @return vsRt
   */
  public VirtualServiceRuntime getVsRt() {
    return vsRt;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_rt of obj type vsfsmeventdetails field type str  type ref.
   * @param vsRt set the vsRt.
   */
  public void setVsRt(VirtualServiceRuntime vsRt) {
    this.vsRt = vsRt;
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


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VsFsmEventDetails objVsFsmEventDetails = (VsFsmEventDetails) o;
  return   Objects.equals(this.vsUuid, objVsFsmEventDetails.vsUuid)&&
  Objects.equals(this.vsRt, objVsFsmEventDetails.vsRt)&&
  Objects.equals(this.vipId, objVsFsmEventDetails.vipId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VsFsmEventDetails {\n");
      sb.append("    vipId: ").append(toIndentedString(vipId)).append("\n");
        sb.append("    vsRt: ").append(toIndentedString(vsRt)).append("\n");
        sb.append("    vsUuid: ").append(toIndentedString(vsUuid)).append("\n");
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

