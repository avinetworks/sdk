package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OpenStackVnicChange is a POJO class extends AviRestResource that used for creating
 * OpenStackVnicChange.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenStackVnicChange  {
    @JsonProperty("error_string")
    private String errorString = null;

    @JsonProperty("mac_addrs")
    private List<String> macAddrs = null;

    @JsonProperty("networks")
    private List<String> networks = null;

    @JsonProperty("se_vm_uuid")
    private String seVmUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error_string of obj type openstackvnicchange field type str  type string.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error_string of obj type openstackvnicchange field type str  type string.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mac_addrs of obj type openstackvnicchange field type str  type array.
   * @return macAddrs
   */
  public List<String> getMacAddrs() {
    return macAddrs;
  }

  /**
   * This is the setter method. this will set the macAddrs
   * Placeholder for description of property mac_addrs of obj type openstackvnicchange field type str  type array.
   * @return macAddrs
   */
  public void setMacAddrs(List<String>  macAddrs) {
    this.macAddrs = macAddrs;
  }

  /**
   * This is the setter method this will set the macAddrs
   * Placeholder for description of property mac_addrs of obj type openstackvnicchange field type str  type array.
   * @return macAddrs
   */
  public OpenStackVnicChange addMacAddrsItem(String macAddrsItem) {
    if (this.macAddrs == null) {
      this.macAddrs = new ArrayList<String>();
    }
    this.macAddrs.add(macAddrsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property networks of obj type openstackvnicchange field type str  type array.
   * @return networks
   */
  public List<String> getNetworks() {
    return networks;
  }

  /**
   * This is the setter method. this will set the networks
   * Placeholder for description of property networks of obj type openstackvnicchange field type str  type array.
   * @return networks
   */
  public void setNetworks(List<String>  networks) {
    this.networks = networks;
  }

  /**
   * This is the setter method this will set the networks
   * Placeholder for description of property networks of obj type openstackvnicchange field type str  type array.
   * @return networks
   */
  public OpenStackVnicChange addNetworksItem(String networksItem) {
    if (this.networks == null) {
      this.networks = new ArrayList<String>();
    }
    this.networks.add(networksItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of se_vm.
   * @return seVmUuid
   */
  public String getSeVmUuid() {
    return seVmUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of se_vm.
   * @param seVmUuid set the seVmUuid.
   */
  public void setSeVmUuid(String  seVmUuid) {
    this.seVmUuid = seVmUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OpenStackVnicChange objOpenStackVnicChange = (OpenStackVnicChange) o;
  return   Objects.equals(this.seVmUuid, objOpenStackVnicChange.seVmUuid)&&
  Objects.equals(this.networks, objOpenStackVnicChange.networks)&&
  Objects.equals(this.errorString, objOpenStackVnicChange.errorString)&&
  Objects.equals(this.macAddrs, objOpenStackVnicChange.macAddrs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OpenStackVnicChange {\n");
      sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
        sb.append("    macAddrs: ").append(toIndentedString(macAddrs)).append("\n");
        sb.append("    networks: ").append(toIndentedString(networks)).append("\n");
        sb.append("    seVmUuid: ").append(toIndentedString(seVmUuid)).append("\n");
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

