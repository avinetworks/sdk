package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The ControllerSizingCloudLimits is a POJO class extends AviRestResource that used for creating
 * ControllerSizingCloudLimits.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerSizingCloudLimits  {
    @JsonProperty("num_clouds")
    private Integer numClouds = null;

    @JsonProperty("type")
    private String type = null;



    /**
     * This is the getter method this will return the attribute value.
     * Maximum number of clouds of a given type.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return numClouds
     */
    public Integer getNumClouds() {
        return numClouds;
    }

    /**
     * This is the setter method to the attribute.
     * Maximum number of clouds of a given type.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param numClouds set the numClouds.
     */
    public void setNumClouds(Integer  numClouds) {
        this.numClouds = numClouds;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Cloud type for the limit.
     * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
     * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * This is the setter method to the attribute.
     * Cloud type for the limit.
     * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
     * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param type set the type.
     */
    public void setType(String  type) {
        this.type = type;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      ControllerSizingCloudLimits objControllerSizingCloudLimits = (ControllerSizingCloudLimits) o;
      return   Objects.equals(this.type, objControllerSizingCloudLimits.type)&&
  Objects.equals(this.numClouds, objControllerSizingCloudLimits.numClouds);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ControllerSizingCloudLimits {\n");
                  sb.append("    numClouds: ").append(toIndentedString(numClouds)).append("\n");
                        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
