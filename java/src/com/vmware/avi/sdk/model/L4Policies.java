package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The L4Policies is a POJO class extends AviRestResource that used for creating
 * L4Policies.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class L4Policies  {
    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("l4_policy_set_ref")
    private String l4PolicySetRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * Index of the virtual service l4 policy set.
   * Field introduced in 17.2.7.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Index of the virtual service l4 policy set.
   * Field introduced in 17.2.7.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Id of the virtual service l4 policy set.
   * It is a reference to an object of type l4policyset.
   * Field introduced in 17.2.7.
   * @return l4PolicySetRef
   */
  public String getL4PolicySetRef() {
    return l4PolicySetRef;
  }

  /**
   * This is the setter method to the attribute.
   * Id of the virtual service l4 policy set.
   * It is a reference to an object of type l4policyset.
   * Field introduced in 17.2.7.
   * @param l4PolicySetRef set the l4PolicySetRef.
   */
  public void setL4PolicySetRef(String  l4PolicySetRef) {
    this.l4PolicySetRef = l4PolicySetRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  L4Policies objL4Policies = (L4Policies) o;
  return   Objects.equals(this.index, objL4Policies.index)&&
  Objects.equals(this.l4PolicySetRef, objL4Policies.l4PolicySetRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class L4Policies {\n");
      sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    l4PolicySetRef: ").append(toIndentedString(l4PolicySetRef)).append("\n");
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

