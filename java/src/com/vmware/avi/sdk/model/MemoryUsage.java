package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MemoryUsage is a POJO class extends AviRestResource that used for creating
 * MemoryUsage.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemoryUsage  {
    @JsonProperty("free")
    private Integer free = null;

    @JsonProperty("total")
    private Integer total = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property free of obj type memoryusage field type str  type integer.
   * @return free
   */
  public Integer getFree() {
    return free;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property free of obj type memoryusage field type str  type integer.
   * @param free set the free.
   */
  public void setFree(Integer  free) {
    this.free = free;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property total of obj type memoryusage field type str  type integer.
   * @return total
   */
  public Integer getTotal() {
    return total;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property total of obj type memoryusage field type str  type integer.
   * @param total set the total.
   */
  public void setTotal(Integer  total) {
    this.total = total;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MemoryUsage objMemoryUsage = (MemoryUsage) o;
  return   Objects.equals(this.total, objMemoryUsage.total)&&
  Objects.equals(this.free, objMemoryUsage.free);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MemoryUsage {\n");
      sb.append("    free: ").append(toIndentedString(free)).append("\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

