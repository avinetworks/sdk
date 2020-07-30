package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AWSASGDelete is a POJO class extends AviRestResource that used for creating
 * AWSASGDelete.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AWSASGDelete  {
    @JsonProperty("asgs")
    private List<String> asgs = null;

    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("pool_uuid")
    private String poolUuid = null;


  /**
   * This is the getter method this will return the attribute value.
   * List of autoscale groups deleted from aws.
   * Field introduced in 17.2.10,18.1.2.
   * @return asgs
   */
  public List<String> getAsgs() {
    return asgs;
  }

  /**
   * This is the setter method. this will set the asgs
   * List of autoscale groups deleted from aws.
   * Field introduced in 17.2.10,18.1.2.
   * @return asgs
   */
  public void setAsgs(List<String>  asgs) {
    this.asgs = asgs;
  }

  /**
   * This is the setter method this will set the asgs
   * List of autoscale groups deleted from aws.
   * Field introduced in 17.2.10,18.1.2.
   * @return asgs
   */
  public AWSASGDelete addAsgsItem(String asgsItem) {
    if (this.asgs == null) {
      this.asgs = new ArrayList<String>();
    }
    this.asgs.add(asgsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the cloud.
   * Field introduced in 17.2.10,18.1.2.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the cloud.
   * Field introduced in 17.2.10,18.1.2.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the pool.
   * Field introduced in 17.2.10,18.1.2.
   * @return poolUuid
   */
  public String getPoolUuid() {
    return poolUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the pool.
   * Field introduced in 17.2.10,18.1.2.
   * @param poolUuid set the poolUuid.
   */
  public void setPoolUuid(String  poolUuid) {
    this.poolUuid = poolUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AWSASGDelete objAWSASGDelete = (AWSASGDelete) o;
  return   Objects.equals(this.ccId, objAWSASGDelete.ccId)&&
  Objects.equals(this.asgs, objAWSASGDelete.asgs)&&
  Objects.equals(this.poolUuid, objAWSASGDelete.poolUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AWSASGDelete {\n");
      sb.append("    asgs: ").append(toIndentedString(asgs)).append("\n");
        sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    poolUuid: ").append(toIndentedString(poolUuid)).append("\n");
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

