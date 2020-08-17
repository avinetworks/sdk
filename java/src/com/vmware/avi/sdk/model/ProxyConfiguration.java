package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ProxyConfiguration is a POJO class extends AviRestResource that used for creating
 * ProxyConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProxyConfiguration  {
    @JsonProperty("host")
    private String host = null;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("port")
    private Integer port = null;

    @JsonProperty("username")
    private String username = null;



  /**
   * This is the getter method this will return the attribute value.
   * Proxy hostname or ip address.
   * @return host
   */
  public String getHost() {
    return host;
  }

  /**
   * This is the setter method to the attribute.
   * Proxy hostname or ip address.
   * @param host set the host.
   */
  public void setHost(String  host) {
    this.host = host;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Password for proxy.
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * This is the setter method to the attribute.
   * Password for proxy.
   * @param password set the password.
   */
  public void setPassword(String  password) {
    this.password = password;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Proxy port.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Proxy port.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Username for proxy.
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * This is the setter method to the attribute.
   * Username for proxy.
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
  ProxyConfiguration objProxyConfiguration = (ProxyConfiguration) o;
  return   Objects.equals(this.host, objProxyConfiguration.host)&&
  Objects.equals(this.port, objProxyConfiguration.port)&&
  Objects.equals(this.username, objProxyConfiguration.username)&&
  Objects.equals(this.password, objProxyConfiguration.password);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ProxyConfiguration {\n");
      sb.append("    host: ").append(toIndentedString(host)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
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

