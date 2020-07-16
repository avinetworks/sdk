package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OshiftDockerRegistryMetaData is a POJO class extends AviRestResource that used for creating
 * OshiftDockerRegistryMetaData.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OshiftDockerRegistryMetaData  {
    @JsonProperty("registry_namespace")
    private String registryNamespace = "default";

    @JsonProperty("registry_service")
    private String registryService = "docker-registry";

    @JsonProperty("registry_vip")
    private IpAddr registryVip = null;



  /**
   * This is the getter method this will return the attribute value.
   * Namespace for the serviceengine image to be hosted in openshift integrated registry.
   * Default value when not specified in API or module is interpreted by Avi Controller as default.
   * @return registryNamespace
   */
  public String getRegistryNamespace() {
    return registryNamespace;
  }

  /**
   * This is the setter method to the attribute.
   * Namespace for the serviceengine image to be hosted in openshift integrated registry.
   * Default value when not specified in API or module is interpreted by Avi Controller as default.
   * @param registryNamespace set the registryNamespace.
   */
  public void setRegistryNamespace(String  registryNamespace) {
    this.registryNamespace = registryNamespace;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the integrated registry service in openshift.
   * Default value when not specified in API or module is interpreted by Avi Controller as docker-registry.
   * @return registryService
   */
  public String getRegistryService() {
    return registryService;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the integrated registry service in openshift.
   * Default value when not specified in API or module is interpreted by Avi Controller as docker-registry.
   * @param registryService set the registryService.
   */
  public void setRegistryService(String  registryService) {
    this.registryService = registryService;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Static vip for 'docker-registry' service in openshift if avi is proxying for this service.this vip should be outside the cluster ip subnet in
   * kubernetes and within the subnet configured (but outside the available pool of ips) in the east west ipam profile configuration for this cloud.
   * For example, if kubernetes cluster vip range is 172.30.0.0/16 and subnet configured in east west ipam profile is 172.50.0.0/16, then 172.50.0.2
   * can be used for this vip and ip pool can start from 172.50.0.3 onwards.
   * Use this static vip in '--insecure-registry <this-vip> 5000' docker config if using an insecure registry or add this to the list of ips/hostnames
   * when generating certificates if using a secure tls registry.
   * @return registryVip
   */
  public IpAddr getRegistryVip() {
    return registryVip;
  }

  /**
   * This is the setter method to the attribute.
   * Static vip for 'docker-registry' service in openshift if avi is proxying for this service.this vip should be outside the cluster ip subnet in
   * kubernetes and within the subnet configured (but outside the available pool of ips) in the east west ipam profile configuration for this cloud.
   * For example, if kubernetes cluster vip range is 172.30.0.0/16 and subnet configured in east west ipam profile is 172.50.0.0/16, then 172.50.0.2
   * can be used for this vip and ip pool can start from 172.50.0.3 onwards.
   * Use this static vip in '--insecure-registry <this-vip> 5000' docker config if using an insecure registry or add this to the list of ips/hostnames
   * when generating certificates if using a secure tls registry.
   * @param registryVip set the registryVip.
   */
  public void setRegistryVip(IpAddr registryVip) {
    this.registryVip = registryVip;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OshiftDockerRegistryMetaData objOshiftDockerRegistryMetaData = (OshiftDockerRegistryMetaData) o;
  return   Objects.equals(this.registryService, objOshiftDockerRegistryMetaData.registryService)&&
  Objects.equals(this.registryVip, objOshiftDockerRegistryMetaData.registryVip)&&
  Objects.equals(this.registryNamespace, objOshiftDockerRegistryMetaData.registryNamespace);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OshiftDockerRegistryMetaData {\n");
      sb.append("    registryNamespace: ").append(toIndentedString(registryNamespace)).append("\n");
        sb.append("    registryService: ").append(toIndentedString(registryService)).append("\n");
        sb.append("    registryVip: ").append(toIndentedString(registryVip)).append("\n");
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

