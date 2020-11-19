package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The VHMatch is a POJO class extends AviRestResource that used for creating
 * VHMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VHMatch  {
    @JsonProperty("host")
    private String host = null;

    @JsonProperty("path")
    private List<PathMatch> path = null;



    /**
     * This is the getter method this will return the attribute value.
     * Host/domain name match configuration.
     * Must be configured along with at least one path match criteria.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * This is the setter method to the attribute.
     * Host/domain name match configuration.
     * Must be configured along with at least one path match criteria.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param host set the host.
     */
    public void setHost(String  host) {
        this.host = host;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Resource/uri path match configuration.
     * Must be configured along with host match criteria.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return path
     */
    public List<PathMatch> getPath() {
        return path;
    }

    /**
     * This is the setter method. this will set the path
     * Resource/uri path match configuration.
     * Must be configured along with host match criteria.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return path
     */
    public void setPath(List<PathMatch>  path) {
        this.path = path;
    }

    /**
     * This is the setter method this will set the path
     * Resource/uri path match configuration.
     * Must be configured along with host match criteria.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return path
     */
    public VHMatch addPathItem(PathMatch pathItem) {
      if (this.path == null) {
        this.path = new ArrayList<PathMatch>();
      }
      this.path.add(pathItem);
      return this;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      VHMatch objVHMatch = (VHMatch) o;
      return   Objects.equals(this.host, objVHMatch.host)&&
  Objects.equals(this.path, objVHMatch.path);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class VHMatch {\n");
                  sb.append("    host: ").append(toIndentedString(host)).append("\n");
                        sb.append("    path: ").append(toIndentedString(path)).append("\n");
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
