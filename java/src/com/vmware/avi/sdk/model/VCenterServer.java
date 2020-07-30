package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VCenterServer is a POJO class extends AviRestResource that used for creating
 * VCenterServer.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VCenterServer extends AviRestResource  {
    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("content_lib")
    private ContentLibConfig contentLib = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vcenter_credentials_ref")
    private String vcenterCredentialsRef = null;

    @JsonProperty("vcenter_url")
    private String vcenterUrl = null;



  /**
   * This is the getter method this will return the attribute value.
   * Vcenter belongs to cloud.
   * It is a reference to an object of type cloud.
   * Field introduced in 20.1.1.
   * @return cloudRef
   */
  public String getCloudRef() {
    return cloudRef;
  }

  /**
   * This is the setter method to the attribute.
   * Vcenter belongs to cloud.
   * It is a reference to an object of type cloud.
   * Field introduced in 20.1.1.
   * @param cloudRef set the cloudRef.
   */
  public void setCloudRef(String  cloudRef) {
    this.cloudRef = cloudRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vcenter template to create service engine.
   * Field introduced in 20.1.1.
   * @return contentLib
   */
  public ContentLibConfig getContentLib() {
    return contentLib;
  }

  /**
   * This is the setter method to the attribute.
   * Vcenter template to create service engine.
   * Field introduced in 20.1.1.
   * @param contentLib set the contentLib.
   */
  public void setContentLib(ContentLibConfig contentLib) {
    this.contentLib = contentLib;
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
   * Vcenter belongs to tenant.
   * It is a reference to an object of type tenant.
   * Field introduced in 20.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * Vcenter belongs to tenant.
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
   * Vcenter config uuid.
   * Field introduced in 20.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Vcenter config uuid.
   * Field introduced in 20.1.1.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Credentials to access vcenter.
   * It is a reference to an object of type cloudconnectoruser.
   * Field introduced in 20.1.1.
   * @return vcenterCredentialsRef
   */
  public String getVcenterCredentialsRef() {
    return vcenterCredentialsRef;
  }

  /**
   * This is the setter method to the attribute.
   * Credentials to access vcenter.
   * It is a reference to an object of type cloudconnectoruser.
   * Field introduced in 20.1.1.
   * @param vcenterCredentialsRef set the vcenterCredentialsRef.
   */
  public void setVcenterCredentialsRef(String  vcenterCredentialsRef) {
    this.vcenterCredentialsRef = vcenterCredentialsRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vcenter hostname or ip address.
   * Field introduced in 20.1.1.
   * @return vcenterUrl
   */
  public String getVcenterUrl() {
    return vcenterUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Vcenter hostname or ip address.
   * Field introduced in 20.1.1.
   * @param vcenterUrl set the vcenterUrl.
   */
  public void setVcenterUrl(String  vcenterUrl) {
    this.vcenterUrl = vcenterUrl;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VCenterServer objVCenterServer = (VCenterServer) o;
  return   Objects.equals(this.uuid, objVCenterServer.uuid)&&
  Objects.equals(this.name, objVCenterServer.name)&&
  Objects.equals(this.vcenterUrl, objVCenterServer.vcenterUrl)&&
  Objects.equals(this.vcenterCredentialsRef, objVCenterServer.vcenterCredentialsRef)&&
  Objects.equals(this.contentLib, objVCenterServer.contentLib)&&
  Objects.equals(this.tenantRef, objVCenterServer.tenantRef)&&
  Objects.equals(this.cloudRef, objVCenterServer.cloudRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VCenterServer {\n");
      sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    contentLib: ").append(toIndentedString(contentLib)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vcenterCredentialsRef: ").append(toIndentedString(vcenterCredentialsRef)).append("\n");
        sb.append("    vcenterUrl: ").append(toIndentedString(vcenterUrl)).append("\n");
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

