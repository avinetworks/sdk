package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IcapRequestLog is a POJO class extends AviRestResource that used for creating
 * IcapRequestLog.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IcapRequestLog  {
    @JsonProperty("action")
    private String action = null;

    @JsonProperty("complete_body_sent")
    private Boolean completeBodySent = null;

    @JsonProperty("http_method")
    private String httpMethod = null;

    @JsonProperty("http_response_code")
    private Integer httpResponseCode = null;

    @JsonProperty("icap_absolute_uri")
    private String icapAbsoluteUri = null;

    @JsonProperty("icap_headers_received_from_server")
    private String icapHeadersReceivedFromServer = null;

    @JsonProperty("icap_headers_sent_to_server")
    private String icapHeadersSentToServer = null;

    @JsonProperty("icap_method")
    private String icapMethod = null;

    @JsonProperty("icap_response_code")
    private Integer icapResponseCode = null;

    @JsonProperty("latency")
    private Integer latency = null;

    @JsonProperty("modified_content_length")
    private Integer modifiedContentLength = null;

    @JsonProperty("pool_name")
    private String poolName = null;

    @JsonProperty("pool_uuid")
    private String poolUuid = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("server_ip")
    private IpAddr serverIp = null;

    @JsonProperty("source_port")
    private Integer sourcePort = null;

    @JsonProperty("threat_description")
    private String threatDescription = null;

    @JsonProperty("threat_id")
    private String threatId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Denotes whether the content was processed by icap server and an action was taken.
   * Enum options - ICAP_DISABLED, ICAP_PASSED, ICAP_MODIFIED, ICAP_BLOCKED, ICAP_FAILED.
   * Field introduced in 20.1.1.
   * @return action
   */
  public String getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Denotes whether the content was processed by icap server and an action was taken.
   * Enum options - ICAP_DISABLED, ICAP_PASSED, ICAP_MODIFIED, ICAP_BLOCKED, ICAP_FAILED.
   * Field introduced in 20.1.1.
   * @param action set the action.
   */
  public void setAction(String  action) {
    this.action = action;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Complete request body from client was sent to the icap server.
   * Field introduced in 20.1.1.
   * @return completeBodySent
   */
  public Boolean getCompleteBodySent() {
    return completeBodySent;
  }

  /**
   * This is the setter method to the attribute.
   * Complete request body from client was sent to the icap server.
   * Field introduced in 20.1.1.
   * @param completeBodySent set the completeBodySent.
   */
  public void setCompleteBodySent(Boolean  completeBodySent) {
    this.completeBodySent = completeBodySent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The http method of the request.
   * Enum options - HTTP_METHOD_GET, HTTP_METHOD_HEAD, HTTP_METHOD_PUT, HTTP_METHOD_DELETE, HTTP_METHOD_POST, HTTP_METHOD_OPTIONS, HTTP_METHOD_TRACE,
   * HTTP_METHOD_CONNECT, HTTP_METHOD_PATCH, HTTP_METHOD_PROPFIND, HTTP_METHOD_PROPPATCH, HTTP_METHOD_MKCOL, HTTP_METHOD_COPY, HTTP_METHOD_MOVE,
   * HTTP_METHOD_LOCK, HTTP_METHOD_UNLOCK.
   * Field introduced in 20.1.1.
   * @return httpMethod
   */
  public String getHttpMethod() {
    return httpMethod;
  }

  /**
   * This is the setter method to the attribute.
   * The http method of the request.
   * Enum options - HTTP_METHOD_GET, HTTP_METHOD_HEAD, HTTP_METHOD_PUT, HTTP_METHOD_DELETE, HTTP_METHOD_POST, HTTP_METHOD_OPTIONS, HTTP_METHOD_TRACE,
   * HTTP_METHOD_CONNECT, HTTP_METHOD_PATCH, HTTP_METHOD_PROPFIND, HTTP_METHOD_PROPPATCH, HTTP_METHOD_MKCOL, HTTP_METHOD_COPY, HTTP_METHOD_MOVE,
   * HTTP_METHOD_LOCK, HTTP_METHOD_UNLOCK.
   * Field introduced in 20.1.1.
   * @param httpMethod set the httpMethod.
   */
  public void setHttpMethod(String  httpMethod) {
    this.httpMethod = httpMethod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The http response code received from the icap server.
   * Http response code is only available if content is blocked.
   * Field introduced in 20.1.1.
   * @return httpResponseCode
   */
  public Integer getHttpResponseCode() {
    return httpResponseCode;
  }

  /**
   * This is the setter method to the attribute.
   * The http response code received from the icap server.
   * Http response code is only available if content is blocked.
   * Field introduced in 20.1.1.
   * @param httpResponseCode set the httpResponseCode.
   */
  public void setHttpResponseCode(Integer  httpResponseCode) {
    this.httpResponseCode = httpResponseCode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The absolute icap uri of the request.
   * Field introduced in 20.1.1.
   * @return icapAbsoluteUri
   */
  public String getIcapAbsoluteUri() {
    return icapAbsoluteUri;
  }

  /**
   * This is the setter method to the attribute.
   * The absolute icap uri of the request.
   * Field introduced in 20.1.1.
   * @param icapAbsoluteUri set the icapAbsoluteUri.
   */
  public void setIcapAbsoluteUri(String  icapAbsoluteUri) {
    this.icapAbsoluteUri = icapAbsoluteUri;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Icap response headers received from icap server.
   * Field introduced in 20.1.1.
   * @return icapHeadersReceivedFromServer
   */
  public String getIcapHeadersReceivedFromServer() {
    return icapHeadersReceivedFromServer;
  }

  /**
   * This is the setter method to the attribute.
   * Icap response headers received from icap server.
   * Field introduced in 20.1.1.
   * @param icapHeadersReceivedFromServer set the icapHeadersReceivedFromServer.
   */
  public void setIcapHeadersReceivedFromServer(String  icapHeadersReceivedFromServer) {
    this.icapHeadersReceivedFromServer = icapHeadersReceivedFromServer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Icap request headers sent to icap server.
   * Field introduced in 20.1.1.
   * @return icapHeadersSentToServer
   */
  public String getIcapHeadersSentToServer() {
    return icapHeadersSentToServer;
  }

  /**
   * This is the setter method to the attribute.
   * Icap request headers sent to icap server.
   * Field introduced in 20.1.1.
   * @param icapHeadersSentToServer set the icapHeadersSentToServer.
   */
  public void setIcapHeadersSentToServer(String  icapHeadersSentToServer) {
    this.icapHeadersSentToServer = icapHeadersSentToServer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The icap method of the request.
   * Enum options - ICAP_METHOD_REQMOD, ICAP_METHOD_RESPMOD.
   * Field introduced in 20.1.1.
   * @return icapMethod
   */
  public String getIcapMethod() {
    return icapMethod;
  }

  /**
   * This is the setter method to the attribute.
   * The icap method of the request.
   * Enum options - ICAP_METHOD_REQMOD, ICAP_METHOD_RESPMOD.
   * Field introduced in 20.1.1.
   * @param icapMethod set the icapMethod.
   */
  public void setIcapMethod(String  icapMethod) {
    this.icapMethod = icapMethod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The response code received from the icap server.
   * Field introduced in 20.1.1.
   * @return icapResponseCode
   */
  public Integer getIcapResponseCode() {
    return icapResponseCode;
  }

  /**
   * This is the setter method to the attribute.
   * The response code received from the icap server.
   * Field introduced in 20.1.1.
   * @param icapResponseCode set the icapResponseCode.
   */
  public void setIcapResponseCode(Integer  icapResponseCode) {
    this.icapResponseCode = icapResponseCode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Latency added due to icap processing.
   * This is the time taken from 1st byte of icap request sent to last byte of icap response received.
   * Field introduced in 20.1.1.
   * @return latency
   */
  public Integer getLatency() {
    return latency;
  }

  /**
   * This is the setter method to the attribute.
   * Latency added due to icap processing.
   * This is the time taken from 1st byte of icap request sent to last byte of icap response received.
   * Field introduced in 20.1.1.
   * @param latency set the latency.
   */
  public void setLatency(Integer  latency) {
    this.latency = latency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Content-length of the modified content from icap server.
   * Field introduced in 20.1.1.
   * @return modifiedContentLength
   */
  public Integer getModifiedContentLength() {
    return modifiedContentLength;
  }

  /**
   * This is the setter method to the attribute.
   * Content-length of the modified content from icap server.
   * Field introduced in 20.1.1.
   * @param modifiedContentLength set the modifiedContentLength.
   */
  public void setModifiedContentLength(Integer  modifiedContentLength) {
    this.modifiedContentLength = modifiedContentLength;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The name of the pool that was used for the request.
   * Field introduced in 20.1.1.
   * @return poolName
   */
  public String getPoolName() {
    return poolName;
  }

  /**
   * This is the setter method to the attribute.
   * The name of the pool that was used for the request.
   * Field introduced in 20.1.1.
   * @param poolName set the poolName.
   */
  public void setPoolName(String  poolName) {
    this.poolName = poolName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The uuis of the pool that was used for the request.
   * Field introduced in 20.1.1.
   * @return poolUuid
   */
  public String getPoolUuid() {
    return poolUuid;
  }

  /**
   * This is the setter method to the attribute.
   * The uuis of the pool that was used for the request.
   * Field introduced in 20.1.1.
   * @param poolUuid set the poolUuid.
   */
  public void setPoolUuid(String  poolUuid) {
    this.poolUuid = poolUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Blocking reason for the content.
   * It is available only if content was scanned by icap server and some violations were found.
   * Field introduced in 20.1.1.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Blocking reason for the content.
   * It is available only if content was scanned by icap server and some violations were found.
   * Field introduced in 20.1.1.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Icap server ip for this connection.
   * Field introduced in 20.1.1.
   * @return serverIp
   */
  public IpAddr getServerIp() {
    return serverIp;
  }

  /**
   * This is the setter method to the attribute.
   * Icap server ip for this connection.
   * Field introduced in 20.1.1.
   * @param serverIp set the serverIp.
   */
  public void setServerIp(IpAddr serverIp) {
    this.serverIp = serverIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Source port for this connection.
   * Field introduced in 20.1.1.
   * @return sourcePort
   */
  public Integer getSourcePort() {
    return sourcePort;
  }

  /**
   * This is the setter method to the attribute.
   * Source port for this connection.
   * Field introduced in 20.1.1.
   * @param sourcePort set the sourcePort.
   */
  public void setSourcePort(Integer  sourcePort) {
    this.sourcePort = sourcePort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Detailed description of the threat found in the content.
   * Available only if request was scanned by icap server and some violations were found.
   * Field introduced in 20.1.1.
   * @return threatDescription
   */
  public String getThreatDescription() {
    return threatDescription;
  }

  /**
   * This is the setter method to the attribute.
   * Detailed description of the threat found in the content.
   * Available only if request was scanned by icap server and some violations were found.
   * Field introduced in 20.1.1.
   * @param threatDescription set the threatDescription.
   */
  public void setThreatDescription(String  threatDescription) {
    this.threatDescription = threatDescription;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Short description of the threat found in the content.
   * Available only if content was scanned by icap server and some violations were found.
   * Field introduced in 20.1.1.
   * @return threatId
   */
  public String getThreatId() {
    return threatId;
  }

  /**
   * This is the setter method to the attribute.
   * Short description of the threat found in the content.
   * Available only if content was scanned by icap server and some violations were found.
   * Field introduced in 20.1.1.
   * @param threatId set the threatId.
   */
  public void setThreatId(String  threatId) {
    this.threatId = threatId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IcapRequestLog objIcapRequestLog = (IcapRequestLog) o;
  return   Objects.equals(this.poolName, objIcapRequestLog.poolName)&&
  Objects.equals(this.completeBodySent, objIcapRequestLog.completeBodySent)&&
  Objects.equals(this.httpResponseCode, objIcapRequestLog.httpResponseCode)&&
  Objects.equals(this.serverIp, objIcapRequestLog.serverIp)&&
  Objects.equals(this.latency, objIcapRequestLog.latency)&&
  Objects.equals(this.modifiedContentLength, objIcapRequestLog.modifiedContentLength)&&
  Objects.equals(this.icapAbsoluteUri, objIcapRequestLog.icapAbsoluteUri)&&
  Objects.equals(this.reason, objIcapRequestLog.reason)&&
  Objects.equals(this.action, objIcapRequestLog.action)&&
  Objects.equals(this.icapHeadersSentToServer, objIcapRequestLog.icapHeadersSentToServer)&&
  Objects.equals(this.httpMethod, objIcapRequestLog.httpMethod)&&
  Objects.equals(this.threatDescription, objIcapRequestLog.threatDescription)&&
  Objects.equals(this.icapResponseCode, objIcapRequestLog.icapResponseCode)&&
  Objects.equals(this.icapMethod, objIcapRequestLog.icapMethod)&&
  Objects.equals(this.threatId, objIcapRequestLog.threatId)&&
  Objects.equals(this.sourcePort, objIcapRequestLog.sourcePort)&&
  Objects.equals(this.poolUuid, objIcapRequestLog.poolUuid)&&
  Objects.equals(this.icapHeadersReceivedFromServer, objIcapRequestLog.icapHeadersReceivedFromServer);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IcapRequestLog {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    completeBodySent: ").append(toIndentedString(completeBodySent)).append("\n");
        sb.append("    httpMethod: ").append(toIndentedString(httpMethod)).append("\n");
        sb.append("    httpResponseCode: ").append(toIndentedString(httpResponseCode)).append("\n");
        sb.append("    icapAbsoluteUri: ").append(toIndentedString(icapAbsoluteUri)).append("\n");
        sb.append("    icapHeadersReceivedFromServer: ").append(toIndentedString(icapHeadersReceivedFromServer)).append("\n");
        sb.append("    icapHeadersSentToServer: ").append(toIndentedString(icapHeadersSentToServer)).append("\n");
        sb.append("    icapMethod: ").append(toIndentedString(icapMethod)).append("\n");
        sb.append("    icapResponseCode: ").append(toIndentedString(icapResponseCode)).append("\n");
        sb.append("    latency: ").append(toIndentedString(latency)).append("\n");
        sb.append("    modifiedContentLength: ").append(toIndentedString(modifiedContentLength)).append("\n");
        sb.append("    poolName: ").append(toIndentedString(poolName)).append("\n");
        sb.append("    poolUuid: ").append(toIndentedString(poolUuid)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    serverIp: ").append(toIndentedString(serverIp)).append("\n");
        sb.append("    sourcePort: ").append(toIndentedString(sourcePort)).append("\n");
        sb.append("    threatDescription: ").append(toIndentedString(threatDescription)).append("\n");
        sb.append("    threatId: ").append(toIndentedString(threatId)).append("\n");
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

