package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeIpfailureEventDetails is a POJO class extends AviRestResource that used for creating
 * SeIpfailureEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeIpfailureEventDetails  {
    @JsonProperty("mac")
    private String mac = null;

    @JsonProperty("network_uuid")
    private String networkUuid = null;

    @JsonProperty("se_ref")
    private String seRef = null;

    @JsonProperty("vnic_name")
    private String vnicName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Mac address.
   * @return mac
   */
  public String getMac() {
    return mac;
  }

  /**
   * This is the setter method to the attribute.
   * Mac address.
   * @param mac set the mac.
   */
  public void setMac(String  mac) {
    this.mac = mac;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Network uuid.
   * @return networkUuid
   */
  public String getNetworkUuid() {
    return networkUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Network uuid.
   * @param networkUuid set the networkUuid.
   */
  public void setNetworkUuid(String  networkUuid) {
    this.networkUuid = networkUuid;
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

  /**
   * This is the getter method this will return the attribute value.
   * Vnic name.
   * @return vnicName
   */
  public String getVnicName() {
    return vnicName;
  }

  /**
   * This is the setter method to the attribute.
   * Vnic name.
   * @param vnicName set the vnicName.
   */
  public void setVnicName(String  vnicName) {
    this.vnicName = vnicName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeIpfailureEventDetails objSeIpfailureEventDetails = (SeIpfailureEventDetails) o;
  return   Objects.equals(this.mac, objSeIpfailureEventDetails.mac)&&
  Objects.equals(this.networkUuid, objSeIpfailureEventDetails.networkUuid)&&
  Objects.equals(this.seRef, objSeIpfailureEventDetails.seRef)&&
  Objects.equals(this.vnicName, objSeIpfailureEventDetails.vnicName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeIpfailureEventDetails {\n");
      sb.append("    mac: ").append(toIndentedString(mac)).append("\n");
        sb.append("    networkUuid: ").append(toIndentedString(networkUuid)).append("\n");
        sb.append("    seRef: ").append(toIndentedString(seRef)).append("\n");
        sb.append("    vnicName: ").append(toIndentedString(vnicName)).append("\n");
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

