package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AzureNetworkInfo is a POJO class extends AviRestResource that used for creating
 * AzureNetworkInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AzureNetworkInfo  {
    @JsonProperty("management_network_id")
    private String managementNetworkId = null;

    @JsonProperty("se_network_id")
    private String seNetworkId = null;

    @JsonProperty("virtual_network_id")
    private String virtualNetworkId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Id of the azure subnet used as management network for the service engines.
   * If set, service engines will have a dedicated management nic, otherwise, they operate in inband mode.
   * Field introduced in 18.2.3.
   * @return managementNetworkId
   */
  public String getManagementNetworkId() {
    return managementNetworkId;
  }

  /**
   * This is the setter method to the attribute.
   * Id of the azure subnet used as management network for the service engines.
   * If set, service engines will have a dedicated management nic, otherwise, they operate in inband mode.
   * Field introduced in 18.2.3.
   * @param managementNetworkId set the managementNetworkId.
   */
  public void setManagementNetworkId(String  managementNetworkId) {
    this.managementNetworkId = managementNetworkId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Id of the azure subnet where avi controller will create the service engines.
   * Field introduced in 17.2.1.
   * @return seNetworkId
   */
  public String getSeNetworkId() {
    return seNetworkId;
  }

  /**
   * This is the setter method to the attribute.
   * Id of the azure subnet where avi controller will create the service engines.
   * Field introduced in 17.2.1.
   * @param seNetworkId set the seNetworkId.
   */
  public void setSeNetworkId(String  seNetworkId) {
    this.seNetworkId = seNetworkId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtual network where virtual ips will belong.
   * Field introduced in 17.2.1.
   * @return virtualNetworkId
   */
  public String getVirtualNetworkId() {
    return virtualNetworkId;
  }

  /**
   * This is the setter method to the attribute.
   * Virtual network where virtual ips will belong.
   * Field introduced in 17.2.1.
   * @param virtualNetworkId set the virtualNetworkId.
   */
  public void setVirtualNetworkId(String  virtualNetworkId) {
    this.virtualNetworkId = virtualNetworkId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AzureNetworkInfo objAzureNetworkInfo = (AzureNetworkInfo) o;
  return   Objects.equals(this.virtualNetworkId, objAzureNetworkInfo.virtualNetworkId)&&
  Objects.equals(this.seNetworkId, objAzureNetworkInfo.seNetworkId)&&
  Objects.equals(this.managementNetworkId, objAzureNetworkInfo.managementNetworkId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AzureNetworkInfo {\n");
      sb.append("    managementNetworkId: ").append(toIndentedString(managementNetworkId)).append("\n");
        sb.append("    seNetworkId: ").append(toIndentedString(seNetworkId)).append("\n");
        sb.append("    virtualNetworkId: ").append(toIndentedString(virtualNetworkId)).append("\n");
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

