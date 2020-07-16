package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbPool is a POJO class extends AviRestResource that used for creating
 * GslbPool.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbPool  {
    @JsonProperty("algorithm")
    private String algorithm = "GSLB_ALGORITHM_ROUND_ROBIN";

    @JsonProperty("consistent_hash_mask")
    private Integer consistentHashMask = null;

    @JsonProperty("consistent_hash_mask6")
    private Integer consistentHashMask6 = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("fallback_algorithm")
    private String fallbackAlgorithm = null;

    @JsonProperty("members")
    private List<GslbPoolMember> members = null;

    @JsonProperty("min_health_monitors_up")
    private Integer minHealthMonitorsUp = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("priority")
    private Integer priority = 10;



  /**
   * This is the getter method this will return the attribute value.
   * The load balancing algorithm will pick a local member within the gslb service list of available members.
   * Enum options - GSLB_ALGORITHM_ROUND_ROBIN, GSLB_ALGORITHM_CONSISTENT_HASH, GSLB_ALGORITHM_GEO, GSLB_ALGORITHM_TOPOLOGY.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_ALGORITHM_ROUND_ROBIN.
   * @return algorithm
   */
  public String getAlgorithm() {
    return algorithm;
  }

  /**
   * This is the setter method to the attribute.
   * The load balancing algorithm will pick a local member within the gslb service list of available members.
   * Enum options - GSLB_ALGORITHM_ROUND_ROBIN, GSLB_ALGORITHM_CONSISTENT_HASH, GSLB_ALGORITHM_GEO, GSLB_ALGORITHM_TOPOLOGY.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_ALGORITHM_ROUND_ROBIN.
   * @param algorithm set the algorithm.
   */
  public void setAlgorithm(String  algorithm) {
    this.algorithm = algorithm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mask to be applied on client ip for consistent hash algorithm.
   * Allowed values are 1-31.
   * @return consistentHashMask
   */
  public Integer getConsistentHashMask() {
    return consistentHashMask;
  }

  /**
   * This is the setter method to the attribute.
   * Mask to be applied on client ip for consistent hash algorithm.
   * Allowed values are 1-31.
   * @param consistentHashMask set the consistentHashMask.
   */
  public void setConsistentHashMask(Integer  consistentHashMask) {
    this.consistentHashMask = consistentHashMask;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mask to be applied on client ipv6 address for consistent hash algorithm.
   * Allowed values are 1-127.
   * Field introduced in 18.2.8, 20.1.1.
   * @return consistentHashMask6
   */
  public Integer getConsistentHashMask6() {
    return consistentHashMask6;
  }

  /**
   * This is the setter method to the attribute.
   * Mask to be applied on client ipv6 address for consistent hash algorithm.
   * Allowed values are 1-127.
   * Field introduced in 18.2.8, 20.1.1.
   * @param consistentHashMask6 set the consistentHashMask6.
   */
  public void setConsistentHashMask6(Integer  consistentHashMask6) {
    this.consistentHashMask6 = consistentHashMask6;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User provided information that records member details such as application owner name, contact, etc.
   * Field introduced in 17.1.3.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * User provided information that records member details such as application owner name, contact, etc.
   * Field introduced in 17.1.3.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable or disable a gslb service pool.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable or disable a gslb service pool.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The fallback load balancing algorithm used to pick a member when the pool algorithm fails to find a valid member.
   * For instance when algorithm is geo and client/server do not have valid geo location.
   * Enum options - GSLB_ALGORITHM_ROUND_ROBIN, GSLB_ALGORITHM_CONSISTENT_HASH, GSLB_ALGORITHM_GEO, GSLB_ALGORITHM_TOPOLOGY.
   * Field introduced in 18.2.3.
   * @return fallbackAlgorithm
   */
  public String getFallbackAlgorithm() {
    return fallbackAlgorithm;
  }

  /**
   * This is the setter method to the attribute.
   * The fallback load balancing algorithm used to pick a member when the pool algorithm fails to find a valid member.
   * For instance when algorithm is geo and client/server do not have valid geo location.
   * Enum options - GSLB_ALGORITHM_ROUND_ROBIN, GSLB_ALGORITHM_CONSISTENT_HASH, GSLB_ALGORITHM_GEO, GSLB_ALGORITHM_TOPOLOGY.
   * Field introduced in 18.2.3.
   * @param fallbackAlgorithm set the fallbackAlgorithm.
   */
  public void setFallbackAlgorithm(String  fallbackAlgorithm) {
    this.fallbackAlgorithm = fallbackAlgorithm;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Select list of vips belonging to this gslb service.
   * @return members
   */
  public List<GslbPoolMember> getMembers() {
    return members;
  }

  /**
   * This is the setter method. this will set the members
   * Select list of vips belonging to this gslb service.
   * @return members
   */
  public void setMembers(List<GslbPoolMember>  members) {
    this.members = members;
  }

  /**
   * This is the setter method this will set the members
   * Select list of vips belonging to this gslb service.
   * @return members
   */
  public GslbPool addMembersItem(GslbPoolMember membersItem) {
    if (this.members == null) {
      this.members = new ArrayList<GslbPoolMember>();
    }
    this.members.add(membersItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum number of health monitors in up state to mark the member up.
   * Field introduced in 20.1.1.
   * @return minHealthMonitorsUp
   */
  public Integer getMinHealthMonitorsUp() {
    return minHealthMonitorsUp;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum number of health monitors in up state to mark the member up.
   * Field introduced in 20.1.1.
   * @param minHealthMonitorsUp set the minHealthMonitorsUp.
   */
  public void setMinHealthMonitorsUp(Integer  minHealthMonitorsUp) {
    this.minHealthMonitorsUp = minHealthMonitorsUp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the gslb service pool.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the gslb service pool.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Priority of this pool of members.
   * The higher the number, the higher is the priority of the pool.
   * The dns service chooses the pool with the highest priority that is operationally up.
   * Allowed values are 0-100.
   * Special values are 0 - 'do not choose members from this pool.a priority of 0 is equivalent to disabling the pool.'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return priority
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * This is the setter method to the attribute.
   * Priority of this pool of members.
   * The higher the number, the higher is the priority of the pool.
   * The dns service chooses the pool with the highest priority that is operationally up.
   * Allowed values are 0-100.
   * Special values are 0 - 'do not choose members from this pool.a priority of 0 is equivalent to disabling the pool.'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param priority set the priority.
   */
  public void setPriority(Integer  priority) {
    this.priority = priority;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbPool objGslbPool = (GslbPool) o;
  return   Objects.equals(this.name, objGslbPool.name)&&
  Objects.equals(this.algorithm, objGslbPool.algorithm)&&
  Objects.equals(this.consistentHashMask, objGslbPool.consistentHashMask)&&
  Objects.equals(this.enabled, objGslbPool.enabled)&&
  Objects.equals(this.priority, objGslbPool.priority)&&
  Objects.equals(this.minHealthMonitorsUp, objGslbPool.minHealthMonitorsUp)&&
  Objects.equals(this.members, objGslbPool.members)&&
  Objects.equals(this.consistentHashMask6, objGslbPool.consistentHashMask6)&&
  Objects.equals(this.fallbackAlgorithm, objGslbPool.fallbackAlgorithm)&&
  Objects.equals(this.description, objGslbPool.description);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbPool {\n");
      sb.append("    algorithm: ").append(toIndentedString(algorithm)).append("\n");
        sb.append("    consistentHashMask: ").append(toIndentedString(consistentHashMask)).append("\n");
        sb.append("    consistentHashMask6: ").append(toIndentedString(consistentHashMask6)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    fallbackAlgorithm: ").append(toIndentedString(fallbackAlgorithm)).append("\n");
        sb.append("    members: ").append(toIndentedString(members)).append("\n");
        sb.append("    minHealthMonitorsUp: ").append(toIndentedString(minHealthMonitorsUp)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
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

