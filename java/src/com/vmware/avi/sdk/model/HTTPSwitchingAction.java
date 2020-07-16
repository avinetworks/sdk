package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPSwitchingAction is a POJO class extends AviRestResource that used for creating
 * HTTPSwitchingAction.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPSwitchingAction  {
    @JsonProperty("action")
    private String action = null;

    @JsonProperty("file")
    private HTTPLocalFile file = null;

    @JsonProperty("pool_group_ref")
    private String poolGroupRef = null;

    @JsonProperty("pool_ref")
    private String poolRef = null;

    @JsonProperty("server")
    private PoolServer server = null;

    @JsonProperty("status_code")
    private String statusCode = null;



  /**
   * This is the getter method this will return the attribute value.
   * Content switching action type.
   * Enum options - HTTP_SWITCHING_SELECT_POOL, HTTP_SWITCHING_SELECT_LOCAL, HTTP_SWITCHING_SELECT_POOLGROUP.
   * @return action
   */
  public String getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Content switching action type.
   * Enum options - HTTP_SWITCHING_SELECT_POOL, HTTP_SWITCHING_SELECT_LOCAL, HTTP_SWITCHING_SELECT_POOLGROUP.
   * @param action set the action.
   */
  public void setAction(String  action) {
    this.action = action;
  }

  /**
   * This is the getter method this will return the attribute value.
   * File from which to serve local response to the request.
   * @return file
   */
  public HTTPLocalFile getFile() {
    return file;
  }

  /**
   * This is the setter method to the attribute.
   * File from which to serve local response to the request.
   * @param file set the file.
   */
  public void setFile(HTTPLocalFile file) {
    this.file = file;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the pool group to serve the request.
   * It is a reference to an object of type poolgroup.
   * @return poolGroupRef
   */
  public String getPoolGroupRef() {
    return poolGroupRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the pool group to serve the request.
   * It is a reference to an object of type poolgroup.
   * @param poolGroupRef set the poolGroupRef.
   */
  public void setPoolGroupRef(String  poolGroupRef) {
    this.poolGroupRef = poolGroupRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the pool of servers to serve the request.
   * It is a reference to an object of type pool.
   * @return poolRef
   */
  public String getPoolRef() {
    return poolRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the pool of servers to serve the request.
   * It is a reference to an object of type pool.
   * @param poolRef set the poolRef.
   */
  public void setPoolRef(String  poolRef) {
    this.poolRef = poolRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specific pool server to select.
   * @return server
   */
  public PoolServer getServer() {
    return server;
  }

  /**
   * This is the setter method to the attribute.
   * Specific pool server to select.
   * @param server set the server.
   */
  public void setServer(PoolServer server) {
    this.server = server;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http status code to use when serving local response.
   * Enum options - HTTP_LOCAL_RESPONSE_STATUS_CODE_200, HTTP_LOCAL_RESPONSE_STATUS_CODE_204, HTTP_LOCAL_RESPONSE_STATUS_CODE_403,
   * HTTP_LOCAL_RESPONSE_STATUS_CODE_404, HTTP_LOCAL_RESPONSE_STATUS_CODE_429, HTTP_LOCAL_RESPONSE_STATUS_CODE_501.
   * @return statusCode
   */
  public String getStatusCode() {
    return statusCode;
  }

  /**
   * This is the setter method to the attribute.
   * Http status code to use when serving local response.
   * Enum options - HTTP_LOCAL_RESPONSE_STATUS_CODE_200, HTTP_LOCAL_RESPONSE_STATUS_CODE_204, HTTP_LOCAL_RESPONSE_STATUS_CODE_403,
   * HTTP_LOCAL_RESPONSE_STATUS_CODE_404, HTTP_LOCAL_RESPONSE_STATUS_CODE_429, HTTP_LOCAL_RESPONSE_STATUS_CODE_501.
   * @param statusCode set the statusCode.
   */
  public void setStatusCode(String  statusCode) {
    this.statusCode = statusCode;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTPSwitchingAction objHTTPSwitchingAction = (HTTPSwitchingAction) o;
  return   Objects.equals(this.poolGroupRef, objHTTPSwitchingAction.poolGroupRef)&&
  Objects.equals(this.statusCode, objHTTPSwitchingAction.statusCode)&&
  Objects.equals(this.server, objHTTPSwitchingAction.server)&&
  Objects.equals(this.file, objHTTPSwitchingAction.file)&&
  Objects.equals(this.action, objHTTPSwitchingAction.action)&&
  Objects.equals(this.poolRef, objHTTPSwitchingAction.poolRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPSwitchingAction {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    file: ").append(toIndentedString(file)).append("\n");
        sb.append("    poolGroupRef: ").append(toIndentedString(poolGroupRef)).append("\n");
        sb.append("    poolRef: ").append(toIndentedString(poolRef)).append("\n");
        sb.append("    server: ").append(toIndentedString(server)).append("\n");
        sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
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

