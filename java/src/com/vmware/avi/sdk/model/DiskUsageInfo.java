package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DiskUsageInfo is a POJO class extends AviRestResource that used for creating
 * DiskUsageInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiskUsageInfo  {
    @JsonProperty("disk_usage_on_nodes")
    private List<DiskUsagePerNode> diskUsageOnNodes = null;


  /**
   * This is the getter method this will return the attribute value.
   * Identifies the disk usage of the node.
   * Field introduced in 17.2.12, 18.1.2.
   * @return diskUsageOnNodes
   */
  public List<DiskUsagePerNode> getDiskUsageOnNodes() {
    return diskUsageOnNodes;
  }

  /**
   * This is the setter method. this will set the diskUsageOnNodes
   * Identifies the disk usage of the node.
   * Field introduced in 17.2.12, 18.1.2.
   * @return diskUsageOnNodes
   */
  public void setDiskUsageOnNodes(List<DiskUsagePerNode>  diskUsageOnNodes) {
    this.diskUsageOnNodes = diskUsageOnNodes;
  }

  /**
   * This is the setter method this will set the diskUsageOnNodes
   * Identifies the disk usage of the node.
   * Field introduced in 17.2.12, 18.1.2.
   * @return diskUsageOnNodes
   */
  public DiskUsageInfo addDiskUsageOnNodesItem(DiskUsagePerNode diskUsageOnNodesItem) {
    if (this.diskUsageOnNodes == null) {
      this.diskUsageOnNodes = new ArrayList<DiskUsagePerNode>();
    }
    this.diskUsageOnNodes.add(diskUsageOnNodesItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DiskUsageInfo objDiskUsageInfo = (DiskUsageInfo) o;
  return   Objects.equals(this.diskUsageOnNodes, objDiskUsageInfo.diskUsageOnNodes);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DiskUsageInfo {\n");
      sb.append("    diskUsageOnNodes: ").append(toIndentedString(diskUsageOnNodes)).append("\n");
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

