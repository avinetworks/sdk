package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DNSConfig is a POJO class extends AviRestResource that used for creating
 * DNSConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNSConfig  {
    @JsonProperty("domain_name")
    private String domainName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Gslb subdomain used for gslb service fqdn match and placement.
   * @return domainName
   */
  public String getDomainName() {
    return domainName;
  }

  /**
   * This is the setter method to the attribute.
   * Gslb subdomain used for gslb service fqdn match and placement.
   * @param domainName set the domainName.
   */
  public void setDomainName(String  domainName) {
    this.domainName = domainName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DNSConfig objDNSConfig = (DNSConfig) o;
  return   Objects.equals(this.domainName, objDNSConfig.domainName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DNSConfig {\n");
      sb.append("    domainName: ").append(toIndentedString(domainName)).append("\n");
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

