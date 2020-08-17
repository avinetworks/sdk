package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Webhook is a POJO class extends AviRestResource that used for creating
 * Webhook.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Webhook extends AviRestResource  {
    @JsonProperty("callback_url")
    private String callbackUrl = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("verification_token")
    private String verificationToken = null;



  /**
   * This is the getter method this will return the attribute value.
   * Callback url for the webhook.
   * Field introduced in 17.1.1.
   * @return callbackUrl
   */
  public String getCallbackUrl() {
    return callbackUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Callback url for the webhook.
   * Field introduced in 17.1.1.
   * @param callbackUrl set the callbackUrl.
   */
  public void setCallbackUrl(String  callbackUrl) {
    this.callbackUrl = callbackUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The name of the webhook profile.
   * Field introduced in 17.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * The name of the webhook profile.
   * Field introduced in 17.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.1.1.
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
   * Uuid of the webhook profile.
   * Field introduced in 17.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the webhook profile.
   * Field introduced in 17.1.1.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Verification token sent back with the callback asquery parameters.
   * Field introduced in 17.1.1.
   * @return verificationToken
   */
  public String getVerificationToken() {
    return verificationToken;
  }

  /**
   * This is the setter method to the attribute.
   * Verification token sent back with the callback asquery parameters.
   * Field introduced in 17.1.1.
   * @param verificationToken set the verificationToken.
   */
  public void setVerificationToken(String  verificationToken) {
    this.verificationToken = verificationToken;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Webhook objWebhook = (Webhook) o;
  return   Objects.equals(this.uuid, objWebhook.uuid)&&
  Objects.equals(this.name, objWebhook.name)&&
  Objects.equals(this.callbackUrl, objWebhook.callbackUrl)&&
  Objects.equals(this.verificationToken, objWebhook.verificationToken)&&
  Objects.equals(this.description, objWebhook.description)&&
  Objects.equals(this.tenantRef, objWebhook.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Webhook {\n");
      sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    verificationToken: ").append(toIndentedString(verificationToken)).append("\n");
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

