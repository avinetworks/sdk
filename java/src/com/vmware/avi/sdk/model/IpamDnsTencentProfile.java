package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IpamDnsTencentProfile is a POJO class extends AviRestResource that used for creating
 * IpamDnsTencentProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpamDnsTencentProfile  {
    @JsonProperty("cloud_credentials_ref")
    private String cloudCredentialsRef = null;

    @JsonProperty("region")
    private String region = null;

    @JsonProperty("usable_subnet_ids")
    private List<String> usableSubnetIds = null;

    @JsonProperty("vpc_id")
    private String vpcId = null;

    @JsonProperty("zones")
    private List<TencentZoneNetwork> zones = null;



  /**
   * This is the getter method this will return the attribute value.
   * Credentials to access tencent cloud.
   * It is a reference to an object of type cloudconnectoruser.
   * Field introduced in 18.2.3.
   * @return cloudCredentialsRef
   */
  public String getCloudCredentialsRef() {
    return cloudCredentialsRef;
  }

  /**
   * This is the setter method to the attribute.
   * Credentials to access tencent cloud.
   * It is a reference to an object of type cloudconnectoruser.
   * Field introduced in 18.2.3.
   * @param cloudCredentialsRef set the cloudCredentialsRef.
   */
  public void setCloudCredentialsRef(String  cloudCredentialsRef) {
    this.cloudCredentialsRef = cloudCredentialsRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vpc region.
   * Field introduced in 18.2.3.
   * @return region
   */
  public String getRegion() {
    return region;
  }

  /**
   * This is the setter method to the attribute.
   * Vpc region.
   * Field introduced in 18.2.3.
   * @param region set the region.
   */
  public void setRegion(String  region) {
    this.region = region;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * Field introduced in 18.2.3.
   * @return usableSubnetIds
   */
  public List<String> getUsableSubnetIds() {
    return usableSubnetIds;
  }

  /**
   * This is the setter method. this will set the usableSubnetIds
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * Field introduced in 18.2.3.
   * @return usableSubnetIds
   */
  public void setUsableSubnetIds(List<String>  usableSubnetIds) {
    this.usableSubnetIds = usableSubnetIds;
  }

  /**
   * This is the setter method this will set the usableSubnetIds
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * Field introduced in 18.2.3.
   * @return usableSubnetIds
   */
  public IpamDnsTencentProfile addUsableSubnetIdsItem(String usableSubnetIdsItem) {
    if (this.usableSubnetIds == null) {
      this.usableSubnetIds = new ArrayList<String>();
    }
    this.usableSubnetIds.add(usableSubnetIdsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vpc id.
   * Field introduced in 18.2.3.
   * @return vpcId
   */
  public String getVpcId() {
    return vpcId;
  }

  /**
   * This is the setter method to the attribute.
   * Vpc id.
   * Field introduced in 18.2.3.
   * @param vpcId set the vpcId.
   */
  public void setVpcId(String  vpcId) {
    this.vpcId = vpcId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Network configuration for virtual ip per az.
   * Field introduced in 18.2.3.
   * @return zones
   */
  public List<TencentZoneNetwork> getZones() {
    return zones;
  }

  /**
   * This is the setter method. this will set the zones
   * Network configuration for virtual ip per az.
   * Field introduced in 18.2.3.
   * @return zones
   */
  public void setZones(List<TencentZoneNetwork>  zones) {
    this.zones = zones;
  }

  /**
   * This is the setter method this will set the zones
   * Network configuration for virtual ip per az.
   * Field introduced in 18.2.3.
   * @return zones
   */
  public IpamDnsTencentProfile addZonesItem(TencentZoneNetwork zonesItem) {
    if (this.zones == null) {
      this.zones = new ArrayList<TencentZoneNetwork>();
    }
    this.zones.add(zonesItem);
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
  IpamDnsTencentProfile objIpamDnsTencentProfile = (IpamDnsTencentProfile) o;
  return   Objects.equals(this.vpcId, objIpamDnsTencentProfile.vpcId)&&
  Objects.equals(this.cloudCredentialsRef, objIpamDnsTencentProfile.cloudCredentialsRef)&&
  Objects.equals(this.usableSubnetIds, objIpamDnsTencentProfile.usableSubnetIds)&&
  Objects.equals(this.zones, objIpamDnsTencentProfile.zones)&&
  Objects.equals(this.region, objIpamDnsTencentProfile.region);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IpamDnsTencentProfile {\n");
      sb.append("    cloudCredentialsRef: ").append(toIndentedString(cloudCredentialsRef)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    usableSubnetIds: ").append(toIndentedString(usableSubnetIds)).append("\n");
        sb.append("    vpcId: ").append(toIndentedString(vpcId)).append("\n");
        sb.append("    zones: ").append(toIndentedString(zones)).append("\n");
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

