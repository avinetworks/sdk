package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPHdrAction is a POJO class extends AviRestResource that used for creating
 * HTTPHdrAction.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPHdrAction  {
    @JsonProperty("action")
    private String action = null;

    @JsonProperty("cookie")
    private HTTPCookieData cookie = null;

    @JsonProperty("hdr")
    private HTTPHdrData hdr = null;



  /**
   * This is the getter method this will return the attribute value.
   * Add  a new header with the new value is added irrespective of the existence of an http header of the given name.
   * Replace  a new header with the new value is added if no header of the given name exists, else existing headers with the given name are removed
   * and a new header with the new value is added.
   * Remove  all the headers of the given name are removed.
   * Enum options - HTTP_ADD_HDR, HTTP_REMOVE_HDR, HTTP_REPLACE_HDR.
   * @return action
   */
  public String getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Add  a new header with the new value is added irrespective of the existence of an http header of the given name.
   * Replace  a new header with the new value is added if no header of the given name exists, else existing headers with the given name are removed
   * and a new header with the new value is added.
   * Remove  all the headers of the given name are removed.
   * Enum options - HTTP_ADD_HDR, HTTP_REMOVE_HDR, HTTP_REPLACE_HDR.
   * @param action set the action.
   */
  public void setAction(String  action) {
    this.action = action;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Cookie information.
   * @return cookie
   */
  public HTTPCookieData getCookie() {
    return cookie;
  }

  /**
   * This is the setter method to the attribute.
   * Cookie information.
   * @param cookie set the cookie.
   */
  public void setCookie(HTTPCookieData cookie) {
    this.cookie = cookie;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http header information.
   * @return hdr
   */
  public HTTPHdrData getHdr() {
    return hdr;
  }

  /**
   * This is the setter method to the attribute.
   * Http header information.
   * @param hdr set the hdr.
   */
  public void setHdr(HTTPHdrData hdr) {
    this.hdr = hdr;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTPHdrAction objHTTPHdrAction = (HTTPHdrAction) o;
  return   Objects.equals(this.action, objHTTPHdrAction.action)&&
  Objects.equals(this.cookie, objHTTPHdrAction.cookie)&&
  Objects.equals(this.hdr, objHTTPHdrAction.hdr);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPHdrAction {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    cookie: ").append(toIndentedString(cookie)).append("\n");
        sb.append("    hdr: ").append(toIndentedString(hdr)).append("\n");
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

