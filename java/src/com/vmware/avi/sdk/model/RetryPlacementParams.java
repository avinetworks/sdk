package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RetryPlacementParams is a POJO class extends AviRestResource that used for creating
 * RetryPlacementParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetryPlacementParams extends AviRestResource  {
    @JsonProperty("all_east_west")
    private Boolean allEastWest = false;

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vip_id")
    private String vipId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Retry placement operations for all east-west services.
   * Field introduced in 17.1.6,17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allEastWest
   */
  public Boolean getAllEastWest() {
    return allEastWest;
  }

  /**
   * This is the setter method to the attribute.
   * Retry placement operations for all east-west services.
   * Field introduced in 17.1.6,17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allEastWest set the allEastWest.
   */
  public void setAllEastWest(Boolean  allEastWest) {
    this.allEastWest = allEastWest;
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
   * Indicates the vip_id that needs placement retrial.
   * Field introduced in 17.1.2.
   * @return vipId
   */
  public String getVipId() {
    return vipId;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates the vip_id that needs placement retrial.
   * Field introduced in 17.1.2.
   * @param vipId set the vipId.
   */
  public void setVipId(String  vipId) {
    this.vipId = vipId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  RetryPlacementParams objRetryPlacementParams = (RetryPlacementParams) o;
  return   Objects.equals(this.uuid, objRetryPlacementParams.uuid)&&
  Objects.equals(this.vipId, objRetryPlacementParams.vipId)&&
  Objects.equals(this.allEastWest, objRetryPlacementParams.allEastWest);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RetryPlacementParams {\n");
      sb.append("    allEastWest: ").append(toIndentedString(allEastWest)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vipId: ").append(toIndentedString(vipId)).append("\n");
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

