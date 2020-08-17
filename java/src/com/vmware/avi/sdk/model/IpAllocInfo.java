package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IpAllocInfo is a POJO class extends AviRestResource that used for creating
 * IpAllocInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpAllocInfo  {
    @JsonProperty("ip")
    private IpAddr ip = null;

    @JsonProperty("mac")
    private String mac = null;

    @JsonProperty("se_uuid")
    private String seUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip of obj type ipallocinfo field type str  type ref.
   * @return ip
   */
  public IpAddr getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip of obj type ipallocinfo field type str  type ref.
   * @param ip set the ip.
   */
  public void setIp(IpAddr ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mac of obj type ipallocinfo field type str  type string.
   * @return mac
   */
  public String getMac() {
    return mac;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mac of obj type ipallocinfo field type str  type string.
   * @param mac set the mac.
   */
  public void setMac(String  mac) {
    this.mac = mac;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of se.
   * @return seUuid
   */
  public String getSeUuid() {
    return seUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of se.
   * @param seUuid set the seUuid.
   */
  public void setSeUuid(String  seUuid) {
    this.seUuid = seUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IpAllocInfo objIpAllocInfo = (IpAllocInfo) o;
  return   Objects.equals(this.ip, objIpAllocInfo.ip)&&
  Objects.equals(this.mac, objIpAllocInfo.mac)&&
  Objects.equals(this.seUuid, objIpAllocInfo.seUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IpAllocInfo {\n");
      sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    mac: ").append(toIndentedString(mac)).append("\n");
        sb.append("    seUuid: ").append(toIndentedString(seUuid)).append("\n");
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

