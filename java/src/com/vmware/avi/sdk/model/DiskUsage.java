package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DiskUsage is a POJO class extends AviRestResource that used for creating
 * DiskUsage.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiskUsage  {
    @JsonProperty("cntlr_disk_free")
    private List<OverallInfo> cntlrDiskFree = null;

    @JsonProperty("cntlr_disk_usage")
    private List<PartitionInfo> cntlrDiskUsage = null;

    @JsonProperty("se_disk_free")
    private List<OverallInfo> seDiskFree = null;

    @JsonProperty("se_disk_usage")
    private List<PartitionInfo> seDiskUsage = null;


  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cntlr_disk_free of obj type diskusage field type str  type array.
   * @return cntlrDiskFree
   */
  public List<OverallInfo> getCntlrDiskFree() {
    return cntlrDiskFree;
  }

  /**
   * This is the setter method. this will set the cntlrDiskFree
   * Placeholder for description of property cntlr_disk_free of obj type diskusage field type str  type array.
   * @return cntlrDiskFree
   */
  public void setCntlrDiskFree(List<OverallInfo>  cntlrDiskFree) {
    this.cntlrDiskFree = cntlrDiskFree;
  }

  /**
   * This is the setter method this will set the cntlrDiskFree
   * Placeholder for description of property cntlr_disk_free of obj type diskusage field type str  type array.
   * @return cntlrDiskFree
   */
  public DiskUsage addCntlrDiskFreeItem(OverallInfo cntlrDiskFreeItem) {
    if (this.cntlrDiskFree == null) {
      this.cntlrDiskFree = new ArrayList<OverallInfo>();
    }
    this.cntlrDiskFree.add(cntlrDiskFreeItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cntlr_disk_usage of obj type diskusage field type str  type array.
   * @return cntlrDiskUsage
   */
  public List<PartitionInfo> getCntlrDiskUsage() {
    return cntlrDiskUsage;
  }

  /**
   * This is the setter method. this will set the cntlrDiskUsage
   * Placeholder for description of property cntlr_disk_usage of obj type diskusage field type str  type array.
   * @return cntlrDiskUsage
   */
  public void setCntlrDiskUsage(List<PartitionInfo>  cntlrDiskUsage) {
    this.cntlrDiskUsage = cntlrDiskUsage;
  }

  /**
   * This is the setter method this will set the cntlrDiskUsage
   * Placeholder for description of property cntlr_disk_usage of obj type diskusage field type str  type array.
   * @return cntlrDiskUsage
   */
  public DiskUsage addCntlrDiskUsageItem(PartitionInfo cntlrDiskUsageItem) {
    if (this.cntlrDiskUsage == null) {
      this.cntlrDiskUsage = new ArrayList<PartitionInfo>();
    }
    this.cntlrDiskUsage.add(cntlrDiskUsageItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_disk_free of obj type diskusage field type str  type array.
   * @return seDiskFree
   */
  public List<OverallInfo> getSeDiskFree() {
    return seDiskFree;
  }

  /**
   * This is the setter method. this will set the seDiskFree
   * Placeholder for description of property se_disk_free of obj type diskusage field type str  type array.
   * @return seDiskFree
   */
  public void setSeDiskFree(List<OverallInfo>  seDiskFree) {
    this.seDiskFree = seDiskFree;
  }

  /**
   * This is the setter method this will set the seDiskFree
   * Placeholder for description of property se_disk_free of obj type diskusage field type str  type array.
   * @return seDiskFree
   */
  public DiskUsage addSeDiskFreeItem(OverallInfo seDiskFreeItem) {
    if (this.seDiskFree == null) {
      this.seDiskFree = new ArrayList<OverallInfo>();
    }
    this.seDiskFree.add(seDiskFreeItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_disk_usage of obj type diskusage field type str  type array.
   * @return seDiskUsage
   */
  public List<PartitionInfo> getSeDiskUsage() {
    return seDiskUsage;
  }

  /**
   * This is the setter method. this will set the seDiskUsage
   * Placeholder for description of property se_disk_usage of obj type diskusage field type str  type array.
   * @return seDiskUsage
   */
  public void setSeDiskUsage(List<PartitionInfo>  seDiskUsage) {
    this.seDiskUsage = seDiskUsage;
  }

  /**
   * This is the setter method this will set the seDiskUsage
   * Placeholder for description of property se_disk_usage of obj type diskusage field type str  type array.
   * @return seDiskUsage
   */
  public DiskUsage addSeDiskUsageItem(PartitionInfo seDiskUsageItem) {
    if (this.seDiskUsage == null) {
      this.seDiskUsage = new ArrayList<PartitionInfo>();
    }
    this.seDiskUsage.add(seDiskUsageItem);
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
  DiskUsage objDiskUsage = (DiskUsage) o;
  return   Objects.equals(this.cntlrDiskUsage, objDiskUsage.cntlrDiskUsage)&&
  Objects.equals(this.cntlrDiskFree, objDiskUsage.cntlrDiskFree)&&
  Objects.equals(this.seDiskUsage, objDiskUsage.seDiskUsage)&&
  Objects.equals(this.seDiskFree, objDiskUsage.seDiskFree);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DiskUsage {\n");
      sb.append("    cntlrDiskFree: ").append(toIndentedString(cntlrDiskFree)).append("\n");
        sb.append("    cntlrDiskUsage: ").append(toIndentedString(cntlrDiskUsage)).append("\n");
        sb.append("    seDiskFree: ").append(toIndentedString(seDiskFree)).append("\n");
        sb.append("    seDiskUsage: ").append(toIndentedString(seDiskUsage)).append("\n");
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

