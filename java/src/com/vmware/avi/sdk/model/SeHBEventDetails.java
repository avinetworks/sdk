package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeHBEventDetails is a POJO class extends AviRestResource that used for creating
 * SeHBEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeHBEventDetails  {
    @JsonProperty("hb_type")
    private Integer hbType = 1;

    @JsonProperty("remote_se_ref")
    private String remoteSeRef = null;

    @JsonProperty("reporting_se_ref")
    private String reportingSeRef = null;

    @JsonProperty("se_ref1")
    private String seRef1 = null;

    @JsonProperty("se_ref2")
    private String seRef2 = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Hb request/response not received.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return hbType
   */
  public Integer getHbType() {
    return hbType;
  }

  /**
   * This is the setter method to the attribute.
   * Hb request/response not received.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param hbType set the hbType.
   */
  public void setHbType(Integer  hbType) {
    this.hbType = hbType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the se with which heartbeat failed.
   * It is a reference to an object of type serviceengine.
   * Field introduced in 20.1.1.
   * @return remoteSeRef
   */
  public String getRemoteSeRef() {
    return remoteSeRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the se with which heartbeat failed.
   * It is a reference to an object of type serviceengine.
   * Field introduced in 20.1.1.
   * @param remoteSeRef set the remoteSeRef.
   */
  public void setRemoteSeRef(String  remoteSeRef) {
    this.remoteSeRef = remoteSeRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the se reporting this event.
   * It is a reference to an object of type serviceengine.
   * Field introduced in 20.1.1.
   * @return reportingSeRef
   */
  public String getReportingSeRef() {
    return reportingSeRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the se reporting this event.
   * It is a reference to an object of type serviceengine.
   * Field introduced in 20.1.1.
   * @param reportingSeRef set the reportingSeRef.
   */
  public void setReportingSeRef(String  reportingSeRef) {
    this.reportingSeRef = reportingSeRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the se responsible for this event.
   * It is a reference to an object of type serviceengine.
   * Field deprecated in 20.1.1.
   * @return seRef1
   */
  public String getSeRef1() {
    return seRef1;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the se responsible for this event.
   * It is a reference to an object of type serviceengine.
   * Field deprecated in 20.1.1.
   * @param seRef1 set the seRef1.
   */
  public void setSeRef1(String  seRef1) {
    this.seRef1 = seRef1;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of a se in the se-group which failed to respond.
   * It is a reference to an object of type serviceengine.
   * Field deprecated in 20.1.1.
   * @return seRef2
   */
  public String getSeRef2() {
    return seRef2;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of a se in the se-group which failed to respond.
   * It is a reference to an object of type serviceengine.
   * Field deprecated in 20.1.1.
   * @param seRef2 set the seRef2.
   */
  public void setSeRef2(String  seRef2) {
    this.seRef2 = seRef2;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the virtual service which is placed on reporting-se and remote-se.
   * Field introduced in 20.1.1.
   * @return vsUuid
   */
  public String getVsUuid() {
    return vsUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the virtual service which is placed on reporting-se and remote-se.
   * Field introduced in 20.1.1.
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
  SeHBEventDetails objSeHBEventDetails = (SeHBEventDetails) o;
  return   Objects.equals(this.remoteSeRef, objSeHBEventDetails.remoteSeRef)&&
  Objects.equals(this.seRef2, objSeHBEventDetails.seRef2)&&
  Objects.equals(this.seRef1, objSeHBEventDetails.seRef1)&&
  Objects.equals(this.vsUuid, objSeHBEventDetails.vsUuid)&&
  Objects.equals(this.reportingSeRef, objSeHBEventDetails.reportingSeRef)&&
  Objects.equals(this.hbType, objSeHBEventDetails.hbType);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeHBEventDetails {\n");
      sb.append("    hbType: ").append(toIndentedString(hbType)).append("\n");
        sb.append("    remoteSeRef: ").append(toIndentedString(remoteSeRef)).append("\n");
        sb.append("    reportingSeRef: ").append(toIndentedString(reportingSeRef)).append("\n");
        sb.append("    seRef1: ").append(toIndentedString(seRef1)).append("\n");
        sb.append("    seRef2: ").append(toIndentedString(seRef2)).append("\n");
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

