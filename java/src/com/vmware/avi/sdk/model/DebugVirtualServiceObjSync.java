package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The DebugVirtualServiceObjSync is a POJO class extends AviRestResource that used for creating
 * DebugVirtualServiceObjSync.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebugVirtualServiceObjSync  {
    @JsonProperty("trigger_initial_sync")
    private Boolean triggerInitialSync = false;



    /**
     * This is the getter method this will return the attribute value.
     * Triggers initial sync on all the ses of this vs.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return triggerInitialSync
     */
    public Boolean getTriggerInitialSync() {
        return triggerInitialSync;
    }

    /**
     * This is the setter method to the attribute.
     * Triggers initial sync on all the ses of this vs.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param triggerInitialSync set the triggerInitialSync.
     */
    public void setTriggerInitialSync(Boolean  triggerInitialSync) {
        this.triggerInitialSync = triggerInitialSync;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      DebugVirtualServiceObjSync objDebugVirtualServiceObjSync = (DebugVirtualServiceObjSync) o;
      return   Objects.equals(this.triggerInitialSync, objDebugVirtualServiceObjSync.triggerInitialSync);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class DebugVirtualServiceObjSync {\n");
                  sb.append("    triggerInitialSync: ").append(toIndentedString(triggerInitialSync)).append("\n");
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
