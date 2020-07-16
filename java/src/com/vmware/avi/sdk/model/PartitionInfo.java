package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PartitionInfo is a POJO class extends AviRestResource that used for creating
 * PartitionInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartitionInfo  {
    @JsonProperty("path")
    private String path = null;

    @JsonProperty("quota")
    private Integer quota = null;

    @JsonProperty("size")
    private Integer size = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property path of obj type partitioninfo field type str  type string.
   * @return path
   */
  public String getPath() {
    return path;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property path of obj type partitioninfo field type str  type string.
   * @param path set the path.
   */
  public void setPath(String  path) {
    this.path = path;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property quota of obj type partitioninfo field type str  type integer.
   * @return quota
   */
  public Integer getQuota() {
    return quota;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property quota of obj type partitioninfo field type str  type integer.
   * @param quota set the quota.
   */
  public void setQuota(Integer  quota) {
    this.quota = quota;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property size of obj type partitioninfo field type str  type integer.
   * @return size
   */
  public Integer getSize() {
    return size;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property size of obj type partitioninfo field type str  type integer.
   * @param size set the size.
   */
  public void setSize(Integer  size) {
    this.size = size;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  PartitionInfo objPartitionInfo = (PartitionInfo) o;
  return   Objects.equals(this.path, objPartitionInfo.path)&&
  Objects.equals(this.quota, objPartitionInfo.quota)&&
  Objects.equals(this.size, objPartitionInfo.size);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PartitionInfo {\n");
      sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    quota: ").append(toIndentedString(quota)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

