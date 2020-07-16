package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbServiceDownResponse is a POJO class extends AviRestResource that used for creating
 * GslbServiceDownResponse.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbServiceDownResponse  {
    @JsonProperty("fallback_ip")
    private IpAddr fallbackIp = null;

    @JsonProperty("fallback_ip6")
    private IpAddr fallbackIp6 = null;

    @JsonProperty("type")
    private String type = "GSLB_SERVICE_DOWN_RESPONSE_NONE";



  /**
   * This is the getter method this will return the attribute value.
   * Fallback ip address to use in a response to the client query when the gslb service is down.
   * @return fallbackIp
   */
  public IpAddr getFallbackIp() {
    return fallbackIp;
  }

  /**
   * This is the setter method to the attribute.
   * Fallback ip address to use in a response to the client query when the gslb service is down.
   * @param fallbackIp set the fallbackIp.
   */
  public void setFallbackIp(IpAddr fallbackIp) {
    this.fallbackIp = fallbackIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fallback ipv6 address to use in aaaa response to the client query when the gslb service is down.
   * Field introduced in 18.2.8.
   * @return fallbackIp6
   */
  public IpAddr getFallbackIp6() {
    return fallbackIp6;
  }

  /**
   * This is the setter method to the attribute.
   * Fallback ipv6 address to use in aaaa response to the client query when the gslb service is down.
   * Field introduced in 18.2.8.
   * @param fallbackIp6 set the fallbackIp6.
   */
  public void setFallbackIp6(IpAddr fallbackIp6) {
    this.fallbackIp6 = fallbackIp6;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Response from dns service towards the client when the gslb service is down.
   * Enum options - GSLB_SERVICE_DOWN_RESPONSE_NONE, GSLB_SERVICE_DOWN_RESPONSE_ALL_RECORDS, GSLB_SERVICE_DOWN_RESPONSE_FALLBACK_IP,
   * GSLB_SERVICE_DOWN_RESPONSE_EMPTY.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_SERVICE_DOWN_RESPONSE_NONE.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Response from dns service towards the client when the gslb service is down.
   * Enum options - GSLB_SERVICE_DOWN_RESPONSE_NONE, GSLB_SERVICE_DOWN_RESPONSE_ALL_RECORDS, GSLB_SERVICE_DOWN_RESPONSE_FALLBACK_IP,
   * GSLB_SERVICE_DOWN_RESPONSE_EMPTY.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_SERVICE_DOWN_RESPONSE_NONE.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbServiceDownResponse objGslbServiceDownResponse = (GslbServiceDownResponse) o;
  return   Objects.equals(this.fallbackIp6, objGslbServiceDownResponse.fallbackIp6)&&
  Objects.equals(this.type, objGslbServiceDownResponse.type)&&
  Objects.equals(this.fallbackIp, objGslbServiceDownResponse.fallbackIp);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbServiceDownResponse {\n");
      sb.append("    fallbackIp: ").append(toIndentedString(fallbackIp)).append("\n");
        sb.append("    fallbackIp6: ").append(toIndentedString(fallbackIp6)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

