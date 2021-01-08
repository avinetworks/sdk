package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The SupportedMigrations is a POJO class extends AviRestResource that used for creating
 * SupportedMigrations.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupportedMigrations  {
    @JsonProperty("api_version")
    private String apiVersion = null;

    @JsonProperty("controller_host_min_free_disk_size")
    private Integer controllerHostMinFreeDiskSize = 10;

    @JsonProperty("controller_min_cores")
    private Integer controllerMinCores = 8;

    @JsonProperty("controller_min_free_disk_size")
    private Integer controllerMinFreeDiskSize = 10;

    @JsonProperty("controller_min_memory")
    private Integer controllerMinMemory = 24;

    @JsonProperty("controller_min_total_disk")
    private Integer controllerMinTotalDisk = 128;

    @JsonProperty("max_active_versions")
    private Integer maxActiveVersions = 2;

    @JsonProperty("rollback_controller_disk_space")
    private Integer rollbackControllerDiskSpace = 2;

    @JsonProperty("rollback_se_disk_space")
    private Integer rollbackSeDiskSpace = 1;

    @JsonProperty("se_host_min_free_disk_size")
    private Integer seHostMinFreeDiskSize = 5;

    @JsonProperty("se_min_cores")
    private Integer seMinCores = 2;

    @JsonProperty("se_min_free_disk_size")
    private Integer seMinFreeDiskSize = 5;

    @JsonProperty("se_min_memory")
    private Integer seMinMemory = 2;

    @JsonProperty("se_min_total_disk")
    private Integer seMinTotalDisk = 10;

    @JsonProperty("versions")
    private List<String> versions = null;



    /**
     * This is the getter method this will return the attribute value.
     * Api version of the image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return apiVersion
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * This is the setter method to the attribute.
     * Api version of the image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param apiVersion set the apiVersion.
     */
    public void setApiVersion(String  apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum space required(in gb) on controller host for this image installation.
     * Field introduced in 18.2.6.
     * Unit is gb.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10.
     * @return controllerHostMinFreeDiskSize
     */
    public Integer getControllerHostMinFreeDiskSize() {
        return controllerHostMinFreeDiskSize;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum space required(in gb) on controller host for this image installation.
     * Field introduced in 18.2.6.
     * Unit is gb.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10.
     * @param controllerHostMinFreeDiskSize set the controllerHostMinFreeDiskSize.
     */
    public void setControllerHostMinFreeDiskSize(Integer  controllerHostMinFreeDiskSize) {
        this.controllerHostMinFreeDiskSize = controllerHostMinFreeDiskSize;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum number of cores required for controller.
     * Field introduced in 18.2.10, 20.1.2.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as 8.
     * @return controllerMinCores
     */
    public Integer getControllerMinCores() {
        return controllerMinCores;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum number of cores required for controller.
     * Field introduced in 18.2.10, 20.1.2.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as 8.
     * @param controllerMinCores set the controllerMinCores.
     */
    public void setControllerMinCores(Integer  controllerMinCores) {
        this.controllerMinCores = controllerMinCores;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum space required(in gb) on controller for this image installation.
     * Field introduced in 18.2.6.
     * Unit is gb.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10.
     * @return controllerMinFreeDiskSize
     */
    public Integer getControllerMinFreeDiskSize() {
        return controllerMinFreeDiskSize;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum space required(in gb) on controller for this image installation.
     * Field introduced in 18.2.6.
     * Unit is gb.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10.
     * @param controllerMinFreeDiskSize set the controllerMinFreeDiskSize.
     */
    public void setControllerMinFreeDiskSize(Integer  controllerMinFreeDiskSize) {
        this.controllerMinFreeDiskSize = controllerMinFreeDiskSize;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum memory required(in gb) for controller.
     * Field introduced in 18.2.10, 20.1.2.
     * Unit is gb.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as 24.
     * @return controllerMinMemory
     */
    public Integer getControllerMinMemory() {
        return controllerMinMemory;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum memory required(in gb) for controller.
     * Field introduced in 18.2.10, 20.1.2.
     * Unit is gb.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as 24.
     * @param controllerMinMemory set the controllerMinMemory.
     */
    public void setControllerMinMemory(Integer  controllerMinMemory) {
        this.controllerMinMemory = controllerMinMemory;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum space required(in gb) for controller.
     * Field introduced in 18.2.10, 20.1.2.
     * Unit is gb.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as 128.
     * @return controllerMinTotalDisk
     */
    public Integer getControllerMinTotalDisk() {
        return controllerMinTotalDisk;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum space required(in gb) for controller.
     * Field introduced in 18.2.10, 20.1.2.
     * Unit is gb.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as 128.
     * @param controllerMinTotalDisk set the controllerMinTotalDisk.
     */
    public void setControllerMinTotalDisk(Integer  controllerMinTotalDisk) {
        this.controllerMinTotalDisk = controllerMinTotalDisk;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Supported active versions for this image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as 2.
     * @return maxActiveVersions
     */
    public Integer getMaxActiveVersions() {
        return maxActiveVersions;
    }

    /**
     * This is the setter method to the attribute.
     * Supported active versions for this image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as 2.
     * @param maxActiveVersions set the maxActiveVersions.
     */
    public void setMaxActiveVersions(Integer  maxActiveVersions) {
        this.maxActiveVersions = maxActiveVersions;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum space required(in gb) on controller for rollback.
     * Field introduced in 18.2.6.
     * Unit is gb.
     * Default value when not specified in API or module is interpreted by Avi Controller as 2.
     * @return rollbackControllerDiskSpace
     */
    public Integer getRollbackControllerDiskSpace() {
        return rollbackControllerDiskSpace;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum space required(in gb) on controller for rollback.
     * Field introduced in 18.2.6.
     * Unit is gb.
     * Default value when not specified in API or module is interpreted by Avi Controller as 2.
     * @param rollbackControllerDiskSpace set the rollbackControllerDiskSpace.
     */
    public void setRollbackControllerDiskSpace(Integer  rollbackControllerDiskSpace) {
        this.rollbackControllerDiskSpace = rollbackControllerDiskSpace;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum space required(in gb) on se for rollback.
     * Field introduced in 18.2.6.
     * Unit is gb.
     * Default value when not specified in API or module is interpreted by Avi Controller as 1.
     * @return rollbackSeDiskSpace
     */
    public Integer getRollbackSeDiskSpace() {
        return rollbackSeDiskSpace;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum space required(in gb) on se for rollback.
     * Field introduced in 18.2.6.
     * Unit is gb.
     * Default value when not specified in API or module is interpreted by Avi Controller as 1.
     * @param rollbackSeDiskSpace set the rollbackSeDiskSpace.
     */
    public void setRollbackSeDiskSpace(Integer  rollbackSeDiskSpace) {
        this.rollbackSeDiskSpace = rollbackSeDiskSpace;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum space required(in gb) on se host for this image installation.
     * Field introduced in 18.2.6.
     * Unit is gb.
     * Default value when not specified in API or module is interpreted by Avi Controller as 5.
     * @return seHostMinFreeDiskSize
     */
    public Integer getSeHostMinFreeDiskSize() {
        return seHostMinFreeDiskSize;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum space required(in gb) on se host for this image installation.
     * Field introduced in 18.2.6.
     * Unit is gb.
     * Default value when not specified in API or module is interpreted by Avi Controller as 5.
     * @param seHostMinFreeDiskSize set the seHostMinFreeDiskSize.
     */
    public void setSeHostMinFreeDiskSize(Integer  seHostMinFreeDiskSize) {
        this.seHostMinFreeDiskSize = seHostMinFreeDiskSize;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum  number of cores required for se.
     * Field introduced in 18.2.10, 20.1.2.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as 2.
     * @return seMinCores
     */
    public Integer getSeMinCores() {
        return seMinCores;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum  number of cores required for se.
     * Field introduced in 18.2.10, 20.1.2.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as 2.
     * @param seMinCores set the seMinCores.
     */
    public void setSeMinCores(Integer  seMinCores) {
        this.seMinCores = seMinCores;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum space required(in gb) on se for this image installation.
     * Field introduced in 18.2.6.
     * Unit is gb.
     * Default value when not specified in API or module is interpreted by Avi Controller as 5.
     * @return seMinFreeDiskSize
     */
    public Integer getSeMinFreeDiskSize() {
        return seMinFreeDiskSize;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum space required(in gb) on se for this image installation.
     * Field introduced in 18.2.6.
     * Unit is gb.
     * Default value when not specified in API or module is interpreted by Avi Controller as 5.
     * @param seMinFreeDiskSize set the seMinFreeDiskSize.
     */
    public void setSeMinFreeDiskSize(Integer  seMinFreeDiskSize) {
        this.seMinFreeDiskSize = seMinFreeDiskSize;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum  memory required(in gb) for se.
     * Field introduced in 18.2.10, 20.1.2.
     * Unit is gb.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as 2.
     * @return seMinMemory
     */
    public Integer getSeMinMemory() {
        return seMinMemory;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum  memory required(in gb) for se.
     * Field introduced in 18.2.10, 20.1.2.
     * Unit is gb.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as 2.
     * @param seMinMemory set the seMinMemory.
     */
    public void setSeMinMemory(Integer  seMinMemory) {
        this.seMinMemory = seMinMemory;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Minimum space required(in gb) for se.
     * Field introduced in 18.2.10, 20.1.2.
     * Unit is gb.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10.
     * @return seMinTotalDisk
     */
    public Integer getSeMinTotalDisk() {
        return seMinTotalDisk;
    }

    /**
     * This is the setter method to the attribute.
     * Minimum space required(in gb) for se.
     * Field introduced in 18.2.10, 20.1.2.
     * Unit is gb.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10.
     * @param seMinTotalDisk set the seMinTotalDisk.
     */
    public void setSeMinTotalDisk(Integer  seMinTotalDisk) {
        this.seMinTotalDisk = seMinTotalDisk;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Supported compatible versions for this image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return versions
     */
    public List<String> getVersions() {
        return versions;
    }

    /**
     * This is the setter method. this will set the versions
     * Supported compatible versions for this image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return versions
     */
    public void setVersions(List<String>  versions) {
        this.versions = versions;
    }

    /**
     * This is the setter method this will set the versions
     * Supported compatible versions for this image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return versions
     */
    public SupportedMigrations addVersionsItem(String versionsItem) {
      if (this.versions == null) {
        this.versions = new ArrayList<String>();
      }
      this.versions.add(versionsItem);
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
      SupportedMigrations objSupportedMigrations = (SupportedMigrations) o;
      return   Objects.equals(this.apiVersion, objSupportedMigrations.apiVersion)&&
  Objects.equals(this.versions, objSupportedMigrations.versions)&&
  Objects.equals(this.maxActiveVersions, objSupportedMigrations.maxActiveVersions)&&
  Objects.equals(this.controllerMinFreeDiskSize, objSupportedMigrations.controllerMinFreeDiskSize)&&
  Objects.equals(this.seMinFreeDiskSize, objSupportedMigrations.seMinFreeDiskSize)&&
  Objects.equals(this.controllerHostMinFreeDiskSize, objSupportedMigrations.controllerHostMinFreeDiskSize)&&
  Objects.equals(this.seHostMinFreeDiskSize, objSupportedMigrations.seHostMinFreeDiskSize)&&
  Objects.equals(this.rollbackControllerDiskSpace, objSupportedMigrations.rollbackControllerDiskSpace)&&
  Objects.equals(this.rollbackSeDiskSpace, objSupportedMigrations.rollbackSeDiskSpace)&&
  Objects.equals(this.seMinTotalDisk, objSupportedMigrations.seMinTotalDisk)&&
  Objects.equals(this.seMinMemory, objSupportedMigrations.seMinMemory)&&
  Objects.equals(this.seMinCores, objSupportedMigrations.seMinCores)&&
  Objects.equals(this.controllerMinTotalDisk, objSupportedMigrations.controllerMinTotalDisk)&&
  Objects.equals(this.controllerMinMemory, objSupportedMigrations.controllerMinMemory)&&
  Objects.equals(this.controllerMinCores, objSupportedMigrations.controllerMinCores);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SupportedMigrations {\n");
                  sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
                        sb.append("    controllerHostMinFreeDiskSize: ").append(toIndentedString(controllerHostMinFreeDiskSize)).append("\n");
                        sb.append("    controllerMinCores: ").append(toIndentedString(controllerMinCores)).append("\n");
                        sb.append("    controllerMinFreeDiskSize: ").append(toIndentedString(controllerMinFreeDiskSize)).append("\n");
                        sb.append("    controllerMinMemory: ").append(toIndentedString(controllerMinMemory)).append("\n");
                        sb.append("    controllerMinTotalDisk: ").append(toIndentedString(controllerMinTotalDisk)).append("\n");
                        sb.append("    maxActiveVersions: ").append(toIndentedString(maxActiveVersions)).append("\n");
                        sb.append("    rollbackControllerDiskSpace: ").append(toIndentedString(rollbackControllerDiskSpace)).append("\n");
                        sb.append("    rollbackSeDiskSpace: ").append(toIndentedString(rollbackSeDiskSpace)).append("\n");
                        sb.append("    seHostMinFreeDiskSize: ").append(toIndentedString(seHostMinFreeDiskSize)).append("\n");
                        sb.append("    seMinCores: ").append(toIndentedString(seMinCores)).append("\n");
                        sb.append("    seMinFreeDiskSize: ").append(toIndentedString(seMinFreeDiskSize)).append("\n");
                        sb.append("    seMinMemory: ").append(toIndentedString(seMinMemory)).append("\n");
                        sb.append("    seMinTotalDisk: ").append(toIndentedString(seMinTotalDisk)).append("\n");
                        sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
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
