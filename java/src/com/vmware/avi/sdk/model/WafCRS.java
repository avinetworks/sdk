package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafCRS is a POJO class extends AviRestResource that used for creating
 * WafCRS.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafCRS extends AviRestResource  {
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
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("version")
    private String version = null;



  /**
   * This is the getter method this will return the attribute value.
   * A short description of this ruleset.
   * Field introduced in 18.1.1.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * A short description of this ruleset.
   * Field introduced in 18.1.1.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Waf rules are sorted in groups based on their characterization.
   * Field introduced in 18.1.1.
   * @return groups
   */
  public List<WafRuleGroup> getGroups() {
    return groups;
  }

  /**
   * This is the setter method. this will set the groups
   * Waf rules are sorted in groups based on their characterization.
   * Field introduced in 18.1.1.
   * @return groups
   */
  public void setGroups(List<WafRuleGroup>  groups) {
    this.groups = groups;
  }

  /**
   * This is the setter method this will set the groups
   * Waf rules are sorted in groups based on their characterization.
   * Field introduced in 18.1.1.
   * @return groups
   */
  public WafCRS addGroupsItem(WafRuleGroup groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<WafRuleGroup>();
    }
    this.groups.add(groupsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Integrity protection value.
   * Field introduced in 18.2.1.
   * @return integrity
   */
  public String getIntegrity() {
    return integrity;
  }

  /**
   * This is the setter method to the attribute.
   * Integrity protection value.
   * Field introduced in 18.2.1.
   * @param integrity set the integrity.
   */
  public void setIntegrity(String  integrity) {
    this.integrity = integrity;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The name of this ruleset object.
   * Field introduced in 18.2.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * The name of this ruleset object.
   * Field introduced in 18.2.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The release date of this version in rfc 3339 / iso 8601 format.
   * Field introduced in 18.1.1.
   * @return releaseDate
   */
  public String getReleaseDate() {
    return releaseDate;
  }

  /**
   * This is the setter method to the attribute.
   * The release date of this version in rfc 3339 / iso 8601 format.
   * Field introduced in 18.1.1.
   * @param releaseDate set the releaseDate.
   */
  public void setReleaseDate(String  releaseDate) {
    this.releaseDate = releaseDate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.1.
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
   * Field introduced in 18.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.1.1.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The version of this ruleset object.
   * Field introduced in 18.1.1.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * The version of this ruleset object.
   * Field introduced in 18.1.1.
   * @param version set the version.
   */
  public void setVersion(String  version) {
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
  WafCRS objWafCRS = (WafCRS) o;
  return   Objects.equals(this.uuid, objWafCRS.uuid)&&
  Objects.equals(this.version, objWafCRS.version)&&
  Objects.equals(this.releaseDate, objWafCRS.releaseDate)&&
  Objects.equals(this.description, objWafCRS.description)&&
  Objects.equals(this.groups, objWafCRS.groups)&&
  Objects.equals(this.name, objWafCRS.name)&&
  Objects.equals(this.tenantRef, objWafCRS.tenantRef)&&
  Objects.equals(this.integrity, objWafCRS.integrity);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafCRS {\n");
      sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
        sb.append("    integrity: ").append(toIndentedString(integrity)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
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

