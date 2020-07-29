package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PoolGroup is a POJO class extends AviRestResource that used for creating
 * PoolGroup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PoolGroup extends AviRestResource  {
    @JsonProperty("cloud_config_cksum")
    private String cloudConfigCksum = null;

    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("deployment_policy_ref")
    private String deploymentPolicyRef = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("enable_http2")
    private Boolean enableHttp2 = false;

    @JsonProperty("fail_action")
    private FailAction failAction = null;

    @JsonProperty("implicit_priority_labels")
    private Boolean implicitPriorityLabels = false;

    @JsonProperty("members")
    private List<PoolGroupMember> members = null;

    @JsonProperty("min_servers")
    private Integer minServers = 0;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("priority_labels_ref")
    private String priorityLabelsRef = null;

    @JsonProperty("service_metadata")
    private String serviceMetadata = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Checksum of cloud configuration for poolgroup.
   * Internally set by cloud connector.
   * @return cloudConfigCksum
   */
  public String getCloudConfigCksum() {
    return cloudConfigCksum;
  }

  /**
   * This is the setter method to the attribute.
   * Checksum of cloud configuration for poolgroup.
   * Internally set by cloud connector.
   * @param cloudConfigCksum set the cloudConfigCksum.
   */
  public void setCloudConfigCksum(String  cloudConfigCksum) {
    this.cloudConfigCksum = cloudConfigCksum;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type cloud.
   * @return cloudRef
   */
  public String getCloudRef() {
    return cloudRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type cloud.
   * @param cloudRef set the cloudRef.
   */
  public void setCloudRef(String  cloudRef) {
    this.cloudRef = cloudRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the user who created the object.
   * @return createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the user who created the object.
   * @param createdBy set the createdBy.
   */
  public void setCreatedBy(String  createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When setup autoscale manager will automatically promote new pools into production when deployment goals are met.
   * It is a reference to an object of type poolgroupdeploymentpolicy.
   * @return deploymentPolicyRef
   */
  public String getDeploymentPolicyRef() {
    return deploymentPolicyRef;
  }

  /**
   * This is the setter method to the attribute.
   * When setup autoscale manager will automatically promote new pools into production when deployment goals are met.
   * It is a reference to an object of type poolgroupdeploymentpolicy.
   * @param deploymentPolicyRef set the deploymentPolicyRef.
   */
  public void setDeploymentPolicyRef(String  deploymentPolicyRef) {
    this.deploymentPolicyRef = deploymentPolicyRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Description of pool group.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * Description of pool group.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable http/2 for traffic from virtualservice to all the backend servers in all the pools configured under this poolgroup.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableHttp2
   */
  public Boolean getEnableHttp2() {
    return enableHttp2;
  }

  /**
   * This is the setter method to the attribute.
   * Enable http/2 for traffic from virtualservice to all the backend servers in all the pools configured under this poolgroup.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableHttp2 set the enableHttp2.
   */
  public void setEnableHttp2(Boolean  enableHttp2) {
    this.enableHttp2 = enableHttp2;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable an action - close connection, http redirect, or local http response - when a pool group failure happens.
   * By default, a connection will be closed, in case the pool group experiences a failure.
   * @return failAction
   */
  public FailAction getFailAction() {
    return failAction;
  }

  /**
   * This is the setter method to the attribute.
   * Enable an action - close connection, http redirect, or local http response - when a pool group failure happens.
   * By default, a connection will be closed, in case the pool group experiences a failure.
   * @param failAction set the failAction.
   */
  public void setFailAction(FailAction failAction) {
    this.failAction = failAction;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Whether an implicit set of priority labels is generated.
   * Field introduced in 17.1.9,17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return implicitPriorityLabels
   */
  public Boolean getImplicitPriorityLabels() {
    return implicitPriorityLabels;
  }

  /**
   * This is the setter method to the attribute.
   * Whether an implicit set of priority labels is generated.
   * Field introduced in 17.1.9,17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param implicitPriorityLabels set the implicitPriorityLabels.
   */
  public void setImplicitPriorityLabels(Boolean  implicitPriorityLabels) {
    this.implicitPriorityLabels = implicitPriorityLabels;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of pool group members object of type poolgroupmember.
   * @return members
   */
  public List<PoolGroupMember> getMembers() {
    return members;
  }

  /**
   * This is the setter method. this will set the members
   * List of pool group members object of type poolgroupmember.
   * @return members
   */
  public void setMembers(List<PoolGroupMember>  members) {
    this.members = members;
  }

  /**
   * This is the setter method this will set the members
   * List of pool group members object of type poolgroupmember.
   * @return members
   */
  public PoolGroup addMembersItem(PoolGroupMember membersItem) {
    if (this.members == null) {
      this.members = new ArrayList<PoolGroupMember>();
    }
    this.members.add(membersItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The minimum number of servers to distribute traffic to.
   * Allowed values are 1-65535.
   * Special values are 0 - 'disable'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return minServers
   */
  public Integer getMinServers() {
    return minServers;
  }

  /**
   * This is the setter method to the attribute.
   * The minimum number of servers to distribute traffic to.
   * Allowed values are 1-65535.
   * Special values are 0 - 'disable'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param minServers set the minServers.
   */
  public void setMinServers(Integer  minServers) {
    this.minServers = minServers;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The name of the pool group.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * The name of the pool group.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the priority labels.
   * If not provided, pool group member priority label will be interpreted as a number with a larger number considered higher priority.
   * It is a reference to an object of type prioritylabels.
   * @return priorityLabelsRef
   */
  public String getPriorityLabelsRef() {
    return priorityLabelsRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the priority labels.
   * If not provided, pool group member priority label will be interpreted as a number with a larger number considered higher priority.
   * It is a reference to an object of type prioritylabels.
   * @param priorityLabelsRef set the priorityLabelsRef.
   */
  public void setPriorityLabelsRef(String  priorityLabelsRef) {
    this.priorityLabelsRef = priorityLabelsRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Metadata pertaining to the service provided by this poolgroup.
   * In openshift/kubernetes environments, app metadata info is stored.
   * Any user input to this field will be overwritten by avi vantage.
   * Field introduced in 17.2.14,18.1.5,18.2.1.
   * @return serviceMetadata
   */
  public String getServiceMetadata() {
    return serviceMetadata;
  }

  /**
   * This is the setter method to the attribute.
   * Metadata pertaining to the service provided by this poolgroup.
   * In openshift/kubernetes environments, app metadata info is stored.
   * Any user input to this field will be overwritten by avi vantage.
   * Field introduced in 17.2.14,18.1.5,18.2.1.
   * @param serviceMetadata set the serviceMetadata.
   */
  public void setServiceMetadata(String  serviceMetadata) {
    this.serviceMetadata = serviceMetadata;
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
   * Uuid of the pool group.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the pool group.
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
  PoolGroup objPoolGroup = (PoolGroup) o;
  return   Objects.equals(this.uuid, objPoolGroup.uuid)&&
  Objects.equals(this.name, objPoolGroup.name)&&
  Objects.equals(this.members, objPoolGroup.members)&&
  Objects.equals(this.priorityLabelsRef, objPoolGroup.priorityLabelsRef)&&
  Objects.equals(this.minServers, objPoolGroup.minServers)&&
  Objects.equals(this.deploymentPolicyRef, objPoolGroup.deploymentPolicyRef)&&
  Objects.equals(this.failAction, objPoolGroup.failAction)&&
  Objects.equals(this.implicitPriorityLabels, objPoolGroup.implicitPriorityLabels)&&
  Objects.equals(this.serviceMetadata, objPoolGroup.serviceMetadata)&&
  Objects.equals(this.createdBy, objPoolGroup.createdBy)&&
  Objects.equals(this.cloudConfigCksum, objPoolGroup.cloudConfigCksum)&&
  Objects.equals(this.description, objPoolGroup.description)&&
  Objects.equals(this.tenantRef, objPoolGroup.tenantRef)&&
  Objects.equals(this.cloudRef, objPoolGroup.cloudRef)&&
  Objects.equals(this.enableHttp2, objPoolGroup.enableHttp2);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PoolGroup {\n");
      sb.append("    cloudConfigCksum: ").append(toIndentedString(cloudConfigCksum)).append("\n");
        sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    deploymentPolicyRef: ").append(toIndentedString(deploymentPolicyRef)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    enableHttp2: ").append(toIndentedString(enableHttp2)).append("\n");
        sb.append("    failAction: ").append(toIndentedString(failAction)).append("\n");
        sb.append("    implicitPriorityLabels: ").append(toIndentedString(implicitPriorityLabels)).append("\n");
        sb.append("    members: ").append(toIndentedString(members)).append("\n");
        sb.append("    minServers: ").append(toIndentedString(minServers)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    priorityLabelsRef: ").append(toIndentedString(priorityLabelsRef)).append("\n");
        sb.append("    serviceMetadata: ").append(toIndentedString(serviceMetadata)).append("\n");
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

