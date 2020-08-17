package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AttackMetaData is a POJO class extends AviRestResource that used for creating
 * AttackMetaData.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttackMetaData  {
    @JsonProperty("ip")
    private String ip = null;

    @JsonProperty("max_resp_time")
    private Integer maxRespTime = null;

    @JsonProperty("url")
    private String url = "url";



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip of obj type attackmetadata field type str  type string.
   * @return ip
   */
  public String getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip of obj type attackmetadata field type str  type string.
   * @param ip set the ip.
   */
  public void setIp(String  ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property max_resp_time of obj type attackmetadata field type str  type integer.
   * @return maxRespTime
   */
  public Integer getMaxRespTime() {
    return maxRespTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property max_resp_time of obj type attackmetadata field type str  type integer.
   * @param maxRespTime set the maxRespTime.
   */
  public void setMaxRespTime(Integer  maxRespTime) {
    this.maxRespTime = maxRespTime;
  }
/**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property url of obj type attackmetadata field type str  type string.
   * @return url
   */
  public String getUrl() {
    return url;
  }

  /**
   * This is the setter method. this will set the url
   * Placeholder for description of property url of obj type attackmetadata field type str  type string.
   * @return url
   */
  public void setUrl(String  url) {
    this.url = url;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AttackMetaData objAttackMetaData = (AttackMetaData) o;
  return   Objects.equals(this.ip, objAttackMetaData.ip)&&
  Objects.equals(this.maxRespTime, objAttackMetaData.maxRespTime);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AttackMetaData {\n");
      sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    maxRespTime: ").append(toIndentedString(maxRespTime)).append("\n");
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

