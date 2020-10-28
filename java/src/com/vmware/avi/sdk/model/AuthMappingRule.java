package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The AuthMappingRule is a POJO class extends AviRestResource that used for creating
 * AuthMappingRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthMappingRule  {
    @JsonProperty("assign_policy")
    private String assignPolicy = null;

    @JsonProperty("assign_role")
    private String assignRole = null;

    @JsonProperty("assign_tenant")
    private String assignTenant = null;

    @JsonProperty("assign_userprofile")
    private String assignUserprofile = null;

    @JsonProperty("attribute_match")
    private AuthMatchAttribute attributeMatch = null;

    @JsonProperty("group_match")
    private AuthMatchGroupMembership groupMatch = null;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("is_superuser")
    private Boolean isSuperuser = null;

    @JsonProperty("object_access_policy_refs")
    private List<String> objectAccessPolicyRefs;

    @JsonProperty("policy_attribute_name")
    private String policyAttributeName = null;

    @JsonProperty("role_attribute_name")
    private String roleAttributeName = null;

    @JsonProperty("role_refs")
    private List<String> roleRefs = null;

    @JsonProperty("tenant_attribute_name")
    private String tenantAttributeName = null;

    @JsonProperty("tenant_refs")
    private List<String> tenantRefs = null;

    @JsonProperty("userprofile_attribute_name")
    private String userprofileAttributeName = null;

    @JsonProperty("userprofile_ref")
    private String userprofileRef = null;



    /**
     * This is the getter method this will return the attribute value.
     * Assignment rule for the object access policy.
     * Enum options - ASSIGN_ALL, ASSIGN_FROM_SELECT_LIST, ASSIGN_MATCHING_GROUP_NAME, ASSIGN_MATCHING_ATTRIBUTE_VALUE, ASSIGN_MATCHING_GROUP_REGEX,
     * ASSIGN_MATCHING_ATTRIBUTE_REGEX.
     * Field introduced in 18.2.7, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return assignPolicy
     */
    public String getAssignPolicy() {
        return assignPolicy;
    }

    /**
     * This is the setter method to the attribute.
     * Assignment rule for the object access policy.
     * Enum options - ASSIGN_ALL, ASSIGN_FROM_SELECT_LIST, ASSIGN_MATCHING_GROUP_NAME, ASSIGN_MATCHING_ATTRIBUTE_VALUE, ASSIGN_MATCHING_GROUP_REGEX,
     * ASSIGN_MATCHING_ATTRIBUTE_REGEX.
     * Field introduced in 18.2.7, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param assignPolicy set the assignPolicy.
     */
    public void setAssignPolicy(String  assignPolicy) {
        this.assignPolicy = assignPolicy;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enum options - ASSIGN_ALL, ASSIGN_FROM_SELECT_LIST, ASSIGN_MATCHING_GROUP_NAME, ASSIGN_MATCHING_ATTRIBUTE_VALUE, ASSIGN_MATCHING_GROUP_REGEX,
     * ASSIGN_MATCHING_ATTRIBUTE_REGEX.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return assignRole
     */
    public String getAssignRole() {
        return assignRole;
    }

    /**
     * This is the setter method to the attribute.
     * Enum options - ASSIGN_ALL, ASSIGN_FROM_SELECT_LIST, ASSIGN_MATCHING_GROUP_NAME, ASSIGN_MATCHING_ATTRIBUTE_VALUE, ASSIGN_MATCHING_GROUP_REGEX,
     * ASSIGN_MATCHING_ATTRIBUTE_REGEX.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param assignRole set the assignRole.
     */
    public void setAssignRole(String  assignRole) {
        this.assignRole = assignRole;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enum options - ASSIGN_ALL, ASSIGN_FROM_SELECT_LIST, ASSIGN_MATCHING_GROUP_NAME, ASSIGN_MATCHING_ATTRIBUTE_VALUE, ASSIGN_MATCHING_GROUP_REGEX,
     * ASSIGN_MATCHING_ATTRIBUTE_REGEX.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return assignTenant
     */
    public String getAssignTenant() {
        return assignTenant;
    }

    /**
     * This is the setter method to the attribute.
     * Enum options - ASSIGN_ALL, ASSIGN_FROM_SELECT_LIST, ASSIGN_MATCHING_GROUP_NAME, ASSIGN_MATCHING_ATTRIBUTE_VALUE, ASSIGN_MATCHING_GROUP_REGEX,
     * ASSIGN_MATCHING_ATTRIBUTE_REGEX.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param assignTenant set the assignTenant.
     */
    public void setAssignTenant(String  assignTenant) {
        this.assignTenant = assignTenant;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Assignment rule for the user account profile.
     * Enum options - ASSIGN_ALL, ASSIGN_FROM_SELECT_LIST, ASSIGN_MATCHING_GROUP_NAME, ASSIGN_MATCHING_ATTRIBUTE_VALUE, ASSIGN_MATCHING_GROUP_REGEX,
     * ASSIGN_MATCHING_ATTRIBUTE_REGEX.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return assignUserprofile
     */
    public String getAssignUserprofile() {
        return assignUserprofile;
    }

    /**
     * This is the setter method to the attribute.
     * Assignment rule for the user account profile.
     * Enum options - ASSIGN_ALL, ASSIGN_FROM_SELECT_LIST, ASSIGN_MATCHING_GROUP_NAME, ASSIGN_MATCHING_ATTRIBUTE_VALUE, ASSIGN_MATCHING_GROUP_REGEX,
     * ASSIGN_MATCHING_ATTRIBUTE_REGEX.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param assignUserprofile set the assignUserprofile.
     */
    public void setAssignUserprofile(String  assignUserprofile) {
        this.assignUserprofile = assignUserprofile;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property attribute_match of obj type authmappingrule field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return attributeMatch
     */
    public AuthMatchAttribute getAttributeMatch() {
        return attributeMatch;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property attribute_match of obj type authmappingrule field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param attributeMatch set the attributeMatch.
     */
    public void setAttributeMatch(AuthMatchAttribute attributeMatch) {
        this.attributeMatch = attributeMatch;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property group_match of obj type authmappingrule field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return groupMatch
     */
    public AuthMatchGroupMembership getGroupMatch() {
        return groupMatch;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property group_match of obj type authmappingrule field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param groupMatch set the groupMatch.
     */
    public void setGroupMatch(AuthMatchGroupMembership groupMatch) {
        this.groupMatch = groupMatch;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property index of obj type authmappingrule field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property index of obj type authmappingrule field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param index set the index.
     */
    public void setIndex(Integer  index) {
        this.index = index;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property is_superuser of obj type authmappingrule field type str  type boolean.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return isSuperuser
     */
    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property is_superuser of obj type authmappingrule field type str  type boolean.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param isSuperuser set the isSuperuser.
     */
    public void setIsSuperuser(Boolean  isSuperuser) {
        this.isSuperuser = isSuperuser;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Object access policies to assign to user on successful match.
     * It is a reference to an object of type objectaccesspolicy.
     * Field deprecated in 20.1.2.
     * Field introduced in 18.2.7, 20.1.1.
     * @return objectAccessPolicyRefs
     */
    public List<String> getObjectAccessPolicyRefs() {
        return objectAccessPolicyRefs;
    }

    /**
     * This is the setter method. this will set the objectAccessPolicyRefs
     * Object access policies to assign to user on successful match.
     * It is a reference to an object of type objectaccesspolicy.
     * Field deprecated in 20.1.2.
     * Field introduced in 18.2.7, 20.1.1.
     * @return objectAccessPolicyRefs
     */
    public void setObjectAccessPolicyRefs(List<String>  objectAccessPolicyRefs) {
        this.objectAccessPolicyRefs = objectAccessPolicyRefs;
    }

    /**
     * This is the setter method this will set the objectAccessPolicyRefs
     * Object access policies to assign to user on successful match.
     * It is a reference to an object of type objectaccesspolicy.
     * Field deprecated in 20.1.2.
     * Field introduced in 18.2.7, 20.1.1.
     * @return objectAccessPolicyRefs
     */
    public AuthMappingRule addObjectAccessPolicyRefsItem(String objectAccessPolicyRefsItem) {
      if (this.objectAccessPolicyRefs == null) {
        this.objectAccessPolicyRefs = new ArrayList<String>();
      }
      this.objectAccessPolicyRefs.add(objectAccessPolicyRefsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Attribute name for object access policy assignment.
     * Field introduced in 18.2.7, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return policyAttributeName
     */
    public String getPolicyAttributeName() {
        return policyAttributeName;
    }

    /**
     * This is the setter method to the attribute.
     * Attribute name for object access policy assignment.
     * Field introduced in 18.2.7, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param policyAttributeName set the policyAttributeName.
     */
    public void setPolicyAttributeName(String  policyAttributeName) {
        this.policyAttributeName = policyAttributeName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property role_attribute_name of obj type authmappingrule field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return roleAttributeName
     */
    public String getRoleAttributeName() {
        return roleAttributeName;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property role_attribute_name of obj type authmappingrule field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param roleAttributeName set the roleAttributeName.
     */
    public void setRoleAttributeName(String  roleAttributeName) {
        this.roleAttributeName = roleAttributeName;
    }
    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type role.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return roleRefs
     */
    public List<String> getRoleRefs() {
        return roleRefs;
    }

    /**
     * This is the setter method. this will set the roleRefs
     * It is a reference to an object of type role.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return roleRefs
     */
    public void setRoleRefs(List<String>  roleRefs) {
        this.roleRefs = roleRefs;
    }

    /**
     * This is the setter method this will set the roleRefs
     * It is a reference to an object of type role.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return roleRefs
     */
    public AuthMappingRule addRoleRefsItem(String roleRefsItem) {
      if (this.roleRefs == null) {
        this.roleRefs = new ArrayList<String>();
      }
      this.roleRefs.add(roleRefsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property tenant_attribute_name of obj type authmappingrule field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantAttributeName
     */
    public String getTenantAttributeName() {
        return tenantAttributeName;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property tenant_attribute_name of obj type authmappingrule field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param tenantAttributeName set the tenantAttributeName.
     */
    public void setTenantAttributeName(String  tenantAttributeName) {
        this.tenantAttributeName = tenantAttributeName;
    }
    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRefs
     */
    public List<String> getTenantRefs() {
        return tenantRefs;
    }

    /**
     * This is the setter method. this will set the tenantRefs
     * It is a reference to an object of type tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRefs
     */
    public void setTenantRefs(List<String>  tenantRefs) {
        this.tenantRefs = tenantRefs;
    }

    /**
     * This is the setter method this will set the tenantRefs
     * It is a reference to an object of type tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRefs
     */
    public AuthMappingRule addTenantRefsItem(String tenantRefsItem) {
      if (this.tenantRefs == null) {
        this.tenantRefs = new ArrayList<String>();
      }
      this.tenantRefs.add(tenantRefsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Attribute name for user account profile assignment.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return userprofileAttributeName
     */
    public String getUserprofileAttributeName() {
        return userprofileAttributeName;
    }

    /**
     * This is the setter method to the attribute.
     * Attribute name for user account profile assignment.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param userprofileAttributeName set the userprofileAttributeName.
     */
    public void setUserprofileAttributeName(String  userprofileAttributeName) {
        this.userprofileAttributeName = userprofileAttributeName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * User account profile to assign to user on successful match.
     * It is a reference to an object of type useraccountprofile.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return userprofileRef
     */
    public String getUserprofileRef() {
        return userprofileRef;
    }

    /**
     * This is the setter method to the attribute.
     * User account profile to assign to user on successful match.
     * It is a reference to an object of type useraccountprofile.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param userprofileRef set the userprofileRef.
     */
    public void setUserprofileRef(String  userprofileRef) {
        this.userprofileRef = userprofileRef;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      AuthMappingRule objAuthMappingRule = (AuthMappingRule) o;
      return   Objects.equals(this.index, objAuthMappingRule.index)&&
  Objects.equals(this.groupMatch, objAuthMappingRule.groupMatch)&&
  Objects.equals(this.attributeMatch, objAuthMappingRule.attributeMatch)&&
  Objects.equals(this.assignTenant, objAuthMappingRule.assignTenant)&&
  Objects.equals(this.tenantAttributeName, objAuthMappingRule.tenantAttributeName)&&
  Objects.equals(this.tenantRefs, objAuthMappingRule.tenantRefs)&&
  Objects.equals(this.assignRole, objAuthMappingRule.assignRole)&&
  Objects.equals(this.roleAttributeName, objAuthMappingRule.roleAttributeName)&&
  Objects.equals(this.roleRefs, objAuthMappingRule.roleRefs)&&
  Objects.equals(this.isSuperuser, objAuthMappingRule.isSuperuser)&&
  Objects.equals(this.assignPolicy, objAuthMappingRule.assignPolicy)&&
  Objects.equals(this.policyAttributeName, objAuthMappingRule.policyAttributeName)&&
  Objects.equals(this.objectAccessPolicyRefs, objAuthMappingRule.objectAccessPolicyRefs)&&
  Objects.equals(this.assignUserprofile, objAuthMappingRule.assignUserprofile)&&
  Objects.equals(this.userprofileAttributeName, objAuthMappingRule.userprofileAttributeName)&&
  Objects.equals(this.userprofileRef, objAuthMappingRule.userprofileRef);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AuthMappingRule {\n");
                  sb.append("    assignPolicy: ").append(toIndentedString(assignPolicy)).append("\n");
                        sb.append("    assignRole: ").append(toIndentedString(assignRole)).append("\n");
                        sb.append("    assignTenant: ").append(toIndentedString(assignTenant)).append("\n");
                        sb.append("    assignUserprofile: ").append(toIndentedString(assignUserprofile)).append("\n");
                        sb.append("    attributeMatch: ").append(toIndentedString(attributeMatch)).append("\n");
                        sb.append("    groupMatch: ").append(toIndentedString(groupMatch)).append("\n");
                        sb.append("    index: ").append(toIndentedString(index)).append("\n");
                        sb.append("    isSuperuser: ").append(toIndentedString(isSuperuser)).append("\n");
                        sb.append("    objectAccessPolicyRefs: ").append(toIndentedString(objectAccessPolicyRefs)).append("\n");
                        sb.append("    policyAttributeName: ").append(toIndentedString(policyAttributeName)).append("\n");
                        sb.append("    roleAttributeName: ").append(toIndentedString(roleAttributeName)).append("\n");
                        sb.append("    roleRefs: ").append(toIndentedString(roleRefs)).append("\n");
                        sb.append("    tenantAttributeName: ").append(toIndentedString(tenantAttributeName)).append("\n");
                        sb.append("    tenantRefs: ").append(toIndentedString(tenantRefs)).append("\n");
                        sb.append("    userprofileAttributeName: ").append(toIndentedString(userprofileAttributeName)).append("\n");
                        sb.append("    userprofileRef: ").append(toIndentedString(userprofileRef)).append("\n");
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
