package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The GCPEncryptionKeys is a POJO class extends AviRestResource that used for creating
 * GCPEncryptionKeys.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GCPEncryptionKeys  {
    @JsonProperty("gcs_bucket_kms_key_id")
    private String gcsBucketKmsKeyId = null;

    @JsonProperty("gcs_objects_kms_key_id")
    private String gcsObjectsKmsKeyId = null;

    @JsonProperty("se_disk_kms_key_id")
    private String seDiskKmsKeyId = null;

    @JsonProperty("se_image_kms_key_id")
    private String seImageKmsKeyId = null;



    /**
     * This is the getter method this will return the attribute value.
     * Cmek resource id to encrypt google cloud storage bucket.
     * This bucket is used to upload service engine raw image.
     * Field introduced in 18.2.10, 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return gcsBucketKmsKeyId
     */
    public String getGcsBucketKmsKeyId() {
        return gcsBucketKmsKeyId;
    }

    /**
     * This is the setter method to the attribute.
     * Cmek resource id to encrypt google cloud storage bucket.
     * This bucket is used to upload service engine raw image.
     * Field introduced in 18.2.10, 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param gcsBucketKmsKeyId set the gcsBucketKmsKeyId.
     */
    public void setGcsBucketKmsKeyId(String  gcsBucketKmsKeyId) {
        this.gcsBucketKmsKeyId = gcsBucketKmsKeyId;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Cmek resource id to encrypt service engine raw image.
     * The raw image is a google cloud storage object.
     * Field introduced in 18.2.10, 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return gcsObjectsKmsKeyId
     */
    public String getGcsObjectsKmsKeyId() {
        return gcsObjectsKmsKeyId;
    }

    /**
     * This is the setter method to the attribute.
     * Cmek resource id to encrypt service engine raw image.
     * The raw image is a google cloud storage object.
     * Field introduced in 18.2.10, 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param gcsObjectsKmsKeyId set the gcsObjectsKmsKeyId.
     */
    public void setGcsObjectsKmsKeyId(String  gcsObjectsKmsKeyId) {
        this.gcsObjectsKmsKeyId = gcsObjectsKmsKeyId;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Cmek resource id to encrypt service engine disks.
     * Field introduced in 18.2.10, 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seDiskKmsKeyId
     */
    public String getSeDiskKmsKeyId() {
        return seDiskKmsKeyId;
    }

    /**
     * This is the setter method to the attribute.
     * Cmek resource id to encrypt service engine disks.
     * Field introduced in 18.2.10, 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seDiskKmsKeyId set the seDiskKmsKeyId.
     */
    public void setSeDiskKmsKeyId(String  seDiskKmsKeyId) {
        this.seDiskKmsKeyId = seDiskKmsKeyId;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Cmek resource id to encrypt service engine gce image.
     * Field introduced in 18.2.10, 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seImageKmsKeyId
     */
    public String getSeImageKmsKeyId() {
        return seImageKmsKeyId;
    }

    /**
     * This is the setter method to the attribute.
     * Cmek resource id to encrypt service engine gce image.
     * Field introduced in 18.2.10, 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seImageKmsKeyId set the seImageKmsKeyId.
     */
    public void setSeImageKmsKeyId(String  seImageKmsKeyId) {
        this.seImageKmsKeyId = seImageKmsKeyId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      GCPEncryptionKeys objGCPEncryptionKeys = (GCPEncryptionKeys) o;
      return   Objects.equals(this.seImageKmsKeyId, objGCPEncryptionKeys.seImageKmsKeyId)&&
  Objects.equals(this.seDiskKmsKeyId, objGCPEncryptionKeys.seDiskKmsKeyId)&&
  Objects.equals(this.gcsBucketKmsKeyId, objGCPEncryptionKeys.gcsBucketKmsKeyId)&&
  Objects.equals(this.gcsObjectsKmsKeyId, objGCPEncryptionKeys.gcsObjectsKmsKeyId);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class GCPEncryptionKeys {\n");
                  sb.append("    gcsBucketKmsKeyId: ").append(toIndentedString(gcsBucketKmsKeyId)).append("\n");
                        sb.append("    gcsObjectsKmsKeyId: ").append(toIndentedString(gcsObjectsKmsKeyId)).append("\n");
                        sb.append("    seDiskKmsKeyId: ").append(toIndentedString(seDiskKmsKeyId)).append("\n");
                        sb.append("    seImageKmsKeyId: ").append(toIndentedString(seImageKmsKeyId)).append("\n");
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
