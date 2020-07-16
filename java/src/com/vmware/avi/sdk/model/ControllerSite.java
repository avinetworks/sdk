package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ControllerSite is a POJO class extends AviRestResource that used for creating
 * ControllerSite.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerSite extends AviRestResource  {
    @JsonProperty("address")
    private String address = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("port")
    private Integer port = 443;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Ip address or a dns resolvable, fully qualified domain name of the site controller cluster.
   * Field introduced in 18.2.5.
   * @return address
   */
  public String getAddress() {
    return address;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address or a dns resolvable, fully qualified domain name of the site controller cluster.
   * Field introduced in 18.2.5.
   * @param address set the address.
   */
  public void setAddress(String  address) {
    this.address = address;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name for the site controller cluster.
   * Field introduced in 18.2.5.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name for the site controller cluster.
   * Field introduced in 18.2.5.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The controller site cluster's rest api port number.
   * Allowed values are 1-65535.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 443.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * The controller site cluster's rest api port number.
   * Allowed values are 1-65535.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 443.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Reference for the tenant.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.5.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * Reference for the tenant.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.5.
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
   * Reference for the site controller cluster.
   * Field introduced in 18.2.5.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Reference for the site controller cluster.
   * Field introduced in 18.2.5.
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
  ControllerSite objControllerSite = (ControllerSite) o;
  return   Objects.equals(this.uuid, objControllerSite.uuid)&&
  Objects.equals(this.port, objControllerSite.port)&&
  Objects.equals(this.address, objControllerSite.address)&&
  Objects.equals(this.tenantRef, objControllerSite.tenantRef)&&
  Objects.equals(this.name, objControllerSite.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ControllerSite {\n");
      sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
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

