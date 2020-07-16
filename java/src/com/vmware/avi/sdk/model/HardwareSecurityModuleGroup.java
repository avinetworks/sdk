package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HardwareSecurityModuleGroup is a POJO class extends AviRestResource that used for creating
 * HardwareSecurityModuleGroup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HardwareSecurityModuleGroup extends AviRestResource  {
    @JsonProperty("hsm")
    private HardwareSecurityModule hsm = null;

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
   * Hardware security module configuration.
   * @return hsm
   */
  public HardwareSecurityModule getHsm() {
    return hsm;
  }

  /**
   * This is the setter method to the attribute.
   * Hardware security module configuration.
   * @param hsm set the hsm.
   */
  public void setHsm(HardwareSecurityModule hsm) {
    this.hsm = hsm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the hsm group configuration object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the hsm group configuration object.
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
   * Uuid of the hsm group configuration object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the hsm group configuration object.
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
  HardwareSecurityModuleGroup objHardwareSecurityModuleGroup = (HardwareSecurityModuleGroup) o;
  return   Objects.equals(this.hsm, objHardwareSecurityModuleGroup.hsm)&&
  Objects.equals(this.tenantRef, objHardwareSecurityModuleGroup.tenantRef)&&
  Objects.equals(this.uuid, objHardwareSecurityModuleGroup.uuid)&&
  Objects.equals(this.name, objHardwareSecurityModuleGroup.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HardwareSecurityModuleGroup {\n");
      sb.append("    hsm: ").append(toIndentedString(hsm)).append("\n");
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

