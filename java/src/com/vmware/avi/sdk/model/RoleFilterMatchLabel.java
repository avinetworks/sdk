package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The RoleFilterMatchLabel is a POJO class extends AviRestResource that used for creating
 * RoleFilterMatchLabel.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleFilterMatchLabel  {
    @JsonProperty("key")
    private String key = null;

    @JsonProperty("values")
    private List<String> values = null;



    /**
     * This is the getter method this will return the attribute value.
     * Key for filter match.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * This is the setter method to the attribute.
     * Key for filter match.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param key set the key.
     */
    public void setKey(String  key) {
        this.key = key;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Values for filter match.
     * Multiple values will be evaluated as or.
     * Example  key = value1 or key = value2.
     * Behavior for match is key = * if this field is empty.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return values
     */
    public List<String> getValues() {
        return values;
    }

    /**
     * This is the setter method. this will set the values
     * Values for filter match.
     * Multiple values will be evaluated as or.
     * Example  key = value1 or key = value2.
     * Behavior for match is key = * if this field is empty.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return values
     */
    public void setValues(List<String>  values) {
        this.values = values;
    }

    /**
     * This is the setter method this will set the values
     * Values for filter match.
     * Multiple values will be evaluated as or.
     * Example  key = value1 or key = value2.
     * Behavior for match is key = * if this field is empty.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return values
     */
    public RoleFilterMatchLabel addValuesItem(String valuesItem) {
      if (this.values == null) {
        this.values = new ArrayList<String>();
      }
      this.values.add(valuesItem);
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
      RoleFilterMatchLabel objRoleFilterMatchLabel = (RoleFilterMatchLabel) o;
      return   Objects.equals(this.key, objRoleFilterMatchLabel.key)&&
  Objects.equals(this.values, objRoleFilterMatchLabel.values);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RoleFilterMatchLabel {\n");
                  sb.append("    key: ").append(toIndentedString(key)).append("\n");
                        sb.append("    values: ").append(toIndentedString(values)).append("\n");
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
