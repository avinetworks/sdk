package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Image is a POJO class extends AviRestResource that used for creating
 * Image.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image extends AviRestResource  {
    @JsonProperty("cloud_info_values")
    private List<ImageCloudData> cloudInfoValues = null;

    @JsonProperty("controller_info")
    private PackageDetails controllerInfo = null;

    @JsonProperty("controller_patch_name")
    private String controllerPatchName = null;

    @JsonProperty("controller_patch_uuid")
    private String controllerPatchUuid = null;

    @JsonProperty("migrations")
    private SupportedMigrations migrations = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("se_info")
    private PackageDetails seInfo = null;

    @JsonProperty("se_patch_name")
    private String sePatchName = null;

    @JsonProperty("se_patch_uuid")
    private String sePatchUuid = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("uber_bundle")
    private Boolean uberBundle = false;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;


  /**
   * This is the getter method this will return the attribute value.
   * This field describes the cloud info specific to the base image.
   * Field introduced in 20.1.1.
   * @return cloudInfoValues
   */
  public List<ImageCloudData> getCloudInfoValues() {
    return cloudInfoValues;
  }

  /**
   * This is the setter method. this will set the cloudInfoValues
   * This field describes the cloud info specific to the base image.
   * Field introduced in 20.1.1.
   * @return cloudInfoValues
   */
  public void setCloudInfoValues(List<ImageCloudData>  cloudInfoValues) {
    this.cloudInfoValues = cloudInfoValues;
  }

  /**
   * This is the setter method this will set the cloudInfoValues
   * This field describes the cloud info specific to the base image.
   * Field introduced in 20.1.1.
   * @return cloudInfoValues
   */
  public Image addCloudInfoValuesItem(ImageCloudData cloudInfoValuesItem) {
    if (this.cloudInfoValues == null) {
      this.cloudInfoValues = new ArrayList<ImageCloudData>();
    }
    this.cloudInfoValues.add(cloudInfoValuesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Controller package details.
   * Field introduced in 18.2.6.
   * @return controllerInfo
   */
  public PackageDetails getControllerInfo() {
    return controllerInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Controller package details.
   * Field introduced in 18.2.6.
   * @param controllerInfo set the controllerInfo.
   */
  public void setControllerInfo(PackageDetails controllerInfo) {
    this.controllerInfo = controllerInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mandatory controller patch name that is applied along with this base image.
   * Field introduced in 18.2.10.
   * @return controllerPatchName
   */
  public String getControllerPatchName() {
    return controllerPatchName;
  }

  /**
   * This is the setter method to the attribute.
   * Mandatory controller patch name that is applied along with this base image.
   * Field introduced in 18.2.10.
   * @param controllerPatchName set the controllerPatchName.
   */
  public void setControllerPatchName(String  controllerPatchName) {
    this.controllerPatchName = controllerPatchName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It references the controller-patch associated with the uber image.
   * Field introduced in 18.2.8, 20.1.1.
   * @return controllerPatchUuid
   */
  public String getControllerPatchUuid() {
    return controllerPatchUuid;
  }

  /**
   * This is the setter method to the attribute.
   * It references the controller-patch associated with the uber image.
   * Field introduced in 18.2.8, 20.1.1.
   * @param controllerPatchUuid set the controllerPatchUuid.
   */
  public void setControllerPatchUuid(String  controllerPatchUuid) {
    this.controllerPatchUuid = controllerPatchUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field describes the api migration related information.
   * Field introduced in 18.2.6.
   * @return migrations
   */
  public SupportedMigrations getMigrations() {
    return migrations;
  }

  /**
   * This is the setter method to the attribute.
   * This field describes the api migration related information.
   * Field introduced in 18.2.6.
   * @param migrations set the migrations.
   */
  public void setMigrations(SupportedMigrations migrations) {
    this.migrations = migrations;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the image.
   * Field introduced in 18.2.6.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the image.
   * Field introduced in 18.2.6.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Se package details.
   * Field introduced in 18.2.6.
   * @return seInfo
   */
  public PackageDetails getSeInfo() {
    return seInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Se package details.
   * Field introduced in 18.2.6.
   * @param seInfo set the seInfo.
   */
  public void setSeInfo(PackageDetails seInfo) {
    this.seInfo = seInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mandatory serviceengine patch name that is applied along with this base image.
   * Field introduced in 18.2.10.
   * @return sePatchName
   */
  public String getSePatchName() {
    return sePatchName;
  }

  /**
   * This is the setter method to the attribute.
   * Mandatory serviceengine patch name that is applied along with this base image.
   * Field introduced in 18.2.10.
   * @param sePatchName set the sePatchName.
   */
  public void setSePatchName(String  sePatchName) {
    this.sePatchName = sePatchName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It references the service engine patch associated with the uber image.
   * Field introduced in 18.2.8, 20.1.1.
   * @return sePatchUuid
   */
  public String getSePatchUuid() {
    return sePatchUuid;
  }

  /**
   * This is the setter method to the attribute.
   * It references the service engine patch associated with the uber image.
   * Field introduced in 18.2.8, 20.1.1.
   * @param sePatchUuid set the sePatchUuid.
   */
  public void setSePatchUuid(String  sePatchUuid) {
    this.sePatchUuid = sePatchUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Status to check if the image is present.
   * Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO,
   * SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN,
   * SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_BAD_REQUEST, SYSERR_TEST1...
   * Field introduced in 18.2.6.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Status to check if the image is present.
   * Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO,
   * SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN,
   * SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_BAD_REQUEST, SYSERR_TEST1...
   * Field introduced in 18.2.6.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.6.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.6.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Type of the image patch/system.
   * Enum options - IMAGE_TYPE_PATCH, IMAGE_TYPE_SYSTEM.
   * Field introduced in 18.2.6.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Type of the image patch/system.
   * Enum options - IMAGE_TYPE_PATCH, IMAGE_TYPE_SYSTEM.
   * Field introduced in 18.2.6.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Status to check if the image is an uber bundle.
   * Field introduced in 18.2.8, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return uberBundle
   */
  public Boolean getUberBundle() {
    return uberBundle;
  }

  /**
   * This is the setter method to the attribute.
   * Status to check if the image is an uber bundle.
   * Field introduced in 18.2.8, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param uberBundle set the uberBundle.
   */
  public void setUberBundle(Boolean  uberBundle) {
    this.uberBundle = uberBundle;
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
   * Uuid of the image.
   * Field introduced in 18.2.6.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the image.
   * Field introduced in 18.2.6.
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
  Image objImage = (Image) o;
  return   Objects.equals(this.status, objImage.status)&&
  Objects.equals(this.seInfo, objImage.seInfo)&&
  Objects.equals(this.uuid, objImage.uuid)&&
  Objects.equals(this.controllerPatchName, objImage.controllerPatchName)&&
  Objects.equals(this.controllerPatchUuid, objImage.controllerPatchUuid)&&
  Objects.equals(this.migrations, objImage.migrations)&&
  Objects.equals(this.cloudInfoValues, objImage.cloudInfoValues)&&
  Objects.equals(this.uberBundle, objImage.uberBundle)&&
  Objects.equals(this.controllerInfo, objImage.controllerInfo)&&
  Objects.equals(this.sePatchName, objImage.sePatchName)&&
  Objects.equals(this.sePatchUuid, objImage.sePatchUuid)&&
  Objects.equals(this.type, objImage.type)&&
  Objects.equals(this.tenantRef, objImage.tenantRef)&&
  Objects.equals(this.name, objImage.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Image {\n");
      sb.append("    cloudInfoValues: ").append(toIndentedString(cloudInfoValues)).append("\n");
        sb.append("    controllerInfo: ").append(toIndentedString(controllerInfo)).append("\n");
        sb.append("    controllerPatchName: ").append(toIndentedString(controllerPatchName)).append("\n");
        sb.append("    controllerPatchUuid: ").append(toIndentedString(controllerPatchUuid)).append("\n");
        sb.append("    migrations: ").append(toIndentedString(migrations)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    seInfo: ").append(toIndentedString(seInfo)).append("\n");
        sb.append("    sePatchName: ").append(toIndentedString(sePatchName)).append("\n");
        sb.append("    sePatchUuid: ").append(toIndentedString(sePatchUuid)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    uberBundle: ").append(toIndentedString(uberBundle)).append("\n");
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

