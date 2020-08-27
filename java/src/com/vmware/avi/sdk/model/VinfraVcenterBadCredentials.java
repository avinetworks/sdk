package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The VinfraVcenterBadCredentials is a POJO class extends AviRestResource that used for creating
 * VinfraVcenterBadCredentials.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VinfraVcenterBadCredentials  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("previous_count")
    private Integer previousCount = null;

    @JsonProperty("user")
    private String user = null;

    @JsonProperty("vcenter")
    private String vcenter = null;

    @JsonProperty("vcenter_name")
    private String vcenterName = null;

    @JsonProperty("vcenter_object")
    private String vcenterObject = null;



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
     * Placeholder for description of property previous_count of obj type vinfravcenterbadcredentials field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return previousCount
     */
    public Integer getPreviousCount() {
        return previousCount;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property previous_count of obj type vinfravcenterbadcredentials field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param previousCount set the previousCount.
     */
    public void setPreviousCount(Integer  previousCount) {
        this.previousCount = previousCount;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property user of obj type vinfravcenterbadcredentials field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property user of obj type vinfravcenterbadcredentials field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param user set the user.
     */
    public void setUser(String  user) {
        this.user = user;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property vcenter of obj type vinfravcenterbadcredentials field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return vcenter
     */
    public String getVcenter() {
        return vcenter;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property vcenter of obj type vinfravcenterbadcredentials field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param vcenter set the vcenter.
     */
    public void setVcenter(String  vcenter) {
        this.vcenter = vcenter;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property vcenter_name of obj type vinfravcenterbadcredentials field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return vcenterName
     */
    public String getVcenterName() {
        return vcenterName;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property vcenter_name of obj type vinfravcenterbadcredentials field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param vcenterName set the vcenterName.
     */
    public void setVcenterName(String  vcenterName) {
        this.vcenterName = vcenterName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property vcenter_object of obj type vinfravcenterbadcredentials field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return vcenterObject
     */
    public String getVcenterObject() {
        return vcenterObject;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property vcenter_object of obj type vinfravcenterbadcredentials field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param vcenterObject set the vcenterObject.
     */
    public void setVcenterObject(String  vcenterObject) {
        this.vcenterObject = vcenterObject;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      VinfraVcenterBadCredentials objVinfraVcenterBadCredentials = (VinfraVcenterBadCredentials) o;
      return   Objects.equals(this.vcenter, objVinfraVcenterBadCredentials.vcenter)&&
  Objects.equals(this.name, objVinfraVcenterBadCredentials.name)&&
  Objects.equals(this.vcenterName, objVinfraVcenterBadCredentials.vcenterName)&&
  Objects.equals(this.user, objVinfraVcenterBadCredentials.user)&&
  Objects.equals(this.vcenterObject, objVinfraVcenterBadCredentials.vcenterObject)&&
  Objects.equals(this.previousCount, objVinfraVcenterBadCredentials.previousCount);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VinfraVcenterBadCredentials {\n");
                  sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    previousCount: ").append(toIndentedString(previousCount)).append("\n");
                        sb.append("    user: ").append(toIndentedString(user)).append("\n");
                        sb.append("    vcenter: ").append(toIndentedString(vcenter)).append("\n");
                        sb.append("    vcenterName: ").append(toIndentedString(vcenterName)).append("\n");
                        sb.append("    vcenterObject: ").append(toIndentedString(vcenterObject)).append("\n");
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
