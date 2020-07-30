package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VinfraVmDetails is a POJO class extends AviRestResource that used for creating
 * VinfraVmDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VinfraVmDetails  {
    @JsonProperty("datacenter")
    private String datacenter = null;

    @JsonProperty("host")
    private String host = null;

    @JsonProperty("name")
    private String name = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property datacenter of obj type vinfravmdetails field type str  type string.
   * @return datacenter
   */
  public String getDatacenter() {
    return datacenter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property datacenter of obj type vinfravmdetails field type str  type string.
   * @param datacenter set the datacenter.
   */
  public void setDatacenter(String  datacenter) {
    this.datacenter = datacenter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property host of obj type vinfravmdetails field type str  type string.
   * @return host
   */
  public String getHost() {
    return host;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property host of obj type vinfravmdetails field type str  type string.
   * @param host set the host.
   */
  public void setHost(String  host) {
    this.host = host;
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


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VinfraVmDetails objVinfraVmDetails = (VinfraVmDetails) o;
  return   Objects.equals(this.name, objVinfraVmDetails.name)&&
  Objects.equals(this.datacenter, objVinfraVmDetails.datacenter)&&
  Objects.equals(this.host, objVinfraVmDetails.host);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VinfraVmDetails {\n");
      sb.append("    datacenter: ").append(toIndentedString(datacenter)).append("\n");
        sb.append("    host: ").append(toIndentedString(host)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

