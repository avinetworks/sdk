package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ClusterLeaderFailoverEvent is a POJO class extends AviRestResource that used for creating
 * ClusterLeaderFailoverEvent.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterLeaderFailoverEvent  {
    @JsonProperty("leader_node")
    private ClusterNode leaderNode = null;

    @JsonProperty("previous_leader_node")
    private ClusterNode previousLeaderNode = null;



  /**
   * This is the getter method this will return the attribute value.
   * Details of the new controller cluster leader node.
   * @return leaderNode
   */
  public ClusterNode getLeaderNode() {
    return leaderNode;
  }

  /**
   * This is the setter method to the attribute.
   * Details of the new controller cluster leader node.
   * @param leaderNode set the leaderNode.
   */
  public void setLeaderNode(ClusterNode leaderNode) {
    this.leaderNode = leaderNode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Details of the previous controller cluster leader.
   * @return previousLeaderNode
   */
  public ClusterNode getPreviousLeaderNode() {
    return previousLeaderNode;
  }

  /**
   * This is the setter method to the attribute.
   * Details of the previous controller cluster leader.
   * @param previousLeaderNode set the previousLeaderNode.
   */
  public void setPreviousLeaderNode(ClusterNode previousLeaderNode) {
    this.previousLeaderNode = previousLeaderNode;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ClusterLeaderFailoverEvent objClusterLeaderFailoverEvent = (ClusterLeaderFailoverEvent) o;
  return   Objects.equals(this.leaderNode, objClusterLeaderFailoverEvent.leaderNode)&&
  Objects.equals(this.previousLeaderNode, objClusterLeaderFailoverEvent.previousLeaderNode);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ClusterLeaderFailoverEvent {\n");
      sb.append("    leaderNode: ").append(toIndentedString(leaderNode)).append("\n");
        sb.append("    previousLeaderNode: ").append(toIndentedString(previousLeaderNode)).append("\n");
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

