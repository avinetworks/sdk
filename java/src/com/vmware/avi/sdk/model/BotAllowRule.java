package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The BotAllowRule is a POJO class extends AviRestResource that used for creating
 * BotAllowRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotAllowRule  {
    @JsonProperty("action")
    private String action = null;

    @JsonProperty("conditions")
    private List<MatchTarget> conditions = null;



    /**
     * This is the getter method this will return the attribute value.
     * The action to take.
     * Enum options - BYPASS, CONTINUE.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return action
     */
    public String getAction() {
        return action;
    }

    /**
     * This is the setter method to the attribute.
     * The action to take.
     * Enum options - BYPASS, CONTINUE.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param action set the action.
     */
    public void setAction(String  action) {
        this.action = action;
    }
    /**
     * This is the getter method this will return the attribute value.
     * The conditions to match, combined by logical and.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return conditions
     */
    public List<MatchTarget> getConditions() {
        return conditions;
    }

    /**
     * This is the setter method. this will set the conditions
     * The conditions to match, combined by logical and.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return conditions
     */
    public void setConditions(List<MatchTarget>  conditions) {
        this.conditions = conditions;
    }

    /**
     * This is the setter method this will set the conditions
     * The conditions to match, combined by logical and.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return conditions
     */
    public BotAllowRule addConditionsItem(MatchTarget conditionsItem) {
      if (this.conditions == null) {
        this.conditions = new ArrayList<MatchTarget>();
      }
      this.conditions.add(conditionsItem);
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
      BotAllowRule objBotAllowRule = (BotAllowRule) o;
      return   Objects.equals(this.conditions, objBotAllowRule.conditions)&&
  Objects.equals(this.action, objBotAllowRule.action);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BotAllowRule {\n");
                  sb.append("    action: ").append(toIndentedString(action)).append("\n");
                        sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
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
