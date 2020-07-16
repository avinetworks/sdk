package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ProactiveSupportDefaults is a POJO class extends AviRestResource that used for creating
 * ProactiveSupportDefaults.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProactiveSupportDefaults  {
    @JsonProperty("attach_core_dump")
    private Boolean attachCoreDump = false;

    @JsonProperty("attach_tech_support")
    private Boolean attachTechSupport = true;

    @JsonProperty("case_severity")
    private String caseSeverity = "severity 5";



  /**
   * This is the getter method this will return the attribute value.
   * Opt-in to attach core dump with support case.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return attachCoreDump
   */
  public Boolean getAttachCoreDump() {
    return attachCoreDump;
  }

  /**
   * This is the setter method to the attribute.
   * Opt-in to attach core dump with support case.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param attachCoreDump set the attachCoreDump.
   */
  public void setAttachCoreDump(Boolean  attachCoreDump) {
    this.attachCoreDump = attachCoreDump;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Opt-in to attach tech support with support case.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return attachTechSupport
   */
  public Boolean getAttachTechSupport() {
    return attachTechSupport;
  }

  /**
   * This is the setter method to the attribute.
   * Opt-in to attach tech support with support case.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param attachTechSupport set the attachTechSupport.
   */
  public void setAttachTechSupport(Boolean  attachTechSupport) {
    this.attachTechSupport = attachTechSupport;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Case severity to be used for proactive support case creation.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as severity 5.
   * @return caseSeverity
   */
  public String getCaseSeverity() {
    return caseSeverity;
  }

  /**
   * This is the setter method to the attribute.
   * Case severity to be used for proactive support case creation.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as severity 5.
   * @param caseSeverity set the caseSeverity.
   */
  public void setCaseSeverity(String  caseSeverity) {
    this.caseSeverity = caseSeverity;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ProactiveSupportDefaults objProactiveSupportDefaults = (ProactiveSupportDefaults) o;
  return   Objects.equals(this.attachCoreDump, objProactiveSupportDefaults.attachCoreDump)&&
  Objects.equals(this.attachTechSupport, objProactiveSupportDefaults.attachTechSupport)&&
  Objects.equals(this.caseSeverity, objProactiveSupportDefaults.caseSeverity);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ProactiveSupportDefaults {\n");
      sb.append("    attachCoreDump: ").append(toIndentedString(attachCoreDump)).append("\n");
        sb.append("    attachTechSupport: ").append(toIndentedString(attachTechSupport)).append("\n");
        sb.append("    caseSeverity: ").append(toIndentedString(caseSeverity)).append("\n");
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

