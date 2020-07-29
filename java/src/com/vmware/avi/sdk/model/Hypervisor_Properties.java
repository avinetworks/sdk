package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Hypervisor_Properties is a POJO class extends AviRestResource that used for creating
 * Hypervisor_Properties.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hypervisor_Properties  {
    @JsonProperty("htype")
    private String htype = null;

    @JsonProperty("max_ips_per_nic")
    private Integer maxIpsPerNic = null;

    @JsonProperty("max_nics")
    private Integer maxNics = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - DEFAULT, VMWARE_ESX, KVM, VMWARE_VSAN, XEN.
   * @return htype
   */
  public String getHtype() {
    return htype;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - DEFAULT, VMWARE_ESX, KVM, VMWARE_VSAN, XEN.
   * @param htype set the htype.
   */
  public void setHtype(String  htype) {
    this.htype = htype;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property max_ips_per_nic of obj type hypervisor_properties field type str  type integer.
   * @return maxIpsPerNic
   */
  public Integer getMaxIpsPerNic() {
    return maxIpsPerNic;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property max_ips_per_nic of obj type hypervisor_properties field type str  type integer.
   * @param maxIpsPerNic set the maxIpsPerNic.
   */
  public void setMaxIpsPerNic(Integer  maxIpsPerNic) {
    this.maxIpsPerNic = maxIpsPerNic;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property max_nics of obj type hypervisor_properties field type str  type integer.
   * @return maxNics
   */
  public Integer getMaxNics() {
    return maxNics;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property max_nics of obj type hypervisor_properties field type str  type integer.
   * @param maxNics set the maxNics.
   */
  public void setMaxNics(Integer  maxNics) {
    this.maxNics = maxNics;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Hypervisor_Properties objHypervisor_Properties = (Hypervisor_Properties) o;
  return   Objects.equals(this.htype, objHypervisor_Properties.htype)&&
  Objects.equals(this.maxNics, objHypervisor_Properties.maxNics)&&
  Objects.equals(this.maxIpsPerNic, objHypervisor_Properties.maxIpsPerNic);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Hypervisor_Properties {\n");
      sb.append("    htype: ").append(toIndentedString(htype)).append("\n");
        sb.append("    maxIpsPerNic: ").append(toIndentedString(maxIpsPerNic)).append("\n");
        sb.append("    maxNics: ").append(toIndentedString(maxNics)).append("\n");
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

