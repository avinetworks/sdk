package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ActionGroupConfig is a POJO class extends AviRestResource that used for creating
 * ActionGroupConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActionGroupConfig extends AviRestResource  {
    @JsonProperty("action_script_config_ref")
    private String actionScriptConfigRef = null;

    @JsonProperty("autoscale_trigger_notification")
    private Boolean autoscaleTriggerNotification = false;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("email_config_ref")
    private String emailConfigRef = null;

    @JsonProperty("external_only")
    private Boolean externalOnly = false;

    @JsonProperty("level")
    private String level = "ALERT_LOW";

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("snmp_trap_profile_ref")
    private String snmpTrapProfileRef = null;

    @JsonProperty("syslog_config_ref")
    private String syslogConfigRef = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Reference of the action script configuration to be used.
   * It is a reference to an object of type alertscriptconfig.
   * @return actionScriptConfigRef
   */
  public String getActionScriptConfigRef() {
    return actionScriptConfigRef;
  }

  /**
   * This is the setter method to the attribute.
   * Reference of the action script configuration to be used.
   * It is a reference to an object of type alertscriptconfig.
   * @param actionScriptConfigRef set the actionScriptConfigRef.
   */
  public void setActionScriptConfigRef(String  actionScriptConfigRef) {
    this.actionScriptConfigRef = actionScriptConfigRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Trigger notification to autoscale manager.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return autoscaleTriggerNotification
   */
  public Boolean getAutoscaleTriggerNotification() {
    return autoscaleTriggerNotification;
  }

  /**
   * This is the setter method to the attribute.
   * Trigger notification to autoscale manager.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param autoscaleTriggerNotification set the autoscaleTriggerNotification.
   */
  public void setAutoscaleTriggerNotification(Boolean  autoscaleTriggerNotification) {
    this.autoscaleTriggerNotification = autoscaleTriggerNotification;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User defined description for the object.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * User defined description for the object.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Select the email notification configuration to use when sending alerts via email.
   * It is a reference to an object of type alertemailconfig.
   * @return emailConfigRef
   */
  public String getEmailConfigRef() {
    return emailConfigRef;
  }

  /**
   * This is the setter method to the attribute.
   * Select the email notification configuration to use when sending alerts via email.
   * It is a reference to an object of type alertemailconfig.
   * @param emailConfigRef set the emailConfigRef.
   */
  public void setEmailConfigRef(String  emailConfigRef) {
    this.emailConfigRef = emailConfigRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Generate alert only to external destinations.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return externalOnly
   */
  public Boolean getExternalOnly() {
    return externalOnly;
  }

  /**
   * This is the setter method to the attribute.
   * Generate alert only to external destinations.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param externalOnly set the externalOnly.
   */
  public void setExternalOnly(Boolean  externalOnly) {
    this.externalOnly = externalOnly;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When an alert is generated, mark its priority via the alert level.
   * Enum options - ALERT_LOW, ALERT_MEDIUM, ALERT_HIGH.
   * Default value when not specified in API or module is interpreted by Avi Controller as ALERT_LOW.
   * @return level
   */
  public String getLevel() {
    return level;
  }

  /**
   * This is the setter method to the attribute.
   * When an alert is generated, mark its priority via the alert level.
   * Enum options - ALERT_LOW, ALERT_MEDIUM, ALERT_HIGH.
   * Default value when not specified in API or module is interpreted by Avi Controller as ALERT_LOW.
   * @param level set the level.
   */
  public void setLevel(String  level) {
    this.level = level;
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
   * Select the snmp trap notification to use when sending alerts via snmp trap.
   * It is a reference to an object of type snmptrapprofile.
   * @return snmpTrapProfileRef
   */
  public String getSnmpTrapProfileRef() {
    return snmpTrapProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Select the snmp trap notification to use when sending alerts via snmp trap.
   * It is a reference to an object of type snmptrapprofile.
   * @param snmpTrapProfileRef set the snmpTrapProfileRef.
   */
  public void setSnmpTrapProfileRef(String  snmpTrapProfileRef) {
    this.snmpTrapProfileRef = snmpTrapProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Select the syslog notification configuration to use when sending alerts via syslog.
   * It is a reference to an object of type alertsyslogconfig.
   * @return syslogConfigRef
   */
  public String getSyslogConfigRef() {
    return syslogConfigRef;
  }

  /**
   * This is the setter method to the attribute.
   * Select the syslog notification configuration to use when sending alerts via syslog.
   * It is a reference to an object of type alertsyslogconfig.
   * @param syslogConfigRef set the syslogConfigRef.
   */
  public void setSyslogConfigRef(String  syslogConfigRef) {
    this.syslogConfigRef = syslogConfigRef;
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
  ActionGroupConfig objActionGroupConfig = (ActionGroupConfig) o;
  return   Objects.equals(this.uuid, objActionGroupConfig.uuid)&&
  Objects.equals(this.name, objActionGroupConfig.name)&&
  Objects.equals(this.emailConfigRef, objActionGroupConfig.emailConfigRef)&&
  Objects.equals(this.syslogConfigRef, objActionGroupConfig.syslogConfigRef)&&
  Objects.equals(this.actionScriptConfigRef, objActionGroupConfig.actionScriptConfigRef)&&
  Objects.equals(this.externalOnly, objActionGroupConfig.externalOnly)&&
  Objects.equals(this.snmpTrapProfileRef, objActionGroupConfig.snmpTrapProfileRef)&&
  Objects.equals(this.autoscaleTriggerNotification, objActionGroupConfig.autoscaleTriggerNotification)&&
  Objects.equals(this.level, objActionGroupConfig.level)&&
  Objects.equals(this.description, objActionGroupConfig.description)&&
  Objects.equals(this.tenantRef, objActionGroupConfig.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ActionGroupConfig {\n");
      sb.append("    actionScriptConfigRef: ").append(toIndentedString(actionScriptConfigRef)).append("\n");
        sb.append("    autoscaleTriggerNotification: ").append(toIndentedString(autoscaleTriggerNotification)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    emailConfigRef: ").append(toIndentedString(emailConfigRef)).append("\n");
        sb.append("    externalOnly: ").append(toIndentedString(externalOnly)).append("\n");
        sb.append("    level: ").append(toIndentedString(level)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    snmpTrapProfileRef: ").append(toIndentedString(snmpTrapProfileRef)).append("\n");
        sb.append("    syslogConfigRef: ").append(toIndentedString(syslogConfigRef)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
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

