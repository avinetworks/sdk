package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OverallInfo is a POJO class extends AviRestResource that used for creating
 * OverallInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OverallInfo  {
    @JsonProperty("available")
    private Integer available = null;

    @JsonProperty("free_percent")
    private String freePercent = null;

    @JsonProperty("path")
    private String path = null;

    @JsonProperty("size")
    private Integer size = null;

    @JsonProperty("used")
    private Integer used = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property available of obj type overallinfo field type str  type integer.
   * @return available
   */
  public Integer getAvailable() {
    return available;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property available of obj type overallinfo field type str  type integer.
   * @param available set the available.
   */
  public void setAvailable(Integer  available) {
    this.available = available;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property free_percent of obj type overallinfo field type str  type string.
   * @return freePercent
   */
  public String getFreePercent() {
    return freePercent;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property free_percent of obj type overallinfo field type str  type string.
   * @param freePercent set the freePercent.
   */
  public void setFreePercent(String  freePercent) {
    this.freePercent = freePercent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property path of obj type overallinfo field type str  type string.
   * @return path
   */
  public String getPath() {
    return path;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property path of obj type overallinfo field type str  type string.
   * @param path set the path.
   */
  public void setPath(String  path) {
    this.path = path;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property size of obj type overallinfo field type str  type integer.
   * @return size
   */
  public Integer getSize() {
    return size;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property size of obj type overallinfo field type str  type integer.
   * @param size set the size.
   */
  public void setSize(Integer  size) {
    this.size = size;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property used of obj type overallinfo field type str  type integer.
   * @return used
   */
  public Integer getUsed() {
    return used;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property used of obj type overallinfo field type str  type integer.
   * @param used set the used.
   */
  public void setUsed(Integer  used) {
    this.used = used;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OverallInfo objOverallInfo = (OverallInfo) o;
  return   Objects.equals(this.available, objOverallInfo.available)&&
  Objects.equals(this.path, objOverallInfo.path)&&
  Objects.equals(this.used, objOverallInfo.used)&&
  Objects.equals(this.freePercent, objOverallInfo.freePercent)&&
  Objects.equals(this.size, objOverallInfo.size);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OverallInfo {\n");
      sb.append("    available: ").append(toIndentedString(available)).append("\n");
        sb.append("    freePercent: ").append(toIndentedString(freePercent)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    used: ").append(toIndentedString(used)).append("\n");
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

