package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AlertEmailConfig is a POJO class extends AviRestResource that used for creating
 * AlertEmailConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertEmailConfig extends AviRestResource  {
    @JsonProperty("cc_emails")
    private String ccEmails = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("to_emails")
    private String toEmails = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Alerts are copied to the comma separated list of  email recipients.
   * @return ccEmails
   */
  public String getCcEmails() {
    return ccEmails;
  }

  /**
   * This is the setter method to the attribute.
   * Alerts are copied to the comma separated list of  email recipients.
   * @param ccEmails set the ccEmails.
   */
  public void setCcEmails(String  ccEmails) {
    this.ccEmails = ccEmails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User defined description for the object.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * User defined description for the object.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A user-friendly name of the email notification service.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * A user-friendly name of the email notification service.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Alerts are sent to the comma separated list of  email recipients.
   * @return toEmails
   */
  public String getToEmails() {
    return toEmails;
  }

  /**
   * This is the setter method to the attribute.
   * Alerts are sent to the comma separated list of  email recipients.
   * @param toEmails set the toEmails.
   */
  public void setToEmails(String  toEmails) {
    this.toEmails = toEmails;
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


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AlertEmailConfig objAlertEmailConfig = (AlertEmailConfig) o;
  return   Objects.equals(this.uuid, objAlertEmailConfig.uuid)&&
  Objects.equals(this.name, objAlertEmailConfig.name)&&
  Objects.equals(this.toEmails, objAlertEmailConfig.toEmails)&&
  Objects.equals(this.ccEmails, objAlertEmailConfig.ccEmails)&&
  Objects.equals(this.description, objAlertEmailConfig.description)&&
  Objects.equals(this.tenantRef, objAlertEmailConfig.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AlertEmailConfig {\n");
      sb.append("    ccEmails: ").append(toIndentedString(ccEmails)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    toEmails: ").append(toIndentedString(toEmails)).append("\n");
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

