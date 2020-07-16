package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PortalConfiguration is a POJO class extends AviRestResource that used for creating
 * PortalConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PortalConfiguration  {
    @JsonProperty("allow_basic_authentication")
    private Boolean allowBasicAuthentication = false;

    @JsonProperty("api_force_timeout")
    private Integer apiForceTimeout = 24;

    @JsonProperty("disable_remote_cli_shell")
    private Boolean disableRemoteCliShell = false;

    @JsonProperty("disable_swagger")
    private Boolean disableSwagger = false;

    @JsonProperty("enable_clickjacking_protection")
    private Boolean enableClickjackingProtection = true;

    @JsonProperty("enable_http")
    private Boolean enableHttp = true;

    @JsonProperty("enable_https")
    private Boolean enableHttps = true;

    @JsonProperty("http_port")
    private Integer httpPort = null;

    @JsonProperty("https_port")
    private Integer httpsPort = null;

    @JsonProperty("password_strength_check")
    private Boolean passwordStrengthCheck = false;

    @JsonProperty("redirect_to_https")
    private Boolean redirectToHttps = true;

    @JsonProperty("sslkeyandcertificate_refs")
    private List<String> sslkeyandcertificateRefs = null;

    @JsonProperty("sslprofile_ref")
    private String sslprofileRef = null;

    @JsonProperty("use_uuid_from_input")
    private Boolean useUuidFromInput = false;



  /**
   * This is the getter method this will return the attribute value.
   * Enable/disable http basic authentication.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allowBasicAuthentication
   */
  public Boolean getAllowBasicAuthentication() {
    return allowBasicAuthentication;
  }

  /**
   * This is the setter method to the attribute.
   * Enable/disable http basic authentication.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allowBasicAuthentication set the allowBasicAuthentication.
   */
  public void setAllowBasicAuthentication(Boolean  allowBasicAuthentication) {
    this.allowBasicAuthentication = allowBasicAuthentication;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Force api session timeout after the specified time (in hours).
   * Allowed values are 1-24.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 24.
   * @return apiForceTimeout
   */
  public Integer getApiForceTimeout() {
    return apiForceTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Force api session timeout after the specified time (in hours).
   * Allowed values are 1-24.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 24.
   * @param apiForceTimeout set the apiForceTimeout.
   */
  public void setApiForceTimeout(Integer  apiForceTimeout) {
    this.apiForceTimeout = apiForceTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable remote cli shell client access.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableRemoteCliShell
   */
  public Boolean getDisableRemoteCliShell() {
    return disableRemoteCliShell;
  }

  /**
   * This is the setter method to the attribute.
   * Disable remote cli shell client access.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableRemoteCliShell set the disableRemoteCliShell.
   */
  public void setDisableRemoteCliShell(Boolean  disableRemoteCliShell) {
    this.disableRemoteCliShell = disableRemoteCliShell;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable swagger access.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableSwagger
   */
  public Boolean getDisableSwagger() {
    return disableSwagger;
  }

  /**
   * This is the setter method to the attribute.
   * Disable swagger access.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableSwagger set the disableSwagger.
   */
  public void setDisableSwagger(Boolean  disableSwagger) {
    this.disableSwagger = disableSwagger;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable/disable clickjacking protection.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableClickjackingProtection
   */
  public Boolean getEnableClickjackingProtection() {
    return enableClickjackingProtection;
  }

  /**
   * This is the setter method to the attribute.
   * Enable/disable clickjacking protection.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableClickjackingProtection set the enableClickjackingProtection.
   */
  public void setEnableClickjackingProtection(Boolean  enableClickjackingProtection) {
    this.enableClickjackingProtection = enableClickjackingProtection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property enable_http of obj type portalconfiguration field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableHttp
   */
  public Boolean getEnableHttp() {
    return enableHttp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property enable_http of obj type portalconfiguration field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableHttp set the enableHttp.
   */
  public void setEnableHttp(Boolean  enableHttp) {
    this.enableHttp = enableHttp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property enable_https of obj type portalconfiguration field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableHttps
   */
  public Boolean getEnableHttps() {
    return enableHttps;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property enable_https of obj type portalconfiguration field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableHttps set the enableHttps.
   */
  public void setEnableHttps(Boolean  enableHttps) {
    this.enableHttps = enableHttps;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http port.
   * @return httpPort
   */
  public Integer getHttpPort() {
    return httpPort;
  }

  /**
   * This is the setter method to the attribute.
   * Http port.
   * @param httpPort set the httpPort.
   */
  public void setHttpPort(Integer  httpPort) {
    this.httpPort = httpPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Https port.
   * @return httpsPort
   */
  public Integer getHttpsPort() {
    return httpsPort;
  }

  /**
   * This is the setter method to the attribute.
   * Https port.
   * @param httpsPort set the httpsPort.
   */
  public void setHttpsPort(Integer  httpsPort) {
    this.httpsPort = httpsPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Strict checking of password strength for user accounts.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return passwordStrengthCheck
   */
  public Boolean getPasswordStrengthCheck() {
    return passwordStrengthCheck;
  }

  /**
   * This is the setter method to the attribute.
   * Strict checking of password strength for user accounts.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param passwordStrengthCheck set the passwordStrengthCheck.
   */
  public void setPasswordStrengthCheck(Boolean  passwordStrengthCheck) {
    this.passwordStrengthCheck = passwordStrengthCheck;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property redirect_to_https of obj type portalconfiguration field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return redirectToHttps
   */
  public Boolean getRedirectToHttps() {
    return redirectToHttps;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property redirect_to_https of obj type portalconfiguration field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param redirectToHttps set the redirectToHttps.
   */
  public void setRedirectToHttps(Boolean  redirectToHttps) {
    this.redirectToHttps = redirectToHttps;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Certificates for system portal.
   * Maximum 2 allowed.
   * Leave list empty to use system default certs.
   * It is a reference to an object of type sslkeyandcertificate.
   * @return sslkeyandcertificateRefs
   */
  public List<String> getSslkeyandcertificateRefs() {
    return sslkeyandcertificateRefs;
  }

  /**
   * This is the setter method. this will set the sslkeyandcertificateRefs
   * Certificates for system portal.
   * Maximum 2 allowed.
   * Leave list empty to use system default certs.
   * It is a reference to an object of type sslkeyandcertificate.
   * @return sslkeyandcertificateRefs
   */
  public void setSslkeyandcertificateRefs(List<String>  sslkeyandcertificateRefs) {
    this.sslkeyandcertificateRefs = sslkeyandcertificateRefs;
  }

  /**
   * This is the setter method this will set the sslkeyandcertificateRefs
   * Certificates for system portal.
   * Maximum 2 allowed.
   * Leave list empty to use system default certs.
   * It is a reference to an object of type sslkeyandcertificate.
   * @return sslkeyandcertificateRefs
   */
  public PortalConfiguration addSslkeyandcertificateRefsItem(String sslkeyandcertificateRefsItem) {
    if (this.sslkeyandcertificateRefs == null) {
      this.sslkeyandcertificateRefs = new ArrayList<String>();
    }
    this.sslkeyandcertificateRefs.add(sslkeyandcertificateRefsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type sslprofile.
   * @return sslprofileRef
   */
  public String getSslprofileRef() {
    return sslprofileRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type sslprofile.
   * @param sslprofileRef set the sslprofileRef.
   */
  public void setSslprofileRef(String  sslprofileRef) {
    this.sslprofileRef = sslprofileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use uuid in post object data as uuid of the new object, instead of a generated uuid.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useUuidFromInput
   */
  public Boolean getUseUuidFromInput() {
    return useUuidFromInput;
  }

  /**
   * This is the setter method to the attribute.
   * Use uuid in post object data as uuid of the new object, instead of a generated uuid.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useUuidFromInput set the useUuidFromInput.
   */
  public void setUseUuidFromInput(Boolean  useUuidFromInput) {
    this.useUuidFromInput = useUuidFromInput;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  PortalConfiguration objPortalConfiguration = (PortalConfiguration) o;
  return   Objects.equals(this.useUuidFromInput, objPortalConfiguration.useUuidFromInput)&&
  Objects.equals(this.redirectToHttps, objPortalConfiguration.redirectToHttps)&&
  Objects.equals(this.httpsPort, objPortalConfiguration.httpsPort)&&
  Objects.equals(this.disableRemoteCliShell, objPortalConfiguration.disableRemoteCliShell)&&
  Objects.equals(this.enableClickjackingProtection, objPortalConfiguration.enableClickjackingProtection)&&
  Objects.equals(this.sslprofileRef, objPortalConfiguration.sslprofileRef)&&
  Objects.equals(this.enableHttps, objPortalConfiguration.enableHttps)&&
  Objects.equals(this.allowBasicAuthentication, objPortalConfiguration.allowBasicAuthentication)&&
  Objects.equals(this.httpPort, objPortalConfiguration.httpPort)&&
  Objects.equals(this.sslkeyandcertificateRefs, objPortalConfiguration.sslkeyandcertificateRefs)&&
  Objects.equals(this.disableSwagger, objPortalConfiguration.disableSwagger)&&
  Objects.equals(this.enableHttp, objPortalConfiguration.enableHttp)&&
  Objects.equals(this.apiForceTimeout, objPortalConfiguration.apiForceTimeout)&&
  Objects.equals(this.passwordStrengthCheck, objPortalConfiguration.passwordStrengthCheck);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PortalConfiguration {\n");
      sb.append("    allowBasicAuthentication: ").append(toIndentedString(allowBasicAuthentication)).append("\n");
        sb.append("    apiForceTimeout: ").append(toIndentedString(apiForceTimeout)).append("\n");
        sb.append("    disableRemoteCliShell: ").append(toIndentedString(disableRemoteCliShell)).append("\n");
        sb.append("    disableSwagger: ").append(toIndentedString(disableSwagger)).append("\n");
        sb.append("    enableClickjackingProtection: ").append(toIndentedString(enableClickjackingProtection)).append("\n");
        sb.append("    enableHttp: ").append(toIndentedString(enableHttp)).append("\n");
        sb.append("    enableHttps: ").append(toIndentedString(enableHttps)).append("\n");
        sb.append("    httpPort: ").append(toIndentedString(httpPort)).append("\n");
        sb.append("    httpsPort: ").append(toIndentedString(httpsPort)).append("\n");
        sb.append("    passwordStrengthCheck: ").append(toIndentedString(passwordStrengthCheck)).append("\n");
        sb.append("    redirectToHttps: ").append(toIndentedString(redirectToHttps)).append("\n");
        sb.append("    sslkeyandcertificateRefs: ").append(toIndentedString(sslkeyandcertificateRefs)).append("\n");
        sb.append("    sslprofileRef: ").append(toIndentedString(sslprofileRef)).append("\n");
        sb.append("    useUuidFromInput: ").append(toIndentedString(useUuidFromInput)).append("\n");
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

