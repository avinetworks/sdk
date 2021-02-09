package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The ConfigUserLogin is a POJO class extends AviRestResource that used for creating
 * ConfigUserLogin.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigUserLogin  {
    @JsonProperty("client_ip")
    private String clientIp = null;

    @JsonProperty("client_type")
    private String clientType = null;

    @JsonProperty("error_message")
    private String errorMessage = null;

    @JsonProperty("local")
    private Boolean local = null;

    @JsonProperty("remote_attributes")
    private String remoteAttributes = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("user")
    private String user = null;



    /**
     * This is the getter method this will return the attribute value.
     * Client ip.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return clientIp
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * This is the setter method to the attribute.
     * Client ip.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param clientIp set the clientIp.
     */
    public void setClientIp(String  clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Type of client used to login ui, cli, others(api).
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return clientType
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * This is the setter method to the attribute.
     * Type of client used to login ui, cli, others(api).
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param clientType set the clientType.
     */
    public void setClientType(String  clientType) {
        this.clientType = clientType;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Error message if authentication failed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * This is the setter method to the attribute.
     * Error message if authentication failed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param errorMessage set the errorMessage.
     */
    public void setErrorMessage(String  errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Local user.
     * Field introduced in 17.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return local
     */
    public Boolean getLocal() {
        return local;
    }

    /**
     * This is the setter method to the attribute.
     * Local user.
     * Field introduced in 17.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param local set the local.
     */
    public void setLocal(Boolean  local) {
        this.local = local;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Additional attributes from login handler.
     * Field introduced in 18.1.4,18.2.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return remoteAttributes
     */
    public String getRemoteAttributes() {
        return remoteAttributes;
    }

    /**
     * This is the setter method to the attribute.
     * Additional attributes from login handler.
     * Field introduced in 18.1.4,18.2.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param remoteAttributes set the remoteAttributes.
     */
    public void setRemoteAttributes(String  remoteAttributes) {
        this.remoteAttributes = remoteAttributes;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Status.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * This is the setter method to the attribute.
     * Status.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param status set the status.
     */
    public void setStatus(String  status) {
        this.status = status;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Request user.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * This is the setter method to the attribute.
     * Request user.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param user set the user.
     */
    public void setUser(String  user) {
        this.user = user;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      ConfigUserLogin objConfigUserLogin = (ConfigUserLogin) o;
      return   Objects.equals(this.user, objConfigUserLogin.user)&&
  Objects.equals(this.status, objConfigUserLogin.status)&&
  Objects.equals(this.clientIp, objConfigUserLogin.clientIp)&&
  Objects.equals(this.errorMessage, objConfigUserLogin.errorMessage)&&
  Objects.equals(this.local, objConfigUserLogin.local)&&
  Objects.equals(this.remoteAttributes, objConfigUserLogin.remoteAttributes)&&
  Objects.equals(this.clientType, objConfigUserLogin.clientType);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ConfigUserLogin {\n");
                  sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
                        sb.append("    clientType: ").append(toIndentedString(clientType)).append("\n");
                        sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
                        sb.append("    local: ").append(toIndentedString(local)).append("\n");
                        sb.append("    remoteAttributes: ").append(toIndentedString(remoteAttributes)).append("\n");
                        sb.append("    status: ").append(toIndentedString(status)).append("\n");
                        sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
