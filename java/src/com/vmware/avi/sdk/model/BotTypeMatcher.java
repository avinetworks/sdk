package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The BotTypeMatcher is a POJO class extends AviRestResource that used for creating
 * BotTypeMatcher.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotTypeMatcher  {
    @JsonProperty("client_types")
    private List<String> clientTypes = null;

    @JsonProperty("op")
    private String op = "IS_IN";


    /**
     * This is the getter method this will return the attribute value.
     * The list of client types.
     * Enum options - WEB_BROWSER, IN_APP_BROWSER, SEARCH_ENGINE, IMPERSONATOR, SPAM_SOURCE, WEB_ATTACKS, BOTNET, SCANNER, DENIAL_OF_SERVICE,
     * CLOUD_SOURCE.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return clientTypes
     */
    public List<String> getClientTypes() {
        return clientTypes;
    }

    /**
     * This is the setter method. this will set the clientTypes
     * The list of client types.
     * Enum options - WEB_BROWSER, IN_APP_BROWSER, SEARCH_ENGINE, IMPERSONATOR, SPAM_SOURCE, WEB_ATTACKS, BOTNET, SCANNER, DENIAL_OF_SERVICE,
     * CLOUD_SOURCE.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return clientTypes
     */
    public void setClientTypes(List<String>  clientTypes) {
        this.clientTypes = clientTypes;
    }

    /**
     * This is the setter method this will set the clientTypes
     * The list of client types.
     * Enum options - WEB_BROWSER, IN_APP_BROWSER, SEARCH_ENGINE, IMPERSONATOR, SPAM_SOURCE, WEB_ATTACKS, BOTNET, SCANNER, DENIAL_OF_SERVICE,
     * CLOUD_SOURCE.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return clientTypes
     */
    public BotTypeMatcher addClientTypesItem(String clientTypesItem) {
      if (this.clientTypes == null) {
        this.clientTypes = new ArrayList<String>();
      }
      this.clientTypes.add(clientTypesItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The match operation.
     * Enum options - IS_IN, IS_NOT_IN.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as "IS_IN".
     * @return op
     */
    public String getOp() {
        return op;
    }

    /**
     * This is the setter method to the attribute.
     * The match operation.
     * Enum options - IS_IN, IS_NOT_IN.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as "IS_IN".
     * @param op set the op.
     */
    public void setOp(String  op) {
        this.op = op;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      BotTypeMatcher objBotTypeMatcher = (BotTypeMatcher) o;
      return   Objects.equals(this.op, objBotTypeMatcher.op)&&
  Objects.equals(this.clientTypes, objBotTypeMatcher.clientTypes);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BotTypeMatcher {\n");
                  sb.append("    clientTypes: ").append(toIndentedString(clientTypes)).append("\n");
                        sb.append("    op: ").append(toIndentedString(op)).append("\n");
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
