package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIMgrIPSubnetRuntime is a POJO class extends AviRestResource that used for creating
 * VIMgrIPSubnetRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIMgrIPSubnetRuntime extends AviRestResource  {
    @JsonProperty("fip_available")
    private Boolean fipAvailable = false;

    @JsonProperty("fip_subnet_uuids")
    private List<String> fipSubnetUuids = null;

    @JsonProperty("floatingip_subnets")
    private List<FloatingIpSubnet> floatingipSubnets = null;

    @JsonProperty("ip_subnet")
    private String ipSubnet = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("prefix")
    private IpAddrPrefix prefix = null;

    @JsonProperty("primary")
    private Boolean primary = false;

    @JsonProperty("ref_count")
    private Integer refCount = null;

    @JsonProperty("se_ref_count")
    private Integer seRefCount = 0;

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * If true, capable of floating/elastic ip association.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return fipAvailable
   */
  public Boolean getFipAvailable() {
    return fipAvailable;
  }

  /**
   * This is the setter method to the attribute.
   * If true, capable of floating/elastic ip association.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param fipAvailable set the fipAvailable.
   */
  public void setFipAvailable(Boolean  fipAvailable) {
    this.fipAvailable = fipAvailable;
  }
  /**
   * This is the getter method this will return the attribute value.
   * If fip_available is true, this is list of supported fip subnets, possibly empty if cloud does not support such a network list.
   * @return fipSubnetUuids
   */
  public List<String> getFipSubnetUuids() {
    return fipSubnetUuids;
  }

  /**
   * This is the setter method. this will set the fipSubnetUuids
   * If fip_available is true, this is list of supported fip subnets, possibly empty if cloud does not support such a network list.
   * @return fipSubnetUuids
   */
  public void setFipSubnetUuids(List<String>  fipSubnetUuids) {
    this.fipSubnetUuids = fipSubnetUuids;
  }

  /**
   * This is the setter method this will set the fipSubnetUuids
   * If fip_available is true, this is list of supported fip subnets, possibly empty if cloud does not support such a network list.
   * @return fipSubnetUuids
   */
  public VIMgrIPSubnetRuntime addFipSubnetUuidsItem(String fipSubnetUuidsItem) {
    if (this.fipSubnetUuids == null) {
      this.fipSubnetUuids = new ArrayList<String>();
    }
    this.fipSubnetUuids.add(fipSubnetUuidsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * If fip_available is true, the list of associated floatingip subnets, possibly empty if unsupported or implictly defined by the cloud.
   * Field introduced in 17.2.1.
   * @return floatingipSubnets
   */
  public List<FloatingIpSubnet> getFloatingipSubnets() {
    return floatingipSubnets;
  }

  /**
   * This is the setter method. this will set the floatingipSubnets
   * If fip_available is true, the list of associated floatingip subnets, possibly empty if unsupported or implictly defined by the cloud.
   * Field introduced in 17.2.1.
   * @return floatingipSubnets
   */
  public void setFloatingipSubnets(List<FloatingIpSubnet>  floatingipSubnets) {
    this.floatingipSubnets = floatingipSubnets;
  }

  /**
   * This is the setter method this will set the floatingipSubnets
   * If fip_available is true, the list of associated floatingip subnets, possibly empty if unsupported or implictly defined by the cloud.
   * Field introduced in 17.2.1.
   * @return floatingipSubnets
   */
  public VIMgrIPSubnetRuntime addFloatingipSubnetsItem(FloatingIpSubnet floatingipSubnetsItem) {
    if (this.floatingipSubnets == null) {
      this.floatingipSubnets = new ArrayList<FloatingIpSubnet>();
    }
    this.floatingipSubnets.add(floatingipSubnetsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip_subnet of obj type vimgripsubnetruntime field type str  type string.
   * @return ipSubnet
   */
  public String getIpSubnet() {
    return ipSubnet;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip_subnet of obj type vimgripsubnetruntime field type str  type string.
   * @param ipSubnet set the ipSubnet.
   */
  public void setIpSubnet(String  ipSubnet) {
    this.ipSubnet = ipSubnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property prefix of obj type vimgripsubnetruntime field type str  type ref.
   * @return prefix
   */
  public IpAddrPrefix getPrefix() {
    return prefix;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property prefix of obj type vimgripsubnetruntime field type str  type ref.
   * @param prefix set the prefix.
   */
  public void setPrefix(IpAddrPrefix prefix) {
    this.prefix = prefix;
  }

  /**
   * This is the getter method this will return the attribute value.
   * True if prefix is primary ip on interface, else false.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return primary
   */
  public Boolean getPrimary() {
    return primary;
  }

  /**
   * This is the setter method to the attribute.
   * True if prefix is primary ip on interface, else false.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param primary set the primary.
   */
  public void setPrimary(Boolean  primary) {
    this.primary = primary;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ref_count of obj type vimgripsubnetruntime field type str  type integer.
   * @return refCount
   */
  public Integer getRefCount() {
    return refCount;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ref_count of obj type vimgripsubnetruntime field type str  type integer.
   * @param refCount set the refCount.
   */
  public void setRefCount(Integer  refCount) {
    this.refCount = refCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_ref_count of obj type vimgripsubnetruntime field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return seRefCount
   */
  public Integer getSeRefCount() {
    return seRefCount;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_ref_count of obj type vimgripsubnetruntime field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param seRefCount set the seRefCount.
   */
  public void setSeRefCount(Integer  seRefCount) {
    this.seRefCount = seRefCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VIMgrIPSubnetRuntime objVIMgrIPSubnetRuntime = (VIMgrIPSubnetRuntime) o;
  return   Objects.equals(this.prefix, objVIMgrIPSubnetRuntime.prefix)&&
  Objects.equals(this.refCount, objVIMgrIPSubnetRuntime.refCount)&&
  Objects.equals(this.ipSubnet, objVIMgrIPSubnetRuntime.ipSubnet)&&
  Objects.equals(this.seRefCount, objVIMgrIPSubnetRuntime.seRefCount)&&
  Objects.equals(this.name, objVIMgrIPSubnetRuntime.name)&&
  Objects.equals(this.uuid, objVIMgrIPSubnetRuntime.uuid)&&
  Objects.equals(this.fipAvailable, objVIMgrIPSubnetRuntime.fipAvailable)&&
  Objects.equals(this.fipSubnetUuids, objVIMgrIPSubnetRuntime.fipSubnetUuids)&&
  Objects.equals(this.primary, objVIMgrIPSubnetRuntime.primary)&&
  Objects.equals(this.floatingipSubnets, objVIMgrIPSubnetRuntime.floatingipSubnets);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIMgrIPSubnetRuntime {\n");
      sb.append("    fipAvailable: ").append(toIndentedString(fipAvailable)).append("\n");
        sb.append("    fipSubnetUuids: ").append(toIndentedString(fipSubnetUuids)).append("\n");
        sb.append("    floatingipSubnets: ").append(toIndentedString(floatingipSubnets)).append("\n");
        sb.append("    ipSubnet: ").append(toIndentedString(ipSubnet)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
        sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
        sb.append("    refCount: ").append(toIndentedString(refCount)).append("\n");
        sb.append("    seRefCount: ").append(toIndentedString(seRefCount)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

