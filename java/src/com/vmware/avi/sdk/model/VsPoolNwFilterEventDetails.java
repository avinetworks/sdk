package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VsPoolNwFilterEventDetails is a POJO class extends AviRestResource that used for creating
 * VsPoolNwFilterEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VsPoolNwFilterEventDetails  {
    @JsonProperty("filter")
    private String filter = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("network")
    private String network = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property filter of obj type vspoolnwfiltereventdetails field type str  type string.
   * @return filter
   */
  public String getFilter() {
    return filter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property filter of obj type vspoolnwfiltereventdetails field type str  type string.
   * @param filter set the filter.
   */
  public void setFilter(String  filter) {
    this.filter = filter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property network of obj type vspoolnwfiltereventdetails field type str  type string.
   * @return network
   */
  public String getNetwork() {
    return network;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property network of obj type vspoolnwfiltereventdetails field type str  type string.
   * @param network set the network.
   */
  public void setNetwork(String  network) {
    this.network = network;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VsPoolNwFilterEventDetails objVsPoolNwFilterEventDetails = (VsPoolNwFilterEventDetails) o;
  return   Objects.equals(this.filter, objVsPoolNwFilterEventDetails.filter)&&
  Objects.equals(this.name, objVsPoolNwFilterEventDetails.name)&&
  Objects.equals(this.network, objVsPoolNwFilterEventDetails.network);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VsPoolNwFilterEventDetails {\n");
      sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    network: ").append(toIndentedString(network)).append("\n");
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

