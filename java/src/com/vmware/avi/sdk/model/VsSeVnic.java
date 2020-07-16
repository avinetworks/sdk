package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VsSeVnic is a POJO class extends AviRestResource that used for creating
 * VsSeVnic.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VsSeVnic  {
    @JsonProperty("lif")
    private String lif = null;

    @JsonProperty("mac")
    private String mac = null;

    @JsonProperty("type")
    private String type = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property lif of obj type vssevnic field type str  type string.
   * @return lif
   */
  public String getLif() {
    return lif;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property lif of obj type vssevnic field type str  type string.
   * @param lif set the lif.
   */
  public void setLif(String  lif) {
    this.lif = lif;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mac of obj type vssevnic field type str  type string.
   * @return mac
   */
  public String getMac() {
    return mac;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mac of obj type vssevnic field type str  type string.
   * @param mac set the mac.
   */
  public void setMac(String  mac) {
    this.mac = mac;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - VNIC_TYPE_FE, VNIC_TYPE_BE.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - VNIC_TYPE_FE, VNIC_TYPE_BE.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VsSeVnic objVsSeVnic = (VsSeVnic) o;
  return   Objects.equals(this.mac, objVsSeVnic.mac)&&
  Objects.equals(this.type, objVsSeVnic.type)&&
  Objects.equals(this.lif, objVsSeVnic.lif);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VsSeVnic {\n");
      sb.append("    lif: ").append(toIndentedString(lif)).append("\n");
        sb.append("    mac: ").append(toIndentedString(mac)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

