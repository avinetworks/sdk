package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The L4RuleActionSelectPool is a POJO class extends AviRestResource that used for creating
 * L4RuleActionSelectPool.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class L4RuleActionSelectPool  {
    @JsonProperty("action_type")
    private String actionType = null;

    @JsonProperty("pool_group_ref")
    private String poolGroupRef = null;

    @JsonProperty("pool_ref")
    private String poolRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * Indicates action to take on rule match.
   * Enum options - L4_RULE_ACTION_SELECT_POOL, L4_RULE_ACTION_SELECT_POOLGROUP.
   * Field introduced in 17.2.7.
   * @return actionType
   */
  public String getActionType() {
    return actionType;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates action to take on rule match.
   * Enum options - L4_RULE_ACTION_SELECT_POOL, L4_RULE_ACTION_SELECT_POOLGROUP.
   * Field introduced in 17.2.7.
   * @param actionType set the actionType.
   */
  public void setActionType(String  actionType) {
    this.actionType = actionType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Id of the pool group to serve the request.
   * It is a reference to an object of type poolgroup.
   * Field introduced in 17.2.7.
   * @return poolGroupRef
   */
  public String getPoolGroupRef() {
    return poolGroupRef;
  }

  /**
   * This is the setter method to the attribute.
   * Id of the pool group to serve the request.
   * It is a reference to an object of type poolgroup.
   * Field introduced in 17.2.7.
   * @param poolGroupRef set the poolGroupRef.
   */
  public void setPoolGroupRef(String  poolGroupRef) {
    this.poolGroupRef = poolGroupRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Id of the pool of servers to serve the request.
   * It is a reference to an object of type pool.
   * Field introduced in 17.2.7.
   * @return poolRef
   */
  public String getPoolRef() {
    return poolRef;
  }

  /**
   * This is the setter method to the attribute.
   * Id of the pool of servers to serve the request.
   * It is a reference to an object of type pool.
   * Field introduced in 17.2.7.
   * @param poolRef set the poolRef.
   */
  public void setPoolRef(String  poolRef) {
    this.poolRef = poolRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  L4RuleActionSelectPool objL4RuleActionSelectPool = (L4RuleActionSelectPool) o;
  return   Objects.equals(this.poolRef, objL4RuleActionSelectPool.poolRef)&&
  Objects.equals(this.poolGroupRef, objL4RuleActionSelectPool.poolGroupRef)&&
  Objects.equals(this.actionType, objL4RuleActionSelectPool.actionType);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class L4RuleActionSelectPool {\n");
      sb.append("    actionType: ").append(toIndentedString(actionType)).append("\n");
        sb.append("    poolGroupRef: ").append(toIndentedString(poolGroupRef)).append("\n");
        sb.append("    poolRef: ").append(toIndentedString(poolRef)).append("\n");
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

