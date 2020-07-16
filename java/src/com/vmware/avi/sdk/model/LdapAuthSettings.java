package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The LdapAuthSettings is a POJO class extends AviRestResource that used for creating
 * LdapAuthSettings.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LdapAuthSettings  {
    @JsonProperty("base_dn")
    private String baseDn = null;

    @JsonProperty("bind_as_administrator")
    private Boolean bindAsAdministrator = true;

    @JsonProperty("email_attribute")
    private String emailAttribute = "email";

    @JsonProperty("full_name_attribute")
    private String fullNameAttribute = "name";

    @JsonProperty("port")
    private Integer port = 389;

    @JsonProperty("security_mode")
    private String securityMode = null;

    @JsonProperty("server")
    private List<String> server = null;

    @JsonProperty("settings")
    private LdapDirectorySettings settings = null;

    @JsonProperty("user_bind")
    private LdapUserBindSettings userBind = null;



  /**
   * This is the getter method this will return the attribute value.
   * The ldap base dn.
   * For example, avinetworks.com would be dc=avinetworks,dc=com.
   * @return baseDn
   */
  public String getBaseDn() {
    return baseDn;
  }

  /**
   * This is the setter method to the attribute.
   * The ldap base dn.
   * For example, avinetworks.com would be dc=avinetworks,dc=com.
   * @param baseDn set the baseDn.
   */
  public void setBaseDn(String  baseDn) {
    this.baseDn = baseDn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap administrator credentials are used to search for users and group memberships.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return bindAsAdministrator
   */
  public Boolean getBindAsAdministrator() {
    return bindAsAdministrator;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap administrator credentials are used to search for users and group memberships.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param bindAsAdministrator set the bindAsAdministrator.
   */
  public void setBindAsAdministrator(Boolean  bindAsAdministrator) {
    this.bindAsAdministrator = bindAsAdministrator;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap attribute that refers to user email.
   * Default value when not specified in API or module is interpreted by Avi Controller as email.
   * @return emailAttribute
   */
  public String getEmailAttribute() {
    return emailAttribute;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap attribute that refers to user email.
   * Default value when not specified in API or module is interpreted by Avi Controller as email.
   * @param emailAttribute set the emailAttribute.
   */
  public void setEmailAttribute(String  emailAttribute) {
    this.emailAttribute = emailAttribute;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap attribute that refers to user's full name.
   * Default value when not specified in API or module is interpreted by Avi Controller as name.
   * @return fullNameAttribute
   */
  public String getFullNameAttribute() {
    return fullNameAttribute;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap attribute that refers to user's full name.
   * Default value when not specified in API or module is interpreted by Avi Controller as name.
   * @param fullNameAttribute set the fullNameAttribute.
   */
  public void setFullNameAttribute(String  fullNameAttribute) {
    this.fullNameAttribute = fullNameAttribute;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Query the ldap servers on this port.
   * Default value when not specified in API or module is interpreted by Avi Controller as 389.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Query the ldap servers on this port.
   * Default value when not specified in API or module is interpreted by Avi Controller as 389.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap connection security mode.
   * Enum options - AUTH_LDAP_SECURE_NONE, AUTH_LDAP_SECURE_USE_LDAPS.
   * @return securityMode
   */
  public String getSecurityMode() {
    return securityMode;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap connection security mode.
   * Enum options - AUTH_LDAP_SECURE_NONE, AUTH_LDAP_SECURE_USE_LDAPS.
   * @param securityMode set the securityMode.
   */
  public void setSecurityMode(String  securityMode) {
    this.securityMode = securityMode;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Ldap server ip address or hostname.
   * Use ip address if an auth profile is used to configure virtual service.
   * @return server
   */
  public List<String> getServer() {
    return server;
  }

  /**
   * This is the setter method. this will set the server
   * Ldap server ip address or hostname.
   * Use ip address if an auth profile is used to configure virtual service.
   * @return server
   */
  public void setServer(List<String>  server) {
    this.server = server;
  }

  /**
   * This is the setter method this will set the server
   * Ldap server ip address or hostname.
   * Use ip address if an auth profile is used to configure virtual service.
   * @return server
   */
  public LdapAuthSettings addServerItem(String serverItem) {
    if (this.server == null) {
      this.server = new ArrayList<String>();
    }
    this.server.add(serverItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap full directory configuration with administrator credentials.
   * @return settings
   */
  public LdapDirectorySettings getSettings() {
    return settings;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap full directory configuration with administrator credentials.
   * @param settings set the settings.
   */
  public void setSettings(LdapDirectorySettings settings) {
    this.settings = settings;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap anonymous bind configuration.
   * @return userBind
   */
  public LdapUserBindSettings getUserBind() {
    return userBind;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap anonymous bind configuration.
   * @param userBind set the userBind.
   */
  public void setUserBind(LdapUserBindSettings userBind) {
    this.userBind = userBind;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  LdapAuthSettings objLdapAuthSettings = (LdapAuthSettings) o;
  return   Objects.equals(this.securityMode, objLdapAuthSettings.securityMode)&&
  Objects.equals(this.settings, objLdapAuthSettings.settings)&&
  Objects.equals(this.bindAsAdministrator, objLdapAuthSettings.bindAsAdministrator)&&
  Objects.equals(this.server, objLdapAuthSettings.server)&&
  Objects.equals(this.userBind, objLdapAuthSettings.userBind)&&
  Objects.equals(this.fullNameAttribute, objLdapAuthSettings.fullNameAttribute)&&
  Objects.equals(this.baseDn, objLdapAuthSettings.baseDn)&&
  Objects.equals(this.emailAttribute, objLdapAuthSettings.emailAttribute)&&
  Objects.equals(this.port, objLdapAuthSettings.port);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class LdapAuthSettings {\n");
      sb.append("    baseDn: ").append(toIndentedString(baseDn)).append("\n");
        sb.append("    bindAsAdministrator: ").append(toIndentedString(bindAsAdministrator)).append("\n");
        sb.append("    emailAttribute: ").append(toIndentedString(emailAttribute)).append("\n");
        sb.append("    fullNameAttribute: ").append(toIndentedString(fullNameAttribute)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    securityMode: ").append(toIndentedString(securityMode)).append("\n");
        sb.append("    server: ").append(toIndentedString(server)).append("\n");
        sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
        sb.append("    userBind: ").append(toIndentedString(userBind)).append("\n");
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

