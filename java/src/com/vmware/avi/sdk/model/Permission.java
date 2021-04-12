package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Permission is a POJO class extends AviRestResource that used for creating
 * Permission.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Permission  {
    @JsonProperty("resource")
    private String resource = null;

    @JsonProperty("subresource")
    private SubResource subresource = null;

    @JsonProperty("type")
    private String type = null;



    /**
     * This is the getter method this will return the attribute value.
     * Enum options - PERMISSION_CONTROLLER, PERMISSION_INTERNAL, PERMISSION_VIRTUALSERVICE, PERMISSION_POOL, PERMISSION_HEALTHMONITOR,
     * PERMISSION_NETWORKPROFILE, PERMISSION_APPLICATIONPROFILE, PERMISSION_HTTPPOLICYSET, PERMISSION_IPADDRGROUP, PERMISSION_STRINGGROUP,
     * PERMISSION_SSLPROFILE, PERMISSION_SSLKEYANDCERTIFICATE, PERMISSION_NETWORKSECURITYPOLICY, PERMISSION_APPLICATIONPERSISTENCEPROFILE,
     * PERMISSION_ANALYTICSPROFILE, PERMISSION_VSDATASCRIPTSET, PERMISSION_TENANT, PERMISSION_PKIPROFILE, PERMISSION_AUTHPROFILE, PERMISSION_CLOUD...
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * This is the setter method to the attribute.
     * Enum options - PERMISSION_CONTROLLER, PERMISSION_INTERNAL, PERMISSION_VIRTUALSERVICE, PERMISSION_POOL, PERMISSION_HEALTHMONITOR,
     * PERMISSION_NETWORKPROFILE, PERMISSION_APPLICATIONPROFILE, PERMISSION_HTTPPOLICYSET, PERMISSION_IPADDRGROUP, PERMISSION_STRINGGROUP,
     * PERMISSION_SSLPROFILE, PERMISSION_SSLKEYANDCERTIFICATE, PERMISSION_NETWORKSECURITYPOLICY, PERMISSION_APPLICATIONPERSISTENCEPROFILE,
     * PERMISSION_ANALYTICSPROFILE, PERMISSION_VSDATASCRIPTSET, PERMISSION_TENANT, PERMISSION_PKIPROFILE, PERMISSION_AUTHPROFILE, PERMISSION_CLOUD...
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param resource set the resource.
     */
    public void setResource(String  resource) {
        this.resource = resource;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Limits the scope of write access on the parent resource to modification of only the specified subresources.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return subresource
     */
    public SubResource getSubresource() {
        return subresource;
    }

    /**
     * This is the setter method to the attribute.
     * Limits the scope of write access on the parent resource to modification of only the specified subresources.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param subresource set the subresource.
     */
    public void setSubresource(SubResource subresource) {
        this.subresource = subresource;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * This is the setter method to the attribute.
     * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param type set the type.
     */
    public void setType(String  type) {
        this.type = type;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      Permission objPermission = (Permission) o;
      return   Objects.equals(this.type, objPermission.type)&&
  Objects.equals(this.resource, objPermission.resource)&&
  Objects.equals(this.subresource, objPermission.subresource);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Permission {\n");
                  sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
                        sb.append("    subresource: ").append(toIndentedString(subresource)).append("\n");
                        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
