package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Network is a POJO class extends AviRestResource that used for creating
 * Network.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Network extends AviRestResource  {
    @JsonProperty("attrs")
    private List<KeyValue> attrs = null;

    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("configured_subnets")
    private List<Subnet> configuredSubnets = null;

    @JsonProperty("dhcp_enabled")
    private Boolean dhcpEnabled = true;

    @JsonProperty("exclude_discovered_subnets")
    private Boolean excludeDiscoveredSubnets = false;

    @JsonProperty("ip6_autocfg_enabled")
    private Boolean ip6AutocfgEnabled = true;

    @JsonProperty("labels")
    private List<KeyValue> labels = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("synced_from_se")
    private Boolean syncedFromSe = false;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vcenter_dvs")
    private Boolean vcenterDvs = true;

    @JsonProperty("vimgrnw_ref")
    private String vimgrnwRef = null;

    @JsonProperty("vrf_context_ref")
    private String vrfContextRef = null;


  /**
   * This is the getter method this will return the attribute value.
   * Key/value network attributes.
   * Field introduced in 20.1.1.
   * @return attrs
   */
  public List<KeyValue> getAttrs() {
    return attrs;
  }

  /**
   * This is the setter method. this will set the attrs
   * Key/value network attributes.
   * Field introduced in 20.1.1.
   * @return attrs
   */
  public void setAttrs(List<KeyValue>  attrs) {
    this.attrs = attrs;
  }

  /**
   * This is the setter method this will set the attrs
   * Key/value network attributes.
   * Field introduced in 20.1.1.
   * @return attrs
   */
  public Network addAttrsItem(KeyValue attrsItem) {
    if (this.attrs == null) {
      this.attrs = new ArrayList<KeyValue>();
    }
    this.attrs.add(attrsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type cloud.
   * @return cloudRef
   */
  public String getCloudRef() {
    return cloudRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type cloud.
   * @param cloudRef set the cloudRef.
   */
  public void setCloudRef(String  cloudRef) {
    this.cloudRef = cloudRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property configured_subnets of obj type network field type str  type array.
   * @return configuredSubnets
   */
  public List<Subnet> getConfiguredSubnets() {
    return configuredSubnets;
  }

  /**
   * This is the setter method. this will set the configuredSubnets
   * Placeholder for description of property configured_subnets of obj type network field type str  type array.
   * @return configuredSubnets
   */
  public void setConfiguredSubnets(List<Subnet>  configuredSubnets) {
    this.configuredSubnets = configuredSubnets;
  }

  /**
   * This is the setter method this will set the configuredSubnets
   * Placeholder for description of property configured_subnets of obj type network field type str  type array.
   * @return configuredSubnets
   */
  public Network addConfiguredSubnetsItem(Subnet configuredSubnetsItem) {
    if (this.configuredSubnets == null) {
      this.configuredSubnets = new ArrayList<Subnet>();
    }
    this.configuredSubnets.add(configuredSubnetsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Select the ip address management scheme for this network.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return dhcpEnabled
   */
  public Boolean getDhcpEnabled() {
    return dhcpEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Select the ip address management scheme for this network.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param dhcpEnabled set the dhcpEnabled.
   */
  public void setDhcpEnabled(Boolean  dhcpEnabled) {
    this.dhcpEnabled = dhcpEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When selected, excludes all discovered subnets in this network from consideration for virtual service placement.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeDiscoveredSubnets
   */
  public Boolean getExcludeDiscoveredSubnets() {
    return excludeDiscoveredSubnets;
  }

  /**
   * This is the setter method to the attribute.
   * When selected, excludes all discovered subnets in this network from consideration for virtual service placement.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeDiscoveredSubnets set the excludeDiscoveredSubnets.
   */
  public void setExcludeDiscoveredSubnets(Boolean  excludeDiscoveredSubnets) {
    this.excludeDiscoveredSubnets = excludeDiscoveredSubnets;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable ipv6 auto configuration.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return ip6AutocfgEnabled
   */
  public Boolean getIp6AutocfgEnabled() {
    return ip6AutocfgEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable ipv6 auto configuration.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param ip6AutocfgEnabled set the ip6AutocfgEnabled.
   */
  public void setIp6AutocfgEnabled(Boolean  ip6AutocfgEnabled) {
    this.ip6AutocfgEnabled = ip6AutocfgEnabled;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Key/value labels which can be used for object access policy permission scoping.
   * Field introduced in 18.2.7, 20.1.1.
   * @return labels
   */
  public List<KeyValue> getLabels() {
    return labels;
  }

  /**
   * This is the setter method. this will set the labels
   * Key/value labels which can be used for object access policy permission scoping.
   * Field introduced in 18.2.7, 20.1.1.
   * @return labels
   */
  public void setLabels(List<KeyValue>  labels) {
    this.labels = labels;
  }

  /**
   * This is the setter method this will set the labels
   * Key/value labels which can be used for object access policy permission scoping.
   * Field introduced in 18.2.7, 20.1.1.
   * @return labels
   */
  public Network addLabelsItem(KeyValue labelsItem) {
    if (this.labels == null) {
      this.labels = new ArrayList<KeyValue>();
    }
    this.labels.add(labelsItem);
    return this;
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
   * Placeholder for description of property synced_from_se of obj type network field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return syncedFromSe
   */
  public Boolean getSyncedFromSe() {
    return syncedFromSe;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property synced_from_se of obj type network field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param syncedFromSe set the syncedFromSe.
   */
  public void setSyncedFromSe(Boolean  syncedFromSe) {
    this.syncedFromSe = syncedFromSe;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
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

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_dvs of obj type network field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return vcenterDvs
   */
  public Boolean getVcenterDvs() {
    return vcenterDvs;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_dvs of obj type network field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param vcenterDvs set the vcenterDvs.
   */
  public void setVcenterDvs(Boolean  vcenterDvs) {
    this.vcenterDvs = vcenterDvs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type vimgrnwruntime.
   * @return vimgrnwRef
   */
  public String getVimgrnwRef() {
    return vimgrnwRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type vimgrnwruntime.
   * @param vimgrnwRef set the vimgrnwRef.
   */
  public void setVimgrnwRef(String  vimgrnwRef) {
    this.vimgrnwRef = vimgrnwRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type vrfcontext.
   * @return vrfContextRef
   */
  public String getVrfContextRef() {
    return vrfContextRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type vrfcontext.
   * @param vrfContextRef set the vrfContextRef.
   */
  public void setVrfContextRef(String  vrfContextRef) {
    this.vrfContextRef = vrfContextRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Network objNetwork = (Network) o;
  return   Objects.equals(this.uuid, objNetwork.uuid)&&
  Objects.equals(this.name, objNetwork.name)&&
  Objects.equals(this.vcenterDvs, objNetwork.vcenterDvs)&&
  Objects.equals(this.vimgrnwRef, objNetwork.vimgrnwRef)&&
  Objects.equals(this.dhcpEnabled, objNetwork.dhcpEnabled)&&
  Objects.equals(this.excludeDiscoveredSubnets, objNetwork.excludeDiscoveredSubnets)&&
  Objects.equals(this.configuredSubnets, objNetwork.configuredSubnets)&&
  Objects.equals(this.vrfContextRef, objNetwork.vrfContextRef)&&
  Objects.equals(this.syncedFromSe, objNetwork.syncedFromSe)&&
  Objects.equals(this.tenantRef, objNetwork.tenantRef)&&
  Objects.equals(this.cloudRef, objNetwork.cloudRef)&&
  Objects.equals(this.ip6AutocfgEnabled, objNetwork.ip6AutocfgEnabled)&&
  Objects.equals(this.labels, objNetwork.labels)&&
  Objects.equals(this.attrs, objNetwork.attrs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Network {\n");
      sb.append("    attrs: ").append(toIndentedString(attrs)).append("\n");
        sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    configuredSubnets: ").append(toIndentedString(configuredSubnets)).append("\n");
        sb.append("    dhcpEnabled: ").append(toIndentedString(dhcpEnabled)).append("\n");
        sb.append("    excludeDiscoveredSubnets: ").append(toIndentedString(excludeDiscoveredSubnets)).append("\n");
        sb.append("    ip6AutocfgEnabled: ").append(toIndentedString(ip6AutocfgEnabled)).append("\n");
        sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    syncedFromSe: ").append(toIndentedString(syncedFromSe)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vcenterDvs: ").append(toIndentedString(vcenterDvs)).append("\n");
        sb.append("    vimgrnwRef: ").append(toIndentedString(vimgrnwRef)).append("\n");
        sb.append("    vrfContextRef: ").append(toIndentedString(vrfContextRef)).append("\n");
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

