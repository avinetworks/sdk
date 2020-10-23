package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The VIMgrClusterRuntime is a POJO class extends AviRestResource that used for creating
 * VIMgrClusterRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIMgrClusterRuntime extends AviRestResource  {
    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("datacenter_managed_object_id")
    private String datacenterManagedObjectId = null;

    @JsonProperty("datacenter_uuid")
    private String datacenterUuid = null;

    @JsonProperty("host_refs")
    private List<String> hostRefs = null;

    @JsonProperty("managed_object_id")
    private String managedObjectId = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type cloud.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cloudRef
     */
    public String getCloudRef() {
        return cloudRef;
    }

    /**
     * This is the setter method to the attribute.
     * It is a reference to an object of type cloud.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param cloudRef set the cloudRef.
     */
    public void setCloudRef(String  cloudRef) {
        this.cloudRef = cloudRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property datacenter_managed_object_id of obj type vimgrclusterruntime field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return datacenterManagedObjectId
     */
    public String getDatacenterManagedObjectId() {
        return datacenterManagedObjectId;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property datacenter_managed_object_id of obj type vimgrclusterruntime field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param datacenterManagedObjectId set the datacenterManagedObjectId.
     */
    public void setDatacenterManagedObjectId(String  datacenterManagedObjectId) {
        this.datacenterManagedObjectId = datacenterManagedObjectId;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Unique object identifier of datacenter.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return datacenterUuid
     */
    public String getDatacenterUuid() {
        return datacenterUuid;
    }

    /**
     * This is the setter method to the attribute.
     * Unique object identifier of datacenter.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param datacenterUuid set the datacenterUuid.
     */
    public void setDatacenterUuid(String  datacenterUuid) {
        this.datacenterUuid = datacenterUuid;
    }
    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type vimgrhostruntime.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return hostRefs
     */
    public List<String> getHostRefs() {
        return hostRefs;
    }

    /**
     * This is the setter method. this will set the hostRefs
     * It is a reference to an object of type vimgrhostruntime.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return hostRefs
     */
    public void setHostRefs(List<String>  hostRefs) {
        this.hostRefs = hostRefs;
    }

    /**
     * This is the setter method this will set the hostRefs
     * It is a reference to an object of type vimgrhostruntime.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return hostRefs
     */
    public VIMgrClusterRuntime addHostRefsItem(String hostRefsItem) {
      if (this.hostRefs == null) {
        this.hostRefs = new ArrayList<String>();
      }
      this.hostRefs.add(hostRefsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property managed_object_id of obj type vimgrclusterruntime field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return managedObjectId
     */
    public String getManagedObjectId() {
        return managedObjectId;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property managed_object_id of obj type vimgrclusterruntime field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param managedObjectId set the managedObjectId.
     */
    public void setManagedObjectId(String  managedObjectId) {
        this.managedObjectId = managedObjectId;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRef
     */
    public String getTenantRef() {
        return tenantRef;
    }

    /**
     * This is the setter method to the attribute.
     * It is a reference to an object of type tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param tenantRef set the tenantRef.
     */
    public void setTenantRef(String  tenantRef) {
        this.tenantRef = tenantRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
     * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * This is the setter method to the attribute.
     * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
     * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param type set the type.
     */
    public void setType(String  type) {
        this.type = type;
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Unique object identifier of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
      VIMgrClusterRuntime objVIMgrClusterRuntime = (VIMgrClusterRuntime) o;
      return   Objects.equals(this.type, objVIMgrClusterRuntime.type)&&
  Objects.equals(this.uuid, objVIMgrClusterRuntime.uuid)&&
  Objects.equals(this.name, objVIMgrClusterRuntime.name)&&
  Objects.equals(this.managedObjectId, objVIMgrClusterRuntime.managedObjectId)&&
  Objects.equals(this.datacenterManagedObjectId, objVIMgrClusterRuntime.datacenterManagedObjectId)&&
  Objects.equals(this.datacenterUuid, objVIMgrClusterRuntime.datacenterUuid)&&
  Objects.equals(this.hostRefs, objVIMgrClusterRuntime.hostRefs)&&
  Objects.equals(this.tenantRef, objVIMgrClusterRuntime.tenantRef)&&
  Objects.equals(this.cloudRef, objVIMgrClusterRuntime.cloudRef);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VIMgrClusterRuntime {\n");
                  sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
                        sb.append("    datacenterManagedObjectId: ").append(toIndentedString(datacenterManagedObjectId)).append("\n");
                        sb.append("    datacenterUuid: ").append(toIndentedString(datacenterUuid)).append("\n");
                        sb.append("    hostRefs: ").append(toIndentedString(hostRefs)).append("\n");
                        sb.append("    managedObjectId: ").append(toIndentedString(managedObjectId)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
                        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
