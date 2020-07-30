package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The BurstLicenseDetails is a POJO class extends AviRestResource that used for creating
 * BurstLicenseDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BurstLicenseDetails  {
    @JsonProperty("cores")
    private Integer cores = null;

    @JsonProperty("end_time")
    private String endTime = null;

    @JsonProperty("se_name")
    private String seName = null;

    @JsonProperty("se_uuid")
    private String seUuid = null;

    @JsonProperty("start_time")
    private String startTime = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cores of obj type burstlicensedetails field type str  type integer.
   * @return cores
   */
  public Integer getCores() {
    return cores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cores of obj type burstlicensedetails field type str  type integer.
   * @param cores set the cores.
   */
  public void setCores(Integer  cores) {
    this.cores = cores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property end_time of obj type burstlicensedetails field type str  type string.
   * @return endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property end_time of obj type burstlicensedetails field type str  type string.
   * @param endTime set the endTime.
   */
  public void setEndTime(String  endTime) {
    this.endTime = endTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_name of obj type burstlicensedetails field type str  type string.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_name of obj type burstlicensedetails field type str  type string.
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
   * Placeholder for description of property start_time of obj type burstlicensedetails field type str  type string.
   * @return startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property start_time of obj type burstlicensedetails field type str  type string.
   * @param startTime set the startTime.
   */
  public void setStartTime(String  startTime) {
    this.startTime = startTime;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  BurstLicenseDetails objBurstLicenseDetails = (BurstLicenseDetails) o;
  return   Objects.equals(this.seName, objBurstLicenseDetails.seName)&&
  Objects.equals(this.seUuid, objBurstLicenseDetails.seUuid)&&
  Objects.equals(this.startTime, objBurstLicenseDetails.startTime)&&
  Objects.equals(this.cores, objBurstLicenseDetails.cores)&&
  Objects.equals(this.endTime, objBurstLicenseDetails.endTime);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class BurstLicenseDetails {\n");
      sb.append("    cores: ").append(toIndentedString(cores)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
        sb.append("    seUuid: ").append(toIndentedString(seUuid)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
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

