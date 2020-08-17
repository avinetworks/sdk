package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The LdapDirectorySettings is a POJO class extends AviRestResource that used for creating
 * LdapDirectorySettings.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LdapDirectorySettings  {
    @JsonProperty("admin_bind_dn")
    private String adminBindDn = null;

    @JsonProperty("group_filter")
    private String groupFilter = "(objectClass=*)";

    @JsonProperty("group_member_attribute")
    private String groupMemberAttribute = "member";

    @JsonProperty("group_member_is_full_dn")
    private Boolean groupMemberIsFullDn = true;

    @JsonProperty("group_search_dn")
    private String groupSearchDn = null;

    @JsonProperty("group_search_scope")
    private String groupSearchScope = "AUTH_LDAP_SCOPE_SUBTREE";

    @JsonProperty("ignore_referrals")
    private Boolean ignoreReferrals = false;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("user_attributes")
    private List<String> userAttributes = null;

    @JsonProperty("user_id_attribute")
    private String userIdAttribute = null;

    @JsonProperty("user_search_dn")
    private String userSearchDn = null;

    @JsonProperty("user_search_scope")
    private String userSearchScope = "AUTH_LDAP_SCOPE_ONE";



  /**
   * This is the getter method this will return the attribute value.
   * Ldap admin user dn.
   * Administrator credentials are required to search for users under user search dn or groups under group search dn.
   * @return adminBindDn
   */
  public String getAdminBindDn() {
    return adminBindDn;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap admin user dn.
   * Administrator credentials are required to search for users under user search dn or groups under group search dn.
   * @param adminBindDn set the adminBindDn.
   */
  public void setAdminBindDn(String  adminBindDn) {
    this.adminBindDn = adminBindDn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Group filter is used to identify groups during search.
   * Default value when not specified in API or module is interpreted by Avi Controller as (objectClass=*).
   * @return groupFilter
   */
  public String getGroupFilter() {
    return groupFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Group filter is used to identify groups during search.
   * Default value when not specified in API or module is interpreted by Avi Controller as (objectClass=*).
   * @param groupFilter set the groupFilter.
   */
  public void setGroupFilter(String  groupFilter) {
    this.groupFilter = groupFilter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap group attribute that identifies each of the group members.
   * Default value when not specified in API or module is interpreted by Avi Controller as member.
   * @return groupMemberAttribute
   */
  public String getGroupMemberAttribute() {
    return groupMemberAttribute;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap group attribute that identifies each of the group members.
   * Default value when not specified in API or module is interpreted by Avi Controller as member.
   * @param groupMemberAttribute set the groupMemberAttribute.
   */
  public void setGroupMemberAttribute(String  groupMemberAttribute) {
    this.groupMemberAttribute = groupMemberAttribute;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Group member entries contain full dns instead of just user id attribute values.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return groupMemberIsFullDn
   */
  public Boolean getGroupMemberIsFullDn() {
    return groupMemberIsFullDn;
  }

  /**
   * This is the setter method to the attribute.
   * Group member entries contain full dns instead of just user id attribute values.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param groupMemberIsFullDn set the groupMemberIsFullDn.
   */
  public void setGroupMemberIsFullDn(Boolean  groupMemberIsFullDn) {
    this.groupMemberIsFullDn = groupMemberIsFullDn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap group search dn is the root of search for a given group in the ldap directory.
   * Only matching groups present in this ldap directory sub-tree will be checked for user membership.
   * @return groupSearchDn
   */
  public String getGroupSearchDn() {
    return groupSearchDn;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap group search dn is the root of search for a given group in the ldap directory.
   * Only matching groups present in this ldap directory sub-tree will be checked for user membership.
   * @param groupSearchDn set the groupSearchDn.
   */
  public void setGroupSearchDn(String  groupSearchDn) {
    this.groupSearchDn = groupSearchDn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap group search scope defines how deep to search for the group starting from the group search dn.
   * Enum options - AUTH_LDAP_SCOPE_BASE, AUTH_LDAP_SCOPE_ONE, AUTH_LDAP_SCOPE_SUBTREE.
   * Default value when not specified in API or module is interpreted by Avi Controller as AUTH_LDAP_SCOPE_SUBTREE.
   * @return groupSearchScope
   */
  public String getGroupSearchScope() {
    return groupSearchScope;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap group search scope defines how deep to search for the group starting from the group search dn.
   * Enum options - AUTH_LDAP_SCOPE_BASE, AUTH_LDAP_SCOPE_ONE, AUTH_LDAP_SCOPE_SUBTREE.
   * Default value when not specified in API or module is interpreted by Avi Controller as AUTH_LDAP_SCOPE_SUBTREE.
   * @param groupSearchScope set the groupSearchScope.
   */
  public void setGroupSearchScope(String  groupSearchScope) {
    this.groupSearchScope = groupSearchScope;
  }

  /**
   * This is the getter method this will return the attribute value.
   * During user or group search, ignore searching referrals.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return ignoreReferrals
   */
  public Boolean getIgnoreReferrals() {
    return ignoreReferrals;
  }

  /**
   * This is the setter method to the attribute.
   * During user or group search, ignore searching referrals.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param ignoreReferrals set the ignoreReferrals.
   */
  public void setIgnoreReferrals(Boolean  ignoreReferrals) {
    this.ignoreReferrals = ignoreReferrals;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap admin user password.
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap admin user password.
   * @param password set the password.
   */
  public void setPassword(String  password) {
    this.password = password;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Ldap user attributes to fetch on a successful user bind.
   * @return userAttributes
   */
  public List<String> getUserAttributes() {
    return userAttributes;
  }

  /**
   * This is the setter method. this will set the userAttributes
   * Ldap user attributes to fetch on a successful user bind.
   * @return userAttributes
   */
  public void setUserAttributes(List<String>  userAttributes) {
    this.userAttributes = userAttributes;
  }

  /**
   * This is the setter method this will set the userAttributes
   * Ldap user attributes to fetch on a successful user bind.
   * @return userAttributes
   */
  public LdapDirectorySettings addUserAttributesItem(String userAttributesItem) {
    if (this.userAttributes == null) {
      this.userAttributes = new ArrayList<String>();
    }
    this.userAttributes.add(userAttributesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap user id attribute is the login attribute that uniquely identifies a single user record.
   * @return userIdAttribute
   */
  public String getUserIdAttribute() {
    return userIdAttribute;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap user id attribute is the login attribute that uniquely identifies a single user record.
   * @param userIdAttribute set the userIdAttribute.
   */
  public void setUserIdAttribute(String  userIdAttribute) {
    this.userIdAttribute = userIdAttribute;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap user search dn is the root of search for a given user in the ldap directory.
   * Only user records present in this ldap directory sub-tree will be validated.
   * @return userSearchDn
   */
  public String getUserSearchDn() {
    return userSearchDn;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap user search dn is the root of search for a given user in the ldap directory.
   * Only user records present in this ldap directory sub-tree will be validated.
   * @param userSearchDn set the userSearchDn.
   */
  public void setUserSearchDn(String  userSearchDn) {
    this.userSearchDn = userSearchDn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap user search scope defines how deep to search for the user starting from user search dn.
   * Enum options - AUTH_LDAP_SCOPE_BASE, AUTH_LDAP_SCOPE_ONE, AUTH_LDAP_SCOPE_SUBTREE.
   * Default value when not specified in API or module is interpreted by Avi Controller as AUTH_LDAP_SCOPE_ONE.
   * @return userSearchScope
   */
  public String getUserSearchScope() {
    return userSearchScope;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap user search scope defines how deep to search for the user starting from user search dn.
   * Enum options - AUTH_LDAP_SCOPE_BASE, AUTH_LDAP_SCOPE_ONE, AUTH_LDAP_SCOPE_SUBTREE.
   * Default value when not specified in API or module is interpreted by Avi Controller as AUTH_LDAP_SCOPE_ONE.
   * @param userSearchScope set the userSearchScope.
   */
  public void setUserSearchScope(String  userSearchScope) {
    this.userSearchScope = userSearchScope;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  LdapDirectorySettings objLdapDirectorySettings = (LdapDirectorySettings) o;
  return   Objects.equals(this.adminBindDn, objLdapDirectorySettings.adminBindDn)&&
  Objects.equals(this.password, objLdapDirectorySettings.password)&&
  Objects.equals(this.userSearchDn, objLdapDirectorySettings.userSearchDn)&&
  Objects.equals(this.userSearchScope, objLdapDirectorySettings.userSearchScope)&&
  Objects.equals(this.userIdAttribute, objLdapDirectorySettings.userIdAttribute)&&
  Objects.equals(this.userAttributes, objLdapDirectorySettings.userAttributes)&&
  Objects.equals(this.groupSearchDn, objLdapDirectorySettings.groupSearchDn)&&
  Objects.equals(this.groupMemberAttribute, objLdapDirectorySettings.groupMemberAttribute)&&
  Objects.equals(this.groupSearchScope, objLdapDirectorySettings.groupSearchScope)&&
  Objects.equals(this.groupMemberIsFullDn, objLdapDirectorySettings.groupMemberIsFullDn)&&
  Objects.equals(this.groupFilter, objLdapDirectorySettings.groupFilter)&&
  Objects.equals(this.ignoreReferrals, objLdapDirectorySettings.ignoreReferrals);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class LdapDirectorySettings {\n");
      sb.append("    adminBindDn: ").append(toIndentedString(adminBindDn)).append("\n");
        sb.append("    groupFilter: ").append(toIndentedString(groupFilter)).append("\n");
        sb.append("    groupMemberAttribute: ").append(toIndentedString(groupMemberAttribute)).append("\n");
        sb.append("    groupMemberIsFullDn: ").append(toIndentedString(groupMemberIsFullDn)).append("\n");
        sb.append("    groupSearchDn: ").append(toIndentedString(groupSearchDn)).append("\n");
        sb.append("    groupSearchScope: ").append(toIndentedString(groupSearchScope)).append("\n");
        sb.append("    ignoreReferrals: ").append(toIndentedString(ignoreReferrals)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    userAttributes: ").append(toIndentedString(userAttributes)).append("\n");
        sb.append("    userIdAttribute: ").append(toIndentedString(userIdAttribute)).append("\n");
        sb.append("    userSearchDn: ").append(toIndentedString(userSearchDn)).append("\n");
        sb.append("    userSearchScope: ").append(toIndentedString(userSearchScope)).append("\n");
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

