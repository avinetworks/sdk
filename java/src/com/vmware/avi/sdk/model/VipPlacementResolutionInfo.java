package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VipPlacementResolutionInfo is a POJO class extends AviRestResource that used for creating
 * VipPlacementResolutionInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VipPlacementResolutionInfo  {
    @JsonProperty("ip")
    private IpAddr ip = null;

    @JsonProperty("networks")
    private List<DiscoveredNetwork> networks = null;

    @JsonProperty("pool_uuid")
    private String poolUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip of obj type vipplacementresolutioninfo field type str  type ref.
   * @return ip
   */
  public IpAddr getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip of obj type vipplacementresolutioninfo field type str  type ref.
   * @param ip set the ip.
   */
  public void setIp(IpAddr ip) {
    this.ip = ip;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property networks of obj type vipplacementresolutioninfo field type str  type array.
   * @return networks
   */
  public List<DiscoveredNetwork> getNetworks() {
    return networks;
  }

  /**
   * This is the setter method. this will set the networks
   * Placeholder for description of property networks of obj type vipplacementresolutioninfo field type str  type array.
   * @return networks
   */
  public void setNetworks(List<DiscoveredNetwork>  networks) {
    this.networks = networks;
  }

  /**
   * This is the setter method this will set the networks
   * Placeholder for description of property networks of obj type vipplacementresolutioninfo field type str  type array.
   * @return networks
   */
  public VipPlacementResolutionInfo addNetworksItem(DiscoveredNetwork networksItem) {
    if (this.networks == null) {
      this.networks = new ArrayList<DiscoveredNetwork>();
    }
    this.networks.add(networksItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of pool.
   * @return poolUuid
   */
  public String getPoolUuid() {
    return poolUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of pool.
   * @param poolUuid set the poolUuid.
   */
  public void setPoolUuid(String  poolUuid) {
    this.poolUuid = poolUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VipPlacementResolutionInfo objVipPlacementResolutionInfo = (VipPlacementResolutionInfo) o;
  return   Objects.equals(this.ip, objVipPlacementResolutionInfo.ip)&&
  Objects.equals(this.poolUuid, objVipPlacementResolutionInfo.poolUuid)&&
  Objects.equals(this.networks, objVipPlacementResolutionInfo.networks);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VipPlacementResolutionInfo {\n");
      sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    networks: ").append(toIndentedString(networks)).append("\n");
        sb.append("    poolUuid: ").append(toIndentedString(poolUuid)).append("\n");
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

