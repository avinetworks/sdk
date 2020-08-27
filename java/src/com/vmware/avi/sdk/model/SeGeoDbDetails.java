package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The SeGeoDbDetails is a POJO class extends AviRestResource that used for creating
 * SeGeoDbDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeGeoDbDetails  {
    @JsonProperty("file_name")
    private String fileName = null;

    @JsonProperty("geo_db_profile_name")
    private String geoDbProfileName = null;

    @JsonProperty("geo_db_profile_ref")
    private String geoDbProfileRef = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("se_ref")
    private String seRef = null;

    @JsonProperty("vip_id")
    private String vipId = null;

    @JsonProperty("virtual_service")
    private String virtualService = null;



    /**
     * This is the getter method this will return the attribute value.
     * Geo db file name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This is the setter method to the attribute.
     * Geo db file name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param fileName set the fileName.
     */
    public void setFileName(String  fileName) {
        this.fileName = fileName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the gslb geo db profile.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return geoDbProfileName
     */
    public String getGeoDbProfileName() {
        return geoDbProfileName;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the gslb geo db profile.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param geoDbProfileName set the geoDbProfileName.
     */
    public void setGeoDbProfileName(String  geoDbProfileName) {
        this.geoDbProfileName = geoDbProfileName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Uuid of the gslb geo db profile.
     * It is a reference to an object of type gslbgeodbprofile.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return geoDbProfileRef
     */
    public String getGeoDbProfileRef() {
        return geoDbProfileRef;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the gslb geo db profile.
     * It is a reference to an object of type gslbgeodbprofile.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param geoDbProfileRef set the geoDbProfileRef.
     */
    public void setGeoDbProfileRef(String  geoDbProfileRef) {
        this.geoDbProfileRef = geoDbProfileRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Reason for gslb geo db failure.
     * Enum options - NO_ERROR, FILE_ERROR, FILE_FORMAT_ERROR, FILE_NO_RESOURCES.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * This is the setter method to the attribute.
     * Reason for gslb geo db failure.
     * Enum options - NO_ERROR, FILE_ERROR, FILE_FORMAT_ERROR, FILE_NO_RESOURCES.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param reason set the reason.
     */
    public void setReason(String  reason) {
        this.reason = reason;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Uuid of the se responsible for this event.
     * It is a reference to an object of type serviceengine.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seRef
     */
    public String getSeRef() {
        return seRef;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the se responsible for this event.
     * It is a reference to an object of type serviceengine.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seRef set the seRef.
     */
    public void setSeRef(String  seRef) {
        this.seRef = seRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Vip id.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return vipId
     */
    public String getVipId() {
        return vipId;
    }

    /**
     * This is the setter method to the attribute.
     * Vip id.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param vipId set the vipId.
     */
    public void setVipId(String  vipId) {
        this.vipId = vipId;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Virtual service name.
     * It is a reference to an object of type virtualservice.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return virtualService
     */
    public String getVirtualService() {
        return virtualService;
    }

    /**
     * This is the setter method to the attribute.
     * Virtual service name.
     * It is a reference to an object of type virtualservice.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param virtualService set the virtualService.
     */
    public void setVirtualService(String  virtualService) {
        this.virtualService = virtualService;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      SeGeoDbDetails objSeGeoDbDetails = (SeGeoDbDetails) o;
      return   Objects.equals(this.seRef, objSeGeoDbDetails.seRef)&&
  Objects.equals(this.virtualService, objSeGeoDbDetails.virtualService)&&
  Objects.equals(this.reason, objSeGeoDbDetails.reason)&&
  Objects.equals(this.vipId, objSeGeoDbDetails.vipId)&&
  Objects.equals(this.geoDbProfileRef, objSeGeoDbDetails.geoDbProfileRef)&&
  Objects.equals(this.geoDbProfileName, objSeGeoDbDetails.geoDbProfileName)&&
  Objects.equals(this.fileName, objSeGeoDbDetails.fileName);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SeGeoDbDetails {\n");
                  sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
                        sb.append("    geoDbProfileName: ").append(toIndentedString(geoDbProfileName)).append("\n");
                        sb.append("    geoDbProfileRef: ").append(toIndentedString(geoDbProfileRef)).append("\n");
                        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
                        sb.append("    seRef: ").append(toIndentedString(seRef)).append("\n");
                        sb.append("    vipId: ").append(toIndentedString(vipId)).append("\n");
                        sb.append("    virtualService: ").append(toIndentedString(virtualService)).append("\n");
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
