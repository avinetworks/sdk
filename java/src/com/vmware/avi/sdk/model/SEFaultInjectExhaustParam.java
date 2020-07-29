package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SEFaultInjectExhaustParam is a POJO class extends AviRestResource that used for creating
 * SEFaultInjectExhaustParam.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SEFaultInjectExhaustParam  {
    @JsonProperty("leak")
    private Boolean leak = null;

    @JsonProperty("num")
    private Integer num = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property leak of obj type sefaultinjectexhaustparam field type str  type boolean.
   * @return leak
   */
  public Boolean getLeak() {
    return leak;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property leak of obj type sefaultinjectexhaustparam field type str  type boolean.
   * @param leak set the leak.
   */
  public void setLeak(Boolean  leak) {
    this.leak = leak;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num of obj type sefaultinjectexhaustparam field type str  type integer.
   * @return num
   */
  public Integer getNum() {
    return num;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num of obj type sefaultinjectexhaustparam field type str  type integer.
   * @param num set the num.
   */
  public void setNum(Integer  num) {
    this.num = num;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SEFaultInjectExhaustParam objSEFaultInjectExhaustParam = (SEFaultInjectExhaustParam) o;
  return   Objects.equals(this.num, objSEFaultInjectExhaustParam.num)&&
  Objects.equals(this.leak, objSEFaultInjectExhaustParam.leak);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SEFaultInjectExhaustParam {\n");
      sb.append("    leak: ").append(toIndentedString(leak)).append("\n");
        sb.append("    num: ").append(toIndentedString(num)).append("\n");
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

