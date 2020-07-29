package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsRuleActionAllowDrop is a POJO class extends AviRestResource that used for creating
 * DnsRuleActionAllowDrop.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsRuleActionAllowDrop  {
    @JsonProperty("allow")
    private Boolean allow = true;

    @JsonProperty("reset_conn")
    private Boolean resetConn = true;



  /**
   * This is the getter method this will return the attribute value.
   * Allow the dns query.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return allow
   */
  public Boolean getAllow() {
    return allow;
  }

  /**
   * This is the setter method to the attribute.
   * Allow the dns query.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param allow set the allow.
   */
  public void setAllow(Boolean  allow) {
    this.allow = allow;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Reset the tcp connection of the dns query, if allow is set to false to drop the query.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return resetConn
   */
  public Boolean getResetConn() {
    return resetConn;
  }

  /**
   * This is the setter method to the attribute.
   * Reset the tcp connection of the dns query, if allow is set to false to drop the query.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param resetConn set the resetConn.
   */
  public void setResetConn(Boolean  resetConn) {
    this.resetConn = resetConn;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsRuleActionAllowDrop objDnsRuleActionAllowDrop = (DnsRuleActionAllowDrop) o;
  return   Objects.equals(this.allow, objDnsRuleActionAllowDrop.allow)&&
  Objects.equals(this.resetConn, objDnsRuleActionAllowDrop.resetConn);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsRuleActionAllowDrop {\n");
      sb.append("    allow: ").append(toIndentedString(allow)).append("\n");
        sb.append("    resetConn: ").append(toIndentedString(resetConn)).append("\n");
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

