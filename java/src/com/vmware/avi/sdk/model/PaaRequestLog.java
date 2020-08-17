package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PaaRequestLog is a POJO class extends AviRestResource that used for creating
 * PaaRequestLog.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaaRequestLog  {
    @JsonProperty("headers_received_from_server")
    private String headersReceivedFromServer = null;

    @JsonProperty("headers_sent_to_server")
    private String headersSentToServer = null;

    @JsonProperty("http_version")
    private String httpVersion = null;

    @JsonProperty("method")
    private String method = null;

    @JsonProperty("pool_name")
    private String poolName = null;

    @JsonProperty("response_code")
    private Integer responseCode = null;

    @JsonProperty("server_ip")
    private Integer serverIp = null;

    @JsonProperty("servers_tried")
    private Integer serversTried = 0;

    @JsonProperty("uri_path")
    private String uriPath = null;



  /**
   * This is the getter method this will return the attribute value.
   * Response headers received from pingaccess server.
   * Field introduced in 18.2.3.
   * @return headersReceivedFromServer
   */
  public String getHeadersReceivedFromServer() {
    return headersReceivedFromServer;
  }

  /**
   * This is the setter method to the attribute.
   * Response headers received from pingaccess server.
   * Field introduced in 18.2.3.
   * @param headersReceivedFromServer set the headersReceivedFromServer.
   */
  public void setHeadersReceivedFromServer(String  headersReceivedFromServer) {
    this.headersReceivedFromServer = headersReceivedFromServer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Request headers sent to pingaccess server.
   * Field introduced in 18.2.3.
   * @return headersSentToServer
   */
  public String getHeadersSentToServer() {
    return headersSentToServer;
  }

  /**
   * This is the setter method to the attribute.
   * Request headers sent to pingaccess server.
   * Field introduced in 18.2.3.
   * @param headersSentToServer set the headersSentToServer.
   */
  public void setHeadersSentToServer(String  headersSentToServer) {
    this.headersSentToServer = headersSentToServer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The http version of the request.
   * Field introduced in 18.2.3.
   * @return httpVersion
   */
  public String getHttpVersion() {
    return httpVersion;
  }

  /**
   * This is the setter method to the attribute.
   * The http version of the request.
   * Field introduced in 18.2.3.
   * @param httpVersion set the httpVersion.
   */
  public void setHttpVersion(String  httpVersion) {
    this.httpVersion = httpVersion;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The http method of the request.
   * Field introduced in 18.2.3.
   * @return method
   */
  public String getMethod() {
    return method;
  }

  /**
   * This is the setter method to the attribute.
   * The http method of the request.
   * Field introduced in 18.2.3.
   * @param method set the method.
   */
  public void setMethod(String  method) {
    this.method = method;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The name of the pool that was used for the request.
   * Field introduced in 18.2.3.
   * @return poolName
   */
  public String getPoolName() {
    return poolName;
  }

  /**
   * This is the setter method to the attribute.
   * The name of the pool that was used for the request.
   * Field introduced in 18.2.3.
   * @param poolName set the poolName.
   */
  public void setPoolName(String  poolName) {
    this.poolName = poolName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The response code received from the pingaccess server.
   * Field introduced in 18.2.3.
   * @return responseCode
   */
  public Integer getResponseCode() {
    return responseCode;
  }

  /**
   * This is the setter method to the attribute.
   * The response code received from the pingaccess server.
   * Field introduced in 18.2.3.
   * @param responseCode set the responseCode.
   */
  public void setResponseCode(Integer  responseCode) {
    this.responseCode = responseCode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The ip of the server that was sent the request.
   * Field introduced in 18.2.3.
   * @return serverIp
   */
  public Integer getServerIp() {
    return serverIp;
  }

  /**
   * This is the setter method to the attribute.
   * The ip of the server that was sent the request.
   * Field introduced in 18.2.3.
   * @param serverIp set the serverIp.
   */
  public void setServerIp(Integer  serverIp) {
    this.serverIp = serverIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of servers tried during server reselect before the response is sent back.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return serversTried
   */
  public Integer getServersTried() {
    return serversTried;
  }

  /**
   * This is the setter method to the attribute.
   * Number of servers tried during server reselect before the response is sent back.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param serversTried set the serversTried.
   */
  public void setServersTried(Integer  serversTried) {
    this.serversTried = serversTried;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The uri of the request.
   * Field introduced in 18.2.3.
   * @return uriPath
   */
  public String getUriPath() {
    return uriPath;
  }

  /**
   * This is the setter method to the attribute.
   * The uri of the request.
   * Field introduced in 18.2.3.
   * @param uriPath set the uriPath.
   */
  public void setUriPath(String  uriPath) {
    this.uriPath = uriPath;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  PaaRequestLog objPaaRequestLog = (PaaRequestLog) o;
  return   Objects.equals(this.responseCode, objPaaRequestLog.responseCode)&&
  Objects.equals(this.httpVersion, objPaaRequestLog.httpVersion)&&
  Objects.equals(this.method, objPaaRequestLog.method)&&
  Objects.equals(this.uriPath, objPaaRequestLog.uriPath)&&
  Objects.equals(this.poolName, objPaaRequestLog.poolName)&&
  Objects.equals(this.serverIp, objPaaRequestLog.serverIp)&&
  Objects.equals(this.headersSentToServer, objPaaRequestLog.headersSentToServer)&&
  Objects.equals(this.headersReceivedFromServer, objPaaRequestLog.headersReceivedFromServer)&&
  Objects.equals(this.serversTried, objPaaRequestLog.serversTried);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PaaRequestLog {\n");
      sb.append("    headersReceivedFromServer: ").append(toIndentedString(headersReceivedFromServer)).append("\n");
        sb.append("    headersSentToServer: ").append(toIndentedString(headersSentToServer)).append("\n");
        sb.append("    httpVersion: ").append(toIndentedString(httpVersion)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    poolName: ").append(toIndentedString(poolName)).append("\n");
        sb.append("    responseCode: ").append(toIndentedString(responseCode)).append("\n");
        sb.append("    serverIp: ").append(toIndentedString(serverIp)).append("\n");
        sb.append("    serversTried: ").append(toIndentedString(serversTried)).append("\n");
        sb.append("    uriPath: ").append(toIndentedString(uriPath)).append("\n");
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

