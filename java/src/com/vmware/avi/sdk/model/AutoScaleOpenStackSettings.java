package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AutoScaleOpenStackSettings is a POJO class extends AviRestResource that used for creating
 * AutoScaleOpenStackSettings.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoScaleOpenStackSettings  {
    @JsonProperty("heat_scale_down_url")
    private String heatScaleDownUrl = null;

    @JsonProperty("heat_scale_up_url")
    private String heatScaleUpUrl = null;



  /**
   * This is the getter method this will return the attribute value.
   * Avi controller will use this url to scale downthe pool.
   * Cloud connector will automatically update the membership.
   * This is an alpha feature.
   * Field introduced in 17.1.1.
   * @return heatScaleDownUrl
   */
  public String getHeatScaleDownUrl() {
    return heatScaleDownUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Avi controller will use this url to scale downthe pool.
   * Cloud connector will automatically update the membership.
   * This is an alpha feature.
   * Field introduced in 17.1.1.
   * @param heatScaleDownUrl set the heatScaleDownUrl.
   */
  public void setHeatScaleDownUrl(String  heatScaleDownUrl) {
    this.heatScaleDownUrl = heatScaleDownUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi controller will use this url to scale upthe pool.
   * Cloud connector will automatically update the membership.
   * This is an alpha feature.
   * Field introduced in 17.1.1.
   * @return heatScaleUpUrl
   */
  public String getHeatScaleUpUrl() {
    return heatScaleUpUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Avi controller will use this url to scale upthe pool.
   * Cloud connector will automatically update the membership.
   * This is an alpha feature.
   * Field introduced in 17.1.1.
   * @param heatScaleUpUrl set the heatScaleUpUrl.
   */
  public void setHeatScaleUpUrl(String  heatScaleUpUrl) {
    this.heatScaleUpUrl = heatScaleUpUrl;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AutoScaleOpenStackSettings objAutoScaleOpenStackSettings = (AutoScaleOpenStackSettings) o;
  return   Objects.equals(this.heatScaleUpUrl, objAutoScaleOpenStackSettings.heatScaleUpUrl)&&
  Objects.equals(this.heatScaleDownUrl, objAutoScaleOpenStackSettings.heatScaleDownUrl);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AutoScaleOpenStackSettings {\n");
      sb.append("    heatScaleDownUrl: ").append(toIndentedString(heatScaleDownUrl)).append("\n");
        sb.append("    heatScaleUpUrl: ").append(toIndentedString(heatScaleUpUrl)).append("\n");
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

