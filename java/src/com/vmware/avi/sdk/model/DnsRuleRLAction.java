package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsRuleRLAction is a POJO class extends AviRestResource that used for creating
 * DnsRuleRLAction.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsRuleRLAction  {
    @JsonProperty("type")
    private String type = "DNS_RL_ACTION_NONE";



  /**
   * This is the getter method this will return the attribute value.
   * Type of action to be enforced upon hitting the rate limit.
   * Enum options - DNS_RL_ACTION_NONE, DNS_RL_ACTION_DROP_REQ.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as DNS_RL_ACTION_NONE.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Type of action to be enforced upon hitting the rate limit.
   * Enum options - DNS_RL_ACTION_NONE, DNS_RL_ACTION_DROP_REQ.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as DNS_RL_ACTION_NONE.
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
  DnsRuleRLAction objDnsRuleRLAction = (DnsRuleRLAction) o;
  return   Objects.equals(this.type, objDnsRuleRLAction.type);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsRuleRLAction {\n");
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

