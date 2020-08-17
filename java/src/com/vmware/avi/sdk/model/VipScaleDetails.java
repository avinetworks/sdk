package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VipScaleDetails is a POJO class extends AviRestResource that used for creating
 * VipScaleDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VipScaleDetails  {
    @JsonProperty("availability_zone")
    private String availabilityZone = null;

    @JsonProperty("error")
    private String error = null;

    @JsonProperty("subnet_uuid")
    private String subnetUuid = null;

    @JsonProperty("vip_id")
    private String vipId = null;

    @JsonProperty("vsvip_uuid")
    private String vsvipUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property availability_zone of obj type vipscaledetails field type str  type string.
   * @return availabilityZone
   */
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property availability_zone of obj type vipscaledetails field type str  type string.
   * @param availabilityZone set the availabilityZone.
   */
  public void setAvailabilityZone(String  availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error of obj type vipscaledetails field type str  type string.
   * @return error
   */
  public String getError() {
    return error;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error of obj type vipscaledetails field type str  type string.
   * @param error set the error.
   */
  public void setError(String  error) {
    this.error = error;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of subnet.
   * @return subnetUuid
   */
  public String getSubnetUuid() {
    return subnetUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of subnet.
   * @param subnetUuid set the subnetUuid.
   */
  public void setSubnetUuid(String  subnetUuid) {
    this.subnetUuid = subnetUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_id of obj type vipscaledetails field type str  type string.
   * @return vipId
   */
  public String getVipId() {
    return vipId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vip_id of obj type vipscaledetails field type str  type string.
   * @param vipId set the vipId.
   */
  public void setVipId(String  vipId) {
    this.vipId = vipId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of vsvip.
   * @return vsvipUuid
   */
  public String getVsvipUuid() {
    return vsvipUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of vsvip.
   * @param vsvipUuid set the vsvipUuid.
   */
  public void setVsvipUuid(String  vsvipUuid) {
    this.vsvipUuid = vsvipUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VipScaleDetails objVipScaleDetails = (VipScaleDetails) o;
  return   Objects.equals(this.vsvipUuid, objVipScaleDetails.vsvipUuid)&&
  Objects.equals(this.vipId, objVipScaleDetails.vipId)&&
  Objects.equals(this.availabilityZone, objVipScaleDetails.availabilityZone)&&
  Objects.equals(this.subnetUuid, objVipScaleDetails.subnetUuid)&&
  Objects.equals(this.error, objVipScaleDetails.error);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VipScaleDetails {\n");
      sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
        sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("    subnetUuid: ").append(toIndentedString(subnetUuid)).append("\n");
        sb.append("    vipId: ").append(toIndentedString(vipId)).append("\n");
        sb.append("    vsvipUuid: ").append(toIndentedString(vsvipUuid)).append("\n");
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

