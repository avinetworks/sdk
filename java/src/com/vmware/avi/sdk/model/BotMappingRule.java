package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The BotMappingRule is a POJO class extends AviRestResource that used for creating
 * BotMappingRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotMappingRule  {
    @JsonProperty("class_matcher")
    private BotClassMatcher classMatcher = null;

    @JsonProperty("classification")
    private BotClassification classification = null;

    @JsonProperty("component_matcher")
    private String componentMatcher = null;

    @JsonProperty("identifier_matcher")
    private StringMatch identifierMatcher = null;

    @JsonProperty("type_matcher")
    private BotTypeMatcher typeMatcher = null;



    /**
     * This is the getter method this will return the attribute value.
     * How to match the botclientclass.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return classMatcher
     */
    public BotClassMatcher getClassMatcher() {
        return classMatcher;
    }

    /**
     * This is the setter method to the attribute.
     * How to match the botclientclass.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param classMatcher set the classMatcher.
     */
    public void setClassMatcher(BotClassMatcher classMatcher) {
        this.classMatcher = classMatcher;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The assigned classification for this client.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return classification
     */
    public BotClassification getClassification() {
        return classification;
    }

    /**
     * This is the setter method to the attribute.
     * The assigned classification for this client.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param classification set the classification.
     */
    public void setClassification(BotClassification classification) {
        this.classification = classification;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The component for which this mapping is used.
     * Enum options - BOT_DECIDER_CONSOLIDATION, BOT_DECIDER_USER_AGENT, BOT_DECIDER_IP_REPUTATION, BOT_DECIDER_IP_NETWORK_LOCATION.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return componentMatcher
     */
    public String getComponentMatcher() {
        return componentMatcher;
    }

    /**
     * This is the setter method to the attribute.
     * The component for which this mapping is used.
     * Enum options - BOT_DECIDER_CONSOLIDATION, BOT_DECIDER_USER_AGENT, BOT_DECIDER_IP_REPUTATION, BOT_DECIDER_IP_NETWORK_LOCATION.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param componentMatcher set the componentMatcher.
     */
    public void setComponentMatcher(String  componentMatcher) {
        this.componentMatcher = componentMatcher;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The list of bot identifier names and how they're matched.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return identifierMatcher
     */
    public StringMatch getIdentifierMatcher() {
        return identifierMatcher;
    }

    /**
     * This is the setter method to the attribute.
     * The list of bot identifier names and how they're matched.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param identifierMatcher set the identifierMatcher.
     */
    public void setIdentifierMatcher(StringMatch identifierMatcher) {
        this.identifierMatcher = identifierMatcher;
    }

    /**
     * This is the getter method this will return the attribute value.
     * How to match the botclienttype.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return typeMatcher
     */
    public BotTypeMatcher getTypeMatcher() {
        return typeMatcher;
    }

    /**
     * This is the setter method to the attribute.
     * How to match the botclienttype.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param typeMatcher set the typeMatcher.
     */
    public void setTypeMatcher(BotTypeMatcher typeMatcher) {
        this.typeMatcher = typeMatcher;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      BotMappingRule objBotMappingRule = (BotMappingRule) o;
      return   Objects.equals(this.componentMatcher, objBotMappingRule.componentMatcher)&&
  Objects.equals(this.classMatcher, objBotMappingRule.classMatcher)&&
  Objects.equals(this.typeMatcher, objBotMappingRule.typeMatcher)&&
  Objects.equals(this.identifierMatcher, objBotMappingRule.identifierMatcher)&&
  Objects.equals(this.classification, objBotMappingRule.classification);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BotMappingRule {\n");
                  sb.append("    classMatcher: ").append(toIndentedString(classMatcher)).append("\n");
                        sb.append("    classification: ").append(toIndentedString(classification)).append("\n");
                        sb.append("    componentMatcher: ").append(toIndentedString(componentMatcher)).append("\n");
                        sb.append("    identifierMatcher: ").append(toIndentedString(identifierMatcher)).append("\n");
                        sb.append("    typeMatcher: ").append(toIndentedString(typeMatcher)).append("\n");
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
