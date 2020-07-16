package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AWSASGNotifDetails is a POJO class extends AviRestResource that used for creating
 * AWSASGNotifDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AWSASGNotifDetails  {
    @JsonProperty("asg_name")
    private String asgName = null;

    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("error_string")
    private String errorString = null;

    @JsonProperty("event_type")
    private String eventType = null;

    @JsonProperty("instance_id")
    private String instanceId = null;

    @JsonProperty("instance_ip_addr")
    private IpAddr instanceIpAddr = null;

    @JsonProperty("pool_ref")
    private String poolRef = null;

    @JsonProperty("vpc_id")
    private String vpcId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property asg_name of obj type awsasgnotifdetails field type str  type string.
   * @return asgName
   */
  public String getAsgName() {
    return asgName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property asg_name of obj type awsasgnotifdetails field type str  type string.
   * @param asgName set the asgName.
   */
  public void setAsgName(String  asgName) {
    this.asgName = asgName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type awsasgnotifdetails field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type awsasgnotifdetails field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error_string of obj type awsasgnotifdetails field type str  type string.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error_string of obj type awsasgnotifdetails field type str  type string.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property event_type of obj type awsasgnotifdetails field type str  type string.
   * @return eventType
   */
  public String getEventType() {
    return eventType;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property event_type of obj type awsasgnotifdetails field type str  type string.
   * @param eventType set the eventType.
   */
  public void setEventType(String  eventType) {
    this.eventType = eventType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property instance_id of obj type awsasgnotifdetails field type str  type string.
   * @return instanceId
   */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property instance_id of obj type awsasgnotifdetails field type str  type string.
   * @param instanceId set the instanceId.
   */
  public void setInstanceId(String  instanceId) {
    this.instanceId = instanceId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property instance_ip_addr of obj type awsasgnotifdetails field type str  type ref.
   * @return instanceIpAddr
   */
  public IpAddr getInstanceIpAddr() {
    return instanceIpAddr;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property instance_ip_addr of obj type awsasgnotifdetails field type str  type ref.
   * @param instanceIpAddr set the instanceIpAddr.
   */
  public void setInstanceIpAddr(IpAddr instanceIpAddr) {
    this.instanceIpAddr = instanceIpAddr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the pool.
   * It is a reference to an object of type pool.
   * Field introduced in 17.2.3.
   * @return poolRef
   */
  public String getPoolRef() {
    return poolRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the pool.
   * It is a reference to an object of type pool.
   * Field introduced in 17.2.3.
   * @param poolRef set the poolRef.
   */
  public void setPoolRef(String  poolRef) {
    this.poolRef = poolRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vpc_id of obj type awsasgnotifdetails field type str  type string.
   * @return vpcId
   */
  public String getVpcId() {
    return vpcId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vpc_id of obj type awsasgnotifdetails field type str  type string.
   * @param vpcId set the vpcId.
   */
  public void setVpcId(String  vpcId) {
    this.vpcId = vpcId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AWSASGNotifDetails objAWSASGNotifDetails = (AWSASGNotifDetails) o;
  return   Objects.equals(this.eventType, objAWSASGNotifDetails.eventType)&&
  Objects.equals(this.errorString, objAWSASGNotifDetails.errorString)&&
  Objects.equals(this.asgName, objAWSASGNotifDetails.asgName)&&
  Objects.equals(this.poolRef, objAWSASGNotifDetails.poolRef)&&
  Objects.equals(this.instanceId, objAWSASGNotifDetails.instanceId)&&
  Objects.equals(this.instanceIpAddr, objAWSASGNotifDetails.instanceIpAddr)&&
  Objects.equals(this.vpcId, objAWSASGNotifDetails.vpcId)&&
  Objects.equals(this.ccId, objAWSASGNotifDetails.ccId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AWSASGNotifDetails {\n");
      sb.append("    asgName: ").append(toIndentedString(asgName)).append("\n");
        sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
        sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
        sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
        sb.append("    instanceIpAddr: ").append(toIndentedString(instanceIpAddr)).append("\n");
        sb.append("    poolRef: ").append(toIndentedString(poolRef)).append("\n");
        sb.append("    vpcId: ").append(toIndentedString(vpcId)).append("\n");
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

