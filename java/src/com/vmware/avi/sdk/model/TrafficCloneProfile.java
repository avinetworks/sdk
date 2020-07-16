package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The TrafficCloneProfile is a POJO class extends AviRestResource that used for creating
 * TrafficCloneProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrafficCloneProfile extends AviRestResource  {
    @JsonProperty("clone_servers")
    private List<CloneServer> cloneServers = null;

    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("preserve_client_ip")
    private Boolean preserveClientIp = false;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;


  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return cloneServers
   */
  public List<CloneServer> getCloneServers() {
    return cloneServers;
  }

  /**
   * This is the setter method. this will set the cloneServers
   * Field introduced in 17.1.1.
   * @return cloneServers
   */
  public void setCloneServers(List<CloneServer>  cloneServers) {
    this.cloneServers = cloneServers;
  }

  /**
   * This is the setter method this will set the cloneServers
   * Field introduced in 17.1.1.
   * @return cloneServers
   */
  public TrafficCloneProfile addCloneServersItem(CloneServer cloneServersItem) {
    if (this.cloneServers == null) {
      this.cloneServers = new ArrayList<CloneServer>();
    }
    this.cloneServers.add(cloneServersItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type cloud.
   * Field introduced in 17.1.1.
   * @return cloudRef
   */
  public String getCloudRef() {
    return cloudRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type cloud.
   * Field introduced in 17.1.1.
   * @param cloudRef set the cloudRef.
   */
  public void setCloudRef(String  cloudRef) {
    this.cloudRef = cloudRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name for the traffic clone profile.
   * Field introduced in 17.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name for the traffic clone profile.
   * Field introduced in 17.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies if client ip needs to be preserved to clone destination.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return preserveClientIp
   */
  public Boolean getPreserveClientIp() {
    return preserveClientIp;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies if client ip needs to be preserved to clone destination.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param preserveClientIp set the preserveClientIp.
   */
  public void setPreserveClientIp(Boolean  preserveClientIp) {
    this.preserveClientIp = preserveClientIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.1.1.
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
   * Uuid of the traffic clone profile.
   * Field introduced in 17.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the traffic clone profile.
   * Field introduced in 17.1.1.
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
  TrafficCloneProfile objTrafficCloneProfile = (TrafficCloneProfile) o;
  return   Objects.equals(this.uuid, objTrafficCloneProfile.uuid)&&
  Objects.equals(this.name, objTrafficCloneProfile.name)&&
  Objects.equals(this.preserveClientIp, objTrafficCloneProfile.preserveClientIp)&&
  Objects.equals(this.tenantRef, objTrafficCloneProfile.tenantRef)&&
  Objects.equals(this.cloudRef, objTrafficCloneProfile.cloudRef)&&
  Objects.equals(this.cloneServers, objTrafficCloneProfile.cloneServers);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class TrafficCloneProfile {\n");
      sb.append("    cloneServers: ").append(toIndentedString(cloneServers)).append("\n");
        sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    preserveClientIp: ").append(toIndentedString(preserveClientIp)).append("\n");
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

