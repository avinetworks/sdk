package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The vCenterConfiguration is a POJO class extends AviRestResource that used for creating
 * vCenterConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class vCenterConfiguration  {
    @JsonProperty("datacenter")
    private String datacenter = null;

    @JsonProperty("management_ip_subnet")
    private IpAddrPrefix managementIpSubnet = null;

    @JsonProperty("management_network")
    private String managementNetwork = null;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("privilege")
    private String privilege = "WRITE_ACCESS";

    @JsonProperty("username")
    private String username = null;

    @JsonProperty("vcenter_template_se_location")
    private String vcenterTemplateSeLocation = null;

    @JsonProperty("vcenter_url")
    private String vcenterUrl = null;



  /**
   * This is the getter method this will return the attribute value.
   * Datacenter for virtual infrastructure discovery.
   * @return datacenter
   */
  public String getDatacenter() {
    return datacenter;
  }

  /**
   * This is the setter method to the attribute.
   * Datacenter for virtual infrastructure discovery.
   * @param datacenter set the datacenter.
   */
  public void setDatacenter(String  datacenter) {
    this.datacenter = datacenter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Management subnet to use for avi service engines.
   * @return managementIpSubnet
   */
  public IpAddrPrefix getManagementIpSubnet() {
    return managementIpSubnet;
  }

  /**
   * This is the setter method to the attribute.
   * Management subnet to use for avi service engines.
   * @param managementIpSubnet set the managementIpSubnet.
   */
  public void setManagementIpSubnet(IpAddrPrefix managementIpSubnet) {
    this.managementIpSubnet = managementIpSubnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Management network to use for avi service engines.
   * It is a reference to an object of type vimgrnwruntime.
   * @return managementNetwork
   */
  public String getManagementNetwork() {
    return managementNetwork;
  }

  /**
   * This is the setter method to the attribute.
   * Management network to use for avi service engines.
   * It is a reference to an object of type vimgrnwruntime.
   * @param managementNetwork set the managementNetwork.
   */
  public void setManagementNetwork(String  managementNetwork) {
    this.managementNetwork = managementNetwork;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The password avi vantage will use when authenticating with vcenter.
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * This is the setter method to the attribute.
   * The password avi vantage will use when authenticating with vcenter.
   * @param password set the password.
   */
  public void setPassword(String  password) {
    this.password = password;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Set the access mode to vcenter as either read, which allows avi to discover networks and servers, or write, which also allows avi to create
   * service engines and configure their network properties.
   * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
   * Default value when not specified in API or module is interpreted by Avi Controller as WRITE_ACCESS.
   * @return privilege
   */
  public String getPrivilege() {
    return privilege;
  }

  /**
   * This is the setter method to the attribute.
   * Set the access mode to vcenter as either read, which allows avi to discover networks and servers, or write, which also allows avi to create
   * service engines and configure their network properties.
   * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
   * Default value when not specified in API or module is interpreted by Avi Controller as WRITE_ACCESS.
   * @param privilege set the privilege.
   */
  public void setPrivilege(String  privilege) {
    this.privilege = privilege;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The username avi vantage will use when authenticating with vcenter.
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * This is the setter method to the attribute.
   * The username avi vantage will use when authenticating with vcenter.
   * @param username set the username.
   */
  public void setUsername(String  username) {
    this.username = username;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi service engine template in vcenter to be used for creating service engines.
   * @return vcenterTemplateSeLocation
   */
  public String getVcenterTemplateSeLocation() {
    return vcenterTemplateSeLocation;
  }

  /**
   * This is the setter method to the attribute.
   * Avi service engine template in vcenter to be used for creating service engines.
   * @param vcenterTemplateSeLocation set the vcenterTemplateSeLocation.
   */
  public void setVcenterTemplateSeLocation(String  vcenterTemplateSeLocation) {
    this.vcenterTemplateSeLocation = vcenterTemplateSeLocation;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vcenter hostname or ip address.
   * @return vcenterUrl
   */
  public String getVcenterUrl() {
    return vcenterUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Vcenter hostname or ip address.
   * @param vcenterUrl set the vcenterUrl.
   */
  public void setVcenterUrl(String  vcenterUrl) {
    this.vcenterUrl = vcenterUrl;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  vCenterConfiguration objvCenterConfiguration = (vCenterConfiguration) o;
  return   Objects.equals(this.username, objvCenterConfiguration.username)&&
  Objects.equals(this.datacenter, objvCenterConfiguration.datacenter)&&
  Objects.equals(this.managementNetwork, objvCenterConfiguration.managementNetwork)&&
  Objects.equals(this.vcenterTemplateSeLocation, objvCenterConfiguration.vcenterTemplateSeLocation)&&
  Objects.equals(this.managementIpSubnet, objvCenterConfiguration.managementIpSubnet)&&
  Objects.equals(this.privilege, objvCenterConfiguration.privilege)&&
  Objects.equals(this.vcenterUrl, objvCenterConfiguration.vcenterUrl)&&
  Objects.equals(this.password, objvCenterConfiguration.password);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class vCenterConfiguration {\n");
      sb.append("    datacenter: ").append(toIndentedString(datacenter)).append("\n");
        sb.append("    managementIpSubnet: ").append(toIndentedString(managementIpSubnet)).append("\n");
        sb.append("    managementNetwork: ").append(toIndentedString(managementNetwork)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    privilege: ").append(toIndentedString(privilege)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    vcenterTemplateSeLocation: ").append(toIndentedString(vcenterTemplateSeLocation)).append("\n");
        sb.append("    vcenterUrl: ").append(toIndentedString(vcenterUrl)).append("\n");
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

