package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The BotDetectionPolicy is a POJO class extends AviRestResource that used for creating
 * BotDetectionPolicy.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotDetectionPolicy extends AviRestResource  {
    @JsonProperty("allow_list")
    private BotAllowList allowList = null;

    @JsonProperty("bot_mapping_uuids")
    private List<String> botMappingUuids = null;

    @JsonProperty("consolidator_ref")
    private String consolidatorRef = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("ip_location_detector")
    private BotConfigIPLocation ipLocationDetector = null;

    @JsonProperty("ip_reputation_detector")
    private BotConfigIPReputation ipReputationDetector = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("user_agent_detector")
    private BotConfigUserAgent userAgentDetector = null;

    @JsonProperty("uuid")
    private String uuid = null;



    /**
     * This is the getter method this will return the attribute value.
     * Allow the user to skip botmanagement for selected requests.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return allowList
     */
    public BotAllowList getAllowList() {
        return allowList;
    }

    /**
     * This is the setter method to the attribute.
     * Allow the user to skip botmanagement for selected requests.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param allowList set the allowList.
     */
    public void setAllowList(BotAllowList allowList) {
        this.allowList = allowList;
    }
    /**
     * This is the getter method this will return the attribute value.
     * System- and user-defined rules for classification.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return botMappingUuids
     */
    public List<String> getBotMappingUuids() {
        return botMappingUuids;
    }

    /**
     * This is the setter method. this will set the botMappingUuids
     * System- and user-defined rules for classification.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return botMappingUuids
     */
    public void setBotMappingUuids(List<String>  botMappingUuids) {
        this.botMappingUuids = botMappingUuids;
    }

    /**
     * This is the setter method this will set the botMappingUuids
     * System- and user-defined rules for classification.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return botMappingUuids
     */
    public BotDetectionPolicy addBotMappingUuidsItem(String botMappingUuidsItem) {
      if (this.botMappingUuids == null) {
        this.botMappingUuids = new ArrayList<String>();
      }
      this.botMappingUuids.add(botMappingUuidsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The installation provides an updated ruleset for consolidating the results of different decider phases.
     * It is a reference to an object of type botconfigconsolidator.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return consolidatorRef
     */
    public String getConsolidatorRef() {
        return consolidatorRef;
    }

    /**
     * This is the setter method to the attribute.
     * The installation provides an updated ruleset for consolidating the results of different decider phases.
     * It is a reference to an object of type botconfigconsolidator.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param consolidatorRef set the consolidatorRef.
     */
    public void setConsolidatorRef(String  consolidatorRef) {
        this.consolidatorRef = consolidatorRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Human-readable description of this bot detection policy.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the setter method to the attribute.
     * Human-readable description of this bot detection policy.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param description set the description.
     */
    public void setDescription(String  description) {
        this.description = description;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The ip location configuration used in this policy.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ipLocationDetector
     */
    public BotConfigIPLocation getIpLocationDetector() {
        return ipLocationDetector;
    }

    /**
     * This is the setter method to the attribute.
     * The ip location configuration used in this policy.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ipLocationDetector set the ipLocationDetector.
     */
    public void setIpLocationDetector(BotConfigIPLocation ipLocationDetector) {
        this.ipLocationDetector = ipLocationDetector;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The ip reputation configuration used in this policy.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ipReputationDetector
     */
    public BotConfigIPReputation getIpReputationDetector() {
        return ipReputationDetector;
    }

    /**
     * This is the setter method to the attribute.
     * The ip reputation configuration used in this policy.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ipReputationDetector set the ipReputationDetector.
     */
    public void setIpReputationDetector(BotConfigIPReputation ipReputationDetector) {
        this.ipReputationDetector = ipReputationDetector;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The name of this bot detection policy.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * The name of this bot detection policy.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The unique identifier of the tenant to which this policy belongs.
     * It is a reference to an object of type tenant.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRef
     */
    public String getTenantRef() {
        return tenantRef;
    }

    /**
     * This is the setter method to the attribute.
     * The unique identifier of the tenant to which this policy belongs.
     * It is a reference to an object of type tenant.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param tenantRef set the tenantRef.
     */
    public void setTenantRef(String  tenantRef) {
        this.tenantRef = tenantRef;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Avi controller URL of the object.
     * @return url
     */
    public String getUrl() {
        return url;
    }

   /**
    * This is the setter method. this will set the url
    * Avi controller URL of the object.
    * @return url
    */
   public void setUrl(String  url) {
     this.url = url;
   }

    /**
     * This is the getter method this will return the attribute value.
     * The user-agent configuration used in this policy.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return userAgentDetector
     */
    public BotConfigUserAgent getUserAgentDetector() {
        return userAgentDetector;
    }

    /**
     * This is the setter method to the attribute.
     * The user-agent configuration used in this policy.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param userAgentDetector set the userAgentDetector.
     */
    public void setUserAgentDetector(BotConfigUserAgent userAgentDetector) {
        this.userAgentDetector = userAgentDetector;
    }

    /**
     * This is the getter method this will return the attribute value.
     * A unique identifier to this bot detection policy.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * A unique identifier to this bot detection policy.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param uuid set the uuid.
     */
    public void setUuid(String  uuid) {
        this.uuid = uuid;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      BotDetectionPolicy objBotDetectionPolicy = (BotDetectionPolicy) o;
      return   Objects.equals(this.uuid, objBotDetectionPolicy.uuid)&&
  Objects.equals(this.tenantRef, objBotDetectionPolicy.tenantRef)&&
  Objects.equals(this.name, objBotDetectionPolicy.name)&&
  Objects.equals(this.description, objBotDetectionPolicy.description)&&
  Objects.equals(this.allowList, objBotDetectionPolicy.allowList)&&
  Objects.equals(this.ipReputationDetector, objBotDetectionPolicy.ipReputationDetector)&&
  Objects.equals(this.ipLocationDetector, objBotDetectionPolicy.ipLocationDetector)&&
  Objects.equals(this.userAgentDetector, objBotDetectionPolicy.userAgentDetector)&&
  Objects.equals(this.consolidatorRef, objBotDetectionPolicy.consolidatorRef)&&
  Objects.equals(this.botMappingUuids, objBotDetectionPolicy.botMappingUuids);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BotDetectionPolicy {\n");
                  sb.append("    allowList: ").append(toIndentedString(allowList)).append("\n");
                        sb.append("    botMappingUuids: ").append(toIndentedString(botMappingUuids)).append("\n");
                        sb.append("    consolidatorRef: ").append(toIndentedString(consolidatorRef)).append("\n");
                        sb.append("    description: ").append(toIndentedString(description)).append("\n");
                        sb.append("    ipLocationDetector: ").append(toIndentedString(ipLocationDetector)).append("\n");
                        sb.append("    ipReputationDetector: ").append(toIndentedString(ipReputationDetector)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
                                    sb.append("    userAgentDetector: ").append(toIndentedString(userAgentDetector)).append("\n");
                        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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
