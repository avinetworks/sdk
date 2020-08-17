package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SecurityMgrDebugFilter is a POJO class extends AviRestResource that used for creating
 * SecurityMgrDebugFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecurityMgrDebugFilter  {
    @JsonProperty("enable_adaptive_config")
    private Boolean enableAdaptiveConfig = true;

    @JsonProperty("entity_ref")
    private String entityRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * Dynamically adapt configuration parameters for application learning feature.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableAdaptiveConfig
   */
  public Boolean getEnableAdaptiveConfig() {
    return enableAdaptiveConfig;
  }

  /**
   * This is the setter method to the attribute.
   * Dynamically adapt configuration parameters for application learning feature.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableAdaptiveConfig set the enableAdaptiveConfig.
   */
  public void setEnableAdaptiveConfig(Boolean  enableAdaptiveConfig) {
    this.enableAdaptiveConfig = enableAdaptiveConfig;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the entity.
   * It is a reference to an object of type virtualservice.
   * Field introduced in 18.2.6.
   * @return entityRef
   */
  public String getEntityRef() {
    return entityRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the entity.
   * It is a reference to an object of type virtualservice.
   * Field introduced in 18.2.6.
   * @param entityRef set the entityRef.
   */
  public void setEntityRef(String  entityRef) {
    this.entityRef = entityRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SecurityMgrDebugFilter objSecurityMgrDebugFilter = (SecurityMgrDebugFilter) o;
  return   Objects.equals(this.entityRef, objSecurityMgrDebugFilter.entityRef)&&
  Objects.equals(this.enableAdaptiveConfig, objSecurityMgrDebugFilter.enableAdaptiveConfig);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SecurityMgrDebugFilter {\n");
      sb.append("    enableAdaptiveConfig: ").append(toIndentedString(enableAdaptiveConfig)).append("\n");
        sb.append("    entityRef: ").append(toIndentedString(entityRef)).append("\n");
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

