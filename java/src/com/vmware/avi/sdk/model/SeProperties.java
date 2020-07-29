package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeProperties is a POJO class extends AviRestResource that used for creating
 * SeProperties.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeProperties extends AviRestResource  {
    @JsonProperty("se_agent_properties")
    private SeAgentProperties seAgentProperties = null;

    @JsonProperty("se_bootup_properties")
    private SeBootupProperties seBootupProperties = null;

    @JsonProperty("se_runtime_properties")
    private SeRuntimeProperties seRuntimeProperties = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = "default";



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_agent_properties of obj type seproperties field type str  type ref.
   * @return seAgentProperties
   */
  public SeAgentProperties getSeAgentProperties() {
    return seAgentProperties;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_agent_properties of obj type seproperties field type str  type ref.
   * @param seAgentProperties set the seAgentProperties.
   */
  public void setSeAgentProperties(SeAgentProperties seAgentProperties) {
    this.seAgentProperties = seAgentProperties;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_bootup_properties of obj type seproperties field type str  type ref.
   * @return seBootupProperties
   */
  public SeBootupProperties getSeBootupProperties() {
    return seBootupProperties;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_bootup_properties of obj type seproperties field type str  type ref.
   * @param seBootupProperties set the seBootupProperties.
   */
  public void setSeBootupProperties(SeBootupProperties seBootupProperties) {
    this.seBootupProperties = seBootupProperties;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_runtime_properties of obj type seproperties field type str  type ref.
   * @return seRuntimeProperties
   */
  public SeRuntimeProperties getSeRuntimeProperties() {
    return seRuntimeProperties;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_runtime_properties of obj type seproperties field type str  type ref.
   * @param seRuntimeProperties set the seRuntimeProperties.
   */
  public void setSeRuntimeProperties(SeRuntimeProperties seRuntimeProperties) {
    this.seRuntimeProperties = seRuntimeProperties;
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
   * Default value when not specified in API or module is interpreted by Avi Controller as default.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
   * Default value when not specified in API or module is interpreted by Avi Controller as default.
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
  SeProperties objSeProperties = (SeProperties) o;
  return   Objects.equals(this.uuid, objSeProperties.uuid)&&
  Objects.equals(this.seBootupProperties, objSeProperties.seBootupProperties)&&
  Objects.equals(this.seRuntimeProperties, objSeProperties.seRuntimeProperties)&&
  Objects.equals(this.seAgentProperties, objSeProperties.seAgentProperties);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeProperties {\n");
      sb.append("    seAgentProperties: ").append(toIndentedString(seAgentProperties)).append("\n");
        sb.append("    seBootupProperties: ").append(toIndentedString(seBootupProperties)).append("\n");
        sb.append("    seRuntimeProperties: ").append(toIndentedString(seRuntimeProperties)).append("\n");
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

