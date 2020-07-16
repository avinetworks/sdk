package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SystemUpgradeDetails is a POJO class extends AviRestResource that used for creating
 * SystemUpgradeDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SystemUpgradeDetails  {
    @JsonProperty("upgrade_status")
    private SystemUpgradeState upgradeStatus = null;



  /**
   * This is the getter method this will return the attribute value.
   * Upgrade status.
   * @return upgradeStatus
   */
  public SystemUpgradeState getUpgradeStatus() {
    return upgradeStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Upgrade status.
   * @param upgradeStatus set the upgradeStatus.
   */
  public void setUpgradeStatus(SystemUpgradeState upgradeStatus) {
    this.upgradeStatus = upgradeStatus;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SystemUpgradeDetails objSystemUpgradeDetails = (SystemUpgradeDetails) o;
  return   Objects.equals(this.upgradeStatus, objSystemUpgradeDetails.upgradeStatus);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SystemUpgradeDetails {\n");
      sb.append("    upgradeStatus: ").append(toIndentedString(upgradeStatus)).append("\n");
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

