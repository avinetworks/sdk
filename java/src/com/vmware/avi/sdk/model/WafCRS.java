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
import com.vmware.avi.sdk.model.WafRuleGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * WafCRS
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-12T12:27:26.755+05:30[Asia/Kolkata]")
public class WafCRS {
  @JsonProperty("_last_modified")
  private String _lastModified = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("groups")
  private List<WafRuleGroup> groups = null;

  @JsonProperty("integrity")
  private String integrity = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("release_date")
  private String releaseDate = null;

  @JsonProperty("tenant_ref")
  private String tenantRef = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("uuid")
  private String uuid = null;

  @JsonProperty("version")
  private String version = null;

   /**
   * UNIX time since epoch in microseconds. Units(MICROSECONDS).
   * @return _lastModified
  **/
  @Schema(description = "UNIX time since epoch in microseconds. Units(MICROSECONDS).")
  public String getLastModified() {
    return _lastModified;
  }

  public WafCRS description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A short description of this ruleset. Field introduced in 18.1.1.
   * @return description
  **/
  @Schema(required = true, description = "A short description of this ruleset. Field introduced in 18.1.1.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public WafCRS groups(List<WafRuleGroup> groups) {
    this.groups = groups;
    return this;
  }

  public WafCRS addGroupsItem(WafRuleGroup groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<WafRuleGroup>();
    }
    this.groups.add(groupsItem);
    return this;
  }

   /**
   * WAF Rules are sorted in groups based on their characterization. Field introduced in 18.1.1.
   * @return groups
  **/
  @Schema(description = "WAF Rules are sorted in groups based on their characterization. Field introduced in 18.1.1.")
  public List<WafRuleGroup> getGroups() {
    return groups;
  }

  public void setGroups(List<WafRuleGroup> groups) {
    this.groups = groups;
  }

  public WafCRS integrity(String integrity) {
    this.integrity = integrity;
    return this;
  }

   /**
   * Integrity protection value. Field introduced in 18.2.1.
   * @return integrity
  **/
  @Schema(required = true, description = "Integrity protection value. Field introduced in 18.2.1.")
  public String getIntegrity() {
    return integrity;
  }

  public void setIntegrity(String integrity) {
    this.integrity = integrity;
  }

  public WafCRS name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of this ruleset object. Field introduced in 18.2.1.
   * @return name
  **/
  @Schema(required = true, description = "The name of this ruleset object. Field introduced in 18.2.1.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WafCRS releaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

   /**
   * The release date of this version in RFC 3339 / ISO 8601 format. Field introduced in 18.1.1.
   * @return releaseDate
  **/
  @Schema(required = true, description = "The release date of this version in RFC 3339 / ISO 8601 format. Field introduced in 18.1.1.")
  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public WafCRS tenantRef(String tenantRef) {
    this.tenantRef = tenantRef;
    return this;
  }

   /**
   * Tenant that this object belongs to. It is a reference to an object of type Tenant. Field introduced in 18.2.1.
   * @return tenantRef
  **/
  @Schema(description = "Tenant that this object belongs to. It is a reference to an object of type Tenant. Field introduced in 18.2.1.")
  public String getTenantRef() {
    return tenantRef;
  }

  public void setTenantRef(String tenantRef) {
    this.tenantRef = tenantRef;
  }

   /**
   * url
   * @return url
  **/
  @Schema(description = "url")
  public String getUrl() {
    return url;
  }

  public WafCRS uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   *  Field introduced in 18.1.1.
   * @return uuid
  **/
  @Schema(description = " Field introduced in 18.1.1.")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public WafCRS version(String version) {
    this.version = version;
    return this;
  }

   /**
   * The version of this ruleset object. Field introduced in 18.1.1.
   * @return version
  **/
  @Schema(required = true, description = "The version of this ruleset object. Field introduced in 18.1.1.")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WafCRS wafCRS = (WafCRS) o;
    return Objects.equals(this._lastModified, wafCRS._lastModified) &&
        Objects.equals(this.description, wafCRS.description) &&
        Objects.equals(this.groups, wafCRS.groups) &&
        Objects.equals(this.integrity, wafCRS.integrity) &&
        Objects.equals(this.name, wafCRS.name) &&
        Objects.equals(this.releaseDate, wafCRS.releaseDate) &&
        Objects.equals(this.tenantRef, wafCRS.tenantRef) &&
        Objects.equals(this.url, wafCRS.url) &&
        Objects.equals(this.uuid, wafCRS.uuid) &&
        Objects.equals(this.version, wafCRS.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_lastModified, description, groups, integrity, name, releaseDate, tenantRef, url, uuid, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WafCRS {\n");
    
    sb.append("    _lastModified: ").append(toIndentedString(_lastModified)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
    sb.append("    integrity: ").append(toIndentedString(integrity)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
    sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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