package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PlacementNetwork is a POJO class extends AviRestResource that used for creating
 * PlacementNetwork.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlacementNetwork  {
    @JsonProperty("network_ref")
    private String networkRef = null;

    @JsonProperty("subnet")
    private IpAddrPrefix subnet = null;



  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type network.
   * @return networkRef
   */
  public String getNetworkRef() {
    return networkRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type network.
   * @param networkRef set the networkRef.
   */
  public void setNetworkRef(String  networkRef) {
    this.networkRef = networkRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property subnet of obj type placementnetwork field type str  type ref.
   * @return subnet
   */
  public IpAddrPrefix getSubnet() {
    return subnet;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property subnet of obj type placementnetwork field type str  type ref.
   * @param subnet set the subnet.
   */
  public void setSubnet(IpAddrPrefix subnet) {
    this.subnet = subnet;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  PlacementNetwork objPlacementNetwork = (PlacementNetwork) o;
  return   Objects.equals(this.subnet, objPlacementNetwork.subnet)&&
  Objects.equals(this.networkRef, objPlacementNetwork.networkRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PlacementNetwork {\n");
      sb.append("    networkRef: ").append(toIndentedString(networkRef)).append("\n");
        sb.append("    subnet: ").append(toIndentedString(subnet)).append("\n");
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

