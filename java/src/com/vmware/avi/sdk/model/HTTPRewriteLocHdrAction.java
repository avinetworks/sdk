package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPRewriteLocHdrAction is a POJO class extends AviRestResource that used for creating
 * HTTPRewriteLocHdrAction.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPRewriteLocHdrAction  {
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
   * Keep or drop the query from the server side redirect uri.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return keepQuery
   */
  public Boolean getKeepQuery() {
    return keepQuery;
  }

  /**
   * This is the setter method to the attribute.
   * Keep or drop the query from the server side redirect uri.
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
   * Port to use in the redirected uri.
   * Allowed values are 1-65535.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Port to use in the redirected uri.
   * Allowed values are 1-65535.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http protocol type.
   * Enum options - HTTP, HTTPS.
   * @return protocol
   */
  public String getProtocol() {
    return protocol;
  }

  /**
   * This is the setter method to the attribute.
   * Http protocol type.
   * Enum options - HTTP, HTTPS.
   * @param protocol set the protocol.
   */
  public void setProtocol(String  protocol) {
    this.protocol = protocol;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTPRewriteLocHdrAction objHTTPRewriteLocHdrAction = (HTTPRewriteLocHdrAction) o;
  return   Objects.equals(this.keepQuery, objHTTPRewriteLocHdrAction.keepQuery)&&
  Objects.equals(this.path, objHTTPRewriteLocHdrAction.path)&&
  Objects.equals(this.host, objHTTPRewriteLocHdrAction.host)&&
  Objects.equals(this.protocol, objHTTPRewriteLocHdrAction.protocol)&&
  Objects.equals(this.port, objHTTPRewriteLocHdrAction.port);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPRewriteLocHdrAction {\n");
      sb.append("    host: ").append(toIndentedString(host)).append("\n");
        sb.append("    keepQuery: ").append(toIndentedString(keepQuery)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
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

