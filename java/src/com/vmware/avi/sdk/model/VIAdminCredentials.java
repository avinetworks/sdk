package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIAdminCredentials is a POJO class extends AviRestResource that used for creating
 * VIAdminCredentials.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIAdminCredentials  {
    @JsonProperty("name")
    private String name = "root";

    @JsonProperty("password")
    private String password = "vmware";

    @JsonProperty("privilege")
    private String privilege = null;

    @JsonProperty("vcenter_url")
    private String vcenterUrl = null;

    @JsonProperty("vi_mgr_token")
    private String viMgrToken = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * Default value when not specified in API or module is interpreted by Avi Controller as root.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * Default value when not specified in API or module is interpreted by Avi Controller as root.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property password of obj type viadmincredentials field type str  type string.
   * Default value when not specified in API or module is interpreted by Avi Controller as vmware.
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property password of obj type viadmincredentials field type str  type string.
   * Default value when not specified in API or module is interpreted by Avi Controller as vmware.
   * @param password set the password.
   */
  public void setPassword(String  password) {
    this.password = password;
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

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_url of obj type viadmincredentials field type str  type string.
   * @return vcenterUrl
   */
  public String getVcenterUrl() {
    return vcenterUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_url of obj type viadmincredentials field type str  type string.
   * @param vcenterUrl set the vcenterUrl.
   */
  public void setVcenterUrl(String  vcenterUrl) {
    this.vcenterUrl = vcenterUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vi_mgr_token of obj type viadmincredentials field type str  type string.
   * @return viMgrToken
   */
  public String getViMgrToken() {
    return viMgrToken;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vi_mgr_token of obj type viadmincredentials field type str  type string.
   * @param viMgrToken set the viMgrToken.
   */
  public void setViMgrToken(String  viMgrToken) {
    this.viMgrToken = viMgrToken;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VIAdminCredentials objVIAdminCredentials = (VIAdminCredentials) o;
  return   Objects.equals(this.vcenterUrl, objVIAdminCredentials.vcenterUrl)&&
  Objects.equals(this.name, objVIAdminCredentials.name)&&
  Objects.equals(this.password, objVIAdminCredentials.password)&&
  Objects.equals(this.viMgrToken, objVIAdminCredentials.viMgrToken)&&
  Objects.equals(this.privilege, objVIAdminCredentials.privilege);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIAdminCredentials {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    privilege: ").append(toIndentedString(privilege)).append("\n");
        sb.append("    vcenterUrl: ").append(toIndentedString(vcenterUrl)).append("\n");
        sb.append("    viMgrToken: ").append(toIndentedString(viMgrToken)).append("\n");
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

