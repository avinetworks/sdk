package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SystemConfiguration is a POJO class extends AviRestResource that used for creating
 * SystemConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SystemConfiguration extends AviRestResource  {
    @JsonProperty("admin_auth_configuration")
    private AdminAuthConfiguration adminAuthConfiguration = null;

    @JsonProperty("default_license_tier")
    private String defaultLicenseTier = "ENTERPRISE";

    @JsonProperty("dns_configuration")
    private DNSConfiguration dnsConfiguration = null;

    @JsonProperty("dns_virtualservice_refs")
    private List<String> dnsVirtualserviceRefs = null;

    @JsonProperty("docker_mode")
    private Boolean dockerMode = false;

    @JsonProperty("email_configuration")
    private EmailConfiguration emailConfiguration = null;

    @JsonProperty("fips_mode")
    private Boolean fipsMode = false;

    @JsonProperty("global_tenant_config")
    private TenantConfiguration globalTenantConfig = null;

    @JsonProperty("linux_configuration")
    private LinuxConfiguration linuxConfiguration = null;

    @JsonProperty("mgmt_ip_access_control")
    private MgmtIpAccessControl mgmtIpAccessControl = null;

    @JsonProperty("ntp_configuration")
    private NTPConfiguration ntpConfiguration = null;

    @JsonProperty("portal_configuration")
    private PortalConfiguration portalConfiguration = null;

    @JsonProperty("proxy_configuration")
    private ProxyConfiguration proxyConfiguration = null;

    @JsonProperty("secure_channel_configuration")
    private SecureChannelConfiguration secureChannelConfiguration = null;

    @JsonProperty("snmp_configuration")
    private SnmpConfiguration snmpConfiguration = null;

    @JsonProperty("ssh_ciphers")
    private List<String> sshCiphers = null;

    @JsonProperty("ssh_hmacs")
    private List<String> sshHmacs = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("welcome_workflow_complete")
    private Boolean welcomeWorkflowComplete = false;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property admin_auth_configuration of obj type systemconfiguration field type str  type ref.
   * @return adminAuthConfiguration
   */
  public AdminAuthConfiguration getAdminAuthConfiguration() {
    return adminAuthConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property admin_auth_configuration of obj type systemconfiguration field type str  type ref.
   * @param adminAuthConfiguration set the adminAuthConfiguration.
   */
  public void setAdminAuthConfiguration(AdminAuthConfiguration adminAuthConfiguration) {
    this.adminAuthConfiguration = adminAuthConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies the default license tier which would be used by new clouds.
   * Enum options - ENTERPRISE_16, ENTERPRISE, ENTERPRISE_18, BASIC.
   * Field introduced in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as ENTERPRISE.
   * @return defaultLicenseTier
   */
  public String getDefaultLicenseTier() {
    return defaultLicenseTier;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies the default license tier which would be used by new clouds.
   * Enum options - ENTERPRISE_16, ENTERPRISE, ENTERPRISE_18, BASIC.
   * Field introduced in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as ENTERPRISE.
   * @param defaultLicenseTier set the defaultLicenseTier.
   */
  public void setDefaultLicenseTier(String  defaultLicenseTier) {
    this.defaultLicenseTier = defaultLicenseTier;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dns_configuration of obj type systemconfiguration field type str  type ref.
   * @return dnsConfiguration
   */
  public DNSConfiguration getDnsConfiguration() {
    return dnsConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property dns_configuration of obj type systemconfiguration field type str  type ref.
   * @param dnsConfiguration set the dnsConfiguration.
   */
  public void setDnsConfiguration(DNSConfiguration dnsConfiguration) {
    this.dnsConfiguration = dnsConfiguration;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Dns virtualservices hosting fqdn records for applications across avi vantage.
   * If no virtualservices are provided, avi vantage will provide dns services for configured applications.
   * Switching back to avi vantage from dns virtualservices is not allowed.
   * It is a reference to an object of type virtualservice.
   * @return dnsVirtualserviceRefs
   */
  public List<String> getDnsVirtualserviceRefs() {
    return dnsVirtualserviceRefs;
  }

  /**
   * This is the setter method. this will set the dnsVirtualserviceRefs
   * Dns virtualservices hosting fqdn records for applications across avi vantage.
   * If no virtualservices are provided, avi vantage will provide dns services for configured applications.
   * Switching back to avi vantage from dns virtualservices is not allowed.
   * It is a reference to an object of type virtualservice.
   * @return dnsVirtualserviceRefs
   */
  public void setDnsVirtualserviceRefs(List<String>  dnsVirtualserviceRefs) {
    this.dnsVirtualserviceRefs = dnsVirtualserviceRefs;
  }

  /**
   * This is the setter method this will set the dnsVirtualserviceRefs
   * Dns virtualservices hosting fqdn records for applications across avi vantage.
   * If no virtualservices are provided, avi vantage will provide dns services for configured applications.
   * Switching back to avi vantage from dns virtualservices is not allowed.
   * It is a reference to an object of type virtualservice.
   * @return dnsVirtualserviceRefs
   */
  public SystemConfiguration addDnsVirtualserviceRefsItem(String dnsVirtualserviceRefsItem) {
    if (this.dnsVirtualserviceRefs == null) {
      this.dnsVirtualserviceRefs = new ArrayList<String>();
    }
    this.dnsVirtualserviceRefs.add(dnsVirtualserviceRefsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property docker_mode of obj type systemconfiguration field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return dockerMode
   */
  public Boolean getDockerMode() {
    return dockerMode;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property docker_mode of obj type systemconfiguration field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param dockerMode set the dockerMode.
   */
  public void setDockerMode(Boolean  dockerMode) {
    this.dockerMode = dockerMode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property email_configuration of obj type systemconfiguration field type str  type ref.
   * @return emailConfiguration
   */
  public EmailConfiguration getEmailConfiguration() {
    return emailConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property email_configuration of obj type systemconfiguration field type str  type ref.
   * @param emailConfiguration set the emailConfiguration.
   */
  public void setEmailConfiguration(EmailConfiguration emailConfiguration) {
    this.emailConfiguration = emailConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable fips mode.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return fipsMode
   */
  public Boolean getFipsMode() {
    return fipsMode;
  }

  /**
   * This is the setter method to the attribute.
   * Enable fips mode.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param fipsMode set the fipsMode.
   */
  public void setFipsMode(Boolean  fipsMode) {
    this.fipsMode = fipsMode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property global_tenant_config of obj type systemconfiguration field type str  type ref.
   * @return globalTenantConfig
   */
  public TenantConfiguration getGlobalTenantConfig() {
    return globalTenantConfig;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property global_tenant_config of obj type systemconfiguration field type str  type ref.
   * @param globalTenantConfig set the globalTenantConfig.
   */
  public void setGlobalTenantConfig(TenantConfiguration globalTenantConfig) {
    this.globalTenantConfig = globalTenantConfig;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property linux_configuration of obj type systemconfiguration field type str  type ref.
   * @return linuxConfiguration
   */
  public LinuxConfiguration getLinuxConfiguration() {
    return linuxConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property linux_configuration of obj type systemconfiguration field type str  type ref.
   * @param linuxConfiguration set the linuxConfiguration.
   */
  public void setLinuxConfiguration(LinuxConfiguration linuxConfiguration) {
    this.linuxConfiguration = linuxConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure ip access control for controller to restrict open access.
   * @return mgmtIpAccessControl
   */
  public MgmtIpAccessControl getMgmtIpAccessControl() {
    return mgmtIpAccessControl;
  }

  /**
   * This is the setter method to the attribute.
   * Configure ip access control for controller to restrict open access.
   * @param mgmtIpAccessControl set the mgmtIpAccessControl.
   */
  public void setMgmtIpAccessControl(MgmtIpAccessControl mgmtIpAccessControl) {
    this.mgmtIpAccessControl = mgmtIpAccessControl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ntp_configuration of obj type systemconfiguration field type str  type ref.
   * @return ntpConfiguration
   */
  public NTPConfiguration getNtpConfiguration() {
    return ntpConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ntp_configuration of obj type systemconfiguration field type str  type ref.
   * @param ntpConfiguration set the ntpConfiguration.
   */
  public void setNtpConfiguration(NTPConfiguration ntpConfiguration) {
    this.ntpConfiguration = ntpConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property portal_configuration of obj type systemconfiguration field type str  type ref.
   * @return portalConfiguration
   */
  public PortalConfiguration getPortalConfiguration() {
    return portalConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property portal_configuration of obj type systemconfiguration field type str  type ref.
   * @param portalConfiguration set the portalConfiguration.
   */
  public void setPortalConfiguration(PortalConfiguration portalConfiguration) {
    this.portalConfiguration = portalConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property proxy_configuration of obj type systemconfiguration field type str  type ref.
   * @return proxyConfiguration
   */
  public ProxyConfiguration getProxyConfiguration() {
    return proxyConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property proxy_configuration of obj type systemconfiguration field type str  type ref.
   * @param proxyConfiguration set the proxyConfiguration.
   */
  public void setProxyConfiguration(ProxyConfiguration proxyConfiguration) {
    this.proxyConfiguration = proxyConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure secure channel properties.
   * Field introduced in 18.1.4, 18.2.1.
   * @return secureChannelConfiguration
   */
  public SecureChannelConfiguration getSecureChannelConfiguration() {
    return secureChannelConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Configure secure channel properties.
   * Field introduced in 18.1.4, 18.2.1.
   * @param secureChannelConfiguration set the secureChannelConfiguration.
   */
  public void setSecureChannelConfiguration(SecureChannelConfiguration secureChannelConfiguration) {
    this.secureChannelConfiguration = secureChannelConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property snmp_configuration of obj type systemconfiguration field type str  type ref.
   * @return snmpConfiguration
   */
  public SnmpConfiguration getSnmpConfiguration() {
    return snmpConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property snmp_configuration of obj type systemconfiguration field type str  type ref.
   * @param snmpConfiguration set the snmpConfiguration.
   */
  public void setSnmpConfiguration(SnmpConfiguration snmpConfiguration) {
    this.snmpConfiguration = snmpConfiguration;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Allowed ciphers list for ssh to the management interface on the controller and service engines.
   * If this is not specified, all the default ciphers are allowed.
   * @return sshCiphers
   */
  public List<String> getSshCiphers() {
    return sshCiphers;
  }

  /**
   * This is the setter method. this will set the sshCiphers
   * Allowed ciphers list for ssh to the management interface on the controller and service engines.
   * If this is not specified, all the default ciphers are allowed.
   * @return sshCiphers
   */
  public void setSshCiphers(List<String>  sshCiphers) {
    this.sshCiphers = sshCiphers;
  }

  /**
   * This is the setter method this will set the sshCiphers
   * Allowed ciphers list for ssh to the management interface on the controller and service engines.
   * If this is not specified, all the default ciphers are allowed.
   * @return sshCiphers
   */
  public SystemConfiguration addSshCiphersItem(String sshCiphersItem) {
    if (this.sshCiphers == null) {
      this.sshCiphers = new ArrayList<String>();
    }
    this.sshCiphers.add(sshCiphersItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Allowed hmac list for ssh to the management interface on the controller and service engines.
   * If this is not specified, all the default hmacs are allowed.
   * @return sshHmacs
   */
  public List<String> getSshHmacs() {
    return sshHmacs;
  }

  /**
   * This is the setter method. this will set the sshHmacs
   * Allowed hmac list for ssh to the management interface on the controller and service engines.
   * If this is not specified, all the default hmacs are allowed.
   * @return sshHmacs
   */
  public void setSshHmacs(List<String>  sshHmacs) {
    this.sshHmacs = sshHmacs;
  }

  /**
   * This is the setter method this will set the sshHmacs
   * Allowed hmac list for ssh to the management interface on the controller and service engines.
   * If this is not specified, all the default hmacs are allowed.
   * @return sshHmacs
   */
  public SystemConfiguration addSshHmacsItem(String sshHmacsItem) {
    if (this.sshHmacs == null) {
      this.sshHmacs = new ArrayList<String>();
    }
    this.sshHmacs.add(sshHmacsItem);
    return this;
  }
/**
   * This is the getter method this will return the attribute value.
   * Avi controller URL of the object.
   * @return url
   */
  public String getUrl() {
    return url;
  }

  /**
   * This is the setter method. this will set the url
   * Avi controller URL of the object.
   * @return url
   */
  public void setUrl(String  url) {
    this.url = url;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This flag is set once the initial controller setup workflow is complete.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return welcomeWorkflowComplete
   */
  public Boolean getWelcomeWorkflowComplete() {
    return welcomeWorkflowComplete;
  }

  /**
   * This is the setter method to the attribute.
   * This flag is set once the initial controller setup workflow is complete.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param welcomeWorkflowComplete set the welcomeWorkflowComplete.
   */
  public void setWelcomeWorkflowComplete(Boolean  welcomeWorkflowComplete) {
    this.welcomeWorkflowComplete = welcomeWorkflowComplete;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SystemConfiguration objSystemConfiguration = (SystemConfiguration) o;
  return   Objects.equals(this.uuid, objSystemConfiguration.uuid)&&
  Objects.equals(this.dnsConfiguration, objSystemConfiguration.dnsConfiguration)&&
  Objects.equals(this.ntpConfiguration, objSystemConfiguration.ntpConfiguration)&&
  Objects.equals(this.portalConfiguration, objSystemConfiguration.portalConfiguration)&&
  Objects.equals(this.globalTenantConfig, objSystemConfiguration.globalTenantConfig)&&
  Objects.equals(this.emailConfiguration, objSystemConfiguration.emailConfiguration)&&
  Objects.equals(this.adminAuthConfiguration, objSystemConfiguration.adminAuthConfiguration)&&
  Objects.equals(this.dockerMode, objSystemConfiguration.dockerMode)&&
  Objects.equals(this.snmpConfiguration, objSystemConfiguration.snmpConfiguration)&&
  Objects.equals(this.linuxConfiguration, objSystemConfiguration.linuxConfiguration)&&
  Objects.equals(this.proxyConfiguration, objSystemConfiguration.proxyConfiguration)&&
  Objects.equals(this.mgmtIpAccessControl, objSystemConfiguration.mgmtIpAccessControl)&&
  Objects.equals(this.sshCiphers, objSystemConfiguration.sshCiphers)&&
  Objects.equals(this.sshHmacs, objSystemConfiguration.sshHmacs)&&
  Objects.equals(this.dnsVirtualserviceRefs, objSystemConfiguration.dnsVirtualserviceRefs)&&
  Objects.equals(this.defaultLicenseTier, objSystemConfiguration.defaultLicenseTier)&&
  Objects.equals(this.secureChannelConfiguration, objSystemConfiguration.secureChannelConfiguration)&&
  Objects.equals(this.welcomeWorkflowComplete, objSystemConfiguration.welcomeWorkflowComplete)&&
  Objects.equals(this.fipsMode, objSystemConfiguration.fipsMode);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SystemConfiguration {\n");
      sb.append("    adminAuthConfiguration: ").append(toIndentedString(adminAuthConfiguration)).append("\n");
        sb.append("    defaultLicenseTier: ").append(toIndentedString(defaultLicenseTier)).append("\n");
        sb.append("    dnsConfiguration: ").append(toIndentedString(dnsConfiguration)).append("\n");
        sb.append("    dnsVirtualserviceRefs: ").append(toIndentedString(dnsVirtualserviceRefs)).append("\n");
        sb.append("    dockerMode: ").append(toIndentedString(dockerMode)).append("\n");
        sb.append("    emailConfiguration: ").append(toIndentedString(emailConfiguration)).append("\n");
        sb.append("    fipsMode: ").append(toIndentedString(fipsMode)).append("\n");
        sb.append("    globalTenantConfig: ").append(toIndentedString(globalTenantConfig)).append("\n");
        sb.append("    linuxConfiguration: ").append(toIndentedString(linuxConfiguration)).append("\n");
        sb.append("    mgmtIpAccessControl: ").append(toIndentedString(mgmtIpAccessControl)).append("\n");
        sb.append("    ntpConfiguration: ").append(toIndentedString(ntpConfiguration)).append("\n");
        sb.append("    portalConfiguration: ").append(toIndentedString(portalConfiguration)).append("\n");
        sb.append("    proxyConfiguration: ").append(toIndentedString(proxyConfiguration)).append("\n");
        sb.append("    secureChannelConfiguration: ").append(toIndentedString(secureChannelConfiguration)).append("\n");
        sb.append("    snmpConfiguration: ").append(toIndentedString(snmpConfiguration)).append("\n");
        sb.append("    sshCiphers: ").append(toIndentedString(sshCiphers)).append("\n");
        sb.append("    sshHmacs: ").append(toIndentedString(sshHmacs)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    welcomeWorkflowComplete: ").append(toIndentedString(welcomeWorkflowComplete)).append("\n");
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

