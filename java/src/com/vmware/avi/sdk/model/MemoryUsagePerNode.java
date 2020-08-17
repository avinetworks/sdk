package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MemoryUsagePerNode is a POJO class extends AviRestResource that used for creating
 * MemoryUsagePerNode.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemoryUsagePerNode  {
    @JsonProperty("mem_info")
    private MemoryUsage memInfo = null;

    @JsonProperty("name")
    private String name = null;



  /**
   * This is the getter method this will return the attribute value.
   * Identifies the memory info of the node.
   * Field introduced in 17.2.12, 18.1.2.
   * @return memInfo
   */
  public MemoryUsage getMemInfo() {
    return memInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Identifies the memory info of the node.
   * Field introduced in 17.2.12, 18.1.2.
   * @param memInfo set the memInfo.
   */
  public void setMemInfo(MemoryUsage memInfo) {
    this.memInfo = memInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Identifies the name of the node.
   * Field introduced in 17.2.12, 18.1.2.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Identifies the name of the node.
   * Field introduced in 17.2.12, 18.1.2.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MemoryUsagePerNode objMemoryUsagePerNode = (MemoryUsagePerNode) o;
  return   Objects.equals(this.name, objMemoryUsagePerNode.name)&&
  Objects.equals(this.memInfo, objMemoryUsagePerNode.memInfo);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MemoryUsagePerNode {\n");
      sb.append("    memInfo: ").append(toIndentedString(memInfo)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

