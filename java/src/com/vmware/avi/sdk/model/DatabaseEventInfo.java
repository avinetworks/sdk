package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The DatabaseEventInfo is a POJO class extends AviRestResource that used for creating
 * DatabaseEventInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DatabaseEventInfo  {
    @JsonProperty("component")
    private String component = null;

    @JsonProperty("message")
    private String message = null;



    /**
     * This is the getter method this will return the attribute value.
     * Component of the database(e.g.
     * Metrics).
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return component
     */
    public String getComponent() {
        return component;
    }

    /**
     * This is the setter method to the attribute.
     * Component of the database(e.g.
     * Metrics).
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param component set the component.
     */
    public void setComponent(String  component) {
        this.component = component;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Reported message of the event.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * This is the setter method to the attribute.
     * Reported message of the event.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param message set the message.
     */
    public void setMessage(String  message) {
        this.message = message;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      DatabaseEventInfo objDatabaseEventInfo = (DatabaseEventInfo) o;
      return   Objects.equals(this.component, objDatabaseEventInfo.component)&&
  Objects.equals(this.message, objDatabaseEventInfo.message);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class DatabaseEventInfo {\n");
                  sb.append("    component: ").append(toIndentedString(component)).append("\n");
                        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
