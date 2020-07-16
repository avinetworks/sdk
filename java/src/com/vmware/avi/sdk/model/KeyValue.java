package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The KeyValue is a POJO class extends AviRestResource that used for creating
 * KeyValue.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeyValue  {
    @JsonProperty("key")
    private String key = null;

    @JsonProperty("value")
    private String value = null;



  /**
   * This is the getter method this will return the attribute value.
   * Key.
   * @return key
   */
  public String getKey() {
    return key;
  }

  /**
   * This is the setter method to the attribute.
   * Key.
   * @param key set the key.
   */
  public void setKey(String  key) {
    this.key = key;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Value.
   * @return value
   */
  public String getValue() {
    return value;
  }

  /**
   * This is the setter method to the attribute.
   * Value.
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
  KeyValue objKeyValue = (KeyValue) o;
  return   Objects.equals(this.value, objKeyValue.value)&&
  Objects.equals(this.key, objKeyValue.key);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class KeyValue {\n");
      sb.append("    key: ").append(toIndentedString(key)).append("\n");
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

