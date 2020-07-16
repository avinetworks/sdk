package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The EventGenParams is a POJO class extends AviRestResource that used for creating
 * EventGenParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventGenParams  {
    @JsonProperty("cluster")
    private String cluster = null;

    @JsonProperty("events")
    private List<String> events = null;

    @JsonProperty("pool")
    private String pool = null;

    @JsonProperty("sslkeyandcertificate")
    private String sslkeyandcertificate = null;

    @JsonProperty("virtualservice")
    private String virtualservice = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cluster of obj type eventgenparams field type str  type string.
   * @return cluster
   */
  public String getCluster() {
    return cluster;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cluster of obj type eventgenparams field type str  type string.
   * @param cluster set the cluster.
   */
  public void setCluster(String  cluster) {
    this.cluster = cluster;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Enum options - VINFRA_DISC_DC, VINFRA_DISC_HOST, VINFRA_DISC_CLUSTER, VINFRA_DISC_VM, VINFRA_DISC_NW, MGMT_NW_NAME_CHANGED,
   * DISCOVERY_DATACENTER_DEL, VM_ADDED, VM_REMOVED, VINFRA_DISC_COMPLETE, VCENTER_ADDRESS_ERROR, SE_GROUP_CLUSTER_DEL, SE_GROUP_MGMT_NW_DEL,
   * MGMT_NW_DEL, VCENTER_BAD_CREDENTIALS, ESX_HOST_UNREACHABLE, SERVER_DELETED, SE_GROUP_HOST_DEL, VINFRA_DISC_FAILURE, ESX_HOST_POWERED_DOWN...
   * @return events
   */
  public List<String> getEvents() {
    return events;
  }

  /**
   * This is the setter method. this will set the events
   * Enum options - VINFRA_DISC_DC, VINFRA_DISC_HOST, VINFRA_DISC_CLUSTER, VINFRA_DISC_VM, VINFRA_DISC_NW, MGMT_NW_NAME_CHANGED,
   * DISCOVERY_DATACENTER_DEL, VM_ADDED, VM_REMOVED, VINFRA_DISC_COMPLETE, VCENTER_ADDRESS_ERROR, SE_GROUP_CLUSTER_DEL, SE_GROUP_MGMT_NW_DEL,
   * MGMT_NW_DEL, VCENTER_BAD_CREDENTIALS, ESX_HOST_UNREACHABLE, SERVER_DELETED, SE_GROUP_HOST_DEL, VINFRA_DISC_FAILURE, ESX_HOST_POWERED_DOWN...
   * @return events
   */
  public void setEvents(List<String>  events) {
    this.events = events;
  }

  /**
   * This is the setter method this will set the events
   * Enum options - VINFRA_DISC_DC, VINFRA_DISC_HOST, VINFRA_DISC_CLUSTER, VINFRA_DISC_VM, VINFRA_DISC_NW, MGMT_NW_NAME_CHANGED,
   * DISCOVERY_DATACENTER_DEL, VM_ADDED, VM_REMOVED, VINFRA_DISC_COMPLETE, VCENTER_ADDRESS_ERROR, SE_GROUP_CLUSTER_DEL, SE_GROUP_MGMT_NW_DEL,
   * MGMT_NW_DEL, VCENTER_BAD_CREDENTIALS, ESX_HOST_UNREACHABLE, SERVER_DELETED, SE_GROUP_HOST_DEL, VINFRA_DISC_FAILURE, ESX_HOST_POWERED_DOWN...
   * @return events
   */
  public EventGenParams addEventsItem(String eventsItem) {
    if (this.events == null) {
      this.events = new ArrayList<String>();
    }
    this.events.add(eventsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property pool of obj type eventgenparams field type str  type string.
   * @return pool
   */
  public String getPool() {
    return pool;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pool of obj type eventgenparams field type str  type string.
   * @param pool set the pool.
   */
  public void setPool(String  pool) {
    this.pool = pool;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property sslkeyandcertificate of obj type eventgenparams field type str  type string.
   * @return sslkeyandcertificate
   */
  public String getSslkeyandcertificate() {
    return sslkeyandcertificate;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property sslkeyandcertificate of obj type eventgenparams field type str  type string.
   * @param sslkeyandcertificate set the sslkeyandcertificate.
   */
  public void setSslkeyandcertificate(String  sslkeyandcertificate) {
    this.sslkeyandcertificate = sslkeyandcertificate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property virtualservice of obj type eventgenparams field type str  type string.
   * @return virtualservice
   */
  public String getVirtualservice() {
    return virtualservice;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property virtualservice of obj type eventgenparams field type str  type string.
   * @param virtualservice set the virtualservice.
   */
  public void setVirtualservice(String  virtualservice) {
    this.virtualservice = virtualservice;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  EventGenParams objEventGenParams = (EventGenParams) o;
  return   Objects.equals(this.cluster, objEventGenParams.cluster)&&
  Objects.equals(this.virtualservice, objEventGenParams.virtualservice)&&
  Objects.equals(this.events, objEventGenParams.events)&&
  Objects.equals(this.pool, objEventGenParams.pool)&&
  Objects.equals(this.sslkeyandcertificate, objEventGenParams.sslkeyandcertificate);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class EventGenParams {\n");
      sb.append("    cluster: ").append(toIndentedString(cluster)).append("\n");
        sb.append("    events: ").append(toIndentedString(events)).append("\n");
        sb.append("    pool: ").append(toIndentedString(pool)).append("\n");
        sb.append("    sslkeyandcertificate: ").append(toIndentedString(sslkeyandcertificate)).append("\n");
        sb.append("    virtualservice: ").append(toIndentedString(virtualservice)).append("\n");
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

