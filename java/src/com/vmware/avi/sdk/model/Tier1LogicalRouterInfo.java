package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Tier1LogicalRouterInfo is a POJO class extends AviRestResource that used for creating
 * Tier1LogicalRouterInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tier1LogicalRouterInfo  {
    @JsonProperty("segment_id")
    private String segmentId = null;

    @JsonProperty("tier1_lr_id")
    private String tier1LrId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Segment id.
   * Field introduced in 20.1.1.
   * @return segmentId
   */
  public String getSegmentId() {
    return segmentId;
  }

  /**
   * This is the setter method to the attribute.
   * Segment id.
   * Field introduced in 20.1.1.
   * @param segmentId set the segmentId.
   */
  public void setSegmentId(String  segmentId) {
    this.segmentId = segmentId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tier1 logical router id.
   * Field introduced in 20.1.1.
   * @return tier1LrId
   */
  public String getTier1LrId() {
    return tier1LrId;
  }

  /**
   * This is the setter method to the attribute.
   * Tier1 logical router id.
   * Field introduced in 20.1.1.
   * @param tier1LrId set the tier1LrId.
   */
  public void setTier1LrId(String  tier1LrId) {
    this.tier1LrId = tier1LrId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Tier1LogicalRouterInfo objTier1LogicalRouterInfo = (Tier1LogicalRouterInfo) o;
  return   Objects.equals(this.tier1LrId, objTier1LogicalRouterInfo.tier1LrId)&&
  Objects.equals(this.segmentId, objTier1LogicalRouterInfo.segmentId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Tier1LogicalRouterInfo {\n");
      sb.append("    segmentId: ").append(toIndentedString(segmentId)).append("\n");
        sb.append("    tier1LrId: ").append(toIndentedString(tier1LrId)).append("\n");
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

