package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NetworkProfile is a POJO class extends AviRestResource that used for creating
 * NetworkProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkProfile extends AviRestResource  {
    @JsonProperty("connection_mirror")
    private Boolean connectionMirror = false;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("profile")
    private NetworkProfileUnion profile = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * When enabled, avi mirrors all tcp fastpath connections to standby.
   * Applicable only in legacy ha mode.
   * Field introduced in 18.1.3,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return connectionMirror
   */
  public Boolean getConnectionMirror() {
    return connectionMirror;
  }

  /**
   * This is the setter method to the attribute.
   * When enabled, avi mirrors all tcp fastpath connections to standby.
   * Applicable only in legacy ha mode.
   * Field introduced in 18.1.3,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param connectionMirror set the connectionMirror.
   */
  public void setConnectionMirror(Boolean  connectionMirror) {
    this.connectionMirror = connectionMirror;
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
   * The name of the network profile.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * The name of the network profile.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property profile of obj type networkprofile field type str  type ref.
   * @return profile
   */
  public NetworkProfileUnion getProfile() {
    return profile;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property profile of obj type networkprofile field type str  type ref.
   * @param profile set the profile.
   */
  public void setProfile(NetworkProfileUnion profile) {
    this.profile = profile;
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
   * Uuid of the network profile.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the network profile.
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
  NetworkProfile objNetworkProfile = (NetworkProfile) o;
  return   Objects.equals(this.uuid, objNetworkProfile.uuid)&&
  Objects.equals(this.name, objNetworkProfile.name)&&
  Objects.equals(this.profile, objNetworkProfile.profile)&&
  Objects.equals(this.description, objNetworkProfile.description)&&
  Objects.equals(this.tenantRef, objNetworkProfile.tenantRef)&&
  Objects.equals(this.connectionMirror, objNetworkProfile.connectionMirror);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NetworkProfile {\n");
      sb.append("    connectionMirror: ").append(toIndentedString(connectionMirror)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
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

