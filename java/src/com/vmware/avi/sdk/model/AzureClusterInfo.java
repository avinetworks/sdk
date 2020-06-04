/*
 * Avi avi_global_spec Object API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 20.1.1
 * Contact: support@avinetworks.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.vmware.avi.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * AzureClusterInfo
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-12T12:27:26.755+05:30[Asia/Kolkata]")
public class AzureClusterInfo {
  @JsonProperty("cloud_credential_ref")
  private String cloudCredentialRef = null;

  @JsonProperty("subscription_id")
  private String subscriptionId = null;

  public AzureClusterInfo cloudCredentialRef(String cloudCredentialRef) {
    this.cloudCredentialRef = cloudCredentialRef;
    return this;
  }

   /**
   *  It is a reference to an object of type CloudConnectorUser. Field introduced in 17.2.5.
   * @return cloudCredentialRef
  **/
  @Schema(required = true, description = " It is a reference to an object of type CloudConnectorUser. Field introduced in 17.2.5.")
  public String getCloudCredentialRef() {
    return cloudCredentialRef;
  }

  public void setCloudCredentialRef(String cloudCredentialRef) {
    this.cloudCredentialRef = cloudCredentialRef;
  }

  public AzureClusterInfo subscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

   /**
   *  Field introduced in 17.2.5.
   * @return subscriptionId
  **/
  @Schema(required = true, description = " Field introduced in 17.2.5.")
  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AzureClusterInfo azureClusterInfo = (AzureClusterInfo) o;
    return Objects.equals(this.cloudCredentialRef, azureClusterInfo.cloudCredentialRef) &&
        Objects.equals(this.subscriptionId, azureClusterInfo.subscriptionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloudCredentialRef, subscriptionId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AzureClusterInfo {\n");
    
    sb.append("    cloudCredentialRef: ").append(toIndentedString(cloudCredentialRef)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
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