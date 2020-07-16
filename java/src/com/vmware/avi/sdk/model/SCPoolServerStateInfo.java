package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SCPoolServerStateInfo is a POJO class extends AviRestResource that used for creating
 * SCPoolServerStateInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SCPoolServerStateInfo extends AviRestResource  {
    @JsonProperty("is_server")
    private Boolean isServer = false;

    @JsonProperty("oper_status")
    private OperationalStatus operStatus = null;

    @JsonProperty("pool_id")
    private String poolId = null;

    @JsonProperty("server_states")
    private List<SCServerStateInfo> serverStates = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isServer
   */
  public Boolean getIsServer() {
    return isServer;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isServer set the isServer.
   */
  public void setIsServer(Boolean  isServer) {
    this.isServer = isServer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return operStatus
   */
  public OperationalStatus getOperStatus() {
    return operStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * @param operStatus set the operStatus.
   */
  public void setOperStatus(OperationalStatus operStatus) {
    this.operStatus = operStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return poolId
   */
  public String getPoolId() {
    return poolId;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * @param poolId set the poolId.
   */
  public void setPoolId(String  poolId) {
    this.poolId = poolId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return serverStates
   */
  public List<SCServerStateInfo> getServerStates() {
    return serverStates;
  }

  /**
   * This is the setter method. this will set the serverStates
   * Field introduced in 17.1.1.
   * @return serverStates
   */
  public void setServerStates(List<SCServerStateInfo>  serverStates) {
    this.serverStates = serverStates;
  }

  /**
   * This is the setter method this will set the serverStates
   * Field introduced in 17.1.1.
   * @return serverStates
   */
  public SCPoolServerStateInfo addServerStatesItem(SCServerStateInfo serverStatesItem) {
    if (this.serverStates == null) {
      this.serverStates = new ArrayList<SCServerStateInfo>();
    }
    this.serverStates.add(serverStatesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.1.1.
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
   * Field introduced in 17.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
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
  SCPoolServerStateInfo objSCPoolServerStateInfo = (SCPoolServerStateInfo) o;
  return   Objects.equals(this.uuid, objSCPoolServerStateInfo.uuid)&&
  Objects.equals(this.poolId, objSCPoolServerStateInfo.poolId)&&
  Objects.equals(this.isServer, objSCPoolServerStateInfo.isServer)&&
  Objects.equals(this.operStatus, objSCPoolServerStateInfo.operStatus)&&
  Objects.equals(this.tenantRef, objSCPoolServerStateInfo.tenantRef)&&
  Objects.equals(this.serverStates, objSCPoolServerStateInfo.serverStates);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SCPoolServerStateInfo {\n");
      sb.append("    isServer: ").append(toIndentedString(isServer)).append("\n");
        sb.append("    operStatus: ").append(toIndentedString(operStatus)).append("\n");
        sb.append("    poolId: ").append(toIndentedString(poolId)).append("\n");
        sb.append("    serverStates: ").append(toIndentedString(serverStates)).append("\n");
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

