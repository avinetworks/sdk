package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The LicenseTransactionDetails is a POJO class extends AviRestResource that used for creating
 * LicenseTransactionDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LicenseTransactionDetails  {
    @JsonProperty("cookie")
    private String cookie = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("licensed_service_cores")
    private Float licensedServiceCores = null;

    @JsonProperty("operation")
    private String operation = null;

    @JsonProperty("overdraft")
    private Boolean overdraft = null;

    @JsonProperty("service_cores")
    private Float serviceCores = null;

    @JsonProperty("tenant_uuid")
    private String tenantUuid = null;

    @JsonProperty("tier")
    private String tier = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cookie of obj type licensetransactiondetails field type str  type string.
   * @return cookie
   */
  public String getCookie() {
    return cookie;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cookie of obj type licensetransactiondetails field type str  type string.
   * @param cookie set the cookie.
   */
  public void setCookie(String  cookie) {
    this.cookie = cookie;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User defined description for the object.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * User defined description for the object.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property id of obj type licensetransactiondetails field type str  type string.
   * @return id
   */
  public String getId() {
    return id;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property id of obj type licensetransactiondetails field type str  type string.
   * @param id set the id.
   */
  public void setId(String  id) {
    this.id = id;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property licensed_service_cores of obj type licensetransactiondetails field type str  type float.
   * @return licensedServiceCores
   */
  public Float getLicensedServiceCores() {
    return licensedServiceCores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property licensed_service_cores of obj type licensetransactiondetails field type str  type float.
   * @param licensedServiceCores set the licensedServiceCores.
   */
  public void setLicensedServiceCores(Float  licensedServiceCores) {
    this.licensedServiceCores = licensedServiceCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property operation of obj type licensetransactiondetails field type str  type string.
   * @return operation
   */
  public String getOperation() {
    return operation;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property operation of obj type licensetransactiondetails field type str  type string.
   * @param operation set the operation.
   */
  public void setOperation(String  operation) {
    this.operation = operation;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property overdraft of obj type licensetransactiondetails field type str  type boolean.
   * @return overdraft
   */
  public Boolean getOverdraft() {
    return overdraft;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property overdraft of obj type licensetransactiondetails field type str  type boolean.
   * @param overdraft set the overdraft.
   */
  public void setOverdraft(Boolean  overdraft) {
    this.overdraft = overdraft;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property service_cores of obj type licensetransactiondetails field type str  type float.
   * @return serviceCores
   */
  public Float getServiceCores() {
    return serviceCores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property service_cores of obj type licensetransactiondetails field type str  type float.
   * @param serviceCores set the serviceCores.
   */
  public void setServiceCores(Float  serviceCores) {
    this.serviceCores = serviceCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of tenant.
   * @return tenantUuid
   */
  public String getTenantUuid() {
    return tenantUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of tenant.
   * @param tenantUuid set the tenantUuid.
   */
  public void setTenantUuid(String  tenantUuid) {
    this.tenantUuid = tenantUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tier of obj type licensetransactiondetails field type str  type string.
   * @return tier
   */
  public String getTier() {
    return tier;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property tier of obj type licensetransactiondetails field type str  type string.
   * @param tier set the tier.
   */
  public void setTier(String  tier) {
    this.tier = tier;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  LicenseTransactionDetails objLicenseTransactionDetails = (LicenseTransactionDetails) o;
  return   Objects.equals(this.description, objLicenseTransactionDetails.description)&&
  Objects.equals(this.overdraft, objLicenseTransactionDetails.overdraft)&&
  Objects.equals(this.id, objLicenseTransactionDetails.id)&&
  Objects.equals(this.cookie, objLicenseTransactionDetails.cookie)&&
  Objects.equals(this.tier, objLicenseTransactionDetails.tier)&&
  Objects.equals(this.licensedServiceCores, objLicenseTransactionDetails.licensedServiceCores)&&
  Objects.equals(this.operation, objLicenseTransactionDetails.operation)&&
  Objects.equals(this.serviceCores, objLicenseTransactionDetails.serviceCores)&&
  Objects.equals(this.tenantUuid, objLicenseTransactionDetails.tenantUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class LicenseTransactionDetails {\n");
      sb.append("    cookie: ").append(toIndentedString(cookie)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    licensedServiceCores: ").append(toIndentedString(licensedServiceCores)).append("\n");
        sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
        sb.append("    overdraft: ").append(toIndentedString(overdraft)).append("\n");
        sb.append("    serviceCores: ").append(toIndentedString(serviceCores)).append("\n");
        sb.append("    tenantUuid: ").append(toIndentedString(tenantUuid)).append("\n");
        sb.append("    tier: ").append(toIndentedString(tier)).append("\n");
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

