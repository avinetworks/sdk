package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CCScaleSetNotifDetails is a POJO class extends AviRestResource that used for creating
 * CCScaleSetNotifDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CCScaleSetNotifDetails  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("scaleset_names")
    private List<String> scalesetNames = null;



  /**
   * This is the getter method this will return the attribute value.
   * Cloud id.
   * Field introduced in 18.2.5.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Cloud id.
   * Field introduced in 18.2.5.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Detailed reason for the scale set notification.
   * Field introduced in 18.2.5.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Detailed reason for the scale set notification.
   * Field introduced in 18.2.5.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Names of scale sets for which polling failed.
   * Field introduced in 18.2.5.
   * @return scalesetNames
   */
  public List<String> getScalesetNames() {
    return scalesetNames;
  }

  /**
   * This is the setter method. this will set the scalesetNames
   * Names of scale sets for which polling failed.
   * Field introduced in 18.2.5.
   * @return scalesetNames
   */
  public void setScalesetNames(List<String>  scalesetNames) {
    this.scalesetNames = scalesetNames;
  }

  /**
   * This is the setter method this will set the scalesetNames
   * Names of scale sets for which polling failed.
   * Field introduced in 18.2.5.
   * @return scalesetNames
   */
  public CCScaleSetNotifDetails addScalesetNamesItem(String scalesetNamesItem) {
    if (this.scalesetNames == null) {
      this.scalesetNames = new ArrayList<String>();
    }
    this.scalesetNames.add(scalesetNamesItem);
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
  CCScaleSetNotifDetails objCCScaleSetNotifDetails = (CCScaleSetNotifDetails) o;
  return   Objects.equals(this.ccId, objCCScaleSetNotifDetails.ccId)&&
  Objects.equals(this.scalesetNames, objCCScaleSetNotifDetails.scalesetNames)&&
  Objects.equals(this.reason, objCCScaleSetNotifDetails.reason);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CCScaleSetNotifDetails {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    scalesetNames: ").append(toIndentedString(scalesetNames)).append("\n");
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

