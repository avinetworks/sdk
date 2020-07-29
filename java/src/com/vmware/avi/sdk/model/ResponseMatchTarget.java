package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ResponseMatchTarget is a POJO class extends AviRestResource that used for creating
 * ResponseMatchTarget.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMatchTarget  {
    @JsonProperty("client_ip")
    private IpAddrMatch clientIp = null;

    @JsonProperty("cookie")
    private CookieMatch cookie = null;

    @JsonProperty("hdrs")
    private List<HdrMatch> hdrs = null;

    @JsonProperty("host_hdr")
    private HostHdrMatch hostHdr = null;

    @JsonProperty("loc_hdr")
    private LocationHdrMatch locHdr = null;

    @JsonProperty("method")
    private MethodMatch method = null;

    @JsonProperty("path")
    private PathMatch path = null;

    @JsonProperty("protocol")
    private ProtocolMatch protocol = null;

    @JsonProperty("query")
    private QueryMatch query = null;

    @JsonProperty("rsp_hdrs")
    private List<HdrMatch> rspHdrs = null;

    @JsonProperty("status")
    private HTTPStatusMatch status = null;

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
   * Configure http headers.
   * @return hdrs
   */
  public List<HdrMatch> getHdrs() {
    return hdrs;
  }

  /**
   * This is the setter method. this will set the hdrs
   * Configure http headers.
   * @return hdrs
   */
  public void setHdrs(List<HdrMatch>  hdrs) {
    this.hdrs = hdrs;
  }

  /**
   * This is the setter method this will set the hdrs
   * Configure http headers.
   * @return hdrs
   */
  public ResponseMatchTarget addHdrsItem(HdrMatch hdrsItem) {
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
   * Configure the location header.
   * @return locHdr
   */
  public LocationHdrMatch getLocHdr() {
    return locHdr;
  }

  /**
   * This is the setter method to the attribute.
   * Configure the location header.
   * @param locHdr set the locHdr.
   */
  public void setLocHdr(LocationHdrMatch locHdr) {
    this.locHdr = locHdr;
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
   * Configure the http headers in response.
   * @return rspHdrs
   */
  public List<HdrMatch> getRspHdrs() {
    return rspHdrs;
  }

  /**
   * This is the setter method. this will set the rspHdrs
   * Configure the http headers in response.
   * @return rspHdrs
   */
  public void setRspHdrs(List<HdrMatch>  rspHdrs) {
    this.rspHdrs = rspHdrs;
  }

  /**
   * This is the setter method this will set the rspHdrs
   * Configure the http headers in response.
   * @return rspHdrs
   */
  public ResponseMatchTarget addRspHdrsItem(HdrMatch rspHdrsItem) {
    if (this.rspHdrs == null) {
      this.rspHdrs = new ArrayList<HdrMatch>();
    }
    this.rspHdrs.add(rspHdrsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure the http status code(s).
   * @return status
   */
  public HTTPStatusMatch getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Configure the http status code(s).
   * @param status set the status.
   */
  public void setStatus(HTTPStatusMatch status) {
    this.status = status;
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
  ResponseMatchTarget objResponseMatchTarget = (ResponseMatchTarget) o;
  return   Objects.equals(this.clientIp, objResponseMatchTarget.clientIp)&&
  Objects.equals(this.vsPort, objResponseMatchTarget.vsPort)&&
  Objects.equals(this.protocol, objResponseMatchTarget.protocol)&&
  Objects.equals(this.method, objResponseMatchTarget.method)&&
  Objects.equals(this.version, objResponseMatchTarget.version)&&
  Objects.equals(this.path, objResponseMatchTarget.path)&&
  Objects.equals(this.query, objResponseMatchTarget.query)&&
  Objects.equals(this.hdrs, objResponseMatchTarget.hdrs)&&
  Objects.equals(this.cookie, objResponseMatchTarget.cookie)&&
  Objects.equals(this.hostHdr, objResponseMatchTarget.hostHdr)&&
  Objects.equals(this.locHdr, objResponseMatchTarget.locHdr)&&
  Objects.equals(this.status, objResponseMatchTarget.status)&&
  Objects.equals(this.rspHdrs, objResponseMatchTarget.rspHdrs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ResponseMatchTarget {\n");
      sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
        sb.append("    cookie: ").append(toIndentedString(cookie)).append("\n");
        sb.append("    hdrs: ").append(toIndentedString(hdrs)).append("\n");
        sb.append("    hostHdr: ").append(toIndentedString(hostHdr)).append("\n");
        sb.append("    locHdr: ").append(toIndentedString(locHdr)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
        sb.append("    query: ").append(toIndentedString(query)).append("\n");
        sb.append("    rspHdrs: ").append(toIndentedString(rspHdrs)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

