package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The L4RuleAction is a POJO class extends AviRestResource that used for creating
 * L4RuleAction.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class L4RuleAction  {
    @JsonProperty("select_pool")
    private L4RuleActionSelectPool selectPool = null;



  /**
   * This is the getter method this will return the attribute value.
   * Indicates pool or pool-group selection on rule match.
   * Field introduced in 17.2.7.
   * @return selectPool
   */
  public L4RuleActionSelectPool getSelectPool() {
    return selectPool;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates pool or pool-group selection on rule match.
   * Field introduced in 17.2.7.
   * @param selectPool set the selectPool.
   */
  public void setSelectPool(L4RuleActionSelectPool selectPool) {
    this.selectPool = selectPool;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  L4RuleAction objL4RuleAction = (L4RuleAction) o;
  return   Objects.equals(this.selectPool, objL4RuleAction.selectPool);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class L4RuleAction {\n");
      sb.append("    selectPool: ").append(toIndentedString(selectPool)).append("\n");
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

