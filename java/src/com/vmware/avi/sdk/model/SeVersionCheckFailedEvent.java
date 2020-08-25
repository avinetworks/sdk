package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The SeVersionCheckFailedEvent is a POJO class extends AviRestResource that used for creating
 * SeVersionCheckFailedEvent.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeVersionCheckFailedEvent  {
    @JsonProperty("controller_version")
    private String controllerVersion = null;

    @JsonProperty("se_uuid")
    private String seUuid = null;

    @JsonProperty("se_version")
    private String seVersion = null;



    /**
     * This is the getter method this will return the attribute value.
     * Software version on the controller.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return controllerVersion
     */
    public String getControllerVersion() {
        return controllerVersion;
    }

    /**
     * This is the setter method to the attribute.
     * Software version on the controller.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param controllerVersion set the controllerVersion.
     */
    public void setControllerVersion(String  controllerVersion) {
        this.controllerVersion = controllerVersion;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Uuid of the se.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seUuid
     */
    public String getSeUuid() {
        return seUuid;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the se.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seUuid set the seUuid.
     */
    public void setSeUuid(String  seUuid) {
        this.seUuid = seUuid;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Software version on the se.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seVersion
     */
    public String getSeVersion() {
        return seVersion;
    }

    /**
     * This is the setter method to the attribute.
     * Software version on the se.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seVersion set the seVersion.
     */
    public void setSeVersion(String  seVersion) {
        this.seVersion = seVersion;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      SeVersionCheckFailedEvent objSeVersionCheckFailedEvent = (SeVersionCheckFailedEvent) o;
      return   Objects.equals(this.seUuid, objSeVersionCheckFailedEvent.seUuid)&&
  Objects.equals(this.seVersion, objSeVersionCheckFailedEvent.seVersion)&&
  Objects.equals(this.controllerVersion, objSeVersionCheckFailedEvent.controllerVersion);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SeVersionCheckFailedEvent {\n");
                  sb.append("    controllerVersion: ").append(toIndentedString(controllerVersion)).append("\n");
                        sb.append("    seUuid: ").append(toIndentedString(seUuid)).append("\n");
                        sb.append("    seVersion: ").append(toIndentedString(seVersion)).append("\n");
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
