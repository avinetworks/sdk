package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The BgpRoutingOptions is a POJO class extends AviRestResource that used for creating
 * BgpRoutingOptions.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BgpRoutingOptions  {
    @JsonProperty("advertise_default_route")
    private Boolean advertiseDefaultRoute = null;

    @JsonProperty("advertise_learned_routes")
    private Boolean advertiseLearnedRoutes = null;

    @JsonProperty("label")
    private String label = null;

    @JsonProperty("learn_only_default_route")
    private Boolean learnOnlyDefaultRoute = null;

    @JsonProperty("learn_routes")
    private Boolean learnRoutes = null;

    @JsonProperty("max_learn_limit")
    private Integer maxLearnLimit = 50;



  /**
   * This is the getter method this will return the attribute value.
   * Advertise self as default router to the bgp peer.
   * Field introduced in 20.1.1.
   * @return advertiseDefaultRoute
   */
  public Boolean getAdvertiseDefaultRoute() {
    return advertiseDefaultRoute;
  }

  /**
   * This is the setter method to the attribute.
   * Advertise self as default router to the bgp peer.
   * Field introduced in 20.1.1.
   * @param advertiseDefaultRoute set the advertiseDefaultRoute.
   */
  public void setAdvertiseDefaultRoute(Boolean  advertiseDefaultRoute) {
    this.advertiseDefaultRoute = advertiseDefaultRoute;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Advertise the learned routes to the bgp peer.
   * Field introduced in 20.1.1.
   * @return advertiseLearnedRoutes
   */
  public Boolean getAdvertiseLearnedRoutes() {
    return advertiseLearnedRoutes;
  }

  /**
   * This is the setter method to the attribute.
   * Advertise the learned routes to the bgp peer.
   * Field introduced in 20.1.1.
   * @param advertiseLearnedRoutes set the advertiseLearnedRoutes.
   */
  public void setAdvertiseLearnedRoutes(Boolean  advertiseLearnedRoutes) {
    this.advertiseLearnedRoutes = advertiseLearnedRoutes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Features are applied to peers matching this label.
   * Field introduced in 20.1.1.
   * @return label
   */
  public String getLabel() {
    return label;
  }

  /**
   * This is the setter method to the attribute.
   * Features are applied to peers matching this label.
   * Field introduced in 20.1.1.
   * @param label set the label.
   */
  public void setLabel(String  label) {
    this.label = label;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Learn only default route from the bgp peer.
   * Field introduced in 20.1.1.
   * @return learnOnlyDefaultRoute
   */
  public Boolean getLearnOnlyDefaultRoute() {
    return learnOnlyDefaultRoute;
  }

  /**
   * This is the setter method to the attribute.
   * Learn only default route from the bgp peer.
   * Field introduced in 20.1.1.
   * @param learnOnlyDefaultRoute set the learnOnlyDefaultRoute.
   */
  public void setLearnOnlyDefaultRoute(Boolean  learnOnlyDefaultRoute) {
    this.learnOnlyDefaultRoute = learnOnlyDefaultRoute;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Learn routes from the bgp peer.
   * Field introduced in 20.1.1.
   * @return learnRoutes
   */
  public Boolean getLearnRoutes() {
    return learnRoutes;
  }

  /**
   * This is the setter method to the attribute.
   * Learn routes from the bgp peer.
   * Field introduced in 20.1.1.
   * @param learnRoutes set the learnRoutes.
   */
  public void setLearnRoutes(Boolean  learnRoutes) {
    this.learnRoutes = learnRoutes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of routes that can be learned from a bgp peer.
   * Allowed values are 50-250.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 50.
   * @return maxLearnLimit
   */
  public Integer getMaxLearnLimit() {
    return maxLearnLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of routes that can be learned from a bgp peer.
   * Allowed values are 50-250.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 50.
   * @param maxLearnLimit set the maxLearnLimit.
   */
  public void setMaxLearnLimit(Integer  maxLearnLimit) {
    this.maxLearnLimit = maxLearnLimit;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  BgpRoutingOptions objBgpRoutingOptions = (BgpRoutingOptions) o;
  return   Objects.equals(this.learnRoutes, objBgpRoutingOptions.learnRoutes)&&
  Objects.equals(this.advertiseDefaultRoute, objBgpRoutingOptions.advertiseDefaultRoute)&&
  Objects.equals(this.learnOnlyDefaultRoute, objBgpRoutingOptions.learnOnlyDefaultRoute)&&
  Objects.equals(this.advertiseLearnedRoutes, objBgpRoutingOptions.advertiseLearnedRoutes)&&
  Objects.equals(this.maxLearnLimit, objBgpRoutingOptions.maxLearnLimit)&&
  Objects.equals(this.label, objBgpRoutingOptions.label);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class BgpRoutingOptions {\n");
      sb.append("    advertiseDefaultRoute: ").append(toIndentedString(advertiseDefaultRoute)).append("\n");
        sb.append("    advertiseLearnedRoutes: ").append(toIndentedString(advertiseLearnedRoutes)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    learnOnlyDefaultRoute: ").append(toIndentedString(learnOnlyDefaultRoute)).append("\n");
        sb.append("    learnRoutes: ").append(toIndentedString(learnRoutes)).append("\n");
        sb.append("    maxLearnLimit: ").append(toIndentedString(maxLearnLimit)).append("\n");
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

