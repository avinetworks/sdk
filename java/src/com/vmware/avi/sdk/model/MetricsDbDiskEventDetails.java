package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MetricsDbDiskEventDetails is a POJO class extends AviRestResource that used for creating
 * MetricsDbDiskEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricsDbDiskEventDetails  {
    @JsonProperty("metrics_deleted_tables")
    private List<String> metricsDeletedTables = null;

    @JsonProperty("metrics_free_sz")
    private Integer metricsFreeSz = null;

    @JsonProperty("metrics_quota")
    private Integer metricsQuota = null;


  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metrics_deleted_tables of obj type metricsdbdiskeventdetails field type str  type array.
   * @return metricsDeletedTables
   */
  public List<String> getMetricsDeletedTables() {
    return metricsDeletedTables;
  }

  /**
   * This is the setter method. this will set the metricsDeletedTables
   * Placeholder for description of property metrics_deleted_tables of obj type metricsdbdiskeventdetails field type str  type array.
   * @return metricsDeletedTables
   */
  public void setMetricsDeletedTables(List<String>  metricsDeletedTables) {
    this.metricsDeletedTables = metricsDeletedTables;
  }

  /**
   * This is the setter method this will set the metricsDeletedTables
   * Placeholder for description of property metrics_deleted_tables of obj type metricsdbdiskeventdetails field type str  type array.
   * @return metricsDeletedTables
   */
  public MetricsDbDiskEventDetails addMetricsDeletedTablesItem(String metricsDeletedTablesItem) {
    if (this.metricsDeletedTables == null) {
      this.metricsDeletedTables = new ArrayList<String>();
    }
    this.metricsDeletedTables.add(metricsDeletedTablesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metrics_free_sz of obj type metricsdbdiskeventdetails field type str  type integer.
   * @return metricsFreeSz
   */
  public Integer getMetricsFreeSz() {
    return metricsFreeSz;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metrics_free_sz of obj type metricsdbdiskeventdetails field type str  type integer.
   * @param metricsFreeSz set the metricsFreeSz.
   */
  public void setMetricsFreeSz(Integer  metricsFreeSz) {
    this.metricsFreeSz = metricsFreeSz;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metrics_quota of obj type metricsdbdiskeventdetails field type str  type integer.
   * @return metricsQuota
   */
  public Integer getMetricsQuota() {
    return metricsQuota;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metrics_quota of obj type metricsdbdiskeventdetails field type str  type integer.
   * @param metricsQuota set the metricsQuota.
   */
  public void setMetricsQuota(Integer  metricsQuota) {
    this.metricsQuota = metricsQuota;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MetricsDbDiskEventDetails objMetricsDbDiskEventDetails = (MetricsDbDiskEventDetails) o;
  return   Objects.equals(this.metricsDeletedTables, objMetricsDbDiskEventDetails.metricsDeletedTables)&&
  Objects.equals(this.metricsFreeSz, objMetricsDbDiskEventDetails.metricsFreeSz)&&
  Objects.equals(this.metricsQuota, objMetricsDbDiskEventDetails.metricsQuota);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MetricsDbDiskEventDetails {\n");
      sb.append("    metricsDeletedTables: ").append(toIndentedString(metricsDeletedTables)).append("\n");
        sb.append("    metricsFreeSz: ").append(toIndentedString(metricsFreeSz)).append("\n");
        sb.append("    metricsQuota: ").append(toIndentedString(metricsQuota)).append("\n");
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

