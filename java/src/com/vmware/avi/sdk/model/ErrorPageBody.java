package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ErrorPageBody is a POJO class extends AviRestResource that used for creating
 * ErrorPageBody.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorPageBody extends AviRestResource  {
    @JsonProperty("error_page_body")
    private String errorPageBody = null;

    @JsonProperty("format")
    private String format = "ERROR_PAGE_FORMAT_HTML";

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Error page body sent to client when match.
   * Field introduced in 17.2.4.
   * @return errorPageBody
   */
  public String getErrorPageBody() {
    return errorPageBody;
  }

  /**
   * This is the setter method to the attribute.
   * Error page body sent to client when match.
   * Field introduced in 17.2.4.
   * @param errorPageBody set the errorPageBody.
   */
  public void setErrorPageBody(String  errorPageBody) {
    this.errorPageBody = errorPageBody;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Format of an error page body html or json.
   * Enum options - ERROR_PAGE_FORMAT_HTML, ERROR_PAGE_FORMAT_JSON.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as ERROR_PAGE_FORMAT_HTML.
   * @return format
   */
  public String getFormat() {
    return format;
  }

  /**
   * This is the setter method to the attribute.
   * Format of an error page body html or json.
   * Enum options - ERROR_PAGE_FORMAT_HTML, ERROR_PAGE_FORMAT_JSON.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as ERROR_PAGE_FORMAT_HTML.
   * @param format set the format.
   */
  public void setFormat(String  format) {
    this.format = format;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.4.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.4.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.2.4.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.2.4.
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
   * Field introduced in 17.2.4.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.4.
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
  ErrorPageBody objErrorPageBody = (ErrorPageBody) o;
  return   Objects.equals(this.uuid, objErrorPageBody.uuid)&&
  Objects.equals(this.name, objErrorPageBody.name)&&
  Objects.equals(this.tenantRef, objErrorPageBody.tenantRef)&&
  Objects.equals(this.errorPageBody, objErrorPageBody.errorPageBody)&&
  Objects.equals(this.format, objErrorPageBody.format);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ErrorPageBody {\n");
      sb.append("    errorPageBody: ").append(toIndentedString(errorPageBody)).append("\n");
        sb.append("    format: ").append(toIndentedString(format)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

