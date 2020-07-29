package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IpamDnsOpenstackProfile is a POJO class extends AviRestResource that used for creating
 * IpamDnsOpenstackProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpamDnsOpenstackProfile  {
    @JsonProperty("keystone_host")
    private String keystoneHost = null;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("region")
    private String region = null;

    @JsonProperty("tenant")
    private String tenant = null;

    @JsonProperty("username")
    private String username = null;

    @JsonProperty("vip_network_name")
    private String vipNetworkName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Keystone's hostname or ip address.
   * @return keystoneHost
   */
  public String getKeystoneHost() {
    return keystoneHost;
  }

  /**
   * This is the setter method to the attribute.
   * Keystone's hostname or ip address.
   * @param keystoneHost set the keystoneHost.
   */
  public void setKeystoneHost(String  keystoneHost) {
    this.keystoneHost = keystoneHost;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The password avi vantage will use when authenticating to keystone.
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * This is the setter method to the attribute.
   * The password avi vantage will use when authenticating to keystone.
   * @param password set the password.
   */
  public void setPassword(String  password) {
    this.password = password;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Region name.
   * @return region
   */
  public String getRegion() {
    return region;
  }

  /**
   * This is the setter method to the attribute.
   * Region name.
   * @param region set the region.
   */
  public void setRegion(String  region) {
    this.region = region;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Openstack tenant name.
   * @return tenant
   */
  public String getTenant() {
    return tenant;
  }

  /**
   * This is the setter method to the attribute.
   * Openstack tenant name.
   * @param tenant set the tenant.
   */
  public void setTenant(String  tenant) {
    this.tenant = tenant;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The username avi vantage will use when authenticating to keystone.
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * This is the setter method to the attribute.
   * The username avi vantage will use when authenticating to keystone.
   * @param username set the username.
   */
  public void setUsername(String  username) {
    this.username = username;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Network to be used for vip allocation.
   * @return vipNetworkName
   */
  public String getVipNetworkName() {
    return vipNetworkName;
  }

  /**
   * This is the setter method to the attribute.
   * Network to be used for vip allocation.
   * @param vipNetworkName set the vipNetworkName.
   */
  public void setVipNetworkName(String  vipNetworkName) {
    this.vipNetworkName = vipNetworkName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IpamDnsOpenstackProfile objIpamDnsOpenstackProfile = (IpamDnsOpenstackProfile) o;
  return   Objects.equals(this.username, objIpamDnsOpenstackProfile.username)&&
  Objects.equals(this.password, objIpamDnsOpenstackProfile.password)&&
  Objects.equals(this.tenant, objIpamDnsOpenstackProfile.tenant)&&
  Objects.equals(this.keystoneHost, objIpamDnsOpenstackProfile.keystoneHost)&&
  Objects.equals(this.vipNetworkName, objIpamDnsOpenstackProfile.vipNetworkName)&&
  Objects.equals(this.region, objIpamDnsOpenstackProfile.region);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IpamDnsOpenstackProfile {\n");
      sb.append("    keystoneHost: ").append(toIndentedString(keystoneHost)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    vipNetworkName: ").append(toIndentedString(vipNetworkName)).append("\n");
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

