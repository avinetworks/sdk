package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AzureClusterInfo is a POJO class extends AviRestResource that used for creating
 * AzureClusterInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AzureClusterInfo  {
    @JsonProperty("cloud_credential_ref")
    private String cloudCredentialRef = null;

    @JsonProperty("subscription_id")
    private String subscriptionId = null;



  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type cloudconnectoruser.
   * Field introduced in 17.2.5.
   * @return cloudCredentialRef
   */
  public String getCloudCredentialRef() {
    return cloudCredentialRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type cloudconnectoruser.
   * Field introduced in 17.2.5.
   * @param cloudCredentialRef set the cloudCredentialRef.
   */
  public void setCloudCredentialRef(String  cloudCredentialRef) {
    this.cloudCredentialRef = cloudCredentialRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.5.
   * @return subscriptionId
   */
  public String getSubscriptionId() {
    return subscriptionId;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.5.
   * @param subscriptionId set the subscriptionId.
   */
  public void setSubscriptionId(String  subscriptionId) {
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
  AzureClusterInfo objAzureClusterInfo = (AzureClusterInfo) o;
  return   Objects.equals(this.subscriptionId, objAzureClusterInfo.subscriptionId)&&
  Objects.equals(this.cloudCredentialRef, objAzureClusterInfo.cloudCredentialRef);
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

