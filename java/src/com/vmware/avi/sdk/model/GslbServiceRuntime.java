package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbServiceRuntime is a POJO class extends AviRestResource that used for creating
 * GslbServiceRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbServiceRuntime extends AviRestResource  {
    @JsonProperty("checksum")
    private String checksum = null;

    @JsonProperty("flr_state")
    private List<CfgState> flrState = null;

    @JsonProperty("groups")
    private List<GslbPoolRuntime> groups = null;

    @JsonProperty("ldr_state")
    private CfgState ldrState = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("oper_status")
    private OperationalStatus operStatus = null;

    @JsonProperty("send_event")
    private Boolean sendEvent = null;

    @JsonProperty("send_status")
    private Boolean sendStatus = null;

    @JsonProperty("services_state")
    private String servicesState = null;

    @JsonProperty("sp_oper_status")
    private OperationalStatus spOperStatus = null;

    @JsonProperty("tenant_name")
    private String tenantName = null;

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.3.
   * @return checksum
   */
  public String getChecksum() {
    return checksum;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.3.
   * @param checksum set the checksum.
   */
  public void setChecksum(String  checksum) {
    this.checksum = checksum;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property flr_state of obj type gslbserviceruntime field type str  type array.
   * @return flrState
   */
  public List<CfgState> getFlrState() {
    return flrState;
  }

  /**
   * This is the setter method. this will set the flrState
   * Placeholder for description of property flr_state of obj type gslbserviceruntime field type str  type array.
   * @return flrState
   */
  public void setFlrState(List<CfgState>  flrState) {
    this.flrState = flrState;
  }

  /**
   * This is the setter method this will set the flrState
   * Placeholder for description of property flr_state of obj type gslbserviceruntime field type str  type array.
   * @return flrState
   */
  public GslbServiceRuntime addFlrStateItem(CfgState flrStateItem) {
    if (this.flrState == null) {
      this.flrState = new ArrayList<CfgState>();
    }
    this.flrState.add(flrStateItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property groups of obj type gslbserviceruntime field type str  type array.
   * @return groups
   */
  public List<GslbPoolRuntime> getGroups() {
    return groups;
  }

  /**
   * This is the setter method. this will set the groups
   * Placeholder for description of property groups of obj type gslbserviceruntime field type str  type array.
   * @return groups
   */
  public void setGroups(List<GslbPoolRuntime>  groups) {
    this.groups = groups;
  }

  /**
   * This is the setter method this will set the groups
   * Placeholder for description of property groups of obj type gslbserviceruntime field type str  type array.
   * @return groups
   */
  public GslbServiceRuntime addGroupsItem(GslbPoolRuntime groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<GslbPoolRuntime>();
    }
    this.groups.add(groupsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ldr_state of obj type gslbserviceruntime field type str  type ref.
   * @return ldrState
   */
  public CfgState getLdrState() {
    return ldrState;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ldr_state of obj type gslbserviceruntime field type str  type ref.
   * @param ldrState set the ldrState.
   */
  public void setLdrState(CfgState ldrState) {
    this.ldrState = ldrState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property oper_status of obj type gslbserviceruntime field type str  type ref.
   * @return operStatus
   */
  public OperationalStatus getOperStatus() {
    return operStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property oper_status of obj type gslbserviceruntime field type str  type ref.
   * @param operStatus set the operStatus.
   */
  public void setOperStatus(OperationalStatus operStatus) {
    this.operStatus = operStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.1.
   * @return sendEvent
   */
  public Boolean getSendEvent() {
    return sendEvent;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.1.
   * @param sendEvent set the sendEvent.
   */
  public void setSendEvent(Boolean  sendEvent) {
    this.sendEvent = sendEvent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.1.
   * @return sendStatus
   */
  public Boolean getSendStatus() {
    return sendStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.1.
   * @param sendStatus set the sendStatus.
   */
  public void setSendStatus(Boolean  sendStatus) {
    this.sendStatus = sendStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property services_state of obj type gslbserviceruntime field type str  type string.
   * @return servicesState
   */
  public String getServicesState() {
    return servicesState;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property services_state of obj type gslbserviceruntime field type str  type string.
   * @param servicesState set the servicesState.
   */
  public void setServicesState(String  servicesState) {
    this.servicesState = servicesState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Gslb site persistence consolidated status.
   * Field introduced in 17.2.2.
   * @return spOperStatus
   */
  public OperationalStatus getSpOperStatus() {
    return spOperStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Gslb site persistence consolidated status.
   * Field introduced in 17.2.2.
   * @param spOperStatus set the spOperStatus.
   */
  public void setSpOperStatus(OperationalStatus spOperStatus) {
    this.spOperStatus = spOperStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant name (and not uuid) is required in logs/metrics generated by the se.
   * @return tenantName
   */
  public String getTenantName() {
    return tenantName;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant name (and not uuid) is required in logs/metrics generated by the se.
   * @param tenantName set the tenantName.
   */
  public void setTenantName(String  tenantName) {
    this.tenantName = tenantName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
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
  GslbServiceRuntime objGslbServiceRuntime = (GslbServiceRuntime) o;
  return   Objects.equals(this.uuid, objGslbServiceRuntime.uuid)&&
  Objects.equals(this.name, objGslbServiceRuntime.name)&&
  Objects.equals(this.ldrState, objGslbServiceRuntime.ldrState)&&
  Objects.equals(this.flrState, objGslbServiceRuntime.flrState)&&
  Objects.equals(this.operStatus, objGslbServiceRuntime.operStatus)&&
  Objects.equals(this.groups, objGslbServiceRuntime.groups)&&
  Objects.equals(this.servicesState, objGslbServiceRuntime.servicesState)&&
  Objects.equals(this.tenantName, objGslbServiceRuntime.tenantName)&&
  Objects.equals(this.checksum, objGslbServiceRuntime.checksum)&&
  Objects.equals(this.spOperStatus, objGslbServiceRuntime.spOperStatus)&&
  Objects.equals(this.sendStatus, objGslbServiceRuntime.sendStatus)&&
  Objects.equals(this.sendEvent, objGslbServiceRuntime.sendEvent);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbServiceRuntime {\n");
      sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
        sb.append("    flrState: ").append(toIndentedString(flrState)).append("\n");
        sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
        sb.append("    ldrState: ").append(toIndentedString(ldrState)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    operStatus: ").append(toIndentedString(operStatus)).append("\n");
        sb.append("    sendEvent: ").append(toIndentedString(sendEvent)).append("\n");
        sb.append("    sendStatus: ").append(toIndentedString(sendStatus)).append("\n");
        sb.append("    servicesState: ").append(toIndentedString(servicesState)).append("\n");
        sb.append("    spOperStatus: ").append(toIndentedString(spOperStatus)).append("\n");
        sb.append("    tenantName: ").append(toIndentedString(tenantName)).append("\n");
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

