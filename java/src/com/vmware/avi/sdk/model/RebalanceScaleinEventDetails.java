package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RebalanceScaleinEventDetails is a POJO class extends AviRestResource that used for creating
 * RebalanceScaleinEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RebalanceScaleinEventDetails  {
    @JsonProperty("scalein_params")
    private VsScaleinParams scaleinParams = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property scalein_params of obj type rebalancescaleineventdetails field type str  type ref.
   * @return scaleinParams
   */
  public VsScaleinParams getScaleinParams() {
    return scaleinParams;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property scalein_params of obj type rebalancescaleineventdetails field type str  type ref.
   * @param scaleinParams set the scaleinParams.
   */
  public void setScaleinParams(VsScaleinParams scaleinParams) {
    this.scaleinParams = scaleinParams;
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
  RebalanceScaleinEventDetails objRebalanceScaleinEventDetails = (RebalanceScaleinEventDetails) o;
  return   Objects.equals(this.vsUuid, objRebalanceScaleinEventDetails.vsUuid)&&
  Objects.equals(this.scaleinParams, objRebalanceScaleinEventDetails.scaleinParams);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RebalanceScaleinEventDetails {\n");
      sb.append("    scaleinParams: ").append(toIndentedString(scaleinParams)).append("\n");
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

