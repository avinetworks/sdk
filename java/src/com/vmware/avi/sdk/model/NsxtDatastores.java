package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The NsxtDatastores is a POJO class extends AviRestResource that used for creating
 * NsxtDatastores.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NsxtDatastores  {
    @JsonProperty("ds_ids")
    private List<String> dsIds = null;

    @JsonProperty("include")
    private Boolean include = false;


    /**
     * This is the getter method this will return the attribute value.
     * List of shared datastores.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return dsIds
     */
    public List<String> getDsIds() {
        return dsIds;
    }

    /**
     * This is the setter method. this will set the dsIds
     * List of shared datastores.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return dsIds
     */
    public void setDsIds(List<String>  dsIds) {
        this.dsIds = dsIds;
    }

    /**
     * This is the setter method this will set the dsIds
     * List of shared datastores.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return dsIds
     */
    public NsxtDatastores addDsIdsItem(String dsIdsItem) {
      if (this.dsIds == null) {
        this.dsIds = new ArrayList<String>();
      }
      this.dsIds.add(dsIdsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Include or exclude.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return include
     */
    public Boolean getInclude() {
        return include;
    }

    /**
     * This is the setter method to the attribute.
     * Include or exclude.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param include set the include.
     */
    public void setInclude(Boolean  include) {
        this.include = include;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      NsxtDatastores objNsxtDatastores = (NsxtDatastores) o;
      return   Objects.equals(this.dsIds, objNsxtDatastores.dsIds)&&
  Objects.equals(this.include, objNsxtDatastores.include);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class NsxtDatastores {\n");
                  sb.append("    dsIds: ").append(toIndentedString(dsIds)).append("\n");
                        sb.append("    include: ").append(toIndentedString(include)).append("\n");
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
