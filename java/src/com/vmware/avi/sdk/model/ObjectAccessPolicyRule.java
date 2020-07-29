package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ObjectAccessPolicyRule is a POJO class extends AviRestResource that used for creating
 * ObjectAccessPolicyRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectAccessPolicyRule  {
    @JsonProperty("matches")
    private List<ObjectAccessMatchTarget> matches = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("obj_types")
    private List<String> objTypes = null;

    @JsonProperty("privilege")
    private String privilege = null;


  /**
   * This is the getter method this will return the attribute value.
   * Match criteria for the rule.
   * Field introduced in 18.2.7, 20.1.1.
   * @return matches
   */
  public List<ObjectAccessMatchTarget> getMatches() {
    return matches;
  }

  /**
   * This is the setter method. this will set the matches
   * Match criteria for the rule.
   * Field introduced in 18.2.7, 20.1.1.
   * @return matches
   */
  public void setMatches(List<ObjectAccessMatchTarget>  matches) {
    this.matches = matches;
  }

  /**
   * This is the setter method this will set the matches
   * Match criteria for the rule.
   * Field introduced in 18.2.7, 20.1.1.
   * @return matches
   */
  public ObjectAccessPolicyRule addMatchesItem(ObjectAccessMatchTarget matchesItem) {
    if (this.matches == null) {
      this.matches = new ArrayList<ObjectAccessMatchTarget>();
    }
    this.matches.add(matchesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the rule.
   * Field introduced in 18.2.7, 20.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the rule.
   * Field introduced in 18.2.7, 20.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Object types that this rule applies to.
   * Enum options - VIRTUALSERVICE, POOL, HEALTHMONITOR, NETWORKPROFILE, APPLICATIONPROFILE, HTTPPOLICYSET, DNSPOLICY, SECURITYPOLICY, IPADDRGROUP,
   * STRINGGROUP, SSLPROFILE, SSLKEYANDCERTIFICATE, NETWORKSECURITYPOLICY, APPLICATIONPERSISTENCEPROFILE, ANALYTICSPROFILE, VSDATASCRIPTSET, TENANT,
   * PKIPROFILE, AUTHPROFILE, CLOUD...
   * Field introduced in 18.2.7, 20.1.1.
   * @return objTypes
   */
  public List<String> getObjTypes() {
    return objTypes;
  }

  /**
   * This is the setter method. this will set the objTypes
   * Object types that this rule applies to.
   * Enum options - VIRTUALSERVICE, POOL, HEALTHMONITOR, NETWORKPROFILE, APPLICATIONPROFILE, HTTPPOLICYSET, DNSPOLICY, SECURITYPOLICY, IPADDRGROUP,
   * STRINGGROUP, SSLPROFILE, SSLKEYANDCERTIFICATE, NETWORKSECURITYPOLICY, APPLICATIONPERSISTENCEPROFILE, ANALYTICSPROFILE, VSDATASCRIPTSET, TENANT,
   * PKIPROFILE, AUTHPROFILE, CLOUD...
   * Field introduced in 18.2.7, 20.1.1.
   * @return objTypes
   */
  public void setObjTypes(List<String>  objTypes) {
    this.objTypes = objTypes;
  }

  /**
   * This is the setter method this will set the objTypes
   * Object types that this rule applies to.
   * Enum options - VIRTUALSERVICE, POOL, HEALTHMONITOR, NETWORKPROFILE, APPLICATIONPROFILE, HTTPPOLICYSET, DNSPOLICY, SECURITYPOLICY, IPADDRGROUP,
   * STRINGGROUP, SSLPROFILE, SSLKEYANDCERTIFICATE, NETWORKSECURITYPOLICY, APPLICATIONPERSISTENCEPROFILE, ANALYTICSPROFILE, VSDATASCRIPTSET, TENANT,
   * PKIPROFILE, AUTHPROFILE, CLOUD...
   * Field introduced in 18.2.7, 20.1.1.
   * @return objTypes
   */
  public ObjectAccessPolicyRule addObjTypesItem(String objTypesItem) {
    if (this.objTypes == null) {
      this.objTypes = new ArrayList<String>();
    }
    this.objTypes.add(objTypesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Privilege granted for objects matched by the rule.
   * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
   * Field introduced in 18.2.7, 20.1.1.
   * @return privilege
   */
  public String getPrivilege() {
    return privilege;
  }

  /**
   * This is the setter method to the attribute.
   * Privilege granted for objects matched by the rule.
   * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
   * Field introduced in 18.2.7, 20.1.1.
   * @param privilege set the privilege.
   */
  public void setPrivilege(String  privilege) {
    this.privilege = privilege;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ObjectAccessPolicyRule objObjectAccessPolicyRule = (ObjectAccessPolicyRule) o;
  return   Objects.equals(this.name, objObjectAccessPolicyRule.name)&&
  Objects.equals(this.objTypes, objObjectAccessPolicyRule.objTypes)&&
  Objects.equals(this.matches, objObjectAccessPolicyRule.matches)&&
  Objects.equals(this.privilege, objObjectAccessPolicyRule.privilege);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ObjectAccessPolicyRule {\n");
      sb.append("    matches: ").append(toIndentedString(matches)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    objTypes: ").append(toIndentedString(objTypes)).append("\n");
        sb.append("    privilege: ").append(toIndentedString(privilege)).append("\n");
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

