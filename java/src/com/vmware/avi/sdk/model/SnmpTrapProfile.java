package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SnmpTrapProfile is a POJO class extends AviRestResource that used for creating
 * SnmpTrapProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SnmpTrapProfile extends AviRestResource  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("trap_servers")
    private List<SnmpTrapServer> trapServers = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * A user-friendly name of the snmp trap configuration.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * A user-friendly name of the snmp trap configuration.
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
   * The ip address or hostname of the snmp trap destination server.
   * @return trapServers
   */
  public List<SnmpTrapServer> getTrapServers() {
    return trapServers;
  }

  /**
   * This is the setter method. this will set the trapServers
   * The ip address or hostname of the snmp trap destination server.
   * @return trapServers
   */
  public void setTrapServers(List<SnmpTrapServer>  trapServers) {
    this.trapServers = trapServers;
  }

  /**
   * This is the setter method this will set the trapServers
   * The ip address or hostname of the snmp trap destination server.
   * @return trapServers
   */
  public SnmpTrapProfile addTrapServersItem(SnmpTrapServer trapServersItem) {
    if (this.trapServers == null) {
      this.trapServers = new ArrayList<SnmpTrapServer>();
    }
    this.trapServers.add(trapServersItem);
    return this;
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
   * Uuid of the snmp trap profile object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the snmp trap profile object.
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
  SnmpTrapProfile objSnmpTrapProfile = (SnmpTrapProfile) o;
  return   Objects.equals(this.uuid, objSnmpTrapProfile.uuid)&&
  Objects.equals(this.name, objSnmpTrapProfile.name)&&
  Objects.equals(this.trapServers, objSnmpTrapProfile.trapServers)&&
  Objects.equals(this.tenantRef, objSnmpTrapProfile.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SnmpTrapProfile {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    trapServers: ").append(toIndentedString(trapServers)).append("\n");
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

