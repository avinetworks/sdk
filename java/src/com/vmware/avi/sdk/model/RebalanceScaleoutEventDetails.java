package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RebalanceScaleoutEventDetails is a POJO class extends AviRestResource that used for creating
 * RebalanceScaleoutEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RebalanceScaleoutEventDetails  {
    @JsonProperty("scaleout_params")
    private VsScaleoutParams scaleoutParams = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property scaleout_params of obj type rebalancescaleouteventdetails field type str  type ref.
   * @return scaleoutParams
   */
  public VsScaleoutParams getScaleoutParams() {
    return scaleoutParams;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property scaleout_params of obj type rebalancescaleouteventdetails field type str  type ref.
   * @param scaleoutParams set the scaleoutParams.
   */
  public void setScaleoutParams(VsScaleoutParams scaleoutParams) {
    this.scaleoutParams = scaleoutParams;
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
  RebalanceScaleoutEventDetails objRebalanceScaleoutEventDetails = (RebalanceScaleoutEventDetails) o;
  return   Objects.equals(this.vsUuid, objRebalanceScaleoutEventDetails.vsUuid)&&
  Objects.equals(this.scaleoutParams, objRebalanceScaleoutEventDetails.scaleoutParams);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RebalanceScaleoutEventDetails {\n");
      sb.append("    scaleoutParams: ").append(toIndentedString(scaleoutParams)).append("\n");
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

