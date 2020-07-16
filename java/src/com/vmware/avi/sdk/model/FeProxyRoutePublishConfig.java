package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The FeProxyRoutePublishConfig is a POJO class extends AviRestResource that used for creating
 * FeProxyRoutePublishConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeProxyRoutePublishConfig  {
    @JsonProperty("mode")
    private String mode = "FE_PROXY_ROUTE_PUBLISH_NONE";

    @JsonProperty("publisher_port")
    private Integer publisherPort = 80;

    @JsonProperty("subnet")
    private Integer subnet = 32;

    @JsonProperty("token")
    private String token = null;



  /**
   * This is the getter method this will return the attribute value.
   * Publish ecmp route to upstream router for vip.
   * Enum options - FE_PROXY_ROUTE_PUBLISH_NONE, FE_PROXY_ROUTE_PUBLISH_QUAGGA_WEBAPP.
   * Default value when not specified in API or module is interpreted by Avi Controller as FE_PROXY_ROUTE_PUBLISH_NONE.
   * @return mode
   */
  public String getMode() {
    return mode;
  }

  /**
   * This is the setter method to the attribute.
   * Publish ecmp route to upstream router for vip.
   * Enum options - FE_PROXY_ROUTE_PUBLISH_NONE, FE_PROXY_ROUTE_PUBLISH_QUAGGA_WEBAPP.
   * Default value when not specified in API or module is interpreted by Avi Controller as FE_PROXY_ROUTE_PUBLISH_NONE.
   * @param mode set the mode.
   */
  public void setMode(String  mode) {
    this.mode = mode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Listener port for publisher.
   * Default value when not specified in API or module is interpreted by Avi Controller as 80.
   * @return publisherPort
   */
  public Integer getPublisherPort() {
    return publisherPort;
  }

  /**
   * This is the setter method to the attribute.
   * Listener port for publisher.
   * Default value when not specified in API or module is interpreted by Avi Controller as 80.
   * @param publisherPort set the publisherPort.
   */
  public void setPublisherPort(Integer  publisherPort) {
    this.publisherPort = publisherPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Subnet for publisher.
   * Default value when not specified in API or module is interpreted by Avi Controller as 32.
   * @return subnet
   */
  public Integer getSubnet() {
    return subnet;
  }

  /**
   * This is the setter method to the attribute.
   * Subnet for publisher.
   * Default value when not specified in API or module is interpreted by Avi Controller as 32.
   * @param subnet set the subnet.
   */
  public void setSubnet(Integer  subnet) {
    this.subnet = subnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Token for tracking changes.
   * @return token
   */
  public String getToken() {
    return token;
  }

  /**
   * This is the setter method to the attribute.
   * Token for tracking changes.
   * @param token set the token.
   */
  public void setToken(String  token) {
    this.token = token;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  FeProxyRoutePublishConfig objFeProxyRoutePublishConfig = (FeProxyRoutePublishConfig) o;
  return   Objects.equals(this.subnet, objFeProxyRoutePublishConfig.subnet)&&
  Objects.equals(this.token, objFeProxyRoutePublishConfig.token)&&
  Objects.equals(this.publisherPort, objFeProxyRoutePublishConfig.publisherPort)&&
  Objects.equals(this.mode, objFeProxyRoutePublishConfig.mode);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class FeProxyRoutePublishConfig {\n");
      sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("    publisherPort: ").append(toIndentedString(publisherPort)).append("\n");
        sb.append("    subnet: ").append(toIndentedString(subnet)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

