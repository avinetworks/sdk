package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The EventLog is a POJO class extends AviRestResource that used for creating
 * EventLog.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventLog  {
    @JsonProperty("context")
    private String context = null;

    @JsonProperty("details_summary")
    private String detailsSummary = null;

    @JsonProperty("event_description")
    private String eventDescription = null;

    @JsonProperty("event_details")
    private EventDetails eventDetails = null;

    @JsonProperty("event_id")
    private String eventId = null;

    @JsonProperty("event_pages")
    private List<String> eventPages = null;

    @JsonProperty("ignore_event_details_display")
    private Boolean ignoreEventDetailsDisplay = false;

    @JsonProperty("internal")
    private String internal = "EVENT_INTERNAL";

    @JsonProperty("is_security_event")
    private Boolean isSecurityEvent = false;

    @JsonProperty("module")
    private String module = null;

    @JsonProperty("obj_name")
    private String objName = null;

    @JsonProperty("obj_type")
    private String objType = null;

    @JsonProperty("obj_uuid")
    private String objUuid = null;

    @JsonProperty("reason_code")
    private String reasonCode = null;

    @JsonProperty("related_uuids")
    private List<String> relatedUuids = null;

    @JsonProperty("report_timestamp")
    private Integer reportTimestamp = null;

    @JsonProperty("tenant")
    private String tenant = null;

    @JsonProperty("tenant_name")
    private String tenantName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - EVENT_CONTEXT_SYSTEM, EVENT_CONTEXT_CONFIG, EVENT_CONTEXT_APP, EVENT_CONTEXT_ALL.
   * @return context
   */
  public String getContext() {
    return context;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - EVENT_CONTEXT_SYSTEM, EVENT_CONTEXT_CONFIG, EVENT_CONTEXT_APP, EVENT_CONTEXT_ALL.
   * @param context set the context.
   */
  public void setContext(String  context) {
    this.context = context;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Summary of event details.
   * @return detailsSummary
   */
  public String getDetailsSummary() {
    return detailsSummary;
  }

  /**
   * This is the setter method to the attribute.
   * Summary of event details.
   * @param detailsSummary set the detailsSummary.
   */
  public void setDetailsSummary(String  detailsSummary) {
    this.detailsSummary = detailsSummary;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Event description for each event  in the table view.
   * @return eventDescription
   */
  public String getEventDescription() {
    return eventDescription;
  }

  /**
   * This is the setter method to the attribute.
   * Event description for each event  in the table view.
   * @param eventDescription set the eventDescription.
   */
  public void setEventDescription(String  eventDescription) {
    this.eventDescription = eventDescription;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property event_details of obj type eventlog field type str  type ref.
   * @return eventDetails
   */
  public EventDetails getEventDetails() {
    return eventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property event_details of obj type eventlog field type str  type ref.
   * @param eventDetails set the eventDetails.
   */
  public void setEventDetails(EventDetails eventDetails) {
    this.eventDetails = eventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - VINFRA_DISC_DC, VINFRA_DISC_HOST, VINFRA_DISC_CLUSTER, VINFRA_DISC_VM, VINFRA_DISC_NW, MGMT_NW_NAME_CHANGED,
   * DISCOVERY_DATACENTER_DEL, VM_ADDED, VM_REMOVED, VINFRA_DISC_COMPLETE, VCENTER_ADDRESS_ERROR, SE_GROUP_CLUSTER_DEL, SE_GROUP_MGMT_NW_DEL,
   * MGMT_NW_DEL, VCENTER_BAD_CREDENTIALS, ESX_HOST_UNREACHABLE, SERVER_DELETED, SE_GROUP_HOST_DEL, VINFRA_DISC_FAILURE, ESX_HOST_POWERED_DOWN...
   * @return eventId
   */
  public String getEventId() {
    return eventId;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - VINFRA_DISC_DC, VINFRA_DISC_HOST, VINFRA_DISC_CLUSTER, VINFRA_DISC_VM, VINFRA_DISC_NW, MGMT_NW_NAME_CHANGED,
   * DISCOVERY_DATACENTER_DEL, VM_ADDED, VM_REMOVED, VINFRA_DISC_COMPLETE, VCENTER_ADDRESS_ERROR, SE_GROUP_CLUSTER_DEL, SE_GROUP_MGMT_NW_DEL,
   * MGMT_NW_DEL, VCENTER_BAD_CREDENTIALS, ESX_HOST_UNREACHABLE, SERVER_DELETED, SE_GROUP_HOST_DEL, VINFRA_DISC_FAILURE, ESX_HOST_POWERED_DOWN...
   * @param eventId set the eventId.
   */
  public void setEventId(String  eventId) {
    this.eventId = eventId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Pages in which event should come up.
   * @return eventPages
   */
  public List<String> getEventPages() {
    return eventPages;
  }

  /**
   * This is the setter method. this will set the eventPages
   * Pages in which event should come up.
   * @return eventPages
   */
  public void setEventPages(List<String>  eventPages) {
    this.eventPages = eventPages;
  }

  /**
   * This is the setter method this will set the eventPages
   * Pages in which event should come up.
   * @return eventPages
   */
  public EventLog addEventPagesItem(String eventPagesItem) {
    if (this.eventPages == null) {
      this.eventPages = new ArrayList<String>();
    }
    this.eventPages.add(eventPagesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ignore_event_details_display of obj type eventlog field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return ignoreEventDetailsDisplay
   */
  public Boolean getIgnoreEventDetailsDisplay() {
    return ignoreEventDetailsDisplay;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ignore_event_details_display of obj type eventlog field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param ignoreEventDetailsDisplay set the ignoreEventDetailsDisplay.
   */
  public void setIgnoreEventDetailsDisplay(Boolean  ignoreEventDetailsDisplay) {
    this.ignoreEventDetailsDisplay = ignoreEventDetailsDisplay;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - EVENT_INTERNAL, EVENT_EXTERNAL.
   * Default value when not specified in API or module is interpreted by Avi Controller as EVENT_INTERNAL.
   * @return internal
   */
  public String getInternal() {
    return internal;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - EVENT_INTERNAL, EVENT_EXTERNAL.
   * Default value when not specified in API or module is interpreted by Avi Controller as EVENT_INTERNAL.
   * @param internal set the internal.
   */
  public void setInternal(String  internal) {
    this.internal = internal;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property is_security_event of obj type eventlog field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isSecurityEvent
   */
  public Boolean getIsSecurityEvent() {
    return isSecurityEvent;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_security_event of obj type eventlog field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isSecurityEvent set the isSecurityEvent.
   */
  public void setIsSecurityEvent(Boolean  isSecurityEvent) {
    this.isSecurityEvent = isSecurityEvent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - UNKNOWN, VSMGR, SEMGR, RESMGR, VIMGR, METRICSMGR, CONFIG, SE_GENERAL, SE_FLOWTABLE, SE_HM, SE_POOL_PERSISTENCE, SE_POOL, VSERVER,
   * CLOUD_CONNECTOR, CLUSTERMGR, HSMGR, NW_MGR, LICENSE_MGR, RES_MONITOR, STATEDBCACHE...
   * @return module
   */
  public String getModule() {
    return module;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - UNKNOWN, VSMGR, SEMGR, RESMGR, VIMGR, METRICSMGR, CONFIG, SE_GENERAL, SE_FLOWTABLE, SE_HM, SE_POOL_PERSISTENCE, SE_POOL, VSERVER,
   * CLOUD_CONNECTOR, CLUSTERMGR, HSMGR, NW_MGR, LICENSE_MGR, RES_MONITOR, STATEDBCACHE...
   * @param module set the module.
   */
  public void setModule(String  module) {
    this.module = module;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property obj_name of obj type eventlog field type str  type string.
   * @return objName
   */
  public String getObjName() {
    return objName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property obj_name of obj type eventlog field type str  type string.
   * @param objName set the objName.
   */
  public void setObjName(String  objName) {
    this.objName = objName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - VIRTUALSERVICE, POOL, HEALTHMONITOR, NETWORKPROFILE, APPLICATIONPROFILE, HTTPPOLICYSET, DNSPOLICY, SECURITYPOLICY, IPADDRGROUP,
   * STRINGGROUP, SSLPROFILE, SSLKEYANDCERTIFICATE, NETWORKSECURITYPOLICY, APPLICATIONPERSISTENCEPROFILE, ANALYTICSPROFILE, VSDATASCRIPTSET, TENANT,
   * PKIPROFILE, AUTHPROFILE, CLOUD...
   * @return objType
   */
  public String getObjType() {
    return objType;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - VIRTUALSERVICE, POOL, HEALTHMONITOR, NETWORKPROFILE, APPLICATIONPROFILE, HTTPPOLICYSET, DNSPOLICY, SECURITYPOLICY, IPADDRGROUP,
   * STRINGGROUP, SSLPROFILE, SSLKEYANDCERTIFICATE, NETWORKSECURITYPOLICY, APPLICATIONPERSISTENCEPROFILE, ANALYTICSPROFILE, VSDATASCRIPTSET, TENANT,
   * PKIPROFILE, AUTHPROFILE, CLOUD...
   * @param objType set the objType.
   */
  public void setObjType(String  objType) {
    this.objType = objType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of obj.
   * @return objUuid
   */
  public String getObjUuid() {
    return objUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of obj.
   * @param objUuid set the objUuid.
   */
  public void setObjUuid(String  objUuid) {
    this.objUuid = objUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Reason code for generating the event.
   * This would be added to the alert where it would say alert generated  on event with reason <reason code>.
   * Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO,
   * SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN,
   * SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_BAD_REQUEST, SYSERR_TEST1...
   * @return reasonCode
   */
  public String getReasonCode() {
    return reasonCode;
  }

  /**
   * This is the setter method to the attribute.
   * Reason code for generating the event.
   * This would be added to the alert where it would say alert generated  on event with reason <reason code>.
   * Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO,
   * SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN,
   * SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_BAD_REQUEST, SYSERR_TEST1...
   * @param reasonCode set the reasonCode.
   */
  public void setReasonCode(String  reasonCode) {
    this.reasonCode = reasonCode;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Related objects corresponding to the events.
   * @return relatedUuids
   */
  public List<String> getRelatedUuids() {
    return relatedUuids;
  }

  /**
   * This is the setter method. this will set the relatedUuids
   * Related objects corresponding to the events.
   * @return relatedUuids
   */
  public void setRelatedUuids(List<String>  relatedUuids) {
    this.relatedUuids = relatedUuids;
  }

  /**
   * This is the setter method this will set the relatedUuids
   * Related objects corresponding to the events.
   * @return relatedUuids
   */
  public EventLog addRelatedUuidsItem(String relatedUuidsItem) {
    if (this.relatedUuids == null) {
      this.relatedUuids = new ArrayList<String>();
    }
    this.relatedUuids.add(relatedUuidsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property report_timestamp of obj type eventlog field type str  type integer.
   * @return reportTimestamp
   */
  public Integer getReportTimestamp() {
    return reportTimestamp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property report_timestamp of obj type eventlog field type str  type integer.
   * @param reportTimestamp set the reportTimestamp.
   */
  public void setReportTimestamp(Integer  reportTimestamp) {
    this.reportTimestamp = reportTimestamp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tenant of obj type eventlog field type str  type string.
   * @return tenant
   */
  public String getTenant() {
    return tenant;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property tenant of obj type eventlog field type str  type string.
   * @param tenant set the tenant.
   */
  public void setTenant(String  tenant) {
    this.tenant = tenant;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.1.
   * @return tenantName
   */
  public String getTenantName() {
    return tenantName;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.1.
   * @param tenantName set the tenantName.
   */
  public void setTenantName(String  tenantName) {
    this.tenantName = tenantName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  EventLog objEventLog = (EventLog) o;
  return   Objects.equals(this.reportTimestamp, objEventLog.reportTimestamp)&&
  Objects.equals(this.objType, objEventLog.objType)&&
  Objects.equals(this.eventId, objEventLog.eventId)&&
  Objects.equals(this.module, objEventLog.module)&&
  Objects.equals(this.internal, objEventLog.internal)&&
  Objects.equals(this.context, objEventLog.context)&&
  Objects.equals(this.objUuid, objEventLog.objUuid)&&
  Objects.equals(this.objName, objEventLog.objName)&&
  Objects.equals(this.reasonCode, objEventLog.reasonCode)&&
  Objects.equals(this.eventDetails, objEventLog.eventDetails)&&
  Objects.equals(this.detailsSummary, objEventLog.detailsSummary)&&
  Objects.equals(this.relatedUuids, objEventLog.relatedUuids)&&
  Objects.equals(this.eventDescription, objEventLog.eventDescription)&&
  Objects.equals(this.eventPages, objEventLog.eventPages)&&
  Objects.equals(this.ignoreEventDetailsDisplay, objEventLog.ignoreEventDetailsDisplay)&&
  Objects.equals(this.isSecurityEvent, objEventLog.isSecurityEvent)&&
  Objects.equals(this.tenantName, objEventLog.tenantName)&&
  Objects.equals(this.tenant, objEventLog.tenant);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class EventLog {\n");
      sb.append("    context: ").append(toIndentedString(context)).append("\n");
        sb.append("    detailsSummary: ").append(toIndentedString(detailsSummary)).append("\n");
        sb.append("    eventDescription: ").append(toIndentedString(eventDescription)).append("\n");
        sb.append("    eventDetails: ").append(toIndentedString(eventDetails)).append("\n");
        sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
        sb.append("    eventPages: ").append(toIndentedString(eventPages)).append("\n");
        sb.append("    ignoreEventDetailsDisplay: ").append(toIndentedString(ignoreEventDetailsDisplay)).append("\n");
        sb.append("    internal: ").append(toIndentedString(internal)).append("\n");
        sb.append("    isSecurityEvent: ").append(toIndentedString(isSecurityEvent)).append("\n");
        sb.append("    module: ").append(toIndentedString(module)).append("\n");
        sb.append("    objName: ").append(toIndentedString(objName)).append("\n");
        sb.append("    objType: ").append(toIndentedString(objType)).append("\n");
        sb.append("    objUuid: ").append(toIndentedString(objUuid)).append("\n");
        sb.append("    reasonCode: ").append(toIndentedString(reasonCode)).append("\n");
        sb.append("    relatedUuids: ").append(toIndentedString(relatedUuids)).append("\n");
        sb.append("    reportTimestamp: ").append(toIndentedString(reportTimestamp)).append("\n");
        sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
        sb.append("    tenantName: ").append(toIndentedString(tenantName)).append("\n");
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

