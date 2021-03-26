package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The GeoDBMapping is a POJO class extends AviRestResource that used for creating
 * GeoDBMapping.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeoDBMapping  {
    @JsonProperty("description")
    private String description = null;

    @JsonProperty("elements")
    private List<GeoDBMappingElement> elements = null;

    @JsonProperty("name")
    private String name = null;



    /**
     * This is the getter method this will return the attribute value.
     * Description of the mapping.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the setter method to the attribute.
     * Description of the mapping.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param description set the description.
     */
    public void setDescription(String  description) {
        this.description = description;
    }
    /**
     * This is the getter method this will return the attribute value.
     * The set of mapping elements.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return elements
     */
    public List<GeoDBMappingElement> getElements() {
        return elements;
    }

    /**
     * This is the setter method. this will set the elements
     * The set of mapping elements.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return elements
     */
    public void setElements(List<GeoDBMappingElement>  elements) {
        this.elements = elements;
    }

    /**
     * This is the setter method this will set the elements
     * The set of mapping elements.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return elements
     */
    public GeoDBMapping addElementsItem(GeoDBMappingElement elementsItem) {
      if (this.elements == null) {
        this.elements = new ArrayList<GeoDBMappingElement>();
      }
      this.elements.add(elementsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The unique name of the user mapping.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * The unique name of the user mapping.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      GeoDBMapping objGeoDBMapping = (GeoDBMapping) o;
      return   Objects.equals(this.name, objGeoDBMapping.name)&&
  Objects.equals(this.description, objGeoDBMapping.description)&&
  Objects.equals(this.elements, objGeoDBMapping.elements);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class GeoDBMapping {\n");
                  sb.append("    description: ").append(toIndentedString(description)).append("\n");
                        sb.append("    elements: ").append(toIndentedString(elements)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
