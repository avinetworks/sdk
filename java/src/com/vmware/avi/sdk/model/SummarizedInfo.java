package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SummarizedInfo is a POJO class extends AviRestResource that used for creating
 * SummarizedInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SummarizedInfo  {
    @JsonProperty("subnet_info")
    private List<SummarizedSubnetInfo> subnetInfo = null;


  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property subnet_info of obj type summarizedinfo field type str  type array.
   * @return subnetInfo
   */
  public List<SummarizedSubnetInfo> getSubnetInfo() {
    return subnetInfo;
  }

  /**
   * This is the setter method. this will set the subnetInfo
   * Placeholder for description of property subnet_info of obj type summarizedinfo field type str  type array.
   * @return subnetInfo
   */
  public void setSubnetInfo(List<SummarizedSubnetInfo>  subnetInfo) {
    this.subnetInfo = subnetInfo;
  }

  /**
   * This is the setter method this will set the subnetInfo
   * Placeholder for description of property subnet_info of obj type summarizedinfo field type str  type array.
   * @return subnetInfo
   */
  public SummarizedInfo addSubnetInfoItem(SummarizedSubnetInfo subnetInfoItem) {
    if (this.subnetInfo == null) {
      this.subnetInfo = new ArrayList<SummarizedSubnetInfo>();
    }
    this.subnetInfo.add(subnetInfoItem);
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
  SummarizedInfo objSummarizedInfo = (SummarizedInfo) o;
  return   Objects.equals(this.subnetInfo, objSummarizedInfo.subnetInfo);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SummarizedInfo {\n");
      sb.append("    subnetInfo: ").append(toIndentedString(subnetInfo)).append("\n");
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

