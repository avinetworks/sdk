package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafPositiveSecurityModel is a POJO class extends AviRestResource that used for creating
 * WafPositiveSecurityModel.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafPositiveSecurityModel  {
    @JsonProperty("group_refs")
    private List<String> groupRefs = null;


  /**
   * This is the getter method this will return the attribute value.
   * These groups should be used to separate different levels of concern.
   * The order of the groups matters, one group may mark parts of the request as valid, so that subsequent groups will not check these parts.
   * It is a reference to an object of type wafpolicypsmgroup.
   * Field introduced in 18.2.3.
   * @return groupRefs
   */
  public List<String> getGroupRefs() {
    return groupRefs;
  }

  /**
   * This is the setter method. this will set the groupRefs
   * These groups should be used to separate different levels of concern.
   * The order of the groups matters, one group may mark parts of the request as valid, so that subsequent groups will not check these parts.
   * It is a reference to an object of type wafpolicypsmgroup.
   * Field introduced in 18.2.3.
   * @return groupRefs
   */
  public void setGroupRefs(List<String>  groupRefs) {
    this.groupRefs = groupRefs;
  }

  /**
   * This is the setter method this will set the groupRefs
   * These groups should be used to separate different levels of concern.
   * The order of the groups matters, one group may mark parts of the request as valid, so that subsequent groups will not check these parts.
   * It is a reference to an object of type wafpolicypsmgroup.
   * Field introduced in 18.2.3.
   * @return groupRefs
   */
  public WafPositiveSecurityModel addGroupRefsItem(String groupRefsItem) {
    if (this.groupRefs == null) {
      this.groupRefs = new ArrayList<String>();
    }
    this.groupRefs.add(groupRefsItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  WafPositiveSecurityModel objWafPositiveSecurityModel = (WafPositiveSecurityModel) o;
  return   Objects.equals(this.groupRefs, objWafPositiveSecurityModel.groupRefs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafPositiveSecurityModel {\n");
      sb.append("    groupRefs: ").append(toIndentedString(groupRefs)).append("\n");
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

