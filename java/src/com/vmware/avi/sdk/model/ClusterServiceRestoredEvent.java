package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The ClusterServiceRestoredEvent is a POJO class extends AviRestResource that used for creating
 * ClusterServiceRestoredEvent.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterServiceRestoredEvent  {
    @JsonProperty("node_name")
    private String nodeName = null;

    @JsonProperty("service_name")
    private String serviceName = null;



    /**
     * This is the getter method this will return the attribute value.
     * Name of controller node.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return nodeName
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * This is the setter method to the attribute.
     * Name of controller node.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param nodeName set the nodeName.
     */
    public void setNodeName(String  nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the controller service.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the controller service.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param serviceName set the serviceName.
     */
    public void setServiceName(String  serviceName) {
        this.serviceName = serviceName;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      ClusterServiceRestoredEvent objClusterServiceRestoredEvent = (ClusterServiceRestoredEvent) o;
      return   Objects.equals(this.serviceName, objClusterServiceRestoredEvent.serviceName)&&
  Objects.equals(this.nodeName, objClusterServiceRestoredEvent.nodeName);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ClusterServiceRestoredEvent {\n");
                  sb.append("    nodeName: ").append(toIndentedString(nodeName)).append("\n");
                        sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
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
