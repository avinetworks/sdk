package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AwsZoneConfig is a POJO class extends AviRestResource that used for creating
 * AwsZoneConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AwsZoneConfig  {
    @JsonProperty("availability_zone")
    private String availabilityZone = null;

    @JsonProperty("mgmt_network_name")
    private String mgmtNetworkName = null;

    @JsonProperty("mgmt_network_uuid")
    private String mgmtNetworkUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Availability zone.
   * @return availabilityZone
   */
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  /**
   * This is the setter method to the attribute.
   * Availability zone.
   * @param availabilityZone set the availabilityZone.
   */
  public void setAvailabilityZone(String  availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name or cidr of the network in the availability zone that will be used as management network.
   * @return mgmtNetworkName
   */
  public String getMgmtNetworkName() {
    return mgmtNetworkName;
  }

  /**
   * This is the setter method to the attribute.
   * Name or cidr of the network in the availability zone that will be used as management network.
   * @param mgmtNetworkName set the mgmtNetworkName.
   */
  public void setMgmtNetworkName(String  mgmtNetworkName) {
    this.mgmtNetworkName = mgmtNetworkName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the network in the availability zone that will be used as management network.
   * @return mgmtNetworkUuid
   */
  public String getMgmtNetworkUuid() {
    return mgmtNetworkUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the network in the availability zone that will be used as management network.
   * @param mgmtNetworkUuid set the mgmtNetworkUuid.
   */
  public void setMgmtNetworkUuid(String  mgmtNetworkUuid) {
    this.mgmtNetworkUuid = mgmtNetworkUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AwsZoneConfig objAwsZoneConfig = (AwsZoneConfig) o;
  return   Objects.equals(this.mgmtNetworkName, objAwsZoneConfig.mgmtNetworkName)&&
  Objects.equals(this.mgmtNetworkUuid, objAwsZoneConfig.mgmtNetworkUuid)&&
  Objects.equals(this.availabilityZone, objAwsZoneConfig.availabilityZone);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AwsZoneConfig {\n");
      sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
        sb.append("    mgmtNetworkName: ").append(toIndentedString(mgmtNetworkName)).append("\n");
        sb.append("    mgmtNetworkUuid: ").append(toIndentedString(mgmtNetworkUuid)).append("\n");
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

