package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ServiceEngineCloudLimits is a POJO class extends AviRestResource that used for creating
 * ServiceEngineCloudLimits.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceEngineCloudLimits  {
    @JsonProperty("type")
    private String type = null;

    @JsonProperty("vrfs_per_serviceengine")
    private Integer vrfsPerServiceengine = null;



  /**
   * This is the getter method this will return the attribute value.
   * Cloud type for this cloud limit.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * Field introduced in 20.1.1.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Cloud type for this cloud limit.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * Field introduced in 20.1.1.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of vrfcontexts per serviceengine.
   * Field introduced in 20.1.1.
   * @return vrfsPerServiceengine
   */
  public Integer getVrfsPerServiceengine() {
    return vrfsPerServiceengine;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of vrfcontexts per serviceengine.
   * Field introduced in 20.1.1.
   * @param vrfsPerServiceengine set the vrfsPerServiceengine.
   */
  public void setVrfsPerServiceengine(Integer  vrfsPerServiceengine) {
    this.vrfsPerServiceengine = vrfsPerServiceengine;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ServiceEngineCloudLimits objServiceEngineCloudLimits = (ServiceEngineCloudLimits) o;
  return   Objects.equals(this.type, objServiceEngineCloudLimits.type)&&
  Objects.equals(this.vrfsPerServiceengine, objServiceEngineCloudLimits.vrfsPerServiceengine);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ServiceEngineCloudLimits {\n");
      sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    vrfsPerServiceengine: ").append(toIndentedString(vrfsPerServiceengine)).append("\n");
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

