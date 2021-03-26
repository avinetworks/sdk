package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The ApiVersionDeprecated is a POJO class extends AviRestResource that used for creating
 * ApiVersionDeprecated.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiVersionDeprecated  {
    @JsonProperty("api_version_used")
    private String apiVersionUsed = null;

    @JsonProperty("client_ip")
    private String clientIp = null;

    @JsonProperty("min_supported_api_version")
    private String minSupportedApiVersion = null;

    @JsonProperty("path")
    private String path = null;

    @JsonProperty("user")
    private String user = null;



    /**
     * This is the getter method this will return the attribute value.
     * Api version used.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return apiVersionUsed
     */
    public String getApiVersionUsed() {
        return apiVersionUsed;
    }

    /**
     * This is the setter method to the attribute.
     * Api version used.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param apiVersionUsed set the apiVersionUsed.
     */
    public void setApiVersionUsed(String  apiVersionUsed) {
        this.apiVersionUsed = apiVersionUsed;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Ip address of client who sent the request.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return clientIp
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * This is the setter method to the attribute.
     * Ip address of client who sent the request.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param clientIp set the clientIp.
     */
    public void setClientIp(String  clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum supported api version.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return minSupportedApiVersion
     */
    public String getMinSupportedApiVersion() {
        return minSupportedApiVersion;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum supported api version.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param minSupportedApiVersion set the minSupportedApiVersion.
     */
    public void setMinSupportedApiVersion(String  minSupportedApiVersion) {
        this.minSupportedApiVersion = minSupportedApiVersion;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Uri of the request.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * This is the setter method to the attribute.
     * Uri of the request.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param path set the path.
     */
    public void setPath(String  path) {
        this.path = path;
    }

    /**
     * This is the getter method this will return the attribute value.
     * User who sent the request.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * This is the setter method to the attribute.
     * User who sent the request.
     * Field introduced in 21.1.1.
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
      ApiVersionDeprecated objApiVersionDeprecated = (ApiVersionDeprecated) o;
      return   Objects.equals(this.apiVersionUsed, objApiVersionDeprecated.apiVersionUsed)&&
  Objects.equals(this.clientIp, objApiVersionDeprecated.clientIp)&&
  Objects.equals(this.path, objApiVersionDeprecated.path)&&
  Objects.equals(this.user, objApiVersionDeprecated.user)&&
  Objects.equals(this.minSupportedApiVersion, objApiVersionDeprecated.minSupportedApiVersion);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ApiVersionDeprecated {\n");
                  sb.append("    apiVersionUsed: ").append(toIndentedString(apiVersionUsed)).append("\n");
                        sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
                        sb.append("    minSupportedApiVersion: ").append(toIndentedString(minSupportedApiVersion)).append("\n");
                        sb.append("    path: ").append(toIndentedString(path)).append("\n");
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
