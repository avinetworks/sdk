package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AutoScaleLaunchConfig is a POJO class extends AviRestResource that used for creating
 * AutoScaleLaunchConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoScaleLaunchConfig extends AviRestResource  {
    @JsonProperty("description")
    private String description = null;

    @JsonProperty("image_id")
    private String imageId = null;

    @JsonProperty("mesos")
    private AutoScaleMesosSettings mesos = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("openstack")
    private AutoScaleOpenStackSettings openstack = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("use_external_asg")
    private Boolean useExternalAsg = true;

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * User defined description for the object.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * User defined description for the object.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique id of the amazon machine image (ami)  or openstack vm id.
   * @return imageId
   */
  public String getImageId() {
    return imageId;
  }

  /**
   * This is the setter method to the attribute.
   * Unique id of the amazon machine image (ami)  or openstack vm id.
   * @param imageId set the imageId.
   */
  public void setImageId(String  imageId) {
    this.imageId = imageId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mesos of obj type autoscalelaunchconfig field type str  type ref.
   * @return mesos
   */
  public AutoScaleMesosSettings getMesos() {
    return mesos;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mesos of obj type autoscalelaunchconfig field type str  type ref.
   * @param mesos set the mesos.
   */
  public void setMesos(AutoScaleMesosSettings mesos) {
    this.mesos = mesos;
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
   * Placeholder for description of property openstack of obj type autoscalelaunchconfig field type str  type ref.
   * @return openstack
   */
  public AutoScaleOpenStackSettings getOpenstack() {
    return openstack;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property openstack of obj type autoscalelaunchconfig field type str  type ref.
   * @param openstack set the openstack.
   */
  public void setOpenstack(AutoScaleOpenStackSettings openstack) {
    this.openstack = openstack;
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
   * If set to true, serverautoscalepolicy will use the autoscaling group (external_autoscaling_groups) from pool to perform scale up and scale down.
   * Pool should have single autoscaling group configured.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return useExternalAsg
   */
  public Boolean getUseExternalAsg() {
    return useExternalAsg;
  }

  /**
   * This is the setter method to the attribute.
   * If set to true, serverautoscalepolicy will use the autoscaling group (external_autoscaling_groups) from pool to perform scale up and scale down.
   * Pool should have single autoscaling group configured.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param useExternalAsg set the useExternalAsg.
   */
  public void setUseExternalAsg(Boolean  useExternalAsg) {
    this.useExternalAsg = useExternalAsg;
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
  AutoScaleLaunchConfig objAutoScaleLaunchConfig = (AutoScaleLaunchConfig) o;
  return   Objects.equals(this.uuid, objAutoScaleLaunchConfig.uuid)&&
  Objects.equals(this.name, objAutoScaleLaunchConfig.name)&&
  Objects.equals(this.imageId, objAutoScaleLaunchConfig.imageId)&&
  Objects.equals(this.openstack, objAutoScaleLaunchConfig.openstack)&&
  Objects.equals(this.mesos, objAutoScaleLaunchConfig.mesos)&&
  Objects.equals(this.description, objAutoScaleLaunchConfig.description)&&
  Objects.equals(this.tenantRef, objAutoScaleLaunchConfig.tenantRef)&&
  Objects.equals(this.useExternalAsg, objAutoScaleLaunchConfig.useExternalAsg);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AutoScaleLaunchConfig {\n");
      sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
        sb.append("    mesos: ").append(toIndentedString(mesos)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    openstack: ").append(toIndentedString(openstack)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
            sb.append("    useExternalAsg: ").append(toIndentedString(useExternalAsg)).append("\n");
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

