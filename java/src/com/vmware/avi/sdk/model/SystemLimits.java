package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SystemLimits is a POJO class extends AviRestResource that used for creating
 * SystemLimits.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SystemLimits extends AviRestResource  {
    @JsonProperty("controller_limits")
    private ControllerLimits controllerLimits = null;

    @JsonProperty("controller_sizes")
    private List<ControllerSize> controllerSizes = null;

    @JsonProperty("serviceengine_limits")
    private ServiceEngineLimits serviceengineLimits = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * System limits for the entire controller cluster.
   * Field introduced in 20.1.1.
   * @return controllerLimits
   */
  public ControllerLimits getControllerLimits() {
    return controllerLimits;
  }

  /**
   * This is the setter method to the attribute.
   * System limits for the entire controller cluster.
   * Field introduced in 20.1.1.
   * @param controllerLimits set the controllerLimits.
   */
  public void setControllerLimits(ControllerLimits controllerLimits) {
    this.controllerLimits = controllerLimits;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Possible controller sizes.
   * Field introduced in 20.1.1.
   * @return controllerSizes
   */
  public List<ControllerSize> getControllerSizes() {
    return controllerSizes;
  }

  /**
   * This is the setter method. this will set the controllerSizes
   * Possible controller sizes.
   * Field introduced in 20.1.1.
   * @return controllerSizes
   */
  public void setControllerSizes(List<ControllerSize>  controllerSizes) {
    this.controllerSizes = controllerSizes;
  }

  /**
   * This is the setter method this will set the controllerSizes
   * Possible controller sizes.
   * Field introduced in 20.1.1.
   * @return controllerSizes
   */
  public SystemLimits addControllerSizesItem(ControllerSize controllerSizesItem) {
    if (this.controllerSizes == null) {
      this.controllerSizes = new ArrayList<ControllerSize>();
    }
    this.controllerSizes.add(controllerSizesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * System limits that apply to a serviceengine.
   * Field introduced in 20.1.1.
   * @return serviceengineLimits
   */
  public ServiceEngineLimits getServiceengineLimits() {
    return serviceengineLimits;
  }

  /**
   * This is the setter method to the attribute.
   * System limits that apply to a serviceengine.
   * Field introduced in 20.1.1.
   * @param serviceengineLimits set the serviceengineLimits.
   */
  public void setServiceengineLimits(ServiceEngineLimits serviceengineLimits) {
    this.serviceengineLimits = serviceengineLimits;
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
   * Uuid for the system limits object.
   * Field introduced in 20.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid for the system limits object.
   * Field introduced in 20.1.1.
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
  SystemLimits objSystemLimits = (SystemLimits) o;
  return   Objects.equals(this.uuid, objSystemLimits.uuid)&&
  Objects.equals(this.controllerSizes, objSystemLimits.controllerSizes)&&
  Objects.equals(this.controllerLimits, objSystemLimits.controllerLimits)&&
  Objects.equals(this.serviceengineLimits, objSystemLimits.serviceengineLimits);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SystemLimits {\n");
      sb.append("    controllerLimits: ").append(toIndentedString(controllerLimits)).append("\n");
        sb.append("    controllerSizes: ").append(toIndentedString(controllerSizes)).append("\n");
        sb.append("    serviceengineLimits: ").append(toIndentedString(serviceengineLimits)).append("\n");
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

