package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The SubResource is a POJO class extends AviRestResource that used for creating
 * SubResource.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubResource  {
    @JsonProperty("exclude_subresources")
    private Boolean excludeSubresources = false;

    @JsonProperty("subresources")
    private List<String> subresources = null;



    /**
     * This is the getter method this will return the attribute value.
     * Allows modification of all fields except for the specified subresources.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return excludeSubresources
     */
    public Boolean getExcludeSubresources() {
        return excludeSubresources;
    }

    /**
     * This is the setter method to the attribute.
     * Allows modification of all fields except for the specified subresources.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param excludeSubresources set the excludeSubresources.
     */
    public void setExcludeSubresources(Boolean  excludeSubresources) {
        this.excludeSubresources = excludeSubresources;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Subresources user can modify.
     * Each subresource specifies and individual field.
     * I.e.
     * Subresource_pool_enabled allows modification of the enabled field in the pool object.
     * Enum options - SUBRESOURCE_POOL_ENABLED, SUBRESOURCE_POOL_SERVERS, SUBRESOURCE_POOL_SERVER_ENABLED, SUBRESOURCE_VIRTUALSERVICE_ENABLED,
     * SUBRESOURCE_GSLBSERVICE_ENABLED, SUBRESOURCE_GSLBSERVICE_GROUPS, SUBRESOURCE_GSLBSERVICE_GROUP_ENABLED, SUBRESOURCE_GSLBSERVICE_GROUP_MEMBERS,
     * SUBRESOURCE_GSLBSERVICE_GROUP_MEMBER_ENABLED.
     * Field introduced in 20.1.5.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return subresources
     */
    public List<String> getSubresources() {
        return subresources;
    }

    /**
     * This is the setter method. this will set the subresources
     * Subresources user can modify.
     * Each subresource specifies and individual field.
     * I.e.
     * Subresource_pool_enabled allows modification of the enabled field in the pool object.
     * Enum options - SUBRESOURCE_POOL_ENABLED, SUBRESOURCE_POOL_SERVERS, SUBRESOURCE_POOL_SERVER_ENABLED, SUBRESOURCE_VIRTUALSERVICE_ENABLED,
     * SUBRESOURCE_GSLBSERVICE_ENABLED, SUBRESOURCE_GSLBSERVICE_GROUPS, SUBRESOURCE_GSLBSERVICE_GROUP_ENABLED, SUBRESOURCE_GSLBSERVICE_GROUP_MEMBERS,
     * SUBRESOURCE_GSLBSERVICE_GROUP_MEMBER_ENABLED.
     * Field introduced in 20.1.5.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return subresources
     */
    public void setSubresources(List<String>  subresources) {
        this.subresources = subresources;
    }

    /**
     * This is the setter method this will set the subresources
     * Subresources user can modify.
     * Each subresource specifies and individual field.
     * I.e.
     * Subresource_pool_enabled allows modification of the enabled field in the pool object.
     * Enum options - SUBRESOURCE_POOL_ENABLED, SUBRESOURCE_POOL_SERVERS, SUBRESOURCE_POOL_SERVER_ENABLED, SUBRESOURCE_VIRTUALSERVICE_ENABLED,
     * SUBRESOURCE_GSLBSERVICE_ENABLED, SUBRESOURCE_GSLBSERVICE_GROUPS, SUBRESOURCE_GSLBSERVICE_GROUP_ENABLED, SUBRESOURCE_GSLBSERVICE_GROUP_MEMBERS,
     * SUBRESOURCE_GSLBSERVICE_GROUP_MEMBER_ENABLED.
     * Field introduced in 20.1.5.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return subresources
     */
    public SubResource addSubresourcesItem(String subresourcesItem) {
      if (this.subresources == null) {
        this.subresources = new ArrayList<String>();
      }
      this.subresources.add(subresourcesItem);
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
      SubResource objSubResource = (SubResource) o;
      return   Objects.equals(this.excludeSubresources, objSubResource.excludeSubresources)&&
  Objects.equals(this.subresources, objSubResource.subresources);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SubResource {\n");
                  sb.append("    excludeSubresources: ").append(toIndentedString(excludeSubresources)).append("\n");
                        sb.append("    subresources: ").append(toIndentedString(subresources)).append("\n");
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
