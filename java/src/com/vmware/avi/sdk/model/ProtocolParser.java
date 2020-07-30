package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ProtocolParser is a POJO class extends AviRestResource that used for creating
 * ProtocolParser.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProtocolParser extends AviRestResource  {
    @JsonProperty("description")
    private String description = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("parser_code")
    private String parserCode = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Description of the protocol parser.
   * Field introduced in 18.2.3.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * Description of the protocol parser.
   * Field introduced in 18.2.3.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the protocol parser.
   * Field introduced in 18.2.3.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the protocol parser.
   * Field introduced in 18.2.3.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Command script provided inline.
   * Field introduced in 18.2.3.
   * @return parserCode
   */
  public String getParserCode() {
    return parserCode;
  }

  /**
   * This is the setter method to the attribute.
   * Command script provided inline.
   * Field introduced in 18.2.3.
   * @param parserCode set the parserCode.
   */
  public void setParserCode(String  parserCode) {
    this.parserCode = parserCode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant uuid of the protocol parser.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.3.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant uuid of the protocol parser.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.3.
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
   * Uuid of the protocol parser.
   * Field introduced in 18.2.3.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the protocol parser.
   * Field introduced in 18.2.3.
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
  ProtocolParser objProtocolParser = (ProtocolParser) o;
  return   Objects.equals(this.uuid, objProtocolParser.uuid)&&
  Objects.equals(this.name, objProtocolParser.name)&&
  Objects.equals(this.parserCode, objProtocolParser.parserCode)&&
  Objects.equals(this.description, objProtocolParser.description)&&
  Objects.equals(this.tenantRef, objProtocolParser.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ProtocolParser {\n");
      sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    parserCode: ").append(toIndentedString(parserCode)).append("\n");
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

