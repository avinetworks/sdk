package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The RoleFilter is a POJO class extends AviRestResource that used for creating
 * RoleFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleFilter  {
    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("match_label")
    private RoleFilterMatchLabel matchLabel = null;

    @JsonProperty("match_operation")
    private String matchOperation = "ROLE_FILTER_EQUALS";

    @JsonProperty("name")
    private String name = null;



    /**
     * This is the getter method this will return the attribute value.
     * Enable this filter.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * This is the setter method to the attribute.
     * Enable this filter.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @param enabled set the enabled.
     */
    public void setEnabled(Boolean  enabled) {
        this.enabled = enabled;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Label key to match against objects for values.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return matchLabel
     */
    public RoleFilterMatchLabel getMatchLabel() {
        return matchLabel;
    }

    /**
     * This is the setter method to the attribute.
     * Label key to match against objects for values.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param matchLabel set the matchLabel.
     */
    public void setMatchLabel(RoleFilterMatchLabel matchLabel) {
        this.matchLabel = matchLabel;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Label match operation criteria.
     * Enum options - ROLE_FILTER_EQUALS, ROLE_FILTER_DOES_NOT_EQUAL, ROLE_FILTER_GLOB_MATCH, ROLE_FILTER_GLOB_DOES_NOT_MATCH.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as "ROLE_FILTER_EQUALS".
     * @return matchOperation
     */
    public String getMatchOperation() {
        return matchOperation;
    }

    /**
     * This is the setter method to the attribute.
     * Label match operation criteria.
     * Enum options - ROLE_FILTER_EQUALS, ROLE_FILTER_DOES_NOT_EQUAL, ROLE_FILTER_GLOB_MATCH, ROLE_FILTER_GLOB_DOES_NOT_MATCH.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as "ROLE_FILTER_EQUALS".
     * @param matchOperation set the matchOperation.
     */
    public void setMatchOperation(String  matchOperation) {
        this.matchOperation = matchOperation;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name for the filter.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name for the filter.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      RoleFilter objRoleFilter = (RoleFilter) o;
      return   Objects.equals(this.name, objRoleFilter.name)&&
  Objects.equals(this.matchOperation, objRoleFilter.matchOperation)&&
  Objects.equals(this.matchLabel, objRoleFilter.matchLabel)&&
  Objects.equals(this.enabled, objRoleFilter.enabled);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RoleFilter {\n");
                  sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
                        sb.append("    matchLabel: ").append(toIndentedString(matchLabel)).append("\n");
                        sb.append("    matchOperation: ").append(toIndentedString(matchOperation)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
