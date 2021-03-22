package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The BotConfigIPReputation is a POJO class extends AviRestResource that used for creating
 * BotConfigIPReputation.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotConfigIPReputation  {
    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("ip_reputation_db_ref")
    private String ipReputationDbRef = null;

    @JsonProperty("ip_reputation_mappings")
    private List<IPReputationTypeMapping> ipReputationMappings = null;



    /**
     * This is the getter method this will return the attribute value.
     * Whether ip reputation-based bot detection is enabled.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * This is the setter method to the attribute.
     * Whether ip reputation-based bot detection is enabled.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @param enabled set the enabled.
     */
    public void setEnabled(Boolean  enabled) {
        this.enabled = enabled;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The uuid of the ip reputation db to use.
     * It is a reference to an object of type ipreputationdb.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ipReputationDbRef
     */
    public String getIpReputationDbRef() {
        return ipReputationDbRef;
    }

    /**
     * This is the setter method to the attribute.
     * The uuid of the ip reputation db to use.
     * It is a reference to an object of type ipreputationdb.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ipReputationDbRef set the ipReputationDbRef.
     */
    public void setIpReputationDbRef(String  ipReputationDbRef) {
        this.ipReputationDbRef = ipReputationDbRef;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Map every ipreputationtype to a bot type (can be unknown).
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ipReputationMappings
     */
    public List<IPReputationTypeMapping> getIpReputationMappings() {
        return ipReputationMappings;
    }

    /**
     * This is the setter method. this will set the ipReputationMappings
     * Map every ipreputationtype to a bot type (can be unknown).
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ipReputationMappings
     */
    public void setIpReputationMappings(List<IPReputationTypeMapping>  ipReputationMappings) {
        this.ipReputationMappings = ipReputationMappings;
    }

    /**
     * This is the setter method this will set the ipReputationMappings
     * Map every ipreputationtype to a bot type (can be unknown).
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ipReputationMappings
     */
    public BotConfigIPReputation addIpReputationMappingsItem(IPReputationTypeMapping ipReputationMappingsItem) {
      if (this.ipReputationMappings == null) {
        this.ipReputationMappings = new ArrayList<IPReputationTypeMapping>();
      }
      this.ipReputationMappings.add(ipReputationMappingsItem);
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
      BotConfigIPReputation objBotConfigIPReputation = (BotConfigIPReputation) o;
      return   Objects.equals(this.enabled, objBotConfigIPReputation.enabled)&&
  Objects.equals(this.ipReputationDbRef, objBotConfigIPReputation.ipReputationDbRef)&&
  Objects.equals(this.ipReputationMappings, objBotConfigIPReputation.ipReputationMappings);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BotConfigIPReputation {\n");
                  sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
                        sb.append("    ipReputationDbRef: ").append(toIndentedString(ipReputationDbRef)).append("\n");
                        sb.append("    ipReputationMappings: ").append(toIndentedString(ipReputationMappings)).append("\n");
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
