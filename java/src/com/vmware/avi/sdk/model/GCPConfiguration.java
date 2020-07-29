package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GCPConfiguration is a POJO class extends AviRestResource that used for creating
 * GCPConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GCPConfiguration  {
    @JsonProperty("cloud_credentials_ref")
    private String cloudCredentialsRef = null;

    @JsonProperty("encryption_key_id")
    private String encryptionKeyId = null;

    @JsonProperty("firewall_target_tags")
    private List<String> firewallTargetTags = null;

    @JsonProperty("gcs_bucket_name")
    private String gcsBucketName = null;

    @JsonProperty("gcs_project_id")
    private String gcsProjectId = null;

    @JsonProperty("match_se_group_subnet")
    private Boolean matchSeGroupSubnet = false;

    @JsonProperty("network_config")
    private GCPNetworkConfig networkConfig = null;

    @JsonProperty("region_name")
    private String regionName = null;

    @JsonProperty("se_project_id")
    private String seProjectId = null;

    @JsonProperty("vip_allocation_strategy")
    private GCPVIPAllocation vipAllocationStrategy = null;

    @JsonProperty("zones")
    private List<String> zones = null;



  /**
   * This is the getter method this will return the attribute value.
   * Credentials to access google cloud platform apis.
   * It is a reference to an object of type cloudconnectoruser.
   * Field introduced in 18.2.1.
   * @return cloudCredentialsRef
   */
  public String getCloudCredentialsRef() {
    return cloudCredentialsRef;
  }

  /**
   * This is the setter method to the attribute.
   * Credentials to access google cloud platform apis.
   * It is a reference to an object of type cloudconnectoruser.
   * Field introduced in 18.2.1.
   * @param cloudCredentialsRef set the cloudCredentialsRef.
   */
  public void setCloudCredentialsRef(String  cloudCredentialsRef) {
    this.cloudCredentialsRef = cloudCredentialsRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Key resource id of customer-managed encryption key (cmek) used to encrypt service engine disks and images.
   * Field introduced in 20.1.1.
   * @return encryptionKeyId
   */
  public String getEncryptionKeyId() {
    return encryptionKeyId;
  }

  /**
   * This is the setter method to the attribute.
   * Key resource id of customer-managed encryption key (cmek) used to encrypt service engine disks and images.
   * Field introduced in 20.1.1.
   * @param encryptionKeyId set the encryptionKeyId.
   */
  public void setEncryptionKeyId(String  encryptionKeyId) {
    this.encryptionKeyId = encryptionKeyId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Firewall rule network target tags which will be applied on service engines to allow ingress and egress traffic for service engines.
   * Field introduced in 18.2.1.
   * @return firewallTargetTags
   */
  public List<String> getFirewallTargetTags() {
    return firewallTargetTags;
  }

  /**
   * This is the setter method. this will set the firewallTargetTags
   * Firewall rule network target tags which will be applied on service engines to allow ingress and egress traffic for service engines.
   * Field introduced in 18.2.1.
   * @return firewallTargetTags
   */
  public void setFirewallTargetTags(List<String>  firewallTargetTags) {
    this.firewallTargetTags = firewallTargetTags;
  }

  /**
   * This is the setter method this will set the firewallTargetTags
   * Firewall rule network target tags which will be applied on service engines to allow ingress and egress traffic for service engines.
   * Field introduced in 18.2.1.
   * @return firewallTargetTags
   */
  public GCPConfiguration addFirewallTargetTagsItem(String firewallTargetTagsItem) {
    if (this.firewallTargetTags == null) {
      this.firewallTargetTags = new ArrayList<String>();
    }
    this.firewallTargetTags.add(firewallTargetTagsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Google cloud storage bucket name where service engine image will be uploaded.
   * This image will be deleted once the image is created in google compute images.
   * By default, a bucket will be created if this field is not specified.
   * Field introduced in 18.2.1.
   * @return gcsBucketName
   */
  public String getGcsBucketName() {
    return gcsBucketName;
  }

  /**
   * This is the setter method to the attribute.
   * Google cloud storage bucket name where service engine image will be uploaded.
   * This image will be deleted once the image is created in google compute images.
   * By default, a bucket will be created if this field is not specified.
   * Field introduced in 18.2.1.
   * @param gcsBucketName set the gcsBucketName.
   */
  public void setGcsBucketName(String  gcsBucketName) {
    this.gcsBucketName = gcsBucketName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Google cloud storage project id where service engine image will be uploaded.
   * This image will be deleted once the image is created in google compute images.
   * By default, service engine project id will be used.
   * Field introduced in 18.2.1.
   * @return gcsProjectId
   */
  public String getGcsProjectId() {
    return gcsProjectId;
  }

  /**
   * This is the setter method to the attribute.
   * Google cloud storage project id where service engine image will be uploaded.
   * This image will be deleted once the image is created in google compute images.
   * By default, service engine project id will be used.
   * Field introduced in 18.2.1.
   * @param gcsProjectId set the gcsProjectId.
   */
  public void setGcsProjectId(String  gcsProjectId) {
    this.gcsProjectId = gcsProjectId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated, please use match_se_group_subnet in routes mode in.
   * Vip_allocation_strategy.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return matchSeGroupSubnet
   */
  public Boolean getMatchSeGroupSubnet() {
    return matchSeGroupSubnet;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated, please use match_se_group_subnet in routes mode in.
   * Vip_allocation_strategy.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param matchSeGroupSubnet set the matchSeGroupSubnet.
   */
  public void setMatchSeGroupSubnet(Boolean  matchSeGroupSubnet) {
    this.matchSeGroupSubnet = matchSeGroupSubnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Google cloud platform vpc network configuration for the service engines.
   * Field introduced in 18.2.1.
   * @return networkConfig
   */
  public GCPNetworkConfig getNetworkConfig() {
    return networkConfig;
  }

  /**
   * This is the setter method to the attribute.
   * Google cloud platform vpc network configuration for the service engines.
   * Field introduced in 18.2.1.
   * @param networkConfig set the networkConfig.
   */
  public void setNetworkConfig(GCPNetworkConfig networkConfig) {
    this.networkConfig = networkConfig;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Google cloud platform region name where service engines will be spawned.
   * Field introduced in 18.2.1.
   * @return regionName
   */
  public String getRegionName() {
    return regionName;
  }

  /**
   * This is the setter method to the attribute.
   * Google cloud platform region name where service engines will be spawned.
   * Field introduced in 18.2.1.
   * @param regionName set the regionName.
   */
  public void setRegionName(String  regionName) {
    this.regionName = regionName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Google cloud platform project id where service engines will be spawned.
   * Field introduced in 18.2.1.
   * @return seProjectId
   */
  public String getSeProjectId() {
    return seProjectId;
  }

  /**
   * This is the setter method to the attribute.
   * Google cloud platform project id where service engines will be spawned.
   * Field introduced in 18.2.1.
   * @param seProjectId set the seProjectId.
   */
  public void setSeProjectId(String  seProjectId) {
    this.seProjectId = seProjectId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vip allocation strategy defines how the vips will be created in google cloud.
   * Field introduced in 20.1.1.
   * @return vipAllocationStrategy
   */
  public GCPVIPAllocation getVipAllocationStrategy() {
    return vipAllocationStrategy;
  }

  /**
   * This is the setter method to the attribute.
   * Vip allocation strategy defines how the vips will be created in google cloud.
   * Field introduced in 20.1.1.
   * @param vipAllocationStrategy set the vipAllocationStrategy.
   */
  public void setVipAllocationStrategy(GCPVIPAllocation vipAllocationStrategy) {
    this.vipAllocationStrategy = vipAllocationStrategy;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Google cloud platform zones where service engines will be distributed for ha.
   * Field introduced in 18.2.1.
   * @return zones
   */
  public List<String> getZones() {
    return zones;
  }

  /**
   * This is the setter method. this will set the zones
   * Google cloud platform zones where service engines will be distributed for ha.
   * Field introduced in 18.2.1.
   * @return zones
   */
  public void setZones(List<String>  zones) {
    this.zones = zones;
  }

  /**
   * This is the setter method this will set the zones
   * Google cloud platform zones where service engines will be distributed for ha.
   * Field introduced in 18.2.1.
   * @return zones
   */
  public GCPConfiguration addZonesItem(String zonesItem) {
    if (this.zones == null) {
      this.zones = new ArrayList<String>();
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
  GCPConfiguration objGCPConfiguration = (GCPConfiguration) o;
  return   Objects.equals(this.cloudCredentialsRef, objGCPConfiguration.cloudCredentialsRef)&&
  Objects.equals(this.regionName, objGCPConfiguration.regionName)&&
  Objects.equals(this.zones, objGCPConfiguration.zones)&&
  Objects.equals(this.seProjectId, objGCPConfiguration.seProjectId)&&
  Objects.equals(this.networkConfig, objGCPConfiguration.networkConfig)&&
  Objects.equals(this.firewallTargetTags, objGCPConfiguration.firewallTargetTags)&&
  Objects.equals(this.matchSeGroupSubnet, objGCPConfiguration.matchSeGroupSubnet)&&
  Objects.equals(this.gcsProjectId, objGCPConfiguration.gcsProjectId)&&
  Objects.equals(this.gcsBucketName, objGCPConfiguration.gcsBucketName)&&
  Objects.equals(this.encryptionKeyId, objGCPConfiguration.encryptionKeyId)&&
  Objects.equals(this.vipAllocationStrategy, objGCPConfiguration.vipAllocationStrategy);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GCPConfiguration {\n");
      sb.append("    cloudCredentialsRef: ").append(toIndentedString(cloudCredentialsRef)).append("\n");
        sb.append("    encryptionKeyId: ").append(toIndentedString(encryptionKeyId)).append("\n");
        sb.append("    firewallTargetTags: ").append(toIndentedString(firewallTargetTags)).append("\n");
        sb.append("    gcsBucketName: ").append(toIndentedString(gcsBucketName)).append("\n");
        sb.append("    gcsProjectId: ").append(toIndentedString(gcsProjectId)).append("\n");
        sb.append("    matchSeGroupSubnet: ").append(toIndentedString(matchSeGroupSubnet)).append("\n");
        sb.append("    networkConfig: ").append(toIndentedString(networkConfig)).append("\n");
        sb.append("    regionName: ").append(toIndentedString(regionName)).append("\n");
        sb.append("    seProjectId: ").append(toIndentedString(seProjectId)).append("\n");
        sb.append("    vipAllocationStrategy: ").append(toIndentedString(vipAllocationStrategy)).append("\n");
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

