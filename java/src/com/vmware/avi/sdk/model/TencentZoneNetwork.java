package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The TencentZoneNetwork is a POJO class extends AviRestResource that used for creating
 * TencentZoneNetwork.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TencentZoneNetwork  {
    @JsonProperty("availability_zone")
    private String availabilityZone = null;

    @JsonProperty("usable_subnet_id")
    private String usableSubnetId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Availability zone.
   * Field introduced in 18.2.3.
   * @return availabilityZone
   */
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  /**
   * This is the setter method to the attribute.
   * Availability zone.
   * Field introduced in 18.2.3.
   * @param availabilityZone set the availabilityZone.
   */
  public void setAvailabilityZone(String  availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * Field introduced in 18.2.3.
   * @return usableSubnetId
   */
  public String getUsableSubnetId() {
    return usableSubnetId;
  }

  /**
   * This is the setter method to the attribute.
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * Field introduced in 18.2.3.
   * @param usableSubnetId set the usableSubnetId.
   */
  public void setUsableSubnetId(String  usableSubnetId) {
    this.usableSubnetId = usableSubnetId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  TencentZoneNetwork objTencentZoneNetwork = (TencentZoneNetwork) o;
  return   Objects.equals(this.usableSubnetId, objTencentZoneNetwork.usableSubnetId)&&
  Objects.equals(this.availabilityZone, objTencentZoneNetwork.availabilityZone);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class TencentZoneNetwork {\n");
      sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
        sb.append("    usableSubnetId: ").append(toIndentedString(usableSubnetId)).append("\n");
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

