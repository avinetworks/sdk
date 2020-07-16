package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The JobEntry is a POJO class extends AviRestResource that used for creating
 * JobEntry.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JobEntry extends AviRestResource  {
    @JsonProperty("expires_at")
    private String expiresAt = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("obj_key")
    private String objKey = null;

    @JsonProperty("subjobs")
    private List<SubJob> subjobs = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property expires_at of obj type jobentry field type str  type string.
   * @return expiresAt
   */
  public String getExpiresAt() {
    return expiresAt;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property expires_at of obj type jobentry field type str  type string.
   * @param expiresAt set the expiresAt.
   */
  public void setExpiresAt(String  expiresAt) {
    this.expiresAt = expiresAt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.1.2.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.1.2.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property obj_key of obj type jobentry field type str  type string.
   * @return objKey
   */
  public String getObjKey() {
    return objKey;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property obj_key of obj type jobentry field type str  type string.
   * @param objKey set the objKey.
   */
  public void setObjKey(String  objKey) {
    this.objKey = objKey;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.1.1.
   * @return subjobs
   */
  public List<SubJob> getSubjobs() {
    return subjobs;
  }

  /**
   * This is the setter method. this will set the subjobs
   * Field introduced in 18.1.1.
   * @return subjobs
   */
  public void setSubjobs(List<SubJob>  subjobs) {
    this.subjobs = subjobs;
  }

  /**
   * This is the setter method this will set the subjobs
   * Field introduced in 18.1.1.
   * @return subjobs
   */
  public JobEntry addSubjobsItem(SubJob subjobsItem) {
    if (this.subjobs == null) {
      this.subjobs = new ArrayList<SubJob>();
    }
    this.subjobs.add(subjobsItem);
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
  JobEntry objJobEntry = (JobEntry) o;
  return   Objects.equals(this.uuid, objJobEntry.uuid)&&
  Objects.equals(this.expiresAt, objJobEntry.expiresAt)&&
  Objects.equals(this.objKey, objJobEntry.objKey)&&
  Objects.equals(this.subjobs, objJobEntry.subjobs)&&
  Objects.equals(this.tenantRef, objJobEntry.tenantRef)&&
  Objects.equals(this.name, objJobEntry.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class JobEntry {\n");
      sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    objKey: ").append(toIndentedString(objKey)).append("\n");
        sb.append("    subjobs: ").append(toIndentedString(subjobs)).append("\n");
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

