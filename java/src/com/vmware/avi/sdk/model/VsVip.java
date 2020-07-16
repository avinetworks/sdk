package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VsVip is a POJO class extends AviRestResource that used for creating
 * VsVip.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VsVip extends AviRestResource  {
    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("dns_info")
    private List<DnsInfo> dnsInfo = null;

    @JsonProperty("east_west_placement")
    private Boolean eastWestPlacement = false;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("tier1_lr")
    private String tier1Lr = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("use_standard_alb")
    private Boolean useStandardAlb = null;

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vip")
    private List<Vip> vip = null;

    @JsonProperty("vrf_context_ref")
    private String vrfContextRef = null;

    @JsonProperty("vsvip_cloud_config_cksum")
    private String vsvipCloudConfigCksum = null;



  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type cloud.
   * Field introduced in 17.1.1.
   * @return cloudRef
   */
  public String getCloudRef() {
    return cloudRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type cloud.
   * Field introduced in 17.1.1.
   * @param cloudRef set the cloudRef.
   */
  public void setCloudRef(String  cloudRef) {
    this.cloudRef = cloudRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Service discovery specific data including fully qualified domain name, type and time-to-live of the dns record.
   * Field introduced in 17.1.1.
   * @return dnsInfo
   */
  public List<DnsInfo> getDnsInfo() {
    return dnsInfo;
  }

  /**
   * This is the setter method. this will set the dnsInfo
   * Service discovery specific data including fully qualified domain name, type and time-to-live of the dns record.
   * Field introduced in 17.1.1.
   * @return dnsInfo
   */
  public void setDnsInfo(List<DnsInfo>  dnsInfo) {
    this.dnsInfo = dnsInfo;
  }

  /**
   * This is the setter method this will set the dnsInfo
   * Service discovery specific data including fully qualified domain name, type and time-to-live of the dns record.
   * Field introduced in 17.1.1.
   * @return dnsInfo
   */
  public VsVip addDnsInfoItem(DnsInfo dnsInfoItem) {
    if (this.dnsInfo == null) {
      this.dnsInfo = new ArrayList<DnsInfo>();
    }
    this.dnsInfo.add(dnsInfoItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Force placement on all service engines in the service engine group (container clouds only).
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return eastWestPlacement
   */
  public Boolean getEastWestPlacement() {
    return eastWestPlacement;
  }

  /**
   * This is the setter method to the attribute.
   * Force placement on all service engines in the service engine group (container clouds only).
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param eastWestPlacement set the eastWestPlacement.
   */
  public void setEastWestPlacement(Boolean  eastWestPlacement) {
    this.eastWestPlacement = eastWestPlacement;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name for the vsvip object.
   * Field introduced in 17.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name for the vsvip object.
   * Field introduced in 17.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.1.1.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This sets the placement scope of virtualservice to given tier1 logical router in nsx-t.
   * Field introduced in 20.1.1.
   * @return tier1Lr
   */
  public String getTier1Lr() {
    return tier1Lr;
  }

  /**
   * This is the setter method to the attribute.
   * This sets the placement scope of virtualservice to given tier1 logical router in nsx-t.
   * Field introduced in 20.1.1.
   * @param tier1Lr set the tier1Lr.
   */
  public void setTier1Lr(String  tier1Lr) {
    this.tier1Lr = tier1Lr;
  }
/**
   * This is the getter method this will return the attribute value.
   * Avi controller URL of the object.
   * @return url
   */
  public String getUrl() {
    return url;
  }

  /**
   * This is the setter method. this will set the url
   * Avi controller URL of the object.
   * @return url
   */
  public void setUrl(String  url) {
    this.url = url;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This overrides the cloud level default and needs to match the se group value in which it will be used if the se group use_standard_alb value is
   * set.
   * This is only used when fip is used for vs on azure cloud.
   * Field introduced in 18.2.3.
   * @return useStandardAlb
   */
  public Boolean getUseStandardAlb() {
    return useStandardAlb;
  }

  /**
   * This is the setter method to the attribute.
   * This overrides the cloud level default and needs to match the se group value in which it will be used if the se group use_standard_alb value is
   * set.
   * This is only used when fip is used for vs on azure cloud.
   * Field introduced in 18.2.3.
   * @param useStandardAlb set the useStandardAlb.
   */
  public void setUseStandardAlb(Boolean  useStandardAlb) {
    this.useStandardAlb = useStandardAlb;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the vsvip object.
   * Field introduced in 17.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the vsvip object.
   * Field introduced in 17.1.1.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of virtual service ips and other shareable entities.
   * Field introduced in 17.1.1.
   * @return vip
   */
  public List<Vip> getVip() {
    return vip;
  }

  /**
   * This is the setter method. this will set the vip
   * List of virtual service ips and other shareable entities.
   * Field introduced in 17.1.1.
   * @return vip
   */
  public void setVip(List<Vip>  vip) {
    this.vip = vip;
  }

  /**
   * This is the setter method this will set the vip
   * List of virtual service ips and other shareable entities.
   * Field introduced in 17.1.1.
   * @return vip
   */
  public VsVip addVipItem(Vip vipItem) {
    if (this.vip == null) {
      this.vip = new ArrayList<Vip>();
    }
    this.vip.add(vipItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtual routing context that the virtual service is bound to.
   * This is used to provide the isolation of the set of networks the application is attached to.
   * It is a reference to an object of type vrfcontext.
   * Field introduced in 17.1.1.
   * @return vrfContextRef
   */
  public String getVrfContextRef() {
    return vrfContextRef;
  }

  /**
   * This is the setter method to the attribute.
   * Virtual routing context that the virtual service is bound to.
   * This is used to provide the isolation of the set of networks the application is attached to.
   * It is a reference to an object of type vrfcontext.
   * Field introduced in 17.1.1.
   * @param vrfContextRef set the vrfContextRef.
   */
  public void setVrfContextRef(String  vrfContextRef) {
    this.vrfContextRef = vrfContextRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Checksum of cloud configuration for vsvip.
   * Internally set by cloud connector.
   * Field introduced in 17.2.9, 18.1.2.
   * @return vsvipCloudConfigCksum
   */
  public String getVsvipCloudConfigCksum() {
    return vsvipCloudConfigCksum;
  }

  /**
   * This is the setter method to the attribute.
   * Checksum of cloud configuration for vsvip.
   * Internally set by cloud connector.
   * Field introduced in 17.2.9, 18.1.2.
   * @param vsvipCloudConfigCksum set the vsvipCloudConfigCksum.
   */
  public void setVsvipCloudConfigCksum(String  vsvipCloudConfigCksum) {
    this.vsvipCloudConfigCksum = vsvipCloudConfigCksum;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VsVip objVsVip = (VsVip) o;
  return   Objects.equals(this.vrfContextRef, objVsVip.vrfContextRef)&&
  Objects.equals(this.eastWestPlacement, objVsVip.eastWestPlacement)&&
  Objects.equals(this.uuid, objVsVip.uuid)&&
  Objects.equals(this.dnsInfo, objVsVip.dnsInfo)&&
  Objects.equals(this.tier1Lr, objVsVip.tier1Lr)&&
  Objects.equals(this.tenantRef, objVsVip.tenantRef)&&
  Objects.equals(this.vip, objVsVip.vip)&&
  Objects.equals(this.vsvipCloudConfigCksum, objVsVip.vsvipCloudConfigCksum)&&
  Objects.equals(this.useStandardAlb, objVsVip.useStandardAlb)&&
  Objects.equals(this.cloudRef, objVsVip.cloudRef)&&
  Objects.equals(this.name, objVsVip.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VsVip {\n");
      sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    dnsInfo: ").append(toIndentedString(dnsInfo)).append("\n");
        sb.append("    eastWestPlacement: ").append(toIndentedString(eastWestPlacement)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    tier1Lr: ").append(toIndentedString(tier1Lr)).append("\n");
            sb.append("    useStandardAlb: ").append(toIndentedString(useStandardAlb)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vip: ").append(toIndentedString(vip)).append("\n");
        sb.append("    vrfContextRef: ").append(toIndentedString(vrfContextRef)).append("\n");
        sb.append("    vsvipCloudConfigCksum: ").append(toIndentedString(vsvipCloudConfigCksum)).append("\n");
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

