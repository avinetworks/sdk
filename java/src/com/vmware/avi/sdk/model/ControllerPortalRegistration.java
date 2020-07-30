package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ControllerPortalRegistration is a POJO class extends AviRestResource that used for creating
 * ControllerPortalRegistration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerPortalRegistration extends AviRestResource  {
    @JsonProperty("asset")
    private ControllerPortalAsset asset = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("portal_auth")
    private ControllerPortalAuth portalAuth = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return asset
   */
  public ControllerPortalAsset getAsset() {
    return asset;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param asset set the asset.
   */
  public void setAsset(ControllerPortalAsset asset) {
    this.asset = asset;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return portalAuth
   */
  public ControllerPortalAuth getPortalAuth() {
    return portalAuth;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param portalAuth set the portalAuth.
   */
  public void setPortalAuth(ControllerPortalAuth portalAuth) {
    this.portalAuth = portalAuth;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.6.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.6.
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
   * Field introduced in 18.2.6.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
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
  ControllerPortalRegistration objControllerPortalRegistration = (ControllerPortalRegistration) o;
  return   Objects.equals(this.uuid, objControllerPortalRegistration.uuid)&&
  Objects.equals(this.name, objControllerPortalRegistration.name)&&
  Objects.equals(this.tenantRef, objControllerPortalRegistration.tenantRef)&&
  Objects.equals(this.portalAuth, objControllerPortalRegistration.portalAuth)&&
  Objects.equals(this.asset, objControllerPortalRegistration.asset);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ControllerPortalRegistration {\n");
      sb.append("    asset: ").append(toIndentedString(asset)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    portalAuth: ").append(toIndentedString(portalAuth)).append("\n");
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

