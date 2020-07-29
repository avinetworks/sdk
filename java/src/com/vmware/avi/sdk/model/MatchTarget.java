package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MatchTarget is a POJO class extends AviRestResource that used for creating
 * MatchTarget.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchTarget  {
    @JsonProperty("client_ip")
    private IpAddrMatch clientIp = null;

    @JsonProperty("cookie")
    private CookieMatch cookie = null;

    @JsonProperty("hdrs")
    private List<HdrMatch> hdrs = null;

    @JsonProperty("host_hdr")
    private HostHdrMatch hostHdr = null;

    @JsonProperty("method")
    private MethodMatch method = null;

    @JsonProperty("path")
    private PathMatch path = null;

    @JsonProperty("protocol")
    private ProtocolMatch protocol = null;

    @JsonProperty("query")
    private QueryMatch query = null;

    @JsonProperty("version")
    private HTTPVersionMatch version = null;

    @JsonProperty("vs_port")
    private PortMatch vsPort = null;



  /**
   * This is the getter method this will return the attribute value.
   * Configure client ip addresses.
   * @return clientIp
   */
  public IpAddrMatch getClientIp() {
    return clientIp;
  }

  /**
   * This is the setter method to the attribute.
   * Configure client ip addresses.
   * @param clientIp set the clientIp.
   */
  public void setClientIp(IpAddrMatch clientIp) {
    this.clientIp = clientIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure http cookie(s).
   * @return cookie
   */
  public CookieMatch getCookie() {
    return cookie;
  }

  /**
   * This is the setter method to the attribute.
   * Configure http cookie(s).
   * @param cookie set the cookie.
   */
  public void setCookie(CookieMatch cookie) {
    this.cookie = cookie;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Configure http header(s).
   * @return hdrs
   */
  public List<HdrMatch> getHdrs() {
    return hdrs;
  }

  /**
   * This is the setter method. this will set the hdrs
   * Configure http header(s).
   * @return hdrs
   */
  public void setHdrs(List<HdrMatch>  hdrs) {
    this.hdrs = hdrs;
  }

  /**
   * This is the setter method this will set the hdrs
   * Configure http header(s).
   * @return hdrs
   */
  public MatchTarget addHdrsItem(HdrMatch hdrsItem) {
    if (this.hdrs == null) {
      this.hdrs = new ArrayList<HdrMatch>();
    }
    this.hdrs.add(hdrsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure the host header.
   * @return hostHdr
   */
  public HostHdrMatch getHostHdr() {
    return hostHdr;
  }

  /**
   * This is the setter method to the attribute.
   * Configure the host header.
   * @param hostHdr set the hostHdr.
   */
  public void setHostHdr(HostHdrMatch hostHdr) {
    this.hostHdr = hostHdr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure http methods.
   * @return method
   */
  public MethodMatch getMethod() {
    return method;
  }

  /**
   * This is the setter method to the attribute.
   * Configure http methods.
   * @param method set the method.
   */
  public void setMethod(MethodMatch method) {
    this.method = method;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure request paths.
   * @return path
   */
  public PathMatch getPath() {
    return path;
  }

  /**
   * This is the setter method to the attribute.
   * Configure request paths.
   * @param path set the path.
   */
  public void setPath(PathMatch path) {
    this.path = path;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure the type of http protocol.
   * @return protocol
   */
  public ProtocolMatch getProtocol() {
    return protocol;
  }

  /**
   * This is the setter method to the attribute.
   * Configure the type of http protocol.
   * @param protocol set the protocol.
   */
  public void setProtocol(ProtocolMatch protocol) {
    this.protocol = protocol;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure request query.
   * @return query
   */
  public QueryMatch getQuery() {
    return query;
  }

  /**
   * This is the setter method to the attribute.
   * Configure request query.
   * @param query set the query.
   */
  public void setQuery(QueryMatch query) {
    this.query = query;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure versions of the http protocol.
   * @return version
   */
  public HTTPVersionMatch getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Configure versions of the http protocol.
   * @param version set the version.
   */
  public void setVersion(HTTPVersionMatch version) {
    this.version = version;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure virtual service ports.
   * @return vsPort
   */
  public PortMatch getVsPort() {
    return vsPort;
  }

  /**
   * This is the setter method to the attribute.
   * Configure virtual service ports.
   * @param vsPort set the vsPort.
   */
  public void setVsPort(PortMatch vsPort) {
    this.vsPort = vsPort;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MatchTarget objMatchTarget = (MatchTarget) o;
  return   Objects.equals(this.clientIp, objMatchTarget.clientIp)&&
  Objects.equals(this.vsPort, objMatchTarget.vsPort)&&
  Objects.equals(this.protocol, objMatchTarget.protocol)&&
  Objects.equals(this.method, objMatchTarget.method)&&
  Objects.equals(this.version, objMatchTarget.version)&&
  Objects.equals(this.path, objMatchTarget.path)&&
  Objects.equals(this.query, objMatchTarget.query)&&
  Objects.equals(this.hdrs, objMatchTarget.hdrs)&&
  Objects.equals(this.cookie, objMatchTarget.cookie)&&
  Objects.equals(this.hostHdr, objMatchTarget.hostHdr);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MatchTarget {\n");
      sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
        sb.append("    cookie: ").append(toIndentedString(cookie)).append("\n");
        sb.append("    hdrs: ").append(toIndentedString(hdrs)).append("\n");
        sb.append("    hostHdr: ").append(toIndentedString(hostHdr)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
        sb.append("    query: ").append(toIndentedString(query)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    vsPort: ").append(toIndentedString(vsPort)).append("\n");
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

