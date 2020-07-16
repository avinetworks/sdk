package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeUpgradeMigrateEventDetails is a POJO class extends AviRestResource that used for creating
 * SeUpgradeMigrateEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeUpgradeMigrateEventDetails  {
    @JsonProperty("migrate_params")
    private VsMigrateParams migrateParams = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property migrate_params of obj type seupgrademigrateeventdetails field type str  type ref.
   * @return migrateParams
   */
  public VsMigrateParams getMigrateParams() {
    return migrateParams;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property migrate_params of obj type seupgrademigrateeventdetails field type str  type ref.
   * @param migrateParams set the migrateParams.
   */
  public void setMigrateParams(VsMigrateParams migrateParams) {
    this.migrateParams = migrateParams;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of vs.
   * @return vsUuid
   */
  public String getVsUuid() {
    return vsUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of vs.
   * @param vsUuid set the vsUuid.
   */
  public void setVsUuid(String  vsUuid) {
    this.vsUuid = vsUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeUpgradeMigrateEventDetails objSeUpgradeMigrateEventDetails = (SeUpgradeMigrateEventDetails) o;
  return   Objects.equals(this.vsUuid, objSeUpgradeMigrateEventDetails.vsUuid)&&
  Objects.equals(this.migrateParams, objSeUpgradeMigrateEventDetails.migrateParams);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeUpgradeMigrateEventDetails {\n");
      sb.append("    migrateParams: ").append(toIndentedString(migrateParams)).append("\n");
        sb.append("    vsUuid: ").append(toIndentedString(vsUuid)).append("\n");
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

