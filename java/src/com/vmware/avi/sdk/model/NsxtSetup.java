package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NsxtSetup is a POJO class extends AviRestResource that used for creating
 * NsxtSetup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NsxtSetup  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("transportzone_id")
    private String transportzoneId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type nsxtsetup field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type nsxtsetup field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type nsxtsetup field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type nsxtsetup field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property status of obj type nsxtsetup field type str  type string.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property status of obj type nsxtsetup field type str  type string.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property transportzone_id of obj type nsxtsetup field type str  type string.
   * @return transportzoneId
   */
  public String getTransportzoneId() {
    return transportzoneId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property transportzone_id of obj type nsxtsetup field type str  type string.
   * @param transportzoneId set the transportzoneId.
   */
  public void setTransportzoneId(String  transportzoneId) {
    this.transportzoneId = transportzoneId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  NsxtSetup objNsxtSetup = (NsxtSetup) o;
  return   Objects.equals(this.ccId, objNsxtSetup.ccId)&&
  Objects.equals(this.transportzoneId, objNsxtSetup.transportzoneId)&&
  Objects.equals(this.status, objNsxtSetup.status)&&
  Objects.equals(this.reason, objNsxtSetup.reason);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NsxtSetup {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    transportzoneId: ").append(toIndentedString(transportzoneId)).append("\n");
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

