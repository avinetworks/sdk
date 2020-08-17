package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SnmpV3Configuration is a POJO class extends AviRestResource that used for creating
 * SnmpV3Configuration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SnmpV3Configuration  {
    @JsonProperty("engine_id")
    private String engineId = null;

    @JsonProperty("user")
    private SnmpV3UserParams user = null;



  /**
   * This is the getter method this will return the attribute value.
   * Engine id of the avi controller snmp.
   * Field introduced in 17.2.3.
   * @return engineId
   */
  public String getEngineId() {
    return engineId;
  }

  /**
   * This is the setter method to the attribute.
   * Engine id of the avi controller snmp.
   * Field introduced in 17.2.3.
   * @param engineId set the engineId.
   */
  public void setEngineId(String  engineId) {
    this.engineId = engineId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Snmp ver 3 user definition.
   * Field introduced in 17.2.3.
   * @return user
   */
  public SnmpV3UserParams getUser() {
    return user;
  }

  /**
   * This is the setter method to the attribute.
   * Snmp ver 3 user definition.
   * Field introduced in 17.2.3.
   * @param user set the user.
   */
  public void setUser(SnmpV3UserParams user) {
    this.user = user;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SnmpV3Configuration objSnmpV3Configuration = (SnmpV3Configuration) o;
  return   Objects.equals(this.user, objSnmpV3Configuration.user)&&
  Objects.equals(this.engineId, objSnmpV3Configuration.engineId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SnmpV3Configuration {\n");
      sb.append("    engineId: ").append(toIndentedString(engineId)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

