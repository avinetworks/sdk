package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The HTTPPolicySet is a POJO class extends AviRestResource that used for creating
 * HTTPPolicySet.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPPolicySet extends AviRestResource  {
    @JsonProperty("cloud_config_cksum")
    private String cloudConfigCksum = null;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("geo_db_ref")
    private String geoDbRef = null;

    @JsonProperty("http_request_policy")
    private HTTPRequestPolicy httpRequestPolicy = null;

    @JsonProperty("http_response_policy")
    private HTTPResponsePolicy httpResponsePolicy = null;

    @JsonProperty("http_security_policy")
    private HTTPSecurityPolicy httpSecurityPolicy = null;

    @JsonProperty("ip_reputation_db_ref")
    private String ipReputationDbRef = null;

    @JsonProperty("is_internal_policy")
    private Boolean isInternalPolicy = false;

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
     * Checksum of cloud configuration for pool.
     * Internally set by cloud connector.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cloudConfigCksum
     */
    public String getCloudConfigCksum() {
        return cloudConfigCksum;
    }

    /**
     * This is the setter method to the attribute.
     * Checksum of cloud configuration for pool.
     * Internally set by cloud connector.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param cloudConfigCksum set the cloudConfigCksum.
     */
    public void setCloudConfigCksum(String  cloudConfigCksum) {
        this.cloudConfigCksum = cloudConfigCksum;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Creator name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This is the setter method to the attribute.
     * Creator name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param createdBy set the createdBy.
     */
    public void setCreatedBy(String  createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This is the getter method this will return the attribute value.
     * User defined description for the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the setter method to the attribute.
     * User defined description for the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param description set the description.
     */
    public void setDescription(String  description) {
        this.description = description;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Geo database.
     * It is a reference to an object of type geodb.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return geoDbRef
     */
    public String getGeoDbRef() {
        return geoDbRef;
    }

    /**
     * This is the setter method to the attribute.
     * Geo database.
     * It is a reference to an object of type geodb.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param geoDbRef set the geoDbRef.
     */
    public void setGeoDbRef(String  geoDbRef) {
        this.geoDbRef = geoDbRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Http request policy for the virtual service.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return httpRequestPolicy
     */
    public HTTPRequestPolicy getHttpRequestPolicy() {
        return httpRequestPolicy;
    }

    /**
     * This is the setter method to the attribute.
     * Http request policy for the virtual service.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param httpRequestPolicy set the httpRequestPolicy.
     */
    public void setHttpRequestPolicy(HTTPRequestPolicy httpRequestPolicy) {
        this.httpRequestPolicy = httpRequestPolicy;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Http response policy for the virtual service.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return httpResponsePolicy
     */
    public HTTPResponsePolicy getHttpResponsePolicy() {
        return httpResponsePolicy;
    }

    /**
     * This is the setter method to the attribute.
     * Http response policy for the virtual service.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param httpResponsePolicy set the httpResponsePolicy.
     */
    public void setHttpResponsePolicy(HTTPResponsePolicy httpResponsePolicy) {
        this.httpResponsePolicy = httpResponsePolicy;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Http security policy for the virtual service.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return httpSecurityPolicy
     */
    public HTTPSecurityPolicy getHttpSecurityPolicy() {
        return httpSecurityPolicy;
    }

    /**
     * This is the setter method to the attribute.
     * Http security policy for the virtual service.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param httpSecurityPolicy set the httpSecurityPolicy.
     */
    public void setHttpSecurityPolicy(HTTPSecurityPolicy httpSecurityPolicy) {
        this.httpSecurityPolicy = httpSecurityPolicy;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Ip reputation database.
     * It is a reference to an object of type ipreputationdb.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ipReputationDbRef
     */
    public String getIpReputationDbRef() {
        return ipReputationDbRef;
    }

    /**
     * This is the setter method to the attribute.
     * Ip reputation database.
     * It is a reference to an object of type ipreputationdb.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ipReputationDbRef set the ipReputationDbRef.
     */
    public void setIpReputationDbRef(String  ipReputationDbRef) {
        this.ipReputationDbRef = ipReputationDbRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property is_internal_policy of obj type httppolicyset field type str  type boolean.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return isInternalPolicy
     */
    public Boolean getIsInternalPolicy() {
        return isInternalPolicy;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property is_internal_policy of obj type httppolicyset field type str  type boolean.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param isInternalPolicy set the isInternalPolicy.
     */
    public void setIsInternalPolicy(Boolean  isInternalPolicy) {
        this.isInternalPolicy = isInternalPolicy;
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
    public HTTPPolicySet addLabelsItem(KeyValue labelsItem) {
      if (this.labels == null) {
        this.labels = new ArrayList<KeyValue>();
      }
      this.labels.add(labelsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the http policy set.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the http policy set.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRef
     */
    public String getTenantRef() {
        return tenantRef;
    }

    /**
     * This is the setter method to the attribute.
     * It is a reference to an object of type tenant.
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
     * Uuid of the http policy set.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the http policy set.
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
      HTTPPolicySet objHTTPPolicySet = (HTTPPolicySet) o;
      return   Objects.equals(this.uuid, objHTTPPolicySet.uuid)&&
  Objects.equals(this.name, objHTTPPolicySet.name)&&
  Objects.equals(this.httpSecurityPolicy, objHTTPPolicySet.httpSecurityPolicy)&&
  Objects.equals(this.httpRequestPolicy, objHTTPPolicySet.httpRequestPolicy)&&
  Objects.equals(this.httpResponsePolicy, objHTTPPolicySet.httpResponsePolicy)&&
  Objects.equals(this.createdBy, objHTTPPolicySet.createdBy)&&
  Objects.equals(this.cloudConfigCksum, objHTTPPolicySet.cloudConfigCksum)&&
  Objects.equals(this.labels, objHTTPPolicySet.labels)&&
  Objects.equals(this.ipReputationDbRef, objHTTPPolicySet.ipReputationDbRef)&&
  Objects.equals(this.geoDbRef, objHTTPPolicySet.geoDbRef)&&
  Objects.equals(this.isInternalPolicy, objHTTPPolicySet.isInternalPolicy)&&
  Objects.equals(this.description, objHTTPPolicySet.description)&&
  Objects.equals(this.tenantRef, objHTTPPolicySet.tenantRef);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class HTTPPolicySet {\n");
                  sb.append("    cloudConfigCksum: ").append(toIndentedString(cloudConfigCksum)).append("\n");
                        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
                        sb.append("    description: ").append(toIndentedString(description)).append("\n");
                        sb.append("    geoDbRef: ").append(toIndentedString(geoDbRef)).append("\n");
                        sb.append("    httpRequestPolicy: ").append(toIndentedString(httpRequestPolicy)).append("\n");
                        sb.append("    httpResponsePolicy: ").append(toIndentedString(httpResponsePolicy)).append("\n");
                        sb.append("    httpSecurityPolicy: ").append(toIndentedString(httpSecurityPolicy)).append("\n");
                        sb.append("    ipReputationDbRef: ").append(toIndentedString(ipReputationDbRef)).append("\n");
                        sb.append("    isInternalPolicy: ").append(toIndentedString(isInternalPolicy)).append("\n");
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
