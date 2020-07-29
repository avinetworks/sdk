package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Cluster is a POJO class extends AviRestResource that used for creating
 * Cluster.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cluster extends AviRestResource  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("nodes")
    private List<ClusterNode> nodes = null;

    @JsonProperty("rejoin_nodes_automatically")
    private Boolean rejoinNodesAutomatically = true;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("virtual_ip")
    private IpAddr virtualIp = null;



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
   * Placeholder for description of property nodes of obj type cluster field type str  type array.
   * @return nodes
   */
  public List<ClusterNode> getNodes() {
    return nodes;
  }

  /**
   * This is the setter method. this will set the nodes
   * Placeholder for description of property nodes of obj type cluster field type str  type array.
   * @return nodes
   */
  public void setNodes(List<ClusterNode>  nodes) {
    this.nodes = nodes;
  }

  /**
   * This is the setter method this will set the nodes
   * Placeholder for description of property nodes of obj type cluster field type str  type array.
   * @return nodes
   */
  public Cluster addNodesItem(ClusterNode nodesItem) {
    if (this.nodes == null) {
      this.nodes = new ArrayList<ClusterNode>();
    }
    this.nodes.add(nodesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Re-join cluster nodes automatically in the event one of the node is reset to factory.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return rejoinNodesAutomatically
   */
  public Boolean getRejoinNodesAutomatically() {
    return rejoinNodesAutomatically;
  }

  /**
   * This is the setter method to the attribute.
   * Re-join cluster nodes automatically in the event one of the node is reset to factory.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param rejoinNodesAutomatically set the rejoinNodesAutomatically.
   */
  public void setRejoinNodesAutomatically(Boolean  rejoinNodesAutomatically) {
    this.rejoinNodesAutomatically = rejoinNodesAutomatically;
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

  /**
   * This is the getter method this will return the attribute value.
   * A virtual ip address.
   * This ip address will be dynamically reconfigured so that it always is the ip of the cluster leader.
   * @return virtualIp
   */
  public IpAddr getVirtualIp() {
    return virtualIp;
  }

  /**
   * This is the setter method to the attribute.
   * A virtual ip address.
   * This ip address will be dynamically reconfigured so that it always is the ip of the cluster leader.
   * @param virtualIp set the virtualIp.
   */
  public void setVirtualIp(IpAddr virtualIp) {
    this.virtualIp = virtualIp;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Cluster objCluster = (Cluster) o;
  return   Objects.equals(this.uuid, objCluster.uuid)&&
  Objects.equals(this.name, objCluster.name)&&
  Objects.equals(this.virtualIp, objCluster.virtualIp)&&
  Objects.equals(this.nodes, objCluster.nodes)&&
  Objects.equals(this.rejoinNodesAutomatically, objCluster.rejoinNodesAutomatically)&&
  Objects.equals(this.tenantRef, objCluster.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Cluster {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
        sb.append("    rejoinNodesAutomatically: ").append(toIndentedString(rejoinNodesAutomatically)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    virtualIp: ").append(toIndentedString(virtualIp)).append("\n");
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

