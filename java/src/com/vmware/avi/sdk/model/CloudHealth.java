package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudHealth is a POJO class extends AviRestResource that used for creating
 * CloudHealth.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudHealth  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("error_string")
    private String errorString = null;

    @JsonProperty("first_fail")
    private String firstFail = null;

    @JsonProperty("last_fail")
    private String lastFail = null;

    @JsonProperty("last_ok")
    private String lastOk = null;

    @JsonProperty("num_fails")
    private Integer numFails = null;

    @JsonProperty("vtype")
    private String vtype = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type cloudhealth field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type cloudhealth field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error_string of obj type cloudhealth field type str  type string.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error_string of obj type cloudhealth field type str  type string.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property first_fail of obj type cloudhealth field type str  type string.
   * @return firstFail
   */
  public String getFirstFail() {
    return firstFail;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property first_fail of obj type cloudhealth field type str  type string.
   * @param firstFail set the firstFail.
   */
  public void setFirstFail(String  firstFail) {
    this.firstFail = firstFail;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property last_fail of obj type cloudhealth field type str  type string.
   * @return lastFail
   */
  public String getLastFail() {
    return lastFail;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property last_fail of obj type cloudhealth field type str  type string.
   * @param lastFail set the lastFail.
   */
  public void setLastFail(String  lastFail) {
    this.lastFail = lastFail;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property last_ok of obj type cloudhealth field type str  type string.
   * @return lastOk
   */
  public String getLastOk() {
    return lastOk;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property last_ok of obj type cloudhealth field type str  type string.
   * @param lastOk set the lastOk.
   */
  public void setLastOk(String  lastOk) {
    this.lastOk = lastOk;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_fails of obj type cloudhealth field type str  type integer.
   * @return numFails
   */
  public Integer getNumFails() {
    return numFails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_fails of obj type cloudhealth field type str  type integer.
   * @param numFails set the numFails.
   */
  public void setNumFails(Integer  numFails) {
    this.numFails = numFails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * @return vtype
   */
  public String getVtype() {
    return vtype;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * @param vtype set the vtype.
   */
  public void setVtype(String  vtype) {
    this.vtype = vtype;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CloudHealth objCloudHealth = (CloudHealth) o;
  return   Objects.equals(this.ccId, objCloudHealth.ccId)&&
  Objects.equals(this.vtype, objCloudHealth.vtype)&&
  Objects.equals(this.errorString, objCloudHealth.errorString)&&
  Objects.equals(this.numFails, objCloudHealth.numFails)&&
  Objects.equals(this.firstFail, objCloudHealth.firstFail)&&
  Objects.equals(this.lastFail, objCloudHealth.lastFail)&&
  Objects.equals(this.lastOk, objCloudHealth.lastOk);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudHealth {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
        sb.append("    firstFail: ").append(toIndentedString(firstFail)).append("\n");
        sb.append("    lastFail: ").append(toIndentedString(lastFail)).append("\n");
        sb.append("    lastOk: ").append(toIndentedString(lastOk)).append("\n");
        sb.append("    numFails: ").append(toIndentedString(numFails)).append("\n");
        sb.append("    vtype: ").append(toIndentedString(vtype)).append("\n");
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

