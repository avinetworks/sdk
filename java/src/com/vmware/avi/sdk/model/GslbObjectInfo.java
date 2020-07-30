package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbObjectInfo is a POJO class extends AviRestResource that used for creating
 * GslbObjectInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbObjectInfo  {
    @JsonProperty("obj")
    private GslbObj obj = null;

    @JsonProperty("object_uuid")
    private String objectUuid = null;

    @JsonProperty("pb_name")
    private String pbName = null;

    @JsonProperty("state")
    private String state = null;



  /**
   * This is the getter method this will return the attribute value.
   * Indicates the object uuid.
   * Field introduced in 18.1.5, 18.2.1.
   * @return obj
   */
  public GslbObj getObj() {
    return obj;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates the object uuid.
   * Field introduced in 18.1.5, 18.2.1.
   * @param obj set the obj.
   */
  public void setObj(GslbObj obj) {
    this.obj = obj;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Indicates the object uuid.
   * Field introduced in 17.1.1.
   * @return objectUuid
   */
  public String getObjectUuid() {
    return objectUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates the object uuid.
   * Field introduced in 17.1.1.
   * @param objectUuid set the objectUuid.
   */
  public void setObjectUuid(String  objectUuid) {
    this.objectUuid = objectUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Indicates the object type gslb, gslbservice or gslbgeodbprofile.
   * Field introduced in 17.1.1.
   * @return pbName
   */
  public String getPbName() {
    return pbName;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates the object type gslb, gslbservice or gslbgeodbprofile.
   * Field introduced in 17.1.1.
   * @param pbName set the pbName.
   */
  public void setPbName(String  pbName) {
    this.pbName = pbName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Indicates the state of the object unchanged or changed.
   * This is used in vs-mgr to push just the uuid or uuid + protobuf to the se-agent.
   * Enum options - GSLB_OBJECT_CHANGED, GSLB_OBJECT_UNCHANGED, GSLB_OBJECT_DELETE.
   * Field introduced in 17.1.1.
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates the state of the object unchanged or changed.
   * This is used in vs-mgr to push just the uuid or uuid + protobuf to the se-agent.
   * Enum options - GSLB_OBJECT_CHANGED, GSLB_OBJECT_UNCHANGED, GSLB_OBJECT_DELETE.
   * Field introduced in 17.1.1.
   * @param state set the state.
   */
  public void setState(String  state) {
    this.state = state;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbObjectInfo objGslbObjectInfo = (GslbObjectInfo) o;
  return   Objects.equals(this.state, objGslbObjectInfo.state)&&
  Objects.equals(this.pbName, objGslbObjectInfo.pbName)&&
  Objects.equals(this.objectUuid, objGslbObjectInfo.objectUuid)&&
  Objects.equals(this.obj, objGslbObjectInfo.obj);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbObjectInfo {\n");
      sb.append("    obj: ").append(toIndentedString(obj)).append("\n");
        sb.append("    objectUuid: ").append(toIndentedString(objectUuid)).append("\n");
        sb.append("    pbName: ").append(toIndentedString(pbName)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

