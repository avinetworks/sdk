package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The LinuxServerHost is a POJO class extends AviRestResource that used for creating
 * LinuxServerHost.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinuxServerHost  {
    @JsonProperty("host_attr")
    private List<HostAttributes> hostAttr = null;

    @JsonProperty("host_ip")
    private IpAddr hostIp = null;

    @JsonProperty("node_availability_zone")
    private String nodeAvailabilityZone = null;

    @JsonProperty("se_group_ref")
    private String seGroupRef = null;


  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property host_attr of obj type linuxserverhost field type str  type array.
   * @return hostAttr
   */
  public List<HostAttributes> getHostAttr() {
    return hostAttr;
  }

  /**
   * This is the setter method. this will set the hostAttr
   * Placeholder for description of property host_attr of obj type linuxserverhost field type str  type array.
   * @return hostAttr
   */
  public void setHostAttr(List<HostAttributes>  hostAttr) {
    this.hostAttr = hostAttr;
  }

  /**
   * This is the setter method this will set the hostAttr
   * Placeholder for description of property host_attr of obj type linuxserverhost field type str  type array.
   * @return hostAttr
   */
  public LinuxServerHost addHostAttrItem(HostAttributes hostAttrItem) {
    if (this.hostAttr == null) {
      this.hostAttr = new ArrayList<HostAttributes>();
    }
    this.hostAttr.add(hostAttrItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property host_ip of obj type linuxserverhost field type str  type ref.
   * @return hostIp
   */
  public IpAddr getHostIp() {
    return hostIp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property host_ip of obj type linuxserverhost field type str  type ref.
   * @param hostIp set the hostIp.
   */
  public void setHostIp(IpAddr hostIp) {
    this.hostIp = hostIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Node's availability zone.
   * Serviceengines belonging to the availability zone will be rebooted during a manual dr failover.
   * @return nodeAvailabilityZone
   */
  public String getNodeAvailabilityZone() {
    return nodeAvailabilityZone;
  }

  /**
   * This is the setter method to the attribute.
   * Node's availability zone.
   * Serviceengines belonging to the availability zone will be rebooted during a manual dr failover.
   * @param nodeAvailabilityZone set the nodeAvailabilityZone.
   */
  public void setNodeAvailabilityZone(String  nodeAvailabilityZone) {
    this.nodeAvailabilityZone = nodeAvailabilityZone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The se group association for the se.
   * If none, then 'default-group' segroup is associated with the se.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 17.2.1.
   * @return seGroupRef
   */
  public String getSeGroupRef() {
    return seGroupRef;
  }

  /**
   * This is the setter method to the attribute.
   * The se group association for the se.
   * If none, then 'default-group' segroup is associated with the se.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 17.2.1.
   * @param seGroupRef set the seGroupRef.
   */
  public void setSeGroupRef(String  seGroupRef) {
    this.seGroupRef = seGroupRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  LinuxServerHost objLinuxServerHost = (LinuxServerHost) o;
  return   Objects.equals(this.hostAttr, objLinuxServerHost.hostAttr)&&
  Objects.equals(this.seGroupRef, objLinuxServerHost.seGroupRef)&&
  Objects.equals(this.hostIp, objLinuxServerHost.hostIp)&&
  Objects.equals(this.nodeAvailabilityZone, objLinuxServerHost.nodeAvailabilityZone);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class LinuxServerHost {\n");
      sb.append("    hostAttr: ").append(toIndentedString(hostAttr)).append("\n");
        sb.append("    hostIp: ").append(toIndentedString(hostIp)).append("\n");
        sb.append("    nodeAvailabilityZone: ").append(toIndentedString(nodeAvailabilityZone)).append("\n");
        sb.append("    seGroupRef: ").append(toIndentedString(seGroupRef)).append("\n");
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

