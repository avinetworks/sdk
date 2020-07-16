package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SubnetRuntime is a POJO class extends AviRestResource that used for creating
 * SubnetRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubnetRuntime  {
    @JsonProperty("free_ip_count")
    private Integer freeIpCount = null;

    @JsonProperty("ip_alloced")
    private List<IpAllocInfo> ipAlloced = null;

    @JsonProperty("prefix")
    private IpAddrPrefix prefix = null;

    @JsonProperty("total_ip_count")
    private Integer totalIpCount = null;

    @JsonProperty("used_ip_count")
    private Integer usedIpCount = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property free_ip_count of obj type subnetruntime field type str  type integer.
   * @return freeIpCount
   */
  public Integer getFreeIpCount() {
    return freeIpCount;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property free_ip_count of obj type subnetruntime field type str  type integer.
   * @param freeIpCount set the freeIpCount.
   */
  public void setFreeIpCount(Integer  freeIpCount) {
    this.freeIpCount = freeIpCount;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip_alloced of obj type subnetruntime field type str  type array.
   * @return ipAlloced
   */
  public List<IpAllocInfo> getIpAlloced() {
    return ipAlloced;
  }

  /**
   * This is the setter method. this will set the ipAlloced
   * Placeholder for description of property ip_alloced of obj type subnetruntime field type str  type array.
   * @return ipAlloced
   */
  public void setIpAlloced(List<IpAllocInfo>  ipAlloced) {
    this.ipAlloced = ipAlloced;
  }

  /**
   * This is the setter method this will set the ipAlloced
   * Placeholder for description of property ip_alloced of obj type subnetruntime field type str  type array.
   * @return ipAlloced
   */
  public SubnetRuntime addIpAllocedItem(IpAllocInfo ipAllocedItem) {
    if (this.ipAlloced == null) {
      this.ipAlloced = new ArrayList<IpAllocInfo>();
    }
    this.ipAlloced.add(ipAllocedItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property prefix of obj type subnetruntime field type str  type ref.
   * @return prefix
   */
  public IpAddrPrefix getPrefix() {
    return prefix;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property prefix of obj type subnetruntime field type str  type ref.
   * @param prefix set the prefix.
   */
  public void setPrefix(IpAddrPrefix prefix) {
    this.prefix = prefix;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property total_ip_count of obj type subnetruntime field type str  type integer.
   * @return totalIpCount
   */
  public Integer getTotalIpCount() {
    return totalIpCount;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property total_ip_count of obj type subnetruntime field type str  type integer.
   * @param totalIpCount set the totalIpCount.
   */
  public void setTotalIpCount(Integer  totalIpCount) {
    this.totalIpCount = totalIpCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property used_ip_count of obj type subnetruntime field type str  type integer.
   * @return usedIpCount
   */
  public Integer getUsedIpCount() {
    return usedIpCount;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property used_ip_count of obj type subnetruntime field type str  type integer.
   * @param usedIpCount set the usedIpCount.
   */
  public void setUsedIpCount(Integer  usedIpCount) {
    this.usedIpCount = usedIpCount;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SubnetRuntime objSubnetRuntime = (SubnetRuntime) o;
  return   Objects.equals(this.totalIpCount, objSubnetRuntime.totalIpCount)&&
  Objects.equals(this.usedIpCount, objSubnetRuntime.usedIpCount)&&
  Objects.equals(this.prefix, objSubnetRuntime.prefix)&&
  Objects.equals(this.ipAlloced, objSubnetRuntime.ipAlloced)&&
  Objects.equals(this.freeIpCount, objSubnetRuntime.freeIpCount);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SubnetRuntime {\n");
      sb.append("    freeIpCount: ").append(toIndentedString(freeIpCount)).append("\n");
        sb.append("    ipAlloced: ").append(toIndentedString(ipAlloced)).append("\n");
        sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
        sb.append("    totalIpCount: ").append(toIndentedString(totalIpCount)).append("\n");
        sb.append("    usedIpCount: ").append(toIndentedString(usedIpCount)).append("\n");
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

