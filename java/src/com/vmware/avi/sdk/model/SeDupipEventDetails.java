package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeDupipEventDetails is a POJO class extends AviRestResource that used for creating
 * SeDupipEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeDupipEventDetails  {
    @JsonProperty("local_mac")
    private String localMac = null;

    @JsonProperty("remote_mac")
    private String remoteMac = null;

    @JsonProperty("vnic_ip")
    private String vnicIp = null;

    @JsonProperty("vnic_name")
    private String vnicName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Mac address.
   * @return localMac
   */
  public String getLocalMac() {
    return localMac;
  }

  /**
   * This is the setter method to the attribute.
   * Mac address.
   * @param localMac set the localMac.
   */
  public void setLocalMac(String  localMac) {
    this.localMac = localMac;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mac address.
   * @return remoteMac
   */
  public String getRemoteMac() {
    return remoteMac;
  }

  /**
   * This is the setter method to the attribute.
   * Mac address.
   * @param remoteMac set the remoteMac.
   */
  public void setRemoteMac(String  remoteMac) {
    this.remoteMac = remoteMac;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vnic ip.
   * @return vnicIp
   */
  public String getVnicIp() {
    return vnicIp;
  }

  /**
   * This is the setter method to the attribute.
   * Vnic ip.
   * @param vnicIp set the vnicIp.
   */
  public void setVnicIp(String  vnicIp) {
    this.vnicIp = vnicIp;
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
  SeDupipEventDetails objSeDupipEventDetails = (SeDupipEventDetails) o;
  return   Objects.equals(this.vnicName, objSeDupipEventDetails.vnicName)&&
  Objects.equals(this.vnicIp, objSeDupipEventDetails.vnicIp)&&
  Objects.equals(this.remoteMac, objSeDupipEventDetails.remoteMac)&&
  Objects.equals(this.localMac, objSeDupipEventDetails.localMac);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeDupipEventDetails {\n");
      sb.append("    localMac: ").append(toIndentedString(localMac)).append("\n");
        sb.append("    remoteMac: ").append(toIndentedString(remoteMac)).append("\n");
        sb.append("    vnicIp: ").append(toIndentedString(vnicIp)).append("\n");
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

