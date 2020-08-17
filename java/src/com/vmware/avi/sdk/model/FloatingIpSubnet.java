package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The FloatingIpSubnet is a POJO class extends AviRestResource that used for creating
 * FloatingIpSubnet.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FloatingIpSubnet extends AviRestResource  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("prefix")
    private IpAddrPrefix prefix = null;

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Floatingip subnet name if available, else uuid.
   * Field introduced in 17.2.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Floatingip subnet name if available, else uuid.
   * Field introduced in 17.2.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Floatingip subnet prefix.
   * Field introduced in 17.2.1.
   * @return prefix
   */
  public IpAddrPrefix getPrefix() {
    return prefix;
  }

  /**
   * This is the setter method to the attribute.
   * Floatingip subnet prefix.
   * Field introduced in 17.2.1.
   * @param prefix set the prefix.
   */
  public void setPrefix(IpAddrPrefix prefix) {
    this.prefix = prefix;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Floatingip subnet uuid.
   * Field introduced in 17.2.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Floatingip subnet uuid.
   * Field introduced in 17.2.1.
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
  FloatingIpSubnet objFloatingIpSubnet = (FloatingIpSubnet) o;
  return   Objects.equals(this.name, objFloatingIpSubnet.name)&&
  Objects.equals(this.uuid, objFloatingIpSubnet.uuid)&&
  Objects.equals(this.prefix, objFloatingIpSubnet.prefix);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class FloatingIpSubnet {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
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

