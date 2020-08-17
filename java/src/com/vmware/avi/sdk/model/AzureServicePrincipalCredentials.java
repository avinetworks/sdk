package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AzureServicePrincipalCredentials is a POJO class extends AviRestResource that used for creating
 * AzureServicePrincipalCredentials.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AzureServicePrincipalCredentials  {
    @JsonProperty("application_id")
    private String applicationId = null;

    @JsonProperty("authentication_token")
    private String authenticationToken = null;

    @JsonProperty("tenant_id")
    private String tenantId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Application id created for avi controller.
   * Required for application id based authentication only.
   * Field introduced in 17.2.1.
   * @return applicationId
   */
  public String getApplicationId() {
    return applicationId;
  }

  /**
   * This is the setter method to the attribute.
   * Application id created for avi controller.
   * Required for application id based authentication only.
   * Field introduced in 17.2.1.
   * @param applicationId set the applicationId.
   */
  public void setApplicationId(String  applicationId) {
    this.applicationId = applicationId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Authentication token created for the avi controller application.
   * Required for application id based authentication only.
   * Field introduced in 17.2.1.
   * @return authenticationToken
   */
  public String getAuthenticationToken() {
    return authenticationToken;
  }

  /**
   * This is the setter method to the attribute.
   * Authentication token created for the avi controller application.
   * Required for application id based authentication only.
   * Field introduced in 17.2.1.
   * @param authenticationToken set the authenticationToken.
   */
  public void setAuthenticationToken(String  authenticationToken) {
    this.authenticationToken = authenticationToken;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant id for the subscription.
   * Required for application id based authentication only.
   * Field introduced in 17.2.1.
   * @return tenantId
   */
  public String getTenantId() {
    return tenantId;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant id for the subscription.
   * Required for application id based authentication only.
   * Field introduced in 17.2.1.
   * @param tenantId set the tenantId.
   */
  public void setTenantId(String  tenantId) {
    this.tenantId = tenantId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AzureServicePrincipalCredentials objAzureServicePrincipalCredentials = (AzureServicePrincipalCredentials) o;
  return   Objects.equals(this.applicationId, objAzureServicePrincipalCredentials.applicationId)&&
  Objects.equals(this.authenticationToken, objAzureServicePrincipalCredentials.authenticationToken)&&
  Objects.equals(this.tenantId, objAzureServicePrincipalCredentials.tenantId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AzureServicePrincipalCredentials {\n");
      sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
        sb.append("    authenticationToken: ").append(toIndentedString(authenticationToken)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
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

