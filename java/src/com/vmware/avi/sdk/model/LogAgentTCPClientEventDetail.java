package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The LogAgentTCPClientEventDetail is a POJO class extends AviRestResource that used for creating
 * LogAgentTCPClientEventDetail.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogAgentTCPClientEventDetail  {
    @JsonProperty("error_code")
    private String errorCode = null;

    @JsonProperty("error_reason")
    private String errorReason = null;

    @JsonProperty("host")
    private String host = null;

    @JsonProperty("port")
    private String port = null;



    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param errorCode set the errorCode.
     */
    public void setErrorCode(String  errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return errorReason
     */
    public String getErrorReason() {
        return errorReason;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param errorReason set the errorReason.
     */
    public void setErrorReason(String  errorReason) {
        this.errorReason = errorReason;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param host set the host.
     */
    public void setHost(String  host) {
        this.host = host;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return port
     */
    public String getPort() {
        return port;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param port set the port.
     */
    public void setPort(String  port) {
        this.port = port;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      LogAgentTCPClientEventDetail objLogAgentTCPClientEventDetail = (LogAgentTCPClientEventDetail) o;
      return   Objects.equals(this.host, objLogAgentTCPClientEventDetail.host)&&
  Objects.equals(this.port, objLogAgentTCPClientEventDetail.port)&&
  Objects.equals(this.errorCode, objLogAgentTCPClientEventDetail.errorCode)&&
  Objects.equals(this.errorReason, objLogAgentTCPClientEventDetail.errorReason);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class LogAgentTCPClientEventDetail {\n");
                  sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
                        sb.append("    errorReason: ").append(toIndentedString(errorReason)).append("\n");
                        sb.append("    host: ").append(toIndentedString(host)).append("\n");
                        sb.append("    port: ").append(toIndentedString(port)).append("\n");
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
