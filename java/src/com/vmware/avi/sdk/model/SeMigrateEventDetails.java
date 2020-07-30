package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeMigrateEventDetails is a POJO class extends AviRestResource that used for creating
 * SeMigrateEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeMigrateEventDetails  {
    @JsonProperty("num_vs")
    private Integer numVs = null;

    @JsonProperty("reason")
    private List<String> reason = null;

    @JsonProperty("se_name")
    private String seName = null;

    @JsonProperty("se_uuid")
    private String seUuid = null;

    @JsonProperty("vs_name")
    private String vsName = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_vs of obj type semigrateeventdetails field type str  type integer.
   * @return numVs
   */
  public Integer getNumVs() {
    return numVs;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_vs of obj type semigrateeventdetails field type str  type integer.
   * @param numVs set the numVs.
   */
  public void setNumVs(Integer  numVs) {
    this.numVs = numVs;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type semigrateeventdetails field type str  type array.
   * @return reason
   */
  public List<String> getReason() {
    return reason;
  }

  /**
   * This is the setter method. this will set the reason
   * Placeholder for description of property reason of obj type semigrateeventdetails field type str  type array.
   * @return reason
   */
  public void setReason(List<String>  reason) {
    this.reason = reason;
  }

  /**
   * This is the setter method this will set the reason
   * Placeholder for description of property reason of obj type semigrateeventdetails field type str  type array.
   * @return reason
   */
  public SeMigrateEventDetails addReasonItem(String reasonItem) {
    if (this.reason == null) {
      this.reason = new ArrayList<String>();
    }
    this.reason.add(reasonItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_name of obj type semigrateeventdetails field type str  type string.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_name of obj type semigrateeventdetails field type str  type string.
   * @param seName set the seName.
   */
  public void setSeName(String  seName) {
    this.seName = seName;
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

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_name of obj type semigrateeventdetails field type str  type string.
   * @return vsName
   */
  public String getVsName() {
    return vsName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_name of obj type semigrateeventdetails field type str  type string.
   * @param vsName set the vsName.
   */
  public void setVsName(String  vsName) {
    this.vsName = vsName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of vs.
   * @return vsUuid
   */
  public String getVsUuid() {
    return vsUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of vs.
   * @param vsUuid set the vsUuid.
   */
  public void setVsUuid(String  vsUuid) {
    this.vsUuid = vsUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeMigrateEventDetails objSeMigrateEventDetails = (SeMigrateEventDetails) o;
  return   Objects.equals(this.seUuid, objSeMigrateEventDetails.seUuid)&&
  Objects.equals(this.seName, objSeMigrateEventDetails.seName)&&
  Objects.equals(this.vsUuid, objSeMigrateEventDetails.vsUuid)&&
  Objects.equals(this.vsName, objSeMigrateEventDetails.vsName)&&
  Objects.equals(this.numVs, objSeMigrateEventDetails.numVs)&&
  Objects.equals(this.reason, objSeMigrateEventDetails.reason);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeMigrateEventDetails {\n");
      sb.append("    numVs: ").append(toIndentedString(numVs)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
        sb.append("    seUuid: ").append(toIndentedString(seUuid)).append("\n");
        sb.append("    vsName: ").append(toIndentedString(vsName)).append("\n");
        sb.append("    vsUuid: ").append(toIndentedString(vsUuid)).append("\n");
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

