package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The L4PolicySet is a POJO class extends AviRestResource that used for creating
 * L4PolicySet.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class L4PolicySet extends AviRestResource  {
    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("is_internal_policy")
    private Boolean isInternalPolicy = false;

    @JsonProperty("l4_connection_policy")
    private L4ConnectionPolicy l4ConnectionPolicy = null;

    @JsonProperty("labels")
    private List<KeyValue> labels = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



    /**
     * This is the getter method this will return the attribute value.
     * Creator name.
     * Field introduced in 17.2.7.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This is the setter method to the attribute.
     * Creator name.
     * Field introduced in 17.2.7.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param createdBy set the createdBy.
     */
    public void setCreatedBy(String  createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 17.2.7.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 17.2.7.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param description set the description.
     */
    public void setDescription(String  description) {
        this.description = description;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 17.2.7.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return isInternalPolicy
     */
    public Boolean getIsInternalPolicy() {
        return isInternalPolicy;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 17.2.7.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param isInternalPolicy set the isInternalPolicy.
     */
    public void setIsInternalPolicy(Boolean  isInternalPolicy) {
        this.isInternalPolicy = isInternalPolicy;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Policy to apply when a new transport connection is setup.
     * Field introduced in 17.2.7.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return l4ConnectionPolicy
     */
    public L4ConnectionPolicy getL4ConnectionPolicy() {
        return l4ConnectionPolicy;
    }

    /**
     * This is the setter method to the attribute.
     * Policy to apply when a new transport connection is setup.
     * Field introduced in 17.2.7.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param l4ConnectionPolicy set the l4ConnectionPolicy.
     */
    public void setL4ConnectionPolicy(L4ConnectionPolicy l4ConnectionPolicy) {
        this.l4ConnectionPolicy = l4ConnectionPolicy;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Key value pairs for granular object access control.
     * Also allows for classification and tagging of similar objects.
     * Field introduced in 20.1.2.
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public L4PolicySet addLabelsItem(KeyValue labelsItem) {
      if (this.labels == null) {
        this.labels = new ArrayList<KeyValue>();
      }
      this.labels.add(labelsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the l4 policy set.
     * Field introduced in 17.2.7.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the l4 policy set.
     * Field introduced in 17.2.7.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type tenant.
     * Field introduced in 17.2.7.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRef
     */
    public String getTenantRef() {
        return tenantRef;
    }

    /**
     * This is the setter method to the attribute.
     * It is a reference to an object of type tenant.
     * Field introduced in 17.2.7.
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
     * Id of the l4 policy set.
     * Field introduced in 17.2.7.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Id of the l4 policy set.
     * Field introduced in 17.2.7.
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
      L4PolicySet objL4PolicySet = (L4PolicySet) o;
      return   Objects.equals(this.uuid, objL4PolicySet.uuid)&&
  Objects.equals(this.name, objL4PolicySet.name)&&
  Objects.equals(this.l4ConnectionPolicy, objL4PolicySet.l4ConnectionPolicy)&&
  Objects.equals(this.createdBy, objL4PolicySet.createdBy)&&
  Objects.equals(this.labels, objL4PolicySet.labels)&&
  Objects.equals(this.isInternalPolicy, objL4PolicySet.isInternalPolicy)&&
  Objects.equals(this.description, objL4PolicySet.description)&&
  Objects.equals(this.tenantRef, objL4PolicySet.tenantRef);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class L4PolicySet {\n");
                  sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
                        sb.append("    description: ").append(toIndentedString(description)).append("\n");
                        sb.append("    isInternalPolicy: ").append(toIndentedString(isInternalPolicy)).append("\n");
                        sb.append("    l4ConnectionPolicy: ").append(toIndentedString(l4ConnectionPolicy)).append("\n");
                        sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
