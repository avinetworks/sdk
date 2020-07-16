package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafPSMLocationMatch is a POJO class extends AviRestResource that used for creating
 * WafPSMLocationMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafPSMLocationMatch  {
    @JsonProperty("host")
    private HostHdrMatch host = null;

    @JsonProperty("methods")
    private MethodMatch methods = null;

    @JsonProperty("path")
    private PathMatch path = null;



  /**
   * This is the getter method this will return the attribute value.
   * Apply the rules only to requests that match the specified host header.
   * If this is not set, the host header will not be checked.
   * Field introduced in 18.2.3.
   * @return host
   */
  public HostHdrMatch getHost() {
    return host;
  }

  /**
   * This is the setter method to the attribute.
   * Apply the rules only to requests that match the specified host header.
   * If this is not set, the host header will not be checked.
   * Field introduced in 18.2.3.
   * @param host set the host.
   */
  public void setHost(HostHdrMatch host) {
    this.host = host;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Apply the rules only to requests that have the specified methods.
   * If this is not set, the method will not be checked.
   * Field introduced in 18.2.3.
   * @return methods
   */
  public MethodMatch getMethods() {
    return methods;
  }

  /**
   * This is the setter method to the attribute.
   * Apply the rules only to requests that have the specified methods.
   * If this is not set, the method will not be checked.
   * Field introduced in 18.2.3.
   * @param methods set the methods.
   */
  public void setMethods(MethodMatch methods) {
    this.methods = methods;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Apply the rules only to requests that match the specified uri.
   * If this is not set, the path will not be checked.
   * Field introduced in 18.2.3.
   * @return path
   */
  public PathMatch getPath() {
    return path;
  }

  /**
   * This is the setter method to the attribute.
   * Apply the rules only to requests that match the specified uri.
   * If this is not set, the path will not be checked.
   * Field introduced in 18.2.3.
   * @param path set the path.
   */
  public void setPath(PathMatch path) {
    this.path = path;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  WafPSMLocationMatch objWafPSMLocationMatch = (WafPSMLocationMatch) o;
  return   Objects.equals(this.path, objWafPSMLocationMatch.path)&&
  Objects.equals(this.host, objWafPSMLocationMatch.host)&&
  Objects.equals(this.methods, objWafPSMLocationMatch.methods);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafPSMLocationMatch {\n");
      sb.append("    host: ").append(toIndentedString(host)).append("\n");
        sb.append("    methods: ").append(toIndentedString(methods)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

