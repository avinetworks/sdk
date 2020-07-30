package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsClientIpMatch is a POJO class extends AviRestResource that used for creating
 * DnsClientIpMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsClientIpMatch  {
    @JsonProperty("client_ip")
    private IpAddrMatch clientIp = null;

    @JsonProperty("use_edns_client_subnet_ip")
    private Boolean useEdnsClientSubnetIp = true;



  /**
   * This is the getter method this will return the attribute value.
   * Ip addresses to match against client ip.
   * Field introduced in 17.1.6,17.2.2.
   * @return clientIp
   */
  public IpAddrMatch getClientIp() {
    return clientIp;
  }

  /**
   * This is the setter method to the attribute.
   * Ip addresses to match against client ip.
   * Field introduced in 17.1.6,17.2.2.
   * @param clientIp set the clientIp.
   */
  public void setClientIp(IpAddrMatch clientIp) {
    this.clientIp = clientIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use the ip address from the edns client subnet option, if available, as the source ip address of the client.
   * It should be noted that the edns subnet ip may not be a /32 ip address.
   * Field introduced in 17.1.6,17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return useEdnsClientSubnetIp
   */
  public Boolean getUseEdnsClientSubnetIp() {
    return useEdnsClientSubnetIp;
  }

  /**
   * This is the setter method to the attribute.
   * Use the ip address from the edns client subnet option, if available, as the source ip address of the client.
   * It should be noted that the edns subnet ip may not be a /32 ip address.
   * Field introduced in 17.1.6,17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param useEdnsClientSubnetIp set the useEdnsClientSubnetIp.
   */
  public void setUseEdnsClientSubnetIp(Boolean  useEdnsClientSubnetIp) {
    this.useEdnsClientSubnetIp = useEdnsClientSubnetIp;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsClientIpMatch objDnsClientIpMatch = (DnsClientIpMatch) o;
  return   Objects.equals(this.clientIp, objDnsClientIpMatch.clientIp)&&
  Objects.equals(this.useEdnsClientSubnetIp, objDnsClientIpMatch.useEdnsClientSubnetIp);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsClientIpMatch {\n");
      sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
        sb.append("    useEdnsClientSubnetIp: ").append(toIndentedString(useEdnsClientSubnetIp)).append("\n");
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

