package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The ACSubjectInfo is a POJO class extends AviRestResource that used for creating
 * ACSubjectInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ACSubjectInfo  {
    @JsonProperty("type")
    private String type = null;

    @JsonProperty("value")
    private String value = null;



    /**
     * This is the getter method this will return the attribute value.
     * Subject type for the audit event (e.g.
     * Dns hostname, ip address, uri).
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * This is the setter method to the attribute.
     * Subject type for the audit event (e.g.
     * Dns hostname, ip address, uri).
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param type set the type.
     */
    public void setType(String  type) {
        this.type = type;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Subject value for the audit event (e.g.
     * Www.example.com, 10.10.10.10, www.foo.com/index.html).
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * This is the setter method to the attribute.
     * Subject value for the audit event (e.g.
     * Www.example.com, 10.10.10.10, www.foo.com/index.html).
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param value set the value.
     */
    public void setValue(String  value) {
        this.value = value;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      ACSubjectInfo objACSubjectInfo = (ACSubjectInfo) o;
      return   Objects.equals(this.type, objACSubjectInfo.type)&&
  Objects.equals(this.value, objACSubjectInfo.value);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ACSubjectInfo {\n");
                  sb.append("    type: ").append(toIndentedString(type)).append("\n");
                        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
