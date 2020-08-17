package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CPUUsage is a POJO class extends AviRestResource that used for creating
 * CPUUsage.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CPUUsage  {
    @JsonProperty("num_cores")
    private Integer numCores = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_cores of obj type cpuusage field type str  type integer.
   * @return numCores
   */
  public Integer getNumCores() {
    return numCores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_cores of obj type cpuusage field type str  type integer.
   * @param numCores set the numCores.
   */
  public void setNumCores(Integer  numCores) {
    this.numCores = numCores;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CPUUsage objCPUUsage = (CPUUsage) o;
  return   Objects.equals(this.numCores, objCPUUsage.numCores);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CPUUsage {\n");
      sb.append("    numCores: ").append(toIndentedString(numCores)).append("\n");
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

