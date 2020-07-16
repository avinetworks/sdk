package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ConfigUserPasswordChangeRequest is a POJO class extends AviRestResource that used for creating
 * ConfigUserPasswordChangeRequest.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigUserPasswordChangeRequest  {
    @JsonProperty("client_ip")
    private String clientIp = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("user")
    private String user = null;

    @JsonProperty("user_email")
    private String userEmail = null;



  /**
   * This is the getter method this will return the attribute value.
   * Client ip.
   * @return clientIp
   */
  public String getClientIp() {
    return clientIp;
  }

  /**
   * This is the setter method to the attribute.
   * Client ip.
   * @param clientIp set the clientIp.
   */
  public void setClientIp(String  clientIp) {
    this.clientIp = clientIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Password link is sent or rejected.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Password link is sent or rejected.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Matched username of email address.
   * @return user
   */
  public String getUser() {
    return user;
  }

  /**
   * This is the setter method to the attribute.
   * Matched username of email address.
   * @param user set the user.
   */
  public void setUser(String  user) {
    this.user = user;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Email address of user.
   * @return userEmail
   */
  public String getUserEmail() {
    return userEmail;
  }

  /**
   * This is the setter method to the attribute.
   * Email address of user.
   * @param userEmail set the userEmail.
   */
  public void setUserEmail(String  userEmail) {
    this.userEmail = userEmail;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ConfigUserPasswordChangeRequest objConfigUserPasswordChangeRequest = (ConfigUserPasswordChangeRequest) o;
  return   Objects.equals(this.status, objConfigUserPasswordChangeRequest.status)&&
  Objects.equals(this.clientIp, objConfigUserPasswordChangeRequest.clientIp)&&
  Objects.equals(this.user, objConfigUserPasswordChangeRequest.user)&&
  Objects.equals(this.userEmail, objConfigUserPasswordChangeRequest.userEmail);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ConfigUserPasswordChangeRequest {\n");
      sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
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

