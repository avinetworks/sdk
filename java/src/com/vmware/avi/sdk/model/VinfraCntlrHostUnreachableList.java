package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VinfraCntlrHostUnreachableList is a POJO class extends AviRestResource that used for creating
 * VinfraCntlrHostUnreachableList.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VinfraCntlrHostUnreachableList  {
    @JsonProperty("host_name")
    private List<String> hostName = null;

    @JsonProperty("vcenter")
    private String vcenter = null;


  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property host_name of obj type vinfracntlrhostunreachablelist field type str  type array.
   * @return hostName
   */
  public List<String> getHostName() {
    return hostName;
  }

  /**
   * This is the setter method. this will set the hostName
   * Placeholder for description of property host_name of obj type vinfracntlrhostunreachablelist field type str  type array.
   * @return hostName
   */
  public void setHostName(List<String>  hostName) {
    this.hostName = hostName;
  }

  /**
   * This is the setter method this will set the hostName
   * Placeholder for description of property host_name of obj type vinfracntlrhostunreachablelist field type str  type array.
   * @return hostName
   */
  public VinfraCntlrHostUnreachableList addHostNameItem(String hostNameItem) {
    if (this.hostName == null) {
      this.hostName = new ArrayList<String>();
    }
    this.hostName.add(hostNameItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter of obj type vinfracntlrhostunreachablelist field type str  type string.
   * @return vcenter
   */
  public String getVcenter() {
    return vcenter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter of obj type vinfracntlrhostunreachablelist field type str  type string.
   * @param vcenter set the vcenter.
   */
  public void setVcenter(String  vcenter) {
    this.vcenter = vcenter;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VinfraCntlrHostUnreachableList objVinfraCntlrHostUnreachableList = (VinfraCntlrHostUnreachableList) o;
  return   Objects.equals(this.vcenter, objVinfraCntlrHostUnreachableList.vcenter)&&
  Objects.equals(this.hostName, objVinfraCntlrHostUnreachableList.hostName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VinfraCntlrHostUnreachableList {\n");
      sb.append("    hostName: ").append(toIndentedString(hostName)).append("\n");
        sb.append("    vcenter: ").append(toIndentedString(vcenter)).append("\n");
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

