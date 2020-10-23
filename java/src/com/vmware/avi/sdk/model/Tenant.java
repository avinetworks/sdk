package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Tenant is a POJO class extends AviRestResource that used for creating
 * Tenant.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tenant extends AviRestResource  {
    @JsonProperty("config_settings")
    private TenantConfiguration configSettings = null;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("local")
    private Boolean local = true;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("suggested_object_labels")
    private List<TenantLabel> suggestedObjectLabels = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property config_settings of obj type tenant field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return configSettings
     */
    public TenantConfiguration getConfigSettings() {
        return configSettings;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property config_settings of obj type tenant field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param configSettings set the configSettings.
     */
    public void setConfigSettings(TenantConfiguration configSettings) {
        this.configSettings = configSettings;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Creator of this tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This is the setter method to the attribute.
     * Creator of this tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param createdBy set the createdBy.
     */
    public void setCreatedBy(String  createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This is the getter method this will return the attribute value.
     * User defined description for the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the setter method to the attribute.
     * User defined description for the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param description set the description.
     */
    public void setDescription(String  description) {
        this.description = description;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property local of obj type tenant field type str  type boolean.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @return local
     */
    public Boolean getLocal() {
        return local;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property local of obj type tenant field type str  type boolean.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @param local set the local.
     */
    public void setLocal(Boolean  local) {
        this.local = local;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Suggestive pool of key value pairs for recommending assignment of labels to objects in the user interface.
     * Every entry is unique in both key and value.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return suggestedObjectLabels
     */
    public List<TenantLabel> getSuggestedObjectLabels() {
        return suggestedObjectLabels;
    }

    /**
     * This is the setter method. this will set the suggestedObjectLabels
     * Suggestive pool of key value pairs for recommending assignment of labels to objects in the user interface.
     * Every entry is unique in both key and value.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return suggestedObjectLabels
     */
    public void setSuggestedObjectLabels(List<TenantLabel>  suggestedObjectLabels) {
        this.suggestedObjectLabels = suggestedObjectLabels;
    }

    /**
     * This is the setter method this will set the suggestedObjectLabels
     * Suggestive pool of key value pairs for recommending assignment of labels to objects in the user interface.
     * Every entry is unique in both key and value.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return suggestedObjectLabels
     */
    public Tenant addSuggestedObjectLabelsItem(TenantLabel suggestedObjectLabelsItem) {
      if (this.suggestedObjectLabels == null) {
        this.suggestedObjectLabels = new ArrayList<TenantLabel>();
      }
      this.suggestedObjectLabels.add(suggestedObjectLabelsItem);
      return this;
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
     * Unique object identifier of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Unique object identifier of the object.
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
      Tenant objTenant = (Tenant) o;
      return   Objects.equals(this.uuid, objTenant.uuid)&&
  Objects.equals(this.name, objTenant.name)&&
  Objects.equals(this.local, objTenant.local)&&
  Objects.equals(this.description, objTenant.description)&&
  Objects.equals(this.configSettings, objTenant.configSettings)&&
  Objects.equals(this.createdBy, objTenant.createdBy)&&
  Objects.equals(this.suggestedObjectLabels, objTenant.suggestedObjectLabels);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Tenant {\n");
                  sb.append("    configSettings: ").append(toIndentedString(configSettings)).append("\n");
                        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
                        sb.append("    description: ").append(toIndentedString(description)).append("\n");
                        sb.append("    local: ").append(toIndentedString(local)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    suggestedObjectLabels: ").append(toIndentedString(suggestedObjectLabels)).append("\n");
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
