package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AttackMitigationAction is a POJO class extends AviRestResource that used for creating
 * AttackMitigationAction.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttackMitigationAction  {
    @JsonProperty("deny")
    private Boolean deny = true;



  /**
   * This is the getter method this will return the attribute value.
   * Deny the attack packets further processing and drop them.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return deny
   */
  public Boolean getDeny() {
    return deny;
  }

  /**
   * This is the setter method to the attribute.
   * Deny the attack packets further processing and drop them.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param deny set the deny.
   */
  public void setDeny(Boolean  deny) {
    this.deny = deny;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AttackMitigationAction objAttackMitigationAction = (AttackMitigationAction) o;
  return   Objects.equals(this.deny, objAttackMitigationAction.deny);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AttackMitigationAction {\n");
      sb.append("    deny: ").append(toIndentedString(deny)).append("\n");
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

