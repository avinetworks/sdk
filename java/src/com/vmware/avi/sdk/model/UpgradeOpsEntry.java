package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The UpgradeOpsEntry is a POJO class extends AviRestResource that used for creating
 * UpgradeOpsEntry.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpgradeOpsEntry extends AviRestResource  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("node_type")
    private String nodeType = null;

    @JsonProperty("obj_cloud_ref")
    private String objCloudRef = null;

    @JsonProperty("params")
    private UpgradeOpsParam params = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("upgrade_info")
    private UpgradeStatusInfo upgradeInfo = null;

    @JsonProperty("upgrade_ops")
    private String upgradeOps = null;

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of the system such as cluster name, se group name and se name.
   * Field introduced in 18.2.6.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the system such as cluster name, se group name and se name.
   * Field introduced in 18.2.6.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Describes the system  controller or se-group or se.
   * Enum options - NODE_CONTROLLER_CLUSTER, NODE_SE_GROUP, NODE_SE_TYPE.
   * Field introduced in 18.2.6.
   * @return nodeType
   */
  public String getNodeType() {
    return nodeType;
  }

  /**
   * This is the setter method to the attribute.
   * Describes the system  controller or se-group or se.
   * Enum options - NODE_CONTROLLER_CLUSTER, NODE_SE_GROUP, NODE_SE_TYPE.
   * Field introduced in 18.2.6.
   * @param nodeType set the nodeType.
   */
  public void setNodeType(String  nodeType) {
    this.nodeType = nodeType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Cloud that this object belongs to.
   * It is a reference to an object of type cloud.
   * Field introduced in 18.2.6.
   * @return objCloudRef
   */
  public String getObjCloudRef() {
    return objCloudRef;
  }

  /**
   * This is the setter method to the attribute.
   * Cloud that this object belongs to.
   * It is a reference to an object of type cloud.
   * Field introduced in 18.2.6.
   * @param objCloudRef set the objCloudRef.
   */
  public void setObjCloudRef(String  objCloudRef) {
    this.objCloudRef = objCloudRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Parameters associated with the upgrade ops request.
   * Field introduced in 18.2.6.
   * @return params
   */
  public UpgradeOpsParam getParams() {
    return params;
  }

  /**
   * This is the setter method to the attribute.
   * Parameters associated with the upgrade ops request.
   * Field introduced in 18.2.6.
   * @param params set the params.
   */
  public void setParams(UpgradeOpsParam params) {
    this.params = params;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.6.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.6.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Current upgrade status info for this node.
   * Field introduced in 18.2.6.
   * @return upgradeInfo
   */
  public UpgradeStatusInfo getUpgradeInfo() {
    return upgradeInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Current upgrade status info for this node.
   * Field introduced in 18.2.6.
   * @param upgradeInfo set the upgradeInfo.
   */
  public void setUpgradeInfo(UpgradeStatusInfo upgradeInfo) {
    this.upgradeInfo = upgradeInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Identifies the upgrade operations.
   * Enum options - UPGRADE, PATCH, ROLLBACK, ROLLBACKPATCH, SEGROUP_RESUME.
   * Field introduced in 18.2.6.
   * @return upgradeOps
   */
  public String getUpgradeOps() {
    return upgradeOps;
  }

  /**
   * This is the setter method to the attribute.
   * Identifies the upgrade operations.
   * Enum options - UPGRADE, PATCH, ROLLBACK, ROLLBACKPATCH, SEGROUP_RESUME.
   * Field introduced in 18.2.6.
   * @param upgradeOps set the upgradeOps.
   */
  public void setUpgradeOps(String  upgradeOps) {
    this.upgradeOps = upgradeOps;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid identifier for the system such as cluster, se group and se.
   * Field introduced in 18.2.6.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid identifier for the system such as cluster, se group and se.
   * Field introduced in 18.2.6.
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
  UpgradeOpsEntry objUpgradeOpsEntry = (UpgradeOpsEntry) o;
  return   Objects.equals(this.uuid, objUpgradeOpsEntry.uuid)&&
  Objects.equals(this.upgradeOps, objUpgradeOpsEntry.upgradeOps)&&
  Objects.equals(this.nodeType, objUpgradeOpsEntry.nodeType)&&
  Objects.equals(this.objCloudRef, objUpgradeOpsEntry.objCloudRef)&&
  Objects.equals(this.params, objUpgradeOpsEntry.params)&&
  Objects.equals(this.upgradeInfo, objUpgradeOpsEntry.upgradeInfo)&&
  Objects.equals(this.tenantRef, objUpgradeOpsEntry.tenantRef)&&
  Objects.equals(this.name, objUpgradeOpsEntry.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class UpgradeOpsEntry {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
        sb.append("    objCloudRef: ").append(toIndentedString(objCloudRef)).append("\n");
        sb.append("    params: ").append(toIndentedString(params)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    upgradeInfo: ").append(toIndentedString(upgradeInfo)).append("\n");
        sb.append("    upgradeOps: ").append(toIndentedString(upgradeOps)).append("\n");
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

