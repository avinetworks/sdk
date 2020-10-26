package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The GslbStatus is a POJO class extends AviRestResource that used for creating
 * GslbStatus.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbStatus extends AviRestResource  {
    @JsonProperty("details")
    private List<String> details = null;

    @JsonProperty("gslb_runtime")
    private GslbRuntime gslbRuntime = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("site")
    private GslbSiteRuntime site = null;

    @JsonProperty("third_party_site")
    private GslbThirdPartySiteRuntime thirdPartySite = null;

    @JsonProperty("uuid")
    private String uuid = null;


    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property details of obj type gslbstatus field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return details
     */
    public List<String> getDetails() {
        return details;
    }

    /**
     * This is the setter method. this will set the details
     * Placeholder for description of property details of obj type gslbstatus field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return details
     */
    public void setDetails(List<String>  details) {
        this.details = details;
    }

    /**
     * This is the setter method this will set the details
     * Placeholder for description of property details of obj type gslbstatus field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return details
     */
    public GslbStatus addDetailsItem(String detailsItem) {
      if (this.details == null) {
        this.details = new ArrayList<String>();
      }
      this.details.add(detailsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property gslb_runtime of obj type gslbstatus field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return gslbRuntime
     */
    public GslbRuntime getGslbRuntime() {
        return gslbRuntime;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property gslb_runtime of obj type gslbstatus field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param gslbRuntime set the gslbRuntime.
     */
    public void setGslbRuntime(GslbRuntime gslbRuntime) {
        this.gslbRuntime = gslbRuntime;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return site
     */
    public GslbSiteRuntime getSite() {
        return site;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param site set the site.
     */
    public void setSite(GslbSiteRuntime site) {
        this.site = site;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return thirdPartySite
     */
    public GslbThirdPartySiteRuntime getThirdPartySite() {
        return thirdPartySite;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param thirdPartySite set the thirdPartySite.
     */
    public void setThirdPartySite(GslbThirdPartySiteRuntime thirdPartySite) {
        this.thirdPartySite = thirdPartySite;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Unique object identifier of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Unique object identifier of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
      GslbStatus objGslbStatus = (GslbStatus) o;
      return   Objects.equals(this.uuid, objGslbStatus.uuid)&&
  Objects.equals(this.name, objGslbStatus.name)&&
  Objects.equals(this.details, objGslbStatus.details)&&
  Objects.equals(this.gslbRuntime, objGslbStatus.gslbRuntime)&&
  Objects.equals(this.site, objGslbStatus.site)&&
  Objects.equals(this.thirdPartySite, objGslbStatus.thirdPartySite);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class GslbStatus {\n");
                  sb.append("    details: ").append(toIndentedString(details)).append("\n");
                        sb.append("    gslbRuntime: ").append(toIndentedString(gslbRuntime)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    site: ").append(toIndentedString(site)).append("\n");
                        sb.append("    thirdPartySite: ").append(toIndentedString(thirdPartySite)).append("\n");
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
