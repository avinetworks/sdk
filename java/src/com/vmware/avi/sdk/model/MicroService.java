package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MicroService is a POJO class extends AviRestResource that used for creating
 * MicroService.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MicroService extends AviRestResource  {
    @JsonProperty("application_name")
    private String applicationName = null;

    @JsonProperty("cloud_config_cksum")
    private String cloudConfigCksum = null;

    @JsonProperty("containers")
    private List<MicroServiceContainer> containers = null;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("ip_list")
    private Boolean ipList = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("orchestrator_name")
    private String orchestratorName = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property application_name of obj type microservice field type str  type string.
   * @return applicationName
   */
  public String getApplicationName() {
    return applicationName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property application_name of obj type microservice field type str  type string.
   * @param applicationName set the applicationName.
   */
  public void setApplicationName(String  applicationName) {
    this.applicationName = applicationName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Checksum of cloud configuration for microservice.
   * Internally set by cloud connector.
   * Field introduced in 17.2.8.
   * @return cloudConfigCksum
   */
  public String getCloudConfigCksum() {
    return cloudConfigCksum;
  }

  /**
   * This is the setter method to the attribute.
   * Checksum of cloud configuration for microservice.
   * Internally set by cloud connector.
   * Field introduced in 17.2.8.
   * @param cloudConfigCksum set the cloudConfigCksum.
   */
  public void setCloudConfigCksum(String  cloudConfigCksum) {
    this.cloudConfigCksum = cloudConfigCksum;
  }
  /**
   * This is the getter method this will return the attribute value.
   * The list of containers for this microservice.
   * @return containers
   */
  public List<MicroServiceContainer> getContainers() {
    return containers;
  }

  /**
   * This is the setter method. this will set the containers
   * The list of containers for this microservice.
   * @return containers
   */
  public void setContainers(List<MicroServiceContainer>  containers) {
    this.containers = containers;
  }

  /**
   * This is the setter method this will set the containers
   * The list of containers for this microservice.
   * @return containers
   */
  public MicroService addContainersItem(MicroServiceContainer containersItem) {
    if (this.containers == null) {
      this.containers = new ArrayList<MicroServiceContainer>();
    }
    this.containers.add(containersItem);
    return this;
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
   * Flag to indicate if container ip list is provided by cloud connectorthis is applicable for overlay cases.
   * @return ipList
   */
  public Boolean getIpList() {
    return ipList;
  }

  /**
   * This is the setter method to the attribute.
   * Flag to indicate if container ip list is provided by cloud connectorthis is applicable for overlay cases.
   * @param ipList set the ipList.
   */
  public void setIpList(Boolean  ipList) {
    this.ipList = ipList;
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
   * Placeholder for description of property orchestrator_name of obj type microservice field type str  type string.
   * @return orchestratorName
   */
  public String getOrchestratorName() {
    return orchestratorName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property orchestrator_name of obj type microservice field type str  type string.
   * @param orchestratorName set the orchestratorName.
   */
  public void setOrchestratorName(String  orchestratorName) {
    this.orchestratorName = orchestratorName;
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
  MicroService objMicroService = (MicroService) o;
  return   Objects.equals(this.uuid, objMicroService.uuid)&&
  Objects.equals(this.name, objMicroService.name)&&
  Objects.equals(this.orchestratorName, objMicroService.orchestratorName)&&
  Objects.equals(this.applicationName, objMicroService.applicationName)&&
  Objects.equals(this.ipList, objMicroService.ipList)&&
  Objects.equals(this.containers, objMicroService.containers)&&
  Objects.equals(this.createdBy, objMicroService.createdBy)&&
  Objects.equals(this.cloudConfigCksum, objMicroService.cloudConfigCksum)&&
  Objects.equals(this.description, objMicroService.description)&&
  Objects.equals(this.tenantRef, objMicroService.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MicroService {\n");
      sb.append("    applicationName: ").append(toIndentedString(applicationName)).append("\n");
        sb.append("    cloudConfigCksum: ").append(toIndentedString(cloudConfigCksum)).append("\n");
        sb.append("    containers: ").append(toIndentedString(containers)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    ipList: ").append(toIndentedString(ipList)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    orchestratorName: ").append(toIndentedString(orchestratorName)).append("\n");
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

