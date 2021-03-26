package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The GeoDBFile is a POJO class extends AviRestResource that used for creating
 * GeoDBFile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoDBFile  {
    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("file_ref")
    private String fileRef = null;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("vendor")
    private String vendor = null;



    /**
     * This is the getter method this will return the attribute value.
     * If set to false, this file is ignored.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * This is the setter method to the attribute.
     * If set to false, this file is ignored.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as true.
     * @param enabled set the enabled.
     */
    public void setEnabled(Boolean  enabled) {
        this.enabled = enabled;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The file object that contains the geo data.
     * Must be of type 'geodb'.
     * It is a reference to an object of type fileobject.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return fileRef
     */
    public String getFileRef() {
        return fileRef;
    }

    /**
     * This is the setter method to the attribute.
     * The file object that contains the geo data.
     * Must be of type 'geodb'.
     * It is a reference to an object of type fileobject.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param fileRef set the fileRef.
     */
    public void setFileRef(String  fileRef) {
        this.fileRef = fileRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Priority of the file - larger number takes precedence.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * This is the setter method to the attribute.
     * Priority of the file - larger number takes precedence.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param index set the index.
     */
    public void setIndex(Integer  index) {
        this.index = index;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the file.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the file.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Source of the file data.
     * Enum options - VENDOR_USER_DEFINED, VENDOR_AVI_DEFINED.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return vendor
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * This is the setter method to the attribute.
     * Source of the file data.
     * Enum options - VENDOR_USER_DEFINED, VENDOR_AVI_DEFINED.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param vendor set the vendor.
     */
    public void setVendor(String  vendor) {
        this.vendor = vendor;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      GeoDBFile objGeoDBFile = (GeoDBFile) o;
      return   Objects.equals(this.index, objGeoDBFile.index)&&
  Objects.equals(this.name, objGeoDBFile.name)&&
  Objects.equals(this.enabled, objGeoDBFile.enabled)&&
  Objects.equals(this.vendor, objGeoDBFile.vendor)&&
  Objects.equals(this.fileRef, objGeoDBFile.fileRef);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class GeoDBFile {\n");
                  sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
                        sb.append("    fileRef: ").append(toIndentedString(fileRef)).append("\n");
                        sb.append("    index: ").append(toIndentedString(index)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
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
