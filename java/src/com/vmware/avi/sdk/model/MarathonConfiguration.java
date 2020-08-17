package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MarathonConfiguration is a POJO class extends AviRestResource that used for creating
 * MarathonConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarathonConfiguration  {
    @JsonProperty("framework_tag")
    private String frameworkTag = null;

    @JsonProperty("marathon_password")
    private String marathonPassword = null;

    @JsonProperty("marathon_url")
    private String marathonUrl = "http://leader.mesos:8080";

    @JsonProperty("marathon_username")
    private String marathonUsername = null;

    @JsonProperty("private_port_range")
    private PortRange privatePortRange = null;

    @JsonProperty("public_port_range")
    private PortRange publicPortRange = null;

    @JsonProperty("tenant")
    private String tenant = "admin";

    @JsonProperty("use_token_auth")
    private Boolean useTokenAuth = false;

    @JsonProperty("vs_name_tag_framework")
    private Boolean vsNameTagFramework = false;



  /**
   * This is the getter method this will return the attribute value.
   * Framework tag to be used in virtualservice name.
   * Default is framework name from mesos.
   * If this tag is altered atruntime, virtualservices will be deleted and re-created.
   * @return frameworkTag
   */
  public String getFrameworkTag() {
    return frameworkTag;
  }

  /**
   * This is the setter method to the attribute.
   * Framework tag to be used in virtualservice name.
   * Default is framework name from mesos.
   * If this tag is altered atruntime, virtualservices will be deleted and re-created.
   * @param frameworkTag set the frameworkTag.
   */
  public void setFrameworkTag(String  frameworkTag) {
    this.frameworkTag = frameworkTag;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Password for marathon authentication.
   * @return marathonPassword
   */
  public String getMarathonPassword() {
    return marathonPassword;
  }

  /**
   * This is the setter method to the attribute.
   * Password for marathon authentication.
   * @param marathonPassword set the marathonPassword.
   */
  public void setMarathonPassword(String  marathonPassword) {
    this.marathonPassword = marathonPassword;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Marathon api url of the form http //host port.
   * Default value when not specified in API or module is interpreted by Avi Controller as http://leader.mesos:8080.
   * @return marathonUrl
   */
  public String getMarathonUrl() {
    return marathonUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Marathon api url of the form http //host port.
   * Default value when not specified in API or module is interpreted by Avi Controller as http://leader.mesos:8080.
   * @param marathonUrl set the marathonUrl.
   */
  public void setMarathonUrl(String  marathonUrl) {
    this.marathonUrl = marathonUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Username for marathon authentication.
   * @return marathonUsername
   */
  public String getMarathonUsername() {
    return marathonUsername;
  }

  /**
   * This is the setter method to the attribute.
   * Username for marathon authentication.
   * @param marathonUsername set the marathonUsername.
   */
  public void setMarathonUsername(String  marathonUsername) {
    this.marathonUsername = marathonUsername;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Private port range allocated to this marathon framework instance.
   * @return privatePortRange
   */
  public PortRange getPrivatePortRange() {
    return privatePortRange;
  }

  /**
   * This is the setter method to the attribute.
   * Private port range allocated to this marathon framework instance.
   * @param privatePortRange set the privatePortRange.
   */
  public void setPrivatePortRange(PortRange privatePortRange) {
    this.privatePortRange = privatePortRange;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Public port range allocated to this marathon framework instance.
   * @return publicPortRange
   */
  public PortRange getPublicPortRange() {
    return publicPortRange;
  }

  /**
   * This is the setter method to the attribute.
   * Public port range allocated to this marathon framework instance.
   * @param publicPortRange set the publicPortRange.
   */
  public void setPublicPortRange(PortRange publicPortRange) {
    this.publicPortRange = publicPortRange;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant to pin this marathon instance to.
   * If set, a tenant object will be created in avi bearing this name and all applications created in this marathon will be associated with this
   * tenant regardless of, if any, tenant configuration in marathon label for this application.
   * Default value when not specified in API or module is interpreted by Avi Controller as admin.
   * @return tenant
   */
  public String getTenant() {
    return tenant;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant to pin this marathon instance to.
   * If set, a tenant object will be created in avi bearing this name and all applications created in this marathon will be associated with this
   * tenant regardless of, if any, tenant configuration in marathon label for this application.
   * Default value when not specified in API or module is interpreted by Avi Controller as admin.
   * @param tenant set the tenant.
   */
  public void setTenant(String  tenant) {
    this.tenant = tenant;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use token based authentication instead of basic authentication.
   * Token is refreshed every 5 minutes.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useTokenAuth
   */
  public Boolean getUseTokenAuth() {
    return useTokenAuth;
  }

  /**
   * This is the setter method to the attribute.
   * Use token based authentication instead of basic authentication.
   * Token is refreshed every 5 minutes.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useTokenAuth set the useTokenAuth.
   */
  public void setUseTokenAuth(Boolean  useTokenAuth) {
    this.useTokenAuth = useTokenAuth;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tag vs name with framework name or framework_tag.
   * Useful in deployments with multiple frameworks.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return vsNameTagFramework
   */
  public Boolean getVsNameTagFramework() {
    return vsNameTagFramework;
  }

  /**
   * This is the setter method to the attribute.
   * Tag vs name with framework name or framework_tag.
   * Useful in deployments with multiple frameworks.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param vsNameTagFramework set the vsNameTagFramework.
   */
  public void setVsNameTagFramework(Boolean  vsNameTagFramework) {
    this.vsNameTagFramework = vsNameTagFramework;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MarathonConfiguration objMarathonConfiguration = (MarathonConfiguration) o;
  return   Objects.equals(this.marathonUrl, objMarathonConfiguration.marathonUrl)&&
  Objects.equals(this.marathonUsername, objMarathonConfiguration.marathonUsername)&&
  Objects.equals(this.marathonPassword, objMarathonConfiguration.marathonPassword)&&
  Objects.equals(this.publicPortRange, objMarathonConfiguration.publicPortRange)&&
  Objects.equals(this.privatePortRange, objMarathonConfiguration.privatePortRange)&&
  Objects.equals(this.frameworkTag, objMarathonConfiguration.frameworkTag)&&
  Objects.equals(this.vsNameTagFramework, objMarathonConfiguration.vsNameTagFramework)&&
  Objects.equals(this.useTokenAuth, objMarathonConfiguration.useTokenAuth)&&
  Objects.equals(this.tenant, objMarathonConfiguration.tenant);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MarathonConfiguration {\n");
      sb.append("    frameworkTag: ").append(toIndentedString(frameworkTag)).append("\n");
        sb.append("    marathonPassword: ").append(toIndentedString(marathonPassword)).append("\n");
        sb.append("    marathonUrl: ").append(toIndentedString(marathonUrl)).append("\n");
        sb.append("    marathonUsername: ").append(toIndentedString(marathonUsername)).append("\n");
        sb.append("    privatePortRange: ").append(toIndentedString(privatePortRange)).append("\n");
        sb.append("    publicPortRange: ").append(toIndentedString(publicPortRange)).append("\n");
        sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
        sb.append("    useTokenAuth: ").append(toIndentedString(useTokenAuth)).append("\n");
        sb.append("    vsNameTagFramework: ").append(toIndentedString(vsNameTagFramework)).append("\n");
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

