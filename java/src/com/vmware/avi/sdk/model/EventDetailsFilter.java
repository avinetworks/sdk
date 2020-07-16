package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The EventDetailsFilter is a POJO class extends AviRestResource that used for creating
 * EventDetailsFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDetailsFilter  {
    @JsonProperty("comparator")
    private String comparator = "ALERT_OP_EQ";

    @JsonProperty("event_details_key")
    private String eventDetailsKey = null;

    @JsonProperty("event_details_value")
    private String eventDetailsValue = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - ALERT_OP_LT, ALERT_OP_LE, ALERT_OP_EQ, ALERT_OP_NE, ALERT_OP_GE, ALERT_OP_GT.
   * Default value when not specified in API or module is interpreted by Avi Controller as ALERT_OP_EQ.
   * @return comparator
   */
  public String getComparator() {
    return comparator;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - ALERT_OP_LT, ALERT_OP_LE, ALERT_OP_EQ, ALERT_OP_NE, ALERT_OP_GE, ALERT_OP_GT.
   * Default value when not specified in API or module is interpreted by Avi Controller as ALERT_OP_EQ.
   * @param comparator set the comparator.
   */
  public void setComparator(String  comparator) {
    this.comparator = comparator;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property event_details_key of obj type eventdetailsfilter field type str  type string.
   * @return eventDetailsKey
   */
  public String getEventDetailsKey() {
    return eventDetailsKey;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property event_details_key of obj type eventdetailsfilter field type str  type string.
   * @param eventDetailsKey set the eventDetailsKey.
   */
  public void setEventDetailsKey(String  eventDetailsKey) {
    this.eventDetailsKey = eventDetailsKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property event_details_value of obj type eventdetailsfilter field type str  type string.
   * @return eventDetailsValue
   */
  public String getEventDetailsValue() {
    return eventDetailsValue;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property event_details_value of obj type eventdetailsfilter field type str  type string.
   * @param eventDetailsValue set the eventDetailsValue.
   */
  public void setEventDetailsValue(String  eventDetailsValue) {
    this.eventDetailsValue = eventDetailsValue;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  EventDetailsFilter objEventDetailsFilter = (EventDetailsFilter) o;
  return   Objects.equals(this.eventDetailsValue, objEventDetailsFilter.eventDetailsValue)&&
  Objects.equals(this.eventDetailsKey, objEventDetailsFilter.eventDetailsKey)&&
  Objects.equals(this.comparator, objEventDetailsFilter.comparator);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class EventDetailsFilter {\n");
      sb.append("    comparator: ").append(toIndentedString(comparator)).append("\n");
        sb.append("    eventDetailsKey: ").append(toIndentedString(eventDetailsKey)).append("\n");
        sb.append("    eventDetailsValue: ").append(toIndentedString(eventDetailsValue)).append("\n");
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

