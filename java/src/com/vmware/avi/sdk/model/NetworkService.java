package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NetworkService is a POJO class extends AviRestResource that used for creating
 * NetworkService.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkService extends AviRestResource  {
    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("routing_service")
    private RoutingService routingService = null;

    @JsonProperty("se_group_ref")
    private String seGroupRef = null;

    @JsonProperty("service_type")
    private String serviceType = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vrf_ref")
    private String vrfRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type cloud.
   * Field introduced in 18.2.5.
   * @return cloudRef
   */
  public String getCloudRef() {
    return cloudRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type cloud.
   * Field introduced in 18.2.5.
   * @param cloudRef set the cloudRef.
   */
  public void setCloudRef(String  cloudRef) {
    this.cloudRef = cloudRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the networkservice.
   * Field introduced in 18.2.5.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the networkservice.
   * Field introduced in 18.2.5.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Routing information of the networkservice.
   * Field introduced in 18.2.5.
   * @return routingService
   */
  public RoutingService getRoutingService() {
    return routingService;
  }

  /**
   * This is the setter method to the attribute.
   * Routing information of the networkservice.
   * Field introduced in 18.2.5.
   * @param routingService set the routingService.
   */
  public void setRoutingService(RoutingService routingService) {
    this.routingService = routingService;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service engine group to which the service is applied.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.5.
   * @return seGroupRef
   */
  public String getSeGroupRef() {
    return seGroupRef;
  }

  /**
   * This is the setter method to the attribute.
   * Service engine group to which the service is applied.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.5.
   * @param seGroupRef set the seGroupRef.
   */
  public void setSeGroupRef(String  seGroupRef) {
    this.seGroupRef = seGroupRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Indicates the type of networkservice.
   * Enum options - ROUTING_SERVICE.
   * Field introduced in 18.2.5.
   * @return serviceType
   */
  public String getServiceType() {
    return serviceType;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates the type of networkservice.
   * Enum options - ROUTING_SERVICE.
   * Field introduced in 18.2.5.
   * @param serviceType set the serviceType.
   */
  public void setServiceType(String  serviceType) {
    this.serviceType = serviceType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.5.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.5.
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
   * Uuid of the networkservice.
   * Field introduced in 18.2.5.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the networkservice.
   * Field introduced in 18.2.5.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vrf context to which the service is scoped.
   * It is a reference to an object of type vrfcontext.
   * Field introduced in 18.2.5.
   * @return vrfRef
   */
  public String getVrfRef() {
    return vrfRef;
  }

  /**
   * This is the setter method to the attribute.
   * Vrf context to which the service is scoped.
   * It is a reference to an object of type vrfcontext.
   * Field introduced in 18.2.5.
   * @param vrfRef set the vrfRef.
   */
  public void setVrfRef(String  vrfRef) {
    this.vrfRef = vrfRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  NetworkService objNetworkService = (NetworkService) o;
  return   Objects.equals(this.uuid, objNetworkService.uuid)&&
  Objects.equals(this.name, objNetworkService.name)&&
  Objects.equals(this.seGroupRef, objNetworkService.seGroupRef)&&
  Objects.equals(this.vrfRef, objNetworkService.vrfRef)&&
  Objects.equals(this.serviceType, objNetworkService.serviceType)&&
  Objects.equals(this.routingService, objNetworkService.routingService)&&
  Objects.equals(this.tenantRef, objNetworkService.tenantRef)&&
  Objects.equals(this.cloudRef, objNetworkService.cloudRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NetworkService {\n");
      sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    routingService: ").append(toIndentedString(routingService)).append("\n");
        sb.append("    seGroupRef: ").append(toIndentedString(seGroupRef)).append("\n");
        sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vrfRef: ").append(toIndentedString(vrfRef)).append("\n");
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

