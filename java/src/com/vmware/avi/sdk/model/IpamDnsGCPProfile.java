package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IpamDnsGCPProfile is a POJO class extends AviRestResource that used for creating
 * IpamDnsGCPProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpamDnsGCPProfile  {
    @JsonProperty("match_se_group_subnet")
    private Boolean matchSeGroupSubnet = false;

    @JsonProperty("network_host_project_id")
    private String networkHostProjectId = null;

    @JsonProperty("region_name")
    private String regionName = null;

    @JsonProperty("se_project_id")
    private String seProjectId = null;

    @JsonProperty("usable_network_refs")
    private List<String> usableNetworkRefs = null;

    @JsonProperty("use_gcp_network")
    private Boolean useGcpNetwork = false;

    @JsonProperty("vpc_network_name")
    private String vpcNetworkName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Match se group subnets for vip placement.
   * Default is to not match se group subnets.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return matchSeGroupSubnet
   */
  public Boolean getMatchSeGroupSubnet() {
    return matchSeGroupSubnet;
  }

  /**
   * This is the setter method to the attribute.
   * Match se group subnets for vip placement.
   * Default is to not match se group subnets.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param matchSeGroupSubnet set the matchSeGroupSubnet.
   */
  public void setMatchSeGroupSubnet(Boolean  matchSeGroupSubnet) {
    this.matchSeGroupSubnet = matchSeGroupSubnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Google cloud platform network host project id.
   * This is the host project in which google cloud platform network resides.
   * Field introduced in 18.1.2.
   * @return networkHostProjectId
   */
  public String getNetworkHostProjectId() {
    return networkHostProjectId;
  }

  /**
   * This is the setter method to the attribute.
   * Google cloud platform network host project id.
   * This is the host project in which google cloud platform network resides.
   * Field introduced in 18.1.2.
   * @param networkHostProjectId set the networkHostProjectId.
   */
  public void setNetworkHostProjectId(String  networkHostProjectId) {
    this.networkHostProjectId = networkHostProjectId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Google cloud platform region name.
   * Field introduced in 18.1.2.
   * @return regionName
   */
  public String getRegionName() {
    return regionName;
  }

  /**
   * This is the setter method to the attribute.
   * Google cloud platform region name.
   * Field introduced in 18.1.2.
   * @param regionName set the regionName.
   */
  public void setRegionName(String  regionName) {
    this.regionName = regionName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Google cloud platform project id.
   * This is the project where service engines are hosted.
   * This field is optional.
   * By default it will use the value of the field network_host_project_id.
   * Field introduced in 18.1.2.
   * @return seProjectId
   */
  public String getSeProjectId() {
    return seProjectId;
  }

  /**
   * This is the setter method to the attribute.
   * Google cloud platform project id.
   * This is the project where service engines are hosted.
   * This field is optional.
   * By default it will use the value of the field network_host_project_id.
   * Field introduced in 18.1.2.
   * @param seProjectId set the seProjectId.
   */
  public void setSeProjectId(String  seProjectId) {
    this.seProjectId = seProjectId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * It is a reference to an object of type network.
   * @return usableNetworkRefs
   */
  public List<String> getUsableNetworkRefs() {
    return usableNetworkRefs;
  }

  /**
   * This is the setter method. this will set the usableNetworkRefs
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * It is a reference to an object of type network.
   * @return usableNetworkRefs
   */
  public void setUsableNetworkRefs(List<String>  usableNetworkRefs) {
    this.usableNetworkRefs = usableNetworkRefs;
  }

  /**
   * This is the setter method this will set the usableNetworkRefs
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * It is a reference to an object of type network.
   * @return usableNetworkRefs
   */
  public IpamDnsGCPProfile addUsableNetworkRefsItem(String usableNetworkRefsItem) {
    if (this.usableNetworkRefs == null) {
      this.usableNetworkRefs = new ArrayList<String>();
    }
    this.usableNetworkRefs.add(usableNetworkRefsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use google cloud platform network for private vip allocation.
   * By default avi vantage network is used for private vip allocation.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useGcpNetwork
   */
  public Boolean getUseGcpNetwork() {
    return useGcpNetwork;
  }

  /**
   * This is the setter method to the attribute.
   * Use google cloud platform network for private vip allocation.
   * By default avi vantage network is used for private vip allocation.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useGcpNetwork set the useGcpNetwork.
   */
  public void setUseGcpNetwork(Boolean  useGcpNetwork) {
    this.useGcpNetwork = useGcpNetwork;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Google cloud platform vpc network name.
   * Field introduced in 18.1.2.
   * @return vpcNetworkName
   */
  public String getVpcNetworkName() {
    return vpcNetworkName;
  }

  /**
   * This is the setter method to the attribute.
   * Google cloud platform vpc network name.
   * Field introduced in 18.1.2.
   * @param vpcNetworkName set the vpcNetworkName.
   */
  public void setVpcNetworkName(String  vpcNetworkName) {
    this.vpcNetworkName = vpcNetworkName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IpamDnsGCPProfile objIpamDnsGCPProfile = (IpamDnsGCPProfile) o;
  return   Objects.equals(this.usableNetworkRefs, objIpamDnsGCPProfile.usableNetworkRefs)&&
  Objects.equals(this.matchSeGroupSubnet, objIpamDnsGCPProfile.matchSeGroupSubnet)&&
  Objects.equals(this.useGcpNetwork, objIpamDnsGCPProfile.useGcpNetwork)&&
  Objects.equals(this.networkHostProjectId, objIpamDnsGCPProfile.networkHostProjectId)&&
  Objects.equals(this.seProjectId, objIpamDnsGCPProfile.seProjectId)&&
  Objects.equals(this.regionName, objIpamDnsGCPProfile.regionName)&&
  Objects.equals(this.vpcNetworkName, objIpamDnsGCPProfile.vpcNetworkName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IpamDnsGCPProfile {\n");
      sb.append("    matchSeGroupSubnet: ").append(toIndentedString(matchSeGroupSubnet)).append("\n");
        sb.append("    networkHostProjectId: ").append(toIndentedString(networkHostProjectId)).append("\n");
        sb.append("    regionName: ").append(toIndentedString(regionName)).append("\n");
        sb.append("    seProjectId: ").append(toIndentedString(seProjectId)).append("\n");
        sb.append("    usableNetworkRefs: ").append(toIndentedString(usableNetworkRefs)).append("\n");
        sb.append("    useGcpNetwork: ").append(toIndentedString(useGcpNetwork)).append("\n");
        sb.append("    vpcNetworkName: ").append(toIndentedString(vpcNetworkName)).append("\n");
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

