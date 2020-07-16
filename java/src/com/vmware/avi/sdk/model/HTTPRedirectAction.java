package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPRedirectAction is a POJO class extends AviRestResource that used for creating
 * HTTPRedirectAction.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPRedirectAction  {
    @JsonProperty("host")
    private URIParam host = null;

    @JsonProperty("keep_query")
    private Boolean keepQuery = true;

    @JsonProperty("path")
    private URIParam path = null;

    @JsonProperty("port")
    private Integer port = null;

    @JsonProperty("protocol")
    private String protocol = null;

    @JsonProperty("status_code")
    private String statusCode = "HTTP_REDIRECT_STATUS_CODE_302";



  /**
   * This is the getter method this will return the attribute value.
   * Host config.
   * @return host
   */
  public URIParam getHost() {
    return host;
  }

  /**
   * This is the setter method to the attribute.
   * Host config.
   * @param host set the host.
   */
  public void setHost(URIParam host) {
    this.host = host;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Keep or drop the query of the incoming request uri in the redirected uri.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return keepQuery
   */
  public Boolean getKeepQuery() {
    return keepQuery;
  }

  /**
   * This is the setter method to the attribute.
   * Keep or drop the query of the incoming request uri in the redirected uri.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param keepQuery set the keepQuery.
   */
  public void setKeepQuery(Boolean  keepQuery) {
    this.keepQuery = keepQuery;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Path config.
   * @return path
   */
  public URIParam getPath() {
    return path;
  }

  /**
   * This is the setter method to the attribute.
   * Path config.
   * @param path set the path.
   */
  public void setPath(URIParam path) {
    this.path = path;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Port to which redirect the request.
   * Allowed values are 1-65535.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Port to which redirect the request.
   * Allowed values are 1-65535.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Protocol type.
   * Enum options - HTTP, HTTPS.
   * @return protocol
   */
  public String getProtocol() {
    return protocol;
  }

  /**
   * This is the setter method to the attribute.
   * Protocol type.
   * Enum options - HTTP, HTTPS.
   * @param protocol set the protocol.
   */
  public void setProtocol(String  protocol) {
    this.protocol = protocol;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http redirect status code.
   * Enum options - HTTP_REDIRECT_STATUS_CODE_301, HTTP_REDIRECT_STATUS_CODE_302, HTTP_REDIRECT_STATUS_CODE_307.
   * Default value when not specified in API or module is interpreted by Avi Controller as HTTP_REDIRECT_STATUS_CODE_302.
   * @return statusCode
   */
  public String getStatusCode() {
    return statusCode;
  }

  /**
   * This is the setter method to the attribute.
   * Http redirect status code.
   * Enum options - HTTP_REDIRECT_STATUS_CODE_301, HTTP_REDIRECT_STATUS_CODE_302, HTTP_REDIRECT_STATUS_CODE_307.
   * Default value when not specified in API or module is interpreted by Avi Controller as HTTP_REDIRECT_STATUS_CODE_302.
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
  HTTPRedirectAction objHTTPRedirectAction = (HTTPRedirectAction) o;
  return   Objects.equals(this.protocol, objHTTPRedirectAction.protocol)&&
  Objects.equals(this.statusCode, objHTTPRedirectAction.statusCode)&&
  Objects.equals(this.host, objHTTPRedirectAction.host)&&
  Objects.equals(this.keepQuery, objHTTPRedirectAction.keepQuery)&&
  Objects.equals(this.path, objHTTPRedirectAction.path)&&
  Objects.equals(this.port, objHTTPRedirectAction.port);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPRedirectAction {\n");
      sb.append("    host: ").append(toIndentedString(host)).append("\n");
        sb.append("    keepQuery: ").append(toIndentedString(keepQuery)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
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

