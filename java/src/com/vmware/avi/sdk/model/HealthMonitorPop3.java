package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The HealthMonitorPop3 is a POJO class extends AviRestResource that used for creating
 * HealthMonitorPop3.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthMonitorPop3  {
    @JsonProperty("ssl_attributes")
    private HealthMonitorSSLAttributes sslAttributes = null;



    /**
     * This is the getter method this will return the attribute value.
     * Ssl attributes for pop3s monitor.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return sslAttributes
     */
    public HealthMonitorSSLAttributes getSslAttributes() {
        return sslAttributes;
    }

    /**
     * This is the setter method to the attribute.
     * Ssl attributes for pop3s monitor.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param sslAttributes set the sslAttributes.
     */
    public void setSslAttributes(HealthMonitorSSLAttributes sslAttributes) {
        this.sslAttributes = sslAttributes;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      HealthMonitorPop3 objHealthMonitorPop3 = (HealthMonitorPop3) o;
      return   Objects.equals(this.sslAttributes, objHealthMonitorPop3.sslAttributes);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class HealthMonitorPop3 {\n");
                  sb.append("    sslAttributes: ").append(toIndentedString(sslAttributes)).append("\n");
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
