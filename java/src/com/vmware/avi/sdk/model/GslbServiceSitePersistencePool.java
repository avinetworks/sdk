package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbServiceSitePersistencePool is a POJO class extends AviRestResource that used for creating
 * GslbServiceSitePersistencePool.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbServiceSitePersistencePool extends AviRestResource  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("num_servers")
    private Integer numServers = null;

    @JsonProperty("num_servers_up")
    private Integer numServersUp = null;

    @JsonProperty("servers")
    private List<ServerConfig> servers = null;

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Site persistence pool's name.
   * Field introduced in 17.2.2.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Site persistence pool's name.
   * Field introduced in 17.2.2.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of servers configured in the pool.
   * Field introduced in 17.2.2.
   * @return numServers
   */
  public Integer getNumServers() {
    return numServers;
  }

  /**
   * This is the setter method to the attribute.
   * Number of servers configured in the pool.
   * Field introduced in 17.2.2.
   * @param numServers set the numServers.
   */
  public void setNumServers(Integer  numServers) {
    this.numServers = numServers;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of servers operationally up in the pool.
   * Field introduced in 17.2.2.
   * @return numServersUp
   */
  public Integer getNumServersUp() {
    return numServersUp;
  }

  /**
   * This is the setter method to the attribute.
   * Number of servers operationally up in the pool.
   * Field introduced in 17.2.2.
   * @param numServersUp set the numServersUp.
   */
  public void setNumServersUp(Integer  numServersUp) {
    this.numServersUp = numServersUp;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Detailed information of the servers in the pool.
   * Field introduced in 17.2.8.
   * @return servers
   */
  public List<ServerConfig> getServers() {
    return servers;
  }

  /**
   * This is the setter method. this will set the servers
   * Detailed information of the servers in the pool.
   * Field introduced in 17.2.8.
   * @return servers
   */
  public void setServers(List<ServerConfig>  servers) {
    this.servers = servers;
  }

  /**
   * This is the setter method this will set the servers
   * Detailed information of the servers in the pool.
   * Field introduced in 17.2.8.
   * @return servers
   */
  public GslbServiceSitePersistencePool addServersItem(ServerConfig serversItem) {
    if (this.servers == null) {
      this.servers = new ArrayList<ServerConfig>();
    }
    this.servers.add(serversItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Site persistence pool's uuid.
   * Field introduced in 17.2.2.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Site persistence pool's uuid.
   * Field introduced in 17.2.2.
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
  GslbServiceSitePersistencePool objGslbServiceSitePersistencePool = (GslbServiceSitePersistencePool) o;
  return   Objects.equals(this.uuid, objGslbServiceSitePersistencePool.uuid)&&
  Objects.equals(this.name, objGslbServiceSitePersistencePool.name)&&
  Objects.equals(this.numServers, objGslbServiceSitePersistencePool.numServers)&&
  Objects.equals(this.numServersUp, objGslbServiceSitePersistencePool.numServersUp)&&
  Objects.equals(this.servers, objGslbServiceSitePersistencePool.servers);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbServiceSitePersistencePool {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    numServers: ").append(toIndentedString(numServers)).append("\n");
        sb.append("    numServersUp: ").append(toIndentedString(numServersUp)).append("\n");
        sb.append("    servers: ").append(toIndentedString(servers)).append("\n");
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

