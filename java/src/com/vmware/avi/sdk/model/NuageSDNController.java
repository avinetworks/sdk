package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NuageSDNController is a POJO class extends AviRestResource that used for creating
 * NuageSDNController.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NuageSDNController  {
    @JsonProperty("nuage_organization")
    private String nuageOrganization = null;

    @JsonProperty("nuage_password")
    private String nuagePassword = null;

    @JsonProperty("nuage_port")
    private Integer nuagePort = 8443;

    @JsonProperty("nuage_username")
    private String nuageUsername = null;

    @JsonProperty("nuage_vsd_host")
    private String nuageVsdHost = null;

    @JsonProperty("se_domain")
    private String seDomain = null;

    @JsonProperty("se_enterprise")
    private String seEnterprise = null;

    @JsonProperty("se_network")
    private String seNetwork = null;

    @JsonProperty("se_policy_group")
    private String sePolicyGroup = null;

    @JsonProperty("se_user")
    private String seUser = null;

    @JsonProperty("se_zone")
    private String seZone = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property nuage_organization of obj type nuagesdncontroller field type str  type string.
   * @return nuageOrganization
   */
  public String getNuageOrganization() {
    return nuageOrganization;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property nuage_organization of obj type nuagesdncontroller field type str  type string.
   * @param nuageOrganization set the nuageOrganization.
   */
  public void setNuageOrganization(String  nuageOrganization) {
    this.nuageOrganization = nuageOrganization;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property nuage_password of obj type nuagesdncontroller field type str  type string.
   * @return nuagePassword
   */
  public String getNuagePassword() {
    return nuagePassword;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property nuage_password of obj type nuagesdncontroller field type str  type string.
   * @param nuagePassword set the nuagePassword.
   */
  public void setNuagePassword(String  nuagePassword) {
    this.nuagePassword = nuagePassword;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property nuage_port of obj type nuagesdncontroller field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 8443.
   * @return nuagePort
   */
  public Integer getNuagePort() {
    return nuagePort;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property nuage_port of obj type nuagesdncontroller field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 8443.
   * @param nuagePort set the nuagePort.
   */
  public void setNuagePort(Integer  nuagePort) {
    this.nuagePort = nuagePort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property nuage_username of obj type nuagesdncontroller field type str  type string.
   * @return nuageUsername
   */
  public String getNuageUsername() {
    return nuageUsername;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property nuage_username of obj type nuagesdncontroller field type str  type string.
   * @param nuageUsername set the nuageUsername.
   */
  public void setNuageUsername(String  nuageUsername) {
    this.nuageUsername = nuageUsername;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Nuage vsd host name or ip address.
   * @return nuageVsdHost
   */
  public String getNuageVsdHost() {
    return nuageVsdHost;
  }

  /**
   * This is the setter method to the attribute.
   * Nuage vsd host name or ip address.
   * @param nuageVsdHost set the nuageVsdHost.
   */
  public void setNuageVsdHost(String  nuageVsdHost) {
    this.nuageVsdHost = nuageVsdHost;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Domain to be used for se creation.
   * @return seDomain
   */
  public String getSeDomain() {
    return seDomain;
  }

  /**
   * This is the setter method to the attribute.
   * Domain to be used for se creation.
   * @param seDomain set the seDomain.
   */
  public void setSeDomain(String  seDomain) {
    this.seDomain = seDomain;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enterprise to be used for se creation.
   * @return seEnterprise
   */
  public String getSeEnterprise() {
    return seEnterprise;
  }

  /**
   * This is the setter method to the attribute.
   * Enterprise to be used for se creation.
   * @param seEnterprise set the seEnterprise.
   */
  public void setSeEnterprise(String  seEnterprise) {
    this.seEnterprise = seEnterprise;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Network to be used for se creation.
   * @return seNetwork
   */
  public String getSeNetwork() {
    return seNetwork;
  }

  /**
   * This is the setter method to the attribute.
   * Network to be used for se creation.
   * @param seNetwork set the seNetwork.
   */
  public void setSeNetwork(String  seNetwork) {
    this.seNetwork = seNetwork;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Policy group to be used for se creation.
   * @return sePolicyGroup
   */
  public String getSePolicyGroup() {
    return sePolicyGroup;
  }

  /**
   * This is the setter method to the attribute.
   * Policy group to be used for se creation.
   * @param sePolicyGroup set the sePolicyGroup.
   */
  public void setSePolicyGroup(String  sePolicyGroup) {
    this.sePolicyGroup = sePolicyGroup;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User to be used for se creation.
   * @return seUser
   */
  public String getSeUser() {
    return seUser;
  }

  /**
   * This is the setter method to the attribute.
   * User to be used for se creation.
   * @param seUser set the seUser.
   */
  public void setSeUser(String  seUser) {
    this.seUser = seUser;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Zone to be used for se creation.
   * @return seZone
   */
  public String getSeZone() {
    return seZone;
  }

  /**
   * This is the setter method to the attribute.
   * Zone to be used for se creation.
   * @param seZone set the seZone.
   */
  public void setSeZone(String  seZone) {
    this.seZone = seZone;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  NuageSDNController objNuageSDNController = (NuageSDNController) o;
  return   Objects.equals(this.nuageVsdHost, objNuageSDNController.nuageVsdHost)&&
  Objects.equals(this.nuagePort, objNuageSDNController.nuagePort)&&
  Objects.equals(this.nuageUsername, objNuageSDNController.nuageUsername)&&
  Objects.equals(this.nuagePassword, objNuageSDNController.nuagePassword)&&
  Objects.equals(this.nuageOrganization, objNuageSDNController.nuageOrganization)&&
  Objects.equals(this.seDomain, objNuageSDNController.seDomain)&&
  Objects.equals(this.seZone, objNuageSDNController.seZone)&&
  Objects.equals(this.seNetwork, objNuageSDNController.seNetwork)&&
  Objects.equals(this.seEnterprise, objNuageSDNController.seEnterprise)&&
  Objects.equals(this.seUser, objNuageSDNController.seUser)&&
  Objects.equals(this.sePolicyGroup, objNuageSDNController.sePolicyGroup);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NuageSDNController {\n");
      sb.append("    nuageOrganization: ").append(toIndentedString(nuageOrganization)).append("\n");
        sb.append("    nuagePassword: ").append(toIndentedString(nuagePassword)).append("\n");
        sb.append("    nuagePort: ").append(toIndentedString(nuagePort)).append("\n");
        sb.append("    nuageUsername: ").append(toIndentedString(nuageUsername)).append("\n");
        sb.append("    nuageVsdHost: ").append(toIndentedString(nuageVsdHost)).append("\n");
        sb.append("    seDomain: ").append(toIndentedString(seDomain)).append("\n");
        sb.append("    seEnterprise: ").append(toIndentedString(seEnterprise)).append("\n");
        sb.append("    seNetwork: ").append(toIndentedString(seNetwork)).append("\n");
        sb.append("    sePolicyGroup: ").append(toIndentedString(sePolicyGroup)).append("\n");
        sb.append("    seUser: ").append(toIndentedString(seUser)).append("\n");
        sb.append("    seZone: ").append(toIndentedString(seZone)).append("\n");
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

