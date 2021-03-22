package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The BotIdentification is a POJO class extends AviRestResource that used for creating
 * BotIdentification.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotIdentification  {
    @JsonProperty("class")
    private String classStr = null;

    @JsonProperty("identifier")
    private String identifier = null;

    @JsonProperty("type")
    private String type = null;



    /**
     * This is the getter method this will return the attribute value.
     * The bot client class of this identification.
     * Enum options - HUMAN_CLIENT, BOT_CLIENT.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return classStr
     */
    public String getClassStr() {
        return classStr;
    }

    /**
     * This is the setter method to the attribute.
     * The bot client class of this identification.
     * Enum options - HUMAN_CLIENT, BOT_CLIENT.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param classStr set the classStr.
     */
    public void setClassStr(String  classStr) {
        this.classStr = classStr;
    }

    /**
     * This is the getter method this will return the attribute value.
     * A free-form string to identify the client.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * This is the setter method to the attribute.
     * A free-form string to identify the client.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param identifier set the identifier.
     */
    public void setIdentifier(String  identifier) {
        this.identifier = identifier;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The bot client type of this identification.
     * Enum options - WEB_BROWSER, IN_APP_BROWSER, SEARCH_ENGINE, IMPERSONATOR, SPAM_SOURCE, WEB_ATTACKS, BOTNET, SCANNER, DENIAL_OF_SERVICE,
     * CLOUD_SOURCE.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * This is the setter method to the attribute.
     * The bot client type of this identification.
     * Enum options - WEB_BROWSER, IN_APP_BROWSER, SEARCH_ENGINE, IMPERSONATOR, SPAM_SOURCE, WEB_ATTACKS, BOTNET, SCANNER, DENIAL_OF_SERVICE,
     * CLOUD_SOURCE.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
      BotIdentification objBotIdentification = (BotIdentification) o;
      return   Objects.equals(this.classStr, objBotIdentification.classStr)&&
  Objects.equals(this.type, objBotIdentification.type)&&
  Objects.equals(this.identifier, objBotIdentification.identifier);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BotIdentification {\n");
                  sb.append("    classStr: ").append(toIndentedString(classStr)).append("\n");
                        sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
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
