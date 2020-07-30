package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Alert is a POJO class extends AviRestResource that used for creating
 * Alert.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alert extends AviRestResource  {
    @JsonProperty("action_script_output")
    private String actionScriptOutput = null;

    @JsonProperty("alert_config_ref")
    private String alertConfigRef = null;

    @JsonProperty("app_events")
    private List<ApplicationLog> appEvents = null;

    @JsonProperty("conn_events")
    private List<ConnectionLog> connEvents = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("event_pages")
    private List<String> eventPages = null;

    @JsonProperty("events")
    private List<EventLog> events = null;

    @JsonProperty("last_throttle_timestamp")
    private Float lastThrottleTimestamp = null;

    @JsonProperty("level")
    private String level = null;

    @JsonProperty("metric_info")
    private List<MetricLog> metricInfo = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("obj_key")
    private String objKey = null;

    @JsonProperty("obj_name")
    private String objName = null;

    @JsonProperty("obj_uuid")
    private String objUuid = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("related_uuids")
    private List<String> relatedUuids = null;

    @JsonProperty("state")
    private String state = null;

    @JsonProperty("summary")
    private String summary = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("threshold")
    private Integer threshold = null;

    @JsonProperty("throttle_count")
    private Integer throttleCount = 0;

    @JsonProperty("timestamp")
    private Float timestamp = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Output of the alert action script.
   * @return actionScriptOutput
   */
  public String getActionScriptOutput() {
    return actionScriptOutput;
  }

  /**
   * This is the setter method to the attribute.
   * Output of the alert action script.
   * @param actionScriptOutput set the actionScriptOutput.
   */
  public void setActionScriptOutput(String  actionScriptOutput) {
    this.actionScriptOutput = actionScriptOutput;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type alertconfig.
   * @return alertConfigRef
   */
  public String getAlertConfigRef() {
    return alertConfigRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type alertconfig.
   * @param alertConfigRef set the alertConfigRef.
   */
  public void setAlertConfigRef(String  alertConfigRef) {
    this.alertConfigRef = alertConfigRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property app_events of obj type alert field type str  type array.
   * @return appEvents
   */
  public List<ApplicationLog> getAppEvents() {
    return appEvents;
  }

  /**
   * This is the setter method. this will set the appEvents
   * Placeholder for description of property app_events of obj type alert field type str  type array.
   * @return appEvents
   */
  public void setAppEvents(List<ApplicationLog>  appEvents) {
    this.appEvents = appEvents;
  }

  /**
   * This is the setter method this will set the appEvents
   * Placeholder for description of property app_events of obj type alert field type str  type array.
   * @return appEvents
   */
  public Alert addAppEventsItem(ApplicationLog appEventsItem) {
    if (this.appEvents == null) {
      this.appEvents = new ArrayList<ApplicationLog>();
    }
    this.appEvents.add(appEventsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property conn_events of obj type alert field type str  type array.
   * @return connEvents
   */
  public List<ConnectionLog> getConnEvents() {
    return connEvents;
  }

  /**
   * This is the setter method. this will set the connEvents
   * Placeholder for description of property conn_events of obj type alert field type str  type array.
   * @return connEvents
   */
  public void setConnEvents(List<ConnectionLog>  connEvents) {
    this.connEvents = connEvents;
  }

  /**
   * This is the setter method this will set the connEvents
   * Placeholder for description of property conn_events of obj type alert field type str  type array.
   * @return connEvents
   */
  public Alert addConnEventsItem(ConnectionLog connEventsItem) {
    if (this.connEvents == null) {
      this.connEvents = new ArrayList<ConnectionLog>();
    }
    this.connEvents.add(connEventsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Alert generation criteria.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * Alert generation criteria.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of event pages this alert is associated with.
   * @return eventPages
   */
  public List<String> getEventPages() {
    return eventPages;
  }

  /**
   * This is the setter method. this will set the eventPages
   * List of event pages this alert is associated with.
   * @return eventPages
   */
  public void setEventPages(List<String>  eventPages) {
    this.eventPages = eventPages;
  }

  /**
   * This is the setter method this will set the eventPages
   * List of event pages this alert is associated with.
   * @return eventPages
   */
  public Alert addEventPagesItem(String eventPagesItem) {
    if (this.eventPages == null) {
      this.eventPages = new ArrayList<String>();
    }
    this.eventPages.add(eventPagesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property events of obj type alert field type str  type array.
   * @return events
   */
  public List<EventLog> getEvents() {
    return events;
  }

  /**
   * This is the setter method. this will set the events
   * Placeholder for description of property events of obj type alert field type str  type array.
   * @return events
   */
  public void setEvents(List<EventLog>  events) {
    this.events = events;
  }

  /**
   * This is the setter method this will set the events
   * Placeholder for description of property events of obj type alert field type str  type array.
   * @return events
   */
  public Alert addEventsItem(EventLog eventsItem) {
    if (this.events == null) {
      this.events = new ArrayList<EventLog>();
    }
    this.events.add(eventsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unix timestamp of the last throttling in seconds.
   * @return lastThrottleTimestamp
   */
  public Float getLastThrottleTimestamp() {
    return lastThrottleTimestamp;
  }

  /**
   * This is the setter method to the attribute.
   * Unix timestamp of the last throttling in seconds.
   * @param lastThrottleTimestamp set the lastThrottleTimestamp.
   */
  public void setLastThrottleTimestamp(Float  lastThrottleTimestamp) {
    this.lastThrottleTimestamp = lastThrottleTimestamp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Resolved alert type.
   * Enum options - ALERT_LOW, ALERT_MEDIUM, ALERT_HIGH.
   * @return level
   */
  public String getLevel() {
    return level;
  }

  /**
   * This is the setter method to the attribute.
   * Resolved alert type.
   * Enum options - ALERT_LOW, ALERT_MEDIUM, ALERT_HIGH.
   * @param level set the level.
   */
  public void setLevel(String  level) {
    this.level = level;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metric_info of obj type alert field type str  type array.
   * @return metricInfo
   */
  public List<MetricLog> getMetricInfo() {
    return metricInfo;
  }

  /**
   * This is the setter method. this will set the metricInfo
   * Placeholder for description of property metric_info of obj type alert field type str  type array.
   * @return metricInfo
   */
  public void setMetricInfo(List<MetricLog>  metricInfo) {
    this.metricInfo = metricInfo;
  }

  /**
   * This is the setter method this will set the metricInfo
   * Placeholder for description of property metric_info of obj type alert field type str  type array.
   * @return metricInfo
   */
  public Alert addMetricInfoItem(MetricLog metricInfoItem) {
    if (this.metricInfo == null) {
      this.metricInfo = new ArrayList<MetricLog>();
    }
    this.metricInfo.add(metricInfoItem);
    return this;
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
   * Uuid of the resource.
   * @return objKey
   */
  public String getObjKey() {
    return objKey;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the resource.
   * @param objKey set the objKey.
   */
  public void setObjKey(String  objKey) {
    this.objKey = objKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the resource.
   * @return objName
   */
  public String getObjName() {
    return objName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the resource.
   * @param objName set the objName.
   */
  public void setObjName(String  objName) {
    this.objName = objName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the resource.
   * @return objUuid
   */
  public String getObjUuid() {
    return objUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the resource.
   * @param objUuid set the objUuid.
   */
  public void setObjUuid(String  objUuid) {
    this.objUuid = objUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type alert field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type alert field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Related uuids for the connection log.
   * Only log agent needs to fill this.
   * Server uuid should be in formatpool_uuid-ip-port.
   * In case of no port is set for server it shouldstill be operational port for the server.
   * @return relatedUuids
   */
  public List<String> getRelatedUuids() {
    return relatedUuids;
  }

  /**
   * This is the setter method. this will set the relatedUuids
   * Related uuids for the connection log.
   * Only log agent needs to fill this.
   * Server uuid should be in formatpool_uuid-ip-port.
   * In case of no port is set for server it shouldstill be operational port for the server.
   * @return relatedUuids
   */
  public void setRelatedUuids(List<String>  relatedUuids) {
    this.relatedUuids = relatedUuids;
  }

  /**
   * This is the setter method this will set the relatedUuids
   * Related uuids for the connection log.
   * Only log agent needs to fill this.
   * Server uuid should be in formatpool_uuid-ip-port.
   * In case of no port is set for server it shouldstill be operational port for the server.
   * @return relatedUuids
   */
  public Alert addRelatedUuidsItem(String relatedUuidsItem) {
    if (this.relatedUuids == null) {
      this.relatedUuids = new ArrayList<String>();
    }
    this.relatedUuids.add(relatedUuidsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * State of the alert.
   * It would be active when createdit would be changed to state read when read by the admin.
   * Enum options - ALERT_STATE_ON, ALERT_STATE_DISMISSED, ALERT_STATE_THROTTLED.
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * This is the setter method to the attribute.
   * State of the alert.
   * It would be active when createdit would be changed to state read when read by the admin.
   * Enum options - ALERT_STATE_ON, ALERT_STATE_DISMISSED, ALERT_STATE_THROTTLED.
   * @param state set the state.
   */
  public void setState(String  state) {
    this.state = state;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Summary of alert based on alert config.
   * @return summary
   */
  public String getSummary() {
    return summary;
  }

  /**
   * This is the setter method to the attribute.
   * Summary of alert based on alert config.
   * @param summary set the summary.
   */
  public void setSummary(String  summary) {
    this.summary = summary;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property threshold of obj type alert field type str  type integer.
   * @return threshold
   */
  public Integer getThreshold() {
    return threshold;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property threshold of obj type alert field type str  type integer.
   * @param threshold set the threshold.
   */
  public void setThreshold(Integer  threshold) {
    this.threshold = threshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of times it was throttled.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return throttleCount
   */
  public Integer getThrottleCount() {
    return throttleCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of times it was throttled.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param throttleCount set the throttleCount.
   */
  public void setThrottleCount(Integer  throttleCount) {
    this.throttleCount = throttleCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unix timestamp of the last throttling in seconds.
   * @return timestamp
   */
  public Float getTimestamp() {
    return timestamp;
  }

  /**
   * This is the setter method to the attribute.
   * Unix timestamp of the last throttling in seconds.
   * @param timestamp set the timestamp.
   */
  public void setTimestamp(Float  timestamp) {
    this.timestamp = timestamp;
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
  Alert objAlert = (Alert) o;
  return   Objects.equals(this.uuid, objAlert.uuid)&&
  Objects.equals(this.name, objAlert.name)&&
  Objects.equals(this.alertConfigRef, objAlert.alertConfigRef)&&
  Objects.equals(this.level, objAlert.level)&&
  Objects.equals(this.reason, objAlert.reason)&&
  Objects.equals(this.state, objAlert.state)&&
  Objects.equals(this.timestamp, objAlert.timestamp)&&
  Objects.equals(this.objUuid, objAlert.objUuid)&&
  Objects.equals(this.objKey, objAlert.objKey)&&
  Objects.equals(this.objName, objAlert.objName)&&
  Objects.equals(this.threshold, objAlert.threshold)&&
  Objects.equals(this.events, objAlert.events)&&
  Objects.equals(this.appEvents, objAlert.appEvents)&&
  Objects.equals(this.connEvents, objAlert.connEvents)&&
  Objects.equals(this.metricInfo, objAlert.metricInfo)&&
  Objects.equals(this.throttleCount, objAlert.throttleCount)&&
  Objects.equals(this.lastThrottleTimestamp, objAlert.lastThrottleTimestamp)&&
  Objects.equals(this.relatedUuids, objAlert.relatedUuids)&&
  Objects.equals(this.eventPages, objAlert.eventPages)&&
  Objects.equals(this.summary, objAlert.summary)&&
  Objects.equals(this.description, objAlert.description)&&
  Objects.equals(this.actionScriptOutput, objAlert.actionScriptOutput)&&
  Objects.equals(this.tenantRef, objAlert.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Alert {\n");
      sb.append("    actionScriptOutput: ").append(toIndentedString(actionScriptOutput)).append("\n");
        sb.append("    alertConfigRef: ").append(toIndentedString(alertConfigRef)).append("\n");
        sb.append("    appEvents: ").append(toIndentedString(appEvents)).append("\n");
        sb.append("    connEvents: ").append(toIndentedString(connEvents)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    eventPages: ").append(toIndentedString(eventPages)).append("\n");
        sb.append("    events: ").append(toIndentedString(events)).append("\n");
        sb.append("    lastThrottleTimestamp: ").append(toIndentedString(lastThrottleTimestamp)).append("\n");
        sb.append("    level: ").append(toIndentedString(level)).append("\n");
        sb.append("    metricInfo: ").append(toIndentedString(metricInfo)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    objKey: ").append(toIndentedString(objKey)).append("\n");
        sb.append("    objName: ").append(toIndentedString(objName)).append("\n");
        sb.append("    objUuid: ").append(toIndentedString(objUuid)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    relatedUuids: ").append(toIndentedString(relatedUuids)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    threshold: ").append(toIndentedString(threshold)).append("\n");
        sb.append("    throttleCount: ").append(toIndentedString(throttleCount)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

