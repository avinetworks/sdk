package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VipAutoscaleConfiguration is a POJO class extends AviRestResource that used for creating
 * VipAutoscaleConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VipAutoscaleConfiguration  {
    @JsonProperty("zones")
    private List<VipAutoscaleZones> zones = null;


  /**
   * This is the getter method this will return the attribute value.
   * This is the list of az+subnet in which vips will be spawned.
   * Field introduced in 17.2.12, 18.1.2.
   * @return zones
   */
  public List<VipAutoscaleZones> getZones() {
    return zones;
  }

  /**
   * This is the setter method. this will set the zones
   * This is the list of az+subnet in which vips will be spawned.
   * Field introduced in 17.2.12, 18.1.2.
   * @return zones
   */
  public void setZones(List<VipAutoscaleZones>  zones) {
    this.zones = zones;
  }

  /**
   * This is the setter method this will set the zones
   * This is the list of az+subnet in which vips will be spawned.
   * Field introduced in 17.2.12, 18.1.2.
   * @return zones
   */
  public VipAutoscaleConfiguration addZonesItem(VipAutoscaleZones zonesItem) {
    if (this.zones == null) {
      this.zones = new ArrayList<VipAutoscaleZones>();
    }
    this.zones.add(zonesItem);
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
  VipAutoscaleConfiguration objVipAutoscaleConfiguration = (VipAutoscaleConfiguration) o;
  return   Objects.equals(this.zones, objVipAutoscaleConfiguration.zones);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VipAutoscaleConfiguration {\n");
      sb.append("    zones: ").append(toIndentedString(zones)).append("\n");
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

