package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OpenStackClusterSetup is a POJO class extends AviRestResource that used for creating
 * OpenStackClusterSetup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenStackClusterSetup  {
    @JsonProperty("admin_tenant")
    private String adminTenant = null;

    @JsonProperty("auth_url")
    private String authUrl = null;

    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("error_string")
    private String errorString = null;

    @JsonProperty("keystone_host")
    private String keystoneHost = null;

    @JsonProperty("privilege")
    private String privilege = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property admin_tenant of obj type openstackclustersetup field type str  type string.
   * @return adminTenant
   */
  public String getAdminTenant() {
    return adminTenant;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property admin_tenant of obj type openstackclustersetup field type str  type string.
   * @param adminTenant set the adminTenant.
   */
  public void setAdminTenant(String  adminTenant) {
    this.adminTenant = adminTenant;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property auth_url of obj type openstackclustersetup field type str  type string.
   * @return authUrl
   */
  public String getAuthUrl() {
    return authUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property auth_url of obj type openstackclustersetup field type str  type string.
   * @param authUrl set the authUrl.
   */
  public void setAuthUrl(String  authUrl) {
    this.authUrl = authUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type openstackclustersetup field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type openstackclustersetup field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error_string of obj type openstackclustersetup field type str  type string.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error_string of obj type openstackclustersetup field type str  type string.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property keystone_host of obj type openstackclustersetup field type str  type string.
   * @return keystoneHost
   */
  public String getKeystoneHost() {
    return keystoneHost;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property keystone_host of obj type openstackclustersetup field type str  type string.
   * @param keystoneHost set the keystoneHost.
   */
  public void setKeystoneHost(String  keystoneHost) {
    this.keystoneHost = keystoneHost;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
   * @return privilege
   */
  public String getPrivilege() {
    return privilege;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
   * @param privilege set the privilege.
   */
  public void setPrivilege(String  privilege) {
    this.privilege = privilege;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OpenStackClusterSetup objOpenStackClusterSetup = (OpenStackClusterSetup) o;
  return   Objects.equals(this.ccId, objOpenStackClusterSetup.ccId)&&
  Objects.equals(this.keystoneHost, objOpenStackClusterSetup.keystoneHost)&&
  Objects.equals(this.adminTenant, objOpenStackClusterSetup.adminTenant)&&
  Objects.equals(this.privilege, objOpenStackClusterSetup.privilege)&&
  Objects.equals(this.errorString, objOpenStackClusterSetup.errorString)&&
  Objects.equals(this.authUrl, objOpenStackClusterSetup.authUrl);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OpenStackClusterSetup {\n");
      sb.append("    adminTenant: ").append(toIndentedString(adminTenant)).append("\n");
        sb.append("    authUrl: ").append(toIndentedString(authUrl)).append("\n");
        sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
        sb.append("    keystoneHost: ").append(toIndentedString(keystoneHost)).append("\n");
        sb.append("    privilege: ").append(toIndentedString(privilege)).append("\n");
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

