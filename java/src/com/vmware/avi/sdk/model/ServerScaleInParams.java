package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ServerScaleInParams is a POJO class extends AviRestResource that used for creating
 * ServerScaleInParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerScaleInParams extends AviRestResource  {
    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("servers")
    private List<ServerId> servers = null;

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Reason for the manual scalein.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Reason for the manual scalein.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of server ids that should be scaled in.
   * @return servers
   */
  public List<ServerId> getServers() {
    return servers;
  }

  /**
   * This is the setter method. this will set the servers
   * List of server ids that should be scaled in.
   * @return servers
   */
  public void setServers(List<ServerId>  servers) {
    this.servers = servers;
  }

  /**
   * This is the setter method this will set the servers
   * List of server ids that should be scaled in.
   * @return servers
   */
  public ServerScaleInParams addServersItem(ServerId serversItem) {
    if (this.servers == null) {
      this.servers = new ArrayList<ServerId>();
    }
    this.servers.add(serversItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
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
  ServerScaleInParams objServerScaleInParams = (ServerScaleInParams) o;
  return   Objects.equals(this.reason, objServerScaleInParams.reason)&&
  Objects.equals(this.uuid, objServerScaleInParams.uuid)&&
  Objects.equals(this.servers, objServerScaleInParams.servers);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ServerScaleInParams {\n");
      sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

