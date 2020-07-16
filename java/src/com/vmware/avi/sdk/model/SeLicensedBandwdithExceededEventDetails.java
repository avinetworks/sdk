package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeLicensedBandwdithExceededEventDetails is a POJO class extends AviRestResource that used for creating
 * SeLicensedBandwdithExceededEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeLicensedBandwdithExceededEventDetails  {
    @JsonProperty("num_pkts_dropped")
    private Integer numPktsDropped = null;

    @JsonProperty("se_ref")
    private String seRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * Number of packets dropped since the last event.
   * @return numPktsDropped
   */
  public Integer getNumPktsDropped() {
    return numPktsDropped;
  }

  /**
   * This is the setter method to the attribute.
   * Number of packets dropped since the last event.
   * @param numPktsDropped set the numPktsDropped.
   */
  public void setNumPktsDropped(Integer  numPktsDropped) {
    this.numPktsDropped = numPktsDropped;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the se responsible for this event.
   * It is a reference to an object of type serviceengine.
   * @return seRef
   */
  public String getSeRef() {
    return seRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the se responsible for this event.
   * It is a reference to an object of type serviceengine.
   * @param seRef set the seRef.
   */
  public void setSeRef(String  seRef) {
    this.seRef = seRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeLicensedBandwdithExceededEventDetails objSeLicensedBandwdithExceededEventDetails = (SeLicensedBandwdithExceededEventDetails) o;
  return   Objects.equals(this.numPktsDropped, objSeLicensedBandwdithExceededEventDetails.numPktsDropped)&&
  Objects.equals(this.seRef, objSeLicensedBandwdithExceededEventDetails.seRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeLicensedBandwdithExceededEventDetails {\n");
      sb.append("    numPktsDropped: ").append(toIndentedString(numPktsDropped)).append("\n");
        sb.append("    seRef: ").append(toIndentedString(seRef)).append("\n");
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

