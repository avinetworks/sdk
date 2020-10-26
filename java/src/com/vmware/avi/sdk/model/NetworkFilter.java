package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The NetworkFilter is a POJO class extends AviRestResource that used for creating
 * NetworkFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkFilter  {
    @JsonProperty("network_ref")
    private String networkRef = null;

    @JsonProperty("server_filter")
    private String serverFilter = null;



    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type vimgrnwruntime.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return networkRef
     */
    public String getNetworkRef() {
        return networkRef;
    }

    /**
     * This is the setter method to the attribute.
     * It is a reference to an object of type vimgrnwruntime.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param networkRef set the networkRef.
     */
    public void setNetworkRef(String  networkRef) {
        this.networkRef = networkRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property server_filter of obj type networkfilter field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return serverFilter
     */
    public String getServerFilter() {
        return serverFilter;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property server_filter of obj type networkfilter field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param serverFilter set the serverFilter.
     */
    public void setServerFilter(String  serverFilter) {
        this.serverFilter = serverFilter;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      NetworkFilter objNetworkFilter = (NetworkFilter) o;
      return   Objects.equals(this.networkRef, objNetworkFilter.networkRef)&&
  Objects.equals(this.serverFilter, objNetworkFilter.serverFilter);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class NetworkFilter {\n");
                  sb.append("    networkRef: ").append(toIndentedString(networkRef)).append("\n");
                        sb.append("    serverFilter: ").append(toIndentedString(serverFilter)).append("\n");
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
