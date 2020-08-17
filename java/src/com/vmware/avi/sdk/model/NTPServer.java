package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NTPServer is a POJO class extends AviRestResource that used for creating
 * NTPServer.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NTPServer  {
    @JsonProperty("key_number")
    private Integer keyNumber = null;

    @JsonProperty("server")
    private IpAddr server = null;



  /**
   * This is the getter method this will return the attribute value.
   * Key number from the list of trusted keys used to authenticate this server.
   * Allowed values are 1-65534.
   * @return keyNumber
   */
  public Integer getKeyNumber() {
    return keyNumber;
  }

  /**
   * This is the setter method to the attribute.
   * Key number from the list of trusted keys used to authenticate this server.
   * Allowed values are 1-65534.
   * @param keyNumber set the keyNumber.
   */
  public void setKeyNumber(Integer  keyNumber) {
    this.keyNumber = keyNumber;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip address of the ntp server.
   * @return server
   */
  public IpAddr getServer() {
    return server;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address of the ntp server.
   * @param server set the server.
   */
  public void setServer(IpAddr server) {
    this.server = server;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  NTPServer objNTPServer = (NTPServer) o;
  return   Objects.equals(this.server, objNTPServer.server)&&
  Objects.equals(this.keyNumber, objNTPServer.keyNumber);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NTPServer {\n");
      sb.append("    keyNumber: ").append(toIndentedString(keyNumber)).append("\n");
        sb.append("    server: ").append(toIndentedString(server)).append("\n");
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

