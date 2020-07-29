package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OpenStackRoleMapping is a POJO class extends AviRestResource that used for creating
 * OpenStackRoleMapping.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenStackRoleMapping  {
    @JsonProperty("avi_role")
    private String aviRole = null;

    @JsonProperty("os_role")
    private String osRole = null;



  /**
   * This is the getter method this will return the attribute value.
   * Role name in avi.
   * @return aviRole
   */
  public String getAviRole() {
    return aviRole;
  }

  /**
   * This is the setter method to the attribute.
   * Role name in avi.
   * @param aviRole set the aviRole.
   */
  public void setAviRole(String  aviRole) {
    this.aviRole = aviRole;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Role name in openstack.
   * @return osRole
   */
  public String getOsRole() {
    return osRole;
  }

  /**
   * This is the setter method to the attribute.
   * Role name in openstack.
   * @param osRole set the osRole.
   */
  public void setOsRole(String  osRole) {
    this.osRole = osRole;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OpenStackRoleMapping objOpenStackRoleMapping = (OpenStackRoleMapping) o;
  return   Objects.equals(this.osRole, objOpenStackRoleMapping.osRole)&&
  Objects.equals(this.aviRole, objOpenStackRoleMapping.aviRole);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OpenStackRoleMapping {\n");
      sb.append("    aviRole: ").append(toIndentedString(aviRole)).append("\n");
        sb.append("    osRole: ").append(toIndentedString(osRole)).append("\n");
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

