package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VipAutoscaleZones is a POJO class extends AviRestResource that used for creating
 * VipAutoscaleZones.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VipAutoscaleZones  {
    @JsonProperty("availability_zone")
    private String availabilityZone = null;

    @JsonProperty("fip_capable")
    private Boolean fipCapable = null;

    @JsonProperty("subnet_uuid")
    private String subnetUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Availability zone associated with the subnet.
   * Field introduced in 17.2.12, 18.1.2.
   * @return availabilityZone
   */
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  /**
   * This is the setter method to the attribute.
   * Availability zone associated with the subnet.
   * Field introduced in 17.2.12, 18.1.2.
   * @param availabilityZone set the availabilityZone.
   */
  public void setAvailabilityZone(String  availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Determines if the subnet is capable of hosting publicly accessible ip.
   * Field introduced in 17.2.12, 18.1.2.
   * @return fipCapable
   */
  public Boolean getFipCapable() {
    return fipCapable;
  }

  /**
   * This is the setter method to the attribute.
   * Determines if the subnet is capable of hosting publicly accessible ip.
   * Field introduced in 17.2.12, 18.1.2.
   * @param fipCapable set the fipCapable.
   */
  public void setFipCapable(Boolean  fipCapable) {
    this.fipCapable = fipCapable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the subnet for new ip address allocation.
   * Field introduced in 17.2.12, 18.1.2.
   * @return subnetUuid
   */
  public String getSubnetUuid() {
    return subnetUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the subnet for new ip address allocation.
   * Field introduced in 17.2.12, 18.1.2.
   * @param subnetUuid set the subnetUuid.
   */
  public void setSubnetUuid(String  subnetUuid) {
    this.subnetUuid = subnetUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VipAutoscaleZones objVipAutoscaleZones = (VipAutoscaleZones) o;
  return   Objects.equals(this.subnetUuid, objVipAutoscaleZones.subnetUuid)&&
  Objects.equals(this.fipCapable, objVipAutoscaleZones.fipCapable)&&
  Objects.equals(this.availabilityZone, objVipAutoscaleZones.availabilityZone);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VipAutoscaleZones {\n");
      sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
        sb.append("    fipCapable: ").append(toIndentedString(fipCapable)).append("\n");
        sb.append("    subnetUuid: ").append(toIndentedString(subnetUuid)).append("\n");
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

