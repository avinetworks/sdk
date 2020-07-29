package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CPUUsagePerNode is a POJO class extends AviRestResource that used for creating
 * CPUUsagePerNode.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CPUUsagePerNode  {
    @JsonProperty("cpu_info")
    private CPUUsage cpuInfo = null;

    @JsonProperty("name")
    private String name = null;



  /**
   * This is the getter method this will return the attribute value.
   * Identifies the cpu usage of the node.
   * Field introduced in 17.2.12, 18.1.2.
   * @return cpuInfo
   */
  public CPUUsage getCpuInfo() {
    return cpuInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Identifies the cpu usage of the node.
   * Field introduced in 17.2.12, 18.1.2.
   * @param cpuInfo set the cpuInfo.
   */
  public void setCpuInfo(CPUUsage cpuInfo) {
    this.cpuInfo = cpuInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Identifies the ip address of the node.
   * Field introduced in 17.2.12, 18.1.2.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Identifies the ip address of the node.
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
  CPUUsagePerNode objCPUUsagePerNode = (CPUUsagePerNode) o;
  return   Objects.equals(this.name, objCPUUsagePerNode.name)&&
  Objects.equals(this.cpuInfo, objCPUUsagePerNode.cpuInfo);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CPUUsagePerNode {\n");
      sb.append("    cpuInfo: ").append(toIndentedString(cpuInfo)).append("\n");
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

