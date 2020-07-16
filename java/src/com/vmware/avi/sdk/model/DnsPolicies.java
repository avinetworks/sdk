package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsPolicies is a POJO class extends AviRestResource that used for creating
 * DnsPolicies.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsPolicies  {
    @JsonProperty("dns_policy_ref")
    private String dnsPolicyRef = null;

    @JsonProperty("index")
    private Integer index = null;



  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the dns policy.
   * It is a reference to an object of type dnspolicy.
   * Field introduced in 17.1.1.
   * @return dnsPolicyRef
   */
  public String getDnsPolicyRef() {
    return dnsPolicyRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the dns policy.
   * It is a reference to an object of type dnspolicy.
   * Field introduced in 17.1.1.
   * @param dnsPolicyRef set the dnsPolicyRef.
   */
  public void setDnsPolicyRef(String  dnsPolicyRef) {
    this.dnsPolicyRef = dnsPolicyRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Index of the dns policy.
   * Field introduced in 17.1.1.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Index of the dns policy.
   * Field introduced in 17.1.1.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsPolicies objDnsPolicies = (DnsPolicies) o;
  return   Objects.equals(this.index, objDnsPolicies.index)&&
  Objects.equals(this.dnsPolicyRef, objDnsPolicies.dnsPolicyRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsPolicies {\n");
      sb.append("    dnsPolicyRef: ").append(toIndentedString(dnsPolicyRef)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
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

