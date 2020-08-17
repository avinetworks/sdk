package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VipAutoscaleGroup is a POJO class extends AviRestResource that used for creating
 * VipAutoscaleGroup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VipAutoscaleGroup  {
    @JsonProperty("configuration")
    private VipAutoscaleConfiguration configuration = null;

    @JsonProperty("policy")
    private VipAutoscalePolicy policy = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.12, 18.1.2.
   * @return configuration
   */
  public VipAutoscaleConfiguration getConfiguration() {
    return configuration;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.12, 18.1.2.
   * @param configuration set the configuration.
   */
  public void setConfiguration(VipAutoscaleConfiguration configuration) {
    this.configuration = configuration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.12, 18.1.2.
   * @return policy
   */
  public VipAutoscalePolicy getPolicy() {
    return policy;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.12, 18.1.2.
   * @param policy set the policy.
   */
  public void setPolicy(VipAutoscalePolicy policy) {
    this.policy = policy;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VipAutoscaleGroup objVipAutoscaleGroup = (VipAutoscaleGroup) o;
  return   Objects.equals(this.policy, objVipAutoscaleGroup.policy)&&
  Objects.equals(this.configuration, objVipAutoscaleGroup.configuration);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VipAutoscaleGroup {\n");
      sb.append("    configuration: ").append(toIndentedString(configuration)).append("\n");
        sb.append("    policy: ").append(toIndentedString(policy)).append("\n");
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

