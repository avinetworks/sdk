package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IpReputationConfig is a POJO class extends AviRestResource that used for creating
 * IpReputationConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpReputationConfig  {
    @JsonProperty("ip_reputation_file_object_expiry_duration")
    private Integer ipReputationFileObjectExpiryDuration = 3;

    @JsonProperty("ip_reputation_sync_interval")
    private Integer ipReputationSyncInterval = 60;



  /**
   * This is the getter method this will return the attribute value.
   * Ip reputation db file object expiry duration in days.
   * Allowed values are 1-7.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.
   * @return ipReputationFileObjectExpiryDuration
   */
  public Integer getIpReputationFileObjectExpiryDuration() {
    return ipReputationFileObjectExpiryDuration;
  }

  /**
   * This is the setter method to the attribute.
   * Ip reputation db file object expiry duration in days.
   * Allowed values are 1-7.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.
   * @param ipReputationFileObjectExpiryDuration set the ipReputationFileObjectExpiryDuration.
   */
  public void setIpReputationFileObjectExpiryDuration(Integer  ipReputationFileObjectExpiryDuration) {
    this.ipReputationFileObjectExpiryDuration = ipReputationFileObjectExpiryDuration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip reputation db sync interval in minutes.
   * Allowed values are 2-1440.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return ipReputationSyncInterval
   */
  public Integer getIpReputationSyncInterval() {
    return ipReputationSyncInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Ip reputation db sync interval in minutes.
   * Allowed values are 2-1440.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param ipReputationSyncInterval set the ipReputationSyncInterval.
   */
  public void setIpReputationSyncInterval(Integer  ipReputationSyncInterval) {
    this.ipReputationSyncInterval = ipReputationSyncInterval;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IpReputationConfig objIpReputationConfig = (IpReputationConfig) o;
  return   Objects.equals(this.ipReputationSyncInterval, objIpReputationConfig.ipReputationSyncInterval)&&
  Objects.equals(this.ipReputationFileObjectExpiryDuration, objIpReputationConfig.ipReputationFileObjectExpiryDuration);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IpReputationConfig {\n");
      sb.append("    ipReputationFileObjectExpiryDuration: ").append(toIndentedString(ipReputationFileObjectExpiryDuration)).append("\n");
        sb.append("    ipReputationSyncInterval: ").append(toIndentedString(ipReputationSyncInterval)).append("\n");
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

