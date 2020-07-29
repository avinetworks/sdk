package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AuthProfileHTTPClientParams is a POJO class extends AviRestResource that used for creating
 * AuthProfileHTTPClientParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthProfileHTTPClientParams  {
    @JsonProperty("cache_expiration_time")
    private Integer cacheExpirationTime = 5;

    @JsonProperty("group_member_is_full_dn")
    private Boolean groupMemberIsFullDn = false;

    @JsonProperty("request_header")
    private String requestHeader = null;

    @JsonProperty("require_user_groups")
    private List<String> requireUserGroups = null;



  /**
   * This is the getter method this will return the attribute value.
   * The max allowed length of time a clients authentication is cached.
   * Allowed values are 1-30.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @return cacheExpirationTime
   */
  public Integer getCacheExpirationTime() {
    return cacheExpirationTime;
  }

  /**
   * This is the setter method to the attribute.
   * The max allowed length of time a clients authentication is cached.
   * Allowed values are 1-30.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @param cacheExpirationTime set the cacheExpirationTime.
   */
  public void setCacheExpirationTime(Integer  cacheExpirationTime) {
    this.cacheExpirationTime = cacheExpirationTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Group member entries contain full dns instead of just user id attribute values.
   * This should now be configured using the ldapdirectorysettings field instead.
   * Field deprecated in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return groupMemberIsFullDn
   */
  public Boolean getGroupMemberIsFullDn() {
    return groupMemberIsFullDn;
  }

  /**
   * This is the setter method to the attribute.
   * Group member entries contain full dns instead of just user id attribute values.
   * This should now be configured using the ldapdirectorysettings field instead.
   * Field deprecated in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param groupMemberIsFullDn set the groupMemberIsFullDn.
   */
  public void setGroupMemberIsFullDn(Boolean  groupMemberIsFullDn) {
    this.groupMemberIsFullDn = groupMemberIsFullDn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Insert an http header.
   * This field is used to define the header name.
   * The value of the header is set to the client's http auth user id.
   * @return requestHeader
   */
  public String getRequestHeader() {
    return requestHeader;
  }

  /**
   * This is the setter method to the attribute.
   * Insert an http header.
   * This field is used to define the header name.
   * The value of the header is set to the client's http auth user id.
   * @param requestHeader set the requestHeader.
   */
  public void setRequestHeader(String  requestHeader) {
    this.requestHeader = requestHeader;
  }
  /**
   * This is the getter method this will return the attribute value.
   * A user should be a member of these groups.
   * Each group is defined by the dn.
   * For example, cn=testgroup,ou=groups,dc=example,dc=avinetworks,dc=com.
   * @return requireUserGroups
   */
  public List<String> getRequireUserGroups() {
    return requireUserGroups;
  }

  /**
   * This is the setter method. this will set the requireUserGroups
   * A user should be a member of these groups.
   * Each group is defined by the dn.
   * For example, cn=testgroup,ou=groups,dc=example,dc=avinetworks,dc=com.
   * @return requireUserGroups
   */
  public void setRequireUserGroups(List<String>  requireUserGroups) {
    this.requireUserGroups = requireUserGroups;
  }

  /**
   * This is the setter method this will set the requireUserGroups
   * A user should be a member of these groups.
   * Each group is defined by the dn.
   * For example, cn=testgroup,ou=groups,dc=example,dc=avinetworks,dc=com.
   * @return requireUserGroups
   */
  public AuthProfileHTTPClientParams addRequireUserGroupsItem(String requireUserGroupsItem) {
    if (this.requireUserGroups == null) {
      this.requireUserGroups = new ArrayList<String>();
    }
    this.requireUserGroups.add(requireUserGroupsItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AuthProfileHTTPClientParams objAuthProfileHTTPClientParams = (AuthProfileHTTPClientParams) o;
  return   Objects.equals(this.requestHeader, objAuthProfileHTTPClientParams.requestHeader)&&
  Objects.equals(this.cacheExpirationTime, objAuthProfileHTTPClientParams.cacheExpirationTime)&&
  Objects.equals(this.requireUserGroups, objAuthProfileHTTPClientParams.requireUserGroups)&&
  Objects.equals(this.groupMemberIsFullDn, objAuthProfileHTTPClientParams.groupMemberIsFullDn);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AuthProfileHTTPClientParams {\n");
      sb.append("    cacheExpirationTime: ").append(toIndentedString(cacheExpirationTime)).append("\n");
        sb.append("    groupMemberIsFullDn: ").append(toIndentedString(groupMemberIsFullDn)).append("\n");
        sb.append("    requestHeader: ").append(toIndentedString(requestHeader)).append("\n");
        sb.append("    requireUserGroups: ").append(toIndentedString(requireUserGroups)).append("\n");
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

