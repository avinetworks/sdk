package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The NatPolicy is a POJO class extends AviRestResource that used for creating
 * NatPolicy.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NatPolicy extends AviRestResource  {
    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("labels")
    private List<KeyValue> labels = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("rules")
    private List<NatRule> rules = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



    /**
     * This is the getter method this will return the attribute value.
     * Creator name.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This is the setter method to the attribute.
     * Creator name.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param createdBy set the createdBy.
     */
    public void setCreatedBy(String  createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param description set the description.
     */
    public void setDescription(String  description) {
        this.description = description;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Key value pairs for granular object access control.
     * Also allows for classification and tagging of similar objects.
     * Field introduced in 20.1.2.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public List<KeyValue> getLabels() {
        return labels;
    }

    /**
     * This is the setter method. this will set the labels
     * Key value pairs for granular object access control.
     * Also allows for classification and tagging of similar objects.
     * Field introduced in 20.1.2.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public void setLabels(List<KeyValue>  labels) {
        this.labels = labels;
    }

    /**
     * This is the setter method this will set the labels
     * Key value pairs for granular object access control.
     * Also allows for classification and tagging of similar objects.
     * Field introduced in 20.1.2.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public NatPolicy addLabelsItem(KeyValue labelsItem) {
      if (this.labels == null) {
        this.labels = new ArrayList<KeyValue>();
      }
      this.labels.add(labelsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the nat policy.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the nat policy.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Nat policy rules.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return rules
     */
    public List<NatRule> getRules() {
        return rules;
    }

    /**
     * This is the setter method. this will set the rules
     * Nat policy rules.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return rules
     */
    public void setRules(List<NatRule>  rules) {
        this.rules = rules;
    }

    /**
     * This is the setter method this will set the rules
     * Nat policy rules.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return rules
     */
    public NatPolicy addRulesItem(NatRule rulesItem) {
      if (this.rules == null) {
        this.rules = new ArrayList<NatRule>();
      }
      this.rules.add(rulesItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type tenant.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRef
     */
    public String getTenantRef() {
        return tenantRef;
    }

    /**
     * This is the setter method to the attribute.
     * It is a reference to an object of type tenant.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Uuid of the nat policy.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the nat policy.
     * Field introduced in 18.2.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
      NatPolicy objNatPolicy = (NatPolicy) o;
      return   Objects.equals(this.uuid, objNatPolicy.uuid)&&
  Objects.equals(this.name, objNatPolicy.name)&&
  Objects.equals(this.rules, objNatPolicy.rules)&&
  Objects.equals(this.createdBy, objNatPolicy.createdBy)&&
  Objects.equals(this.labels, objNatPolicy.labels)&&
  Objects.equals(this.description, objNatPolicy.description)&&
  Objects.equals(this.tenantRef, objNatPolicy.tenantRef);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class NatPolicy {\n");
                  sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
                        sb.append("    description: ").append(toIndentedString(description)).append("\n");
                        sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
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
