package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SecurityManagerData is a POJO class extends AviRestResource that used for creating
 * SecurityManagerData.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecurityManagerData extends AviRestResource  {
    @JsonProperty("app_learning_info")
    private List<DbAppLearningInfo> appLearningInfo = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;


  /**
   * This is the getter method this will return the attribute value.
   * Information about various applications.
   * Field introduced in 20.1.1.
   * @return appLearningInfo
   */
  public List<DbAppLearningInfo> getAppLearningInfo() {
    return appLearningInfo;
  }

  /**
   * This is the setter method. this will set the appLearningInfo
   * Information about various applications.
   * Field introduced in 20.1.1.
   * @return appLearningInfo
   */
  public void setAppLearningInfo(List<DbAppLearningInfo>  appLearningInfo) {
    this.appLearningInfo = appLearningInfo;
  }

  /**
   * This is the setter method this will set the appLearningInfo
   * Information about various applications.
   * Field introduced in 20.1.1.
   * @return appLearningInfo
   */
  public SecurityManagerData addAppLearningInfoItem(DbAppLearningInfo appLearningInfoItem) {
    if (this.appLearningInfo == null) {
      this.appLearningInfo = new ArrayList<DbAppLearningInfo>();
    }
    this.appLearningInfo.add(appLearningInfoItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtualservice name.
   * Field introduced in 20.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Virtualservice name.
   * Field introduced in 20.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 20.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
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
   * Virtualservice uuid.
   * Field introduced in 20.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Virtualservice uuid.
   * Field introduced in 20.1.1.
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
  SecurityManagerData objSecurityManagerData = (SecurityManagerData) o;
  return   Objects.equals(this.uuid, objSecurityManagerData.uuid)&&
  Objects.equals(this.appLearningInfo, objSecurityManagerData.appLearningInfo)&&
  Objects.equals(this.name, objSecurityManagerData.name)&&
  Objects.equals(this.tenantRef, objSecurityManagerData.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SecurityManagerData {\n");
      sb.append("    appLearningInfo: ").append(toIndentedString(appLearningInfo)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

