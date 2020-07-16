package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ContainerCloudService is a POJO class extends AviRestResource that used for creating
 * ContainerCloudService.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContainerCloudService  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("object")
    private String object = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("service")
    private String service = null;

    @JsonProperty("status")
    private String status = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type containercloudservice field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type containercloudservice field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property object of obj type containercloudservice field type str  type string.
   * @return object
   */
  public String getObject() {
    return object;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property object of obj type containercloudservice field type str  type string.
   * @param object set the object.
   */
  public void setObject(String  object) {
    this.object = object;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type containercloudservice field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type containercloudservice field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property service of obj type containercloudservice field type str  type string.
   * @return service
   */
  public String getService() {
    return service;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property service of obj type containercloudservice field type str  type string.
   * @param service set the service.
   */
  public void setService(String  service) {
    this.service = service;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property status of obj type containercloudservice field type str  type string.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property status of obj type containercloudservice field type str  type string.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ContainerCloudService objContainerCloudService = (ContainerCloudService) o;
  return   Objects.equals(this.status, objContainerCloudService.status)&&
  Objects.equals(this.reason, objContainerCloudService.reason)&&
  Objects.equals(this.object, objContainerCloudService.object)&&
  Objects.equals(this.service, objContainerCloudService.service)&&
  Objects.equals(this.ccId, objContainerCloudService.ccId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ContainerCloudService {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    object: ").append(toIndentedString(object)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    service: ").append(toIndentedString(service)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

