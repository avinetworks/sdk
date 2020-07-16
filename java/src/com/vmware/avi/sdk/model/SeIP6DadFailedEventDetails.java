package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeIP6DadFailedEventDetails is a POJO class extends AviRestResource that used for creating
 * SeIP6DadFailedEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeIP6DadFailedEventDetails  {
    @JsonProperty("dad_ip")
    private IpAddr dadIp = null;

    @JsonProperty("if_name")
    private String ifName = null;

    @JsonProperty("se_ref")
    private String seRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * Ipv6 address.
   * @return dadIp
   */
  public IpAddr getDadIp() {
    return dadIp;
  }

  /**
   * This is the setter method to the attribute.
   * Ipv6 address.
   * @param dadIp set the dadIp.
   */
  public void setDadIp(IpAddr dadIp) {
    this.dadIp = dadIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vnic name.
   * @return ifName
   */
  public String getIfName() {
    return ifName;
  }

  /**
   * This is the setter method to the attribute.
   * Vnic name.
   * @param ifName set the ifName.
   */
  public void setIfName(String  ifName) {
    this.ifName = ifName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the se responsible for this event.
   * It is a reference to an object of type serviceengine.
   * @return seRef
   */
  public String getSeRef() {
    return seRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the se responsible for this event.
   * It is a reference to an object of type serviceengine.
   * @param seRef set the seRef.
   */
  public void setSeRef(String  seRef) {
    this.seRef = seRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeIP6DadFailedEventDetails objSeIP6DadFailedEventDetails = (SeIP6DadFailedEventDetails) o;
  return   Objects.equals(this.seRef, objSeIP6DadFailedEventDetails.seRef)&&
  Objects.equals(this.ifName, objSeIP6DadFailedEventDetails.ifName)&&
  Objects.equals(this.dadIp, objSeIP6DadFailedEventDetails.dadIp);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeIP6DadFailedEventDetails {\n");
      sb.append("    dadIp: ").append(toIndentedString(dadIp)).append("\n");
        sb.append("    ifName: ").append(toIndentedString(ifName)).append("\n");
        sb.append("    seRef: ").append(toIndentedString(seRef)).append("\n");
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

