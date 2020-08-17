package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PoolGroupDeploymentPolicy is a POJO class extends AviRestResource that used for creating
 * PoolGroupDeploymentPolicy.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PoolGroupDeploymentPolicy extends AviRestResource  {
    @JsonProperty("auto_disable_old_prod_pools")
    private Boolean autoDisableOldProdPools = true;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("evaluation_duration")
    private Integer evaluationDuration = 300;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("rules")
    private List<PGDeploymentRule> rules = null;

    @JsonProperty("scheme")
    private String scheme = "BLUE_GREEN";

    @JsonProperty("target_test_traffic_ratio")
    private Integer targetTestTrafficRatio = 100;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("test_traffic_ratio_rampup")
    private Integer testTrafficRatioRampup = 100;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("webhook_ref")
    private String webhookRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * It will automatically disable old production pools once there is a new production candidate.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return autoDisableOldProdPools
   */
  public Boolean getAutoDisableOldProdPools() {
    return autoDisableOldProdPools;
  }

  /**
   * This is the setter method to the attribute.
   * It will automatically disable old production pools once there is a new production candidate.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param autoDisableOldProdPools set the autoDisableOldProdPools.
   */
  public void setAutoDisableOldProdPools(Boolean  autoDisableOldProdPools) {
    this.autoDisableOldProdPools = autoDisableOldProdPools;
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
   * Duration of evaluation period for automatic deployment.
   * Allowed values are 60-86400.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @return evaluationDuration
   */
  public Integer getEvaluationDuration() {
    return evaluationDuration;
  }

  /**
   * This is the setter method to the attribute.
   * Duration of evaluation period for automatic deployment.
   * Allowed values are 60-86400.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @param evaluationDuration set the evaluationDuration.
   */
  public void setEvaluationDuration(Integer  evaluationDuration) {
    this.evaluationDuration = evaluationDuration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The name of the pool group deployment policy.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * The name of the pool group deployment policy.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rules of obj type poolgroupdeploymentpolicy field type str  type array.
   * @return rules
   */
  public List<PGDeploymentRule> getRules() {
    return rules;
  }

  /**
   * This is the setter method. this will set the rules
   * Placeholder for description of property rules of obj type poolgroupdeploymentpolicy field type str  type array.
   * @return rules
   */
  public void setRules(List<PGDeploymentRule>  rules) {
    this.rules = rules;
  }

  /**
   * This is the setter method this will set the rules
   * Placeholder for description of property rules of obj type poolgroupdeploymentpolicy field type str  type array.
   * @return rules
   */
  public PoolGroupDeploymentPolicy addRulesItem(PGDeploymentRule rulesItem) {
    if (this.rules == null) {
      this.rules = new ArrayList<PGDeploymentRule>();
    }
    this.rules.add(rulesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deployment scheme.
   * Enum options - BLUE_GREEN, CANARY.
   * Default value when not specified in API or module is interpreted by Avi Controller as BLUE_GREEN.
   * @return scheme
   */
  public String getScheme() {
    return scheme;
  }

  /**
   * This is the setter method to the attribute.
   * Deployment scheme.
   * Enum options - BLUE_GREEN, CANARY.
   * Default value when not specified in API or module is interpreted by Avi Controller as BLUE_GREEN.
   * @param scheme set the scheme.
   */
  public void setScheme(String  scheme) {
    this.scheme = scheme;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Target traffic ratio before pool is made production.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return targetTestTrafficRatio
   */
  public Integer getTargetTestTrafficRatio() {
    return targetTestTrafficRatio;
  }

  /**
   * This is the setter method to the attribute.
   * Target traffic ratio before pool is made production.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param targetTestTrafficRatio set the targetTestTrafficRatio.
   */
  public void setTargetTestTrafficRatio(Integer  targetTestTrafficRatio) {
    this.targetTestTrafficRatio = targetTestTrafficRatio;
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
   * Ratio of the traffic that is sent to the pool under test.
   * Test ratio of 100 means blue green.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return testTrafficRatioRampup
   */
  public Integer getTestTrafficRatioRampup() {
    return testTrafficRatioRampup;
  }

  /**
   * This is the setter method to the attribute.
   * Ratio of the traffic that is sent to the pool under test.
   * Test ratio of 100 means blue green.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param testTrafficRatioRampup set the testTrafficRatioRampup.
   */
  public void setTestTrafficRatioRampup(Integer  testTrafficRatioRampup) {
    this.testTrafficRatioRampup = testTrafficRatioRampup;
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
   * Uuid of the pool group deployment policy.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the pool group deployment policy.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Webhook configured with url that avi controller will pass back information about pool group, old and new pool information and current deployment
   * rule results.
   * It is a reference to an object of type webhook.
   * Field introduced in 17.1.1.
   * @return webhookRef
   */
  public String getWebhookRef() {
    return webhookRef;
  }

  /**
   * This is the setter method to the attribute.
   * Webhook configured with url that avi controller will pass back information about pool group, old and new pool information and current deployment
   * rule results.
   * It is a reference to an object of type webhook.
   * Field introduced in 17.1.1.
   * @param webhookRef set the webhookRef.
   */
  public void setWebhookRef(String  webhookRef) {
    this.webhookRef = webhookRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  PoolGroupDeploymentPolicy objPoolGroupDeploymentPolicy = (PoolGroupDeploymentPolicy) o;
  return   Objects.equals(this.uuid, objPoolGroupDeploymentPolicy.uuid)&&
  Objects.equals(this.name, objPoolGroupDeploymentPolicy.name)&&
  Objects.equals(this.scheme, objPoolGroupDeploymentPolicy.scheme)&&
  Objects.equals(this.testTrafficRatioRampup, objPoolGroupDeploymentPolicy.testTrafficRatioRampup)&&
  Objects.equals(this.rules, objPoolGroupDeploymentPolicy.rules)&&
  Objects.equals(this.webhookRef, objPoolGroupDeploymentPolicy.webhookRef)&&
  Objects.equals(this.evaluationDuration, objPoolGroupDeploymentPolicy.evaluationDuration)&&
  Objects.equals(this.targetTestTrafficRatio, objPoolGroupDeploymentPolicy.targetTestTrafficRatio)&&
  Objects.equals(this.autoDisableOldProdPools, objPoolGroupDeploymentPolicy.autoDisableOldProdPools)&&
  Objects.equals(this.description, objPoolGroupDeploymentPolicy.description)&&
  Objects.equals(this.tenantRef, objPoolGroupDeploymentPolicy.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PoolGroupDeploymentPolicy {\n");
      sb.append("    autoDisableOldProdPools: ").append(toIndentedString(autoDisableOldProdPools)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    evaluationDuration: ").append(toIndentedString(evaluationDuration)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
        sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
        sb.append("    targetTestTrafficRatio: ").append(toIndentedString(targetTestTrafficRatio)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    testTrafficRatioRampup: ").append(toIndentedString(testTrafficRatioRampup)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    webhookRef: ").append(toIndentedString(webhookRef)).append("\n");
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

