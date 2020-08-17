package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AlertConfig is a POJO class extends AviRestResource that used for creating
 * AlertConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertConfig extends AviRestResource  {
    @JsonProperty("action_group_ref")
    private String actionGroupRef = null;

    @JsonProperty("alert_rule")
    private AlertRule alertRule = null;

    @JsonProperty("autoscale_alert")
    private Boolean autoscaleAlert = null;

    @JsonProperty("category")
    private String category = "REALTIME";

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("expiry_time")
    private Integer expiryTime = 86400;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("obj_uuid")
    private String objUuid = null;

    @JsonProperty("object_type")
    private String objectType = null;

    @JsonProperty("recommendation")
    private String recommendation = null;

    @JsonProperty("rolling_window")
    private Integer rollingWindow = 300;

    @JsonProperty("source")
    private String source = null;

    @JsonProperty("summary")
    private String summary = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("threshold")
    private Integer threshold = 1;

    @JsonProperty("throttle")
    private Integer throttle = 600;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * The alert config will trigger the selected alert action, which can send notifications and execute a controlscript.
   * It is a reference to an object of type actiongroupconfig.
   * @return actionGroupRef
   */
  public String getActionGroupRef() {
    return actionGroupRef;
  }

  /**
   * This is the setter method to the attribute.
   * The alert config will trigger the selected alert action, which can send notifications and execute a controlscript.
   * It is a reference to an object of type actiongroupconfig.
   * @param actionGroupRef set the actionGroupRef.
   */
  public void setActionGroupRef(String  actionGroupRef) {
    this.actionGroupRef = actionGroupRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * List of filters matching on events or client logs used for triggering alerts.
   * @return alertRule
   */
  public AlertRule getAlertRule() {
    return alertRule;
  }

  /**
   * This is the setter method to the attribute.
   * List of filters matching on events or client logs used for triggering alerts.
   * @param alertRule set the alertRule.
   */
  public void setAlertRule(AlertRule alertRule) {
    this.alertRule = alertRule;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This alert config applies to auto scale alerts.
   * @return autoscaleAlert
   */
  public Boolean getAutoscaleAlert() {
    return autoscaleAlert;
  }

  /**
   * This is the setter method to the attribute.
   * This alert config applies to auto scale alerts.
   * @param autoscaleAlert set the autoscaleAlert.
   */
  public void setAutoscaleAlert(Boolean  autoscaleAlert) {
    this.autoscaleAlert = autoscaleAlert;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Determines whether an alert is raised immediately when event occurs (realtime) or after specified number of events occurs within rolling time
   * window.
   * Enum options - REALTIME, ROLLINGWINDOW, WATERMARK.
   * Default value when not specified in API or module is interpreted by Avi Controller as REALTIME.
   * @return category
   */
  public String getCategory() {
    return category;
  }

  /**
   * This is the setter method to the attribute.
   * Determines whether an alert is raised immediately when event occurs (realtime) or after specified number of events occurs within rolling time
   * window.
   * Enum options - REALTIME, ROLLINGWINDOW, WATERMARK.
   * Default value when not specified in API or module is interpreted by Avi Controller as REALTIME.
   * @param category set the category.
   */
  public void setCategory(String  category) {
    this.category = category;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A custom description field.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * A custom description field.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable or disable this alert config from generating new alerts.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable or disable this alert config from generating new alerts.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * An alert is expired and deleted after the expiry time has elapsed.
   * The original event triggering the alert remains in the event's log.
   * Allowed values are 1-31536000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 86400.
   * @return expiryTime
   */
  public Integer getExpiryTime() {
    return expiryTime;
  }

  /**
   * This is the setter method to the attribute.
   * An alert is expired and deleted after the expiry time has elapsed.
   * The original event triggering the alert remains in the event's log.
   * Allowed values are 1-31536000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 86400.
   * @param expiryTime set the expiryTime.
   */
  public void setExpiryTime(Integer  expiryTime) {
    this.expiryTime = expiryTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the alert configuration.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the alert configuration.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the resource for which alert was raised.
   * @return objUuid
   */
  public String getObjUuid() {
    return objUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the resource for which alert was raised.
   * @param objUuid set the objUuid.
   */
  public void setObjUuid(String  objUuid) {
    this.objUuid = objUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The object type to which the alert config is associated with.
   * Valid object types are - virtual service, pool, service engine.
   * Enum options - VIRTUALSERVICE, POOL, HEALTHMONITOR, NETWORKPROFILE, APPLICATIONPROFILE, HTTPPOLICYSET, DNSPOLICY, SECURITYPOLICY, IPADDRGROUP,
   * STRINGGROUP, SSLPROFILE, SSLKEYANDCERTIFICATE, NETWORKSECURITYPOLICY, APPLICATIONPERSISTENCEPROFILE, ANALYTICSPROFILE, VSDATASCRIPTSET, TENANT,
   * PKIPROFILE, AUTHPROFILE, CLOUD...
   * @return objectType
   */
  public String getObjectType() {
    return objectType;
  }

  /**
   * This is the setter method to the attribute.
   * The object type to which the alert config is associated with.
   * Valid object types are - virtual service, pool, service engine.
   * Enum options - VIRTUALSERVICE, POOL, HEALTHMONITOR, NETWORKPROFILE, APPLICATIONPROFILE, HTTPPOLICYSET, DNSPOLICY, SECURITYPOLICY, IPADDRGROUP,
   * STRINGGROUP, SSLPROFILE, SSLKEYANDCERTIFICATE, NETWORKSECURITYPOLICY, APPLICATIONPERSISTENCEPROFILE, ANALYTICSPROFILE, VSDATASCRIPTSET, TENANT,
   * PKIPROFILE, AUTHPROFILE, CLOUD...
   * @param objectType set the objectType.
   */
  public void setObjectType(String  objectType) {
    this.objectType = objectType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property recommendation of obj type alertconfig field type str  type string.
   * @return recommendation
   */
  public String getRecommendation() {
    return recommendation;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property recommendation of obj type alertconfig field type str  type string.
   * @param recommendation set the recommendation.
   */
  public void setRecommendation(String  recommendation) {
    this.recommendation = recommendation;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Only if the number of events is reached or exceeded within the time window will an alert be generated.
   * Allowed values are 1-31536000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @return rollingWindow
   */
  public Integer getRollingWindow() {
    return rollingWindow;
  }

  /**
   * This is the setter method to the attribute.
   * Only if the number of events is reached or exceeded within the time window will an alert be generated.
   * Allowed values are 1-31536000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @param rollingWindow set the rollingWindow.
   */
  public void setRollingWindow(Integer  rollingWindow) {
    this.rollingWindow = rollingWindow;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Signifies system events or the type of client logsused in this alert configuration.
   * Enum options - CONN_LOGS, APP_LOGS, EVENT_LOGS, METRICS.
   * @return source
   */
  public String getSource() {
    return source;
  }

  /**
   * This is the setter method to the attribute.
   * Signifies system events or the type of client logsused in this alert configuration.
   * Enum options - CONN_LOGS, APP_LOGS, EVENT_LOGS, METRICS.
   * @param source set the source.
   */
  public void setSource(String  source) {
    this.source = source;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Summary of reason why alert is generated.
   * @return summary
   */
  public String getSummary() {
    return summary;
  }

  /**
   * This is the setter method to the attribute.
   * Summary of reason why alert is generated.
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
   * An alert is created only when the number of events meets or exceeds this number within the chosen time frame.
   * Allowed values are 1-65536.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return threshold
   */
  public Integer getThreshold() {
    return threshold;
  }

  /**
   * This is the setter method to the attribute.
   * An alert is created only when the number of events meets or exceeds this number within the chosen time frame.
   * Allowed values are 1-65536.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param threshold set the threshold.
   */
  public void setThreshold(Integer  threshold) {
    this.threshold = threshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Alerts are suppressed (throttled) for this duration of time since the last alert was raised for this alert config.
   * Allowed values are 0-31536000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600.
   * @return throttle
   */
  public Integer getThrottle() {
    return throttle;
  }

  /**
   * This is the setter method to the attribute.
   * Alerts are suppressed (throttled) for this duration of time since the last alert was raised for this alert config.
   * Allowed values are 0-31536000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600.
   * @param throttle set the throttle.
   */
  public void setThrottle(Integer  throttle) {
    this.throttle = throttle;
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
  AlertConfig objAlertConfig = (AlertConfig) o;
  return   Objects.equals(this.uuid, objAlertConfig.uuid)&&
  Objects.equals(this.name, objAlertConfig.name)&&
  Objects.equals(this.summary, objAlertConfig.summary)&&
  Objects.equals(this.description, objAlertConfig.description)&&
  Objects.equals(this.alertRule, objAlertConfig.alertRule)&&
  Objects.equals(this.threshold, objAlertConfig.threshold)&&
  Objects.equals(this.throttle, objAlertConfig.throttle)&&
  Objects.equals(this.rollingWindow, objAlertConfig.rollingWindow)&&
  Objects.equals(this.expiryTime, objAlertConfig.expiryTime)&&
  Objects.equals(this.source, objAlertConfig.source)&&
  Objects.equals(this.objUuid, objAlertConfig.objUuid)&&
  Objects.equals(this.category, objAlertConfig.category)&&
  Objects.equals(this.recommendation, objAlertConfig.recommendation)&&
  Objects.equals(this.enabled, objAlertConfig.enabled)&&
  Objects.equals(this.actionGroupRef, objAlertConfig.actionGroupRef)&&
  Objects.equals(this.autoscaleAlert, objAlertConfig.autoscaleAlert)&&
  Objects.equals(this.objectType, objAlertConfig.objectType)&&
  Objects.equals(this.tenantRef, objAlertConfig.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AlertConfig {\n");
      sb.append("    actionGroupRef: ").append(toIndentedString(actionGroupRef)).append("\n");
        sb.append("    alertRule: ").append(toIndentedString(alertRule)).append("\n");
        sb.append("    autoscaleAlert: ").append(toIndentedString(autoscaleAlert)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    expiryTime: ").append(toIndentedString(expiryTime)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    objUuid: ").append(toIndentedString(objUuid)).append("\n");
        sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
        sb.append("    recommendation: ").append(toIndentedString(recommendation)).append("\n");
        sb.append("    rollingWindow: ").append(toIndentedString(rollingWindow)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    threshold: ").append(toIndentedString(threshold)).append("\n");
        sb.append("    throttle: ").append(toIndentedString(throttle)).append("\n");
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

