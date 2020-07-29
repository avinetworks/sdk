package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbSite is a POJO class extends AviRestResource that used for creating
 * GslbSite.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbSite extends AviRestResource  {
    @JsonProperty("address")
    private String address = null;

    @JsonProperty("cluster_uuid")
    private String clusterUuid = null;

    @JsonProperty("dns_vs_uuids")
    private List<String> dnsVsUuids = null;

    @JsonProperty("dns_vses")
    private List<GslbSiteDnsVs> dnsVses = null;

    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("hm_proxies")
    private List<GslbHealthMonitorProxy> hmProxies = null;

    @JsonProperty("hm_shard_enabled")
    private Boolean hmShardEnabled = false;

    @JsonProperty("ip_addresses")
    private List<IpAddr> ipAddresses = null;

    @JsonProperty("location")
    private GslbGeoLocation location = null;

    @JsonProperty("member_type")
    private String memberType = "GSLB_PASSIVE_MEMBER";

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("port")
    private Integer port = 443;

    @JsonProperty("ratio")
    private Integer ratio = null;

    @JsonProperty("suspend_mode")
    private Boolean suspendMode = false;

    @JsonProperty("username")
    private String username = null;

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Ip address or a dns resolvable, fully qualified domain name of the site controller cluster.
   * @return address
   */
  public String getAddress() {
    return address;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address or a dns resolvable, fully qualified domain name of the site controller cluster.
   * @param address set the address.
   */
  public void setAddress(String  address) {
    this.address = address;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the 'cluster' object of the controller cluster in this site.
   * @return clusterUuid
   */
  public String getClusterUuid() {
    return clusterUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the 'cluster' object of the controller cluster in this site.
   * @param clusterUuid set the clusterUuid.
   */
  public void setClusterUuid(String  clusterUuid) {
    this.clusterUuid = clusterUuid;
  }
  /**
   * This is the getter method this will return the attribute value.
   * The dns vses on which the gslbservices shall be placed.
   * The site has to be an active member.
   * This field is deprecated in 17.2.3 and replaced by 'dns_vses' field.
   * Field deprecated in 17.2.3.
   * @return dnsVsUuids
   */
  public List<String> getDnsVsUuids() {
    return dnsVsUuids;
  }

  /**
   * This is the setter method. this will set the dnsVsUuids
   * The dns vses on which the gslbservices shall be placed.
   * The site has to be an active member.
   * This field is deprecated in 17.2.3 and replaced by 'dns_vses' field.
   * Field deprecated in 17.2.3.
   * @return dnsVsUuids
   */
  public void setDnsVsUuids(List<String>  dnsVsUuids) {
    this.dnsVsUuids = dnsVsUuids;
  }

  /**
   * This is the setter method this will set the dnsVsUuids
   * The dns vses on which the gslbservices shall be placed.
   * The site has to be an active member.
   * This field is deprecated in 17.2.3 and replaced by 'dns_vses' field.
   * Field deprecated in 17.2.3.
   * @return dnsVsUuids
   */
  public GslbSite addDnsVsUuidsItem(String dnsVsUuidsItem) {
    if (this.dnsVsUuids == null) {
      this.dnsVsUuids = new ArrayList<String>();
    }
    this.dnsVsUuids.add(dnsVsUuidsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * This field identifies the dns vs and the subdomains it hosts for gslb services.
   * Field introduced in 17.2.3.
   * @return dnsVses
   */
  public List<GslbSiteDnsVs> getDnsVses() {
    return dnsVses;
  }

  /**
   * This is the setter method. this will set the dnsVses
   * This field identifies the dns vs and the subdomains it hosts for gslb services.
   * Field introduced in 17.2.3.
   * @return dnsVses
   */
  public void setDnsVses(List<GslbSiteDnsVs>  dnsVses) {
    this.dnsVses = dnsVses;
  }

  /**
   * This is the setter method this will set the dnsVses
   * This field identifies the dns vs and the subdomains it hosts for gslb services.
   * Field introduced in 17.2.3.
   * @return dnsVses
   */
  public GslbSite addDnsVsesItem(GslbSiteDnsVs dnsVsesItem) {
    if (this.dnsVses == null) {
      this.dnsVses = new ArrayList<GslbSiteDnsVs>();
    }
    this.dnsVses.add(dnsVsesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable or disable the site.
   * This is useful in maintenance scenarios such as upgrade and routine maintenance.
   * A disabled site's configuration shall be retained but it will not get any new configuration updates.
   * It shall not participate in health-status monitoring.
   * Vips of the virtual services on the disabled site shall not be sent in dns response.
   * When a site transitions from disabled to enabled, it is treated similar to the addition of a new site.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable or disable the site.
   * This is useful in maintenance scenarios such as upgrade and routine maintenance.
   * A disabled site's configuration shall be retained but it will not get any new configuration updates.
   * It shall not participate in health-status monitoring.
   * Vips of the virtual services on the disabled site shall not be sent in dns response.
   * When a site transitions from disabled to enabled, it is treated similar to the addition of a new site.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }
  /**
   * This is the getter method this will return the attribute value.
   * User can designate certain avi sites to run health monitor probes for vips/vs(es) for this site.
   * This is useful in network deployments where the vips/vs(es) are reachable only from certain sites.
   * A typical scenario is a firewall between two gslb sites.
   * User may want to run health monitor probes from sites on either side of the firewall so that each designated site can derive a datapath view of
   * the reachable members.
   * If the health monitor proxies are not configured, then the default behavior is to run health monitor probes from all the active sites.
   * Field introduced in 17.1.1.
   * @return hmProxies
   */
  public List<GslbHealthMonitorProxy> getHmProxies() {
    return hmProxies;
  }

  /**
   * This is the setter method. this will set the hmProxies
   * User can designate certain avi sites to run health monitor probes for vips/vs(es) for this site.
   * This is useful in network deployments where the vips/vs(es) are reachable only from certain sites.
   * A typical scenario is a firewall between two gslb sites.
   * User may want to run health monitor probes from sites on either side of the firewall so that each designated site can derive a datapath view of
   * the reachable members.
   * If the health monitor proxies are not configured, then the default behavior is to run health monitor probes from all the active sites.
   * Field introduced in 17.1.1.
   * @return hmProxies
   */
  public void setHmProxies(List<GslbHealthMonitorProxy>  hmProxies) {
    this.hmProxies = hmProxies;
  }

  /**
   * This is the setter method this will set the hmProxies
   * User can designate certain avi sites to run health monitor probes for vips/vs(es) for this site.
   * This is useful in network deployments where the vips/vs(es) are reachable only from certain sites.
   * A typical scenario is a firewall between two gslb sites.
   * User may want to run health monitor probes from sites on either side of the firewall so that each designated site can derive a datapath view of
   * the reachable members.
   * If the health monitor proxies are not configured, then the default behavior is to run health monitor probes from all the active sites.
   * Field introduced in 17.1.1.
   * @return hmProxies
   */
  public GslbSite addHmProxiesItem(GslbHealthMonitorProxy hmProxiesItem) {
    if (this.hmProxies == null) {
      this.hmProxies = new ArrayList<GslbHealthMonitorProxy>();
    }
    this.hmProxies.add(hmProxiesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field enables the health monitor shard functionality on a site-basis.
   * Field introduced in 18.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return hmShardEnabled
   */
  public Boolean getHmShardEnabled() {
    return hmShardEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * This field enables the health monitor shard functionality on a site-basis.
   * Field introduced in 18.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param hmShardEnabled set the hmShardEnabled.
   */
  public void setHmShardEnabled(Boolean  hmShardEnabled) {
    this.hmShardEnabled = hmShardEnabled;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Ip address(es) of the site's cluster.
   * For a 3-node cluster, either the cluster vip is provided, or the list of controller ips in the cluster are provided.
   * @return ipAddresses
   */
  public List<IpAddr> getIpAddresses() {
    return ipAddresses;
  }

  /**
   * This is the setter method. this will set the ipAddresses
   * Ip address(es) of the site's cluster.
   * For a 3-node cluster, either the cluster vip is provided, or the list of controller ips in the cluster are provided.
   * @return ipAddresses
   */
  public void setIpAddresses(List<IpAddr>  ipAddresses) {
    this.ipAddresses = ipAddresses;
  }

  /**
   * This is the setter method this will set the ipAddresses
   * Ip address(es) of the site's cluster.
   * For a 3-node cluster, either the cluster vip is provided, or the list of controller ips in the cluster are provided.
   * @return ipAddresses
   */
  public GslbSite addIpAddressesItem(IpAddr ipAddressesItem) {
    if (this.ipAddresses == null) {
      this.ipAddresses = new ArrayList<IpAddr>();
    }
    this.ipAddresses.add(ipAddressesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Geographic location of the site.
   * Field introduced in 17.1.1.
   * @return location
   */
  public GslbGeoLocation getLocation() {
    return location;
  }

  /**
   * This is the setter method to the attribute.
   * Geographic location of the site.
   * Field introduced in 17.1.1.
   * @param location set the location.
   */
  public void setLocation(GslbGeoLocation location) {
    this.location = location;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The site's member type  a leader is set to active while allmembers are set to passive.
   * Enum options - GSLB_ACTIVE_MEMBER, GSLB_PASSIVE_MEMBER.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_PASSIVE_MEMBER.
   * @return memberType
   */
  public String getMemberType() {
    return memberType;
  }

  /**
   * This is the setter method to the attribute.
   * The site's member type  a leader is set to active while allmembers are set to passive.
   * Enum options - GSLB_ACTIVE_MEMBER, GSLB_PASSIVE_MEMBER.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_PASSIVE_MEMBER.
   * @param memberType set the memberType.
   */
  public void setMemberType(String  memberType) {
    this.memberType = memberType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name for the site controller cluster.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name for the site controller cluster.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The password used when authenticating with the site.
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * This is the setter method to the attribute.
   * The password used when authenticating with the site.
   * @param password set the password.
   */
  public void setPassword(String  password) {
    this.password = password;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The site controller cluster's rest api port number.
   * Allowed values are 1-65535.
   * Default value when not specified in API or module is interpreted by Avi Controller as 443.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * The site controller cluster's rest api port number.
   * Allowed values are 1-65535.
   * Default value when not specified in API or module is interpreted by Avi Controller as 443.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User can overide the individual gslbpoolmember ratio for all the vips/vs(es) of this site.
   * If this field is not  configured then the gslbpoolmember ratio gets applied.
   * Allowed values are 1-20.
   * Field introduced in 17.1.1.
   * @return ratio
   */
  public Integer getRatio() {
    return ratio;
  }

  /**
   * This is the setter method to the attribute.
   * User can overide the individual gslbpoolmember ratio for all the vips/vs(es) of this site.
   * If this field is not  configured then the gslbpoolmember ratio gets applied.
   * Allowed values are 1-20.
   * Field introduced in 17.1.1.
   * @param ratio set the ratio.
   */
  public void setRatio(Integer  ratio) {
    this.ratio = ratio;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This modes applies to follower sites.
   * When an active site is in suspend mode, the site does not receive any further federated objects.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return suspendMode
   */
  public Boolean getSuspendMode() {
    return suspendMode;
  }

  /**
   * This is the setter method to the attribute.
   * This modes applies to follower sites.
   * When an active site is in suspend mode, the site does not receive any further federated objects.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param suspendMode set the suspendMode.
   */
  public void setSuspendMode(Boolean  suspendMode) {
    this.suspendMode = suspendMode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The username used when authenticating with the site.
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * This is the setter method to the attribute.
   * The username used when authenticating with the site.
   * @param username set the username.
   */
  public void setUsername(String  username) {
    this.username = username;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field is used as a key in the datastore for the gslbsite table to encapsulate site-related info.
   * Field introduced in 17.2.5.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * This field is used as a key in the datastore for the gslbsite table to encapsulate site-related info.
   * Field introduced in 17.2.5.
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
  GslbSite objGslbSite = (GslbSite) o;
  return   Objects.equals(this.clusterUuid, objGslbSite.clusterUuid)&&
  Objects.equals(this.name, objGslbSite.name)&&
  Objects.equals(this.address, objGslbSite.address)&&
  Objects.equals(this.ipAddresses, objGslbSite.ipAddresses)&&
  Objects.equals(this.port, objGslbSite.port)&&
  Objects.equals(this.username, objGslbSite.username)&&
  Objects.equals(this.password, objGslbSite.password)&&
  Objects.equals(this.dnsVsUuids, objGslbSite.dnsVsUuids)&&
  Objects.equals(this.memberType, objGslbSite.memberType)&&
  Objects.equals(this.enabled, objGslbSite.enabled)&&
  Objects.equals(this.location, objGslbSite.location)&&
  Objects.equals(this.hmProxies, objGslbSite.hmProxies)&&
  Objects.equals(this.ratio, objGslbSite.ratio)&&
  Objects.equals(this.dnsVses, objGslbSite.dnsVses)&&
  Objects.equals(this.uuid, objGslbSite.uuid)&&
  Objects.equals(this.hmShardEnabled, objGslbSite.hmShardEnabled)&&
  Objects.equals(this.suspendMode, objGslbSite.suspendMode);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbSite {\n");
      sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    clusterUuid: ").append(toIndentedString(clusterUuid)).append("\n");
        sb.append("    dnsVsUuids: ").append(toIndentedString(dnsVsUuids)).append("\n");
        sb.append("    dnsVses: ").append(toIndentedString(dnsVses)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    hmProxies: ").append(toIndentedString(hmProxies)).append("\n");
        sb.append("    hmShardEnabled: ").append(toIndentedString(hmShardEnabled)).append("\n");
        sb.append("    ipAddresses: ").append(toIndentedString(ipAddresses)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    memberType: ").append(toIndentedString(memberType)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    ratio: ").append(toIndentedString(ratio)).append("\n");
        sb.append("    suspendMode: ").append(toIndentedString(suspendMode)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
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

