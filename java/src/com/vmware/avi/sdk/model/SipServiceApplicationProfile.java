package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SipServiceApplicationProfile is a POJO class extends AviRestResource that used for creating
 * SipServiceApplicationProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SipServiceApplicationProfile  {
    @JsonProperty("transaction_timeout")
    private Integer transactionTimeout = 32;



  /**
   * This is the getter method this will return the attribute value.
   * Sip transaction timeout in seconds.
   * Allowed values are 2-512.
   * Field introduced in 17.2.8, 18.1.3, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 32.
   * @return transactionTimeout
   */
  public Integer getTransactionTimeout() {
    return transactionTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Sip transaction timeout in seconds.
   * Allowed values are 2-512.
   * Field introduced in 17.2.8, 18.1.3, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 32.
   * @param transactionTimeout set the transactionTimeout.
   */
  public void setTransactionTimeout(Integer  transactionTimeout) {
    this.transactionTimeout = transactionTimeout;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SipServiceApplicationProfile objSipServiceApplicationProfile = (SipServiceApplicationProfile) o;
  return   Objects.equals(this.transactionTimeout, objSipServiceApplicationProfile.transactionTimeout);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SipServiceApplicationProfile {\n");
      sb.append("    transactionTimeout: ").append(toIndentedString(transactionTimeout)).append("\n");
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

