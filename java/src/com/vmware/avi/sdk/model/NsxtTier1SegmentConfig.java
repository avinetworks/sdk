package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NsxtTier1SegmentConfig is a POJO class extends AviRestResource that used for creating
 * NsxtTier1SegmentConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NsxtTier1SegmentConfig  {
    @JsonProperty("automatic")
    private NsxtTier1SegmentAutomaticMode automatic = null;

    @JsonProperty("manual")
    private NsxtTier1SegmentManualMode manual = null;

    @JsonProperty("segment_config_mode")
    private String segmentConfigMode = "TIER1_SEGMENT_MANUAL";



  /**
   * This is the getter method this will return the attribute value.
   * Avi controller creates and manages logical segments for a tier-1 lr.
   * Field introduced in 20.1.1.
   * @return automatic
   */
  public NsxtTier1SegmentAutomaticMode getAutomatic() {
    return automatic;
  }

  /**
   * This is the setter method to the attribute.
   * Avi controller creates and manages logical segments for a tier-1 lr.
   * Field introduced in 20.1.1.
   * @param automatic set the automatic.
   */
  public void setAutomatic(NsxtTier1SegmentAutomaticMode automatic) {
    this.automatic = automatic;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi admin selects an available logical segment (created by nsx-t admin) associated with a tier-1 lr.
   * Field introduced in 20.1.1.
   * @return manual
   */
  public NsxtTier1SegmentManualMode getManual() {
    return manual;
  }

  /**
   * This is the setter method to the attribute.
   * Avi admin selects an available logical segment (created by nsx-t admin) associated with a tier-1 lr.
   * Field introduced in 20.1.1.
   * @param manual set the manual.
   */
  public void setManual(NsxtTier1SegmentManualMode manual) {
    this.manual = manual;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Config mode for selecting the placement logical segments for avi serviceengine data path.
   * Enum options - TIER1_SEGMENT_MANUAL, TIER1_SEGMENT_AUTOMATIC.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as TIER1_SEGMENT_MANUAL.
   * @return segmentConfigMode
   */
  public String getSegmentConfigMode() {
    return segmentConfigMode;
  }

  /**
   * This is the setter method to the attribute.
   * Config mode for selecting the placement logical segments for avi serviceengine data path.
   * Enum options - TIER1_SEGMENT_MANUAL, TIER1_SEGMENT_AUTOMATIC.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as TIER1_SEGMENT_MANUAL.
   * @param segmentConfigMode set the segmentConfigMode.
   */
  public void setSegmentConfigMode(String  segmentConfigMode) {
    this.segmentConfigMode = segmentConfigMode;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  NsxtTier1SegmentConfig objNsxtTier1SegmentConfig = (NsxtTier1SegmentConfig) o;
  return   Objects.equals(this.segmentConfigMode, objNsxtTier1SegmentConfig.segmentConfigMode)&&
  Objects.equals(this.manual, objNsxtTier1SegmentConfig.manual)&&
  Objects.equals(this.automatic, objNsxtTier1SegmentConfig.automatic);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NsxtTier1SegmentConfig {\n");
      sb.append("    automatic: ").append(toIndentedString(automatic)).append("\n");
        sb.append("    manual: ").append(toIndentedString(manual)).append("\n");
        sb.append("    segmentConfigMode: ").append(toIndentedString(segmentConfigMode)).append("\n");
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

