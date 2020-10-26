package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The SecureChannelMetadata is a POJO class extends AviRestResource that used for creating
 * SecureChannelMetadata.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecureChannelMetadata  {
    @JsonProperty("key")
    private String key = null;

    @JsonProperty("val")
    private String val = null;



    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property key of obj type securechannelmetadata field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property key of obj type securechannelmetadata field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param key set the key.
     */
    public void setKey(String  key) {
        this.key = key;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property val of obj type securechannelmetadata field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return val
     */
    public String getVal() {
        return val;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property val of obj type securechannelmetadata field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param val set the val.
     */
    public void setVal(String  val) {
        this.val = val;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      SecureChannelMetadata objSecureChannelMetadata = (SecureChannelMetadata) o;
      return   Objects.equals(this.key, objSecureChannelMetadata.key)&&
  Objects.equals(this.val, objSecureChannelMetadata.val);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SecureChannelMetadata {\n");
                  sb.append("    key: ").append(toIndentedString(key)).append("\n");
                        sb.append("    val: ").append(toIndentedString(val)).append("\n");
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
