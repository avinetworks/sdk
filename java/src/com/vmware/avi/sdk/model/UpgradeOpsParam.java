package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The UpgradeOpsParam is a POJO class extends AviRestResource that used for creating
 * UpgradeOpsParam.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpgradeOpsParam  {
    @JsonProperty("image_ref")
    private String imageRef = null;

    @JsonProperty("patch_ref")
    private String patchRef = null;

    @JsonProperty("se_group_options")
    private SeGroupOptions seGroupOptions = null;

    @JsonProperty("se_group_resume_options")
    private SeGroupResumeOptions seGroupResumeOptions = null;



    /**
     * This is the getter method this will return the attribute value.
     * Image uuid for identifying base image.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return imageRef
     */
    public String getImageRef() {
        return imageRef;
    }

    /**
     * This is the setter method to the attribute.
     * Image uuid for identifying base image.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param imageRef set the imageRef.
     */
    public void setImageRef(String  imageRef) {
        this.imageRef = imageRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Image uuid for identifying patch.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return patchRef
     */
    public String getPatchRef() {
        return patchRef;
    }

    /**
     * This is the setter method to the attribute.
     * Image uuid for identifying patch.
     * It is a reference to an object of type image.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param patchRef set the patchRef.
     */
    public void setPatchRef(String  patchRef) {
        this.patchRef = patchRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * This field identifies se group options that need to be applied during the upgrade operations.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seGroupOptions
     */
    public SeGroupOptions getSeGroupOptions() {
        return seGroupOptions;
    }

    /**
     * This is the setter method to the attribute.
     * This field identifies se group options that need to be applied during the upgrade operations.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seGroupOptions set the seGroupOptions.
     */
    public void setSeGroupOptions(SeGroupOptions seGroupOptions) {
        this.seGroupOptions = seGroupOptions;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Apply options while resuming se group upgrade operations.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seGroupResumeOptions
     */
    public SeGroupResumeOptions getSeGroupResumeOptions() {
        return seGroupResumeOptions;
    }

    /**
     * This is the setter method to the attribute.
     * Apply options while resuming se group upgrade operations.
     * Field introduced in 18.2.6.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seGroupResumeOptions set the seGroupResumeOptions.
     */
    public void setSeGroupResumeOptions(SeGroupResumeOptions seGroupResumeOptions) {
        this.seGroupResumeOptions = seGroupResumeOptions;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      UpgradeOpsParam objUpgradeOpsParam = (UpgradeOpsParam) o;
      return   Objects.equals(this.imageRef, objUpgradeOpsParam.imageRef)&&
  Objects.equals(this.patchRef, objUpgradeOpsParam.patchRef)&&
  Objects.equals(this.seGroupOptions, objUpgradeOpsParam.seGroupOptions)&&
  Objects.equals(this.seGroupResumeOptions, objUpgradeOpsParam.seGroupResumeOptions);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class UpgradeOpsParam {\n");
                  sb.append("    imageRef: ").append(toIndentedString(imageRef)).append("\n");
                        sb.append("    patchRef: ").append(toIndentedString(patchRef)).append("\n");
                        sb.append("    seGroupOptions: ").append(toIndentedString(seGroupOptions)).append("\n");
                        sb.append("    seGroupResumeOptions: ").append(toIndentedString(seGroupResumeOptions)).append("\n");
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
