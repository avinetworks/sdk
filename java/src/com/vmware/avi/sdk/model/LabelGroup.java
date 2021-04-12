package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The LabelGroup is a POJO class extends AviRestResource that used for creating
 * LabelGroup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LabelGroup extends AviRestResource  {
    @JsonProperty("labels")
    private List<RoleMatchOperationMatchLabel> labels = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;


    /**
     * This is the getter method this will return the attribute value.
     * List of allowed or suggested labels for the label group.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public List<RoleMatchOperationMatchLabel> getLabels() {
        return labels;
    }

    /**
     * This is the setter method. this will set the labels
     * List of allowed or suggested labels for the label group.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public void setLabels(List<RoleMatchOperationMatchLabel>  labels) {
        this.labels = labels;
    }

    /**
     * This is the setter method this will set the labels
     * List of allowed or suggested labels for the label group.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return labels
     */
    public LabelGroup addLabelsItem(RoleMatchOperationMatchLabel labelsItem) {
      if (this.labels == null) {
        this.labels = new ArrayList<RoleMatchOperationMatchLabel>();
      }
      this.labels.add(labelsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the label group.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the label group.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
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
     * Uuid of the label group.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the label group.
     * Field introduced in 20.1.5.
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
      LabelGroup objLabelGroup = (LabelGroup) o;
      return   Objects.equals(this.uuid, objLabelGroup.uuid)&&
  Objects.equals(this.name, objLabelGroup.name)&&
  Objects.equals(this.labels, objLabelGroup.labels);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class LabelGroup {\n");
                  sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
