package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OCISetup is a POJO class extends AviRestResource that used for creating
 * OCISetup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OCISetup  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("compartment_id")
    private String compartmentId = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("tenancy")
    private String tenancy = null;

    @JsonProperty("vcn_id")
    private String vcnId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type ocisetup field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type ocisetup field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property compartment_id of obj type ocisetup field type str  type string.
   * @return compartmentId
   */
  public String getCompartmentId() {
    return compartmentId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property compartment_id of obj type ocisetup field type str  type string.
   * @param compartmentId set the compartmentId.
   */
  public void setCompartmentId(String  compartmentId) {
    this.compartmentId = compartmentId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type ocisetup field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type ocisetup field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property status of obj type ocisetup field type str  type string.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property status of obj type ocisetup field type str  type string.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tenancy of obj type ocisetup field type str  type string.
   * @return tenancy
   */
  public String getTenancy() {
    return tenancy;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property tenancy of obj type ocisetup field type str  type string.
   * @param tenancy set the tenancy.
   */
  public void setTenancy(String  tenancy) {
    this.tenancy = tenancy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcn_id of obj type ocisetup field type str  type string.
   * @return vcnId
   */
  public String getVcnId() {
    return vcnId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcn_id of obj type ocisetup field type str  type string.
   * @param vcnId set the vcnId.
   */
  public void setVcnId(String  vcnId) {
    this.vcnId = vcnId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OCISetup objOCISetup = (OCISetup) o;
  return   Objects.equals(this.ccId, objOCISetup.ccId)&&
  Objects.equals(this.tenancy, objOCISetup.tenancy)&&
  Objects.equals(this.compartmentId, objOCISetup.compartmentId)&&
  Objects.equals(this.vcnId, objOCISetup.vcnId)&&
  Objects.equals(this.status, objOCISetup.status)&&
  Objects.equals(this.reason, objOCISetup.reason);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OCISetup {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    compartmentId: ").append(toIndentedString(compartmentId)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    tenancy: ").append(toIndentedString(tenancy)).append("\n");
        sb.append("    vcnId: ").append(toIndentedString(vcnId)).append("\n");
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

