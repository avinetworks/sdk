package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ObjectAccessPolicy is a POJO class extends AviRestResource that used for creating
 * ObjectAccessPolicy.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectAccessPolicy extends AviRestResource  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("rules")
    private List<ObjectAccessPolicyRule> rules = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of the object access policy.
   * Field introduced in 18.2.7, 20.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object access policy.
   * Field introduced in 18.2.7, 20.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Rules which grant access to specific objects.
   * Field introduced in 18.2.7, 20.1.1.
   * @return rules
   */
  public List<ObjectAccessPolicyRule> getRules() {
    return rules;
  }

  /**
   * This is the setter method. this will set the rules
   * Rules which grant access to specific objects.
   * Field introduced in 18.2.7, 20.1.1.
   * @return rules
   */
  public void setRules(List<ObjectAccessPolicyRule>  rules) {
    this.rules = rules;
  }

  /**
   * This is the setter method this will set the rules
   * Rules which grant access to specific objects.
   * Field introduced in 18.2.7, 20.1.1.
   * @return rules
   */
  public ObjectAccessPolicy addRulesItem(ObjectAccessPolicyRule rulesItem) {
    if (this.rules == null) {
      this.rules = new ArrayList<ObjectAccessPolicyRule>();
    }
    this.rules.add(rulesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.7, 20.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.7, 20.1.1.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
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
   * Uuid of the object access policy.
   * Field introduced in 18.2.7, 20.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the object access policy.
   * Field introduced in 18.2.7, 20.1.1.
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
  ObjectAccessPolicy objObjectAccessPolicy = (ObjectAccessPolicy) o;
  return   Objects.equals(this.rules, objObjectAccessPolicy.rules)&&
  Objects.equals(this.tenantRef, objObjectAccessPolicy.tenantRef)&&
  Objects.equals(this.uuid, objObjectAccessPolicy.uuid)&&
  Objects.equals(this.name, objObjectAccessPolicy.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ObjectAccessPolicy {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
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

