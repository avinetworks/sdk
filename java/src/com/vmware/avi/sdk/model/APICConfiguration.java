package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The APICConfiguration is a POJO class extends AviRestResource that used for creating
 * APICConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APICConfiguration  {
    @JsonProperty("apic_admin_tenant")
    private String apicAdminTenant = "common";

    @JsonProperty("apic_domain")
    private String apicDomain = null;

    @JsonProperty("apic_name")
    private List<String> apicName = null;

    @JsonProperty("apic_password")
    private String apicPassword = null;

    @JsonProperty("apic_product")
    private String apicProduct = "asp";

    @JsonProperty("apic_username")
    private String apicUsername = null;

    @JsonProperty("apic_vendor")
    private String apicVendor = "avi";

    @JsonProperty("avi_controller_password")
    private String aviControllerPassword = null;

    @JsonProperty("avi_controller_username")
    private String aviControllerUsername = "admin";

    @JsonProperty("context_aware")
    private String contextAware = "SINGLE_CONTEXT";

    @JsonProperty("deployment")
    private String deployment = null;

    @JsonProperty("managed_mode")
    private Boolean managedMode = true;

    @JsonProperty("minor")
    private String minor = "2";

    @JsonProperty("se_tunnel_mode")
    private Boolean seTunnelMode = true;

    @JsonProperty("version")
    private String version = "1.0";



  /**
   * This is the getter method this will return the attribute value.
   * Name of the avi specific tenant created within apic.
   * Default value when not specified in API or module is interpreted by Avi Controller as common.
   * @return apicAdminTenant
   */
  public String getApicAdminTenant() {
    return apicAdminTenant;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the avi specific tenant created within apic.
   * Default value when not specified in API or module is interpreted by Avi Controller as common.
   * @param apicAdminTenant set the apicAdminTenant.
   */
  public void setApicAdminTenant(String  apicAdminTenant) {
    this.apicAdminTenant = apicAdminTenant;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vcenter's virtual machine manager domain within apic.
   * @return apicDomain
   */
  public String getApicDomain() {
    return apicDomain;
  }

  /**
   * This is the setter method to the attribute.
   * Vcenter's virtual machine manager domain within apic.
   * @param apicDomain set the apicDomain.
   */
  public void setApicDomain(String  apicDomain) {
    this.apicDomain = apicDomain;
  }
  /**
   * This is the getter method this will return the attribute value.
   * The hostname or ip address of the apic controller.
   * @return apicName
   */
  public List<String> getApicName() {
    return apicName;
  }

  /**
   * This is the setter method. this will set the apicName
   * The hostname or ip address of the apic controller.
   * @return apicName
   */
  public void setApicName(List<String>  apicName) {
    this.apicName = apicName;
  }

  /**
   * This is the setter method this will set the apicName
   * The hostname or ip address of the apic controller.
   * @return apicName
   */
  public APICConfiguration addApicNameItem(String apicNameItem) {
    if (this.apicName == null) {
      this.apicName = new ArrayList<String>();
    }
    this.apicName.add(apicNameItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The password avi vantage will use when authenticating with apic.
   * @return apicPassword
   */
  public String getApicPassword() {
    return apicPassword;
  }

  /**
   * This is the setter method to the attribute.
   * The password avi vantage will use when authenticating with apic.
   * @param apicPassword set the apicPassword.
   */
  public void setApicPassword(String  apicPassword) {
    this.apicPassword = apicPassword;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 17.2.10,18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as asp.
   * @return apicProduct
   */
  public String getApicProduct() {
    return apicProduct;
  }

  /**
   * This is the setter method to the attribute.
   * Field deprecated in 17.2.10,18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as asp.
   * @param apicProduct set the apicProduct.
   */
  public void setApicProduct(String  apicProduct) {
    this.apicProduct = apicProduct;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The username avi vantage will use when authenticating with apic.
   * @return apicUsername
   */
  public String getApicUsername() {
    return apicUsername;
  }

  /**
   * This is the setter method to the attribute.
   * The username avi vantage will use when authenticating with apic.
   * @param apicUsername set the apicUsername.
   */
  public void setApicUsername(String  apicUsername) {
    this.apicUsername = apicUsername;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 17.2.10,18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as avi.
   * @return apicVendor
   */
  public String getApicVendor() {
    return apicVendor;
  }

  /**
   * This is the setter method to the attribute.
   * Field deprecated in 17.2.10,18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as avi.
   * @param apicVendor set the apicVendor.
   */
  public void setApicVendor(String  apicVendor) {
    this.apicVendor = apicVendor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The password apic will use when authenticating with avi vantage.
   * Field deprecated in 17.2.10,18.1.2.
   * @return aviControllerPassword
   */
  public String getAviControllerPassword() {
    return aviControllerPassword;
  }

  /**
   * This is the setter method to the attribute.
   * The password apic will use when authenticating with avi vantage.
   * Field deprecated in 17.2.10,18.1.2.
   * @param aviControllerPassword set the aviControllerPassword.
   */
  public void setAviControllerPassword(String  aviControllerPassword) {
    this.aviControllerPassword = aviControllerPassword;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The username apic will use when authenticating with avi vantage.
   * Field deprecated in 17.2.10,18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as admin.
   * @return aviControllerUsername
   */
  public String getAviControllerUsername() {
    return aviControllerUsername;
  }

  /**
   * This is the setter method to the attribute.
   * The username apic will use when authenticating with avi vantage.
   * Field deprecated in 17.2.10,18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as admin.
   * @param aviControllerUsername set the aviControllerUsername.
   */
  public void setAviControllerUsername(String  aviControllerUsername) {
    this.aviControllerUsername = aviControllerUsername;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Context aware for supporting service graphs across vrfs.
   * Enum options - SINGLE_CONTEXT, MULTI_CONTEXT.
   * Default value when not specified in API or module is interpreted by Avi Controller as SINGLE_CONTEXT.
   * @return contextAware
   */
  public String getContextAware() {
    return contextAware;
  }

  /**
   * This is the setter method to the attribute.
   * Context aware for supporting service graphs across vrfs.
   * Enum options - SINGLE_CONTEXT, MULTI_CONTEXT.
   * Default value when not specified in API or module is interpreted by Avi Controller as SINGLE_CONTEXT.
   * @param contextAware set the contextAware.
   */
  public void setContextAware(String  contextAware) {
    this.contextAware = contextAware;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 17.2.10,18.1.2.
   * @return deployment
   */
  public String getDeployment() {
    return deployment;
  }

  /**
   * This is the setter method to the attribute.
   * Field deprecated in 17.2.10,18.1.2.
   * @param deployment set the deployment.
   */
  public void setDeployment(String  deployment) {
    this.deployment = deployment;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use managed mode for apic service insertion.
   * Field deprecated in 17.2.10,18.1.2.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return managedMode
   */
  public Boolean getManagedMode() {
    return managedMode;
  }

  /**
   * This is the setter method to the attribute.
   * Use managed mode for apic service insertion.
   * Field deprecated in 17.2.10,18.1.2.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param managedMode set the managedMode.
   */
  public void setManagedMode(Boolean  managedMode) {
    this.managedMode = managedMode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi device package minor version.
   * Field deprecated in 17.2.10,18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @return minor
   */
  public String getMinor() {
    return minor;
  }

  /**
   * This is the setter method to the attribute.
   * Avi device package minor version.
   * Field deprecated in 17.2.10,18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @param minor set the minor.
   */
  public void setMinor(String  minor) {
    this.minor = minor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Determines if dsr from secondary se is active or not  false   dsr active.
   * Please ensure that apic bd's endpoint dataplane learning is disabled true    disable dsr unconditionally.
   * Field introduced in 17.2.10,18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return seTunnelMode
   */
  public Boolean getSeTunnelMode() {
    return seTunnelMode;
  }

  /**
   * This is the setter method to the attribute.
   * Determines if dsr from secondary se is active or not  false   dsr active.
   * Please ensure that apic bd's endpoint dataplane learning is disabled true    disable dsr unconditionally.
   * Field introduced in 17.2.10,18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param seTunnelMode set the seTunnelMode.
   */
  public void setSeTunnelMode(Boolean  seTunnelMode) {
    this.seTunnelMode = seTunnelMode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi device package version.
   * Field deprecated in 17.2.10,18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.0.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Avi device package version.
   * Field deprecated in 17.2.10,18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.0.
   * @param version set the version.
   */
  public void setVersion(String  version) {
    this.version = version;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  APICConfiguration objAPICConfiguration = (APICConfiguration) o;
  return   Objects.equals(this.seTunnelMode, objAPICConfiguration.seTunnelMode)&&
  Objects.equals(this.apicVendor, objAPICConfiguration.apicVendor)&&
  Objects.equals(this.version, objAPICConfiguration.version)&&
  Objects.equals(this.apicPassword, objAPICConfiguration.apicPassword)&&
  Objects.equals(this.deployment, objAPICConfiguration.deployment)&&
  Objects.equals(this.apicAdminTenant, objAPICConfiguration.apicAdminTenant)&&
  Objects.equals(this.apicUsername, objAPICConfiguration.apicUsername)&&
  Objects.equals(this.contextAware, objAPICConfiguration.contextAware)&&
  Objects.equals(this.aviControllerPassword, objAPICConfiguration.aviControllerPassword)&&
  Objects.equals(this.aviControllerUsername, objAPICConfiguration.aviControllerUsername)&&
  Objects.equals(this.apicProduct, objAPICConfiguration.apicProduct)&&
  Objects.equals(this.apicDomain, objAPICConfiguration.apicDomain)&&
  Objects.equals(this.apicName, objAPICConfiguration.apicName)&&
  Objects.equals(this.managedMode, objAPICConfiguration.managedMode)&&
  Objects.equals(this.minor, objAPICConfiguration.minor);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class APICConfiguration {\n");
      sb.append("    apicAdminTenant: ").append(toIndentedString(apicAdminTenant)).append("\n");
        sb.append("    apicDomain: ").append(toIndentedString(apicDomain)).append("\n");
        sb.append("    apicName: ").append(toIndentedString(apicName)).append("\n");
        sb.append("    apicPassword: ").append(toIndentedString(apicPassword)).append("\n");
        sb.append("    apicProduct: ").append(toIndentedString(apicProduct)).append("\n");
        sb.append("    apicUsername: ").append(toIndentedString(apicUsername)).append("\n");
        sb.append("    apicVendor: ").append(toIndentedString(apicVendor)).append("\n");
        sb.append("    aviControllerPassword: ").append(toIndentedString(aviControllerPassword)).append("\n");
        sb.append("    aviControllerUsername: ").append(toIndentedString(aviControllerUsername)).append("\n");
        sb.append("    contextAware: ").append(toIndentedString(contextAware)).append("\n");
        sb.append("    deployment: ").append(toIndentedString(deployment)).append("\n");
        sb.append("    managedMode: ").append(toIndentedString(managedMode)).append("\n");
        sb.append("    minor: ").append(toIndentedString(minor)).append("\n");
        sb.append("    seTunnelMode: ").append(toIndentedString(seTunnelMode)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

