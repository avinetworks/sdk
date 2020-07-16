package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafApplicationSignatureProvider is a POJO class extends AviRestResource that used for creating
 * WafApplicationSignatureProvider.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafApplicationSignatureProvider extends AviRestResource  {
    @JsonProperty("available_applications")
    private List<WafApplicationSignatureAppVersion> availableApplications = null;

    @JsonProperty("last_check_for_updates_error")
    private String lastCheckForUpdatesError = null;

    @JsonProperty("last_failed_check_for_updates")
    private TimeStamp lastFailedCheckForUpdates = null;

    @JsonProperty("last_successful_check_for_updates")
    private TimeStamp lastSuccessfulCheckForUpdates = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("ruleset_version")
    private String rulesetVersion = null;

    @JsonProperty("signatures")
    private List<WafRule> signatures = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;


  /**
   * This is the getter method this will return the attribute value.
   * Available application names and the ruleset version, when the rules for an application changed the last time.
   * Field introduced in 20.1.1.
   * @return availableApplications
   */
  public List<WafApplicationSignatureAppVersion> getAvailableApplications() {
    return availableApplications;
  }

  /**
   * This is the setter method. this will set the availableApplications
   * Available application names and the ruleset version, when the rules for an application changed the last time.
   * Field introduced in 20.1.1.
   * @return availableApplications
   */
  public void setAvailableApplications(List<WafApplicationSignatureAppVersion>  availableApplications) {
    this.availableApplications = availableApplications;
  }

  /**
   * This is the setter method this will set the availableApplications
   * Available application names and the ruleset version, when the rules for an application changed the last time.
   * Field introduced in 20.1.1.
   * @return availableApplications
   */
  public WafApplicationSignatureProvider addAvailableApplicationsItem(WafApplicationSignatureAppVersion availableApplicationsItem) {
    if (this.availableApplications == null) {
      this.availableApplications = new ArrayList<WafApplicationSignatureAppVersion>();
    }
    this.availableApplications.add(availableApplicationsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The error message indicating why the last update check failed.
   * Field introduced in 20.1.1.
   * @return lastCheckForUpdatesError
   */
  public String getLastCheckForUpdatesError() {
    return lastCheckForUpdatesError;
  }

  /**
   * This is the setter method to the attribute.
   * The error message indicating why the last update check failed.
   * Field introduced in 20.1.1.
   * @param lastCheckForUpdatesError set the lastCheckForUpdatesError.
   */
  public void setLastCheckForUpdatesError(String  lastCheckForUpdatesError) {
    this.lastCheckForUpdatesError = lastCheckForUpdatesError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The last time that we checked for updates but did not get a result because of an error.
   * Field introduced in 20.1.1.
   * @return lastFailedCheckForUpdates
   */
  public TimeStamp getLastFailedCheckForUpdates() {
    return lastFailedCheckForUpdates;
  }

  /**
   * This is the setter method to the attribute.
   * The last time that we checked for updates but did not get a result because of an error.
   * Field introduced in 20.1.1.
   * @param lastFailedCheckForUpdates set the lastFailedCheckForUpdates.
   */
  public void setLastFailedCheckForUpdates(TimeStamp lastFailedCheckForUpdates) {
    this.lastFailedCheckForUpdates = lastFailedCheckForUpdates;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The last time that we checked for updates sucessfully.
   * Field introduced in 20.1.1.
   * @return lastSuccessfulCheckForUpdates
   */
  public TimeStamp getLastSuccessfulCheckForUpdates() {
    return lastSuccessfulCheckForUpdates;
  }

  /**
   * This is the setter method to the attribute.
   * The last time that we checked for updates sucessfully.
   * Field introduced in 20.1.1.
   * @param lastSuccessfulCheckForUpdates set the lastSuccessfulCheckForUpdates.
   */
  public void setLastSuccessfulCheckForUpdates(TimeStamp lastSuccessfulCheckForUpdates) {
    this.lastSuccessfulCheckForUpdates = lastSuccessfulCheckForUpdates;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of application specific ruleset provider.
   * Field introduced in 20.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of application specific ruleset provider.
   * Field introduced in 20.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Version of signatures.
   * Field introduced in 20.1.1.
   * @return rulesetVersion
   */
  public String getRulesetVersion() {
    return rulesetVersion;
  }

  /**
   * This is the setter method to the attribute.
   * Version of signatures.
   * Field introduced in 20.1.1.
   * @param rulesetVersion set the rulesetVersion.
   */
  public void setRulesetVersion(String  rulesetVersion) {
    this.rulesetVersion = rulesetVersion;
  }
  /**
   * This is the getter method this will return the attribute value.
   * The waf rules.
   * Not visible in the api.
   * Field introduced in 20.1.1.
   * @return signatures
   */
  public List<WafRule> getSignatures() {
    return signatures;
  }

  /**
   * This is the setter method. this will set the signatures
   * The waf rules.
   * Not visible in the api.
   * Field introduced in 20.1.1.
   * @return signatures
   */
  public void setSignatures(List<WafRule>  signatures) {
    this.signatures = signatures;
  }

  /**
   * This is the setter method this will set the signatures
   * The waf rules.
   * Not visible in the api.
   * Field introduced in 20.1.1.
   * @return signatures
   */
  public WafApplicationSignatureProvider addSignaturesItem(WafRule signaturesItem) {
    if (this.signatures == null) {
      this.signatures = new ArrayList<WafRule>();
    }
    this.signatures.add(signaturesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 20.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 20.1.1.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
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
   * Field introduced in 20.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 20.1.1.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  WafApplicationSignatureProvider objWafApplicationSignatureProvider = (WafApplicationSignatureProvider) o;
  return   Objects.equals(this.signatures, objWafApplicationSignatureProvider.signatures)&&
  Objects.equals(this.uuid, objWafApplicationSignatureProvider.uuid)&&
  Objects.equals(this.lastCheckForUpdatesError, objWafApplicationSignatureProvider.lastCheckForUpdatesError)&&
  Objects.equals(this.rulesetVersion, objWafApplicationSignatureProvider.rulesetVersion)&&
  Objects.equals(this.availableApplications, objWafApplicationSignatureProvider.availableApplications)&&
  Objects.equals(this.lastSuccessfulCheckForUpdates, objWafApplicationSignatureProvider.lastSuccessfulCheckForUpdates)&&
  Objects.equals(this.lastFailedCheckForUpdates, objWafApplicationSignatureProvider.lastFailedCheckForUpdates)&&
  Objects.equals(this.tenantRef, objWafApplicationSignatureProvider.tenantRef)&&
  Objects.equals(this.name, objWafApplicationSignatureProvider.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafApplicationSignatureProvider {\n");
      sb.append("    availableApplications: ").append(toIndentedString(availableApplications)).append("\n");
        sb.append("    lastCheckForUpdatesError: ").append(toIndentedString(lastCheckForUpdatesError)).append("\n");
        sb.append("    lastFailedCheckForUpdates: ").append(toIndentedString(lastFailedCheckForUpdates)).append("\n");
        sb.append("    lastSuccessfulCheckForUpdates: ").append(toIndentedString(lastSuccessfulCheckForUpdates)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    rulesetVersion: ").append(toIndentedString(rulesetVersion)).append("\n");
        sb.append("    signatures: ").append(toIndentedString(signatures)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

