package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudTenantsDeleted is a POJO class extends AviRestResource that used for creating
 * CloudTenantsDeleted.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudTenantsDeleted  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("tenants")
    private List<CloudTenantCleanup> tenants = null;

    @JsonProperty("vtype")
    private String vtype = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type cloudtenantsdeleted field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type cloudtenantsdeleted field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tenants of obj type cloudtenantsdeleted field type str  type array.
   * @return tenants
   */
  public List<CloudTenantCleanup> getTenants() {
    return tenants;
  }

  /**
   * This is the setter method. this will set the tenants
   * Placeholder for description of property tenants of obj type cloudtenantsdeleted field type str  type array.
   * @return tenants
   */
  public void setTenants(List<CloudTenantCleanup>  tenants) {
    this.tenants = tenants;
  }

  /**
   * This is the setter method this will set the tenants
   * Placeholder for description of property tenants of obj type cloudtenantsdeleted field type str  type array.
   * @return tenants
   */
  public CloudTenantsDeleted addTenantsItem(CloudTenantCleanup tenantsItem) {
    if (this.tenants == null) {
      this.tenants = new ArrayList<CloudTenantCleanup>();
    }
    this.tenants.add(tenantsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * @return vtype
   */
  public String getVtype() {
    return vtype;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * @param vtype set the vtype.
   */
  public void setVtype(String  vtype) {
    this.vtype = vtype;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CloudTenantsDeleted objCloudTenantsDeleted = (CloudTenantsDeleted) o;
  return   Objects.equals(this.vtype, objCloudTenantsDeleted.vtype)&&
  Objects.equals(this.tenants, objCloudTenantsDeleted.tenants)&&
  Objects.equals(this.ccId, objCloudTenantsDeleted.ccId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudTenantsDeleted {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    tenants: ").append(toIndentedString(tenants)).append("\n");
        sb.append("    vtype: ").append(toIndentedString(vtype)).append("\n");
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

