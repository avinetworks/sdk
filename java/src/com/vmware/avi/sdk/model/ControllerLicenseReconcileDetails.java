package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ControllerLicenseReconcileDetails is a POJO class extends AviRestResource that used for creating
 * ControllerLicenseReconcileDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerLicenseReconcileDetails  {
    @JsonProperty("new_available_service_cores")
    private Float newAvailableServiceCores = null;

    @JsonProperty("new_consumed_service_cores")
    private Float newConsumedServiceCores = null;

    @JsonProperty("new_escrow_service_cores")
    private Float newEscrowServiceCores = null;

    @JsonProperty("new_remaining_service_cores")
    private Float newRemainingServiceCores = null;

    @JsonProperty("old_available_service_cores")
    private Float oldAvailableServiceCores = null;

    @JsonProperty("old_consumed_service_cores")
    private Float oldConsumedServiceCores = null;

    @JsonProperty("old_escrow_service_cores")
    private Float oldEscrowServiceCores = null;

    @JsonProperty("old_remaining_service_cores")
    private Float oldRemainingServiceCores = null;

    @JsonProperty("tenant_uuid")
    private String tenantUuid = null;

    @JsonProperty("tier")
    private String tier = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property new_available_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @return newAvailableServiceCores
   */
  public Float getNewAvailableServiceCores() {
    return newAvailableServiceCores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property new_available_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @param newAvailableServiceCores set the newAvailableServiceCores.
   */
  public void setNewAvailableServiceCores(Float  newAvailableServiceCores) {
    this.newAvailableServiceCores = newAvailableServiceCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property new_consumed_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @return newConsumedServiceCores
   */
  public Float getNewConsumedServiceCores() {
    return newConsumedServiceCores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property new_consumed_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @param newConsumedServiceCores set the newConsumedServiceCores.
   */
  public void setNewConsumedServiceCores(Float  newConsumedServiceCores) {
    this.newConsumedServiceCores = newConsumedServiceCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property new_escrow_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @return newEscrowServiceCores
   */
  public Float getNewEscrowServiceCores() {
    return newEscrowServiceCores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property new_escrow_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @param newEscrowServiceCores set the newEscrowServiceCores.
   */
  public void setNewEscrowServiceCores(Float  newEscrowServiceCores) {
    this.newEscrowServiceCores = newEscrowServiceCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property new_remaining_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @return newRemainingServiceCores
   */
  public Float getNewRemainingServiceCores() {
    return newRemainingServiceCores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property new_remaining_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @param newRemainingServiceCores set the newRemainingServiceCores.
   */
  public void setNewRemainingServiceCores(Float  newRemainingServiceCores) {
    this.newRemainingServiceCores = newRemainingServiceCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property old_available_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @return oldAvailableServiceCores
   */
  public Float getOldAvailableServiceCores() {
    return oldAvailableServiceCores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property old_available_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @param oldAvailableServiceCores set the oldAvailableServiceCores.
   */
  public void setOldAvailableServiceCores(Float  oldAvailableServiceCores) {
    this.oldAvailableServiceCores = oldAvailableServiceCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property old_consumed_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @return oldConsumedServiceCores
   */
  public Float getOldConsumedServiceCores() {
    return oldConsumedServiceCores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property old_consumed_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @param oldConsumedServiceCores set the oldConsumedServiceCores.
   */
  public void setOldConsumedServiceCores(Float  oldConsumedServiceCores) {
    this.oldConsumedServiceCores = oldConsumedServiceCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property old_escrow_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @return oldEscrowServiceCores
   */
  public Float getOldEscrowServiceCores() {
    return oldEscrowServiceCores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property old_escrow_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @param oldEscrowServiceCores set the oldEscrowServiceCores.
   */
  public void setOldEscrowServiceCores(Float  oldEscrowServiceCores) {
    this.oldEscrowServiceCores = oldEscrowServiceCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property old_remaining_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @return oldRemainingServiceCores
   */
  public Float getOldRemainingServiceCores() {
    return oldRemainingServiceCores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property old_remaining_service_cores of obj type controllerlicensereconciledetails field type str  type float.
   * @param oldRemainingServiceCores set the oldRemainingServiceCores.
   */
  public void setOldRemainingServiceCores(Float  oldRemainingServiceCores) {
    this.oldRemainingServiceCores = oldRemainingServiceCores;
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
   * Placeholder for description of property tier of obj type controllerlicensereconciledetails field type str  type string.
   * @return tier
   */
  public String getTier() {
    return tier;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property tier of obj type controllerlicensereconciledetails field type str  type string.
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
  ControllerLicenseReconcileDetails objControllerLicenseReconcileDetails = (ControllerLicenseReconcileDetails) o;
  return   Objects.equals(this.tenantUuid, objControllerLicenseReconcileDetails.tenantUuid)&&
  Objects.equals(this.tier, objControllerLicenseReconcileDetails.tier)&&
  Objects.equals(this.oldAvailableServiceCores, objControllerLicenseReconcileDetails.oldAvailableServiceCores)&&
  Objects.equals(this.newAvailableServiceCores, objControllerLicenseReconcileDetails.newAvailableServiceCores)&&
  Objects.equals(this.oldConsumedServiceCores, objControllerLicenseReconcileDetails.oldConsumedServiceCores)&&
  Objects.equals(this.newConsumedServiceCores, objControllerLicenseReconcileDetails.newConsumedServiceCores)&&
  Objects.equals(this.oldRemainingServiceCores, objControllerLicenseReconcileDetails.oldRemainingServiceCores)&&
  Objects.equals(this.newRemainingServiceCores, objControllerLicenseReconcileDetails.newRemainingServiceCores)&&
  Objects.equals(this.oldEscrowServiceCores, objControllerLicenseReconcileDetails.oldEscrowServiceCores)&&
  Objects.equals(this.newEscrowServiceCores, objControllerLicenseReconcileDetails.newEscrowServiceCores);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ControllerLicenseReconcileDetails {\n");
      sb.append("    newAvailableServiceCores: ").append(toIndentedString(newAvailableServiceCores)).append("\n");
        sb.append("    newConsumedServiceCores: ").append(toIndentedString(newConsumedServiceCores)).append("\n");
        sb.append("    newEscrowServiceCores: ").append(toIndentedString(newEscrowServiceCores)).append("\n");
        sb.append("    newRemainingServiceCores: ").append(toIndentedString(newRemainingServiceCores)).append("\n");
        sb.append("    oldAvailableServiceCores: ").append(toIndentedString(oldAvailableServiceCores)).append("\n");
        sb.append("    oldConsumedServiceCores: ").append(toIndentedString(oldConsumedServiceCores)).append("\n");
        sb.append("    oldEscrowServiceCores: ").append(toIndentedString(oldEscrowServiceCores)).append("\n");
        sb.append("    oldRemainingServiceCores: ").append(toIndentedString(oldRemainingServiceCores)).append("\n");
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

