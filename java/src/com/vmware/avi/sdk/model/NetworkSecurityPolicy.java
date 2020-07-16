package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NetworkSecurityPolicy is a POJO class extends AviRestResource that used for creating
 * NetworkSecurityPolicy.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkSecurityPolicy extends AviRestResource  {
    @JsonProperty("cloud_config_cksum")
    private String cloudConfigCksum = null;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("ip_reputation_db_ref")
    private String ipReputationDbRef = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("rules")
    private List<NetworkSecurityRule> rules = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Checksum of cloud configuration for network sec policy.
   * Internally set by cloud connector.
   * @return cloudConfigCksum
   */
  public String getCloudConfigCksum() {
    return cloudConfigCksum;
  }

  /**
   * This is the setter method to the attribute.
   * Checksum of cloud configuration for network sec policy.
   * Internally set by cloud connector.
   * @param cloudConfigCksum set the cloudConfigCksum.
   */
  public void setCloudConfigCksum(String  cloudConfigCksum) {
    this.cloudConfigCksum = cloudConfigCksum;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Creator name.
   * @return createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * This is the setter method to the attribute.
   * Creator name.
   * @param createdBy set the createdBy.
   */
  public void setCreatedBy(String  createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User defined description for the object.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * User defined description for the object.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip reputation database.
   * It is a reference to an object of type ipreputationdb.
   * Field introduced in 20.1.1.
   * @return ipReputationDbRef
   */
  public String getIpReputationDbRef() {
    return ipReputationDbRef;
  }

  /**
   * This is the setter method to the attribute.
   * Ip reputation database.
   * It is a reference to an object of type ipreputationdb.
   * Field introduced in 20.1.1.
   * @param ipReputationDbRef set the ipReputationDbRef.
   */
  public void setIpReputationDbRef(String  ipReputationDbRef) {
    this.ipReputationDbRef = ipReputationDbRef;
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
   * Placeholder for description of property rules of obj type networksecuritypolicy field type str  type array.
   * @return rules
   */
  public List<NetworkSecurityRule> getRules() {
    return rules;
  }

  /**
   * This is the setter method. this will set the rules
   * Placeholder for description of property rules of obj type networksecuritypolicy field type str  type array.
   * @return rules
   */
  public void setRules(List<NetworkSecurityRule>  rules) {
    this.rules = rules;
  }

  /**
   * This is the setter method this will set the rules
   * Placeholder for description of property rules of obj type networksecuritypolicy field type str  type array.
   * @return rules
   */
  public NetworkSecurityPolicy addRulesItem(NetworkSecurityRule rulesItem) {
    if (this.rules == null) {
      this.rules = new ArrayList<NetworkSecurityRule>();
    }
    this.rules.add(rulesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
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
  NetworkSecurityPolicy objNetworkSecurityPolicy = (NetworkSecurityPolicy) o;
  return   Objects.equals(this.uuid, objNetworkSecurityPolicy.uuid)&&
  Objects.equals(this.description, objNetworkSecurityPolicy.description)&&
  Objects.equals(this.ipReputationDbRef, objNetworkSecurityPolicy.ipReputationDbRef)&&
  Objects.equals(this.createdBy, objNetworkSecurityPolicy.createdBy)&&
  Objects.equals(this.rules, objNetworkSecurityPolicy.rules)&&
  Objects.equals(this.cloudConfigCksum, objNetworkSecurityPolicy.cloudConfigCksum)&&
  Objects.equals(this.tenantRef, objNetworkSecurityPolicy.tenantRef)&&
  Objects.equals(this.name, objNetworkSecurityPolicy.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NetworkSecurityPolicy {\n");
      sb.append("    cloudConfigCksum: ").append(toIndentedString(cloudConfigCksum)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    ipReputationDbRef: ").append(toIndentedString(ipReputationDbRef)).append("\n");
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

