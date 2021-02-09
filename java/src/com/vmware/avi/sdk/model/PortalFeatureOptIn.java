package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The PortalFeatureOptIn is a POJO class extends AviRestResource that used for creating
 * PortalFeatureOptIn.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PortalFeatureOptIn  {
    @JsonProperty("enable_appsignature_sync")
    private Boolean enableAppsignatureSync = false;

    @JsonProperty("enable_auto_case_creation_on_se_failure")
    private Boolean enableAutoCaseCreationOnSeFailure = false;

    @JsonProperty("enable_auto_case_creation_on_system_failure")
    private Boolean enableAutoCaseCreationOnSystemFailure = false;

    @JsonProperty("enable_auto_download_waf_signatures")
    private Boolean enableAutoDownloadWafSignatures = false;

    @JsonProperty("enable_ip_reputation")
    private Boolean enableIpReputation = false;

    @JsonProperty("enable_waf_signatures_notifications")
    private Boolean enableWafSignaturesNotifications = true;



    /**
     * This is the getter method this will return the attribute value.
     * Enable to subscribe to automated application signature rulesets updates.
     * Field introduced in 20.1.4.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return enableAppsignatureSync
     */
    public Boolean getEnableAppsignatureSync() {
        return enableAppsignatureSync;
    }

    /**
     * This is the setter method to the attribute.
     * Enable to subscribe to automated application signature rulesets updates.
     * Field introduced in 20.1.4.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param enableAppsignatureSync set the enableAppsignatureSync.
     */
    public void setEnableAppsignatureSync(Boolean  enableAppsignatureSync) {
        this.enableAppsignatureSync = enableAppsignatureSync;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enable pro-active support case creation when a service engine failure occurs.
     * Field introduced in 20.1.1.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return enableAutoCaseCreationOnSeFailure
     */
    public Boolean getEnableAutoCaseCreationOnSeFailure() {
        return enableAutoCaseCreationOnSeFailure;
    }

    /**
     * This is the setter method to the attribute.
     * Enable pro-active support case creation when a service engine failure occurs.
     * Field introduced in 20.1.1.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param enableAutoCaseCreationOnSeFailure set the enableAutoCaseCreationOnSeFailure.
     */
    public void setEnableAutoCaseCreationOnSeFailure(Boolean  enableAutoCaseCreationOnSeFailure) {
        this.enableAutoCaseCreationOnSeFailure = enableAutoCaseCreationOnSeFailure;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enable to allow pro-active support case creation when a system failure occurs.
     * Manual download will still be available in the customer portal.
     * Field introduced in 20.1.1.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return enableAutoCaseCreationOnSystemFailure
     */
    public Boolean getEnableAutoCaseCreationOnSystemFailure() {
        return enableAutoCaseCreationOnSystemFailure;
    }

    /**
     * This is the setter method to the attribute.
     * Enable to allow pro-active support case creation when a system failure occurs.
     * Manual download will still be available in the customer portal.
     * Field introduced in 20.1.1.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param enableAutoCaseCreationOnSystemFailure set the enableAutoCaseCreationOnSystemFailure.
     */
    public void setEnableAutoCaseCreationOnSystemFailure(Boolean  enableAutoCaseCreationOnSystemFailure) {
        this.enableAutoCaseCreationOnSystemFailure = enableAutoCaseCreationOnSystemFailure;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enable to automatically download new crs version to the controller.
     * Field introduced in 20.1.1.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return enableAutoDownloadWafSignatures
     */
    public Boolean getEnableAutoDownloadWafSignatures() {
        return enableAutoDownloadWafSignatures;
    }

    /**
     * This is the setter method to the attribute.
     * Enable to automatically download new crs version to the controller.
     * Field introduced in 20.1.1.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param enableAutoDownloadWafSignatures set the enableAutoDownloadWafSignatures.
     */
    public void setEnableAutoDownloadWafSignatures(Boolean  enableAutoDownloadWafSignatures) {
        this.enableAutoDownloadWafSignatures = enableAutoDownloadWafSignatures;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enable to subscribe to ip reputation updates.
     * This is a requirement for using ip reputation in the product.
     * Field introduced in 20.1.1.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return enableIpReputation
     */
    public Boolean getEnableIpReputation() {
        return enableIpReputation;
    }

    /**
     * This is the setter method to the attribute.
     * Enable to subscribe to ip reputation updates.
     * This is a requirement for using ip reputation in the product.
     * Field introduced in 20.1.1.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param enableIpReputation set the enableIpReputation.
     */
    public void setEnableIpReputation(Boolean  enableIpReputation) {
        this.enableIpReputation = enableIpReputation;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enable event notifications when new crs versions are available.
     * Field introduced in 20.1.1.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Special default for basic edition is false, essentials edition is false, enterprise is true.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @return enableWafSignaturesNotifications
     */
    public Boolean getEnableWafSignaturesNotifications() {
        return enableWafSignaturesNotifications;
    }

    /**
     * This is the setter method to the attribute.
     * Enable event notifications when new crs versions are available.
     * Field introduced in 20.1.1.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Special default for basic edition is false, essentials edition is false, enterprise is true.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @param enableWafSignaturesNotifications set the enableWafSignaturesNotifications.
     */
    public void setEnableWafSignaturesNotifications(Boolean  enableWafSignaturesNotifications) {
        this.enableWafSignaturesNotifications = enableWafSignaturesNotifications;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      PortalFeatureOptIn objPortalFeatureOptIn = (PortalFeatureOptIn) o;
      return   Objects.equals(this.enableAutoDownloadWafSignatures, objPortalFeatureOptIn.enableAutoDownloadWafSignatures)&&
  Objects.equals(this.enableWafSignaturesNotifications, objPortalFeatureOptIn.enableWafSignaturesNotifications)&&
  Objects.equals(this.enableAutoCaseCreationOnSystemFailure, objPortalFeatureOptIn.enableAutoCaseCreationOnSystemFailure)&&
  Objects.equals(this.enableAutoCaseCreationOnSeFailure, objPortalFeatureOptIn.enableAutoCaseCreationOnSeFailure)&&
  Objects.equals(this.enableIpReputation, objPortalFeatureOptIn.enableIpReputation)&&
  Objects.equals(this.enableAppsignatureSync, objPortalFeatureOptIn.enableAppsignatureSync);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PortalFeatureOptIn {\n");
                  sb.append("    enableAppsignatureSync: ").append(toIndentedString(enableAppsignatureSync)).append("\n");
                        sb.append("    enableAutoCaseCreationOnSeFailure: ").append(toIndentedString(enableAutoCaseCreationOnSeFailure)).append("\n");
                        sb.append("    enableAutoCaseCreationOnSystemFailure: ").append(toIndentedString(enableAutoCaseCreationOnSystemFailure)).append("\n");
                        sb.append("    enableAutoDownloadWafSignatures: ").append(toIndentedString(enableAutoDownloadWafSignatures)).append("\n");
                        sb.append("    enableIpReputation: ").append(toIndentedString(enableIpReputation)).append("\n");
                        sb.append("    enableWafSignaturesNotifications: ").append(toIndentedString(enableWafSignaturesNotifications)).append("\n");
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
