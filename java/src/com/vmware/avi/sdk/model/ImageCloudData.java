package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The ImageCloudData is a POJO class extends AviRestResource that used for creating
 * ImageCloudData.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageCloudData  {
    @JsonProperty("cloud_data_values")
    private List<ImageCloudSpecificData> cloudDataValues = null;

    @JsonProperty("cloud_name")
    private String cloudName = null;


    /**
     * This is the getter method this will return the attribute value.
     * Cloud data specific to a particular cloud.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cloudDataValues
     */
    public List<ImageCloudSpecificData> getCloudDataValues() {
        return cloudDataValues;
    }

    /**
     * This is the setter method. this will set the cloudDataValues
     * Cloud data specific to a particular cloud.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cloudDataValues
     */
    public void setCloudDataValues(List<ImageCloudSpecificData>  cloudDataValues) {
        this.cloudDataValues = cloudDataValues;
    }

    /**
     * This is the setter method this will set the cloudDataValues
     * Cloud data specific to a particular cloud.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cloudDataValues
     */
    public ImageCloudData addCloudDataValuesItem(ImageCloudSpecificData cloudDataValuesItem) {
      if (this.cloudDataValues == null) {
        this.cloudDataValues = new ArrayList<ImageCloudSpecificData>();
      }
      this.cloudDataValues.add(cloudDataValuesItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Contains the name of the cloud.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cloudName
     */
    public String getCloudName() {
        return cloudName;
    }

    /**
     * This is the setter method to the attribute.
     * Contains the name of the cloud.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param cloudName set the cloudName.
     */
    public void setCloudName(String  cloudName) {
        this.cloudName = cloudName;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      ImageCloudData objImageCloudData = (ImageCloudData) o;
      return   Objects.equals(this.cloudName, objImageCloudData.cloudName)&&
  Objects.equals(this.cloudDataValues, objImageCloudData.cloudDataValues);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ImageCloudData {\n");
                  sb.append("    cloudDataValues: ").append(toIndentedString(cloudDataValues)).append("\n");
                        sb.append("    cloudName: ").append(toIndentedString(cloudName)).append("\n");
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
