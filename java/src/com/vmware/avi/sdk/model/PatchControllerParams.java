package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The PatchControllerParams is a POJO class extends AviRestResource that used for creating
 * PatchControllerParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatchControllerParams  {
    @JsonProperty("controller_patch_ref")
    private String controllerPatchRef = null;

    @JsonProperty("skip_warnings")
    private Boolean skipWarnings = false;



    /**
     * This is the getter method this will return the attribute value.
     * Image uuid for identifying controller patch image.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return controllerPatchRef
     */
    public String getControllerPatchRef() {
        return controllerPatchRef;
    }

    /**
     * This is the setter method to the attribute.
     * Image uuid for identifying controller patch image.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param controllerPatchRef set the controllerPatchRef.
     */
    public void setControllerPatchRef(String  controllerPatchRef) {
        this.controllerPatchRef = controllerPatchRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * This is flag when set as true skips few optional must checks.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return skipWarnings
     */
    public Boolean getSkipWarnings() {
        return skipWarnings;
    }

    /**
     * This is the setter method to the attribute.
     * This is flag when set as true skips few optional must checks.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param skipWarnings set the skipWarnings.
     */
    public void setSkipWarnings(Boolean  skipWarnings) {
        this.skipWarnings = skipWarnings;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      PatchControllerParams objPatchControllerParams = (PatchControllerParams) o;
      return   Objects.equals(this.controllerPatchRef, objPatchControllerParams.controllerPatchRef)&&
  Objects.equals(this.skipWarnings, objPatchControllerParams.skipWarnings);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PatchControllerParams {\n");
                  sb.append("    controllerPatchRef: ").append(toIndentedString(controllerPatchRef)).append("\n");
                        sb.append("    skipWarnings: ").append(toIndentedString(skipWarnings)).append("\n");
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
