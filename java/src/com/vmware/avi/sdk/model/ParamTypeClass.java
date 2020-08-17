package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ParamTypeClass is a POJO class extends AviRestResource that used for creating
 * ParamTypeClass.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParamTypeClass  {
    @JsonProperty("hits")
    private Integer hits = null;

    @JsonProperty("type")
    private String type = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 20.1.1.
   * @return hits
   */
  public Integer getHits() {
    return hits;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 20.1.1.
   * @param hits set the hits.
   */
  public void setHits(Integer  hits) {
    this.hits = hits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - PARAM_FLAG, PARAM_DIGITS, PARAM_HEXDIGITS, PARAM_WORD, PARAM_SAFE_TEXT, PARAM_SAFE_TEXT_MULTILINE, PARAM_TEXT,
   * PARAM_TEXT_MULTILINE, PARAM_ALL.
   * Field introduced in 20.1.1.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - PARAM_FLAG, PARAM_DIGITS, PARAM_HEXDIGITS, PARAM_WORD, PARAM_SAFE_TEXT, PARAM_SAFE_TEXT_MULTILINE, PARAM_TEXT,
   * PARAM_TEXT_MULTILINE, PARAM_ALL.
   * Field introduced in 20.1.1.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ParamTypeClass objParamTypeClass = (ParamTypeClass) o;
  return   Objects.equals(this.type, objParamTypeClass.type)&&
  Objects.equals(this.hits, objParamTypeClass.hits);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ParamTypeClass {\n");
      sb.append("    hits: ").append(toIndentedString(hits)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

