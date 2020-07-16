package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OpenStackLbPluginOp is a POJO class extends AviRestResource that used for creating
 * OpenStackLbPluginOp.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenStackLbPluginOp  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("command")
    private String command = null;

    @JsonProperty("detail")
    private String detail = null;

    @JsonProperty("elapsed")
    private Integer elapsed = null;

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("prov")
    private String prov = null;

    @JsonProperty("result")
    private String result = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type openstacklbpluginop field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type openstacklbpluginop field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property command of obj type openstacklbpluginop field type str  type string.
   * @return command
   */
  public String getCommand() {
    return command;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property command of obj type openstacklbpluginop field type str  type string.
   * @param command set the command.
   */
  public void setCommand(String  command) {
    this.command = command;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property detail of obj type openstacklbpluginop field type str  type string.
   * @return detail
   */
  public String getDetail() {
    return detail;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property detail of obj type openstacklbpluginop field type str  type string.
   * @param detail set the detail.
   */
  public void setDetail(String  detail) {
    this.detail = detail;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property elapsed of obj type openstacklbpluginop field type str  type integer.
   * @return elapsed
   */
  public Integer getElapsed() {
    return elapsed;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property elapsed of obj type openstacklbpluginop field type str  type integer.
   * @param elapsed set the elapsed.
   */
  public void setElapsed(Integer  elapsed) {
    this.elapsed = elapsed;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property id of obj type openstacklbpluginop field type str  type string.
   * @return id
   */
  public String getId() {
    return id;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property id of obj type openstacklbpluginop field type str  type string.
   * @param id set the id.
   */
  public void setId(String  id) {
    this.id = id;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property prov of obj type openstacklbpluginop field type str  type string.
   * @return prov
   */
  public String getProv() {
    return prov;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property prov of obj type openstacklbpluginop field type str  type string.
   * @param prov set the prov.
   */
  public void setProv(String  prov) {
    this.prov = prov;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property result of obj type openstacklbpluginop field type str  type string.
   * @return result
   */
  public String getResult() {
    return result;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property result of obj type openstacklbpluginop field type str  type string.
   * @param result set the result.
   */
  public void setResult(String  result) {
    this.result = result;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OpenStackLbPluginOp objOpenStackLbPluginOp = (OpenStackLbPluginOp) o;
  return   Objects.equals(this.prov, objOpenStackLbPluginOp.prov)&&
  Objects.equals(this.detail, objOpenStackLbPluginOp.detail)&&
  Objects.equals(this.elapsed, objOpenStackLbPluginOp.elapsed)&&
  Objects.equals(this.command, objOpenStackLbPluginOp.command)&&
  Objects.equals(this.result, objOpenStackLbPluginOp.result)&&
  Objects.equals(this.id, objOpenStackLbPluginOp.id)&&
  Objects.equals(this.ccId, objOpenStackLbPluginOp.ccId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OpenStackLbPluginOp {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    command: ").append(toIndentedString(command)).append("\n");
        sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
        sb.append("    elapsed: ").append(toIndentedString(elapsed)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    prov: ").append(toIndentedString(prov)).append("\n");
        sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

