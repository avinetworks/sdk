package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The BotClassification is a POJO class extends AviRestResource that used for creating
 * BotClassification.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotClassification  {
    @JsonProperty("type")
    private String type = null;

    @JsonProperty("user_defined_type")
    private String userDefinedType = null;



    /**
     * This is the getter method this will return the attribute value.
     * One of the system-defined bot classification types.
     * Enum options - HUMAN, GOOD_BOT, BAD_BOT, DANGEROUS_BOT, USER_DEFINED_BOT, UNKNOWN_CLIENT.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * This is the setter method to the attribute.
     * One of the system-defined bot classification types.
     * Enum options - HUMAN, GOOD_BOT, BAD_BOT, DANGEROUS_BOT, USER_DEFINED_BOT, UNKNOWN_CLIENT.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param type set the type.
     */
    public void setType(String  type) {
        this.type = type;
    }

    /**
     * This is the getter method this will return the attribute value.
     * If 'type' has botclassificationtypes value 'user_defined', this is the user-defined value.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return userDefinedType
     */
    public String getUserDefinedType() {
        return userDefinedType;
    }

    /**
     * This is the setter method to the attribute.
     * If 'type' has botclassificationtypes value 'user_defined', this is the user-defined value.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param userDefinedType set the userDefinedType.
     */
    public void setUserDefinedType(String  userDefinedType) {
        this.userDefinedType = userDefinedType;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      BotClassification objBotClassification = (BotClassification) o;
      return   Objects.equals(this.type, objBotClassification.type)&&
  Objects.equals(this.userDefinedType, objBotClassification.userDefinedType);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BotClassification {\n");
                  sb.append("    type: ").append(toIndentedString(type)).append("\n");
                        sb.append("    userDefinedType: ").append(toIndentedString(userDefinedType)).append("\n");
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
