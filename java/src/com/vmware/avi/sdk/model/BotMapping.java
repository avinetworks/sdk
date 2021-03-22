package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The BotMapping is a POJO class extends AviRestResource that used for creating
 * BotMapping.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BotMapping extends AviRestResource  {
    @JsonProperty("mapping_rules")
    private List<BotMappingRule> mappingRules = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;


    /**
     * This is the getter method this will return the attribute value.
     * Rules for bot classification.
     * Field introduced in 21.1.1.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mappingRules
     */
    public List<BotMappingRule> getMappingRules() {
        return mappingRules;
    }

    /**
     * This is the setter method. this will set the mappingRules
     * Rules for bot classification.
     * Field introduced in 21.1.1.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mappingRules
     */
    public void setMappingRules(List<BotMappingRule>  mappingRules) {
        this.mappingRules = mappingRules;
    }

    /**
     * This is the setter method this will set the mappingRules
     * Rules for bot classification.
     * Field introduced in 21.1.1.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mappingRules
     */
    public BotMapping addMappingRulesItem(BotMappingRule mappingRulesItem) {
      if (this.mappingRules == null) {
        this.mappingRules = new ArrayList<BotMappingRule>();
      }
      this.mappingRules.add(mappingRulesItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The name of this mapping.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * The name of this mapping.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The unique identifier of the tenant to which this mapping belongs.
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
     * The unique identifier of the tenant to which this mapping belongs.
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
     * A unique identifier of this mapping.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * A unique identifier of this mapping.
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
      BotMapping objBotMapping = (BotMapping) o;
      return   Objects.equals(this.uuid, objBotMapping.uuid)&&
  Objects.equals(this.tenantRef, objBotMapping.tenantRef)&&
  Objects.equals(this.name, objBotMapping.name)&&
  Objects.equals(this.mappingRules, objBotMapping.mappingRules);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BotMapping {\n");
                  sb.append("    mappingRules: ").append(toIndentedString(mappingRules)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
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
