package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The IPReputationTypeMapping is a POJO class extends AviRestResource that used for creating
 * IPReputationTypeMapping.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IPReputationTypeMapping  {
    @JsonProperty("bot_identification")
    private BotIdentification botIdentification = null;

    @JsonProperty("ip_reputation_type")
    private String ipReputationType = null;



    /**
     * This is the getter method this will return the attribute value.
     * The bot identification to which the ip reputation type is mapped.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return botIdentification
     */
    public BotIdentification getBotIdentification() {
        return botIdentification;
    }

    /**
     * This is the setter method to the attribute.
     * The bot identification to which the ip reputation type is mapped.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param botIdentification set the botIdentification.
     */
    public void setBotIdentification(BotIdentification botIdentification) {
        this.botIdentification = botIdentification;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The type of ip reputation that is mapped to a bot identification.
     * Enum options - IP_REPUTATION_TYPE_SPAM_SOURCE, IP_REPUTATION_TYPE_WINDOWS_EXPLOITS, IP_REPUTATION_TYPE_WEB_ATTACKS, IP_REPUTATION_TYPE_BOTNETS,
     * IP_REPUTATION_TYPE_SCANNERS, IP_REPUTATION_TYPE_DOS, IP_REPUTATION_TYPE_REPUTATION, IP_REPUTATION_TYPE_PHISHING, IP_REPUTATION_TYPE_PROXY,
     * IP_REPUTATION_TYPE_CLOUD, IP_REPUTATION_TYPE_MOBILE_THREATS, IP_REPUTATION_TYPE_TOR, IP_REPUTATION_TYPE_ALL.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ipReputationType
     */
    public String getIpReputationType() {
        return ipReputationType;
    }

    /**
     * This is the setter method to the attribute.
     * The type of ip reputation that is mapped to a bot identification.
     * Enum options - IP_REPUTATION_TYPE_SPAM_SOURCE, IP_REPUTATION_TYPE_WINDOWS_EXPLOITS, IP_REPUTATION_TYPE_WEB_ATTACKS, IP_REPUTATION_TYPE_BOTNETS,
     * IP_REPUTATION_TYPE_SCANNERS, IP_REPUTATION_TYPE_DOS, IP_REPUTATION_TYPE_REPUTATION, IP_REPUTATION_TYPE_PHISHING, IP_REPUTATION_TYPE_PROXY,
     * IP_REPUTATION_TYPE_CLOUD, IP_REPUTATION_TYPE_MOBILE_THREATS, IP_REPUTATION_TYPE_TOR, IP_REPUTATION_TYPE_ALL.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ipReputationType set the ipReputationType.
     */
    public void setIpReputationType(String  ipReputationType) {
        this.ipReputationType = ipReputationType;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      IPReputationTypeMapping objIPReputationTypeMapping = (IPReputationTypeMapping) o;
      return   Objects.equals(this.ipReputationType, objIPReputationTypeMapping.ipReputationType)&&
  Objects.equals(this.botIdentification, objIPReputationTypeMapping.botIdentification);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class IPReputationTypeMapping {\n");
                  sb.append("    botIdentification: ").append(toIndentedString(botIdentification)).append("\n");
                        sb.append("    ipReputationType: ").append(toIndentedString(ipReputationType)).append("\n");
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
