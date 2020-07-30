package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NatPolicyAction is a POJO class extends AviRestResource that used for creating
 * NatPolicyAction.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NatPolicyAction  {
    @JsonProperty("nat_info")
    private List<NatAddrInfo> natInfo = null;

    @JsonProperty("type")
    private String type = null;


  /**
   * This is the getter method this will return the attribute value.
   * Pool of ip addresses used for nat.
   * Field introduced in 18.2.5.
   * @return natInfo
   */
  public List<NatAddrInfo> getNatInfo() {
    return natInfo;
  }

  /**
   * This is the setter method. this will set the natInfo
   * Pool of ip addresses used for nat.
   * Field introduced in 18.2.5.
   * @return natInfo
   */
  public void setNatInfo(List<NatAddrInfo>  natInfo) {
    this.natInfo = natInfo;
  }

  /**
   * This is the setter method this will set the natInfo
   * Pool of ip addresses used for nat.
   * Field introduced in 18.2.5.
   * @return natInfo
   */
  public NatPolicyAction addNatInfoItem(NatAddrInfo natInfoItem) {
    if (this.natInfo == null) {
      this.natInfo = new ArrayList<NatAddrInfo>();
    }
    this.natInfo.add(natInfoItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Nat action type.
   * Enum options - NAT_POLICY_ACTION_TYPE_DYNAMIC_IP_PORT.
   * Field introduced in 18.2.5.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Nat action type.
   * Enum options - NAT_POLICY_ACTION_TYPE_DYNAMIC_IP_PORT.
   * Field introduced in 18.2.5.
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
  NatPolicyAction objNatPolicyAction = (NatPolicyAction) o;
  return   Objects.equals(this.type, objNatPolicyAction.type)&&
  Objects.equals(this.natInfo, objNatPolicyAction.natInfo);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NatPolicyAction {\n");
      sb.append("    natInfo: ").append(toIndentedString(natInfo)).append("\n");
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

