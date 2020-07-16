package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VersionInfo is a POJO class extends AviRestResource that used for creating
 * VersionInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VersionInfo extends AviRestResource  {
    @JsonProperty("ds_name")
    private String dsName = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("ops")
    private String ops = null;

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Identifies the datastore table.
   * Field introduced in 17.2.7.
   * @return dsName
   */
  public String getDsName() {
    return dsName;
  }

  /**
   * This is the setter method to the attribute.
   * Identifies the datastore table.
   * Field introduced in 17.2.7.
   * @param dsName set the dsName.
   */
  public void setDsName(String  dsName) {
    this.dsName = dsName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - GSLB_NONE, GSLB_CREATE, GSLB_UPDATE, GSLB_DELETE, GSLB_PURGE, GSLB_DECL.
   * @return ops
   */
  public String getOps() {
    return ops;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - GSLB_NONE, GSLB_CREATE, GSLB_UPDATE, GSLB_DELETE, GSLB_PURGE, GSLB_DECL.
   * @param ops set the ops.
   */
  public void setOps(String  ops) {
    this.ops = ops;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
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
  VersionInfo objVersionInfo = (VersionInfo) o;
  return   Objects.equals(this.dsName, objVersionInfo.dsName)&&
  Objects.equals(this.ops, objVersionInfo.ops)&&
  Objects.equals(this.uuid, objVersionInfo.uuid)&&
  Objects.equals(this.name, objVersionInfo.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VersionInfo {\n");
      sb.append("    dsName: ").append(toIndentedString(dsName)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    ops: ").append(toIndentedString(ops)).append("\n");
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

