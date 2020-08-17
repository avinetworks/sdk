package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VssPlacement is a POJO class extends AviRestResource that used for creating
 * VssPlacement.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VssPlacement  {
    @JsonProperty("core_nonaffinity")
    private Integer coreNonaffinity = 2;

    @JsonProperty("num_subcores")
    private Integer numSubcores = 4;



  /**
   * This is the getter method this will return the attribute value.
   * Degree of core non-affinity for vs placement.
   * Allowed values are 1-256.
   * Field introduced in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @return coreNonaffinity
   */
  public Integer getCoreNonaffinity() {
    return coreNonaffinity;
  }

  /**
   * This is the setter method to the attribute.
   * Degree of core non-affinity for vs placement.
   * Allowed values are 1-256.
   * Field introduced in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @param coreNonaffinity set the coreNonaffinity.
   */
  public void setCoreNonaffinity(Integer  coreNonaffinity) {
    this.coreNonaffinity = coreNonaffinity;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of sub-cores that comprise a cpu core.
   * Allowed values are 1-128.
   * Field introduced in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @return numSubcores
   */
  public Integer getNumSubcores() {
    return numSubcores;
  }

  /**
   * This is the setter method to the attribute.
   * Number of sub-cores that comprise a cpu core.
   * Allowed values are 1-128.
   * Field introduced in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @param numSubcores set the numSubcores.
   */
  public void setNumSubcores(Integer  numSubcores) {
    this.numSubcores = numSubcores;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VssPlacement objVssPlacement = (VssPlacement) o;
  return   Objects.equals(this.numSubcores, objVssPlacement.numSubcores)&&
  Objects.equals(this.coreNonaffinity, objVssPlacement.coreNonaffinity);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VssPlacement {\n");
      sb.append("    coreNonaffinity: ").append(toIndentedString(coreNonaffinity)).append("\n");
        sb.append("    numSubcores: ").append(toIndentedString(numSubcores)).append("\n");
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

