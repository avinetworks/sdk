package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeUpgradeVsDisruptedEventDetails is a POJO class extends AviRestResource that used for creating
 * SeUpgradeVsDisruptedEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeUpgradeVsDisruptedEventDetails  {
    @JsonProperty("ip")
    private String ip = null;

    @JsonProperty("notes")
    private List<String> notes = null;

    @JsonProperty("vip_id")
    private String vipId = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip of obj type seupgradevsdisruptedeventdetails field type str  type string.
   * @return ip
   */
  public String getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip of obj type seupgradevsdisruptedeventdetails field type str  type string.
   * @param ip set the ip.
   */
  public void setIp(String  ip) {
    this.ip = ip;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property notes of obj type seupgradevsdisruptedeventdetails field type str  type array.
   * @return notes
   */
  public List<String> getNotes() {
    return notes;
  }

  /**
   * This is the setter method. this will set the notes
   * Placeholder for description of property notes of obj type seupgradevsdisruptedeventdetails field type str  type array.
   * @return notes
   */
  public void setNotes(List<String>  notes) {
    this.notes = notes;
  }

  /**
   * This is the setter method this will set the notes
   * Placeholder for description of property notes of obj type seupgradevsdisruptedeventdetails field type str  type array.
   * @return notes
   */
  public SeUpgradeVsDisruptedEventDetails addNotesItem(String notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<String>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_id of obj type seupgradevsdisruptedeventdetails field type str  type string.
   * @return vipId
   */
  public String getVipId() {
    return vipId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vip_id of obj type seupgradevsdisruptedeventdetails field type str  type string.
   * @param vipId set the vipId.
   */
  public void setVipId(String  vipId) {
    this.vipId = vipId;
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
  SeUpgradeVsDisruptedEventDetails objSeUpgradeVsDisruptedEventDetails = (SeUpgradeVsDisruptedEventDetails) o;
  return   Objects.equals(this.ip, objSeUpgradeVsDisruptedEventDetails.ip)&&
  Objects.equals(this.vsUuid, objSeUpgradeVsDisruptedEventDetails.vsUuid)&&
  Objects.equals(this.notes, objSeUpgradeVsDisruptedEventDetails.notes)&&
  Objects.equals(this.vipId, objSeUpgradeVsDisruptedEventDetails.vipId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeUpgradeVsDisruptedEventDetails {\n");
      sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
        sb.append("    vipId: ").append(toIndentedString(vipId)).append("\n");
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

