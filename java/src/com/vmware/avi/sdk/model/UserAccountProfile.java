package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The UserAccountProfile is a POJO class extends AviRestResource that used for creating
 * UserAccountProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAccountProfile extends AviRestResource  {
    @JsonProperty("account_lock_timeout")
    private Integer accountLockTimeout = 30;

    @JsonProperty("credentials_timeout_threshold")
    private Integer credentialsTimeoutThreshold = 180;

    @JsonProperty("max_concurrent_sessions")
    private Integer maxConcurrentSessions = 0;

    @JsonProperty("max_login_failure_count")
    private Integer maxLoginFailureCount = 3;

    @JsonProperty("max_password_history_count")
    private Integer maxPasswordHistoryCount = 4;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Lock timeout period (in minutes).
   * Default is 30 minutes.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @return accountLockTimeout
   */
  public Integer getAccountLockTimeout() {
    return accountLockTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Lock timeout period (in minutes).
   * Default is 30 minutes.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @param accountLockTimeout set the accountLockTimeout.
   */
  public void setAccountLockTimeout(Integer  accountLockTimeout) {
    this.accountLockTimeout = accountLockTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The time period after which credentials expire.
   * Default is 180 days.
   * Default value when not specified in API or module is interpreted by Avi Controller as 180.
   * @return credentialsTimeoutThreshold
   */
  public Integer getCredentialsTimeoutThreshold() {
    return credentialsTimeoutThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * The time period after which credentials expire.
   * Default is 180 days.
   * Default value when not specified in API or module is interpreted by Avi Controller as 180.
   * @param credentialsTimeoutThreshold set the credentialsTimeoutThreshold.
   */
  public void setCredentialsTimeoutThreshold(Integer  credentialsTimeoutThreshold) {
    this.credentialsTimeoutThreshold = credentialsTimeoutThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of concurrent sessions allowed.
   * There are unlimited sessions by default.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return maxConcurrentSessions
   */
  public Integer getMaxConcurrentSessions() {
    return maxConcurrentSessions;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of concurrent sessions allowed.
   * There are unlimited sessions by default.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param maxConcurrentSessions set the maxConcurrentSessions.
   */
  public void setMaxConcurrentSessions(Integer  maxConcurrentSessions) {
    this.maxConcurrentSessions = maxConcurrentSessions;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of login attempts before lockout.
   * Default is 3 attempts.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.
   * @return maxLoginFailureCount
   */
  public Integer getMaxLoginFailureCount() {
    return maxLoginFailureCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of login attempts before lockout.
   * Default is 3 attempts.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.
   * @param maxLoginFailureCount set the maxLoginFailureCount.
   */
  public void setMaxLoginFailureCount(Integer  maxLoginFailureCount) {
    this.maxLoginFailureCount = maxLoginFailureCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of passwords to be maintained in the password history.
   * Default is 4 passwords.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @return maxPasswordHistoryCount
   */
  public Integer getMaxPasswordHistoryCount() {
    return maxPasswordHistoryCount;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of passwords to be maintained in the password history.
   * Default is 4 passwords.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @param maxPasswordHistoryCount set the maxPasswordHistoryCount.
   */
  public void setMaxPasswordHistoryCount(Integer  maxPasswordHistoryCount) {
    this.maxPasswordHistoryCount = maxPasswordHistoryCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }
/**
   * This is the getter method this will return the attribute value.
   * Avi controller URL of the object.
   * @return url
   */
  public String getUrl() {
    return url;
  }

  /**
   * This is the setter method. this will set the url
   * Avi controller URL of the object.
   * @return url
   */
  public void setUrl(String  url) {
    this.url = url;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  UserAccountProfile objUserAccountProfile = (UserAccountProfile) o;
  return   Objects.equals(this.maxConcurrentSessions, objUserAccountProfile.maxConcurrentSessions)&&
  Objects.equals(this.uuid, objUserAccountProfile.uuid)&&
  Objects.equals(this.accountLockTimeout, objUserAccountProfile.accountLockTimeout)&&
  Objects.equals(this.maxLoginFailureCount, objUserAccountProfile.maxLoginFailureCount)&&
  Objects.equals(this.maxPasswordHistoryCount, objUserAccountProfile.maxPasswordHistoryCount)&&
  Objects.equals(this.credentialsTimeoutThreshold, objUserAccountProfile.credentialsTimeoutThreshold)&&
  Objects.equals(this.name, objUserAccountProfile.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class UserAccountProfile {\n");
      sb.append("    accountLockTimeout: ").append(toIndentedString(accountLockTimeout)).append("\n");
        sb.append("    credentialsTimeoutThreshold: ").append(toIndentedString(credentialsTimeoutThreshold)).append("\n");
        sb.append("    maxConcurrentSessions: ").append(toIndentedString(maxConcurrentSessions)).append("\n");
        sb.append("    maxLoginFailureCount: ").append(toIndentedString(maxLoginFailureCount)).append("\n");
        sb.append("    maxPasswordHistoryCount: ").append(toIndentedString(maxPasswordHistoryCount)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

