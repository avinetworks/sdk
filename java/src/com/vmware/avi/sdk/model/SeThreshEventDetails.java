package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeThreshEventDetails is a POJO class extends AviRestResource that used for creating
 * SeThreshEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeThreshEventDetails  {
    @JsonProperty("curr_value")
    private Integer currValue = null;

    @JsonProperty("thresh")
    private Integer thresh = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property curr_value of obj type sethresheventdetails field type str  type integer.
   * @return currValue
   */
  public Integer getCurrValue() {
    return currValue;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property curr_value of obj type sethresheventdetails field type str  type integer.
   * @param currValue set the currValue.
   */
  public void setCurrValue(Integer  currValue) {
    this.currValue = currValue;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property thresh of obj type sethresheventdetails field type str  type integer.
   * @return thresh
   */
  public Integer getThresh() {
    return thresh;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property thresh of obj type sethresheventdetails field type str  type integer.
   * @param thresh set the thresh.
   */
  public void setThresh(Integer  thresh) {
    this.thresh = thresh;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeThreshEventDetails objSeThreshEventDetails = (SeThreshEventDetails) o;
  return   Objects.equals(this.currValue, objSeThreshEventDetails.currValue)&&
  Objects.equals(this.thresh, objSeThreshEventDetails.thresh);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeThreshEventDetails {\n");
      sb.append("    currValue: ").append(toIndentedString(currValue)).append("\n");
        sb.append("    thresh: ").append(toIndentedString(thresh)).append("\n");
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

