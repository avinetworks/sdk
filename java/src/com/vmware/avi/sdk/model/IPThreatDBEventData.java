package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IPThreatDBEventData is a POJO class extends AviRestResource that used for creating
 * IPThreatDBEventData.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IPThreatDBEventData  {
    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("version")
    private String version = null;



  /**
   * This is the getter method this will return the attribute value.
   * Reason for ipthreatdb transaction failure.
   * Field introduced in 20.1.1.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Reason for ipthreatdb transaction failure.
   * Field introduced in 20.1.1.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Status of ipthreatdb transaction.
   * Field introduced in 20.1.1.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Status of ipthreatdb transaction.
   * Field introduced in 20.1.1.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Last synced version of the ipthreatdb.
   * Field introduced in 20.1.1.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Last synced version of the ipthreatdb.
   * Field introduced in 20.1.1.
   * @param version set the version.
   */
  public void setVersion(String  version) {
    this.version = version;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IPThreatDBEventData objIPThreatDBEventData = (IPThreatDBEventData) o;
  return   Objects.equals(this.status, objIPThreatDBEventData.status)&&
  Objects.equals(this.reason, objIPThreatDBEventData.reason)&&
  Objects.equals(this.version, objIPThreatDBEventData.version);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IPThreatDBEventData {\n");
      sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

