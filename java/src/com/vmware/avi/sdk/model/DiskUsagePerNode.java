package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DiskUsagePerNode is a POJO class extends AviRestResource that used for creating
 * DiskUsagePerNode.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiskUsagePerNode  {
    @JsonProperty("disk_info")
    private DiskUsage diskInfo = null;

    @JsonProperty("name")
    private String name = null;



  /**
   * This is the getter method this will return the attribute value.
   * Identifies the disk usage of the node.
   * Field introduced in 17.2.12, 18.1.2.
   * @return diskInfo
   */
  public DiskUsage getDiskInfo() {
    return diskInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Identifies the disk usage of the node.
   * Field introduced in 17.2.12, 18.1.2.
   * @param diskInfo set the diskInfo.
   */
  public void setDiskInfo(DiskUsage diskInfo) {
    this.diskInfo = diskInfo;
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
  DiskUsagePerNode objDiskUsagePerNode = (DiskUsagePerNode) o;
  return   Objects.equals(this.diskInfo, objDiskUsagePerNode.diskInfo)&&
  Objects.equals(this.name, objDiskUsagePerNode.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DiskUsagePerNode {\n");
      sb.append("    diskInfo: ").append(toIndentedString(diskInfo)).append("\n");
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

