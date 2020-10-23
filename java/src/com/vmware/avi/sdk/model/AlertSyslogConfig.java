package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The AlertSyslogConfig is a POJO class extends AviRestResource that used for creating
 * AlertSyslogConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertSyslogConfig extends AviRestResource  {
    @JsonProperty("description")
    private String description = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("syslog_servers")
    private List<AlertSyslogServer> syslogServers = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



    /**
     * This is the getter method this will return the attribute value.
     * User defined description for alert syslog config.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the setter method to the attribute.
     * User defined description for alert syslog config.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param description set the description.
     */
    public void setDescription(String  description) {
        this.description = description;
    }

    /**
     * This is the getter method this will return the attribute value.
     * A user-friendly name of the syslog notification.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * A user-friendly name of the syslog notification.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }
    /**
     * This is the getter method this will return the attribute value.
     * The list of syslog servers.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return syslogServers
     */
    public List<AlertSyslogServer> getSyslogServers() {
        return syslogServers;
    }

    /**
     * This is the setter method. this will set the syslogServers
     * The list of syslog servers.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return syslogServers
     */
    public void setSyslogServers(List<AlertSyslogServer>  syslogServers) {
        this.syslogServers = syslogServers;
    }

    /**
     * This is the setter method this will set the syslogServers
     * The list of syslog servers.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return syslogServers
     */
    public AlertSyslogConfig addSyslogServersItem(AlertSyslogServer syslogServersItem) {
      if (this.syslogServers == null) {
        this.syslogServers = new ArrayList<AlertSyslogServer>();
      }
      this.syslogServers.add(syslogServersItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRef
     */
    public String getTenantRef() {
        return tenantRef;
    }

    /**
     * This is the setter method to the attribute.
     * It is a reference to an object of type tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Unique object identifier of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
      AlertSyslogConfig objAlertSyslogConfig = (AlertSyslogConfig) o;
      return   Objects.equals(this.uuid, objAlertSyslogConfig.uuid)&&
  Objects.equals(this.name, objAlertSyslogConfig.name)&&
  Objects.equals(this.syslogServers, objAlertSyslogConfig.syslogServers)&&
  Objects.equals(this.description, objAlertSyslogConfig.description)&&
  Objects.equals(this.tenantRef, objAlertSyslogConfig.tenantRef);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AlertSyslogConfig {\n");
                  sb.append("    description: ").append(toIndentedString(description)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    syslogServers: ").append(toIndentedString(syslogServers)).append("\n");
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
