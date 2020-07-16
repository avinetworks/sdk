package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPClientAuthenticationParams is a POJO class extends AviRestResource that used for creating
 * HTTPClientAuthenticationParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPClientAuthenticationParams  {
    @JsonProperty("auth_profile_ref")
    private String authProfileRef = null;

    @JsonProperty("realm")
    private String realm = null;

    @JsonProperty("request_uri_path")
    private StringMatch requestUriPath = null;

    @JsonProperty("type")
    private String type = null;



  /**
   * This is the getter method this will return the attribute value.
   * Auth profile to use for validating users.
   * It is a reference to an object of type authprofile.
   * @return authProfileRef
   */
  public String getAuthProfileRef() {
    return authProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Auth profile to use for validating users.
   * It is a reference to an object of type authprofile.
   * @param authProfileRef set the authProfileRef.
   */
  public void setAuthProfileRef(String  authProfileRef) {
    this.authProfileRef = authProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Basic authentication realm to present to a user along with the prompt for credentials.
   * @return realm
   */
  public String getRealm() {
    return realm;
  }

  /**
   * This is the setter method to the attribute.
   * Basic authentication realm to present to a user along with the prompt for credentials.
   * @param realm set the realm.
   */
  public void setRealm(String  realm) {
    this.realm = realm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rrequest uri path when the authentication applies.
   * @return requestUriPath
   */
  public StringMatch getRequestUriPath() {
    return requestUriPath;
  }

  /**
   * This is the setter method to the attribute.
   * Rrequest uri path when the authentication applies.
   * @param requestUriPath set the requestUriPath.
   */
  public void setRequestUriPath(StringMatch requestUriPath) {
    this.requestUriPath = requestUriPath;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Type of client authentication.
   * Enum options - HTTP_BASIC_AUTH.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Type of client authentication.
   * Enum options - HTTP_BASIC_AUTH.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTPClientAuthenticationParams objHTTPClientAuthenticationParams = (HTTPClientAuthenticationParams) o;
  return   Objects.equals(this.realm, objHTTPClientAuthenticationParams.realm)&&
  Objects.equals(this.authProfileRef, objHTTPClientAuthenticationParams.authProfileRef)&&
  Objects.equals(this.type, objHTTPClientAuthenticationParams.type)&&
  Objects.equals(this.requestUriPath, objHTTPClientAuthenticationParams.requestUriPath);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPClientAuthenticationParams {\n");
      sb.append("    authProfileRef: ").append(toIndentedString(authProfileRef)).append("\n");
        sb.append("    realm: ").append(toIndentedString(realm)).append("\n");
        sb.append("    requestUriPath: ").append(toIndentedString(requestUriPath)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

