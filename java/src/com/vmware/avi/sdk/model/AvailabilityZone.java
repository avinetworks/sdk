package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AvailabilityZone is a POJO class extends AviRestResource that used for creating
 * AvailabilityZone.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvailabilityZone extends AviRestResource  {
    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vcenter_refs")
    private List<String> vcenterRefs = null;



  /**
   * This is the getter method this will return the attribute value.
   * Availability zone belongs to cloud.
   * It is a reference to an object of type cloud.
   * Field introduced in 20.1.1.
   * @return cloudRef
   */
  public String getCloudRef() {
    return cloudRef;
  }

  /**
   * This is the setter method to the attribute.
   * Availability zone belongs to cloud.
   * It is a reference to an object of type cloud.
   * Field introduced in 20.1.1.
   * @param cloudRef set the cloudRef.
   */
  public void setCloudRef(String  cloudRef) {
    this.cloudRef = cloudRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Availabilty zone where vcenter list belongs to.
   * Field introduced in 20.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Availabilty zone where vcenter list belongs to.
   * Field introduced in 20.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Availabilityzone belongs to tenant.
   * It is a reference to an object of type tenant.
   * Field introduced in 20.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * Availabilityzone belongs to tenant.
   * It is a reference to an object of type tenant.
   * Field introduced in 20.1.1.
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
   * Availability zone config uuid.
   * Field introduced in 20.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Availability zone config uuid.
   * Field introduced in 20.1.1.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Group of vcenter list belong to availabilty zone.
   * It is a reference to an object of type vcenterserver.
   * Field introduced in 20.1.1.
   * @return vcenterRefs
   */
  public List<String> getVcenterRefs() {
    return vcenterRefs;
  }

  /**
   * This is the setter method. this will set the vcenterRefs
   * Group of vcenter list belong to availabilty zone.
   * It is a reference to an object of type vcenterserver.
   * Field introduced in 20.1.1.
   * @return vcenterRefs
   */
  public void setVcenterRefs(List<String>  vcenterRefs) {
    this.vcenterRefs = vcenterRefs;
  }

  /**
   * This is the setter method this will set the vcenterRefs
   * Group of vcenter list belong to availabilty zone.
   * It is a reference to an object of type vcenterserver.
   * Field introduced in 20.1.1.
   * @return vcenterRefs
   */
  public AvailabilityZone addVcenterRefsItem(String vcenterRefsItem) {
    if (this.vcenterRefs == null) {
      this.vcenterRefs = new ArrayList<String>();
    }
    this.vcenterRefs.add(vcenterRefsItem);
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
  AvailabilityZone objAvailabilityZone = (AvailabilityZone) o;
  return   Objects.equals(this.uuid, objAvailabilityZone.uuid)&&
  Objects.equals(this.cloudRef, objAvailabilityZone.cloudRef)&&
  Objects.equals(this.vcenterRefs, objAvailabilityZone.vcenterRefs)&&
  Objects.equals(this.tenantRef, objAvailabilityZone.tenantRef)&&
  Objects.equals(this.name, objAvailabilityZone.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AvailabilityZone {\n");
      sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vcenterRefs: ").append(toIndentedString(vcenterRefs)).append("\n");
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

