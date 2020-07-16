package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PodToleration is a POJO class extends AviRestResource that used for creating
 * PodToleration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PodToleration  {
    @JsonProperty("effect")
    private String effect = null;

    @JsonProperty("key")
    private String key = null;

    @JsonProperty("operator")
    private String operator = "EQUAL";

    @JsonProperty("toleration_seconds")
    private Integer tolerationSeconds = null;

    @JsonProperty("value")
    private String value = null;



  /**
   * This is the getter method this will return the attribute value.
   * Effect to match.
   * Enum options - NO_SCHEDULE, PREFER_NO_SCHEDULE, NO_EXECUTE.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * @return effect
   */
  public String getEffect() {
    return effect;
  }

  /**
   * This is the setter method to the attribute.
   * Effect to match.
   * Enum options - NO_SCHEDULE, PREFER_NO_SCHEDULE, NO_EXECUTE.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * @param effect set the effect.
   */
  public void setEffect(String  effect) {
    this.effect = effect;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Key to match.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * @return key
   */
  public String getKey() {
    return key;
  }

  /**
   * This is the setter method to the attribute.
   * Key to match.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * @param key set the key.
   */
  public void setKey(String  key) {
    this.key = key;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Operator to match.
   * Enum options - EQUAL, EXISTS.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as EQUAL.
   * @return operator
   */
  public String getOperator() {
    return operator;
  }

  /**
   * This is the setter method to the attribute.
   * Operator to match.
   * Enum options - EQUAL, EXISTS.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as EQUAL.
   * @param operator set the operator.
   */
  public void setOperator(String  operator) {
    this.operator = operator;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Pods that tolerate the taint with a specified toleration_seconds remain bound for the specified amount of time.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * @return tolerationSeconds
   */
  public Integer getTolerationSeconds() {
    return tolerationSeconds;
  }

  /**
   * This is the setter method to the attribute.
   * Pods that tolerate the taint with a specified toleration_seconds remain bound for the specified amount of time.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * @param tolerationSeconds set the tolerationSeconds.
   */
  public void setTolerationSeconds(Integer  tolerationSeconds) {
    this.tolerationSeconds = tolerationSeconds;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Value to match.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * @return value
   */
  public String getValue() {
    return value;
  }

  /**
   * This is the setter method to the attribute.
   * Value to match.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * @param value set the value.
   */
  public void setValue(String  value) {
    this.value = value;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  PodToleration objPodToleration = (PodToleration) o;
  return   Objects.equals(this.operator, objPodToleration.operator)&&
  Objects.equals(this.tolerationSeconds, objPodToleration.tolerationSeconds)&&
  Objects.equals(this.value, objPodToleration.value)&&
  Objects.equals(this.key, objPodToleration.key)&&
  Objects.equals(this.effect, objPodToleration.effect);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PodToleration {\n");
      sb.append("    effect: ").append(toIndentedString(effect)).append("\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
        sb.append("    tolerationSeconds: ").append(toIndentedString(tolerationSeconds)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

