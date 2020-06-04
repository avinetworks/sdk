/*
 * Avi avi_global_spec Object API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 20.1.1
 * Contact: support@avinetworks.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.vmware.avi.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vmware.avi.sdk.model.PGDeploymentRule;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * PoolGroupDeploymentPolicy
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-12T12:27:26.755+05:30[Asia/Kolkata]")
public class PoolGroupDeploymentPolicy {
  @JsonProperty("_last_modified")
  private String _lastModified = null;

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
  private String url = null;

  @JsonProperty("uuid")
  private String uuid = null;

  @JsonProperty("webhook_ref")
  private String webhookRef = null;

   /**
   * UNIX time since epoch in microseconds. Units(MICROSECONDS).
   * @return _lastModified
  **/
  @Schema(description = "UNIX time since epoch in microseconds. Units(MICROSECONDS).")
  public String getLastModified() {
    return _lastModified;
  }

  public PoolGroupDeploymentPolicy autoDisableOldProdPools(Boolean autoDisableOldProdPools) {
    this.autoDisableOldProdPools = autoDisableOldProdPools;
    return this;
  }

   /**
   * It will automatically disable old production pools once there is a new production candidate.
   * @return autoDisableOldProdPools
  **/
  @Schema(description = "It will automatically disable old production pools once there is a new production candidate.")
  public Boolean isAutoDisableOldProdPools() {
    return autoDisableOldProdPools;
  }

  public void setAutoDisableOldProdPools(Boolean autoDisableOldProdPools) {
    this.autoDisableOldProdPools = autoDisableOldProdPools;
  }

  public PoolGroupDeploymentPolicy description(String description) {
    this.description = description;
    return this;
  }

   /**
   * User defined description for the object.
   * @return description
  **/
  @Schema(description = "User defined description for the object.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PoolGroupDeploymentPolicy evaluationDuration(Integer evaluationDuration) {
    this.evaluationDuration = evaluationDuration;
    return this;
  }

   /**
   * Duration of evaluation period for automatic deployment. Allowed values are 60-86400.
   * @return evaluationDuration
  **/
  @Schema(description = "Duration of evaluation period for automatic deployment. Allowed values are 60-86400.")
  public Integer getEvaluationDuration() {
    return evaluationDuration;
  }

  public void setEvaluationDuration(Integer evaluationDuration) {
    this.evaluationDuration = evaluationDuration;
  }

  public PoolGroupDeploymentPolicy name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the pool group deployment policy.
   * @return name
  **/
  @Schema(required = true, description = "The name of the pool group deployment policy.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PoolGroupDeploymentPolicy rules(List<PGDeploymentRule> rules) {
    this.rules = rules;
    return this;
  }

  public PoolGroupDeploymentPolicy addRulesItem(PGDeploymentRule rulesItem) {
    if (this.rules == null) {
      this.rules = new ArrayList<PGDeploymentRule>();
    }
    this.rules.add(rulesItem);
    return this;
  }

   /**
   * Placeholder for description of property rules of obj type PoolGroupDeploymentPolicy field type str  type object
   * @return rules
  **/
  @Schema(description = "Placeholder for description of property rules of obj type PoolGroupDeploymentPolicy field type str  type object")
  public List<PGDeploymentRule> getRules() {
    return rules;
  }

  public void setRules(List<PGDeploymentRule> rules) {
    this.rules = rules;
  }

  public PoolGroupDeploymentPolicy scheme(String scheme) {
    this.scheme = scheme;
    return this;
  }

   /**
   * deployment scheme. Enum options - BLUE_GREEN, CANARY.
   * @return scheme
  **/
  @Schema(description = "deployment scheme. Enum options - BLUE_GREEN, CANARY.")
  public String getScheme() {
    return scheme;
  }

  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  public PoolGroupDeploymentPolicy targetTestTrafficRatio(Integer targetTestTrafficRatio) {
    this.targetTestTrafficRatio = targetTestTrafficRatio;
    return this;
  }

   /**
   * Target traffic ratio before pool is made production. Allowed values are 1-100.
   * @return targetTestTrafficRatio
  **/
  @Schema(description = "Target traffic ratio before pool is made production. Allowed values are 1-100.")
  public Integer getTargetTestTrafficRatio() {
    return targetTestTrafficRatio;
  }

  public void setTargetTestTrafficRatio(Integer targetTestTrafficRatio) {
    this.targetTestTrafficRatio = targetTestTrafficRatio;
  }

  public PoolGroupDeploymentPolicy tenantRef(String tenantRef) {
    this.tenantRef = tenantRef;
    return this;
  }

   /**
   *  It is a reference to an object of type Tenant.
   * @return tenantRef
  **/
  @Schema(description = " It is a reference to an object of type Tenant.")
  public String getTenantRef() {
    return tenantRef;
  }

  public void setTenantRef(String tenantRef) {
    this.tenantRef = tenantRef;
  }

  public PoolGroupDeploymentPolicy testTrafficRatioRampup(Integer testTrafficRatioRampup) {
    this.testTrafficRatioRampup = testTrafficRatioRampup;
    return this;
  }

   /**
   * Ratio of the traffic that is sent to the pool under test. test ratio of 100 means blue green. Allowed values are 1-100.
   * @return testTrafficRatioRampup
  **/
  @Schema(description = "Ratio of the traffic that is sent to the pool under test. test ratio of 100 means blue green. Allowed values are 1-100.")
  public Integer getTestTrafficRatioRampup() {
    return testTrafficRatioRampup;
  }

  public void setTestTrafficRatioRampup(Integer testTrafficRatioRampup) {
    this.testTrafficRatioRampup = testTrafficRatioRampup;
  }

   /**
   * url
   * @return url
  **/
  @Schema(description = "url")
  public String getUrl() {
    return url;
  }

  public PoolGroupDeploymentPolicy uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * UUID of the pool group deployment policy.
   * @return uuid
  **/
  @Schema(description = "UUID of the pool group deployment policy.")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public PoolGroupDeploymentPolicy webhookRef(String webhookRef) {
    this.webhookRef = webhookRef;
    return this;
  }

   /**
   * Webhook configured with URL that Avi controller will pass back information about pool group, old and new pool information and current deployment rule results. It is a reference to an object of type Webhook. Field introduced in 17.1.1.
   * @return webhookRef
  **/
  @Schema(description = "Webhook configured with URL that Avi controller will pass back information about pool group, old and new pool information and current deployment rule results. It is a reference to an object of type Webhook. Field introduced in 17.1.1.")
  public String getWebhookRef() {
    return webhookRef;
  }

  public void setWebhookRef(String webhookRef) {
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
    PoolGroupDeploymentPolicy poolGroupDeploymentPolicy = (PoolGroupDeploymentPolicy) o;
    return Objects.equals(this._lastModified, poolGroupDeploymentPolicy._lastModified) &&
        Objects.equals(this.autoDisableOldProdPools, poolGroupDeploymentPolicy.autoDisableOldProdPools) &&
        Objects.equals(this.description, poolGroupDeploymentPolicy.description) &&
        Objects.equals(this.evaluationDuration, poolGroupDeploymentPolicy.evaluationDuration) &&
        Objects.equals(this.name, poolGroupDeploymentPolicy.name) &&
        Objects.equals(this.rules, poolGroupDeploymentPolicy.rules) &&
        Objects.equals(this.scheme, poolGroupDeploymentPolicy.scheme) &&
        Objects.equals(this.targetTestTrafficRatio, poolGroupDeploymentPolicy.targetTestTrafficRatio) &&
        Objects.equals(this.tenantRef, poolGroupDeploymentPolicy.tenantRef) &&
        Objects.equals(this.testTrafficRatioRampup, poolGroupDeploymentPolicy.testTrafficRatioRampup) &&
        Objects.equals(this.url, poolGroupDeploymentPolicy.url) &&
        Objects.equals(this.uuid, poolGroupDeploymentPolicy.uuid) &&
        Objects.equals(this.webhookRef, poolGroupDeploymentPolicy.webhookRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_lastModified, autoDisableOldProdPools, description, evaluationDuration, name, rules, scheme, targetTestTrafficRatio, tenantRef, testTrafficRatioRampup, url, uuid, webhookRef);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PoolGroupDeploymentPolicy {\n");
    
    sb.append("    _lastModified: ").append(toIndentedString(_lastModified)).append("\n");
    sb.append("    autoDisableOldProdPools: ").append(toIndentedString(autoDisableOldProdPools)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    evaluationDuration: ").append(toIndentedString(evaluationDuration)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
    sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
    sb.append("    targetTestTrafficRatio: ").append(toIndentedString(targetTestTrafficRatio)).append("\n");
    sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
    sb.append("    testTrafficRatioRampup: ").append(toIndentedString(testTrafficRatioRampup)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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