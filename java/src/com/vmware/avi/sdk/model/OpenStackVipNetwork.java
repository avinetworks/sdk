package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OpenStackVipNetwork is a POJO class extends AviRestResource that used for creating
 * OpenStackVipNetwork.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenStackVipNetwork  {
    @JsonProperty("os_network_uuid")
    private String osNetworkUuid = null;

    @JsonProperty("os_tenant_uuids")
    private List<String> osTenantUuids = null;



  /**
   * This is the getter method this will return the attribute value.
   * Neutron network uuid.
   * Field introduced in 18.1.2.
   * @return osNetworkUuid
   */
  public String getOsNetworkUuid() {
    return osNetworkUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Neutron network uuid.
   * Field introduced in 18.1.2.
   * @param osNetworkUuid set the osNetworkUuid.
   */
  public void setOsNetworkUuid(String  osNetworkUuid) {
    this.osNetworkUuid = osNetworkUuid;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Uuids of openstack tenants that should be allowed to use the specified neutron network for vips.
   * Use '*' to make this network available to all tenants.
   * Field introduced in 18.1.2.
   * @return osTenantUuids
   */
  public List<String> getOsTenantUuids() {
    return osTenantUuids;
  }

  /**
   * This is the setter method. this will set the osTenantUuids
   * Uuids of openstack tenants that should be allowed to use the specified neutron network for vips.
   * Use '*' to make this network available to all tenants.
   * Field introduced in 18.1.2.
   * @return osTenantUuids
   */
  public void setOsTenantUuids(List<String>  osTenantUuids) {
    this.osTenantUuids = osTenantUuids;
  }

  /**
   * This is the setter method this will set the osTenantUuids
   * Uuids of openstack tenants that should be allowed to use the specified neutron network for vips.
   * Use '*' to make this network available to all tenants.
   * Field introduced in 18.1.2.
   * @return osTenantUuids
   */
  public OpenStackVipNetwork addOsTenantUuidsItem(String osTenantUuidsItem) {
    if (this.osTenantUuids == null) {
      this.osTenantUuids = new ArrayList<String>();
    }
    this.osTenantUuids.add(osTenantUuidsItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OpenStackVipNetwork objOpenStackVipNetwork = (OpenStackVipNetwork) o;
  return   Objects.equals(this.osNetworkUuid, objOpenStackVipNetwork.osNetworkUuid)&&
  Objects.equals(this.osTenantUuids, objOpenStackVipNetwork.osTenantUuids);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OpenStackVipNetwork {\n");
      sb.append("    osNetworkUuid: ").append(toIndentedString(osNetworkUuid)).append("\n");
        sb.append("    osTenantUuids: ").append(toIndentedString(osTenantUuids)).append("\n");
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

