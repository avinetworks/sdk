package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Role is a POJO class extends AviRestResource that used for creating
 * Role.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role extends AviRestResource  {
    @JsonProperty("filters")
    private List<RoleFilter> filters = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("privileges")
    private List<Permission> privileges = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;


    /**
     * This is the getter method this will return the attribute value.
     * Filters for granular object access control based on object labels.
     * Multiple filters are merged using the and operator.
     * If empty, all objects according to the privileges will be accessible to the user.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return filters
     */
    public List<RoleFilter> getFilters() {
        return filters;
    }

    /**
     * This is the setter method. this will set the filters
     * Filters for granular object access control based on object labels.
     * Multiple filters are merged using the and operator.
     * If empty, all objects according to the privileges will be accessible to the user.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return filters
     */
    public void setFilters(List<RoleFilter>  filters) {
        this.filters = filters;
    }

    /**
     * This is the setter method this will set the filters
     * Filters for granular object access control based on object labels.
     * Multiple filters are merged using the and operator.
     * If empty, all objects according to the privileges will be accessible to the user.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return filters
     */
    public Role addFiltersItem(RoleFilter filtersItem) {
      if (this.filters == null) {
        this.filters = new ArrayList<RoleFilter>();
      }
      this.filters.add(filtersItem);
      return this;
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
     * Placeholder for description of property privileges of obj type role field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return privileges
     */
    public List<Permission> getPrivileges() {
        return privileges;
    }

    /**
     * This is the setter method. this will set the privileges
     * Placeholder for description of property privileges of obj type role field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return privileges
     */
    public void setPrivileges(List<Permission>  privileges) {
        this.privileges = privileges;
    }

    /**
     * This is the setter method this will set the privileges
     * Placeholder for description of property privileges of obj type role field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return privileges
     */
    public Role addPrivilegesItem(Permission privilegesItem) {
      if (this.privileges == null) {
        this.privileges = new ArrayList<Permission>();
      }
      this.privileges.add(privilegesItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRef
     */
    public String getTenantRef() {
        return tenantRef;
    }

    /**
     * This is the setter method to the attribute.
     * It is a reference to an object of type tenant.
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
      Role objRole = (Role) o;
      return   Objects.equals(this.uuid, objRole.uuid)&&
  Objects.equals(this.name, objRole.name)&&
  Objects.equals(this.privileges, objRole.privileges)&&
  Objects.equals(this.filters, objRole.filters)&&
  Objects.equals(this.tenantRef, objRole.tenantRef);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Role {\n");
                  sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    privileges: ").append(toIndentedString(privileges)).append("\n");
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
