package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ServicePoolSelector is a POJO class extends AviRestResource that used for creating
 * ServicePoolSelector.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServicePoolSelector  {
    @JsonProperty("service_pool_group_ref")
    private String servicePoolGroupRef = null;

    @JsonProperty("service_pool_ref")
    private String servicePoolRef = null;

    @JsonProperty("service_port")
    private Integer servicePort = null;

    @JsonProperty("service_port_range_end")
    private Integer servicePortRangeEnd = 0;

    @JsonProperty("service_protocol")
    private String serviceProtocol = null;



  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type poolgroup.
   * @return servicePoolGroupRef
   */
  public String getServicePoolGroupRef() {
    return servicePoolGroupRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type poolgroup.
   * @param servicePoolGroupRef set the servicePoolGroupRef.
   */
  public void setServicePoolGroupRef(String  servicePoolGroupRef) {
    this.servicePoolGroupRef = servicePoolGroupRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type pool.
   * @return servicePoolRef
   */
  public String getServicePoolRef() {
    return servicePoolRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type pool.
   * @param servicePoolRef set the servicePoolRef.
   */
  public void setServicePoolRef(String  servicePoolRef) {
    this.servicePoolRef = servicePoolRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Pool based destination port.
   * Allowed values are 1-65535.
   * @return servicePort
   */
  public Integer getServicePort() {
    return servicePort;
  }

  /**
   * This is the setter method to the attribute.
   * Pool based destination port.
   * Allowed values are 1-65535.
   * @param servicePort set the servicePort.
   */
  public void setServicePort(Integer  servicePort) {
    this.servicePort = servicePort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The end of the service port number range.
   * Allowed values are 1-65535.
   * Special values are 0- 'single port'.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return servicePortRangeEnd
   */
  public Integer getServicePortRangeEnd() {
    return servicePortRangeEnd;
  }

  /**
   * This is the setter method to the attribute.
   * The end of the service port number range.
   * Allowed values are 1-65535.
   * Special values are 0- 'single port'.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param servicePortRangeEnd set the servicePortRangeEnd.
   */
  public void setServicePortRangeEnd(Integer  servicePortRangeEnd) {
    this.servicePortRangeEnd = servicePortRangeEnd;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Destination protocol to match for the pool selection.
   * If not specified, it will match any protocol.
   * Enum options - PROTOCOL_TYPE_TCP_PROXY, PROTOCOL_TYPE_TCP_FAST_PATH, PROTOCOL_TYPE_UDP_FAST_PATH, PROTOCOL_TYPE_UDP_PROXY.
   * @return serviceProtocol
   */
  public String getServiceProtocol() {
    return serviceProtocol;
  }

  /**
   * This is the setter method to the attribute.
   * Destination protocol to match for the pool selection.
   * If not specified, it will match any protocol.
   * Enum options - PROTOCOL_TYPE_TCP_PROXY, PROTOCOL_TYPE_TCP_FAST_PATH, PROTOCOL_TYPE_UDP_FAST_PATH, PROTOCOL_TYPE_UDP_PROXY.
   * @param serviceProtocol set the serviceProtocol.
   */
  public void setServiceProtocol(String  serviceProtocol) {
    this.serviceProtocol = serviceProtocol;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ServicePoolSelector objServicePoolSelector = (ServicePoolSelector) o;
  return   Objects.equals(this.servicePort, objServicePoolSelector.servicePort)&&
  Objects.equals(this.servicePoolRef, objServicePoolSelector.servicePoolRef)&&
  Objects.equals(this.serviceProtocol, objServicePoolSelector.serviceProtocol)&&
  Objects.equals(this.servicePoolGroupRef, objServicePoolSelector.servicePoolGroupRef)&&
  Objects.equals(this.servicePortRangeEnd, objServicePoolSelector.servicePortRangeEnd);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ServicePoolSelector {\n");
      sb.append("    servicePoolGroupRef: ").append(toIndentedString(servicePoolGroupRef)).append("\n");
        sb.append("    servicePoolRef: ").append(toIndentedString(servicePoolRef)).append("\n");
        sb.append("    servicePort: ").append(toIndentedString(servicePort)).append("\n");
        sb.append("    servicePortRangeEnd: ").append(toIndentedString(servicePortRangeEnd)).append("\n");
        sb.append("    serviceProtocol: ").append(toIndentedString(serviceProtocol)).append("\n");
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

