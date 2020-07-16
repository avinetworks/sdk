package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AlertObjectList is a POJO class extends AviRestResource that used for creating
 * AlertObjectList.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertObjectList extends AviRestResource  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("objects")
    private List<String> objects = null;

    @JsonProperty("source")
    private String source = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



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
   * Enum options - VIRTUALSERVICE, POOL, HEALTHMONITOR, NETWORKPROFILE, APPLICATIONPROFILE, HTTPPOLICYSET, DNSPOLICY, SECURITYPOLICY, IPADDRGROUP,
   * STRINGGROUP, SSLPROFILE, SSLKEYANDCERTIFICATE, NETWORKSECURITYPOLICY, APPLICATIONPERSISTENCEPROFILE, ANALYTICSPROFILE, VSDATASCRIPTSET, TENANT,
   * PKIPROFILE, AUTHPROFILE, CLOUD...
   * @return objects
   */
  public List<String> getObjects() {
    return objects;
  }

  /**
   * This is the setter method. this will set the objects
   * Enum options - VIRTUALSERVICE, POOL, HEALTHMONITOR, NETWORKPROFILE, APPLICATIONPROFILE, HTTPPOLICYSET, DNSPOLICY, SECURITYPOLICY, IPADDRGROUP,
   * STRINGGROUP, SSLPROFILE, SSLKEYANDCERTIFICATE, NETWORKSECURITYPOLICY, APPLICATIONPERSISTENCEPROFILE, ANALYTICSPROFILE, VSDATASCRIPTSET, TENANT,
   * PKIPROFILE, AUTHPROFILE, CLOUD...
   * @return objects
   */
  public void setObjects(List<String>  objects) {
    this.objects = objects;
  }

  /**
   * This is the setter method this will set the objects
   * Enum options - VIRTUALSERVICE, POOL, HEALTHMONITOR, NETWORKPROFILE, APPLICATIONPROFILE, HTTPPOLICYSET, DNSPOLICY, SECURITYPOLICY, IPADDRGROUP,
   * STRINGGROUP, SSLPROFILE, SSLKEYANDCERTIFICATE, NETWORKSECURITYPOLICY, APPLICATIONPERSISTENCEPROFILE, ANALYTICSPROFILE, VSDATASCRIPTSET, TENANT,
   * PKIPROFILE, AUTHPROFILE, CLOUD...
   * @return objects
   */
  public AlertObjectList addObjectsItem(String objectsItem) {
    if (this.objects == null) {
      this.objects = new ArrayList<String>();
    }
    this.objects.add(objectsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - CONN_LOGS, APP_LOGS, EVENT_LOGS, METRICS.
   * @return source
   */
  public String getSource() {
    return source;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - CONN_LOGS, APP_LOGS, EVENT_LOGS, METRICS.
   * @param source set the source.
   */
  public void setSource(String  source) {
    this.source = source;
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
  AlertObjectList objAlertObjectList = (AlertObjectList) o;
  return   Objects.equals(this.uuid, objAlertObjectList.uuid)&&
  Objects.equals(this.source, objAlertObjectList.source)&&
  Objects.equals(this.objects, objAlertObjectList.objects)&&
  Objects.equals(this.tenantRef, objAlertObjectList.tenantRef)&&
  Objects.equals(this.name, objAlertObjectList.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AlertObjectList {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    objects: ").append(toIndentedString(objects)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
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

