package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The ControllerDiscontinuousTimeChangeEventDetails is a POJO class extends AviRestResource that used for creating
 * ControllerDiscontinuousTimeChangeEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerDiscontinuousTimeChangeEventDetails  {
    @JsonProperty("from_time")
    private String fromTime = null;

    @JsonProperty("node_name")
    private String nodeName = null;

    @JsonProperty("to_time")
    private String toTime = null;



    /**
     * This is the getter method this will return the attribute value.
     * Time stamp before the discontinuous jump in time.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return fromTime
     */
    public String getFromTime() {
        return fromTime;
    }

    /**
     * This is the setter method to the attribute.
     * Time stamp before the discontinuous jump in time.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param fromTime set the fromTime.
     */
    public void setFromTime(String  fromTime) {
        this.fromTime = fromTime;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the controller responsible for this event.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return nodeName
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the controller responsible for this event.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param nodeName set the nodeName.
     */
    public void setNodeName(String  nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Time stamp to which the time has discontinuously jumped.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return toTime
     */
    public String getToTime() {
        return toTime;
    }

    /**
     * This is the setter method to the attribute.
     * Time stamp to which the time has discontinuously jumped.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param toTime set the toTime.
     */
    public void setToTime(String  toTime) {
        this.toTime = toTime;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      ControllerDiscontinuousTimeChangeEventDetails objControllerDiscontinuousTimeChangeEventDetails = (ControllerDiscontinuousTimeChangeEventDetails) o;
      return   Objects.equals(this.nodeName, objControllerDiscontinuousTimeChangeEventDetails.nodeName)&&
  Objects.equals(this.fromTime, objControllerDiscontinuousTimeChangeEventDetails.fromTime)&&
  Objects.equals(this.toTime, objControllerDiscontinuousTimeChangeEventDetails.toTime);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ControllerDiscontinuousTimeChangeEventDetails {\n");
                  sb.append("    fromTime: ").append(toIndentedString(fromTime)).append("\n");
                        sb.append("    nodeName: ").append(toIndentedString(nodeName)).append("\n");
                        sb.append("    toTime: ").append(toIndentedString(toTime)).append("\n");
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
