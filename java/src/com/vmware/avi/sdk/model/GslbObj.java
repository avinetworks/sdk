package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbObj is a POJO class extends AviRestResource that used for creating
 * GslbObj.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbObj  {
    @JsonProperty("gslb_geo_db_profile_uuid")
    private String gslbGeoDbProfileUuid = null;

    @JsonProperty("gslb_service_uuid")
    private String gslbServiceUuid = null;

    @JsonProperty("gslb_uuid")
    private String gslbUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.1.5, 18.2.1.
   * @return gslbGeoDbProfileUuid
   */
  public String getGslbGeoDbProfileUuid() {
    return gslbGeoDbProfileUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.1.5, 18.2.1.
   * @param gslbGeoDbProfileUuid set the gslbGeoDbProfileUuid.
   */
  public void setGslbGeoDbProfileUuid(String  gslbGeoDbProfileUuid) {
    this.gslbGeoDbProfileUuid = gslbGeoDbProfileUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.1.5, 18.2.1.
   * @return gslbServiceUuid
   */
  public String getGslbServiceUuid() {
    return gslbServiceUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.1.5, 18.2.1.
   * @param gslbServiceUuid set the gslbServiceUuid.
   */
  public void setGslbServiceUuid(String  gslbServiceUuid) {
    this.gslbServiceUuid = gslbServiceUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.1.5, 18.2.1.
   * @return gslbUuid
   */
  public String getGslbUuid() {
    return gslbUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.1.5, 18.2.1.
   * @param gslbUuid set the gslbUuid.
   */
  public void setGslbUuid(String  gslbUuid) {
    this.gslbUuid = gslbUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbObj objGslbObj = (GslbObj) o;
  return   Objects.equals(this.gslbGeoDbProfileUuid, objGslbObj.gslbGeoDbProfileUuid)&&
  Objects.equals(this.gslbServiceUuid, objGslbObj.gslbServiceUuid)&&
  Objects.equals(this.gslbUuid, objGslbObj.gslbUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbObj {\n");
      sb.append("    gslbGeoDbProfileUuid: ").append(toIndentedString(gslbGeoDbProfileUuid)).append("\n");
        sb.append("    gslbServiceUuid: ").append(toIndentedString(gslbServiceUuid)).append("\n");
        sb.append("    gslbUuid: ").append(toIndentedString(gslbUuid)).append("\n");
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

