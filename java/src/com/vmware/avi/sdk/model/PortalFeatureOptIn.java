package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
   * Flag to check if the user has opted in for proactive case creation on service engine failure.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableAutoCaseCreationOnSeFailure
   */
  public Boolean getEnableAutoCaseCreationOnSeFailure() {
    return enableAutoCaseCreationOnSeFailure;
  }

  /**
   * This is the setter method to the attribute.
   * Flag to check if the user has opted in for proactive case creation on service engine failure.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableAutoCaseCreationOnSeFailure set the enableAutoCaseCreationOnSeFailure.
   */
  public void setEnableAutoCaseCreationOnSeFailure(Boolean  enableAutoCaseCreationOnSeFailure) {
    this.enableAutoCaseCreationOnSeFailure = enableAutoCaseCreationOnSeFailure;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag to check if the user has opted in for proactive case creation on system failure.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableAutoCaseCreationOnSystemFailure
   */
  public Boolean getEnableAutoCaseCreationOnSystemFailure() {
    return enableAutoCaseCreationOnSystemFailure;
  }

  /**
   * This is the setter method to the attribute.
   * Flag to check if the user has opted in for proactive case creation on system failure.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableAutoCaseCreationOnSystemFailure set the enableAutoCaseCreationOnSystemFailure.
   */
  public void setEnableAutoCaseCreationOnSystemFailure(Boolean  enableAutoCaseCreationOnSystemFailure) {
    this.enableAutoCaseCreationOnSystemFailure = enableAutoCaseCreationOnSystemFailure;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag to check if the user has opted in for auto deployment of crs data on controller.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableAutoDownloadWafSignatures
   */
  public Boolean getEnableAutoDownloadWafSignatures() {
    return enableAutoDownloadWafSignatures;
  }

  /**
   * This is the setter method to the attribute.
   * Flag to check if the user has opted in for auto deployment of crs data on controller.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableAutoDownloadWafSignatures set the enableAutoDownloadWafSignatures.
   */
  public void setEnableAutoDownloadWafSignatures(Boolean  enableAutoDownloadWafSignatures) {
    this.enableAutoDownloadWafSignatures = enableAutoDownloadWafSignatures;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag to check if the user has opted in for automated ip reputation db sync.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableIpReputation
   */
  public Boolean getEnableIpReputation() {
    return enableIpReputation;
  }

  /**
   * This is the setter method to the attribute.
   * Flag to check if the user has opted in for automated ip reputation db sync.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableIpReputation set the enableIpReputation.
   */
  public void setEnableIpReputation(Boolean  enableIpReputation) {
    this.enableIpReputation = enableIpReputation;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag to check if the user has opted in for notifications about the availability of new crs data.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableWafSignaturesNotifications
   */
  public Boolean getEnableWafSignaturesNotifications() {
    return enableWafSignaturesNotifications;
  }

  /**
   * This is the setter method to the attribute.
   * Flag to check if the user has opted in for notifications about the availability of new crs data.
   * Field introduced in 20.1.1.
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
  Objects.equals(this.enableAutoCaseCreationOnSeFailure, objPortalFeatureOptIn.enableAutoCaseCreationOnSeFailure)&&
  Objects.equals(this.enableAutoCaseCreationOnSystemFailure, objPortalFeatureOptIn.enableAutoCaseCreationOnSystemFailure)&&
  Objects.equals(this.enableIpReputation, objPortalFeatureOptIn.enableIpReputation);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PortalFeatureOptIn {\n");
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

