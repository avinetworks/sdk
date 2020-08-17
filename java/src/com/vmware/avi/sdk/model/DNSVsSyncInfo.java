package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DNSVsSyncInfo is a POJO class extends AviRestResource that used for creating
 * DNSVsSyncInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNSVsSyncInfo  {
    @JsonProperty("error")
    private String error = null;

    @JsonProperty("total_records")
    private Integer totalRecords = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error of obj type dnsvssyncinfo field type str  type string.
   * @return error
   */
  public String getError() {
    return error;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error of obj type dnsvssyncinfo field type str  type string.
   * @param error set the error.
   */
  public void setError(String  error) {
    this.error = error;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property total_records of obj type dnsvssyncinfo field type str  type integer.
   * @return totalRecords
   */
  public Integer getTotalRecords() {
    return totalRecords;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property total_records of obj type dnsvssyncinfo field type str  type integer.
   * @param totalRecords set the totalRecords.
   */
  public void setTotalRecords(Integer  totalRecords) {
    this.totalRecords = totalRecords;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DNSVsSyncInfo objDNSVsSyncInfo = (DNSVsSyncInfo) o;
  return   Objects.equals(this.totalRecords, objDNSVsSyncInfo.totalRecords)&&
  Objects.equals(this.error, objDNSVsSyncInfo.error);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DNSVsSyncInfo {\n");
      sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("    totalRecords: ").append(toIndentedString(totalRecords)).append("\n");
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

