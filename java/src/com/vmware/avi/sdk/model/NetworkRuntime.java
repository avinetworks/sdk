package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NetworkRuntime is a POJO class extends AviRestResource that used for creating
 * NetworkRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkRuntime extends AviRestResource  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("se_uuid")
    private List<String> seUuid = null;

    @JsonProperty("subnet_runtime")
    private List<SubnetRuntime> subnetRuntime = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



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
   * Unique object identifier of se.
   * @return seUuid
   */
  public List<String> getSeUuid() {
    return seUuid;
  }

  /**
   * This is the setter method. this will set the seUuid
   * Unique object identifier of se.
   * @return seUuid
   */
  public void setSeUuid(List<String>  seUuid) {
    this.seUuid = seUuid;
  }

  /**
   * This is the setter method this will set the seUuid
   * Unique object identifier of se.
   * @return seUuid
   */
  public NetworkRuntime addSeUuidItem(String seUuidItem) {
    if (this.seUuid == null) {
      this.seUuid = new ArrayList<String>();
    }
    this.seUuid.add(seUuidItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property subnet_runtime of obj type networkruntime field type str  type array.
   * @return subnetRuntime
   */
  public List<SubnetRuntime> getSubnetRuntime() {
    return subnetRuntime;
  }

  /**
   * This is the setter method. this will set the subnetRuntime
   * Placeholder for description of property subnet_runtime of obj type networkruntime field type str  type array.
   * @return subnetRuntime
   */
  public void setSubnetRuntime(List<SubnetRuntime>  subnetRuntime) {
    this.subnetRuntime = subnetRuntime;
  }

  /**
   * This is the setter method this will set the subnetRuntime
   * Placeholder for description of property subnet_runtime of obj type networkruntime field type str  type array.
   * @return subnetRuntime
   */
  public NetworkRuntime addSubnetRuntimeItem(SubnetRuntime subnetRuntimeItem) {
    if (this.subnetRuntime == null) {
      this.subnetRuntime = new ArrayList<SubnetRuntime>();
    }
    this.subnetRuntime.add(subnetRuntimeItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
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
  NetworkRuntime objNetworkRuntime = (NetworkRuntime) o;
  return   Objects.equals(this.uuid, objNetworkRuntime.uuid)&&
  Objects.equals(this.name, objNetworkRuntime.name)&&
  Objects.equals(this.subnetRuntime, objNetworkRuntime.subnetRuntime)&&
  Objects.equals(this.seUuid, objNetworkRuntime.seUuid)&&
  Objects.equals(this.tenantRef, objNetworkRuntime.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NetworkRuntime {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    seUuid: ").append(toIndentedString(seUuid)).append("\n");
        sb.append("    subnetRuntime: ").append(toIndentedString(subnetRuntime)).append("\n");
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

