package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeVsFaultEventDetails is a POJO class extends AviRestResource that used for creating
 * SeVsFaultEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeVsFaultEventDetails  {
    @JsonProperty("fault_object")
    private String faultObject = null;

    @JsonProperty("fault_reason")
    private String faultReason = null;

    @JsonProperty("service_engine")
    private String serviceEngine = null;

    @JsonProperty("virtual_service")
    private String virtualService = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of the object responsible for the fault.
   * @return faultObject
   */
  public String getFaultObject() {
    return faultObject;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object responsible for the fault.
   * @param faultObject set the faultObject.
   */
  public void setFaultObject(String  faultObject) {
    this.faultObject = faultObject;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Reason for the fault.
   * @return faultReason
   */
  public String getFaultReason() {
    return faultReason;
  }

  /**
   * This is the setter method to the attribute.
   * Reason for the fault.
   * @param faultReason set the faultReason.
   */
  public void setFaultReason(String  faultReason) {
    this.faultReason = faultReason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Se uuid.
   * It is a reference to an object of type serviceengine.
   * @return serviceEngine
   */
  public String getServiceEngine() {
    return serviceEngine;
  }

  /**
   * This is the setter method to the attribute.
   * Se uuid.
   * It is a reference to an object of type serviceengine.
   * @param serviceEngine set the serviceEngine.
   */
  public void setServiceEngine(String  serviceEngine) {
    this.serviceEngine = serviceEngine;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vs name.
   * It is a reference to an object of type virtualservice.
   * @return virtualService
   */
  public String getVirtualService() {
    return virtualService;
  }

  /**
   * This is the setter method to the attribute.
   * Vs name.
   * It is a reference to an object of type virtualservice.
   * @param virtualService set the virtualService.
   */
  public void setVirtualService(String  virtualService) {
    this.virtualService = virtualService;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeVsFaultEventDetails objSeVsFaultEventDetails = (SeVsFaultEventDetails) o;
  return   Objects.equals(this.virtualService, objSeVsFaultEventDetails.virtualService)&&
  Objects.equals(this.serviceEngine, objSeVsFaultEventDetails.serviceEngine)&&
  Objects.equals(this.faultObject, objSeVsFaultEventDetails.faultObject)&&
  Objects.equals(this.faultReason, objSeVsFaultEventDetails.faultReason);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeVsFaultEventDetails {\n");
      sb.append("    faultObject: ").append(toIndentedString(faultObject)).append("\n");
        sb.append("    faultReason: ").append(toIndentedString(faultReason)).append("\n");
        sb.append("    serviceEngine: ").append(toIndentedString(serviceEngine)).append("\n");
        sb.append("    virtualService: ").append(toIndentedString(virtualService)).append("\n");
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

