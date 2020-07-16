package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VinfraMgmtNwChangeDetails is a POJO class extends AviRestResource that used for creating
 * VinfraMgmtNwChangeDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VinfraMgmtNwChangeDetails  {
    @JsonProperty("existing_nw")
    private String existingNw = null;

    @JsonProperty("new_nw")
    private String newNw = null;

    @JsonProperty("vcenter")
    private String vcenter = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property existing_nw of obj type vinframgmtnwchangedetails field type str  type string.
   * @return existingNw
   */
  public String getExistingNw() {
    return existingNw;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property existing_nw of obj type vinframgmtnwchangedetails field type str  type string.
   * @param existingNw set the existingNw.
   */
  public void setExistingNw(String  existingNw) {
    this.existingNw = existingNw;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property new_nw of obj type vinframgmtnwchangedetails field type str  type string.
   * @return newNw
   */
  public String getNewNw() {
    return newNw;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property new_nw of obj type vinframgmtnwchangedetails field type str  type string.
   * @param newNw set the newNw.
   */
  public void setNewNw(String  newNw) {
    this.newNw = newNw;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter of obj type vinframgmtnwchangedetails field type str  type string.
   * @return vcenter
   */
  public String getVcenter() {
    return vcenter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter of obj type vinframgmtnwchangedetails field type str  type string.
   * @param vcenter set the vcenter.
   */
  public void setVcenter(String  vcenter) {
    this.vcenter = vcenter;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VinfraMgmtNwChangeDetails objVinfraMgmtNwChangeDetails = (VinfraMgmtNwChangeDetails) o;
  return   Objects.equals(this.vcenter, objVinfraMgmtNwChangeDetails.vcenter)&&
  Objects.equals(this.existingNw, objVinfraMgmtNwChangeDetails.existingNw)&&
  Objects.equals(this.newNw, objVinfraMgmtNwChangeDetails.newNw);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VinfraMgmtNwChangeDetails {\n");
      sb.append("    existingNw: ").append(toIndentedString(existingNw)).append("\n");
        sb.append("    newNw: ").append(toIndentedString(newNw)).append("\n");
        sb.append("    vcenter: ").append(toIndentedString(vcenter)).append("\n");
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

