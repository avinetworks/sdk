package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The TenantConfiguration is a POJO class extends AviRestResource that used for creating
 * TenantConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TenantConfiguration  {
    @JsonProperty("se_in_provider_context")
    private Boolean seInProviderContext = true;

    @JsonProperty("tenant_access_to_provider_se")
    private Boolean tenantAccessToProviderSe = true;

    @JsonProperty("tenant_vrf")
    private Boolean tenantVrf = false;



  /**
   * This is the getter method this will return the attribute value.
   * Controls the ownership of serviceengines.
   * Service engines can either be exclusively owned by each tenant or owned by the administrator and shared by all tenants.
   * When serviceengines are owned by the administrator, each tenant can have either read access or no access to their service engines.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return seInProviderContext
   */
  public Boolean getSeInProviderContext() {
    return seInProviderContext;
  }

  /**
   * This is the setter method to the attribute.
   * Controls the ownership of serviceengines.
   * Service engines can either be exclusively owned by each tenant or owned by the administrator and shared by all tenants.
   * When serviceengines are owned by the administrator, each tenant can have either read access or no access to their service engines.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param seInProviderContext set the seInProviderContext.
   */
  public void setSeInProviderContext(Boolean  seInProviderContext) {
    this.seInProviderContext = seInProviderContext;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tenant_access_to_provider_se of obj type tenantconfiguration field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return tenantAccessToProviderSe
   */
  public Boolean getTenantAccessToProviderSe() {
    return tenantAccessToProviderSe;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property tenant_access_to_provider_se of obj type tenantconfiguration field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param tenantAccessToProviderSe set the tenantAccessToProviderSe.
   */
  public void setTenantAccessToProviderSe(Boolean  tenantAccessToProviderSe) {
    this.tenantAccessToProviderSe = tenantAccessToProviderSe;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When 'per tenant ip domain' is selected, each tenant gets its own routing domain that is not shared with any other tenant.
   * When 'share ip domain across all tenants' is selected, all tenants share the same routing domain.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return tenantVrf
   */
  public Boolean getTenantVrf() {
    return tenantVrf;
  }

  /**
   * This is the setter method to the attribute.
   * When 'per tenant ip domain' is selected, each tenant gets its own routing domain that is not shared with any other tenant.
   * When 'share ip domain across all tenants' is selected, all tenants share the same routing domain.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param tenantVrf set the tenantVrf.
   */
  public void setTenantVrf(Boolean  tenantVrf) {
    this.tenantVrf = tenantVrf;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  TenantConfiguration objTenantConfiguration = (TenantConfiguration) o;
  return   Objects.equals(this.seInProviderContext, objTenantConfiguration.seInProviderContext)&&
  Objects.equals(this.tenantAccessToProviderSe, objTenantConfiguration.tenantAccessToProviderSe)&&
  Objects.equals(this.tenantVrf, objTenantConfiguration.tenantVrf);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class TenantConfiguration {\n");
      sb.append("    seInProviderContext: ").append(toIndentedString(seInProviderContext)).append("\n");
        sb.append("    tenantAccessToProviderSe: ").append(toIndentedString(tenantAccessToProviderSe)).append("\n");
        sb.append("    tenantVrf: ").append(toIndentedString(tenantVrf)).append("\n");
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

