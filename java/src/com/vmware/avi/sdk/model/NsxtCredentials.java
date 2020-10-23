package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The NsxtCredentials is a POJO class extends AviRestResource that used for creating
 * NsxtCredentials.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NsxtCredentials  {
    @JsonProperty("password")
    private String password = null;

    @JsonProperty("username")
    private String username = null;



    /**
     * This is the getter method this will return the attribute value.
     * Password to talk to nsx-t manager.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This is the setter method to the attribute.
     * Password to talk to nsx-t manager.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param password set the password.
     */
    public void setPassword(String  password) {
        this.password = password;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Username to talk to nsx-t manager.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This is the setter method to the attribute.
     * Username to talk to nsx-t manager.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param username set the username.
     */
    public void setUsername(String  username) {
        this.username = username;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      NsxtCredentials objNsxtCredentials = (NsxtCredentials) o;
      return   Objects.equals(this.username, objNsxtCredentials.username)&&
  Objects.equals(this.password, objNsxtCredentials.password);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class NsxtCredentials {\n");
                  sb.append("    password: ").append(toIndentedString(password)).append("\n");
                        sb.append("    username: ").append(toIndentedString(username)).append("\n");
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
