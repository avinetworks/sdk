package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AlertFilter is a POJO class extends AviRestResource that used for creating
 * AlertFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertFilter  {
    @JsonProperty("filter_action")
    private String filterAction = null;

    @JsonProperty("filter_string")
    private String filterString = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property filter_action of obj type alertfilter field type str  type string.
   * @return filterAction
   */
  public String getFilterAction() {
    return filterAction;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property filter_action of obj type alertfilter field type str  type string.
   * @param filterAction set the filterAction.
   */
  public void setFilterAction(String  filterAction) {
    this.filterAction = filterAction;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property filter_string of obj type alertfilter field type str  type string.
   * @return filterString
   */
  public String getFilterString() {
    return filterString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property filter_string of obj type alertfilter field type str  type string.
   * @param filterString set the filterString.
   */
  public void setFilterString(String  filterString) {
    this.filterString = filterString;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AlertFilter objAlertFilter = (AlertFilter) o;
  return   Objects.equals(this.filterString, objAlertFilter.filterString)&&
  Objects.equals(this.filterAction, objAlertFilter.filterAction);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AlertFilter {\n");
      sb.append("    filterAction: ").append(toIndentedString(filterAction)).append("\n");
        sb.append("    filterString: ").append(toIndentedString(filterString)).append("\n");
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

