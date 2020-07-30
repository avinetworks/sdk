package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudRuntime is a POJO class extends AviRestResource that used for creating
 * CloudRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudRuntime extends AviRestResource  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("network_sync_complete")
    private Boolean networkSyncComplete = false;

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
   * Placeholder for description of property network_sync_complete of obj type cloudruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return networkSyncComplete
   */
  public Boolean getNetworkSyncComplete() {
    return networkSyncComplete;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property network_sync_complete of obj type cloudruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param networkSyncComplete set the networkSyncComplete.
   */
  public void setNetworkSyncComplete(Boolean  networkSyncComplete) {
    this.networkSyncComplete = networkSyncComplete;
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
  CloudRuntime objCloudRuntime = (CloudRuntime) o;
  return   Objects.equals(this.uuid, objCloudRuntime.uuid)&&
  Objects.equals(this.name, objCloudRuntime.name)&&
  Objects.equals(this.networkSyncComplete, objCloudRuntime.networkSyncComplete)&&
  Objects.equals(this.tenantRef, objCloudRuntime.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudRuntime {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    networkSyncComplete: ").append(toIndentedString(networkSyncComplete)).append("\n");
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

