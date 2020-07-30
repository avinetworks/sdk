package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AwsZoneNetwork is a POJO class extends AviRestResource that used for creating
 * AwsZoneNetwork.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AwsZoneNetwork  {
    @JsonProperty("availability_zone")
    private String availabilityZone = null;

    @JsonProperty("usable_network_uuids")
    private List<String> usableNetworkUuids = null;



  /**
   * This is the getter method this will return the attribute value.
   * Availability zone.
   * Field introduced in 17.1.3.
   * @return availabilityZone
   */
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  /**
   * This is the setter method to the attribute.
   * Availability zone.
   * Field introduced in 17.1.3.
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
   * Field introduced in 17.1.3.
   * @return usableNetworkUuids
   */
  public List<String> getUsableNetworkUuids() {
    return usableNetworkUuids;
  }

  /**
   * This is the setter method. this will set the usableNetworkUuids
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * Field introduced in 17.1.3.
   * @return usableNetworkUuids
   */
  public void setUsableNetworkUuids(List<String>  usableNetworkUuids) {
    this.usableNetworkUuids = usableNetworkUuids;
  }

  /**
   * This is the setter method this will set the usableNetworkUuids
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * Field introduced in 17.1.3.
   * @return usableNetworkUuids
   */
  public AwsZoneNetwork addUsableNetworkUuidsItem(String usableNetworkUuidsItem) {
    if (this.usableNetworkUuids == null) {
      this.usableNetworkUuids = new ArrayList<String>();
    }
    this.usableNetworkUuids.add(usableNetworkUuidsItem);
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
  AwsZoneNetwork objAwsZoneNetwork = (AwsZoneNetwork) o;
  return   Objects.equals(this.availabilityZone, objAwsZoneNetwork.availabilityZone)&&
  Objects.equals(this.usableNetworkUuids, objAwsZoneNetwork.usableNetworkUuids);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AwsZoneNetwork {\n");
      sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
        sb.append("    usableNetworkUuids: ").append(toIndentedString(usableNetworkUuids)).append("\n");
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

