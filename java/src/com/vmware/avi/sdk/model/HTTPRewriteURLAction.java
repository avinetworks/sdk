package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPRewriteURLAction is a POJO class extends AviRestResource that used for creating
 * HTTPRewriteURLAction.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPRewriteURLAction  {
    @JsonProperty("host_hdr")
    private URIParam hostHdr = null;

    @JsonProperty("path")
    private URIParam path = null;

    @JsonProperty("query")
    private URIParamQuery query = null;



  /**
   * This is the getter method this will return the attribute value.
   * Host config.
   * @return hostHdr
   */
  public URIParam getHostHdr() {
    return hostHdr;
  }

  /**
   * This is the setter method to the attribute.
   * Host config.
   * @param hostHdr set the hostHdr.
   */
  public void setHostHdr(URIParam hostHdr) {
    this.hostHdr = hostHdr;
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
   * Query config.
   * @return query
   */
  public URIParamQuery getQuery() {
    return query;
  }

  /**
   * This is the setter method to the attribute.
   * Query config.
   * @param query set the query.
   */
  public void setQuery(URIParamQuery query) {
    this.query = query;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTPRewriteURLAction objHTTPRewriteURLAction = (HTTPRewriteURLAction) o;
  return   Objects.equals(this.hostHdr, objHTTPRewriteURLAction.hostHdr)&&
  Objects.equals(this.path, objHTTPRewriteURLAction.path)&&
  Objects.equals(this.query, objHTTPRewriteURLAction.query);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPRewriteURLAction {\n");
      sb.append("    hostHdr: ").append(toIndentedString(hostHdr)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    query: ").append(toIndentedString(query)).append("\n");
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

