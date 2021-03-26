package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The GeoDB is a POJO class extends AviRestResource that used for creating
 * GeoDB.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoDB extends AviRestResource  {
    @JsonProperty("description")
    private String description = null;

    @JsonProperty("files")
    private List<GeoDBFile> files = null;

    @JsonProperty("is_federated")
    private Boolean isFederated = false;

    @JsonProperty("mappings")
    private List<GeoDBMapping> mappings = null;

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
     * Description.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the setter method to the attribute.
     * Description.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param description set the description.
     */
    public void setDescription(String  description) {
        this.description = description;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Geo database files.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return files
     */
    public List<GeoDBFile> getFiles() {
        return files;
    }

    /**
     * This is the setter method. this will set the files
     * Geo database files.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return files
     */
    public void setFiles(List<GeoDBFile>  files) {
        this.files = files;
    }

    /**
     * This is the setter method this will set the files
     * Geo database files.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return files
     */
    public GeoDB addFilesItem(GeoDBFile filesItem) {
      if (this.files == null) {
        this.files = new ArrayList<GeoDBFile>();
      }
      this.files.add(filesItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * This field indicates that this object is replicated across gslb federation.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return isFederated
     */
    public Boolean getIsFederated() {
        return isFederated;
    }

    /**
     * This is the setter method to the attribute.
     * This field indicates that this object is replicated across gslb federation.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param isFederated set the isFederated.
     */
    public void setIsFederated(Boolean  isFederated) {
        this.isFederated = isFederated;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Custom mappings of geo values.
     * All mappings which start with the prefix 'system-' (any case) are reserved for system default objects and may be overwritten.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mappings
     */
    public List<GeoDBMapping> getMappings() {
        return mappings;
    }

    /**
     * This is the setter method. this will set the mappings
     * Custom mappings of geo values.
     * All mappings which start with the prefix 'system-' (any case) are reserved for system default objects and may be overwritten.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mappings
     */
    public void setMappings(List<GeoDBMapping>  mappings) {
        this.mappings = mappings;
    }

    /**
     * This is the setter method this will set the mappings
     * Custom mappings of geo values.
     * All mappings which start with the prefix 'system-' (any case) are reserved for system default objects and may be overwritten.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mappings
     */
    public GeoDB addMappingsItem(GeoDBMapping mappingsItem) {
      if (this.mappings == null) {
        this.mappings = new ArrayList<GeoDBMapping>();
      }
      this.mappings.add(mappingsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Geo database name.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Geo database name.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Tenant that this object belongs to.
     * It is a reference to an object of type tenant.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRef
     */
    public String getTenantRef() {
        return tenantRef;
    }

    /**
     * This is the setter method to the attribute.
     * Tenant that this object belongs to.
     * It is a reference to an object of type tenant.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Uuid of this object.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of this object.
     * Field introduced in 21.1.1.
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
      GeoDB objGeoDB = (GeoDB) o;
      return   Objects.equals(this.uuid, objGeoDB.uuid)&&
  Objects.equals(this.tenantRef, objGeoDB.tenantRef)&&
  Objects.equals(this.name, objGeoDB.name)&&
  Objects.equals(this.description, objGeoDB.description)&&
  Objects.equals(this.isFederated, objGeoDB.isFederated)&&
  Objects.equals(this.files, objGeoDB.files)&&
  Objects.equals(this.mappings, objGeoDB.mappings);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class GeoDB {\n");
                  sb.append("    description: ").append(toIndentedString(description)).append("\n");
                        sb.append("    files: ").append(toIndentedString(files)).append("\n");
                        sb.append("    isFederated: ").append(toIndentedString(isFederated)).append("\n");
                        sb.append("    mappings: ").append(toIndentedString(mappings)).append("\n");
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
